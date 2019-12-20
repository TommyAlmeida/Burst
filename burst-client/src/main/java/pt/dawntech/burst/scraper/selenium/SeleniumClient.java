package pt.dawntech.burst.scraper.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pt.dawntech.burst.scraper.ScrapingClient;


public final class SeleniumClient implements ScrapingClient<WebDriver> {

    private WebDriver driver;

    public SeleniumClient(String driverPath){
        init(driverPath);
    }

    @Override
    public void init(String driverPath) {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    private ChromeOptions options(){
        return null;
    }

    @Override
    public WebDriver getNativeDriver() {
        return driver;
    }
}
