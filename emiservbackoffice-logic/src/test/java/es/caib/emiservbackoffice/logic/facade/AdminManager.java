package es.caib.emiservbackoffice.logic.facade;

import es.caib.emiservbackoffice.commons.utils.Constants;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
import javax.ejb.Stateless;

/**
 * EJB d'utilitat per pemetre executar mètodes amb permisos
 */
@Stateless
@RunAs(Constants.EBO_ADMIN)
@PermitAll
public class AdminManager {

    public void exec(Runnable runnable) {
        runnable.run();
    }
}