package es.caib.emiservbackoffice.ws.cedent;

import es.caib.emiserv.logic.intf.service.ws.backoffice.DatosGenericos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

/**
 *
 * @author gdeignacio
 */
public abstract class CedentClient {
    
    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    protected DatosGenericos datosGenericos;
    protected Element peticionDatosEspecificos;
    protected Propietats propietats;
    
    protected Element respuestaDatosEspecificos;

    public CedentClient(DatosGenericos datosGenericos, Element peticionDatosEspecificos, Propietats propietats) {
        this.datosGenericos = datosGenericos;
        this.peticionDatosEspecificos = peticionDatosEspecificos;
        this.propietats = propietats;
    }

    public DatosGenericos getDatosGenericos() {
        return datosGenericos;
    }

    public void setDatosGenericos(DatosGenericos datosGenericos) {
        this.datosGenericos = datosGenericos;
    }

    public Element getPeticionDatosEspecificos() {
        return peticionDatosEspecificos;
    }

    public void setPeticionDatosEspecificos(Element peticionDatosEspecificos) {
        this.peticionDatosEspecificos = peticionDatosEspecificos;
    }

    public Propietats getPropietats() {
        return propietats;
    }

    public void setPropietats(Propietats propietats) {
        this.propietats = propietats;
    }

    public Element getRespuestaDatosEspecificos() {
        return respuestaDatosEspecificos;
    }

    public void setRespuestaDatosEspecificos(Element respuestaDatosEspecificos) {
        this.respuestaDatosEspecificos = respuestaDatosEspecificos;
    }
    
    public abstract void peticionSincrona();
    
    
}
