package es.caib.emiservbackoffice.ws.impl;

import es.caib.emiserv.logic.intf.service.ws.backoffice.ConfirmacionPeticion;
import es.caib.emiserv.logic.intf.service.ws.backoffice.EmiservBackoffice;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Peticion;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Respuesta;
import es.caib.emiserv.logic.intf.service.ws.backoffice.SolicitudRespuesta;
import es.caib.emiservbackoffice.service.facade.EmiservBackofficeServiceFacade;
import es.caib.emiservbackoffice.ws.utils.BaseWsImpl;
import es.caib.emiservbackoffice.ws.utils.WsI18NException;
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
    
    @EJB
    EmiservBackofficeServiceFacade emiservBackofficeService;

    @WebMethod
    public String echo(@WebParam(name = "echo") String echo) throws WsI18NException {
        log.info("EmiservBackofficeWsImpl :: echo = " + echo);
        return echo;
    }

    @Override
    public Respuesta peticionSincrona(Peticion peticion) {
        
        Respuesta respuesta = new Respuesta();
        
        
        
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
