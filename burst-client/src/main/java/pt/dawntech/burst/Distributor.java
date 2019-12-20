package pt.dawntech.burst;

import pt.dawntech.burst.auth.AuthProvider;
import pt.dawntech.burst.auth.AuthStrategy;
import pt.dawntech.burst.scraper.scavenger.ScavangerActionWithAuth;

public class Distributor {

    private AuthStrategy authStrategy;

    public Distributor(AuthStrategy authStrategy, AuthProvider authProvider) {
        this.authStrategy = authStrategy;
        this.authStrategy.provider(authProvider);
    }

    public void login(ScavangerActionWithAuth scavangerAction) {
        authStrategy.login(scavangerAction);
    }

    public String getOrigin() {
        return "";
    }
}
