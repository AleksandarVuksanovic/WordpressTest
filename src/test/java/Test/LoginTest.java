package Test;

import Base.BaseTest;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @BeforeMethod
    public void pageSetUp () {
        driver.manage().window().maximize();
        driver.navigate().to("http://www.wordpress.com/");
    }

    @Test (priority = 10)
    public void successfulLogin () throws InterruptedException {
        homepagePage.clickOnLoginButton();
        waitURLToBe("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");
        String username = "aleksandarprvovencani";
        visibilityWait(loginPage.getUsername());
        loginPage.enterUsername(username);
        loginPage.clickOnContinueButton();
        visibilityWait(loginPage.getPassword());
        loginPage.enterPassword("KualaLumpur123");
        loginPage.clickOnContinueButton();
        waitURLToBe("https://wordpress.com/read");

        Assert.assertEquals(welcomePage.getWelcomeMessage().getText(), "Welcome!");
        welcomePage.clickOnProfileButton();

        waitURLToBe("https://wordpress.com/me");
        visibilityWait(profilePage.getProfileName());
        Assert.assertEquals(profilePage.getProfileName().getText(), username);
        Assert.assertTrue(profilePage.getLogoutButton().isDisplayed());
    }

    @Test (priority = 20)
    public void invalidUsername () throws InterruptedException {
        homepagePage.clickOnLoginButton();
        waitURLToBe("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");
        visibilityWait(loginPage.getUsername());
        loginPage.enterUsername("invalidusername");
        loginPage.clickOnContinueButton();
        visibilityWait(loginPage.getPassword());
        loginPage.enterPassword("KualaLumpur123");
        loginPage.clickOnContinueButton();

        Thread.sleep(2000);
        Assert.assertTrue(loginPage.getErrorNotification().isDisplayed());

        boolean check = false;
        try {
            check = welcomePage.getWelcomeMessage().isDisplayed();

        } catch (Exception e) { }
        Assert.assertFalse(check);

    }


}
