package es.caib.emiservbackoffice.ws.cedent;

import es.caib.emiserv.logic.intf.exception.BackofficeException;
import es.caib.emiserv.logic.intf.service.ws.backoffice.DatosGenericos;
import es.caib.emiserv.logic.intf.service.ws.backoffice.Estado;
import es.caib.emiservbackoffice.ws.scsp.SVDSCTFNWS01v3PeticionDatosEspecificos;
import es.caib.emiservbackoffice.ws.scsp.SVDSCTFNWS01v3RespuestaDatosEspecificos;
import es.caib.emiservbackoffice.ws.specs.ErrorBackoffice;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.custom.Svdsctfnws01v3ApiCustom;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.BeneficiarioRetorno;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Categoria;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.TituloVigente;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.custom.ApiClientCustom;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.services.ApiException;
import es.caib.scsp.esquemas.SVDSCTFNWS01v3.peticion.datosespecificos.ListaBeneficiariosRetorno;
import es.caib.scsp.esquemas.SVDSCTFNWS01v3.peticion.datosespecificos.TituloFamiliaNumerosa;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.HttpHeaders;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.fundaciobit.pluginsib.utils.xml.XmlManager;
import org.springframework.util.Base64Utils;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import org.fundaciobit.pluginsib.utils.commons.GregorianCalendars;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.web.client.HttpServerErrorException;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author gdeignacio
 */
public class SVDSCTFNWS01v3Client extends CedentClient {

    protected es.caib.emiservbackoffice.ws.scsp.SVDSCTFNWS01v3PeticionDatosEspecificos pde;

    protected es.caib.emiservbackoffice.ws.scsp.SVDSCTFNWS01v3RespuestaDatosEspecificos rde;

    public SVDSCTFNWS01v3Client(DatosGenericos datosGenericos, String strPeticionDatosEspecificos,
            Propietats propietats) {
        super(datosGenericos, strPeticionDatosEspecificos, propietats);
    }

    private void setDatosPeticion() throws JAXBException, IOException {

        try {
            XmlManager<SVDSCTFNWS01v3PeticionDatosEspecificos> manager = new XmlManager<SVDSCTFNWS01v3PeticionDatosEspecificos>(
                    SVDSCTFNWS01v3PeticionDatosEspecificos.class);

            Element peticionDatosEspecificos = manager.stringToElement(strPeticionDatosEspecificos);

            NamedNodeMap attrs = peticionDatosEspecificos.getAttributes();

            while (attrs.getLength() > 0) {
                attrs.removeNamedItem(attrs.item(0).getNodeName());
            }

            // peticionDatosEspecificos.setAttribute(XMLConstants.XMLNS_ATTRIBUTE.concat(":ns2"),
            // EMISERV_BACKOFFICE_XMLNS);

            pde = manager.generateItem(peticionDatosEspecificos, false, true);

            log.info("SVDSCTFNWS01v3Client :: Datos Especificos Peticion: " + ((pde != null) ? pde.toString() : ""));
        } catch (TransformerException ex) {
            Logger.getLogger(SVDSCTFNWS01v3Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SVDSCTFNWS01v3Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SVDSCTFNWS01v3Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setDatosRespuesta() throws JAXBException, ParserConfigurationException {

        XmlManager<SVDSCTFNWS01v3RespuestaDatosEspecificos> manager = new XmlManager<SVDSCTFNWS01v3RespuestaDatosEspecificos>(
                SVDSCTFNWS01v3RespuestaDatosEspecificos.class);

        XmlSchema xmlSchemaAnnotation = manager.getXmlSchemaAnnotation();

        log.info("SVDSCTFNWS01v3Client :: Datos Especificos NAMESPACE: "
                + ((xmlSchemaAnnotation != null) ? xmlSchemaAnnotation.namespace() : "No xmlSchemaAnnotation"));
        log.info("SVDSCTFNWS01v3Client :: Datos Especificos LOCATION: "
                + ((xmlSchemaAnnotation != null) ? xmlSchemaAnnotation.location() : "No xmlSchemaAnnotation"));

        XmlRootElement xmlRootElementAnnotation = manager.getXmlRootElementAnnotation();

        log.info("SVDSCTFNWS01v3Client :: Datos Especificos XmlRoot NAMESPACE: "
                + ((xmlRootElementAnnotation != null) ? xmlRootElementAnnotation.namespace()
                        : "No xmlRootElementAnnotation"));
        log.info("SVDSCTFNWS01v3Client :: Datos Especificos XmlRoot LOCATION: "
                + ((xmlRootElementAnnotation != null) ? xmlRootElementAnnotation.name()
                        : "No xmlRootElementAnnotation"));

        Element respuestaDatosEspecificos = manager.generateElement(rde);
        // respuestaDatosEspecificos.setAttribute(XMLConstants.XMLNS_ATTRIBUTE,
        // xmlSchemaAnnotation.namespace());

        try {
            strRespuestaDatosEspecificos = manager.elementToString(respuestaDatosEspecificos);
        } catch (TransformerException ex) {
            Logger.getLogger(SVDSCTFNWS01v3Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Map<String, Object> getResultado(es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Solicitud solicitud)
            throws ApiException {

        log.info("SVDSCTFNWS01v3Client :: Iniciant client");

        Svdsctfnws01v3ApiCustom api = new Svdsctfnws01v3ApiCustom();

        ApiClientCustom apiClient = api.getApiClientCustom();

        apiClient.setBasePath(propietats.getEndpoint());

        apiClient.setDebugging(true);

        String usuari = propietats.getUsuari();
        String secret = propietats.getSecret();

        String userpass = usuari.concat(":").concat(secret);

        apiClient.addDefaultHeader(HttpHeaders.AUTHORIZATION,
                "Basic " + Base64Utils.encodeToString(userpass.getBytes(StandardCharsets.UTF_8)));

        // api.getApiClient().addDefaultHeader(HttpHeaders.ACCEPT, "; charset=" +
        // StandardCharsets.UTF_8.name());
        // api.getApiClient().addDefaultHeader(HttpHeaders.CONTENT_TYPE, "; charset=" +
        // StandardCharsets.UTF_8.name());

        // es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Resultado response =
        // null;

        Map<String, Object> response = null;

        try {

            response = api.peticionSincronaCustom(solicitud);

        } catch (ProcessingException ex) {

            throw new ApiException(ex.getMessage(), ex, api.getApiClientCustom().getStatusCode(),
                    api.getApiClientCustom().getResponseHeaders());

        } catch (ApiException ex) {

            int code = 400;
            String message = "";
            String jsonString = ex.getMessage();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode;

            try {

                jsonNode = objectMapper.readTree(jsonString);
                code = jsonNode.get("code").asInt();
                message = jsonNode.get("message").asText();

            } catch (IOException ioex) {

                throw new ApiException(ioex.getMessage(), ioex, api.getApiClientCustom().getStatusCode(),
                        api.getApiClientCustom().getResponseHeaders());

            }

            throw new ApiException(message, ex, code, api.getApiClientCustom().getResponseHeaders(),
                    ex.getResponseBody());
        }

        log.info("SVDSCTFNWS01v3Client :: Consulta al cedent finalitzada");

        return response;
    }

    /**
     * @param consulta
     * @return
     */
    private es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Solicitud adaptaSolicitud(
            es.caib.scsp.esquemas.SVDSCTFNWS01v3.peticion.datosespecificos.Consulta consulta) {

        es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Solicitud sol = new es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Solicitud();

        if (consulta == null) {
            return sol;
        }

        String codigoComunidadAutonoma = null;
        String numeroTitulo = null;
        String fechaConsulta = null;

        es.caib.scsp.esquemas.SVDSCTFNWS01v3.peticion.datosespecificos.TituloFamiliaNumerosa tituloFamiliaNumerosa = consulta.getTituloFamiliaNumerosa();

        if (tituloFamiliaNumerosa != null) {

            es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.TituloFamiliaNumerosa tfn = new es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.TituloFamiliaNumerosa();

            codigoComunidadAutonoma = tituloFamiliaNumerosa.getCodigoComunidadAutonoma();
            numeroTitulo = tituloFamiliaNumerosa.getNumeroTitulo();
            fechaConsulta = tituloFamiliaNumerosa.getFechaConsulta();

            tfn.setCodigoComunidadAutonoma(codigoComunidadAutonoma);
            tfn.setNumeroTitulo(numeroTitulo);
            tfn.setFechaConsulta(fechaConsulta);

            sol.setTituloFamiliaNumerosa(tfn);
        }

        es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.DatosAdicionalesTitular dat = new es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.DatosAdicionalesTitular();
        es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.DatosPersonales dp = new es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.DatosPersonales();

        es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Documentacion dc = new es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Documentacion();

        String tipo;
        String valor;
        String apellido1;
        String apellido2;
        String nombre;
        String fechaNacimiento;
        
        es.caib.emiserv.logic.intf.service.ws.backoffice.Titular titular = datosGenericos.getTitular();

        if (titular != null){
            tipo = titular.getTipoDocumentacion().toString();
            valor = titular.getDocumentacion();
            apellido1 = titular.getApellido1();
            apellido2 = titular.getApellido2();
            nombre = titular.getNombre();

            dp.setApellido1(apellido1);
            dp.setApellido2(apellido2);
            dp.setNombre(nombre);

            dc.setTipo(es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Documentacion.TipoEnum.fromValue(tipo));
            dc.setValor(valor);
            dp.setDocumentacion(dc);
        }

        es.caib.scsp.esquemas.SVDSCTFNWS01v3.peticion.datosespecificos.DatosAdicionalesTitular datosAdicionalesTitular = consulta.getDatosAdicionalesTitular();

        if (datosAdicionalesTitular != null) {
            fechaNacimiento = datosAdicionalesTitular.getFechaNacimiento();
            dp.setFechaNacimiento(fechaNacimiento);
        }
        
        dat.setDatosPersonales(dp);
        dat.setDocumentacion(dc);
        sol.setTitular(dat);

        return sol;
        
    }

    private es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.Retorno adaptaResultado(
            es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Resultado res) {

        if (res == null) {
            return null;
        }

        es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.Retorno retorno = new es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.Retorno();

        es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.TituloFamiliaNumerosaRetorno tfnret = res
                .getTituloFamiliaNumerosaRetorno();

        if (tfnret != null) {

            es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.TituloFamiliaNumerosaRetorno tituloFamiliaNumerosaRetorno = new es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.TituloFamiliaNumerosaRetorno();

            String cca = tfnret.getCodigoComunidadAutonoma();
            String fcad = tfnret.getFechaCaducidad();
            String numttl = tfnret.getNumeroTitulo();
            Integer nh = tfnret.getNumeroHijos();

            Categoria cat = tfnret.getCategoria();
            String categoria = null;
            if (cat != null) {
                categoria = cat.getValue();
            }

            TituloVigente tvi = tfnret.getTituloVigente();
            String tituloVigente = null;
            if (tvi != null) {
                tituloVigente = tvi.getValue();
            }

            tituloFamiliaNumerosaRetorno.setCodigoComunidadAutonoma(cca);
            tituloFamiliaNumerosaRetorno.setFechaCaducidad(fcad);
            tituloFamiliaNumerosaRetorno.setNumeroTitulo(numttl);
            tituloFamiliaNumerosaRetorno.setNumeroHijos(nh);

            tituloFamiliaNumerosaRetorno.setCategoria(categoria);
            tituloFamiliaNumerosaRetorno.setTituloVigente(tituloVigente);

            retorno.setTituloFamiliaNumerosaRetorno(tituloFamiliaNumerosaRetorno);
        }

        es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.ListaBeneficiariosRetorno lbr = res
                .getListaBeneficiariosRetorno();

        if (lbr != null) {

            es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.ListaBeneficiariosRetorno listaBeneficiariosRetorno = new es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.ListaBeneficiariosRetorno();

            List<es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.BeneficiarioRetorno> dom = lbr.getDomicilio();

            if (dom != null) {

                for (BeneficiarioRetorno ber : dom) {

                    es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.BeneficiarioRetorno beneficiarioRetorno = new es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.BeneficiarioRetorno();

                    beneficiarioRetorno.setApellido1(ber.getApellido1());
                    beneficiarioRetorno.setApellido2(ber.getApellido2());

                    // set Documentacion
                    es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Documentacion doc = ber.getDocumentacion();
                    if (doc != null) {
                        // es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.Documentacion
                        // documentacion = new
                        // es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.Documentacion();
                        es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Documentacion.TipoEnum tipo = doc.getTipo();
                        if (tipo != null) {
                            String valorTipo = (es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Documentacion.TipoEnum.PASAPORTE == tipo)
                                    ? es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Documentacion.TipoEnum.PASAPORTE.getValue()
                                    : tipo.getValue();
                            beneficiarioRetorno.setTipoDocumentacion(valorTipo);
                            String documentacion = doc.getValor();
                            beneficiarioRetorno.setDocumentacion(documentacion);
                        }
                    }

                    beneficiarioRetorno.setFechaNacimiento(ber.getFechaNacimiento());
                    beneficiarioRetorno.setNombre(ber.getNombre());

                    es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Titular ttlr = ber.getTitular();

                    if (ttlr != null) {
                        String titular = ttlr.getValue();
                        beneficiarioRetorno.setTitular(titular);
                    }

                    listaBeneficiariosRetorno.getBeneficiarioRetorno().add(beneficiarioRetorno);
                }

            }

            retorno.setListaBeneficiariosRetorno(listaBeneficiariosRetorno);

        }

        return retorno;
    }

    @Override
    public void peticionSincrona() {

        try {
            setDatosPeticion();
        } catch (JAXBException | IOException ex) {
            Logger.getLogger(SVDSCTFNWS01v3Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        String tipo = null;
        String valor = null;
        
        es.caib.emiserv.logic.intf.service.ws.backoffice.Titular ttl = datosGenericos.getTitular();

        if (ttl != null) {
            if (ttl.getDocumentacion() != null) {
                tipo = ttl.getTipoDocumentacion().toString();
                valor = ttl.getDocumentacion();
                log.info("SVDSCTFNWS01v3Client :: Paràmetres de consulta: " + "Tipus document: " + tipo);
                log.info("SVDSCTFNWS01v3Client :: Paràmetres de consulta: " + "Document: " + valor);
            }
        }
        

        if (pde != null) {

            es.caib.scsp.esquemas.SVDSCTFNWS01v3.peticion.datosespecificos.Consulta consulta = pde.getConsulta();
            
            es.caib.scsp.esquemas.SVDSCTFNWS01v3.peticion.datosespecificos.TituloFamiliaNumerosa tfm = null;
            es.caib.scsp.esquemas.SVDSCTFNWS01v3.peticion.datosespecificos.DatosAdicionalesTitular dat = null;

            log.info("SVDSCTFNWS01v3Client :: Paràmetres de consulta: " + "Consulta: " + consulta);

            if (consulta != null) {

                tfm = consulta.getTituloFamiliaNumerosa();

                if (tfm != null) {
                    log.info("SVDSCTFNWS01v3Client :: Paràmetres de consulta: " + "Codi comunitat autònoma : "
                            + tfm.getCodigoComunidadAutonoma());
                    log.info("SVDSCTFNWS01v3Client :: Paràmetres de consulta: " + "Data consulta : "
                            + tfm.getFechaConsulta());
                    log.info("SVDSCTFNWS01v3Client :: Paràmetres de consulta: " + "Numero títol : "
                            + tfm.getNumeroTitulo());
                }

                dat = consulta.getDatosAdicionalesTitular();

                if (dat != null) {
                    log.info("SVDSCTFNWS01v3Client :: Paràmetres de consulta: " + "Data neixement titular : "
                            + dat.getFechaNacimiento());
                }

                

            }

            es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Solicitud sol = adaptaSolicitud(consulta);

            log.info("SVDSCTFNWS01v3Client :: Solicitud per al cedent " + sol);

            rde = new SVDSCTFNWS01v3RespuestaDatosEspecificos();

            es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.Estado respuestaEstado = new es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.Estado();
            es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.Retorno retorno = new es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.Retorno();

            try {

                es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Resultado res;
                es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.ModelApiResponse modelApiResponse;

                Map<String, Object> response = getResultado(sol);

                res = (es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Resultado) response.get("returnType");
                log.info("SVDSCTFNWS01v3Client :: Resposta del cedent " + res);
                modelApiResponse = (es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.ModelApiResponse) response
                        .get("errorType");
                log.info("SVDSCTFNWS01v3Client :: Resposta api del cedent " + modelApiResponse);

                if (res != null) {
                    retorno = adaptaResultado(res);
                    
                    respuestaEstado.setCodigoEstado(ErrorBackoffice.TRAMITADA.getEstat());
                    respuestaEstado.setLiteralError(ErrorBackoffice.TRAMITADA.getCodi());
                    retorno.setEstado(respuestaEstado);

                    log.info("SVDSCTFNWS01v3Client :: Resposta del cedent adaptada");
                    
                    if (retorno != null) {
                        for (es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.BeneficiarioRetorno beneficiarioRetorno : retorno.getListaBeneficiariosRetorno().getBeneficiarioRetorno()) {
                            if ("S".equals(beneficiarioRetorno.getTitular())) {
                                datosGenericos.getTitular()
                                        .setTipoDocumentacion(es.caib.emiserv.logic.intf.service.ws.backoffice.TipoDocumentacion
                                                .valueOf(beneficiarioRetorno.getTipoDocumentacion()));
                                datosGenericos.getTitular().setDocumentacion(beneficiarioRetorno.getDocumentacion());

                            }
                        }
                    }
                    
                }

                if (modelApiResponse != null) {
                    retorno = new es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.Retorno();
                    respuestaEstado.setCodigoEstado(String.valueOf(modelApiResponse.getCode()));
                    respuestaEstado.setLiteralError(modelApiResponse.getMessage());
                    retorno.setEstado(respuestaEstado);
                }

            } catch (ApiException ex) {
                Logger.getLogger(SVDSCTFNWS01v3Client.class.getName()).log(Level.SEVERE, null, ex);

                retorno = new es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.Retorno();
                respuestaEstado.setCodigoEstado(ErrorBackoffice.ERROR_CEDENT.getEstat());
                respuestaEstado.setLiteralError("Error genèric del cedent. " + ex.getMessage());
                retorno.setEstado(respuestaEstado);
            }

            rde.setRetorno(retorno);
            
            es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.Consulta respuestaConsulta = new es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.Consulta();

            es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.TituloFamiliaNumerosa tfmr;
            es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.DatosAdicionalesTitular datr;
            
            if (tfm!=null){
                tfmr = new es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.TituloFamiliaNumerosa();
                tfmr.setCodigoComunidadAutonoma(tfm.getCodigoComunidadAutonoma());
                tfmr.setFechaConsulta(tfm.getFechaConsulta());
                tfmr.setNumeroTitulo(tfm.getNumeroTitulo());
                respuestaConsulta.setTituloFamiliaNumerosa(tfmr);
                respuestaConsulta.setTituloFamiliaNumerosa(tfmr);
            }
            
            if (dat!=null){
               datr = new es.caib.scsp.esquemas.SVDSCTFNWS01v3.respuesta.datosespecificos.DatosAdicionalesTitular();
               datr.setFechaNacimiento(dat.getFechaNacimiento());
               respuestaConsulta.setDatosAdicionalesTitular(datr);
            }
            
            rde.setConsulta(respuestaConsulta);
          
        }

        log.info("SVDSCTFNWS01v3Client :: Tipus de documentació de la solicitud: " + tipo);
        log.info("SVDSCTFNWS01v3Client :: Valor de documentació de la solicitud: " + valor);
       
        log.info("SVDSCTFNWS01v3Client :: Dades resposta");
        try {
            setDatosRespuesta();
        } catch (JAXBException | ParserConfigurationException ex) {
            Logger.getLogger(SVDSCTFNWS01v3Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Element getRespuestaDatosEspecificos() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public void setPeticionDatosEspecificos(Element element) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

}
