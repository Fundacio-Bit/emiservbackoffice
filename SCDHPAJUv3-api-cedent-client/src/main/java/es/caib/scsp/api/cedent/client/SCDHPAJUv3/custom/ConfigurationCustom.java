package es.caib.scsp.api.cedent.client.SCDHPAJUv3.custom;

/**
 * Static holder para el cliente API custom default.
 * Permite acceder al ApiClientCustom de manera centralizada.
 */
public class ConfigurationCustom {
    private static ApiClientCustom defaultApiClientCustom;

    public static ApiClientCustom getDefaultApiClientCustom() {
        if (defaultApiClientCustom == null) {
            defaultApiClientCustom = new ApiClientCustom();
        }
        return defaultApiClientCustom;
    }

    public static void setDefaultApiClientCustom(ApiClientCustom apiClient) {
        defaultApiClientCustom = apiClient;
    }
}
