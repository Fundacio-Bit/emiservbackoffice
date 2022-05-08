package es.caib.scsp.api.cedent.client.SCDHPAJUv3.model;

import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.Documentacion;
import es.caib.scsp.api.cedent.client.SCDHPAJUv3.model.HistoricoDomicilios;

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

public class Resultado   {
  
  @Schema(required = true, description = "")
  private String nombre = null;
  
  @Schema(description = "")
  private String particula1 = null;
  
  @Schema(required = true, description = "")
  private String apellido1 = null;
  
  @Schema(description = "")
  private String particula2 = null;
  
  @Schema(description = "")
  private String apellido2 = null;
  
  @Schema(description = "")
  private String fechaNacimiento = null;
  
  @Schema(description = "")
  private Documentacion documentacion = null;
  
  @Schema(required = true, description = "")
  private HistoricoDomicilios historicoDomicilios = null;
  
  @Schema(required = true, description = "")
  private String fechaExpedicion = null;
 /**
   * Get nombre
   * @return nombre
  **/
  @JsonProperty("nombre")
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Resultado nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

 /**
   * Get particula1
   * @return particula1
  **/
  @JsonProperty("particula1")
  public String getParticula1() {
    return particula1;
  }

  public void setParticula1(String particula1) {
    this.particula1 = particula1;
  }

  public Resultado particula1(String particula1) {
    this.particula1 = particula1;
    return this;
  }

 /**
   * Get apellido1
   * @return apellido1
  **/
  @JsonProperty("apellido1")
  public String getApellido1() {
    return apellido1;
  }

  public void setApellido1(String apellido1) {
    this.apellido1 = apellido1;
  }

  public Resultado apellido1(String apellido1) {
    this.apellido1 = apellido1;
    return this;
  }

 /**
   * Get particula2
   * @return particula2
  **/
  @JsonProperty("particula2")
  public String getParticula2() {
    return particula2;
  }

  public void setParticula2(String particula2) {
    this.particula2 = particula2;
  }

  public Resultado particula2(String particula2) {
    this.particula2 = particula2;
    return this;
  }

 /**
   * Get apellido2
   * @return apellido2
  **/
  @JsonProperty("apellido2")
  public String getApellido2() {
    return apellido2;
  }

  public void setApellido2(String apellido2) {
    this.apellido2 = apellido2;
  }

  public Resultado apellido2(String apellido2) {
    this.apellido2 = apellido2;
    return this;
  }

 /**
   * Get fechaNacimiento
   * @return fechaNacimiento
  **/
  @JsonProperty("fechaNacimiento")
  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public Resultado fechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
    return this;
  }

 /**
   * Get documentacion
   * @return documentacion
  **/
  @JsonProperty("documentacion")
  public Documentacion getDocumentacion() {
    return documentacion;
  }

  public void setDocumentacion(Documentacion documentacion) {
    this.documentacion = documentacion;
  }

  public Resultado documentacion(Documentacion documentacion) {
    this.documentacion = documentacion;
    return this;
  }

 /**
   * Get historicoDomicilios
   * @return historicoDomicilios
  **/
  @JsonProperty("historicoDomicilios")
  public HistoricoDomicilios getHistoricoDomicilios() {
    return historicoDomicilios;
  }

  public void setHistoricoDomicilios(HistoricoDomicilios historicoDomicilios) {
    this.historicoDomicilios = historicoDomicilios;
  }

  public Resultado historicoDomicilios(HistoricoDomicilios historicoDomicilios) {
    this.historicoDomicilios = historicoDomicilios;
    return this;
  }

 /**
   * Get fechaExpedicion
   * @return fechaExpedicion
  **/
  @JsonProperty("fechaExpedicion")
  public String getFechaExpedicion() {
    return fechaExpedicion;
  }

  public void setFechaExpedicion(String fechaExpedicion) {
    this.fechaExpedicion = fechaExpedicion;
  }

  public Resultado fechaExpedicion(String fechaExpedicion) {
    this.fechaExpedicion = fechaExpedicion;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Resultado {\n");
    
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    particula1: ").append(toIndentedString(particula1)).append("\n");
    sb.append("    apellido1: ").append(toIndentedString(apellido1)).append("\n");
    sb.append("    particula2: ").append(toIndentedString(particula2)).append("\n");
    sb.append("    apellido2: ").append(toIndentedString(apellido2)).append("\n");
    sb.append("    fechaNacimiento: ").append(toIndentedString(fechaNacimiento)).append("\n");
    sb.append("    documentacion: ").append(toIndentedString(documentacion)).append("\n");
    sb.append("    historicoDomicilios: ").append(toIndentedString(historicoDomicilios)).append("\n");
    sb.append("    fechaExpedicion: ").append(toIndentedString(fechaExpedicion)).append("\n");
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
