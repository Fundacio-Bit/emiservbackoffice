package es.caib.emiservbackoffice.ws.utils;

import es.caib.emiservbackoffice.commons.i18n.I18NException;
import es.caib.emiservbackoffice.commons.utils.Constants;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.security.SecurityContext;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.invoker.MethodDispatcher;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Locale;

/**
 * Intercepta les cridades entrants a un WS. Veure: Veure https://cxf.apache.org/docs/interceptors.html
 *
 * @author anadal
 */
public class WsInInterceptor extends AbstractPhaseInterceptor<Message> {

    private static final Logger LOG = LoggerFactory.getLogger(WsInInterceptor.class);

    public WsInInterceptor() {
        super(Phase.PRE_INVOKE);
    }

    @Override
    public void handleMessage(Message message) throws Fault {

        LOG.debug("WsInInterceptor::handleMessage() =>  Thread = {}", Thread.currentThread().getId());

        Method method = getTargetMethod(message);
        LOG.debug("  + Method NAME = {}", method.getName());
        LOG.debug("  + Method CLASS = {}", method.getDeclaringClass());

        SecurityContext context = message.get(SecurityContext.class);
        if (context == null || context.getUserPrincipal() == null) {
            LOG.error("S'ha cridat a l'API sense autenticar la petició.");
            return;
        }

        String username = context.getUserPrincipal().getName();
        LOG.info("WsInInterceptor::handleMessage() => username {}", username);
        LOG.info("WsInInterceptor::handleMessage() => EBO_USER {}", context.isUserInRole(Constants.EBO_USER));
        LOG.info("WsInInterceptor::handleMessage() => EBO_ADMIN {}", context.isUserInRole(Constants.EBO_ADMIN));
    }

    private Method getTargetMethod(Message m) {
        BindingOperationInfo bop = m.getExchange().get(BindingOperationInfo.class);
        MethodDispatcher md = (MethodDispatcher) m.getExchange().get(Service.class)
                .get(MethodDispatcher.class.getName());
        return md.getMethod(bop);
    }

    @Override
    public void handleFault(Message message) {

        Fault f = (Fault) message.getContent(Exception.class);

        LOG.error("WsInInterceptor::handleFault() - Code = {}", f.getCode());
        LOG.error("WsInInterceptor::handleFault() - Msg = {}", f.getMessage());

        Throwable cause = f.getCause();

        // TODO obtenir Idioma de l'usuari
        Locale language = Locale.getDefault();

        if (cause != null) {
            LOG.error("WsInInterceptor::handleFault() - Cause Class = " + cause.getClass());
            if (cause instanceof UndeclaredThrowableException) {
                LOG.error("WsInInterceptor::handleFault() - Cause.UndeclaredThrowable");
                cause = ((UndeclaredThrowableException) cause).getUndeclaredThrowable();
            }
            if (cause instanceof I18NException) {
                LOG.error("WsInInterceptor::handleFault() - Cause.I18NException");
                I18NException i18n = (I18NException) cause;
                message.setContent(WsI18NException.class,
                        new WsI18NException(i18n.getLocalizedMessage(language), cause));
            } else {
                LOG.error("WsInInterceptor::handleFault() - Cause.msg = {}", cause.getMessage());
                LOG.error("WsInInterceptor::handleFault() - Cause.type = {}", cause.getClass());
            }
        }

        super.handleFault(message);
    }
}