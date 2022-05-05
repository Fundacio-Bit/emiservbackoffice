package es.caib.emiservbackoffice.cedent.SCDCPAJUv3;

import es.caib.emiservbackoffice.cedent.SCDCPAJUv3.scsp.TipoDocumentacionSubset;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Documentacion;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.OneOfTitular;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Titular;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Dades emprades al formulari per indicar les dades a verificar del titular.
 */
public class TitularModel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /*
    @NotEmpty
    @Size(max=14) private String valor;
   */
    /**
     * Tipo de documentació. Aquesta enumeració permet molts de valors, però el servei concret de verificació
     * d'identitat només permet emprar DNI o NIE, per això validam que sigui un d'aquests valors.
     */
    /*
    @NotEmpty
    @TipoDocumentacionSubset(anyOf = {Documentacion.TipoEnum.DNI, Documentacion.TipoEnum.NIE, Documentacion.TipoEnum.NIF, Documentacion.TipoEnum.PASSAPORT })
    private String tipo;
    */
    
    @NotEmpty
    @Size(max=40) private String apellido1;
    @Size(max=40)private String apellido2;
    private Timestamp fechaNacimiento;
    @NotEmpty
    @Size(max=40) private String nombre;
    @Size(max=6) private String particula1;
    @Size(max=6) private String particula2;

    

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Timestamp getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Timestamp fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParticula1() {
        return particula1;
    }

    public void setParticula1(String particula1) {
        this.particula1 = particula1;
    }

    public String getParticula2() {
        return particula2;
    }

    public void setParticula2(String particula2) {
        this.particula2 = particula2;
    }
    
    public Titular toTitular() {
        
        OneOfTitular titular = new Documentacion();
        
        
        
        return (Titular)titular;
        
        /*
        DatosPersonales datosPersonales = new DatosPersonales();
        datosPersonales.setApellido1(apellido1);
        datosPersonales.setApellido2(apellido2);
        datosPersonales.setFechaNacimiento(new DateTime(fechaNacimiento));
        datosPersonales.setNombre(nombre);
        datosPersonales.setParticula1(particula1);
        datosPersonales.setParticula2(particula2);
        datosPersonales.setDocumentacion(documentacion);
        return datosPersonales;
        */
    }
    
    
}
