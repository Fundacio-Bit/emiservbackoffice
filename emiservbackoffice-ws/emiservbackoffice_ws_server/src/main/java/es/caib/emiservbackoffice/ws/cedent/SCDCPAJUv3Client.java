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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;
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


/**
 *
 * @author gdeignacio
 */
public class SCDCPAJUv3Client extends CedentClient {
    
    
    protected SCDCPAJUv3PeticionDatosEspecificos pde;
        
    protected SCDCPAJUv3RespuestaDatosEspecificos rde;
    
    public SCDCPAJUv3Client(DatosGenericos datosGenericos, Element peticionDatosEspecificos, Propietats propietats) {
        super(datosGenericos, peticionDatosEspecificos, propietats);
    }

    private void setDatosPeticion() throws JAXBException, IOException{
        
        
        NamedNodeMap attrs = peticionDatosEspecificos.getAttributes();
        
        while (attrs.getLength() > 0) {
            attrs.removeNamedItem(attrs.item(0).getNodeName());
        }
        
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
        
        response = api.peticionSincrona(solicitud);
        
        return response;
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
        
        es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.ClaveHojaPadronal claveHojaPadronal = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.ClaveHojaPadronal();
        
        claveHojaPadronal.setDistrito(res.getClaveHojaPadronal().getDistrito());
        claveHojaPadronal.setSeccion(res.getClaveHojaPadronal().getSeccion());
        claveHojaPadronal.setHoja(res.getClaveHojaPadronal().getHoja());
        
        es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Domicilio domicilio = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Domicilio();
        domicilio.setBloque(res.getDomicilio().getBloque());
        domicilio.setCodPostal(res.getDomicilio().getCodPostal());
        domicilio.setEscalera(res.getDomicilio().getEscalera());
        domicilio.setHmt(res.getDomicilio().getHmt());
        domicilio.setKmt(res.getDomicilio().getKmt());
        
        es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Numero numero = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Numero();
        numero.setCalificador(res.getDomicilio().getNumero().getCalificador());
        numero.setValor(res.getDomicilio().getNumero().getValor());
        domicilio.setNumero(numero);
        
        es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.NumeroSuperior numeroSuperior = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.NumeroSuperior();
        numeroSuperior.setCalificador(res.getDomicilio().getNumeroSuperior().getCalificador());
        numeroSuperior.setValor(res.getDomicilio().getNumeroSuperior().getValor());
        domicilio.setNumeroSuperior(numeroSuperior);
        
        domicilio.setPlanta(res.getDomicilio().getPlanta());
        domicilio.setPortal(res.getDomicilio().getPortal());
        domicilio.setPuerta(res.getDomicilio().getPuerta());
        
        es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Via via = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Via();
        via.setCodigo(res.getDomicilio().getVia().getCodigo());
        via.setNombre(res.getDomicilio().getVia().getNombre());
        via.setTipo(res.getDomicilio().getVia().getTipo());
        domicilio.setVia(via);
        
        es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Personas personas = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Personas();
        
        for ( es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Persona per:res.getPersonas().getDomicilio()){
            es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Persona persona = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Persona();
            persona.setApellido1(per.getApellido1());
            persona.setApellido2(per.getApellido2());
            persona.setNIA(per.getNia());
            persona.setNombre(per.getNombre());
            persona.setParticula1(per.getParticula1());
            persona.setParticula2(per.getParticula2());
            
            es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Documentacion documentacion = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Documentacion();
            documentacion.setTipo(per.getDocumentacion().getTipo().getValue());
            documentacion.setValor(per.getDocumentacion().getValor());
            persona.setDocumentacion(documentacion);
            
            es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.PeriodoInscripcion periodoInscripcion = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.PeriodoInscripcion();
            periodoInscripcion.setDesde(per.getPeriodoInscripcion().getDesde());
            
            es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.MotivoInscripcion motivoInscripcion = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.MotivoInscripcion();
            motivoInscripcion.setCausaVariacion(per.getPeriodoInscripcion().getMotivoInscripcion().getCausaVariacion());
            motivoInscripcion.setCodigoVariacion(per.getPeriodoInscripcion().getMotivoInscripcion().getCodigoVariacion().getValue());
            motivoInscripcion.setDescripcion(per.getPeriodoInscripcion().getMotivoInscripcion().getDescripcion());
            
            periodoInscripcion.setMotivoInscripcion(motivoInscripcion);
            
            persona.setPeriodoInscripcion(periodoInscripcion);
            
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
            personas.getPersona().add(persona);
        
        }
        
        rde = new SCDCPAJUv3RespuestaDatosEspecificos();
        
        es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Resultado resultado = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.Resultado();
        resultado.setClaveHojaPadronal(claveHojaPadronal);
        resultado.setDomicilio(domicilio);
        resultado.setFechaExpedicion(res.getFechaExpedicion());
        resultado.setPersonas(personas);
        
        
        
        
        

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
