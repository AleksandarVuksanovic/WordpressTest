package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement welcomeMessage;
    WebElement profileButton;

    public WelcomePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getWelcomeMessage() {
        return driver.findElement(By.xpath("//*[@id=\"primary\"]/main/header/div/div/span/strong"));
    }

    public WebElement getProfileButton() {
        return driver.findElement(By.cssSelector(".gravatar.masterbar__item-me-gravatar"));
    }

    //-------------

    public void clickOnProfileButton () {
        getProfileButton().click();
    }
}
