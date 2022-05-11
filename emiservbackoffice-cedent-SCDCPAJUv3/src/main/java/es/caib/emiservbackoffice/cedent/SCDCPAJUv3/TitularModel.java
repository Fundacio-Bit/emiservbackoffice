package es.caib.emiservbackoffice.cedent.SCDCPAJUv3;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Titular;
import java.io.Serializable;
import javax.validation.Valid;

/**
 * Dades emprades al formulari per indicar les dades a verificar del titular.
 */
public class TitularModel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Valid
    private DocumentacionModel documentacion;
    
    @Valid
    private DatosPersonalesModel datosPersonales;

    public DocumentacionModel getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(DocumentacionModel documentacion) {
        this.documentacion = documentacion;
    }

    public DatosPersonalesModel getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonalesModel datosPersonales) {
        this.datosPersonales = datosPersonales;
    }
    
    
    public Titular toTitular() {

        Titular titular = new Titular();
        titular.setDatosPersonales((datosPersonales!=null)?datosPersonales.toDatosPersonales():null);
        titular.setDocumentacion((documentacion!=null)?documentacion.toDocumentacion():null);
        return titular;
    }

    
}
