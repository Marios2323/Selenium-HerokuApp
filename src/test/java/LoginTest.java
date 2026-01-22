import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

        driver.get("https://the-internet.herokuapp.com/login");

        // ASSERT: Login page loaded
        Assert.assertTrue(
                wait.until(ExpectedConditions
                                .visibilityOfElementLocated(By.xpath("//h2[text()='Login Page']")))
                        .isDisplayed(),
                "Login Page is not visible"
        );

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();

        // ASSERT: Success message
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
