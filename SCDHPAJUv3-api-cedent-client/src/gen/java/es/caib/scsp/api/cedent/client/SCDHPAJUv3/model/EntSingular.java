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

public class EntSingular   {
  
  @Schema(required = true, description = "Codi entitat col·lectiva del domicili.")
 /**
   * Codi entitat col·lectiva del domicili.  
  **/
  private String codigo = null;
  
  @Schema(required = true, description = "Nom entitat col·lectiva del domicili.")
 /**
   * Nom entitat col·lectiva del domicili.  
  **/
  private String nombre = null;
 /**
   * Codi entitat col·lectiva del domicili.
   * @return codigo
  **/
  @JsonProperty("codigo")
  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public EntSingular codigo(String codigo) {
    this.codigo = codigo;
    return this;
  }

 /**
   * Nom entitat col·lectiva del domicili.
   * @return nombre
  **/
  @JsonProperty("nombre")
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public EntSingular nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntSingular {\n");
    
    sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
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
