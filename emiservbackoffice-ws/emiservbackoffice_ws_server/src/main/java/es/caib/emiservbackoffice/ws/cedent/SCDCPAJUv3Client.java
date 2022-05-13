/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.caib.emiservbackoffice.ws.cedent;

import es.caib.scsp.esquemas.SCDCPAJUv3.peticion.datosespecificos.DatosEspecificos;

/**
 *
 * @author gdeignacio
 */
public class SCDCPAJUv3Client {
    
    
    
    public SCDCPAJUv3Client(Object datosEspecificos){
        
    }
    
    private DatosEspecificos datosEspecificos;

    public SCDCPAJUv3Client(DatosEspecificos datosEspecificos) {
        this.datosEspecificos = datosEspecificos;
    }

    public DatosEspecificos getDatosEspecificos() {
        return datosEspecificos;
    }

    public void setDatosEspecificos(DatosEspecificos datosEspecificos) {
        this.datosEspecificos = datosEspecificos;
    }
    
    
    
    
    
    
}
