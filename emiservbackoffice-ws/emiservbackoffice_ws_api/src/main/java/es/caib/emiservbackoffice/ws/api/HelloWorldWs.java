package es.caib.emiservbackoffice.ws.api;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.12.redhat-00001
 * 2021-11-18T18:58:38.956+01:00
 * Generated source version: 3.2.12.redhat-00001
 *
 */
@WebService(targetNamespace = "http://impl.ws.emiservbackoffice.caib.es/", name = "HelloWorldWs")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWorldWs {

    @WebMethod
    @WebResult(name = "return", targetNamespace = "http://impl.ws.emiservbackoffice.caib.es/", partName = "return")
    public java.lang.String echo(
        @WebParam(partName = "echo", name = "echo")
        java.lang.String echo
    ) throws WsI18NException;

    @WebMethod
    @WebResult(name = "return", targetNamespace = "http://impl.ws.emiservbackoffice.caib.es/", partName = "return")
    public java.lang.String getVersion();
}
