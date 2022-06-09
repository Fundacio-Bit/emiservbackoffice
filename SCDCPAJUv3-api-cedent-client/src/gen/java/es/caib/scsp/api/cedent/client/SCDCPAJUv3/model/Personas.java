package es.caib.scsp.api.cedent.client.SCDCPAJUv3.model;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Persona;
import java.util.ArrayList;
import java.util.List;

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

public class Personas   {
  
  @Schema(description = "")
  private List<Persona> domicilio = null;
 /**
   * Get domicilio
   * @return domicilio
  **/
  @JsonProperty("domicilio")
  public List<Persona> getDomicilio() {
    return domicilio;
  }

  public void setDomicilio(List<Persona> domicilio) {
    this.domicilio = domicilio;
  }

  public Personas domicilio(List<Persona> domicilio) {
    this.domicilio = domicilio;
    return this;
  }

  public Personas addDomicilioItem(Persona domicilioItem) {
    this.domicilio.add(domicilioItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Personas {\n");
    
    sb.append("    domicilio: ").append(toIndentedString(domicilio)).append("\n");
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
