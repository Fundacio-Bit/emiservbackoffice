package es.caib.emiservbackoffice.ws.cedent;

import es.caib.emiserv.logic.intf.service.ws.backoffice.DatosGenericos;
import org.w3c.dom.Element;

/**
 *
 * @author gdeignacio
 */
public class SCDHPAJUv3Client extends CedentClient {
    
    //private es.caib.scsp.esquemas.SCDHPAJUv3.peticion.datosespecificos.DatosEspecificos pde;
        
    //private es.caib.scsp.esquemas.SCDHPAJUv3.peticion.datosespecificos.DatosEspecificos rde;
    
    
    public SCDHPAJUv3Client(DatosGenericos datosGenericos, String strPeticionDatosEspecificos, Propietats propietats) {
        super(datosGenericos, strPeticionDatosEspecificos, propietats);
    }

 
    @Override
    public void peticionSincrona() {
        
        
        
    
    }

    @Override
    public Element getRespuestaDatosEspecificos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPeticionDatosEspecificos(Element element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
