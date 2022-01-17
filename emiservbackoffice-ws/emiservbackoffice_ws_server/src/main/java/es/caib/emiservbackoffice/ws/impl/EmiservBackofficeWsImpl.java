package es.caib.emiservbackoffice.ws.impl;

import es.caib.emiserv.logic.intf.service.ws.backoffice.Atributos;
import es.caib.emiserv.logic.intf.service.ws.backoffice.ConfirmacionPeticion;
import es.caib.emiserv.logic.intf.service.ws.backoffice.DatosGenericos;
import es.caib.emiserv.logic.intf.service.ws.backoffice.EmiservBackoffice;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Emisor;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Peticion;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Respuesta;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Solicitante;
import es.caib.emiserv.logic.intf.service.ws.backoffice.SolicitudRespuesta;
import es.caib.emiserv.logic.intf.service.ws.backoffice.SolicitudTransmision;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Solicitudes;
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
        
        Respuesta respuesta = new Respuesta();
        
        Transmisiones respuestaTransmisiones = new Transmisiones();
        
        List<TransmisionDatos> listRespuestaTransmisionDatos = new ArrayList<TransmisionDatos>();
        
        
        
        Atributos atributos = peticion.getAtributos();
        
        String codigoCertificado = atributos.getCodigoCertificado();
        String idPeticion = atributos.getIdPeticion();
        String numElementos = atributos.getNumElementos();
        String timeStamp = atributos.getTimeStamp();
        
        Solicitudes solicitudes = peticion.getSolicitudes();
        ArrayList<SolicitudTransmision> listSolicitudTransmision = solicitudes.getSolicitudTransmision();
        
        for (SolicitudTransmision solicitudTransmision:listSolicitudTransmision){
            
            DatosGenericos datosGenericos = solicitudTransmision.getDatosGenericos();
            
            Emisor emisor = datosGenericos.getEmisor();
            
            String nifEmisor = emisor.getNifEmisor();
            String nombreEmisor = emisor.getNombreEmisor();
            
            Solicitante solicitante = datosGenericos.getSolicitante();
            
            Titular titular = datosGenericos.getTitular();
            Transmision transmision = datosGenericos.getTransmision();
            
            
            break;
        }
        
        
        
        
        
      
        
        
        
        
        
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
