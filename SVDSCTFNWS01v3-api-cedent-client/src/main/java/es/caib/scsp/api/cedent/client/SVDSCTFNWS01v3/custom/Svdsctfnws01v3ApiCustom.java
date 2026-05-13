package es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.custom;

import javax.ws.rs.core.GenericType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.api.Svdsctfnws01v3Api;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.ModelApiResponse;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Resultado;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Solicitud;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.services.ApiClient;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.services.ApiException;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.services.Pair;

public class Svdsctfnws01v3ApiCustom extends Svdsctfnws01v3Api {

  public Svdsctfnws01v3ApiCustom() {
    super(ConfigurationCustom.getDefaultApiClientCustom());
  }

  public Svdsctfnws01v3ApiCustom(ApiClientCustom apiClientCustom) {
    super(apiClientCustom);
  }

  public ApiClientCustom getApiClientCustom() {
    ApiClient apiClient = super.getApiClient();
    if (apiClient instanceof ApiClientCustom) {
      return (ApiClientCustom) apiClient;
    }
    throw new IllegalStateException("El ApiClient actual no es ApiClientCustom");
  }

  public void setApiClientCustom(ApiClientCustom apiClientCustom) {
    super.setApiClient(apiClientCustom);
  }

  @Override
  public void setApiClient(ApiClient apiClient) {
    if (!(apiClient instanceof ApiClientCustom)) {
      throw new IllegalArgumentException("Nomes s'accepta ApiClientCustom");
    }
    super.setApiClient(apiClient);
  }

  /**
   * Realitza una consulta al cedent
   * Realitza una consulta al cedent
   * @param body Dades de la consulta (required)
   * @return Resultado
   * @throws ApiException if fails to make API call
   */
  public Map<String, Object> peticionSincronaCustom(Solicitud body) throws ApiException {
    ApiClientCustom apiClientCustom = getApiClientCustom();
    Object localVarPostBody = body;
    // verify the required parameter 'body' is set
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling peticionSincrona");
    }
    // create path and map variables
    String localVarPath = "/SVDSCTFNWS01v3/peticionSincrona".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    final String[] localVarAccepts = {
      "application/json; charset=UTF-8", "text/plain; charset=UTF-8"
    };
    final String localVarAccept = apiClientCustom.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json; charset=UTF-8"
    };
    final String localVarContentType = apiClientCustom.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Resultado> localVarReturnType = new GenericType<Resultado>() {};
    GenericType<ModelApiResponse> localVarErrorType = new GenericType<ModelApiResponse>() {};

    return apiClientCustom.invokeAPICustom(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType, localVarErrorType);
  }
}
