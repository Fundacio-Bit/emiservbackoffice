package es.caib.emiservbackoffice.cedent.SCDCPAJUv3.scsp;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Permet validar que un camp de tipus ScspTitular.ScspTipoDocumentacion té un dels valors permsos.
 */
public class ProvinciaSolicitudSubsetValidator
        implements ConstraintValidator<ProvinciaSolicitudSubset, String> {

    private String[] subset;
    
    @Override
    public void initialize(ProvinciaSolicitudSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }

}
