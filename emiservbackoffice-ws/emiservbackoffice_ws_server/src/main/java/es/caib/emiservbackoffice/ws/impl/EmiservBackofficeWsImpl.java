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
//import es.caib.emiservbackoffice.service.facade.EmiservBackofficeServiceFacade;
import es.caib.emiservbackoffice.ws.utils.BaseWsImpl;
import es.caib.emiservbackoffice.ws.utils.WsI18NException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

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

    public static final String NAME = "EmiservBackoffice";

    public static final String NAME_WS = NAME + "Ws";
    
    //@EJB
    //EmiservBackofficeServiceFacade emiservBackofficeService;

    @WebMethod
    public String echo(@WebParam(name = "echo") String echo) throws WsI18NException {
        log.info("EmiservBackofficeWsImpl :: echo = " + echo);
        return echo;
    }

    @Override
    public Respuesta peticionSincrona(Peticion peticion) {

        if (peticion==null) return null;
        
        Atributos peticionAtributos = peticion.getAtributos();
        
        Estado peticionAtributosEstado = peticionAtributos.getEstado();
        
        Solicitudes peticionSolicitudes = peticion.getSolicitudes();
        
        if (peticionSolicitudes==null) return null;
        
        DatosGenericos peticionDatosGenericos;
        Object peticionDatosEspecificos;
        
        Emisor peticionEmisor;
        Solicitante peticionSolicitante;
        Titular peticionTitular;
        Transmision peticionTransmision;
        
        Consentimiento peticionSolicitanteConsentimiento;
        Funcionario peticionSolicitanteFuncionario;
        Procedimiento peticionSolicitanteProcedimiento;
        
        TipoDocumentacion peticionTitularTipoDocumentacion;
        
        
        ArrayList<SolicitudTransmision> peticionSolicitudesSolicitudTransmision = peticionSolicitudes.getSolicitudTransmision();
        
        if (peticionSolicitudesSolicitudTransmision==null) return null;
        
        for (SolicitudTransmision peticionSolicitudTransmision : peticionSolicitudesSolicitudTransmision) {

            peticionDatosGenericos = peticionSolicitudTransmision.getDatosGenericos();
            peticionDatosEspecificos = peticionSolicitudTransmision.getDatosEspecificos();

            peticionEmisor = peticionDatosGenericos.getEmisor();
            peticionSolicitante = peticionDatosGenericos.getSolicitante();
            peticionTitular = peticionDatosGenericos.getTitular();
            peticionTransmision = peticionDatosGenericos.getTransmision();

            peticionSolicitanteConsentimiento = peticionSolicitante.getConsentimiento();
            peticionSolicitanteFuncionario = peticionSolicitante.getFuncionario();
            peticionSolicitanteProcedimiento = peticionSolicitante.getProcedimiento();

            peticionTitularTipoDocumentacion = peticionTitular.getTipoDocumentacion();
            
            
            

        }
        
        Atributos respuestaAtributos = new Atributos();
        
        respuestaAtributos.setCodigoCertificado(peticionAtributos.getCodigoCertificado());
        respuestaAtributos.setIdPeticion(peticionAtributos.getIdPeticion());
        
        
        
        
        Respuesta respuesta = new Respuesta();
        
        Transmisiones respuestaTransmisiones = new Transmisiones();
        
        List<TransmisionDatos> listRespuestaTransmisionDatos = new ArrayList<TransmisionDatos>();
        
      
        
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

}
