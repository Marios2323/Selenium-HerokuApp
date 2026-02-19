package tests;

import base.BaseTest;
import drivers.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void successfulLoginTest() {

        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

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

        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

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

        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

        loginPage.navigateToLoginPage();

        //Verifies that the login page is accessible
        Assert.assertTrue(loginPage.isLoginPageVisible(), "Correct message is not shown");

        loginPage.typeUsername("tomsmith");
        loginPage.typePassword("wrongPassword");
        loginPage.pressLoginButton();

        //Verifies the login page is secure
        Assert.assertTrue(loginPage.isWrongPasswordMessageDisplayed(), "Correct message is not shown");
    }
}
