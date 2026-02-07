package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void successfulLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.navigateToLoginPage();

        loginPage.typeUsername("tomsmith");
        loginPage.typePassword("SuperSecretPassword!");
        loginPage.pressLoginButton();

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful");

        Assert.assertTrue(loginPage.isLoginSecure(), "Page is not a secure page!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
