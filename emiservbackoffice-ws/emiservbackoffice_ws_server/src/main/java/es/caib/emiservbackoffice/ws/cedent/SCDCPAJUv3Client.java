package es.caib.emiservbackoffice.ws.cedent;

import es.caib.emiserv.logic.intf.exception.BackofficeException;
import es.caib.emiserv.logic.intf.service.ws.backoffice.DatosGenericos;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Estado;
import es.caib.emiservbackoffice.ws.scsp.SCDCPAJUv3PeticionDatosEspecificos;
import es.caib.emiservbackoffice.ws.scsp.SCDCPAJUv3RespuestaDatosEspecificos;
import es.caib.emiservbackoffice.ws.specs.ErrorBackoffice;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.api.ScdcpajUv3Api;
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
import javax.ws.rs.core.MediaType;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.fundaciobit.pluginsib.utils.xml.XmlManager;
import org.springframework.util.Base64Utils;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import org.fundaciobit.pluginsib.utils.commons.GregorianCalendars;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import org.xml.sax.SAXException;

/**
 *
 * @author gdeignacio
 */
public class SCDCPAJUv3Client extends CedentClient {
    
    
    protected es.caib.emiservbackoffice.ws.scsp.SCDCPAJUv3PeticionDatosEspecificos pde;
        
    protected es.caib.emiservbackoffice.ws.scsp.SCDCPAJUv3RespuestaDatosEspecificos rde;
    
    public SCDCPAJUv3Client(DatosGenericos datosGenericos, String strPeticionDatosEspecificos, Propietats propietats) {
        super(datosGenericos, strPeticionDatosEspecificos, propietats);
    }

    private void setDatosPeticion() throws JAXBException, IOException{
        
        try {
            XmlManager<SCDCPAJUv3PeticionDatosEspecificos> manager
                    = new XmlManager<SCDCPAJUv3PeticionDatosEspecificos>(SCDCPAJUv3PeticionDatosEspecificos.class);
            
            Element peticionDatosEspecificos = manager.stringToElement(strPeticionDatosEspecificos);
            
            NamedNodeMap attrs = peticionDatosEspecificos.getAttributes();
            
            while (attrs.getLength() > 0) {
                attrs.removeNamedItem(attrs.item(0).getNodeName());
            }
            
            //peticionDatosEspecificos.setAttribute(XMLConstants.XMLNS_ATTRIBUTE.concat(":ns2"), EMISERV_BACKOFFICE_XMLNS);
            
            
            pde = manager.generateItem(peticionDatosEspecificos, false, true);
            
            log.info("SCDCPAJUv3Client :: Datos Especificos Peticion: " +  ((pde!=null)?pde.toString():""));
        } catch (TransformerException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        }

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

        Element respuestaDatosEspecificos = manager.generateElement(rde);
        //respuestaDatosEspecificos.setAttribute(XMLConstants.XMLNS_ATTRIBUTE, xmlSchemaAnnotation.namespace());
        
        try {
            strRespuestaDatosEspecificos = manager.elementToString(respuestaDatosEspecificos);
        } catch (TransformerException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    private es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Resultado getResultado(es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud solicitud) {

        log.info("SCDCPAJUv3Client :: Iniciant client ");

        SCDCPAJUv3CustomApi api = new SCDCPAJUv3CustomApi();
        
        SCDCPAJUv3CustomApiClient apiClient = (SCDCPAJUv3CustomApiClient) api.getApiClient();

        apiClient.setBasePath(propietats.getEndpoint());

        apiClient.setDebugging(true);

        String usuari = propietats.getUsuari();
        String secret = propietats.getSecret();

        String userpass = usuari.concat(":").concat(secret);

        apiClient.addDefaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString(userpass.getBytes(StandardCharsets.UTF_8)));

        //api.getApiClient().addDefaultHeader(HttpHeaders.ACCEPT, "; charset=" + StandardCharsets.UTF_8.name());
        //api.getApiClient().addDefaultHeader(HttpHeaders.CONTENT_TYPE, "; charset=" + StandardCharsets.UTF_8.name());
        
        es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Resultado response = null;

        try {
            response = api.peticionSincrona(solicitud);
        } catch (HttpServerErrorException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHttpStatusCodeException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
            throw new BackofficeException(api.getApiClient().getStatusCode().toString(), ex);
        }

        return response;
    }
    
    
    
    
    private es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud adaptaSolicitud(es.caib.scsp.esquemas.SCDCPAJUv3.peticion.datosespecificos.Solicitud solicitud) {

        es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud sol = new es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud();

        if (solicitud == null) {
            return sol;
        }

        String provinciaSolicitud = null;
        String municipioSolicitud = null;

        es.caib.scsp.esquemas.SCDCPAJUv3.peticion.datosespecificos.Documentacion documentacion;
        es.caib.scsp.esquemas.SCDCPAJUv3.peticion.datosespecificos.DatosPersonales datosPersonales;

        String tipo;
        String valor;
        String apellido1;
        String apellido2;
        String fechaNacimiento;
        String nombre;
        String particula1;
        String particula2;

        provinciaSolicitud = solicitud.getProvinciaSolicitud();
        municipioSolicitud = solicitud.getMunicipioSolicitud();

        sol.setProvinciaSolicitud(provinciaSolicitud);
        sol.setMunicipioSolicitud(municipioSolicitud);
        
        es.caib.scsp.esquemas.SCDCPAJUv3.peticion.datosespecificos.Titular titular = solicitud.getTitular();
        if (titular != null) {

            es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Titular ti = new  es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Titular();
            
            documentacion = titular.getDocumentacion();
            datosPersonales = titular.getDatosPersonales();

            if (documentacion != null) {
                
                es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Documentacion dc = new es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Documentacion();
                tipo = documentacion.getTipo();
                valor = documentacion.getValor();
                dc.setTipo(es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Documentacion.TipoEnum.fromValue(tipo));
                dc.setValor(valor);
                ti.setDocumentacion(dc);
                
            } else if (datosPersonales != null) {
                
                es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.DatosPersonales dp = new es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.DatosPersonales();
                
                documentacion = datosPersonales.getDocumentacion();

                if (documentacion != null) {
                    es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Documentacion dc = new es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Documentacion();
                    tipo = documentacion.getTipo();
                    valor = documentacion.getValor();
                    dc.setTipo(es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Documentacion.TipoEnum.fromValue(tipo));
                    dc.setValor(valor);
                    dp.setDocumentacion(dc);
                }

                apellido1 = datosPersonales.getApellido1();
                dp.setApellido1(apellido1);
                apellido2 = datosPersonales.getApellido2();
                dp.setApellido2(apellido2);
                
                XMLGregorianCalendar fn = datosPersonales.getFechaNacimiento();

                if (fn != null) {
                    Timestamp timestamp = GregorianCalendars.xmlGregorianCalendarToTimestamp(fn);
                    DateTime dateTime = new DateTime(timestamp);
                    DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
                    fechaNacimiento = dateTime.toString(dtf);
                    dp.setFechaNacimiento(fechaNacimiento);
                }

                nombre = datosPersonales.getNombre();
                dp.setNombre(nombre);
                particula1 = datosPersonales.getParticula1();
                dp.setParticula1(particula1);
                particula2 = datosPersonales.getParticula2();
                dp.setParticula2(particula2);
                ti.setDatosPersonales(dp);
            }
            sol.setTitular(ti);
        }
        return sol;
    }
    
    private es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Resultado adaptaResultado(es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Resultado res) {

        if (res == null) {
            return null;
        }
        
        es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Resultado resultado = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Resultado();

        // Set fechaExpedicion
        
        //LocalDate fexp = res.getFechaExpedicion();
        //String fechaExpedicion = fexp.toString("yyyy-MM-dd");
        //resultado.setFechaExpedicion(fechaExpedicion);

        String fexp = res.getFechaExpedicion();
        String fechaExpedicion = fexp;
        try {
            fechaExpedicion = fullDateToDate(fexp);
        } catch (ParseException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        resultado.setFechaExpedicion(fechaExpedicion);
        
        
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
                via.setTipo(va.getTipo().substring(0, 1));
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
                            
                            //LocalDate dsd = pin.getDesde();
                            //String desde = dsd.toString("yyyy-MM-dd");                    
                            //periodoInscripcion.setDesde(desde);
                            
                            String dsd = pin.getDesde();
                            String desde = dsd; 
                            try {        
                                desde = fullDateToDate(dsd);
                            } catch (ParseException ex) {
                                Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
                            }              
                            periodoInscripcion.setDesde(desde);
                            
                         
                            // Set motivo inscripcion
                            es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.MotivoInscripcion mins = pin.getMotivoInscripcion();
                            
                            if (mins != null) {
                                es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.MotivoInscripcion motivoInscripcion = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.MotivoInscripcion();
                                motivoInscripcion.setCausaVariacion((mins.getCausaVariacion()!=null)?mins.getCausaVariacion():"OM");
                                es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.MotivoInscripcion.CodigoVariacionEnum codigo = mins.getCodigoVariacion();
                                if (codigo != null){
                                    motivoInscripcion.setCodigoVariacion(codigo.getValue());
                                } else {
                                    motivoInscripcion.setCodigoVariacion("A");
                                }
                                motivoInscripcion.setDescripcion((mins.getDescripcion()!=null)?mins.getDescripcion():"OM");
                                periodoInscripcion.setMotivoInscripcion(motivoInscripcion);
                            }
                            persona.setPeriodoInscripcion(periodoInscripcion);
                        }

                        // set fecha nacimiento
                        Date date;
                        Timestamp timestamp = null;
                        try {
                            date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(per.getFechaNacimiento());
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
                log.info("SCDCPAJUv3Client :: Paràmetres de consulta: " + "Provincia: " + pde.getSolicitud().getProvinciaSolicitud());
                log.info("SCDCPAJUv3Client :: Paràmetres de consulta: " + "Municipi: " + pde.getSolicitud().getMunicipioSolicitud());
                log.info("SCDCPAJUv3Client :: Paràmetres de consulta: " + "Tipus document: " + pde.getSolicitud().getTitular().getDocumentacion().getTipo());
                log.info("SCDCPAJUv3Client :: Paràmetres de consulta: " + "Document: " + pde.getSolicitud().getTitular().getDocumentacion().getValor());
            }
        }

        es.caib.scsp.esquemas.SCDCPAJUv3.peticion.datosespecificos.Solicitud solicitud = pde.getSolicitud();
        
        String provinciaSolicitud = null;
        String municipioSolicitud = null;
        
        if (solicitud != null) {
            provinciaSolicitud = solicitud.getProvinciaSolicitud();
            municipioSolicitud = solicitud.getMunicipioSolicitud();
        }

        es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud sol = adaptaSolicitud(pde.getSolicitud());
        
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
        
        respuestaSolicitud.setProvinciaSolicitud(provinciaSolicitud);
        respuestaSolicitud.setMunicipioSolicitud(municipioSolicitud);
        es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Titular respuestaTitular = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Titular();
        es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Documentacion respuestaDocumentacion = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Documentacion();
        
        String tipo = null;
        String valor = null;
        
        if (solicitud!=null && solicitud.getTitular()!= null && solicitud.getTitular().getDocumentacion()!=null){
            tipo = solicitud.getTitular().getDocumentacion().getTipo();
            valor = solicitud.getTitular().getDocumentacion().getValor();
        } else if (solicitud!=null && solicitud.getTitular()!= null && solicitud.getTitular().getDatosPersonales()!=null && solicitud.getTitular().getDatosPersonales().getDocumentacion()!=null){
            tipo = solicitud.getTitular().getDatosPersonales().getDocumentacion().getTipo();
            valor = solicitud.getTitular().getDatosPersonales().getDocumentacion().getValor();
        }
        
        respuestaDocumentacion.setTipo(tipo);
        respuestaDocumentacion.setValor(valor);
        respuestaTitular.setDocumentacion(respuestaDocumentacion);
        respuestaSolicitud.setTitular(respuestaTitular);
        
        datosGenericos.getTitular().setTipoDocumentacion(es.caib.emiserv.logic.intf.service.ws.backoffice.TipoDocumentacion.valueOf(respuestaDocumentacion.getTipo()));
        datosGenericos.getTitular().setDocumentacion(respuestaDocumentacion.getValor());
        

        rde.setSolicitud(respuestaSolicitud);

        try {
            setDatosRespuesta();
        } catch (JAXBException | ParserConfigurationException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Element getRespuestaDatosEspecificos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPeticionDatosEspecificos(Element element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
