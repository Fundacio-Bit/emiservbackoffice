package es.caib.scsp.api.cedent.client.SCDCPAJUv3.model;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Titular;

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

public class Solicitud   {
  
  @Schema(required = true, description = "")
  private String provinciaSolicitud = null;
  
  @Schema(required = true, description = "")
  private String municipioSolicitud = null;
  
  @Schema(required = true, description = "")
  private Titular titular = null;
 /**
   * Get provinciaSolicitud
   * @return provinciaSolicitud
  **/
  @JsonProperty("provinciaSolicitud")
  public String getProvinciaSolicitud() {
    return provinciaSolicitud;
  }

  public void setProvinciaSolicitud(String provinciaSolicitud) {
    this.provinciaSolicitud = provinciaSolicitud;
  }

  public Solicitud provinciaSolicitud(String provinciaSolicitud) {
    this.provinciaSolicitud = provinciaSolicitud;
    return this;
  }

 /**
   * Get municipioSolicitud
   * @return municipioSolicitud
  **/
  @JsonProperty("municipioSolicitud")
  public String getMunicipioSolicitud() {
    return municipioSolicitud;
  }

  public void setMunicipioSolicitud(String municipioSolicitud) {
    this.municipioSolicitud = municipioSolicitud;
  }

  public Solicitud municipioSolicitud(String municipioSolicitud) {
    this.municipioSolicitud = municipioSolicitud;
    return this;
  }

 /**
   * Get titular
   * @return titular
  **/
  @JsonProperty("titular")
  public Titular getTitular() {
    return titular;
  }

  public void setTitular(Titular titular) {
    this.titular = titular;
  }

  public Solicitud titular(Titular titular) {
    this.titular = titular;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Solicitud {\n");
    
    sb.append("    provinciaSolicitud: ").append(toIndentedString(provinciaSolicitud)).append("\n");
    sb.append("    municipioSolicitud: ").append(toIndentedString(municipioSolicitud)).append("\n");
    sb.append("    titular: ").append(toIndentedString(titular)).append("\n");
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
