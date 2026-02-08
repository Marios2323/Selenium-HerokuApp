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

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void successfulLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.navigateToLoginPage();

        //Verifies that the login page is accessible
        Assert.assertTrue(loginPage.isLoginPageVisible(), "Login page is not available");

        loginPage.typeUsername("tomsmith");
        loginPage.typePassword("SuperSecretPassword!");
        loginPage.pressLoginButton();

        //Verifies the login page is secure
        Assert.assertTrue(loginPage.isLoginSecure(), "Page is not a secure page!");
    }

    @Test
    public void wrongUsernameTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.navigateToLoginPage();

        //Verifies that the login page is accessible
        Assert.assertTrue(loginPage.isLoginPageVisible(), "Login page is not available");

        loginPage.typeUsername("wrongUsername");
        loginPage.typePassword("SuperSecretPassword!");
        loginPage.pressLoginButton();

        //Verifies the login page is secure
        Assert.assertTrue(loginPage.isWrongUsernameMessageDisplayed(), "Correct message is not shown");
    }

    @Test
    public void wrongPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.navigateToLoginPage();

        //Verifies that the login page is accessible
        Assert.assertTrue(loginPage.isLoginPageVisible(), "Correct message is not shown");

        loginPage.typeUsername("tomsmith");
        loginPage.typePassword("wrongPassword");
        loginPage.pressLoginButton();

        //Verifies the login page is secure
        Assert.assertTrue(loginPage.isWrongPasswordMessageDisplayed(), "Correct message is not shown");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
