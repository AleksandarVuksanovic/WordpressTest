package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement username;
    WebElement password;
    WebElement continueButton;
    WebElement errorNotification;

    public LoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getUsername() {
        return driver.findElement(By.id("usernameOrEmail"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.cssSelector(".button.form-button.is-primary"));
    }

    public WebElement getErrorNotification() {
        return driver.findElement(By.cssSelector(".form-input-validation.is-error"));
    }

    //----------

    public void enterUsername (String userName) {
        getUsername().clear();
        getUsername().sendKeys(userName);
    }

    public void enterPassword (String pass) {
        getPassword().clear();
        getPassword().sendKeys(pass);
    }

    public void clickOnContinueButton () {
        getContinueButton().click();
    }
}
