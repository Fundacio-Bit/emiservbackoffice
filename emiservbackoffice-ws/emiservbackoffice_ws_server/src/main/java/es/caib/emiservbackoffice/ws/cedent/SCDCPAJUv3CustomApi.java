/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.caib.emiservbackoffice.ws.cedent;


import es.caib.scsp.api.cedent.client.SCDCPAJUv3.api.ScdcpajUv3Api;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.services.ApiClient;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.ModelApiResponse;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Resultado;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

/**
 *
 * @author gdeignacio
 */
public class SCDCPAJUv3CustomApi extends ScdcpajUv3Api {
    
    private SCDCPAJUv3CustomApiClient apiClient;

    public SCDCPAJUv3CustomApi() {
        this(new SCDCPAJUv3CustomApiClient());
    }

    @Autowired
    public SCDCPAJUv3CustomApi(SCDCPAJUv3CustomApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public ApiClient getApiClient() {
        return apiClient;
    }

    @Override
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = (SCDCPAJUv3CustomApiClient) apiClient;
    }
    
   
}
