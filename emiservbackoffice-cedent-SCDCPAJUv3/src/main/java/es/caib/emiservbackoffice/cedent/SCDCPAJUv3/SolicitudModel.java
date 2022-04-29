package es.caib.emiservbackoffice.cedent.SCDCPAJUv3;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Titular;

/**
 * Dades emprades al formulari per indicar les dades a verificar del titular.
 */
public class SolicitudModel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @NotEmpty
    @Size(max = 2)
    private String provinciaSolicitud;
    
    @NotEmpty
    @Size(max = 3)
    private String municipioSolicitud;

    @NotEmpty
    private Titular titular;

    public String getProvinciaSolicitud() {
        return provinciaSolicitud;
    }

    public void setProvinciaSolicitud(String provinciaSolicitud) {
        this.provinciaSolicitud = provinciaSolicitud;
    }

    public String getMunicipioSolicitud() {
        return municipioSolicitud;
    }

    public void setMunicipioSolicitud(String municipioSolicitud) {
        this.municipioSolicitud = municipioSolicitud;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public Solicitud toSolicitud() {
        Solicitud solicitud = new Solicitud();
        solicitud.setProvinciaSolicitud(provinciaSolicitud);
        solicitud.setMunicipioSolicitud(municipioSolicitud);
        solicitud.setTitular(titular);
        return solicitud;
    }
    
}
