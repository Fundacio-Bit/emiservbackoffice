package es.caib.scsp.api.cedent.client.SCDHPAJUv3.custom;

import java.io.IOException;
import java.text.DateFormat;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;

import org.jboss.logging.Logger;

import es.caib.scsp.api.cedent.client.SCDHPAJUv3.services.ApiClient;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.services.ApiException;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.services.Pair;

public class ApiClientCustom extends ApiClient {

  private static final Logger LOG = Logger.getLogger(ApiClientCustom.class);

  public ApiClientCustom() {
    super();
    LOG.debug("ApiClientCustom :: ApiClientCustom :: Creacio del client EmiservBackoffice");
  }

  @Override
  public ApiClientCustom setHttpClient(Client httpClient) {
    super.setHttpClient(httpClient);
    return this;
  }

  @Override
  public ApiClientCustom setBasePath(String basePath) {
    super.setBasePath(basePath);
    return this;
  }

  @Override
  public ApiClientCustom setUserAgent(String userAgent) {
    super.setUserAgent(userAgent);
    return this;
  }

  @Override
  public ApiClientCustom addDefaultHeader(String key, String value) {
    super.addDefaultHeader(key, value);
    return this;
  }

  @Override
  public ApiClientCustom setDebugging(boolean debugging) {
    super.setDebugging(debugging);
    return this;
  }

  @Override
  public ApiClientCustom setTempFolderPath(String tempFolderPath) {
    super.setTempFolderPath(tempFolderPath);
    return this;
  }

  @Override
  public ApiClientCustom setDateFormat(DateFormat dateFormat) {
    super.setDateFormat(dateFormat);
    return this;
  }

  @Override
  public <T> T invokeAPI(
      String path,
      String method,
      List<Pair> queryParams,
      Object body,
      Map<String, String> headerParams,
      Map<String, Object> formParams,
      String accept,
      String contentType,
      String[] authNames,
      GenericType<T> returnType) throws ApiException {

    Object requestBody = body;
    if (requestBody != null && contentType != null && isJsonMime(contentType) && !(requestBody instanceof String)) {
      try {
        // Forcam la serialitzacio JSON amb el mapper del client per respectar
        // WRITE_ENUMS_USING_TO_STRING i evitar serialitzacio del provider JAX-RS.
        requestBody = getJSON().getContext(null).writeValueAsString(requestBody);
      } catch (IOException ioEx) {
        throw new ApiException("No s'ha pogut serialitzar el body JSON", ioEx, 500, null);
      }
    }

    return super.invokeAPI(
        path,
        method,
        queryParams,
        requestBody,
        headerParams,
        formParams,
        accept,
        contentType,
        authNames,
        returnType);
  }
}
