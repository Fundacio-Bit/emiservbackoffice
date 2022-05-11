package es.caib.emiservbackoffice.cedent.SCDCPAJUv3;

import es.caib.emiservbackoffice.cedent.SCDCPAJUv3.scsp.TipoDocumentacionSubset;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Documentacion;
import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 * Dades emprades al formulari per indicar les dades a verificar del titular.
 */
public class DocumentacionModel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @NotEmpty
    @Size(max=14) private String valor;
   
    /**
     * Tipo de documentació. Aquesta enumeració permet molts de valors, però el servei concret de verificació
     * d'identitat només permet emprar DNI o NIE, per això validam que sigui un d'aquests valors.
     */
    
    @NotNull
    @TipoDocumentacionSubset(anyOf = {Documentacion.TipoEnum.DNI, Documentacion.TipoEnum.NIE, Documentacion.TipoEnum.NIF, Documentacion.TipoEnum.PASSAPORT })
    private Documentacion.TipoEnum tipo;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Documentacion.TipoEnum getTipo() {
        return tipo;
    }

    public void setTipo(Documentacion.TipoEnum tipo) {
        this.tipo = tipo;
    }

    
    
    public Documentacion toDocumentacion() {
        
        Documentacion documentacion = new Documentacion();
        documentacion.setTipo(tipo);
        documentacion.setValor(valor);
        return documentacion;
        
    }
    
    
}
