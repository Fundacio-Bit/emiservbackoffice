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
    
    
    public SCDHPAJUv3Client(DatosGenericos datosGenericos, Element peticionDatosEspecificos, Propietats propietats) {
        super(datosGenericos, peticionDatosEspecificos, propietats);
    }

 
    @Override
    public void peticionSincrona() {
        
        
        
    
    }
    
}
