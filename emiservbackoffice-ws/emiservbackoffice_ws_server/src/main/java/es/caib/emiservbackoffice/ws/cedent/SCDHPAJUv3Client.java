package es.caib.emiservbackoffice.ws.cedent;

import es.caib.emiserv.logic.intf.service.ws.backoffice.DatosGenericos;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Estado;
import es.caib.emiservbackoffice.ws.scsp.SCDHPAJUv3PeticionDatosEspecificos;
import es.caib.emiservbackoffice.ws.scsp.SCDHPAJUv3RespuestaDatosEspecificos;
import es.caib.emiservbackoffice.ws.specs.ErrorBackoffice;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.api.ScdhpajUv3Api;
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
import org.xml.sax.SAXException;

/**
 *
 * @author gdeignacio
 */
public class SCDHPAJUv3Client extends CedentClient {
    
    
    protected es.caib.emiservbackoffice.ws.scsp.SCDHPAJUv3PeticionDatosEspecificos pde;
        
    protected es.caib.emiservbackoffice.ws.scsp.SCDHPAJUv3RespuestaDatosEspecificos rde;
    
    public SCDHPAJUv3Client(DatosGenericos datosGenericos, String strPeticionDatosEspecificos, Propietats propietats) {
        super(datosGenericos, strPeticionDatosEspecificos, propietats);
    }

    private void setDatosPeticion() throws JAXBException, IOException{
        
        try {
            XmlManager<SCDHPAJUv3PeticionDatosEspecificos> manager
                    = new XmlManager<SCDHPAJUv3PeticionDatosEspecificos>(SCDHPAJUv3PeticionDatosEspecificos.class);
            
            Element peticionDatosEspecificos = manager.stringToElement(strPeticionDatosEspecificos);
            
            NamedNodeMap attrs = peticionDatosEspecificos.getAttributes();
            
            while (attrs.getLength() > 0) {
                attrs.removeNamedItem(attrs.item(0).getNodeName());
            }
            
            //peticionDatosEspecificos.setAttribute(XMLConstants.XMLNS_ATTRIBUTE.concat(":ns2"), EMISERV_BACKOFFICE_XMLNS);
            
            
            pde = manager.generateItem(peticionDatosEspecificos, false, true);
            
            log.info("SCDHPAJUv3Client :: Datos Especificos Peticion: " +  ((pde!=null)?pde.toString():""));
        } catch (TransformerException ex) {
            Logger.getLogger(SCDHPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SCDHPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SCDHPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    private void setDatosRespuesta() throws JAXBException, ParserConfigurationException{
        
        XmlManager<SCDHPAJUv3RespuestaDatosEspecificos> manager
                = new XmlManager<SCDHPAJUv3RespuestaDatosEspecificos>(SCDHPAJUv3RespuestaDatosEspecificos.class);
        
        XmlSchema xmlSchemaAnnotation = manager.getXmlSchemaAnnotation();

        log.info("SCDHPAJUv3Client :: Datos Especificos NAMESPACE: " + ((xmlSchemaAnnotation!=null)?xmlSchemaAnnotation.namespace():"No xmlSchemaAnnotation"));
        log.info("SCDHPAJUv3Client :: Datos Especificos LOCATION: " + ((xmlSchemaAnnotation!=null)?xmlSchemaAnnotation.location():"No xmlSchemaAnnotation"));

        XmlRootElement xmlRootElementAnnotation = manager.getXmlRootElementAnnotation();

        log.info("SCDHPAJUv3Client :: Datos Especificos XmlRoot NAMESPACE: " + ((xmlRootElementAnnotation!=null)?xmlRootElementAnnotation.namespace():"No xmlRootElementAnnotation"));
        log.info("SCDHPAJUv3Client :: Datos Especificos XmlRoot LOCATION: " + ((xmlRootElementAnnotation!=null)?xmlRootElementAnnotation.name():"No xmlRootElementAnnotation"));

        Element respuestaDatosEspecificos = manager.generateElement(rde);
        //respuestaDatosEspecificos.setAttribute(XMLConstants.XMLNS_ATTRIBUTE, xmlSchemaAnnotation.namespace());
        
        try {
            strRespuestaDatosEspecificos = manager.elementToString(respuestaDatosEspecificos);
        } catch (TransformerException ex) {
            Logger.getLogger(SCDHPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    private es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Resultado getResultado(es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Solicitud solicitud) {

        log.info("SCDHPAJUv3Client :: Iniciant client ");

        ScdhpajUv3Api api = new ScdhpajUv3Api();

        api.getApiClient().setBasePath(propietats.getEndpoint());

        api.getApiClient().setDebugging(true);

        String usuari = propietats.getUsuari();
        String secret = propietats.getSecret();

        String userpass = usuari.concat(":").concat(secret);

        api.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString(userpass.getBytes(StandardCharsets.UTF_8)));

        es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Resultado response = null;

        try {
            response = api.peticionSincrona(solicitud);
        } catch (HttpServerErrorException ex) {
            Logger.getLogger(SCDHPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }
    
    
    
    
    private es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Solicitud adaptaSolicitud(es.caib.scsp.esquemas.SCDHPAJUv3.peticion.datosespecificos.Solicitud solicitud) {

        es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Solicitud sol = new es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Solicitud();

        if (solicitud == null) {
            return sol;
        }

        String provinciaSolicitud = null;
        String municipioSolicitud = null;
        String numeroAnyos = null;

        String nia = null;
        es.caib.scsp.esquemas.SCDHPAJUv3.peticion.datosespecificos.Documentacion documentacion;
        es.caib.scsp.esquemas.SCDHPAJUv3.peticion.datosespecificos.DatosPersonales datosPersonales;
        

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
        numeroAnyos = solicitud.getNumeroAnyos();

        sol.setProvinciaSolicitud(provinciaSolicitud);
        sol.setMunicipioSolicitud(municipioSolicitud);
        sol.setNumeroAnyos(numeroAnyos);
        
        es.caib.scsp.esquemas.SCDHPAJUv3.peticion.datosespecificos.Titular titular = solicitud.getTitular();
        if (titular != null) {

            es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Titular ti = new  es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Titular();
            
            documentacion = titular.getDocumentacion();
            datosPersonales = titular.getDatosPersonales();
            nia = titular.getNIA();

            if (documentacion != null) {
                
                es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Documentacion dc = new es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Documentacion();
                tipo = documentacion.getTipo();
                valor = documentacion.getValor();
                dc.setTipo(es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Documentacion.TipoEnum.fromValue(tipo));
                dc.setValor(valor);
                ti.setDocumentacion(dc);
                
            } else if (datosPersonales != null) {
                
                es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.DatosPersonales dp = new es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.DatosPersonales();
                
                documentacion = datosPersonales.getDocumentacion();

                if (documentacion != null) {
                    es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Documentacion dc = new es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Documentacion();
                    tipo = documentacion.getTipo();
                    valor = documentacion.getValor();
                    dc.setTipo(es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Documentacion.TipoEnum.fromValue(tipo));
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
            } else if (nia!=null && !"".equals(nia)) {
                ti.setNia(nia);
            }
            sol.setTitular(ti);
        }
        return sol;
    }
    
    private es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Resultado adaptaResultado(es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Resultado res) {

        if (res == null) {
            return null;
        }

        es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Resultado resultado = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Resultado();

        resultado.setApellido1(res.getApellido1());
        resultado.setApellido2(res.getApellido2());
        
        // set Documentacion
        es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Documentacion doc = res.getDocumentacion();
        if (doc != null) {
            es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Documentacion documentacion = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Documentacion();
            es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Documentacion.TipoEnum tipo = doc.getTipo();
            if (tipo != null) {
                documentacion.setTipo(tipo.getValue());
            }
            documentacion.setValor(doc.getValor());
            resultado.setDocumentacion(documentacion);
        }

        //LocalDate fexp = res.getFechaExpedicion();
        //String fechaExpedicion = fexp.toString("yyyy-MM-dd");
        //resultado.setFechaExpedicion(fechaExpedicion);
        
        String fexp = res.getFechaExpedicion();
        String fechaExpedicion = fexp;
        try {
            fechaExpedicion = fullDateToDate(fexp);
        } catch (ParseException ex) {
            Logger.getLogger(SCDHPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        resultado.setFechaExpedicion(fechaExpedicion);
        
        
        // set fecha nacimiento
        Date date;
        Timestamp timestamp = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(res.getFechaNacimiento());
            timestamp = new java.sql.Timestamp(date.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(SCDHPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        XMLGregorianCalendar fechaNacimiento = GregorianCalendars.timestampToXMLGregorianCalendar(timestamp);
        resultado.setFechaNacimiento(fechaNacimiento);


        // Set Historico Domicilios
        es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.HistoricoDomicilios hdom = res.getHistoricoDomicilios();
        if (hdom!=null){
            
            es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.HistoricoDomicilios historicoDomicilios = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.HistoricoDomicilios();
            
            List<es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Domicilio> lDom = hdom.getDomicilio();
            
            if (lDom != null){
                
                for (es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Domicilio dom : lDom){
                    
                    if (dom!=null){
                        
                        es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Domicilio domicilio = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Domicilio();
                        
                        // Set ClaveHojaPadronal
                        es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.ClaveHojaPadronal chp = dom.getClaveHojaPadronal();
                        
                        if (chp != null) {
                            es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.ClaveHojaPadronal claveHojaPadronal = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.ClaveHojaPadronal();
                            claveHojaPadronal.setDistrito(chp.getDistrito());
                            claveHojaPadronal.setSeccion(chp.getSeccion());
                            claveHojaPadronal.setHoja(chp.getHoja());
                            domicilio.setClaveHojaPadronal(claveHojaPadronal);
                        }

                        // set codUnidadPoblacional
                        domicilio.setCodUnidadPoblacional(dom.getCodUnidadPoblacional());
                        
                        //LocalDate dsd = dom.getDesde();
                        //String desde = dsd.toString("yyyy-MM-dd");                    
                        //domicilio.setDesde(desde);
                        
                        String dsd = dom.getDesde();
                        String desde = dsd;
                        try {
                            desde = fullDateToDate(dsd);
                        } catch (ParseException ex) {
                            Logger.getLogger(SCDHPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        domicilio.setDesde(desde);

                        
                        es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Direccion dir = dom.getDireccion();
                        
                        if (dir!=null){
                            
                            es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Direccion direccion = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Direccion();
                            
                            direccion.setBloque(dir.getBloque());
                            direccion.setCodPostal(dir.getCodPostal());
                            direccion.setEscalera(dir.getEscalera());
                            direccion.setHmt(dir.getHmt());
                            direccion.setKmt(dir.getKmt());
                            
                             // Set numero   
                            es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Numero num = dir.getNumero();

                            if (num != null) {
                                es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Numero numero = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Numero();
                                numero.setCalificador(num.getCalificador());
                                numero.setValor(num.getValor());
                                direccion.setNumero(numero);
                            }

                            // Set numero superior   
                            es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.NumeroSuperior numsup = dir.getNumeroSuperior();
                            if (numsup != null) {
                                es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.NumeroSuperior numeroSuperior = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.NumeroSuperior();
                                numeroSuperior.setCalificador(numsup.getCalificador());
                                numeroSuperior.setValor(numsup.getValor());
                                direccion.setNumeroSuperior(numeroSuperior);
                            }
                            
                            direccion.setPlanta(dir.getPlanta());
                            direccion.setPortal(dir.getPortal());
                            direccion.setPuerta(dir.getPuerta());
                            
                             // Set via   
                            es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Via va  = dir.getVia();
                            if (va  != null) {
                                es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Via via = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Via();
                                via.setCodigo(va.getCodigo());
                                via.setNombre(va.getNombre());
                                via.setTipo(va.getTipo());
                                direccion.setVia(via);
                            }
                            domicilio.setDireccion(direccion); 
                        }
                        
                        es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.EntColectiva entc = dom.getEntColectiva();
                        
                        if (entc!=null){
                            es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.EntColectiva entColectiva = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.EntColectiva();
                            entColectiva.setCodigo(entc.getCodigo());
                            entColectiva.setNombre(entc.getNombre());
                            domicilio.setEntColectiva(entColectiva);
                        }
                        
                        es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.EntSingular ents = dom.getEntSingular();
                        
                        if (ents!=null){
                            es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.EntSingular entSingular = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.EntSingular();
                            entSingular.setCodigo(ents.getCodigo());
                            entSingular.setNombre(ents.getNombre());
                            domicilio.setEntSingular(entSingular);
                        }
                        
                        //LocalDate hst = dom.getHasta();
                        //String hasta = hst.toString("yyyy-MM-dd");                    
                        //domicilio.setHasta(hasta);
                        
                        String hst = dom.getHasta();
                        String hasta = hst;
                        try {
                            hasta = fullDateToDate(hst);
                        } catch (ParseException ex) {
                            Logger.getLogger(SCDHPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        domicilio.setHasta(hasta);


                        // Set motivo baja
                        es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.MotivoBaja motb = dom.getMotivoBaja();
                        if (motb != null) {
                            es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.MotivoBaja motivoBaja = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.MotivoBaja();
                            motivoBaja.setCausaVariacion(motb.getCausaVariacion());
                            es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.MotivoBaja.CodigoVariacionEnum codigo = motb.getCodigoVariacion();
                            if (codigo != null) {
                                motivoBaja.setCodigoVariacion(codigo.getValue());
                            }
                            motivoBaja.setDescripcion(motb.getDescripcion());
                            domicilio.setMotivoBaja(motivoBaja);
                        }

                        // Set motivo inscripcion
                        es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.MotivoInscripcion mins = dom.getMotivoInscripcion();
                        if (mins != null) {
                            es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.MotivoInscripcion motivoInscripcion = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.MotivoInscripcion();
                            motivoInscripcion.setCausaVariacion(mins.getCausaVariacion());
                            es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.MotivoInscripcion.CodigoVariacionEnum codigo = mins.getCodigoVariacion();
                            if (codigo != null) {
                                motivoInscripcion.setCodigoVariacion(codigo.getValue());
                            }
                            motivoInscripcion.setDescripcion(mins.getDescripcion());
                            domicilio.setMotivoInscripcion(motivoInscripcion);
                        }

                        es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.MunicipioRespuesta munRes = dom.getMunicipioRespuesta();
                        
                        if (munRes!=null){
                            es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.MunicipioRespuesta municipioRespuesta = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.MunicipioRespuesta();
                            municipioRespuesta.setCodigo(munRes.getCodigo());
                            municipioRespuesta.setNombre(munRes.getNombre());
                            domicilio.setMunicipioRespuesta(municipioRespuesta);
                        }
                       
                        es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Nucleo nuc = dom.getNucleo();
                        
                        if (nuc!=null){
                            es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Nucleo nucleo = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Nucleo();
                            nucleo.setCodigo(nucleo.getCodigo());
                            nucleo.setNombre(nucleo.getNombre());
                            domicilio.setNucleo(nucleo);
                        }
                        
                        es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.ProvinciaRespuesta proRes = dom.getProvinciaRespuesta();
                        
                        if (proRes!=null){
                            es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.ProvinciaRespuesta provinciaRespuesta = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.ProvinciaRespuesta();
                            provinciaRespuesta.setCodigo(proRes.getCodigo());
                            provinciaRespuesta.setNombre(proRes.getNombre());
                            domicilio.setProvinciaRespuesta(provinciaRespuesta);
                        }
                        
                        historicoDomicilios.getDomicilio().add(domicilio);
                    }
                    
                }
            }
            
            resultado.setHistoricoDomicilios(historicoDomicilios);
        }
        
        resultado.setNombre(res.getNombre());
        resultado.setParticula1(res.getParticula1());
        resultado.setParticula2(res.getParticula2());
        
        return resultado;
    }
    
    
    @Override
    public void peticionSincrona() {

        try {
            setDatosPeticion();
        } catch (JAXBException | IOException ex) {
            Logger.getLogger(SCDHPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (pde != null) {

            log.info("SCDHPAJUv3Client :: Paràmetres de consulta: " + "Solicitud: " + pde.getSolicitud());
            if (pde.getSolicitud() != null) {
                log.info("SCDHPAJUv3Client :: Paràmetres de consulta: " + "Provincia: " + pde.getSolicitud().getProvinciaSolicitud());
                log.info("SCDHPAJUv3Client :: Paràmetres de consulta: " + "Municipi: " + pde.getSolicitud().getMunicipioSolicitud());
                log.info("SCDHPAJUv3Client :: Paràmetres de consulta: " + "Numero anyos: " + pde.getSolicitud().getNumeroAnyos());
                log.info("SCDHPAJUv3Client :: Paràmetres de consulta: " + "Tipus document: " + pde.getSolicitud().getTitular().getDocumentacion().getTipo());
                log.info("SCDHPAJUv3Client :: Paràmetres de consulta: " + "Document: " + pde.getSolicitud().getTitular().getDocumentacion().getValor());
            }
        }

        es.caib.scsp.esquemas.SCDHPAJUv3.peticion.datosespecificos.Solicitud solicitud = pde.getSolicitud();
        
        String provinciaSolicitud = null;
        String municipioSolicitud = null;
        
        if (solicitud != null) {
            provinciaSolicitud = solicitud.getProvinciaSolicitud();
            municipioSolicitud = solicitud.getMunicipioSolicitud();
        }

        es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Solicitud sol = adaptaSolicitud(pde.getSolicitud());
        
        es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Resultado res = getResultado(sol);

        rde = new SCDHPAJUv3RespuestaDatosEspecificos();

        es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Resultado resultado = adaptaResultado(res);

        rde.setResultado(resultado);

        Estado respuestaEstado = new Estado();
        respuestaEstado.setCodigoEstado(ErrorBackoffice.TRAMITADA.getEstat());
        //estado.setCodigoEstadoSecundario(peticionAtributosEstado.getCodigoEstadoSecundario());
        respuestaEstado.setLiteralError(ErrorBackoffice.TRAMITADA.getCodi());
        //estado.setTiempoEstimadoRespuesta(peticionAtributosEstado.getTiempoEstimadoRespuesta());

        
        es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Solicitud respuestaSolicitud = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Solicitud();
        
        respuestaSolicitud.setProvinciaSolicitud(provinciaSolicitud);
        respuestaSolicitud.setMunicipioSolicitud(municipioSolicitud);
        es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Titular respuestaTitular = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Titular();
        es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Documentacion respuestaDocumentacion = new es.caib.scsp.esquemas.SCDHPAJUv3.respuesta.datosespecificos.Documentacion();
        
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
            Logger.getLogger(SCDHPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
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
