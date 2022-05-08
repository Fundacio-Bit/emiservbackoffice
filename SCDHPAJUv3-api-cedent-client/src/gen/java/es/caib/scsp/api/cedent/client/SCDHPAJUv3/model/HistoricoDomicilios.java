package es.caib.scsp.api.cedent.client.SCDHPAJUv3.model;

import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Domicilio;
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

public class HistoricoDomicilios   {
  
  @Schema(description = "")
  private List<Domicilio> domicilio = null;
 /**
   * Get domicilio
   * @return domicilio
  **/
  @JsonProperty("domicilio")
  public List<Domicilio> getDomicilio() {
    return domicilio;
  }

  public void setDomicilio(List<Domicilio> domicilio) {
    this.domicilio = domicilio;
  }

  public HistoricoDomicilios domicilio(List<Domicilio> domicilio) {
    this.domicilio = domicilio;
    return this;
  }

  public HistoricoDomicilios addDomicilioItem(Domicilio domicilioItem) {
    this.domicilio.add(domicilioItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HistoricoDomicilios {\n");
    
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
