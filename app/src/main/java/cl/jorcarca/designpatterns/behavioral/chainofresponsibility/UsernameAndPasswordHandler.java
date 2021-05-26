package cl.jorcarca.designpatterns.behavioral.chainofresponsibility;

import java.util.logging.Level;

public class UsernameAndPasswordHandler extends BaseHandler {

    public UsernameAndPasswordHandler() {
        super();
    }

    public UsernameAndPasswordHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public boolean implementation(AuthenticationProvider authenticationProvider) {
        if (authenticationProvider instanceof UsernameAndPasswordProvider) {
            logger.info("I can handle it! :)");
            internalProcess((UsernameAndPasswordProvider) authenticationProvider);
            return true;
        }
        logger.info("I can\'t handle it! :(");

        return false;
    }

    private void internalProcess(UsernameAndPasswordProvider usernameAndPasswordProvider) {
        logger.log(Level.INFO, "I am doing fancy things with the UsernameAndPasswordProvider: {0}",
                usernameAndPasswordProvider);
    }

}
