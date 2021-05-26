package cl.jorcarca.designpatterns.behavioral.chainofresponsibility;

public class UsernameAndPasswordProvider implements AuthenticationProvider {
    private String username;
    private String encryptedPassword;

    public UsernameAndPasswordProvider(String username, String encryptedPassword) {
        this.username = username;
        this.encryptedPassword = encryptedPassword;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncryptedPassword() {
        return this.encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    @Override
    public String toString() {
        return "{" + " username='" + getUsername() + "'" + ", encryptedPassword='" + getEncryptedPassword() + "'" + "}";
    }

}
