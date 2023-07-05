/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.caib.emiservbackoffice.ws.specs;

import es.caib.emiservbackoffice.ws.cedent.SCDCPAJUv3Client;
import es.caib.emiservbackoffice.ws.cedent.SCDHPAJUv3Client;
import es.caib.emiservbackoffice.ws.cedent.SVDSCTFNWS01v3Client;

/**
 *
 * @author gdeignacio
 */
public enum ServeiBackoffice {
    
    SCDCPAJU("SCDCPAJUv3", SCDCPAJUv3Client.class),
    SCDHPAJU("SCDHPAJUv3", SCDHPAJUv3Client.class),
    SVDSCTFNWS01("SVDSCTFNWS01v3", SVDSCTFNWS01v3Client.class);
    
    private ServeiBackoffice(String codi, Class client){
        this.codi = codi;
        this.client = client;
    }
    
    private String codi;
    private Class client;
  

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public Class getClient() {
        return client;
    }

    public void setClient(Class client) {
        this.client = client;
    }
  

}
