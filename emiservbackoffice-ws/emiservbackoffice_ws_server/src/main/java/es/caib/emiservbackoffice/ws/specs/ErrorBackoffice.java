/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.caib.emiservbackoffice.ws.specs;

/**
 *
 * @author gdeignacio
 */
public enum ErrorBackoffice {
    
    TRAMITADA("TRAMITADA","0003"),
    DOS_O_MES("DOS_O_MES","0232"),
    NO_IDENTIFICAT("NO_IDENTIFICAT","0233"),
    NOT_DISPONIBLE("NOT_DISPONIBLE","0238"),
    SCHEMA_INCORRECTE ("ESQUEMA_INCORRECTE","0401"),
    FALTA_SOLICITUD("FALTA_SOLICITUD","0401"),
    FALTA_ATRIBUTOS("FALTA_ATRIBUTOS","0401"),
    FALTA_CERTIFICAT("FALTA_CERTIFICAT","0234"),
    MULTIPLES_SOLICITUDS("MULTIPLES_SOLICITUDS", "0415"),
    ERROR_DATOS_ESPECIFICOS("ERROR_DATOS_ESPECIFICOS","0239"),
    ERROR_BACKOFFICE("ERROR_BACKOFFICE", "0242"),
    ERROR_CEDENT("ERROR_CEDENT","0242");
    
    private ErrorBackoffice(String codi, String estat){
        this.codi = codi;
        this.estat = estat;
    }
    
    private String codi;
    private String estat;

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }
    
    
}
