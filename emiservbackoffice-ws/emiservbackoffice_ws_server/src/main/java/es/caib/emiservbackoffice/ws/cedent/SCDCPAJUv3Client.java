package es.caib.emiservbackoffice.ws.cedent;

import es.caib.emiserv.logic.intf.service.ws.backoffice.DatosGenericos;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author gdeignacio
 */
public class SCDCPAJUv3Client extends CedentClient {

    public SCDCPAJUv3Client(DatosGenericos datosGenericos, String strPeticionDatosEspecificos, Propietats propietats) {
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
        
        
        
        es.caib.scsp.esquemas.SCDCPAJUv3.peticion.datosespecificos.DatosEspecificos peticionDatosEspecificos;
        
        JAXBContext jaxbContext;
        
        try {        
            jaxbContext = JAXBContext.newInstance(es.caib.scsp.esquemas.SCDCPAJUv3.peticion.datosespecificos.DatosEspecificos.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            peticionDatosEspecificos = (es.caib.scsp.esquemas.SCDCPAJUv3.peticion.datosespecificos.DatosEspecificos) jaxbUnmarshaller.unmarshal(new StringReader(strPeticionDatosEspecificos));
       
            String str = peticionDatosEspecificos.toString();
            
            log.info("SCDCPAJUv3Client :: Contingut Datos Especificos :"  + str);
            
            
            
        } catch (JAXBException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        
        
    }
    
}
