package es.caib.emiservbackoffice.ws.cedent;

import es.caib.emiserv.logic.intf.service.ws.backoffice.DatosGenericos;

/**
 *
 * @author gdeignacio
 */
public class SCDHPAJUv3Client extends CedentClient {

    public SCDHPAJUv3Client(DatosGenericos datosGenericos, String strPeticionDatosEspecificos, Propietats propietats) {
        super(datosGenericos, strPeticionDatosEspecificos, propietats);
    }

    @Override
    public String getStrDatosEspecificosRespuesta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DatosGenericos getDatosGenericosRespuesta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void peticionSincrona() {
        
        
        
    
    }
    
}
