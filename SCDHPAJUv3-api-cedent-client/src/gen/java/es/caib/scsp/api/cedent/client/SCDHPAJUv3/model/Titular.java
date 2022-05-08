package es.caib.scsp.api.cedent.client.SCDHPAJUv3.model;

import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.DatosPersonales;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Documentacion;

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

public class Titular   {
  
  @Schema(description = "")
  private Documentacion documentacion = null;
  
  @Schema(description = "")
  private DatosPersonales datosPersonales = null;
  
  @Schema(description = "")
  private String nia = null;
 /**
   * Get documentacion
   * @return documentacion
  **/
  @JsonProperty("documentacion")
  public Documentacion getDocumentacion() {
    return documentacion;
  }

  public void setDocumentacion(Documentacion documentacion) {
    this.documentacion = documentacion;
  }

  public Titular documentacion(Documentacion documentacion) {
    this.documentacion = documentacion;
    return this;
  }

 /**
   * Get datosPersonales
   * @return datosPersonales
  **/
  @JsonProperty("datosPersonales")
  public DatosPersonales getDatosPersonales() {
    return datosPersonales;
  }

  public void setDatosPersonales(DatosPersonales datosPersonales) {
    this.datosPersonales = datosPersonales;
  }

  public Titular datosPersonales(DatosPersonales datosPersonales) {
    this.datosPersonales = datosPersonales;
    return this;
  }

 /**
   * Get nia
   * @return nia
  **/
  @JsonProperty("nia")
  public String getNia() {
    return nia;
  }

  public void setNia(String nia) {
    this.nia = nia;
  }

  public Titular nia(String nia) {
    this.nia = nia;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Titular {\n");
    
    sb.append("    documentacion: ").append(toIndentedString(documentacion)).append("\n");
    sb.append("    datosPersonales: ").append(toIndentedString(datosPersonales)).append("\n");
    sb.append("    nia: ").append(toIndentedString(nia)).append("\n");
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
