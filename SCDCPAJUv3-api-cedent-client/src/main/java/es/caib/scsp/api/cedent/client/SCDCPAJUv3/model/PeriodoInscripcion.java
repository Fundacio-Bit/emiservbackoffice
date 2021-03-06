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
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.MotivoInscripcion;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * PeriodoInscripcion
 */


public class PeriodoInscripcion {
  @JsonProperty("desde")
  private String desde = null;

  @JsonProperty("motivoInscripcion")
  private MotivoInscripcion motivoInscripcion = null;

  public PeriodoInscripcion desde(String desde) {
    this.desde = desde;
    return this;
  }

   /**
   * Get desde
   * @return desde
  **/
  @Schema(required = true, description = "")
  public String getDesde() {
    return desde;
  }

  public void setDesde(String desde) {
    this.desde = desde;
  }

  public PeriodoInscripcion motivoInscripcion(MotivoInscripcion motivoInscripcion) {
    this.motivoInscripcion = motivoInscripcion;
    return this;
  }

   /**
   * Get motivoInscripcion
   * @return motivoInscripcion
  **/
  @Schema(required = true, description = "")
  public MotivoInscripcion getMotivoInscripcion() {
    return motivoInscripcion;
  }

  public void setMotivoInscripcion(MotivoInscripcion motivoInscripcion) {
    this.motivoInscripcion = motivoInscripcion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PeriodoInscripcion periodoInscripcion = (PeriodoInscripcion) o;
    return Objects.equals(this.desde, periodoInscripcion.desde) &&
        Objects.equals(this.motivoInscripcion, periodoInscripcion.motivoInscripcion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(desde, motivoInscripcion);
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
