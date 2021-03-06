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
 * 2020-04-24T11:00:01.603+02:00
 * Generated source version: 3.2.11.redhat-00001
 *
 */
@WebServiceClient(name = "HelloWorldWsService",
                  wsdlLocation = "http://localhost:8080/emiservbackoffice-ws-server-1.0.0/HelloWorldWsService/HelloWorldWs?wsdl",
                  targetNamespace = "http://impl.ws.emiservbackoffice.caib.es/")
public class HelloWorldWsService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://impl.ws.emiservbackoffice.caib.es/", "HelloWorldWsService");
    public final static QName HelloWorldWs = new QName("http://impl.ws.emiservbackoffice.caib.es/", "HelloWorldWs");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/emiservbackoffice-ws-server-1.0.0/HelloWorldWsService/HelloWorldWs?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(HelloWorldWsService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/emiservbackoffice-ws-server-1.0.0/HelloWorldWsService/HelloWorldWs?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public HelloWorldWsService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public HelloWorldWsService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloWorldWsService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public HelloWorldWsService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public HelloWorldWsService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public HelloWorldWsService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns HelloWorldWs
     */
    @WebEndpoint(name = "HelloWorldWs")
    public HelloWorldWs getHelloWorldWs() {
        return super.getPort(HelloWorldWs, HelloWorldWs.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloWorldWs
     */
    @WebEndpoint(name = "HelloWorldWs")
    public HelloWorldWs getHelloWorldWs(WebServiceFeature... features) {
        return super.getPort(HelloWorldWs, HelloWorldWs.class, features);
    }

}
