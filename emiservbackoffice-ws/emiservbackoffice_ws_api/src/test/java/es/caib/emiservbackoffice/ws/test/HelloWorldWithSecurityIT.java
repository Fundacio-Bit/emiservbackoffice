package es.caib.emiservbackoffice.ws.test;

import es.caib.emiservbackoffice.ws.api.HelloWorldWithSecurityWs;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test de petició a WebService autenticada.
 * TODO: pendent de si es pot integrar JAX-WS amb mòdul EJB amb keycloak (areus)
 *
 * @author anadal
 */
@Ignore
public class HelloWorldWithSecurityIT {

    protected static HelloWorldWithSecurityWs helloWorldWithSecurityApi;

    /**
     * S'executa una vegada abans de l'execució de tots els tests d'aquesta classe
     *
     * @throws Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        helloWorldWithSecurityApi = TestUtils.getHelloWorldWithSecurityApi();
    }

    @Test
    public void testVersio() throws Exception {
        Assert.assertEquals("1.0.0", helloWorldWithSecurityApi.getVersion());
    }

    @Test
    public void testEcho() throws Exception {
        final String echo = "eco ecooooo";
        Assert.assertEquals(echo, helloWorldWithSecurityApi.echo(echo));
    }
}
