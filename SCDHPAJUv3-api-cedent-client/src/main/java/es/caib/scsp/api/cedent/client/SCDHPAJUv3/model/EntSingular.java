/*
 * SCDHPAJUv3
 * # This is a SCDHPAJUv3 server spec You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/). For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: pinbal@fundaciobit.org
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.caib.scsp.api.cedent.client.SCDHPAJUv3.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * EntSingular
 */


public class EntSingular {
  @JsonProperty("codigo")
  private String codigo = null;

  @JsonProperty("nombre")
  private String nombre = null;

  public EntSingular codigo(String codigo) {
    this.codigo = codigo;
    return this;
  }

   /**
   * Codi entitat col·lectiva del domicili.
   * @return codigo
  **/
  @Schema(required = true, description = "Codi entitat col·lectiva del domicili.")
  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public EntSingular nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

   /**
   * Nom entitat col·lectiva del domicili.
   * @return nombre
  **/
  @Schema(required = true, description = "Nom entitat col·lectiva del domicili.")
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntSingular entSingular = (EntSingular) o;
    return Objects.equals(this.codigo, entSingular.codigo) &&
        Objects.equals(this.nombre, entSingular.nombre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigo, nombre);
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
