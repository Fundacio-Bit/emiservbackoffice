/*
 * SCDCPAJUv3
 * # This is a SCDCPAJUv3 server spec You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/). For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: pinbal@fundaciobit.org
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.caib.scsp.api.cedent.client.SCDCPAJUv3.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * NumeroSuperior
 */


public class NumeroSuperior {
  @JsonProperty("calificador")
  private String calificador = null;

  @JsonProperty("valor")
  private String valor = null;

  public NumeroSuperior calificador(String calificador) {
    this.calificador = calificador;
    return this;
  }

   /**
   * Qualificador número superior.
   * @return calificador
  **/
  @Schema(description = "Qualificador número superior.")
  public String getCalificador() {
    return calificador;
  }

  public void setCalificador(String calificador) {
    this.calificador = calificador;
  }

  public NumeroSuperior valor(String valor) {
    this.valor = valor;
    return this;
  }

   /**
   * Valor número superior.
   * @return valor
  **/
  @Schema(description = "Valor número superior.")
  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NumeroSuperior numeroSuperior = (NumeroSuperior) o;
    return Objects.equals(this.calificador, numeroSuperior.calificador) &&
        Objects.equals(this.valor, numeroSuperior.valor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(calificador, valor);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NumeroSuperior {\n");
    
    sb.append("    calificador: ").append(toIndentedString(calificador)).append("\n");
    sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
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
