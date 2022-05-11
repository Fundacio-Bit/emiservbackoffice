/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.caib.emiservbackoffice.ws.specs;

/**
 *
 * @author gdeignacio
 */
public enum ServeiBackoffice {
    
    SCDCPAJU("SCDCPAJUv3",null),
    SCDHPAJU("SCDHPAJUv3",null);
    
    
    private ServeiBackoffice(String codi, Class clazz){
        this.codi = codi;
        this.clazz = clazz;
    }
    
    private String codi;
    private Class clazz;

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

}
