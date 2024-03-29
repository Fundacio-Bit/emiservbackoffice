/*
 * SVDSCTFNWS01v3
 * # This is a SVDSCTFNWS01v3 server spec You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/). For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: pinbal@fundaciobit.org
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Documentacion
 */


public class Documentacion {
  /**
   * Possibles valors son NIF, DNI, NIE, Passaport.
   */
  public enum TipoEnum {
    NIF("NIF"),
    DNI("DNI"),
    NIE("NIE"),
    PASSAPORT("Passaport");

    private String value;

    TipoEnum(String value) {
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
    public static TipoEnum fromValue(String input) {
      for (TipoEnum b : TipoEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("tipo")
  private TipoEnum tipo = null;

  @JsonProperty("valor")
  private String valor = null;

  public Documentacion tipo(TipoEnum tipo) {
    this.tipo = tipo;
    return this;
  }

   /**
   * Possibles valors son NIF, DNI, NIE, Passaport.
   * @return tipo
  **/
  @Schema(required = true, description = "Possibles valors son NIF, DNI, NIE, Passaport.")
  public TipoEnum getTipo() {
    return tipo;
  }

  public void setTipo(TipoEnum tipo) {
    this.tipo = tipo;
  }

  public Documentacion valor(String valor) {
    this.valor = valor;
    return this;
  }

   /**
   * Valor del document del titular sense cap espai en blanc.
   * @return valor
  **/
  @Schema(required = true, description = "Valor del document del titular sense cap espai en blanc.")
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
    Documentacion documentacion = (Documentacion) o;
    return Objects.equals(this.tipo, documentacion.tipo) &&
        Objects.equals(this.valor, documentacion.valor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tipo, valor);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Documentacion {\n");
    
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
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
