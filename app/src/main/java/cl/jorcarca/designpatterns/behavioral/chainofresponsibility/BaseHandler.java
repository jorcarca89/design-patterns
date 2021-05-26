package cl.jorcarca.designpatterns.behavioral.chainofresponsibility;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseHandler implements Handler {
    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    private Handler nextHandler = null;

    public abstract boolean implementation(AuthenticationProvider authenticationProvider);

    protected BaseHandler() {
    }

    protected BaseHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public boolean handle(AuthenticationProvider authenticationProvider) {
        logger.info("Can I handle the request?");
        boolean canIHandleIt = implementation(authenticationProvider);
        logger.log(Level.INFO, "Could I handle it? {0}", Boolean.toString(canIHandleIt));
        if (!canIHandleIt) {
            logger.info("Passing the request to the next handler in the chain");
            return !Objects.isNull(nextHandler) ? nextHandler.handle(authenticationProvider) : false;
        }
        return true;
    }
}
