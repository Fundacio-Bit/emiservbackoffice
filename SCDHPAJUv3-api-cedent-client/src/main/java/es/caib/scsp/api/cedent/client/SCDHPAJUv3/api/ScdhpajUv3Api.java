package es.caib.scsp.api.cedent.client.SCDHPAJUv3.api;

import es.caib.scsp.api.cedent.client.SCDHPAJUv3.services.ApiException;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.services.ApiClient;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.services.Configuration;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.services.Pair;

import javax.ws.rs.core.GenericType;

import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.ModelApiResponse;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Resultado;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Solicitud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScdhpajUv3Api {
  private ApiClient apiClient;

  public ScdhpajUv3Api() {
    this(Configuration.getDefaultApiClient());
  }

  public ScdhpajUv3Api(ApiClient apiClient) {
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
   * @param body Dades de la consulta (required)
   * @return Resultado
   * @throws ApiException if fails to make API call
   */
  public Resultado peticionSincrona(Solicitud body) throws ApiException {
    Object localVarPostBody = body;
    // verify the required parameter 'body' is set
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling peticionSincrona");
    }
    // create path and map variables
    String localVarPath = "/SCDHPAJUv3/peticionSincrona".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    final String[] localVarAccepts = {
      "application/json; charset=UTF-8", "text/plain; charset=UTF-8"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json; charset=UTF-8"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Resultado> localVarReturnType = new GenericType<Resultado>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
  }
}
