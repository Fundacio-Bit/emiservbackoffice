package es.caib.emiservbackoffice.ws.api;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.11.redhat-00001
 * 2020-04-24T11:00:07.739+02:00
 * Generated source version: 3.2.11.redhat-00001
 *
 */
@WebServiceClient(name = "HelloWorldWithSecurityWsService",
                  wsdlLocation = "http://localhost:8080/emiservbackoffice-ws-server-1.0.0/HelloWorldWithSecurityWsService/HelloWorldWithSecurityWs?wsdl",
                  targetNamespace = "http://impl.ws.emiservbackoffice.caib.es/")
public class HelloWorldWithSecurityWsService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://impl.ws.emiservbackoffice.caib.es/", "HelloWorldWithSecurityWsService");
    public final static QName HelloWorldWithSecurityWs = new QName("http://impl.ws.emiservbackoffice.caib.es/", "HelloWorldWithSecurityWs");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/emiservbackoffice-ws-server-1.0.0/HelloWorldWithSecurityWsService/HelloWorldWithSecurityWs?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(HelloWorldWithSecurityWsService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/emiservbackoffice-ws-server-1.0.0/HelloWorldWithSecurityWsService/HelloWorldWithSecurityWs?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public HelloWorldWithSecurityWsService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public HelloWorldWithSecurityWsService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloWorldWithSecurityWsService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public HelloWorldWithSecurityWsService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public HelloWorldWithSecurityWsService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public HelloWorldWithSecurityWsService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns HelloWorldWithSecurityWs
     */
    @WebEndpoint(name = "HelloWorldWithSecurityWs")
    public HelloWorldWithSecurityWs getHelloWorldWithSecurityWs() {
        return super.getPort(HelloWorldWithSecurityWs, HelloWorldWithSecurityWs.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloWorldWithSecurityWs
     */
    @WebEndpoint(name = "HelloWorldWithSecurityWs")
    public HelloWorldWithSecurityWs getHelloWorldWithSecurityWs(WebServiceFeature... features) {
        return super.getPort(HelloWorldWithSecurityWs, HelloWorldWithSecurityWs.class, features);
    }

}
