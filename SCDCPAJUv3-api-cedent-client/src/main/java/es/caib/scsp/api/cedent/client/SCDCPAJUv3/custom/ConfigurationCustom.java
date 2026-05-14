package es.caib.scsp.api.cedent.client.SCDCPAJUv3.custom;

public class ConfigurationCustom {
  private static ApiClientCustom defaultApiClientCustom = new ApiClientCustom();

  public static ApiClientCustom getDefaultApiClientCustom() {
    return defaultApiClientCustom;
  }

  public static void setDefaultApiClient(ApiClientCustom apiClientCustom) {
    defaultApiClientCustom = apiClientCustom;
  }
}
