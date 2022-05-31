package es.caib.scsp.api.cedent.client.SCDCPAJUv3.api;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.services.ApiClient;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.ModelApiResponse;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Resultado;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@Component("es.caib.scsp.api.cedent.client.SCDCPAJUv3.api.ScdcpajUv3Api")
public class ScdcpajUv3Api {
    private ApiClient apiClient;

    public ScdcpajUv3Api() {
        this(new ApiClient());
    }

    @Autowired
    public ScdcpajUv3Api(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Realitza una consulta al cedent
     * Realitza una consulta al cedent
     * <p><b>200</b> - Petició processada
     * <p><b>400</b> - Petició errònia
     * <p><b>0</b> - Codi de resposta incorrecte
     * @param body Dades de la consulta
     * @return Resultado
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Resultado peticionSincrona(Solicitud body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling peticionSincrona");
        }
        String path = UriComponentsBuilder.fromPath("/SCDCPAJUv3/peticionSincrona").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json; charset&#x3D;UTF-8", "text/plain; charset&#x3D;UTF-8"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json; charset&#x3D;UTF-8"
         };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Resultado> returnType = new ParameterizedTypeReference<Resultado>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
