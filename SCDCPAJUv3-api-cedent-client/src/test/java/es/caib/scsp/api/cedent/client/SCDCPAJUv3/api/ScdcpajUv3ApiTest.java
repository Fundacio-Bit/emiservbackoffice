/**
 * SCDCPAJUv3
 * # This is a SCDCPAJUv3 server spec You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/). For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: pinbal@fundaciobit.org
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package es.caib.scsp.api.cedent.client.SCDCPAJUv3.api;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.ModelApiResponse;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Resultado;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;


import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.fundaciobit.pluginsib.utils.ssl.AuthenticatorReplacer;



/**
 * SCDCPAJUv3
 *
 * <p># This is a SCDCPAJUv3 server spec You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/). For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * API tests for ScdcpajUv3Api 
 */
public class ScdcpajUv3ApiTest {


    private ScdcpajUv3Api api;
    
    @Before
    public void setup() {
        JacksonJsonProvider provider = new JacksonJsonProvider();
        List providers = new ArrayList();
        providers.add(provider);
        
        // Replace 'user' and 'password' by the actual values
        String userpass = "pinbal".concat(":").concat("");
        String authorizationHeader = "Basic "
        + org.apache.cxf.common.util.Base64Utility.encode(userpass.getBytes());
        
        AuthenticatorReplacer.verifyHost();
        
        api = JAXRSClientFactory.create("https://10.0.0.45:8580/pinbal-services/rest/SCDCPAJUv3/peticionSincrona", ScdcpajUv3Api.class, providers);
        org.apache.cxf.jaxrs.client.Client client = WebClient.client(api).authorization(authorizationHeader);
        
        ClientConfiguration config = WebClient.getConfig(client);
        System.out.println(authorizationHeader);
        System.out.println(client.getHeaders().entrySet().toString());
        
        
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
        Solicitud body = null;
        //Resultado response = api.peticionSincrona(body);
        assertNotNull(body);
        // TODO: test validations
        
        
    }
}
