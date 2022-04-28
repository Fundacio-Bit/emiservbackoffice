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
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Persona;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * Personas
 */


public class Personas {
  @JsonProperty("domicilio")
  private List<Persona> domicilio = null;

  public Personas domicilio(List<Persona> domicilio) {
    this.domicilio = domicilio;
    return this;
  }

  public Personas addDomicilioItem(Persona domicilioItem) {
    if (this.domicilio == null) {
      this.domicilio = new ArrayList<Persona>();
    }
    this.domicilio.add(domicilioItem);
    return this;
  }

   /**
   * Get domicilio
   * @return domicilio
  **/
  @Schema(description = "")
  public List<Persona> getDomicilio() {
    return domicilio;
  }

  public void setDomicilio(List<Persona> domicilio) {
    this.domicilio = domicilio;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Personas personas = (Personas) o;
    return Objects.equals(this.domicilio, personas.domicilio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(domicilio);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Personas {\n");
    
    sb.append("    domicilio: ").append(toIndentedString(domicilio)).append("\n");
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
