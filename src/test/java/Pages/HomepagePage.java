package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomepagePage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement loginButton;

    public HomepagePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//*[@id=\"lpc-header-nav\"]/div/div/div[1]/div/nav/ul[2]/li[1]/a"));
    }

    //-------------

    public void clickOnLoginButton () {
        getLoginButton().click();
    }
}
