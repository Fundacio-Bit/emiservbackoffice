package es.caib.emiservbackoffice.cedent.SCDCPAJUv3;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Documentacion;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Resultado;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Titular;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;
import java.io.Serializable;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;

/**
 * Controlador d'exemple per emprar el servei de verificació d'identitat.
 *
 * @author areus
 */
@Named("SCDCPAJUv3Controller")
@ViewScoped
public class SCDCPAJUv3Controller implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private static final Logger LOG = LoggerFactory.getLogger(SCDCPAJUv3Controller.class);

    /**
     * Injecta l'API del client del servei de verificació d'identitat
     */
    @Inject
    private SCDCPAJUv3Client clientSCDCPAJUv3;

    @Inject
    private Configuracio configuracio;
    
    @Inject
    private FacesContext context;

    @Valid
    private String provinciaSolicitud;
    
    public String getProvinciaSolicitudModel() {
        return provinciaSolicitud;
    }
    
    @Valid
    private String municipioSolicitud;
    
    public String getMunicipioSolicitud(){
        return municipioSolicitud;
    }
    
    @Valid
    private DocumentacionModel documentacion;

    public DocumentacionModel getDocumentacion() {
        return documentacion;
    }

    @Valid
    private DatosPersonalesModel datosPersonales;
    
    public DatosPersonalesModel getDatosPersonales() {
        return datosPersonales;
    }
    
    private Resultado resultado;

    public Resultado getResultado() {
        return resultado;
    }

    @PostConstruct
    protected void init() {
        LOG.info("init");
        documentacion = new DocumentacionModel();
        datosPersonales = new DatosPersonalesModel();
    }

    /**
     * Neteja la resposta
     */
    public void neteja() {
        resultado = null;
    }

    /**
     * Cridat en fer un submit del formulari per fer la consulta al servei.
     */
    
    public void obtenirDadesPadroConvivencia() {
        
        LOG.info("Peticio " +  SCDCPAJUv3Controller.class.getName());

        Solicitud solicitud = new Solicitud();
  
        solicitud.setProvinciaSolicitud(provinciaSolicitud);
        solicitud.setMunicipioSolicitud(municipioSolicitud);
        
        Titular titular = new Titular();
        
        if (documentacion!=null){
            titular.setDocumentacion(documentacion.toDocumentacion());
            titular.setDatosPersonales(null);
            solicitud.setTitular(titular);
        } else if (datosPersonales!=null){
            titular.setDatosPersonales(datosPersonales.toDatosPersonales());
            titular.setDocumentacion(null);
            solicitud.setTitular(titular);
        }
       
        try {
            resultado = clientSCDCPAJUv3.peticioSincrona(solicitud);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(SEVERITY_ERROR, "Error al client SCDCPAJUv3", e.getMessage());
            context.addMessage(null, message);
        }
    }


}
