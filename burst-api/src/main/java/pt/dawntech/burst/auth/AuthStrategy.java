package pt.dawntech.burst.auth;

import pt.dawntech.burst.scraper.scavenger.ScavangerActionWithAuth;

public interface AuthStrategy {

    void provider(AuthProvider authProvider);

    void login(ScavangerActionWithAuth action);

    boolean success();

    String getResultPath();

}
