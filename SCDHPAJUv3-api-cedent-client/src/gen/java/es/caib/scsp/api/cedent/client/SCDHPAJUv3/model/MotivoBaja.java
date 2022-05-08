package es.caib.scsp.api.cedent.client.SCDHPAJUv3.model;


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

public class MotivoBaja   {
  public enum CodigoVariacionEnum {
    B("B"),
    M("M");

    private String value;

    CodigoVariacionEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static CodigoVariacionEnum fromValue(String text) {
      for (CodigoVariacionEnum b : CodigoVariacionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }  
  @Schema(description = "Codi causa d'inscripció al domicili. (A: Alta, M: Modificacion) Si no és cap d'aquestes, no s'informa aquest valor.")
 /**
   * Codi causa d'inscripció al domicili. (A: Alta, M: Modificacion) Si no és cap d'aquestes, no s'informa aquest valor.  
  **/
  private CodigoVariacionEnum codigoVariacion = null;
  
  @Schema(description = "Codi variació inscripció al domicili.")
 /**
   * Codi variació inscripció al domicili.  
  **/
  private String causaVariacion = null;
  
  @Schema(required = true, description = "Nom del nucli del domicili.")
 /**
   * Nom del nucli del domicili.  
  **/
  private String descripcion = null;
 /**
   * Codi causa d&#x27;inscripció al domicili. (A: Alta, M: Modificacion) Si no és cap d&#x27;aquestes, no s&#x27;informa aquest valor.
   * @return codigoVariacion
  **/
  @JsonProperty("codigoVariacion")
  public String getCodigoVariacion() {
    if (codigoVariacion == null) {
      return null;
    }
    return codigoVariacion.getValue();
  }

  public void setCodigoVariacion(CodigoVariacionEnum codigoVariacion) {
    this.codigoVariacion = codigoVariacion;
  }

  public MotivoBaja codigoVariacion(CodigoVariacionEnum codigoVariacion) {
    this.codigoVariacion = codigoVariacion;
    return this;
  }

 /**
   * Codi variació inscripció al domicili.
   * @return causaVariacion
  **/
  @JsonProperty("causaVariacion")
  public String getCausaVariacion() {
    return causaVariacion;
  }

  public void setCausaVariacion(String causaVariacion) {
    this.causaVariacion = causaVariacion;
  }

  public MotivoBaja causaVariacion(String causaVariacion) {
    this.causaVariacion = causaVariacion;
    return this;
  }

 /**
   * Nom del nucli del domicili.
   * @return descripcion
  **/
  @JsonProperty("descripcion")
  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public MotivoBaja descripcion(String descripcion) {
    this.descripcion = descripcion;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MotivoBaja {\n");
    
    sb.append("    codigoVariacion: ").append(toIndentedString(codigoVariacion)).append("\n");
    sb.append("    causaVariacion: ").append(toIndentedString(causaVariacion)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
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
