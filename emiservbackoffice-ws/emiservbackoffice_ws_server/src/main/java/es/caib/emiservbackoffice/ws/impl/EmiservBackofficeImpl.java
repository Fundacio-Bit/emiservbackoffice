package es.caib.emiservbackoffice.ws.impl;

import es.caib.emiservbackoffice.ws.utils.BaseWsImpl;
import es.caib.emiservbackoffice.ws.utils.WsI18NException;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import es.caib.emiserv.logic.intf.service.ws.backoffice.EmiservBackoffice;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Peticion;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Respuesta;
import es.caib.emiserv.logic.intf.service.ws.backoffice.ConfirmacionPeticion;
import es.caib.emiserv.logic.intf.service.ws.backoffice.SolicitudRespuesta;
import es.caib.emiservbackoffice.service.facade.BackofficeLogicServiceFacade;
import javax.ejb.EJB;

/**
 * @author gdeignacio
 */
@Stateless(name = EmiservBackofficeImpl.NAME + "Ejb")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebService(
        name = EmiservBackofficeImpl.NAME_WS,
        portName = EmiservBackofficeImpl.NAME_WS,
        serviceName = EmiservBackofficeImpl.NAME_WS + "Service",
        targetNamespace = "http://caib.es/emiserv/backoffice")
public class EmiservBackofficeImpl extends BaseWsImpl implements EmiservBackoffice {
    
    @EJB
    private BackofficeLogicServiceFacade backofficeLogicService;

    public static final String NAME = "EmiservBackoffice";

    public static final String NAME_WS = NAME + "Ws";

    @WebMethod
    public String echo(@WebParam(name = "echo") String echo) throws WsI18NException {
        log.info("EmiservBackofficeImpl :: echo = " + echo);
        return echo;
    }
    
    
    @WebMethod
    @Override
    public Respuesta peticionSincrona(Peticion peticion) {
        
        String echo = peticion.toString();
        log.info("EmiservBackofficeImpl :: peticion = " + echo);
        
        Respuesta respuesta = backofficeLogicService.peticionSincrona(peticion);
        
        return respuesta
    }
    
    @WebMethod
    @Override
    public ConfirmacionPeticion peticionAsincrona(Peticion peticion) {

        return new ConfirmacionPeticion();

    }

    @WebMethod
    @Override
    public Respuesta solicitarRespuesta(SolicitudRespuesta solicitudRespuesta) {
     
        return new Respuesta();
    }
    
      

}
