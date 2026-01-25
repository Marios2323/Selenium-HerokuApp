package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;
public class LoginTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
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

        driver.get("https://the-internet.herokuapp.com/login");

        Assert.assertTrue(
                wait.until(ExpectedConditions
                                .visibilityOfElementLocated(By.xpath("//h2[text()='Login Page']")))
                        .isDisplayed(),
                "Login Page is not visible"
        );

        loginPage.typeUsername("tomsmith");
        loginPage.typePassword("SuperSecretPassword!");
        loginPage.pressLoginButton();

        Assert.assertTrue(
                wait.until(ExpectedConditions
                                .visibilityOfElementLocated(By.id("flash")))
                        .getText().contains("You logged into a secure area!"),
                "Login failed"
        );
        Assert.assertTrue(driver.getCurrentUrl().contains("/secure"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
