/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.caib.emiservbackoffice.ws.specs;

import es.caib.emiservbackoffice.ws.cedent.SCDCPAJUv3Client;
import es.caib.emiservbackoffice.ws.cedent.SCDHPAJUv3Client;

/**
 *
 * @author gdeignacio
 */
public enum ServeiBackoffice {
    
    SCDCPAJU("SCDCPAJUv3", SCDCPAJUv3Client.class, null),
    SCDHPAJU("SCDHPAJUv3", SCDHPAJUv3Client.class, null);
    
    
    private ServeiBackoffice(String codi, Class client, Class schema){
        this.codi = codi;
        this.client = client;
        this.schema = schema;
    }
    
    private String codi;
    private Class client;
    private Class schema;

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

    public Class getSchema() {
        return schema;
    }

    public void setSchema(Class schema) {
        this.schema = schema;
    }

    

}
