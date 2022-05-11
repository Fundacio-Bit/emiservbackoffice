package es.caib.emiservbackoffice.cedent.SCDCPAJUv3.scsp;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Documentacion;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Permet validar que un camp de tipus ScspTitular.ScspTipoDocumentacion té un dels valors permsos.
 */
public class TipoDocumentacionSubsetValidator
        implements ConstraintValidator<TipoDocumentacionSubset, Documentacion.TipoEnum> {

    private Documentacion.TipoEnum[] subset;
    
    @Override
    public void initialize(TipoDocumentacionSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(Documentacion.TipoEnum value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
    
  

}
