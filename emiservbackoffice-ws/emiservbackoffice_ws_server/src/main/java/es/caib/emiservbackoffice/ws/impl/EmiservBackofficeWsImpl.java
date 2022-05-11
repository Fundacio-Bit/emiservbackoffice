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
import es.caib.emiservbackoffice.ws.specs.ErrorBackoffice;
import static es.caib.emiservbackoffice.ws.specs.ErrorBackoffice.FALTA_ATRIBUTOS;
import static es.caib.emiservbackoffice.ws.specs.ErrorBackoffice.FALTA_SOLICITUD;
import static es.caib.emiservbackoffice.ws.specs.ErrorBackoffice.MULTIPLES_SOLICITUDS;
import static es.caib.emiservbackoffice.ws.specs.ErrorBackoffice.SCHEMA_INCORRECTE;

import es.caib.emiservbackoffice.ws.utils.BaseWsImpl;
import es.caib.emiservbackoffice.ws.utils.WsI18NException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

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
            
            log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Id :"  + peticionSolicitudTransmisionId);
            
            DatosGenericos peticionDatosGenericos = peticionSolicitudTransmision.getDatosGenericos();
            
            Object peticionDatosEspecificos = peticionSolicitudTransmision.getDatosEspecificos();
           
            Emisor peticionEmisor = peticionDatosGenericos.getEmisor();
            log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Emisor :"  + peticionEmisor.toString());
            Solicitante peticionSolicitante = peticionDatosGenericos.getSolicitante();
            log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Solicitante :"  + peticionSolicitante.toString());
            Titular peticionTitular = peticionDatosGenericos.getTitular();
            log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Titular :"  + peticionTitular.toString());
            Transmision peticionTransmision = peticionDatosGenericos.getTransmision();
            log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Transmision :"  + peticionTransmision.toString());

            Consentimiento peticionSolicitanteConsentimiento = peticionSolicitante.getConsentimiento();
            log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Consentimiento :"  + peticionSolicitanteConsentimiento.toString());
            Funcionario peticionSolicitanteFuncionario = peticionSolicitante.getFuncionario();
            log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Funcionario :"  + peticionSolicitanteFuncionario.toString());
            Procedimiento peticionSolicitanteProcedimiento = peticionSolicitante.getProcedimiento();
            log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: Procedimiento :"  + peticionSolicitanteProcedimiento.toString());
            TipoDocumentacion peticionTitularTipoDocumentacion = peticionTitular.getTipoDocumentacion();
            
            if (peticionTitularTipoDocumentacion==null) {
                log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: TipoDocumentacion : Petició no subministra informació del titular.");
            } else{
                log.info("EmiservBackofficeWsImpl :: SolicitudTransmision: TipoDocumentacion :"  + peticionTitularTipoDocumentacion.toString());
            }
            
            // Secció de tractament de la resposta
            
            TransmisionDatos respuestaTransmisionDatos  =  new TransmisionDatos();
            
            respuestaTransmisionDatos.setId(peticionSolicitudTransmisionId);
            
            DatosGenericos respuestaDatosGenericos = new DatosGenericos();
            
            Emisor respuestaEmisor = peticionEmisor;
            Solicitante respuestaSolicitante = peticionSolicitante;
            Titular respuestaTitular = peticionTitular;
            Transmision respuestaTransmision = peticionTransmision;
            
            respuestaDatosGenericos.setEmisor(respuestaEmisor);
            respuestaDatosGenericos.setSolicitante(respuestaSolicitante);
            respuestaDatosGenericos.setTitular(respuestaTitular);
            respuestaDatosGenericos.setTransmision(respuestaTransmision);
            
            respuestaTransmisionDatos.setDatosGenericos(respuestaDatosGenericos);
            
            
            
            respuestaTransmisionesTransmisionDatos.add(respuestaTransmisionDatos);
            
        }
        
        Transmisiones respuestaTransmisiones = new Transmisiones();
        respuestaTransmisiones.setTransmisionDatos(respuestaTransmisionesTransmisionDatos);

        respuesta.setTransmisiones(respuestaTransmisiones);
        
        Atributos respuestaAtributos = new Atributos();
        
        respuestaAtributos.setCodigoCertificado(peticionAtributos.getCodigoCertificado());
        
        Estado respuestaAtributosEstado  = new Estado();
        
        respuestaAtributosEstado.setCodigoEstado(peticionAtributosEstado.getCodigoEstado());
        respuestaAtributosEstado.setCodigoEstadoSecundario(peticionAtributosEstado.getCodigoEstadoSecundario());
        respuestaAtributosEstado.setLiteralError(peticionAtributosEstado.getLiteralError());
        respuestaAtributosEstado.setTiempoEstimadoRespuesta(peticionAtributosEstado.getTiempoEstimadoRespuesta());
          
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
    
 
    
    
}
