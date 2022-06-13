package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement profileName;
    WebElement logoutButton;

    public ProfilePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getProfileName() {
        return driver.findElement(By.className("profile-gravatar__user-display-name"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.className("sidebar__me-signout-text"));
    }

    //------------------


}
