package es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.services;

import java.io.IOException;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

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

  /**
   * Invoke API by sending HTTP request with the given options and deserialize
   * either success or client error payloads using specific types.
   */
  public <T, E> Map<String, Object> invokeAPICustom(
      String path,
      String method,
      List<Pair> queryParams,
      Object body,
      Map<String, String> headerParams,
      Map<String, Object> formParams,
      String accept,
      String contentType,
      String[] authNames,
      GenericType<T> returnType,
      GenericType<E> errorType) throws ApiException {

    Object requestBody = body;
    if (requestBody != null && contentType != null && isJsonMime(contentType) && !(requestBody instanceof String)) {
      try {
        // Forcem la serialitzacio JSON amb el mapper configurat del client
        // (WRITE_ENUMS_USING_TO_STRING) per evitar que el provider JAX-RS
        // del servidor serialitzi enums amb el nom intern de la constant.
        requestBody = getJSON().getContext(null).writeValueAsString(requestBody);
      } catch (IOException ioEx) {
        throw new ApiException("No s'ha pogut serialitzar el body JSON", ioEx, 500, null);
      }
    }

    try {
      T returnTypeObject = super.invokeAPI(
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

      if (returnType == null) {
        return null;
      }

      Map<String, Object> responseMap = new HashMap<String, Object>();
      responseMap.put("returnType", returnTypeObject);
      LOG.debug("ApiClientCustom :: invokeAPICustom :: Response Map: " + responseMap);
      return responseMap;

    } catch (ApiException ex) {
      int statusCode = ex.getCode();
      LOG.debug("ApiClientCustom :: invokeAPICustom :: Response Status: " + statusCode);
      LOG.debug("ApiClientCustom :: invokeAPICustom :: Response Headers: " + ex.getResponseHeaders());

      if (Response.Status.Family.familyOf(statusCode).equals(Status.Family.CLIENT_ERROR)) {
        if (errorType == null) {
          return null;
        }

        String responseBody = ex.getResponseBody();
        if (responseBody != null && !responseBody.trim().isEmpty()) {
          try {
            E errorTypeObject = getJSON()
                .getContext(null)
                .readValue(responseBody, getJSON().getContext(null).constructType(errorType.getType()));
            Map<String, Object> responseMap = new HashMap<String, Object>();
            responseMap.put("errorType", errorTypeObject);
            LOG.debug("ApiClientCustom :: invokeAPICustom :: Response Map: " + responseMap);
            return responseMap;
          } catch (IOException ioEx) {
            String message = ioEx.getMessage();
            if (responseBody != null && !responseBody.trim().isEmpty()) {
              message = responseBody;
            }
            throw new ApiException(message, ioEx, statusCode, ex.getResponseHeaders(), responseBody);
          }
        }
      }

      throw ex;
    }
  }
}
