package es.caib.scsp.api.cedent.client.SCDCPAJUv3.model;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.ClaveHojaPadronal;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Domicilio;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Personas;
import org.joda.time.DateTime;

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

public class Resultado   {
  
  @Schema(required = true, description = "")
  private ClaveHojaPadronal claveHojaPadronal = null;
  
  @Schema(required = true, description = "")
  private Domicilio domicilio = null;
  
  @Schema(required = true, description = "")
  private Personas personas = null;
  
  @Schema(required = true, description = "")
  private DateTime fechaExpedicion = null;
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

  public Resultado claveHojaPadronal(ClaveHojaPadronal claveHojaPadronal) {
    this.claveHojaPadronal = claveHojaPadronal;
    return this;
  }

 /**
   * Get domicilio
   * @return domicilio
  **/
  @JsonProperty("domicilio")
  public Domicilio getDomicilio() {
    return domicilio;
  }

  public void setDomicilio(Domicilio domicilio) {
    this.domicilio = domicilio;
  }

  public Resultado domicilio(Domicilio domicilio) {
    this.domicilio = domicilio;
    return this;
  }

 /**
   * Get personas
   * @return personas
  **/
  @JsonProperty("personas")
  public Personas getPersonas() {
    return personas;
  }

  public void setPersonas(Personas personas) {
    this.personas = personas;
  }

  public Resultado personas(Personas personas) {
    this.personas = personas;
    return this;
  }

 /**
   * Get fechaExpedicion
   * @return fechaExpedicion
  **/
  @JsonProperty("fechaExpedicion")
  public DateTime getFechaExpedicion() {
    return fechaExpedicion;
  }

  public void setFechaExpedicion(DateTime fechaExpedicion) {
    this.fechaExpedicion = fechaExpedicion;
  }

  public Resultado fechaExpedicion(DateTime fechaExpedicion) {
    this.fechaExpedicion = fechaExpedicion;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Resultado {\n");
    
    sb.append("    claveHojaPadronal: ").append(toIndentedString(claveHojaPadronal)).append("\n");
    sb.append("    domicilio: ").append(toIndentedString(domicilio)).append("\n");
    sb.append("    personas: ").append(toIndentedString(personas)).append("\n");
    sb.append("    fechaExpedicion: ").append(toIndentedString(fechaExpedicion)).append("\n");
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
