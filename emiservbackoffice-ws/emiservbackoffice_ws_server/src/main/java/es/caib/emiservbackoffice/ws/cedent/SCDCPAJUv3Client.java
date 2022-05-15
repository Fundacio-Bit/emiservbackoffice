package es.caib.emiservbackoffice.ws.cedent;

import es.caib.emiserv.logic.intf.service.ws.backoffice.DatosGenericos;
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
    
    
    private es.caib.scsp.esquemas.SCDCPAJUv3.peticion.datosespecificos.DatosEspecificos pde;
        
    private es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.DatosEspecificos rde;
    
    public SCDCPAJUv3Client(DatosGenericos datosGenericos, Element peticionDatosEspecificos, Propietats propietats) {
        super(datosGenericos, peticionDatosEspecificos, propietats);
    }

    private void setDatosPeticion() throws JAXBException, IOException{
        
        XmlManager<es.caib.scsp.esquemas.SCDCPAJUv3.peticion.datosespecificos.DatosEspecificos> manager
                = new XmlManager<es.caib.scsp.esquemas.SCDCPAJUv3.peticion.datosespecificos.DatosEspecificos>(es.caib.scsp.esquemas.SCDCPAJUv3.peticion.datosespecificos.DatosEspecificos.class);
        pde = manager.generateItem(peticionDatosEspecificos);
        
    }
    
    
    private void setDatosRespuesta() throws JAXBException, ParserConfigurationException{
        
        XmlManager<es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.DatosEspecificos> manager
                = new XmlManager<es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.DatosEspecificos>(es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.DatosEspecificos.class);
        
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
        
        
        rde = new es.caib.scsp.esquemas.SCDCPAJUv3.respuesta.datosespecificos.DatosEspecificos();
        
        try {
            setDatosRespuesta();
        } catch (JAXBException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SCDCPAJUv3Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
