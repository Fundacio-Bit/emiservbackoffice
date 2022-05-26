package es.caib.emiservbackoffice.ws.impl;

import es.caib.emiserv.logic.intf.service.ws.backoffice.Atributos;
import es.caib.emiserv.logic.intf.service.ws.backoffice.ConfirmacionPeticion;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Consentimiento;
import es.caib.emiserv.logic.intf.service.ws.backoffice.DatosGenericos;
import es.caib.emiserv.logic.intf.service.ws.backoffice.EmiservBackoffice;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Emisor;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Estado;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Funcionario;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Peticion;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Procedimiento;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Respuesta;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Solicitante;
import es.caib.emiserv.logic.intf.service.ws.backoffice.SolicitudRespuesta;
import es.caib.emiserv.logic.intf.service.ws.backoffice.SolicitudTransmision;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Solicitudes;
import es.caib.emiserv.logic.intf.service.ws.backoffice.TipoDocumentacion;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Titular;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Transmision;
import es.caib.emiserv.logic.intf.service.ws.backoffice.TransmisionDatos;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Transmisiones;

import es.caib.emiserv.logic.intf.service.ws.backoffice.SoapFaultAtributos;
import es.caib.emiservbackoffice.commons.config.PropertyFileConfigSource;
import es.caib.emiservbackoffice.ws.cedent.CedentClient;
import es.caib.emiservbackoffice.ws.cedent.Propietats;
import es.caib.emiservbackoffice.ws.specs.ErrorBackoffice;
import static es.caib.emiservbackoffice.ws.specs.ErrorBackoffice.ERROR_DATOS_ESPECIFICOS;
import static es.caib.emiservbackoffice.ws.specs.ErrorBackoffice.FALTA_ATRIBUTOS;
import static es.caib.emiservbackoffice.ws.specs.ErrorBackoffice.FALTA_CERTIFICAT;
import static es.caib.emiservbackoffice.ws.specs.ErrorBackoffice.FALTA_SOLICITUD;
import static es.caib.emiservbackoffice.ws.specs.ErrorBackoffice.MULTIPLES_SOLICITUDS;
import static es.caib.emiservbackoffice.ws.specs.ErrorBackoffice.SCHEMA_INCORRECTE;
import es.caib.emiservbackoffice.ws.specs.ServeiBackoffice;

import es.caib.emiservbackoffice.ws.utils.BaseWsImpl;
import es.caib.emiservbackoffice.ws.utils.WsI18NException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.fundaciobit.pluginsib.utils.xml.XmlUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @author gdeignacio
 */
@Stateless(name = EmiservBackofficeWsImpl.NAME + "Ejb")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebService(
        name = EmiservBackofficeWsImpl.NAME_WS,
        portName = EmiservBackofficeWsImpl.NAME_WS,
        serviceName = EmiservBackofficeWsImpl.NAME_WS + "Service",
        targetNamespace = "http://caib.es/emiserv/backoffice")
public class EmiservBackofficeWsImpl extends BaseWsImpl implements EmiservBackoffice {

//    public static final String TRAMITADA = "0003";
//    public static final String DOS_O_MES = "0232";
//    public static final String NO_IDENTIFICAT = "0233";
//    public static final String NOT_DISPONIBLE = "0238";
//    public static final String SCHEMA_INCORRECTE = "0401";
//    public static final String FALTA_SOLICITUD = "0401";
//    public static final String FALTA_ATRIBUTOS = "0401";
//    public static final String MULTIPLES_SOLICITUDS = "0415";
//    public static final String ERROR_BACKOFFICE = "0242";
//    public static final String ERROR_CEDENT = "0242";
    
    public static final String NAME = "EmiservBackoffice";

    public static final String NAME_WS = NAME + "Ws";
    
    @WebMethod
    public String echo(@WebParam(name = "echo") String echo) throws WsI18NException {
        log.info("EmiservBackofficeWsImpl :: echo = " + echo);
        return echo;
    }

    @Override
    public Respuesta peticionSincrona(Peticion peticion) {
        
        Respuesta respuesta = new Respuesta();
        
        if (peticion==null) {
            respuesta = peticionErronea(SCHEMA_INCORRECTE,  "Peticion nula");
            return respuesta;
        }
        
        log.info("EmiservBackofficeWsImpl :: Peticion no nula" );
        
        Atributos peticionAtributos = peticion.getAtributos();
        
        if (peticionAtributos==null) {
            respuesta = peticionErronea(FALTA_ATRIBUTOS,  "Falta camp atributs");
            return respuesta;
        }
        
        if (peticionAtributos.getCodigoCertificado()==null) {
            respuesta = peticionErronea(FALTA_CERTIFICAT,  "Falta codi de certificat");
            return respuesta;
        }
        
        log.info("EmiservBackofficeWsImpl :: Atributos: "  + peticionAtributos.toString());
        
        Estado peticionAtributosEstado = peticionAtributos.getEstado();
        
        if (peticionAtributosEstado==null) {
            log.info("EmiservBackofficeWsImpl :: Estado: Petició no subministra estat. Creant objecte Estado ");
            peticionAtributosEstado = new Estado();
        }
        
        log.info("EmiservBackofficeWsImpl :: Estado: "  + peticionAtributosEstado.toString());
        
        Solicitudes peticionSolicitudes = peticion.getSolicitudes();
        
        if (peticionSolicitudes==null) {
            respuesta = peticionErronea(FALTA_SOLICITUD,  "El número de sol·licituds ha de ser major que 0");
            return respuesta;
        }
        
        List<SolicitudTransmision> peticionSolicitudesSolicitudTransmision = peticionSolicitudes.getSolicitudTransmision();
        
        if (peticionSolicitudesSolicitudTransmision==null) {
            respuesta = peticionErronea(FALTA_SOLICITUD,  "El número de transmisions de la sol·licitud ha de ser major que 0");
            return respuesta;
        }
        
        log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Size :"  + peticionSolicitudesSolicitudTransmision.size());
        
        if (peticionSolicitudesSolicitudTransmision.size()>1){
            respuesta = peticionErronea(MULTIPLES_SOLICITUDS,  "El número de sol·licituds no pot ser major que 1");
            return respuesta;
        }
        
        ArrayList<TransmisionDatos> respuestaTransmisionesTransmisionDatos = new ArrayList<TransmisionDatos>();
        
        for (SolicitudTransmision peticionSolicitudTransmision : peticionSolicitudesSolicitudTransmision) {
            
            // Secció de tractament de la peticio
        
            String peticionSolicitudTransmisionId = peticionSolicitudTransmision.getId();
            
            log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Id : "  + peticionSolicitudTransmisionId);
            
            DatosGenericos peticionDatosGenericos = peticionSolicitudTransmision.getDatosGenericos();
            
            Element peticionDatosEspecificos = (Element)peticionSolicitudTransmision.getDatosEspecificos();
            
            String strPeticionDatosEspecificos;
            
            try {
                strPeticionDatosEspecificos = elementToString(peticionDatosEspecificos);
            } catch (TransformerException ex) {
                Logger.getLogger(EmiservBackofficeWsImpl.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = peticionErronea(ERROR_DATOS_ESPECIFICOS,  "Error al tractar dades específiques");
                return respuesta;
            }
            
            log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Datos Especificos : "  + strPeticionDatosEspecificos);
           
            Emisor peticionEmisor = peticionDatosGenericos.getEmisor();
            log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Emisor : "  + peticionEmisor.toString());
            Solicitante peticionSolicitante = peticionDatosGenericos.getSolicitante();
            log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Solicitante : "  + peticionSolicitante.toString());
            Titular peticionTitular = peticionDatosGenericos.getTitular();
            log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Titular : "  + peticionTitular.toString());
            Transmision peticionTransmision = peticionDatosGenericos.getTransmision();
            log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Transmision : "  + peticionTransmision.toString());

            Consentimiento peticionSolicitanteConsentimiento = peticionSolicitante.getConsentimiento();
            log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Consentimiento : "  + peticionSolicitanteConsentimiento.toString());
            Funcionario peticionSolicitanteFuncionario = peticionSolicitante.getFuncionario();
            log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Funcionario : "  + peticionSolicitanteFuncionario.toString());
            Procedimiento peticionSolicitanteProcedimiento = peticionSolicitante.getProcedimiento();
            log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Procedimiento : "  + peticionSolicitanteProcedimiento.toString());
            TipoDocumentacion peticionTitularTipoDocumentacion = peticionTitular.getTipoDocumentacion();
            
            if (peticionTitularTipoDocumentacion==null) {
                log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: TipoDocumentacion : Petició no subministra informació del titular.");
            } else{
                log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: TipoDocumentacion :"  + peticionTitularTipoDocumentacion.toString());
            }
            
            // Secció de tractament de la resposta
            
            String codiCertificat = peticionAtributos.getCodigoCertificado();
            
            ServeiBackoffice serveiBackoffice = ServeiBackoffice.valueOf(codiCertificat);
            
            if (serveiBackoffice==null) {
                respuesta = peticionErronea(FALTA_CERTIFICAT,  "No s'ha trobat un certificat");
                return respuesta;
            }
            
            Propietats propietats = new Propietats(new PropertyFileConfigSource(), serveiBackoffice);
            
            log.info("EmiservBackofficeWsImpl :: Configurant per al codi de certificat : "  + codiCertificat);
            log.info("EmiservBackofficeWsImpl :: Configurant per al servei : "  + serveiBackoffice.getCodi());
            log.info("EmiservBackofficeWsImpl :: Client backoffice : "  + serveiBackoffice.getClient().getName());
            log.info("EmiservBackofficeWsImpl :: Propietats: Endpoint : "  + propietats.getEndpoint());
            log.info("EmiservBackofficeWsImpl :: Propietats: Usuari : "  + propietats.getUsuari());
            
            
            TransmisionDatos respuestaTransmisionDatos  =  new TransmisionDatos();
            
            String respuestaTransmisionDatosId = peticionAtributos.getIdPeticion(); 
            
            respuestaTransmisionDatos.setId(respuestaTransmisionDatosId);
            
            DatosGenericos respuestaDatosGenericos = new DatosGenericos();
            
            Emisor respuestaEmisor = peticionEmisor;
            Solicitante respuestaSolicitante = peticionSolicitante;
            // Attn rellenar
            Titular respuestaTitular = peticionTitular;
            Transmision respuestaTransmision = peticionTransmision;
            
            respuestaDatosGenericos.setEmisor(respuestaEmisor);
            respuestaDatosGenericos.setSolicitante(respuestaSolicitante);
            respuestaDatosGenericos.setTitular(respuestaTitular);
            respuestaDatosGenericos.setTransmision(respuestaTransmision);
            
            Class clazz = serveiBackoffice.getClient();
            
            String[] s = new String[]{};
            
            Class[] constructorParameters =  new Class[]{DatosGenericos.class, String.class, Propietats.class};
            Object[] parameters = new Object[]{respuestaDatosGenericos, strPeticionDatosEspecificos, propietats};
            
            
            String strRespuestaDatosEspecificos;
            
            try {
                CedentClient client = (CedentClient) clazz.getConstructor(constructorParameters).newInstance(parameters);
                log.info("EmiservBackofficeWsImpl :: Classe client instanciada per : "  + client.getClass().getName());
                client.peticionSincrona();
                strRespuestaDatosEspecificos = client.getStrRespuestaDatosEspecificos();
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(EmiservBackofficeWsImpl.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = peticionErronea(ERROR_DATOS_ESPECIFICOS,  "Error al tractar dades específiques");
                return respuesta;
            }
            
            log.info("EmiservBackofficeWsImpl :: Transmision: Respuesta Datos Especificos : "  + strRespuestaDatosEspecificos);
            
            Element respuestaDatosEspecificos = null;
            
            try {
                
                respuestaDatosEspecificos = stringToElement(strRespuestaDatosEspecificos);
                
                
                //respuestaDatosEspecificos = camelCaseToCamelCaseLower(respuestaDatosEspecificos);
                //respuestaDatosEspecificos.setAttribute(XMLConstants.XMLNS_ATTRIBUTE.concat(":ns2"), CedentClient.EMISERV_BACKOFFICE_XMLNS);
                //strRespuestaDatosEspecificos = elementToString(respuestaDatosEspecificos);
                //log.info("EmiservBackofficeWsImpl :: Transmision: Respuesta Datos Especificos Namespace: "  + strRespuestaDatosEspecificos);
                //respuestaDatosEspecificos = stringToElement(strRespuestaDatosEspecificos);
                //respuestaDatosEspecificos = XmlUtils.node2Element(respuestaDatosEspecificos);
                
            } catch (ParserConfigurationException | SAXException | IOException ex) {
                Logger.getLogger(EmiservBackofficeWsImpl.class.getName()).log(Level.SEVERE, null, ex);
                respuesta = peticionErronea(ERROR_DATOS_ESPECIFICOS,  "Error al tractar dades específiques");
                return respuesta;
            } catch (TransformerException ex) {
                Logger.getLogger(EmiservBackofficeWsImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            respuestaTransmisionDatos.setDatosGenericos(respuestaDatosGenericos);
            respuestaTransmisionDatos.setDatosEspecificos(respuestaDatosEspecificos);
            
            respuestaTransmisionesTransmisionDatos.add(respuestaTransmisionDatos);
            
        }
        
        Transmisiones respuestaTransmisiones = new Transmisiones();
        respuestaTransmisiones.setTransmisionDatos(respuestaTransmisionesTransmisionDatos);

        respuesta.setTransmisiones(respuestaTransmisiones);
        
        Atributos respuestaAtributos = new Atributos();
        
        respuestaAtributos.setCodigoCertificado(peticionAtributos.getCodigoCertificado());
        
        Estado respuestaAtributosEstado  = new Estado();
        
        respuestaAtributosEstado.setCodigoEstado(ErrorBackoffice.TRAMITADA.getEstat());
        //respuestaAtributosEstado.setCodigoEstadoSecundario(peticionAtributosEstado.getCodigoEstadoSecundario());
        respuestaAtributosEstado.setLiteralError(ErrorBackoffice.TRAMITADA.getCodi());
        //respuestaAtributosEstado.setTiempoEstimadoRespuesta(peticionAtributosEstado.getTiempoEstimadoRespuesta());
          
        respuestaAtributos.setEstado(respuestaAtributosEstado);
        respuestaAtributos.setIdPeticion(peticionAtributos.getIdPeticion());
        respuestaAtributos.setNumElementos(peticionAtributos.getNumElementos());
        respuestaAtributos.setTimeStamp(peticionAtributos.getTimeStamp());
        
        respuesta.setAtributos(respuestaAtributos);
        
        return respuesta;
    }

    @Override
    public ConfirmacionPeticion peticionAsincrona(Peticion peticion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Respuesta solicitarRespuesta(SolicitudRespuesta solicitudRespuesta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    Respuesta peticionErronea(ErrorBackoffice error, String literalError) {

        Respuesta respuesta = new Respuesta();

        SoapFaultAtributos soapFaultAtributos = new SoapFaultAtributos();
        Atributos atributos = soapFaultAtributos.getAtributos();
        Estado estado = new Estado();
        estado.setCodigoEstado(error.getEstat());
        estado.setLiteralError(literalError);
        atributos.setEstado(estado);
        respuesta.setAtributos(atributos);
        
        log.info("EmiservBackofficeWsImpl :: " + "codigoEstado = " + estado.getCodigoEstado() + "literalError = " + estado.getLiteralError());
        
        return respuesta;
        
    }
    
    
    
    private Element stringToElement(String xml) throws TransformerException, ParserConfigurationException, SAXException, IOException{
        return stringToElement(xml, Boolean.FALSE);
    }
    
   private Element stringToElement(String xml, boolean namespaceAware) throws TransformerException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setNamespaceAware(namespaceAware);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        StringReader reader = new StringReader(xml);
        InputSource inputSource = new InputSource(reader);
        Document doc = dBuilder.parse(inputSource);
        return doc.getDocumentElement();
    }

    
    private String elementToString(Element element) throws TransformerException {
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();
        StringWriter buffer = new StringWriter();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.transform(
                new DOMSource(element),
                new StreamResult(buffer));
        return buffer.toString();
    }
    
    
    private Element camelCaseToCamelCaseLower(Element element){
        
        Document document = element.getOwnerDocument();
        
        NodeList nl = element.getElementsByTagName("*");
        
        for (int i=0;i<nl.getLength();i++){
            Node n = nl.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE){
                String nombre = n.getNodeName();
                document.renameNode(n, n.getNodeName(), nombre.substring(0,1).toLowerCase() + nombre.substring(1));
            }
        }
        
        String xml = null;
        try {
            xml = elementToString(element);
            xml = xml.replaceAll(" xmlns=\".*\"", "");
        } catch (TransformerException ex) {
            Logger.getLogger(EmiservBackofficeWsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        log.info("EmiservBackofficeWsImpl :: Transmision: Respuesta Datos Especificos : Adaptado "  + xml);
      
        try {
            element  = stringToElement(xml);
        } catch (TransformerException | ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(EmiservBackofficeWsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return element;
    
    }
    
}
