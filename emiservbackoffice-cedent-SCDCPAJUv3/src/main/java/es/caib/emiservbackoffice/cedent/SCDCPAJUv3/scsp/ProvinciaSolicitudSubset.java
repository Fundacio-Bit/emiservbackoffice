package es.caib.emiservbackoffice.cedent.SCDCPAJUv3.scsp;

import es.caib.scsp.api.cedent.client.SCDCPAJUv3.model.Solicitud;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Anotació per validar que els camps del tipus ScspTitular.ScspTipoDocumentacion estan
 * dins un dels valors possibles.
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ProvinciaSolicitudSubsetValidator.class)
public @interface ProvinciaSolicitudSubset {

    String[] anyOf();
  
    String message() default "ha de ser qualsevol de {anyOf}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
