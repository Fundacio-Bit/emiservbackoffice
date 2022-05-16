/*
 * SCDCPAJUv3
 * # This is a SCDCPAJUv3 server spec You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/). For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: pinbal@fundaciobit.org
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.caib.scsp.api.cedent.client.SCDCPAJUv3.api;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.DatosPersonales;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Documentacion;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.ModelApiResponse;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Resultado;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Titular;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.services.auth.Authentication;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.services.auth.HttpBasicAuth;
import java.nio.charset.StandardCharsets;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.springframework.http.HttpHeaders;
import org.springframework.util.Base64Utils;

/**
 * API tests for ScdcpajUv3Api
 */

public class ScdcpajUv3ApiTest {

    //private final ScdcpajUv3Api api = new ScdcpajUv3Api();
    
    
    private ScdcpajUv3Api api;
    
    @Before
    public void setup() {
        
         api = new ScdcpajUv3Api();
         
         api.getApiClient().setBasePath("http://pinbalcedent:8580/pinbal-services/rest");
         
         api.getApiClient().setDebugging(true);
         
         String userpass = "pinbal".concat(":").concat("!puW6PHUQC%c");
         
         api.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString(userpass.getBytes(StandardCharsets.UTF_8)));
         
         //headerParams.add(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString(str.getBytes(StandardCharsets.UTF_8)));
         
           // Replace 'user' and 'password' by the actual values
        //String userpass = "pinbal".concat(":").concat("!puW6PHUQC%c");
        //String authorizationHeader = "Basic "
        //+ org.apache.cxf.common.util.Base64Utility.encode(userpass.getBytes());

        

         //api.getApiClient().setUsername("pinbal");
         //api.getApiClient().setPassword("!puW6PHUQC%c");
         
         
        
        //JacksonJsonProvider provider = new JacksonJsonProvider();
        //List providers = new ArrayList();
        //providers.add(provider);
        
        // Replace 'user' and 'password' by the actual values
        //String userpass = "pinbal".concat(":").concat("!puW6PHUQC%c");
        //String authorizationHeader = "Basic "
        //+ org.apache.cxf.common.util.Base64Utility.encode(userpass.getBytes());
        
        //AuthenticatorReplacer.verifyHost();
        
        //api = JAXRSClientFactory.create("http://pinbalcedent:8580/pinbal-services/rest", ScdcpajUv3Api.class, providers);
        //org.apache.cxf.jaxrs.client.Client client = WebClient.client(api).authorization(authorizationHeader);
        
        //ClientConfiguration config = WebClient.getConfig(client);
        //System.out.println(authorizationHeader);
        //System.out.println(client.getHeaders().entrySet().toString());
        
        //config.getInInterceptors().add(new LoggingInInterceptor());
        //config.getOutInterceptors().add(new LoggingOutInterceptor());
        
    }

    /**
     * Realitza una consulta al cedent
     *
     * Realitza una consulta al cedent
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void peticionSincronaTest() {
        //Solicitud body = null;
        //Resultado response = api.peticionSincrona(body);
        
        
        Solicitud body = new Solicitud();
        
        String provinciaSolicitud = "7";
        String municipioSolicitud = "26";
        
        body.setProvinciaSolicitud(provinciaSolicitud);
        body.setMunicipioSolicitud(municipioSolicitud);
        
        DatosPersonales datosPersonales = new DatosPersonales();
        Documentacion documentacion = new Documentacion();
        
        
        Documentacion.TipoEnum tipo = Documentacion.TipoEnum.NIF;
        String valor = "41438576M";
        
        documentacion.setTipo(tipo);
        documentacion.setValor(valor);
        
        
        
        System.out.println(datosPersonales);
        
        Titular titular;
        titular = new Titular();
        titular.setDocumentacion(documentacion);
        
        System.out.println(titular);
        
        body.setTitular(titular);
        
        assertNotNull(body);
        assertNotNull(titular);
        
        Resultado response = null;
       
            response = api.peticionSincrona(body);
            System.out.println(response.toString());
        //} catch (ResponseProcessingException e){
        //    System.out.println(e.getMessage());
        //}
        
        
        
        
        
        
        
        
        

        // TODO: test validations
    }
}
