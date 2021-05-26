package cl.jorcarca.designpatterns.behavioral.chainofresponsibility;

import java.util.logging.Level;

public class OAuthHandler extends BaseHandler {

    public OAuthHandler() {
        super();
    }

    public OAuthHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public boolean implementation(AuthenticationProvider authenticationProvider) {
        if (authenticationProvider instanceof OAuthProvider) {
            logger.info("I can handle it! :)");
            internalProcess((OAuthProvider) authenticationProvider);
            return true;
        }
        logger.info("I can\'t handle it! :(");

        return false;
    }

    private void internalProcess(OAuthProvider oAuthProvider) {
        logger.log(Level.INFO, "I am doing fancy things with the OAuthProvider {0}", oAuthProvider);
    }

}
