/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.caib.emiservbackoffice.ws.cedent;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.api.ScdcpajUv3Api;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author gdeignacio
 */
public class SCDCPAJUv3CustomApi extends ScdcpajUv3Api {
    
    public SCDCPAJUv3CustomApi() {
        this(new SCDCPAJUv3CustomApiClient());
    }

    @Autowired
    public SCDCPAJUv3CustomApi(SCDCPAJUv3CustomApiClient apiClient) {
        super();
        super.setApiClient(apiClient);
    }
   
}
