# ScdcpajUv3Api

All URIs are relative to *http://emiservbackoffice.fundaciobit.org:8080/emiservbackofficeapi/externa/services*

Method | HTTP request | Description
------------- | ------------- | -------------
[**peticionSincrona**](ScdcpajUv3Api.md#peticionSincrona) | **POST** /SCDCPAJUv3/peticionSincrona | Realitza una consulta al cedent

<a name="peticionSincrona"></a>
# **peticionSincrona**
> Resultado peticionSincrona(body)

Realitza una consulta al cedent

Realitza una consulta al cedent

### Example
```java
// Import classes:
//import es.caib.scsp.api.cedent.client.SCDCPAJUv3.services.ApiException;
//import es.caib.scsp.api.cedent.client.SCDCPAJUv3.api.ScdcpajUv3Api;


ScdcpajUv3Api apiInstance = new ScdcpajUv3Api();
Solicitud body = new Solicitud(); // Solicitud | Dades de la consulta
try {
    Resultado result = apiInstance.peticionSincrona(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScdcpajUv3Api#peticionSincrona");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Solicitud**](Solicitud.md)| Dades de la consulta |

### Return type

[**Resultado**](Resultado.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json; charset=UTF-8
 - **Accept**: application/json; charset=UTF-8, text/plain; charset=UTF-8

