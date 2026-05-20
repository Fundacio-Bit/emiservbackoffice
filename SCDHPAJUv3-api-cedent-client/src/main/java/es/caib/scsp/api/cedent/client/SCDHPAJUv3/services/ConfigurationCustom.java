package es.caib.scsp.api.cedent.client.SCDHPAJUv3.services;

public class ConfigurationCustom extends Configuration {

  private static ApiClientCustom defaultApiClientCustom = new ApiClientCustom();

  /**
   * Get the default custom API client used by custom API wrappers.
   */
  public static ApiClientCustom getDefaultApiClientCustom() {
    return defaultApiClientCustom;
  }

  /**
   * Set the default custom API client used by custom API wrappers.
   */
  public static void setDefaultApiClientCustom(ApiClientCustom apiClientCustom) {
    defaultApiClientCustom = apiClientCustom;
    Configuration.setDefaultApiClient(apiClientCustom);
  }

  /**
   * Bridge with generated Configuration API. Keeps both defaults aligned.
   */
  public static void setDefaultApiClient(ApiClient apiClient) {
    if (!(apiClient instanceof ApiClientCustom)) {
      throw new IllegalArgumentException("Nomes s'accepta ApiClientCustom");
    }
    defaultApiClientCustom = (ApiClientCustom) apiClient;
    Configuration.setDefaultApiClient(apiClient);
  }
}
