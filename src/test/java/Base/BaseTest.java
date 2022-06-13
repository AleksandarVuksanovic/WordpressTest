package Base;

import Pages.HomepagePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import Pages.WelcomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public HomepagePage homepagePage;
    public LoginPage loginPage;
    public WelcomePage welcomePage;
    public ProfilePage profilePage;

    @BeforeClass
    public void setUp () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homepagePage = new HomepagePage(driver, wdwait);
        loginPage = new LoginPage(driver, wdwait);
        welcomePage = new WelcomePage(driver, wdwait);
        profilePage = new ProfilePage(driver, wdwait);


    }

    public void visibilityWait (WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitURLToBe (String url) {
        wdwait.until(ExpectedConditions.urlToBe(url));
    }

    @AfterClass
    public void tearDown () {
        //driver.close();
        //driver.quit();
    }

}
