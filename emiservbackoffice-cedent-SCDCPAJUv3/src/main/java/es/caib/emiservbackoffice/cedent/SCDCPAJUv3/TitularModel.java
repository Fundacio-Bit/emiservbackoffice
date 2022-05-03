package es.caib.emiservbackoffice.cedent.SCDCPAJUv3;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Titular;

/**
 * Dades emprades al formulari per indicar les dades a verificar del titular.
 */
public abstract class TitularModel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public abstract Titular toTitular();
    
}
