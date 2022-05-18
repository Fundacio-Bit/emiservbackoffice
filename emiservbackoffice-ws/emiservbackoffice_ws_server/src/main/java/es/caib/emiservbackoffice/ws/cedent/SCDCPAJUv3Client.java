package es.caib.emiservbackoffice.ws.cedent;

import es.caib.emiserv.logic.intf.service.ws.backoffice.DatosGenericos;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Estado;
import es.caib.emiserv.logic.intf.service.ws.backoffice.TipoDocumentacion;
import es.caib.emiservbackoffice.ws.scsp.SCDCPAJUv3PeticionDatosEspecificos;
import es.caib.emiservbackoffice.ws.scsp.SCDCPAJUv3RespuestaDatosEspecificos;
import es.caib.emiservbackoffice.ws.specs.ErrorBackoffice;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.api.ScdcpajUv3Api;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Resultado;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.ParserConfigurationException;
import org.fundaciobit.pluginsib.utils.xml.XmlManager;
import org.springframework.util.Base64Utils;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import org.fundaciobit.pluginsib.utils.commons.GregorianCalendars;
import org.springframework.web.client.HttpServerErrorException;

/**
 *
 * @author gdeignacio
 */
public class SCDCPAJUv3Client extends CedentClient {
    
    
    protected es.caib.emiservbackoffice.ws.scsp.SCDCPAJUv3PeticionDatosEspecificos pde;
        
    protected es.caib.emiservbackoffice.ws.scsp.SCDCPAJUv3RespuestaDatosEspecificos rde;
    
    public SCDCPAJUv3Client(DatosGenericos datosGenericos, Element peticionDatosEspecificos, Propietats propietats) {
        super(datosGenericos, peticionDatosEspecificos, propietats);
    }

    private void setDatosPeticion() throws JAXBException, IOException{
        
        
        NamedNodeMap attrs = peticionDatosEspecificos.getAttributes();
        
        while (attrs.getLength() > 0) {
            attrs.removeNamedItem(attrs.item(0).getNodeName());
        }
        
        //peticionDatosEspecificos.setAttribute(XMLConstants.XMLNS_ATTRIBUTE.concat(":ns2"), EMISERV_BACKOFFICE_XMLNS);
       
        
        
        XmlManager<SCDCPAJUv3PeticionDatosEspecificos> manager
                = new XmlManager<SCDCPAJUv3PeticionDatosEspecificos>(SCDCPAJUv3PeticionDatosEspecificos.class);
        pde = manager.generateItem(peticionDatosEspecificos, false, true);

        log.info("SCDCPAJUv3Client :: Datos Especificos Peticion: " +  ((pde!=null)?pde.toString():""));

    }
    
    
    private void setDatosRespuesta() throws JAXBException, ParserConfigurationException{
        
        XmlManager<SCDCPAJUv3RespuestaDatosEspecificos> manager
                = new XmlManager<SCDCPAJUv3RespuestaDatosEspecificos>(SCDCPAJUv3RespuestaDatosEspecificos.class);
        
        XmlSchema xmlSchemaAnnotation = manager.getXmlSchemaAnnotation();

        log.info("SCDCPAJUv3Client :: Datos Especificos NAMESPACE: " + ((xmlSchemaAnnotation!=null)?xmlSchemaAnnotation.namespace():"No xmlSchemaAnnotation"));
        log.info("SCDCPAJUv3Client :: Datos Especificos LOCATION: " + ((xmlSchemaAnnotation!=null)?xmlSchemaAnnotation.location():"No xmlSchemaAnnotation"));

        XmlRootElement xmlRootElementAnnotation = manager.getXmlRootElementAnnotation();

        log.info("SCDCPAJUv3Client :: Datos Especificos XmlRoot NAMESPACE: " + ((xmlRootElementAnnotation!=null)?xmlRootElementAnnotation.namespace():"No xmlRootElementAnnotation"));
        log.info("SCDCPAJUv3Client :: Datos Especificos XmlRoot LOCATION: " + ((xmlRootElementAnnotation!=null)?xmlRootElementAnnotation.name():"No xmlRootElementAnnotation"));

        respuestaDatosEspecificos = manager.generateElement(rde);
        
        respuestaDatosEspecificos.setAttribute(XMLConstants.XMLNS_ATTRIBUTE.concat(":ns2"), EMISERV_BACKOFFICE_XMLNS);
        
    }
    
    
    private Resultado getResultado(Solicitud solicitud){
        
        log.info("SCDCPAJUv3Client :: Iniciant client ");   
        
        ScdcpajUv3Api api = new ScdcpajUv3Api();
         
        api.getApiClient().setBasePath(propietats.getEndpoint());
         
        api.getApiClient().setDebugging(true);
         
        String usuari = propietats.getUsuari();
        String secret = propietats.getSecret();
        
        String userpass = usuari.concat(":").concat(secret);
         
        api.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString(userpass.getBytes(StandardCharsets.UTF_8)));
        
        Resultado response = null;
        
        /*
        try {
            response = api.peticionSincrona(solicitud);
        } catch (HttpServerErrorException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        return response;
    }
    
    
    
    private es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Resultado adaptaResultado(es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Resultado res) {

        if (res == null) {
            return null;
        }

        es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Resultado resultado = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Resultado();

        // Set fechaExpedicion 
        resultado.setFechaExpedicion(res.getFechaExpedicion());

        // Set ClaveHojaPadronal 
        es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.ClaveHojaPadronal chp = res.getClaveHojaPadronal();

        if (chp != null) {
            es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.ClaveHojaPadronal claveHojaPadronal = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.ClaveHojaPadronal();
            claveHojaPadronal.setDistrito(chp.getDistrito());
            claveHojaPadronal.setSeccion(chp.getSeccion());
            claveHojaPadronal.setHoja(chp.getHoja());
            resultado.setClaveHojaPadronal(claveHojaPadronal);
        }

        // Set Domicilio
        es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Domicilio dom = res.getDomicilio();

        if (dom != null) {
            es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Domicilio domicilio = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Domicilio();
            domicilio.setBloque(dom.getBloque());
            domicilio.setCodPostal(dom.getCodPostal());
            domicilio.setEscalera(dom.getEscalera());
            domicilio.setHmt(dom.getHmt());
            domicilio.setKmt(dom.getKmt());

            // Set numero   
            es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Numero num = dom.getNumero();

            if (num != null) {
                es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Numero numero = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Numero();
                numero.setCalificador(num.getCalificador());
                numero.setValor(num.getValor());
                domicilio.setNumero(numero);
            }

            // Set numero superior   
            es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.NumeroSuperior numsup = dom.getNumeroSuperior();
            if (numsup != null) {
                es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.NumeroSuperior numeroSuperior = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.NumeroSuperior();
                numeroSuperior.setCalificador(numsup.getCalificador());
                numeroSuperior.setValor(numsup.getValor());
                domicilio.setNumeroSuperior(numeroSuperior);
            }

            domicilio.setPlanta(dom.getPlanta());
            domicilio.setPortal(dom.getPortal());
            domicilio.setPuerta(dom.getPuerta());

            // Set via   
            es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Via va  = dom.getVia();
            if (va != null) {
                es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Via via = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Via();
                via.setCodigo(va.getCodigo());
                via.setNombre(va.getNombre());
                via.setTipo(va.getTipo());
                domicilio.setVia(via);
            }
            resultado.setDomicilio(domicilio);
        }

        // Set personas
        es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Personas prs = res.getPersonas();
        if (prs != null) {
            es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Personas personas = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Personas();

            List<es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Persona> lPrs = prs.getDomicilio();

            if (lPrs != null) {

                for (es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Persona per : lPrs) {

                    if (per != null) {

                        es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Persona persona = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Persona();
                        persona.setApellido1(per.getApellido1());
                        persona.setApellido2(per.getApellido2());
                        persona.setNIA(per.getNia());
                        persona.setNombre(per.getNombre());
                        persona.setParticula1(per.getParticula1());
                        persona.setParticula2(per.getParticula2());

                        // set Documentacion
                        es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Documentacion doc = per.getDocumentacion();
                        if (doc != null) {
                            es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Documentacion documentacion = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Documentacion();
                            es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Documentacion.TipoEnum tipo = doc.getTipo();
                            if (tipo != null) {
                                documentacion.setTipo(tipo.getValue());
                            }
                            documentacion.setValor(doc.getValor());
                            persona.setDocumentacion(documentacion);
                        }

                        // Set periodo inscripcion
                        es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.PeriodoInscripcion pin = per.getPeriodoInscripcion();
                        if (pin != null) {
                            es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.PeriodoInscripcion periodoInscripcion = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.PeriodoInscripcion();
                            periodoInscripcion.setDesde(pin.getDesde());

                            // Set motivo inscripcion
                            es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.MotivoInscripcion mins = pin.getMotivoInscripcion();
                            if (mins != null) {
                                es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.MotivoInscripcion motivoInscripcion = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.MotivoInscripcion();
                                motivoInscripcion.setCausaVariacion(mins.getCausaVariacion());
                                es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.MotivoInscripcion.CodigoVariacionEnum codigo = mins.getCodigoVariacion();
                                if (codigo != null){
                                    motivoInscripcion.setCodigoVariacion(codigo.getValue());
                                }
                                motivoInscripcion.setDescripcion(mins.getDescripcion());
                                periodoInscripcion.setMotivoInscripcion(motivoInscripcion);
                            }
                            persona.setPeriodoInscripcion(periodoInscripcion);
                        }

                        // set fecha nacimiento
                        Date date;
                        Timestamp timestamp = null;
                        try {
                            date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse(per.getFechaNacimiento());
                            timestamp = new java.sql.Timestamp(date.getTime());
                        } catch (ParseException ex) {
                            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        XMLGregorianCalendar fechaNacimiento = GregorianCalendars.timestampToXMLGregorianCalendar(timestamp);
                        persona.setFechaNacimiento(fechaNacimiento);
                        
                        // add persona
                        personas.getPersona().add(persona);

                    }
                }
            }
            resultado.setPersonas(personas);
        }
        return resultado;
    }
    
    
    @Override
    public void peticionSincrona() {
        
        try {
            setDatosPeticion();
        } catch (JAXBException | IOException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (pde != null) {

            log.info("SCDCPAJUv3Client :: Paràmetres de consulta: " + "Solicitud: " + pde.getSolicitud());
            if (pde.getSolicitud() != null) {
                log.info("SCDCPAJUv3Client :: Paràmetres de consulta: " + "Tipus document: " + pde.getSolicitud().getProvinciaSolicitud());
                log.info("SCDCPAJUv3Client :: Paràmetres de consulta: " + "Tipus document: " + pde.getSolicitud().getMunicipioSolicitud());
                log.info("SCDCPAJUv3Client :: Paràmetres de consulta: " + "Tipus document: " + pde.getSolicitud().getTitular().getDocumentacion().getTipo());
                log.info("SCDCPAJUv3Client :: Paràmetres de consulta: " + "Document: " + pde.getSolicitud().getTitular().getDocumentacion().getValor());
            }
        }
        
        es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud sol = new es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud();
        
        es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Resultado res = getResultado(sol);
        
        rde = new SCDCPAJUv3RespuestaDatosEspecificos();
        
        es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Resultado resultado = adaptaResultado(res);
        
        rde.setResultado(resultado);
        
        Estado respuestaEstado = new Estado();
        respuestaEstado.setCodigoEstado(ErrorBackoffice.TRAMITADA.getEstat());
        //estado.setCodigoEstadoSecundario(peticionAtributosEstado.getCodigoEstadoSecundario());
        respuestaEstado.setLiteralError(ErrorBackoffice.TRAMITADA.getCodi());
        //estado.setTiempoEstimadoRespuesta(peticionAtributosEstado.getTiempoEstimadoRespuesta());
        
        es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Solicitud respuestaSolicitud = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Solicitud();
        respuestaSolicitud.setProvinciaSolicitud("07");
        respuestaSolicitud.setMunicipioSolicitud("026");
        es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Titular respuestaTitular = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Titular();
        es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Documentacion respuestaDocumentacion = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Documentacion();
        respuestaDocumentacion.setTipo("NIF");
        respuestaDocumentacion.setValor("12345678Z");
        respuestaTitular.setDocumentacion(respuestaDocumentacion);
        respuestaSolicitud.setTitular(respuestaTitular);

        datosGenericos.getTitular().setTipoDocumentacion(TipoDocumentacion.valueOf(respuestaDocumentacion.getTipo()));
        datosGenericos.getTitular().setDocumentacion(respuestaDocumentacion.getValor());

        rde.setSolicitud(respuestaSolicitud);

        try {
            setDatosRespuesta();
        } catch (JAXBException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
