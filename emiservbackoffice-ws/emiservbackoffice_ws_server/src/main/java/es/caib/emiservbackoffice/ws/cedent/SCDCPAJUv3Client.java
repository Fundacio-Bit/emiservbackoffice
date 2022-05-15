package es.caib.emiservbackoffice.ws.cedent;

import es.caib.emiserv.logic.intf.service.ws.backoffice.DatosGenericos;
import es.caib.emiservbackoffice.ws.scsp.SCDCPAJUv3PeticionDatosEspecificos;
import es.caib.emiservbackoffice.ws.scsp.SCDCPAJUv3RespuestaDatosEspecificos;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.parsers.ParserConfigurationException;
import org.fundaciobit.pluginsib.utils.xml.XmlManager;
import org.w3c.dom.Element;

/**
 *
 * @author gdeignacio
 */
public class SCDCPAJUv3Client extends CedentClient {
    
    
    private SCDCPAJUv3PeticionDatosEspecificos pde;
        
    private SCDCPAJUv3RespuestaDatosEspecificos rde;
    
    public SCDCPAJUv3Client(DatosGenericos datosGenericos, Element peticionDatosEspecificos, Propietats propietats) {
        super(datosGenericos, peticionDatosEspecificos, propietats);
    }

    private void setDatosPeticion() throws JAXBException, IOException{
        
        XmlManager<SCDCPAJUv3PeticionDatosEspecificos> manager
                = new XmlManager<SCDCPAJUv3PeticionDatosEspecificos>(SCDCPAJUv3PeticionDatosEspecificos.class);
        pde = manager.generateItem(peticionDatosEspecificos);

        log.info("SCDCPAJUv3Client :: Datos Especificos Peticioon: " +  ((pde!=null)?pde.toString():""));

    }
    
    
    private void setDatosRespuesta() throws JAXBException, ParserConfigurationException{
        
        XmlManager<SCDCPAJUv3RespuestaDatosEspecificos> manager
                = new XmlManager<SCDCPAJUv3RespuestaDatosEspecificos>(SCDCPAJUv3RespuestaDatosEspecificos.class);
        
        XmlSchema xmlSchemaAnnotation = manager.getXmlSchemaAnnotation();

        log.info("SCDCPAJUv3Client :: Datos Especificos NAMESPACE: " + ((xmlSchemaAnnotation!=null)?xmlSchemaAnnotation.namespace():"No xmlSchemaAnnotation"));
        log.info("SCDCPAJUv3Client :: Datos Especificos LOCATION: " + ((xmlSchemaAnnotation!=null)?xmlSchemaAnnotation.location():"No xmlSchemaAnnotation"));

        XmlRootElement xmlRootElementAnnotation = manager.getXmlRootElementAnnotation();

        log.info("SCDCPAJUv3Client :: Datos Especificos XmlRoot NAMESPACE: " + ((xmlRootElementAnnotation!=null)?xmlRootElementAnnotation.namespace():"No xmlRootElementAnnotation"));
        log.info("SCDCPAJUv3Client :: Datos Especificos XmlRoot LOCATION: " + ((xmlRootElementAnnotation!=null)?xmlRootElementAnnotation.name():"No xmlRootElementAnnotation"));

        respuestaDatosEspecificos = manager.generateElement(rde);
   
    }
    
    
    @Override
    public void peticionSincrona() {
        
        try {
            setDatosPeticion();
        } catch (JAXBException | IOException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        rde = new SCDCPAJUv3RespuestaDatosEspecificos();
        
        try {
            setDatosRespuesta();
        } catch (JAXBException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
