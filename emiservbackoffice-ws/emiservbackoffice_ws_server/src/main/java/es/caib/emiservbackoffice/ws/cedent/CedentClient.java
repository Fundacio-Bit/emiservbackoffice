package es.caib.emiservbackoffice.ws.cedent;

import es.caib.emiserv.logic.intf.service.ws.backoffice.DatosGenericos;

/**
 *
 * @author gdeignacio
 */
public abstract class CedentClient {
    
    protected DatosGenericos peticionDatosGenericos;
    protected String peticionDatosEspecificos;
    protected Propietats propietats;

    public CedentClient(DatosGenericos peticionDatosGenericos, String peticionDatosEspecificos, Propietats propietats) {
        this.peticionDatosGenericos = peticionDatosGenericos;
        this.peticionDatosEspecificos = peticionDatosEspecificos;
        this.propietats = propietats;
    }

    public DatosGenericos getPeticionDatosGenericos() {
        return peticionDatosGenericos;
    }

    public void setPeticionDatosGenericos(DatosGenericos peticionDatosGenericos) {
        this.peticionDatosGenericos = peticionDatosGenericos;
    }

    public String getPeticionDatosEspecificos() {
        return peticionDatosEspecificos;
    }

    public void setPeticionDatosEspecificos(String peticionDatosEspecificos) {
        this.peticionDatosEspecificos = peticionDatosEspecificos;
    }

    public Propietats getPropietats() {
        return propietats;
    }

    public void setPropietats(Propietats propietats) {
        this.propietats = propietats;
    }
    
    public abstract String getDatosEspecificosRespuesta();
    
    public abstract DatosGenericos getDatosGenericosRespuesta();
    
    public abstract void peticionSincrona();
    
    
}
