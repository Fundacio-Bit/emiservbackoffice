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
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets Titular
 */
public enum Titular {
  S("S"),
  N("N");

  private String value;

  Titular(String value) {
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
  public static Titular fromValue(String input) {
    for (Titular b : Titular.values()) {
      if (b.value.equals(input)) {
        return b;
      }
    }
    return null;
  }
}
