/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.caib.emiservbackoffice.ws.cedent;

import org.springframework.http.MediaType;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;


/**
 *
 * @author gdeignacio
 */
public class SCDCPAJUv3CustomApiClient extends es.caib.scsp.api.cedent.client.SCDCPAJUv3.services.ApiClient {
 
    private RestTemplate restTemplate;
    
    public SCDCPAJUv3CustomApiClient() {
        this.restTemplate = buildRestTemplate();
        init();
    }
    
    @Autowired
    public SCDCPAJUv3CustomApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        init();
    }
    
    
     /**
     * Select the Accept header's value from the given accepts array:
     *     if JSON exists in the given array, use it;
     *     otherwise use all of them (joining into a string)
     *
     * @param accepts The accepts array to select from
     * @return List The list of MediaTypes to use for the Accept header
     */
    
    @Override
    public List<MediaType> selectHeaderAccept(String[] accepts) {
        if (accepts.length == 0) {
            return null;
        }
        for (String accept : accepts) {
            MediaType mediaType = MediaType.parseMediaType(accept);
            if (isJsonMime(mediaType)) {
                //return Collections.singletonList(mediaType);
                return Collections.singletonList(MediaType.APPLICATION_JSON_UTF8);
            }
        }
        return MediaType.parseMediaTypes(StringUtils.arrayToCommaDelimitedString(accepts));
    }

    /**
     * Select the Content-Type header's value from the given array:
     *     if JSON exists in the given array, use it;
     *     otherwise use the first one of the array.
     *
     * @param contentTypes The Content-Type array to select from
     * @return MediaType The Content-Type header to use. If the given array is empty, JSON will be used.
     */
    
    @Override
    public MediaType selectHeaderContentType(String[] contentTypes) {
        if (contentTypes.length == 0) {
            //return MediaType.APPLICATION_JSON;
            return MediaType.APPLICATION_JSON_UTF8;
        }
        for (String contentType : contentTypes) {
            MediaType mediaType = MediaType.parseMediaType(contentType);
            if (isJsonMime(mediaType)) {
                //return mediaType;
                return MediaType.APPLICATION_JSON_UTF8;
            }
        }
        return MediaType.parseMediaType(contentTypes[0]);
    }
    
    
    /**
     * Build the RestTemplate used to make HTTP requests.
     * @return RestTemplate
     */
    @Override
    protected RestTemplate buildRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        // This allows us to read the response more than once - Necessary for debugging.
        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(restTemplate.getRequestFactory()));
        
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        
        return restTemplate;
    }
    
}
