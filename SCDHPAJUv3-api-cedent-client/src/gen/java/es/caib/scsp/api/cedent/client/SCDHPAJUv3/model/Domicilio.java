package es.caib.scsp.api.cedent.client.SCDHPAJUv3.model;

import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.ClaveHojaPadronal;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Direccion;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.EntColectiva;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.EntSingular;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.MotivoBaja;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.MotivoInscripcion;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.MunicipioRespuesta;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Nucleo;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.ProvinciaRespuesta;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

public class Domicilio   {
  
  @Schema(required = true, description = "")
  private ClaveHojaPadronal claveHojaPadronal = null;
  
  @Schema(description = "")
  private ProvinciaRespuesta provinciaRespuesta = null;
  
  @Schema(description = "")
  private MunicipioRespuesta municipioRespuesta = null;
  
  @Schema(description = "")
  private EntColectiva entColectiva = null;
  
  @Schema(description = "")
  private EntSingular entSingular = null;
  
  @Schema(description = "")
  private Nucleo nucleo = null;
  
  @Schema(description = "")
  private String codUnidadPoblacional = null;
  
  @Schema(required = true, description = "")
  private Direccion direccion = null;
  
  @Schema(required = true, description = "")
  private String desde = null;
  
  @Schema(description = "")
  private MotivoInscripcion motivoInscripcion = null;
  
  @Schema(description = "")
  private String hasta = null;
  
  @Schema(description = "")
  private MotivoBaja motivoBaja = null;
 /**
   * Get claveHojaPadronal
   * @return claveHojaPadronal
  **/
  @JsonProperty("claveHojaPadronal")
  public ClaveHojaPadronal getClaveHojaPadronal() {
    return claveHojaPadronal;
  }

  public void setClaveHojaPadronal(ClaveHojaPadronal claveHojaPadronal) {
    this.claveHojaPadronal = claveHojaPadronal;
  }

  public Domicilio claveHojaPadronal(ClaveHojaPadronal claveHojaPadronal) {
    this.claveHojaPadronal = claveHojaPadronal;
    return this;
  }

 /**
   * Get provinciaRespuesta
   * @return provinciaRespuesta
  **/
  @JsonProperty("provinciaRespuesta")
  public ProvinciaRespuesta getProvinciaRespuesta() {
    return provinciaRespuesta;
  }

  public void setProvinciaRespuesta(ProvinciaRespuesta provinciaRespuesta) {
    this.provinciaRespuesta = provinciaRespuesta;
  }

  public Domicilio provinciaRespuesta(ProvinciaRespuesta provinciaRespuesta) {
    this.provinciaRespuesta = provinciaRespuesta;
    return this;
  }

 /**
   * Get municipioRespuesta
   * @return municipioRespuesta
  **/
  @JsonProperty("municipioRespuesta")
  public MunicipioRespuesta getMunicipioRespuesta() {
    return municipioRespuesta;
  }

  public void setMunicipioRespuesta(MunicipioRespuesta municipioRespuesta) {
    this.municipioRespuesta = municipioRespuesta;
  }

  public Domicilio municipioRespuesta(MunicipioRespuesta municipioRespuesta) {
    this.municipioRespuesta = municipioRespuesta;
    return this;
  }

 /**
   * Get entColectiva
   * @return entColectiva
  **/
  @JsonProperty("entColectiva")
  public EntColectiva getEntColectiva() {
    return entColectiva;
  }

  public void setEntColectiva(EntColectiva entColectiva) {
    this.entColectiva = entColectiva;
  }

  public Domicilio entColectiva(EntColectiva entColectiva) {
    this.entColectiva = entColectiva;
    return this;
  }

 /**
   * Get entSingular
   * @return entSingular
  **/
  @JsonProperty("entSingular")
  public EntSingular getEntSingular() {
    return entSingular;
  }

  public void setEntSingular(EntSingular entSingular) {
    this.entSingular = entSingular;
  }

  public Domicilio entSingular(EntSingular entSingular) {
    this.entSingular = entSingular;
    return this;
  }

 /**
   * Get nucleo
   * @return nucleo
  **/
  @JsonProperty("nucleo")
  public Nucleo getNucleo() {
    return nucleo;
  }

  public void setNucleo(Nucleo nucleo) {
    this.nucleo = nucleo;
  }

  public Domicilio nucleo(Nucleo nucleo) {
    this.nucleo = nucleo;
    return this;
  }

 /**
   * Get codUnidadPoblacional
   * @return codUnidadPoblacional
  **/
  @JsonProperty("codUnidadPoblacional")
  public String getCodUnidadPoblacional() {
    return codUnidadPoblacional;
  }

  public void setCodUnidadPoblacional(String codUnidadPoblacional) {
    this.codUnidadPoblacional = codUnidadPoblacional;
  }

  public Domicilio codUnidadPoblacional(String codUnidadPoblacional) {
    this.codUnidadPoblacional = codUnidadPoblacional;
    return this;
  }

 /**
   * Get direccion
   * @return direccion
  **/
  @JsonProperty("direccion")
  public Direccion getDireccion() {
    return direccion;
  }

  public void setDireccion(Direccion direccion) {
    this.direccion = direccion;
  }

  public Domicilio direccion(Direccion direccion) {
    this.direccion = direccion;
    return this;
  }

 /**
   * Get desde
   * @return desde
  **/
  @JsonProperty("desde")
  public String getDesde() {
    return desde;
  }

  public void setDesde(String desde) {
    this.desde = desde;
  }

  public Domicilio desde(String desde) {
    this.desde = desde;
    return this;
  }

 /**
   * Get motivoInscripcion
   * @return motivoInscripcion
  **/
  @JsonProperty("motivoInscripcion")
  public MotivoInscripcion getMotivoInscripcion() {
    return motivoInscripcion;
  }

  public void setMotivoInscripcion(MotivoInscripcion motivoInscripcion) {
    this.motivoInscripcion = motivoInscripcion;
  }

  public Domicilio motivoInscripcion(MotivoInscripcion motivoInscripcion) {
    this.motivoInscripcion = motivoInscripcion;
    return this;
  }

 /**
   * Get hasta
   * @return hasta
  **/
  @JsonProperty("hasta")
  public String getHasta() {
    return hasta;
  }

  public void setHasta(String hasta) {
    this.hasta = hasta;
  }

  public Domicilio hasta(String hasta) {
    this.hasta = hasta;
    return this;
  }

 /**
   * Get motivoBaja
   * @return motivoBaja
  **/
  @JsonProperty("motivoBaja")
  public MotivoBaja getMotivoBaja() {
    return motivoBaja;
  }

  public void setMotivoBaja(MotivoBaja motivoBaja) {
    this.motivoBaja = motivoBaja;
  }

  public Domicilio motivoBaja(MotivoBaja motivoBaja) {
    this.motivoBaja = motivoBaja;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Domicilio {\n");
    
    sb.append("    claveHojaPadronal: ").append(toIndentedString(claveHojaPadronal)).append("\n");
    sb.append("    provinciaRespuesta: ").append(toIndentedString(provinciaRespuesta)).append("\n");
    sb.append("    municipioRespuesta: ").append(toIndentedString(municipioRespuesta)).append("\n");
    sb.append("    entColectiva: ").append(toIndentedString(entColectiva)).append("\n");
    sb.append("    entSingular: ").append(toIndentedString(entSingular)).append("\n");
    sb.append("    nucleo: ").append(toIndentedString(nucleo)).append("\n");
    sb.append("    codUnidadPoblacional: ").append(toIndentedString(codUnidadPoblacional)).append("\n");
    sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
    sb.append("    desde: ").append(toIndentedString(desde)).append("\n");
    sb.append("    motivoInscripcion: ").append(toIndentedString(motivoInscripcion)).append("\n");
    sb.append("    hasta: ").append(toIndentedString(hasta)).append("\n");
    sb.append("    motivoBaja: ").append(toIndentedString(motivoBaja)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
