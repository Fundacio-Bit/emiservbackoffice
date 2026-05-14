package es.caib.scsp.api.cedent.client.SCDCPAJUv3.custom;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.api.Scdcpajuv3Api;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Resultado;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.services.ApiClient;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.services.ApiException;

public class Scdcpajuv3ApiCustom extends Scdcpajuv3Api {

  public Scdcpajuv3ApiCustom() {
    super(ConfigurationCustom.getDefaultApiClientCustom());
  }

  public Scdcpajuv3ApiCustom(ApiClientCustom apiClientCustom) {
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

  // Variante custom mantenint el mateix resultat que l'API generada.
  public Resultado peticionSincronaCustom(Solicitud body) throws ApiException {
    return super.peticionSincrona(body);
  }
}
