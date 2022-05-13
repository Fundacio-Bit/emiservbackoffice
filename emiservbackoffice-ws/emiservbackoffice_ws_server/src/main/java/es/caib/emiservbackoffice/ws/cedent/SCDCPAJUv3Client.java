/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.caib.emiservbackoffice.ws.cedent;

import es.caib.emiserv.logic.intf.service.ws.backoffice.DatosGenericos;
import es.caib.scsp.esquemas.SCDCPAJUv3.peticion.datosespecificos.DatosEspecificos;

/**
 *
 * @author gdeignacio
 */
public class SCDCPAJUv3Client extends CedentClient {

    public SCDCPAJUv3Client(DatosGenericos peticionDatosGenericos, String peticionDatosEspecificos) {
        super(peticionDatosGenericos, peticionDatosEspecificos);
    }

    @Override
    public String getDatosEspecificosRespuesta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DatosGenericos getDatosGenericosRespuesta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
