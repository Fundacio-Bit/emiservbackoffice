package es.caib.emiservbackoffice.ws.cedent;

import es.caib.emiserv.logic.intf.service.ws.backoffice.DatosGenericos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author gdeignacio
 */
public abstract class CedentClient {
    
    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    protected DatosGenericos datosGenericos;
    protected String strPeticionDatosEspecificos;
    protected Propietats propietats;

    public CedentClient(DatosGenericos datosGenericos, String strPeticionDatosEspecificos, Propietats propietats) {
        this.datosGenericos = datosGenericos;
        this.strPeticionDatosEspecificos = strPeticionDatosEspecificos;
        this.propietats = propietats;
    }

    public DatosGenericos getDatosGenericos() {
        return datosGenericos;
    }

    public void setDatosGenericos(DatosGenericos datosGenericos) {
        this.datosGenericos = datosGenericos;
    }

    public String getStrPeticionDatosEspecificos() {
        return strPeticionDatosEspecificos;
    }

    public void setStrPeticionDatosEspecificos(String strPeticionDatosEspecificos) {
        this.strPeticionDatosEspecificos = strPeticionDatosEspecificos;
    }

    public Propietats getPropietats() {
        return propietats;
    }

    public void setPropietats(Propietats propietats) {
        this.propietats = propietats;
    }
    
    public abstract String getStrDatosEspecificosRespuesta();
    
    public abstract DatosGenericos getDatosGenericosRespuesta();
    
    public abstract void peticionSincrona();
    
    
}
