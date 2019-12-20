package pt.dawntech.burst.auth;

public class CpcdiAuthProvider extends BasicAuthProvider {

    public CpcdiAuthProvider(String clientId, String username, String password) {
        field("clientId", clientId);
        field("username", username);
        field("password", password);
    }

}
