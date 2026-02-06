package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Happy path
    private By username = By.name("username");
    private By password = By.name("password");
    private By loginButton = By.xpath("//button[contains(.,'Login')]");

    //Constructor is manadotory inside POM
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void navigateToLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void typeUsername(String username) {
        driver.findElement(this.username)
                .sendKeys(username);
    };

    public void typePassword(String password) {
        driver.findElement(this.password).
                sendKeys(password);

    };

    public void pressLoginButton() {
        driver.findElement(loginButton)
                .click();
    }

    public boolean isLoginSuccessful() {
        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("content")))
                .getText().contains("Login Page");
    }

    public boolean isLoginSecure() {
        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("flash")))
                .getText().contains("You logged into a secure area!");
    }
}