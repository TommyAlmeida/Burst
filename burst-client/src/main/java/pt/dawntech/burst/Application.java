package pt.dawntech.burst;

import io.github.cdimascio.dotenv.Dotenv;
import pt.dawntech.burst.actions.CpcdiLoginAction;
import pt.dawntech.burst.auth.AuthProvider;
import pt.dawntech.burst.auth.AuthStrategy;
import pt.dawntech.burst.auth.CpcdiAuthProvider;
import pt.dawntech.burst.auth.CpcdiAuthStrategy;
import pt.dawntech.burst.scraper.ScrapingClient;
import pt.dawntech.burst.scraper.selenium.SeleniumClient;
import pt.dawntech.burst.utils.EnvVariables;

public final class Application implements BurstApplication {

    @Override
    public void start() {
        Dotenv dotenv = Dotenv.load();
        String webdriver = dotenv.get(EnvVariables.WEBDRIVER);

        ScrapingClient<?> scrapingClient = new SeleniumClient(webdriver);

        AuthStrategy cpcdiAuthStrategy = new CpcdiAuthStrategy(scrapingClient);
        AuthProvider cpcdiAuthProvider = new CpcdiAuthProvider(
                dotenv.get(EnvVariables.CPCDI_CLIENTID),
                dotenv.get(EnvVariables.CPCDI_USER),
                dotenv.get(EnvVariables.CPCDI_PASSWORD)
        );

        Distributor cpcdi = new Distributor(cpcdiAuthStrategy, cpcdiAuthProvider);
        cpcdi.login(new CpcdiLoginAction(scrapingClient));
    }
}
