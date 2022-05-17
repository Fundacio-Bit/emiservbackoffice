package es.caib.scsp.api.cedent.client.SCDHPAJUv3.model;


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

public class NumeroSuperior   {
  
  @Schema(description = "Qualificador número superior.")
 /**
   * Qualificador número superior.  
  **/
  private String calificador = null;
  
  @Schema(description = "Valor número superior.")
 /**
   * Valor número superior.  
  **/
  private String valor = null;
 /**
   * Qualificador número superior.
   * @return calificador
  **/
  @JsonProperty("calificador")
  public String getCalificador() {
    return calificador;
  }

  public void setCalificador(String calificador) {
    this.calificador = calificador;
  }

  public NumeroSuperior calificador(String calificador) {
    this.calificador = calificador;
    return this;
  }

 /**
   * Valor número superior.
   * @return valor
  **/
  @JsonProperty("valor")
  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  public NumeroSuperior valor(String valor) {
    this.valor = valor;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NumeroSuperior {\n");
    
    sb.append("    calificador: ").append(toIndentedString(calificador)).append("\n");
    sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
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