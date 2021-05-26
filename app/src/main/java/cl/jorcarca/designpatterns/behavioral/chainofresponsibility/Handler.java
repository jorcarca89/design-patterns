package cl.jorcarca.designpatterns.behavioral.chainofresponsibility;

public interface Handler {
    boolean handle(AuthenticationProvider authenticationProvider);
}
