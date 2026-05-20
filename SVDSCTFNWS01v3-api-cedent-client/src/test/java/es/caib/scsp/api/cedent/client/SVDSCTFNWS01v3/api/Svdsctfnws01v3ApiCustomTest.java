package es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.api;

import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.DatosAdicionalesTitular;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.DatosPersonales;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Documentacion;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.ModelApiResponse;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Resultado;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Solicitud;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.TituloFamiliaNumerosa;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.services.ApiClientCustom;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.services.ApiException;

import org.junit.Test;
import org.jboss.logging.Logger;
import java.util.Map;
import javax.ws.rs.ProcessingException;
import static org.junit.Assert.assertNotNull;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * API tests for Svdsctfnws01v3Api
 */

public class Svdsctfnws01v3ApiCustomTest {

    private static final Logger LOG = Logger.getLogger(Svdsctfnws01v3ApiCustomTest.class);

    private final Svdsctfnws01v3ApiCustom api = new Svdsctfnws01v3ApiCustom();
    

    /**
     * Realitza una consulta al cedent
     *
     * Realitza una consulta al cedent
     *
     * @throws Exception
     *          if the Api call fails
     */
    
    
    @Test
    public void peticionSincronaCustomTest() throws Exception {
        
        //Logger.getLogger(Svdsctfnws01v3ApiCustomTest.class.getName()).log(Level.INFO, "Entrando");
        
        ApiClientCustom apiClient =  api.getApiClientCustom();

        apiClient.setBasePath("http://Nautilus:48080/emiservcedentapi/externa");
        //apiClient.setBasePath("http://sdmi16209:48080/emiservcedentapi/externa");

        apiClient.setDebugging(true);

        String usuari = "pinbal";
        //String secret = "!puW6PHUQC%c";
        String secret = "";

        String userpass = usuari.concat(":").concat(secret);

        //apiClient.addDefaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString(userpass.getBytes(StandardCharsets.UTF_8)));

        Solicitud body = new Solicitud();
        
        String codigoComunidadAutonoma = "04";
        String numeroTitulo = null;
        String fechaConsulta = null;

        TituloFamiliaNumerosa tituloFamiliaNumerosa = new TituloFamiliaNumerosa();
        tituloFamiliaNumerosa.setCodigoComunidadAutonoma(codigoComunidadAutonoma);
        tituloFamiliaNumerosa.setNumeroTitulo(numeroTitulo);
        tituloFamiliaNumerosa.setFechaConsulta(fechaConsulta);

        body.setTituloFamiliaNumerosa(tituloFamiliaNumerosa);

        DatosAdicionalesTitular datosAdicionalesTitular = new DatosAdicionalesTitular();
        
        Documentacion documentacion = new Documentacion();
        
        Documentacion.TipoEnum tipo = Documentacion.TipoEnum.PASSAPORT;
        //String valor = "41504049C";
        String valor = "223301419";
        //String valor = "41503905Z";
        documentacion.setTipo(tipo);
        documentacion.setValor(valor);
        
        System.out.println(documentacion);

        DatosPersonales datosPersonales = new DatosPersonales();

        System.out.println(datosPersonales);

        datosAdicionalesTitular.setDocumentacion(documentacion);
        datosAdicionalesTitular.setDatosPersonales(datosPersonales);

        body.setTitular(datosAdicionalesTitular);

        assertNotNull(body);
        assertNotNull(datosAdicionalesTitular);
        
        Map<String, Object> response;

        Resultado resultado;
        ModelApiResponse modelApiResponse;
       
        try {

            LOG.info("Svdsctfnws01v3ApiCustomTest :: peticionSincronaCustomTest :: Consulta ") ;

            response = api.peticionSincronaCustom(body);

            LOG.info("Svdsctfnws01v3ApiCustomTest :: peticionSincronaCustomTest :: Response "  + response) ;

            resultado = (Resultado) response.get("returnType");
            modelApiResponse = (ModelApiResponse) response.get("errorType");
            
        } catch (ProcessingException ex) {

            //Logger.getLogger(Svdsctfnws01v3ApiCustomTest.class.getName()).log(Level.SEVERE, null, ex);
            LOG.error("Svdsctfnws01v3ApiCustomTest :: peticionSincronaCustomTest :: Error " + ex.getMessage(), ex) ;
            LOG.info("Svdsctfnws01v3ApiCustomTest :: peticionSincronaCustomTest :: No identificado ") ;
            
        } catch (ApiException ex) {
            System.out.println("Codigo: " +  api.getApiClientCustom().getStatusCode() + " " + ex.getMessage() + " " +  api.getApiClientCustom().getResponseHeaders());

            String jsonString = ex.getMessage();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            LOG.debug("Svdsctfnws01v3ApiCustomTest :: peticionSincronaCustomTest :: ApiException " + jsonNode) ;

            //System.out.println(jsonNode.get("code").asInt());
            //System.out.println(jsonNode.get("message").asText());

            //GenericType<ModelApiResponse> localVarReturnType = new GenericType<ModelApiResponse>() {};

        }

        
    }
}
