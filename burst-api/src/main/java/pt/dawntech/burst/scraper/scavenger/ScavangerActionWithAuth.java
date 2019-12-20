package pt.dawntech.burst.scraper.scavenger;

import pt.dawntech.burst.auth.AuthProvider;
import pt.dawntech.burst.scraper.ScrapingClient;

public interface ScavangerActionWithAuth {

    void act(AuthProvider authProvider);

}
