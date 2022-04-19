package es.caib.scsp.api.cedent.client.SCDCPAJUv3.model;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.MotivoInscripcion;
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

public class PeriodoInscripcion   {
  
  @Schema(required = true, description = "")
  private DateTime desde = null;
  
  @Schema(required = true, description = "")
  private MotivoInscripcion motivoInscripcion = null;
 /**
   * Get desde
   * @return desde
  **/
  @JsonProperty("desde")
  public DateTime getDesde() {
    return desde;
  }

  public void setDesde(DateTime desde) {
    this.desde = desde;
  }

  public PeriodoInscripcion desde(DateTime desde) {
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

  public PeriodoInscripcion motivoInscripcion(MotivoInscripcion motivoInscripcion) {
    this.motivoInscripcion = motivoInscripcion;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PeriodoInscripcion {\n");
    
    sb.append("    desde: ").append(toIndentedString(desde)).append("\n");
    sb.append("    motivoInscripcion: ").append(toIndentedString(motivoInscripcion)).append("\n");
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
