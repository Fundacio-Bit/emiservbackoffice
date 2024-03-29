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
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.ListaBeneficiariosRetorno;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.TituloFamiliaNumerosaRetorno;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Resultado
 */


public class Resultado {
  @JsonProperty("tituloFamiliaNumerosaRetorno")
  private TituloFamiliaNumerosaRetorno tituloFamiliaNumerosaRetorno = null;

  @JsonProperty("listaBeneficiariosRetorno")
  private ListaBeneficiariosRetorno listaBeneficiariosRetorno = null;

  public Resultado tituloFamiliaNumerosaRetorno(TituloFamiliaNumerosaRetorno tituloFamiliaNumerosaRetorno) {
    this.tituloFamiliaNumerosaRetorno = tituloFamiliaNumerosaRetorno;
    return this;
  }

   /**
   * Get tituloFamiliaNumerosaRetorno
   * @return tituloFamiliaNumerosaRetorno
  **/
  @Schema(description = "")
  public TituloFamiliaNumerosaRetorno getTituloFamiliaNumerosaRetorno() {
    return tituloFamiliaNumerosaRetorno;
  }

  public void setTituloFamiliaNumerosaRetorno(TituloFamiliaNumerosaRetorno tituloFamiliaNumerosaRetorno) {
    this.tituloFamiliaNumerosaRetorno = tituloFamiliaNumerosaRetorno;
  }

  public Resultado listaBeneficiariosRetorno(ListaBeneficiariosRetorno listaBeneficiariosRetorno) {
    this.listaBeneficiariosRetorno = listaBeneficiariosRetorno;
    return this;
  }

   /**
   * Get listaBeneficiariosRetorno
   * @return listaBeneficiariosRetorno
  **/
  @Schema(description = "")
  public ListaBeneficiariosRetorno getListaBeneficiariosRetorno() {
    return listaBeneficiariosRetorno;
  }

  public void setListaBeneficiariosRetorno(ListaBeneficiariosRetorno listaBeneficiariosRetorno) {
    this.listaBeneficiariosRetorno = listaBeneficiariosRetorno;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Resultado resultado = (Resultado) o;
    return Objects.equals(this.tituloFamiliaNumerosaRetorno, resultado.tituloFamiliaNumerosaRetorno) &&
        Objects.equals(this.listaBeneficiariosRetorno, resultado.listaBeneficiariosRetorno);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tituloFamiliaNumerosaRetorno, listaBeneficiariosRetorno);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Resultado {\n");
    
    sb.append("    tituloFamiliaNumerosaRetorno: ").append(toIndentedString(tituloFamiliaNumerosaRetorno)).append("\n");
    sb.append("    listaBeneficiariosRetorno: ").append(toIndentedString(listaBeneficiariosRetorno)).append("\n");
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
