/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.caib.emiservbackoffice.ws.specs;

import es.caib.emiservbackoffice.ws.cedent.SCDCPAJUv3Client;
import es.caib.emiservbackoffice.ws.cedent.SCDHPAJUv3Client;

//import es.caib.scsp.esquemas.SCDCPAJUv3.peticion.datosespecificos.DatosEspecificos;
//import es.caib.scsp.esquemas.SCDCPAJUv3.peticion.datosespecificos.DatosEspecificos;

/**
 *
 * @author gdeignacio
 */
public enum ServeiBackoffice {
    
    SCDCPAJU("SCDCPAJUv3", 
            SCDCPAJUv3Client.class, 
            es.caib.scsp.esquemas.SCDCPAJUv3.peticion.datosespecificos.DatosEspecificos.class, 
            es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.DatosEspecificos.class),
    SCDHPAJU("SCDHPAJUv3",
            SCDHPAJUv3Client.class,
            null,
            null);
    
    private ServeiBackoffice(String codi, Class client, Class datosEspecificosPeticion, Class datosEspecificosRespuesta){
        this.codi = codi;
        this.client = client;
        this.datosEspecificosPeticion = datosEspecificosPeticion;
        this.datosEspecificosRespuesta = datosEspecificosRespuesta;
    }
    
    private String codi;
    private Class client;
    private Class datosEspecificosPeticion;
    private Class datosEspecificosRespuesta;

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

    public Class getDatosEspecificosPeticion() {
        return datosEspecificosPeticion;
    }

    public void setDatosEspecificosPeticion(Class datosEspecificosPeticion) {
        this.datosEspecificosPeticion = datosEspecificosPeticion;
    }

    public Class getDatosEspecificosRespuesta() {
        return datosEspecificosRespuesta;
    }

    public void setDatosEspecificosRespuesta(Class datosEspecificosRespuesta) {
        this.datosEspecificosRespuesta = datosEspecificosRespuesta;
    }

   

    

}
