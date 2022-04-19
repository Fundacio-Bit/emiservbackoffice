package es.caib.scsp.api.cedent.client.SCDCPAJUv3.model;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Numero;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.NumeroSuperior;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Via;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

public class Domicilio   {
  
  @Schema(required = true, description = "")
  private Via via = null;
  
  @Schema(description = "")
  private Numero numero = null;
  
  @Schema(description = "")
  private NumeroSuperior numeroSuperior = null;
  
  @Schema(description = "")
  private String kmt = null;
  
  @Schema(description = "")
  private String hmt = null;
  
  @Schema(description = "")
  private String bloque = null;
  
  @Schema(description = "")
  private String portal = null;
  
  @Schema(description = "")
  private String escalera = null;
  
  @Schema(description = "")
  private String planta = null;
  
  @Schema(description = "")
  private String puerta = null;
  
  @Schema(description = "")
  private String codPostal = null;
 /**
   * Get via
   * @return via
  **/
  @JsonProperty("via")
  public Via getVia() {
    return via;
  }

  public void setVia(Via via) {
    this.via = via;
  }

  public Domicilio via(Via via) {
    this.via = via;
    return this;
  }

 /**
   * Get numero
   * @return numero
  **/
  @JsonProperty("numero")
  public Numero getNumero() {
    return numero;
  }

  public void setNumero(Numero numero) {
    this.numero = numero;
  }

  public Domicilio numero(Numero numero) {
    this.numero = numero;
    return this;
  }

 /**
   * Get numeroSuperior
   * @return numeroSuperior
  **/
  @JsonProperty("numeroSuperior")
  public NumeroSuperior getNumeroSuperior() {
    return numeroSuperior;
  }

  public void setNumeroSuperior(NumeroSuperior numeroSuperior) {
    this.numeroSuperior = numeroSuperior;
  }

  public Domicilio numeroSuperior(NumeroSuperior numeroSuperior) {
    this.numeroSuperior = numeroSuperior;
    return this;
  }

 /**
   * Get kmt
   * @return kmt
  **/
  @JsonProperty("kmt")
  public String getKmt() {
    return kmt;
  }

  public void setKmt(String kmt) {
    this.kmt = kmt;
  }

  public Domicilio kmt(String kmt) {
    this.kmt = kmt;
    return this;
  }

 /**
   * Get hmt
   * @return hmt
  **/
  @JsonProperty("hmt")
  public String getHmt() {
    return hmt;
  }

  public void setHmt(String hmt) {
    this.hmt = hmt;
  }

  public Domicilio hmt(String hmt) {
    this.hmt = hmt;
    return this;
  }

 /**
   * Get bloque
   * @return bloque
  **/
  @JsonProperty("bloque")
  public String getBloque() {
    return bloque;
  }

  public void setBloque(String bloque) {
    this.bloque = bloque;
  }

  public Domicilio bloque(String bloque) {
    this.bloque = bloque;
    return this;
  }

 /**
   * Get portal
   * @return portal
  **/
  @JsonProperty("portal")
  public String getPortal() {
    return portal;
  }

  public void setPortal(String portal) {
    this.portal = portal;
  }

  public Domicilio portal(String portal) {
    this.portal = portal;
    return this;
  }

 /**
   * Get escalera
   * @return escalera
  **/
  @JsonProperty("escalera")
  public String getEscalera() {
    return escalera;
  }

  public void setEscalera(String escalera) {
    this.escalera = escalera;
  }

  public Domicilio escalera(String escalera) {
    this.escalera = escalera;
    return this;
  }

 /**
   * Get planta
   * @return planta
  **/
  @JsonProperty("planta")
  public String getPlanta() {
    return planta;
  }

  public void setPlanta(String planta) {
    this.planta = planta;
  }

  public Domicilio planta(String planta) {
    this.planta = planta;
    return this;
  }

 /**
   * Get puerta
   * @return puerta
  **/
  @JsonProperty("puerta")
  public String getPuerta() {
    return puerta;
  }

  public void setPuerta(String puerta) {
    this.puerta = puerta;
  }

  public Domicilio puerta(String puerta) {
    this.puerta = puerta;
    return this;
  }

 /**
   * Get codPostal
   * @return codPostal
  **/
  @JsonProperty("codPostal")
  public String getCodPostal() {
    return codPostal;
  }

  public void setCodPostal(String codPostal) {
    this.codPostal = codPostal;
  }

  public Domicilio codPostal(String codPostal) {
    this.codPostal = codPostal;
    return this;
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
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
