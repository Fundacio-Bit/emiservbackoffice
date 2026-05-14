package es.caib.scsp.api.cedent.client.SCDHPAJUv3.custom;

import es.caib.scsp.api.cedent.client.SCDHPAJUv3.api.Scdhpajuv3Api;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Resultado;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Solicitud;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.services.ApiClient;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.services.ApiException;

/**
 * Custom API wrapper que extiende Scdhpajuv3Api para:
 * 1. Forzar el uso de ApiClientCustom (con serialización personnalizadas)
 * 2. Exponer un método peticionSincronaCustom() que delega al método base
 * 3. Proteger contra inyección de ApiClient incorrecto
 */
public class Scdhpajuv3ApiCustom extends Scdhpajuv3Api {

    public Scdhpajuv3ApiCustom() {
        super(ConfigurationCustom.getDefaultApiClientCustom());
    }

    public Scdhpajuv3ApiCustom(ApiClientCustom apiClient) {
        super(apiClient);
    }

    /**
     * Override de setApiClient que valida que el cliente sea ApiClientCustom.
     * Esto previene que se inyecte un ApiClient incorrecto en tiempo de ejecución.
     */
    @Override
    public void setApiClient(ApiClient apiClient) {
        if (!(apiClient instanceof ApiClientCustom)) {
            throw new IllegalArgumentException(
                "Scdhpajuv3ApiCustom requiere un ApiClientCustom, no " + 
                (apiClient != null ? apiClient.getClass().getSimpleName() : "null"));
        }
        super.setApiClient(apiClient);
    }

    /**
     * Obtiene el cliente API de forma segura con type-casting.
     */
    public ApiClientCustom getApiClientCustom() {
        ApiClient client = super.getApiClient();
        if (!(client instanceof ApiClientCustom)) {
            throw new IllegalStateException(
                "ApiClient no es una instancia de ApiClientCustom: " + 
                (client != null ? client.getClass().getName() : "null"));
        }
        return (ApiClientCustom) client;
    }

    /**
     * Método custom que delega a peticionSincrona() con type-safety.
     * Devuelve Resultado directamente (sin Map wrapper).
     */
    public Resultado peticionSincronaCustom(Solicitud body) throws ApiException {
        return super.peticionSincrona(body);
    }
}
