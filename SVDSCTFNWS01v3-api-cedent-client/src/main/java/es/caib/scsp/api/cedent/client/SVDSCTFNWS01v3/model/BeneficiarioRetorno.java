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
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Documentacion;
import es.caib.scsp.api.cedent.client.SVDSCTFNWS01v3.model.Titular;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * BeneficiarioRetorno
 */


public class BeneficiarioRetorno {
  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("particula1")
  private String particula1 = null;

  @JsonProperty("apellido1")
  private String apellido1 = null;

  @JsonProperty("particula2")
  private String particula2 = null;

  @JsonProperty("apellido2")
  private String apellido2 = null;

  @JsonProperty("fechaNacimiento")
  private String fechaNacimiento = null;

  @JsonProperty("documentacion")
  private Documentacion documentacion = null;

  @JsonProperty("titular")
  private Titular titular = null;

  public BeneficiarioRetorno nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

   /**
   * Get nombre
   * @return nombre
  **/
  @Schema(required = true, description = "")
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public BeneficiarioRetorno particula1(String particula1) {
    this.particula1 = particula1;
    return this;
  }

   /**
   * Get particula1
   * @return particula1
  **/
  @Schema(description = "")
  public String getParticula1() {
    return particula1;
  }

  public void setParticula1(String particula1) {
    this.particula1 = particula1;
  }

  public BeneficiarioRetorno apellido1(String apellido1) {
    this.apellido1 = apellido1;
    return this;
  }

   /**
   * Get apellido1
   * @return apellido1
  **/
  @Schema(required = true, description = "")
  public String getApellido1() {
    return apellido1;
  }

  public void setApellido1(String apellido1) {
    this.apellido1 = apellido1;
  }

  public BeneficiarioRetorno particula2(String particula2) {
    this.particula2 = particula2;
    return this;
  }

   /**
   * Get particula2
   * @return particula2
  **/
  @Schema(description = "")
  public String getParticula2() {
    return particula2;
  }

  public void setParticula2(String particula2) {
    this.particula2 = particula2;
  }

  public BeneficiarioRetorno apellido2(String apellido2) {
    this.apellido2 = apellido2;
    return this;
  }

   /**
   * Get apellido2
   * @return apellido2
  **/
  @Schema(description = "")
  public String getApellido2() {
    return apellido2;
  }

  public void setApellido2(String apellido2) {
    this.apellido2 = apellido2;
  }

  public BeneficiarioRetorno fechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
    return this;
  }

   /**
   * Get fechaNacimiento
   * @return fechaNacimiento
  **/
  @Schema(description = "")
  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public BeneficiarioRetorno documentacion(Documentacion documentacion) {
    this.documentacion = documentacion;
    return this;
  }

   /**
   * Get documentacion
   * @return documentacion
  **/
  @Schema(description = "")
  public Documentacion getDocumentacion() {
    return documentacion;
  }

  public void setDocumentacion(Documentacion documentacion) {
    this.documentacion = documentacion;
  }

  public BeneficiarioRetorno titular(Titular titular) {
    this.titular = titular;
    return this;
  }

   /**
   * Get titular
   * @return titular
  **/
  @Schema(description = "")
  public Titular getTitular() {
    return titular;
  }

  public void setTitular(Titular titular) {
    this.titular = titular;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BeneficiarioRetorno beneficiarioRetorno = (BeneficiarioRetorno) o;
    return Objects.equals(this.nombre, beneficiarioRetorno.nombre) &&
        Objects.equals(this.particula1, beneficiarioRetorno.particula1) &&
        Objects.equals(this.apellido1, beneficiarioRetorno.apellido1) &&
        Objects.equals(this.particula2, beneficiarioRetorno.particula2) &&
        Objects.equals(this.apellido2, beneficiarioRetorno.apellido2) &&
        Objects.equals(this.fechaNacimiento, beneficiarioRetorno.fechaNacimiento) &&
        Objects.equals(this.documentacion, beneficiarioRetorno.documentacion) &&
        Objects.equals(this.titular, beneficiarioRetorno.titular);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, particula1, apellido1, particula2, apellido2, fechaNacimiento, documentacion, titular);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BeneficiarioRetorno {\n");
    
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    particula1: ").append(toIndentedString(particula1)).append("\n");
    sb.append("    apellido1: ").append(toIndentedString(apellido1)).append("\n");
    sb.append("    particula2: ").append(toIndentedString(particula2)).append("\n");
    sb.append("    apellido2: ").append(toIndentedString(apellido2)).append("\n");
    sb.append("    fechaNacimiento: ").append(toIndentedString(fechaNacimiento)).append("\n");
    sb.append("    documentacion: ").append(toIndentedString(documentacion)).append("\n");
    sb.append("    titular: ").append(toIndentedString(titular)).append("\n");
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
