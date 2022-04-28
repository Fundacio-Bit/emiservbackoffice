package es.caib.scsp.api.cedent.client.SCDCPAJUv3.model;


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

public class ClaveHojaPadronal   {
  
  @Schema(required = true, description = "Dada districte del domicili al padró municipal.")
 /**
   * Dada districte del domicili al padró municipal.  
  **/
  private String distrito = null;
  
  @Schema(required = true, description = "Dada secció del domicili al padró municipal.")
 /**
   * Dada secció del domicili al padró municipal.  
  **/
  private String seccion = null;
  
  @Schema(required = true, description = "Dada fulla d'inscripció del domicili al padró municipal.")
 /**
   * Dada fulla d'inscripció del domicili al padró municipal.  
  **/
  private String hoja = null;
 /**
   * Dada districte del domicili al padró municipal.
   * @return distrito
  **/
  @JsonProperty("distrito")
  public String getDistrito() {
    return distrito;
  }

  public void setDistrito(String distrito) {
    this.distrito = distrito;
  }

  public ClaveHojaPadronal distrito(String distrito) {
    this.distrito = distrito;
    return this;
  }

 /**
   * Dada secció del domicili al padró municipal.
   * @return seccion
  **/
  @JsonProperty("seccion")
  public String getSeccion() {
    return seccion;
  }

  public void setSeccion(String seccion) {
    this.seccion = seccion;
  }

  public ClaveHojaPadronal seccion(String seccion) {
    this.seccion = seccion;
    return this;
  }

 /**
   * Dada fulla d&#x27;inscripció del domicili al padró municipal.
   * @return hoja
  **/
  @JsonProperty("hoja")
  public String getHoja() {
    return hoja;
  }

  public void setHoja(String hoja) {
    this.hoja = hoja;
  }

  public ClaveHojaPadronal hoja(String hoja) {
    this.hoja = hoja;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClaveHojaPadronal {\n");
    
    sb.append("    distrito: ").append(toIndentedString(distrito)).append("\n");
    sb.append("    seccion: ").append(toIndentedString(seccion)).append("\n");
    sb.append("    hoja: ").append(toIndentedString(hoja)).append("\n");
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
