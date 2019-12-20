package pt.dawntech.burst.auth;

import pt.dawntech.burst.scraper.scavenger.ScavangerActionWithAuth;
import pt.dawntech.burst.scraper.ScrapingClient;

public class CpcdiAuthStrategy implements AuthStrategy {

    private ScrapingClient<?> scrapingClient;

    private AuthProvider authProvider;

    public CpcdiAuthStrategy(ScrapingClient<?> scrapingClient) {
        this.scrapingClient = scrapingClient;
    }

    public void provider(AuthProvider authProvider) {
        this.authProvider = authProvider;
    }

    public void login(ScavangerActionWithAuth scavangerAction) {
        scavangerAction.act(authProvider);
    }

    public boolean success() {
        return false;
    }

    public String getResultPath() {
        return null;
    }
}
