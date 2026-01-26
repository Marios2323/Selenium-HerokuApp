package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    //Happy path
    private By username = By.name("username");
    private By password = By.name("password");
    private By loginButton = By.xpath("//button[contains(.,'Login')]");
    private By loginPageIsVisible = By.xpath("//h2[text()='Login Page']");

    //Constructor is manadotory inside POM
    public LoginPage(WebDriver driver) {
        this.driver = driver;
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
}