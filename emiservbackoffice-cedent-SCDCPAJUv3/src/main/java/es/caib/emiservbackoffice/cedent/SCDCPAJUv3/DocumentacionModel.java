package es.caib.emiservbackoffice.cedent.SCDCPAJUv3;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Documentacion;

/**
 * Dades emprades al formulari per indicar les dades a verificar del titular.
 */
public class DocumentacionModel extends TitularModel {

    private static final long serialVersionUID = 1L;

    
    @NotEmpty
    @Size(max=14) private String valor;

    /**
     * Tipo de documentació. Aquesta enumeració permet molts de valors, però el servei concret de verificació
     * d'identitat només permet emprar DNI o NIE, per això validam que sigui un d'aquests valors.
     */
    @NotEmpty
    @DocumentacionSubset(anyOf = {Documentacion.TipoEnum.DNI, Documentacion.TipoEnum.NIE, Documentacion.TipoEnum.NIF, Documentacion.TipoEnum.PASSAPORT })
    private String tipo;
    
    
    
    
    public Documentacion toDocumentacion() {
        
        Documentacion documentacion = new Documentacion();
        
        documentacion.setTipo(Documentacion.TipoEnum.);
        documentacion.setValor(valor);
        
        return documentacion;
    }
  
}
