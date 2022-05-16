package es.caib.scsp.api.cedent.client.SCDCPAJUv3.model;


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

public class Documentacion   {
  public enum TipoEnum {
    NIF("NIF"),
    DNI("DNI"),
    NIE("NIE"),
    PASSAPORT("Passaport");

    private String value;

    TipoEnum(String value) {
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
    public static TipoEnum fromValue(String text) {
      for (TipoEnum b : TipoEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }  
  @Schema(required = true, description = "Possibles valors son NIF, DNI, NIE, Passaport.")
 /**
   * Possibles valors son NIF, DNI, NIE, Passaport.  
  **/
  private TipoEnum tipo = null;
  
  @Schema(required = true, description = "Valor del document del titular sense cap espai en blanc.")
 /**
   * Valor del document del titular sense cap espai en blanc.  
  **/
  private String valor = null;
 /**
   * Possibles valors son NIF, DNI, NIE, Passaport.
   * @return tipo
  **/
  @JsonProperty("tipo")
  public String getTipo() {
    if (tipo == null) {
      return null;
    }
    return tipo.getValue();
  }

  public void setTipo(TipoEnum tipo) {
    this.tipo = tipo;
  }

  public Documentacion tipo(TipoEnum tipo) {
    this.tipo = tipo;
    return this;
  }

 /**
   * Valor del document del titular sense cap espai en blanc.
   * @return valor
  **/
  @JsonProperty("valor")
  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  public Documentacion valor(String valor) {
    this.valor = valor;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Documentacion {\n");
    
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
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
