package es.caib.emiservbackoffice.cedent.SCDCPAJUv3;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import es.caib.emiservbackoffice.cedent.SCDCPAJUv3.scsp.ProvinciaSolicitudSubset;
import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Documentacion;

/**
 * Dades emprades al formulari per indicar les dades a verificar del titular.
 */
public class DocumentacionModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Size(max=14) private String valor;

    /**
     * Tipo de documentació. Aquesta enumeració permet molts de valors, però el servei concret de verificació
     * d'identitat només permet emprar DNI o NIE, per això validam que sigui un d'aquests valors.
     */
    @NotNull
    @DocumentacionSubset(anyOf = {Documentacion.TipoEnum.DNI, Documentacion.TipoEnum.NIE, Documentacion.TipoEnum.NIF, Documentacion.TipoEnum.PASSAPORT })
    private Documentacion.TipoEnum tipo;

  

    


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrimerCognom() {
        return primerCognom;
    }

    public void setPrimerCognom(String primerCognom) {
        this.primerCognom = primerCognom;
    }

    public String getSegonCognom() {
        return segonCognom;
    }

    public void setSegonCognom(String segonCognom) {
        this.segonCognom = segonCognom;
    }

    public ScspTitular toScspTitular() {
        ScspTitular titular = new ScspTitular();
        titular.setTipoDocumentacion(tipusDocumentacio);
        titular.setDocumentacion(documentacio);
        titular.setNombre(nom);
        titular.setApellido1(primerCognom);
        titular.setApellido2(segonCognom);
        return titular;
    }
}
