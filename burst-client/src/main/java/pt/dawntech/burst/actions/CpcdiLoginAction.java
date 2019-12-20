package pt.dawntech.burst.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pt.dawntech.burst.auth.AuthProvider;
import pt.dawntech.burst.scraper.ScrapingClient;
import pt.dawntech.burst.scraper.scavenger.ScavangerActionWithAuth;

public class CpcdiLoginAction implements ScavangerActionWithAuth {

    private WebDriver driver;

    public CpcdiLoginAction(ScrapingClient<?> scrapingClient) {
        if(scrapingClient.getNativeDriver() instanceof WebDriver){
            this.driver = (WebDriver) scrapingClient.getNativeDriver();
        }
    }

    @Override
    public void act(AuthProvider authProvider) {
        if(driver.getCurrentUrl().equalsIgnoreCase("https://www.cpcdi.pt/Home/Index")){
            return;
        }

        driver.get("https://www.cpcdi.pt/Account/Login");

        WebElement submitBtn = driver.findElement(By.xpath("//button[contains(.,'Entrar')]"));
        WebElement clientIdField = driver.findElement(By.id("CodCliente"));
        WebElement usernameField = driver.findElement(By.id("UserName"));
        WebElement passwordField = driver.findElement(By.id("Password"));

        clientIdField.sendKeys(authProvider.getField("clientId"));
        usernameField.sendKeys(authProvider.getField("username"));
        passwordField.sendKeys(authProvider.getField("password"));

        submitBtn.click();

        System.out.println(driver.getCurrentUrl());
    }
}
