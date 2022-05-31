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
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Documentacion;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.PeriodoInscripcion;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Persona
 */


public class Persona {
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

  @JsonProperty("nia")
  private String nia = null;

  @JsonProperty("periodoInscripcion")
  private PeriodoInscripcion periodoInscripcion = null;

  public Persona nombre(String nombre) {
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

  public Persona particula1(String particula1) {
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

  public Persona apellido1(String apellido1) {
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

  public Persona particula2(String particula2) {
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

  public Persona apellido2(String apellido2) {
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

  public Persona fechaNacimiento(String fechaNacimiento) {
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

  public Persona documentacion(Documentacion documentacion) {
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

  public Persona nia(String nia) {
    this.nia = nia;
    return this;
  }

   /**
   * Get nia
   * @return nia
  **/
  @Schema(description = "")
  public String getNia() {
    return nia;
  }

  public void setNia(String nia) {
    this.nia = nia;
  }

  public Persona periodoInscripcion(PeriodoInscripcion periodoInscripcion) {
    this.periodoInscripcion = periodoInscripcion;
    return this;
  }

   /**
   * Get periodoInscripcion
   * @return periodoInscripcion
  **/
  @Schema(description = "")
  public PeriodoInscripcion getPeriodoInscripcion() {
    return periodoInscripcion;
  }

  public void setPeriodoInscripcion(PeriodoInscripcion periodoInscripcion) {
    this.periodoInscripcion = periodoInscripcion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Persona persona = (Persona) o;
    return Objects.equals(this.nombre, persona.nombre) &&
        Objects.equals(this.particula1, persona.particula1) &&
        Objects.equals(this.apellido1, persona.apellido1) &&
        Objects.equals(this.particula2, persona.particula2) &&
        Objects.equals(this.apellido2, persona.apellido2) &&
        Objects.equals(this.fechaNacimiento, persona.fechaNacimiento) &&
        Objects.equals(this.documentacion, persona.documentacion) &&
        Objects.equals(this.nia, persona.nia) &&
        Objects.equals(this.periodoInscripcion, persona.periodoInscripcion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, particula1, apellido1, particula2, apellido2, fechaNacimiento, documentacion, nia, periodoInscripcion);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Persona {\n");
    
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    particula1: ").append(toIndentedString(particula1)).append("\n");
    sb.append("    apellido1: ").append(toIndentedString(apellido1)).append("\n");
    sb.append("    particula2: ").append(toIndentedString(particula2)).append("\n");
    sb.append("    apellido2: ").append(toIndentedString(apellido2)).append("\n");
    sb.append("    fechaNacimiento: ").append(toIndentedString(fechaNacimiento)).append("\n");
    sb.append("    documentacion: ").append(toIndentedString(documentacion)).append("\n");
    sb.append("    nia: ").append(toIndentedString(nia)).append("\n");
    sb.append("    periodoInscripcion: ").append(toIndentedString(periodoInscripcion)).append("\n");
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
