/*
 * SCDHPAJUv3
 * # This is a SCDHPAJUv3 server spec You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/). For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: pinbal@fundaciobit.org
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.caib.scsp.api.cedent.client.SCDHPAJUv3.api;

import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.ModelApiResponse;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Resultado;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Solicitud;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * API tests for ScdhpajUv3Api
 */
@Ignore
public class ScdhpajUv3ApiTest {

    private final ScdhpajUv3Api api = new ScdhpajUv3Api();

    /**
     * Realitza una consulta al cedent
     *
     * Realitza una consulta al cedent
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void peticionSincronaTest() throws Exception {
        Solicitud body = null;
        Resultado response = api.peticionSincrona(body);

        // TODO: test validations
    }
}
