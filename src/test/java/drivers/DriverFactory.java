package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {

        WebDriver driver;

        //Selecting the driver for the tests
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
        return driver;
    }
}
