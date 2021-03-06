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
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Numero;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.NumeroSuperior;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Via;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Domicilio
 */


public class Domicilio {
  @JsonProperty("via")
  private Via via = null;

  @JsonProperty("numero")
  private Numero numero = null;

  @JsonProperty("numeroSuperior")
  private NumeroSuperior numeroSuperior = null;

  @JsonProperty("kmt")
  private String kmt = null;

  @JsonProperty("hmt")
  private String hmt = null;

  @JsonProperty("bloque")
  private String bloque = null;

  @JsonProperty("portal")
  private String portal = null;

  @JsonProperty("escalera")
  private String escalera = null;

  @JsonProperty("planta")
  private String planta = null;

  @JsonProperty("puerta")
  private String puerta = null;

  @JsonProperty("codPostal")
  private String codPostal = null;

  public Domicilio via(Via via) {
    this.via = via;
    return this;
  }

   /**
   * Get via
   * @return via
  **/
  @Schema(required = true, description = "")
  public Via getVia() {
    return via;
  }

  public void setVia(Via via) {
    this.via = via;
  }

  public Domicilio numero(Numero numero) {
    this.numero = numero;
    return this;
  }

   /**
   * Get numero
   * @return numero
  **/
  @Schema(description = "")
  public Numero getNumero() {
    return numero;
  }

  public void setNumero(Numero numero) {
    this.numero = numero;
  }

  public Domicilio numeroSuperior(NumeroSuperior numeroSuperior) {
    this.numeroSuperior = numeroSuperior;
    return this;
  }

   /**
   * Get numeroSuperior
   * @return numeroSuperior
  **/
  @Schema(description = "")
  public NumeroSuperior getNumeroSuperior() {
    return numeroSuperior;
  }

  public void setNumeroSuperior(NumeroSuperior numeroSuperior) {
    this.numeroSuperior = numeroSuperior;
  }

  public Domicilio kmt(String kmt) {
    this.kmt = kmt;
    return this;
  }

   /**
   * Get kmt
   * @return kmt
  **/
  @Schema(description = "")
  public String getKmt() {
    return kmt;
  }

  public void setKmt(String kmt) {
    this.kmt = kmt;
  }

  public Domicilio hmt(String hmt) {
    this.hmt = hmt;
    return this;
  }

   /**
   * Get hmt
   * @return hmt
  **/
  @Schema(description = "")
  public String getHmt() {
    return hmt;
  }

  public void setHmt(String hmt) {
    this.hmt = hmt;
  }

  public Domicilio bloque(String bloque) {
    this.bloque = bloque;
    return this;
  }

   /**
   * Get bloque
   * @return bloque
  **/
  @Schema(description = "")
  public String getBloque() {
    return bloque;
  }

  public void setBloque(String bloque) {
    this.bloque = bloque;
  }

  public Domicilio portal(String portal) {
    this.portal = portal;
    return this;
  }

   /**
   * Get portal
   * @return portal
  **/
  @Schema(description = "")
  public String getPortal() {
    return portal;
  }

  public void setPortal(String portal) {
    this.portal = portal;
  }

  public Domicilio escalera(String escalera) {
    this.escalera = escalera;
    return this;
  }

   /**
   * Get escalera
   * @return escalera
  **/
  @Schema(description = "")
  public String getEscalera() {
    return escalera;
  }

  public void setEscalera(String escalera) {
    this.escalera = escalera;
  }

  public Domicilio planta(String planta) {
    this.planta = planta;
    return this;
  }

   /**
   * Get planta
   * @return planta
  **/
  @Schema(description = "")
  public String getPlanta() {
    return planta;
  }

  public void setPlanta(String planta) {
    this.planta = planta;
  }

  public Domicilio puerta(String puerta) {
    this.puerta = puerta;
    return this;
  }

   /**
   * Get puerta
   * @return puerta
  **/
  @Schema(description = "")
  public String getPuerta() {
    return puerta;
  }

  public void setPuerta(String puerta) {
    this.puerta = puerta;
  }

  public Domicilio codPostal(String codPostal) {
    this.codPostal = codPostal;
    return this;
  }

   /**
   * Get codPostal
   * @return codPostal
  **/
  @Schema(description = "")
  public String getCodPostal() {
    return codPostal;
  }

  public void setCodPostal(String codPostal) {
    this.codPostal = codPostal;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Domicilio domicilio = (Domicilio) o;
    return Objects.equals(this.via, domicilio.via) &&
        Objects.equals(this.numero, domicilio.numero) &&
        Objects.equals(this.numeroSuperior, domicilio.numeroSuperior) &&
        Objects.equals(this.kmt, domicilio.kmt) &&
        Objects.equals(this.hmt, domicilio.hmt) &&
        Objects.equals(this.bloque, domicilio.bloque) &&
        Objects.equals(this.portal, domicilio.portal) &&
        Objects.equals(this.escalera, domicilio.escalera) &&
        Objects.equals(this.planta, domicilio.planta) &&
        Objects.equals(this.puerta, domicilio.puerta) &&
        Objects.equals(this.codPostal, domicilio.codPostal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(via, numero, numeroSuperior, kmt, hmt, bloque, portal, escalera, planta, puerta, codPostal);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Domicilio {\n");
    
    sb.append("    via: ").append(toIndentedString(via)).append("\n");
    sb.append("    numero: ").append(toIndentedString(numero)).append("\n");
    sb.append("    numeroSuperior: ").append(toIndentedString(numeroSuperior)).append("\n");
    sb.append("    kmt: ").append(toIndentedString(kmt)).append("\n");
    sb.append("    hmt: ").append(toIndentedString(hmt)).append("\n");
    sb.append("    bloque: ").append(toIndentedString(bloque)).append("\n");
    sb.append("    portal: ").append(toIndentedString(portal)).append("\n");
    sb.append("    escalera: ").append(toIndentedString(escalera)).append("\n");
    sb.append("    planta: ").append(toIndentedString(planta)).append("\n");
    sb.append("    puerta: ").append(toIndentedString(puerta)).append("\n");
    sb.append("    codPostal: ").append(toIndentedString(codPostal)).append("\n");
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
