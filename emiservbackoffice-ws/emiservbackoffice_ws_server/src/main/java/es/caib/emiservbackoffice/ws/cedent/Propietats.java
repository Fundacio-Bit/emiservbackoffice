/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.caib.emiservbackoffice.ws.cedent;

import es.caib.emiservbackoffice.commons.config.PropertyFileConfigSource;
import es.caib.emiservbackoffice.ws.specs.ServeiBackoffice;

/**
 *
 * @author gdeignacio
 */
public class Propietats {
    
    public static String BASE_PROPERTY = "es.caib.emiservbackoffice.int.cedent";

    public Propietats(PropertyFileConfigSource cfg, ServeiBackoffice serveiBackoffice) {
        
        String baseProp = BASE_PROPERTY.concat(".").concat((serveiBackoffice!=null)?serveiBackoffice.getCodi():"");
        
        this.endpoint = cfg.getValue(baseProp.concat(".endpoint"));
        this.usuari = cfg.getValue(baseProp.concat(".usuari"));
        this.secret = cfg.getValue(baseProp.concat(".secret"));
        
    }
    
    private String endpoint;

    private String usuari;

    private String secret;

    
    public String getEndpoint() {
        return endpoint;
    }

    public String getUsuari() {
        return usuari;
    }

    public String getSecret() {
        return secret;
    }

    
}
