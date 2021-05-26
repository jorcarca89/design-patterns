package cl.jorcarca.designpatterns.behavioral.chainofresponsibility;

public class OAuthProvider implements AuthenticationProvider {
    private String credentials;

    public OAuthProvider(String credentials) {
        this.credentials = credentials;
    }

    public String getCredentials() {
        return this.credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "{" + " credentials='" + getCredentials() + "'" + "}";
    }

}
