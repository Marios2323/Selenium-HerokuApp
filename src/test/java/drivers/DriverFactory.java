package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {
        WebDriver webDriver;

        switch (browser.toLowerCase()) {
            case "chrome": {
                WebDriverManager.chromedriver().setup(); // κατεβάζει driver τοπικά
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                webDriver = new ChromeDriver(options);
                break;
            }

            case "firefox": {
                WebDriverManager.firefoxdriver().setup(); // κατεβάζει driver τοπικά
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                webDriver = new FirefoxDriver(options);
                break;
            }

            case "edge": {
                // Edge δεν υποστηρίζεται στο GitHub Actions (Ubuntu runner)
                // Αν είσαι local Windows, βάζεις τον driver
                if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                    System.setProperty("webdriver.edge.driver", "EdgeDrivers/msedgedriver.exe");
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    webDriver = new EdgeDriver(options);
                } else {
                    throw new IllegalStateException(
                            "Edge not supported on non-Windows CI environments. Use Chrome/Firefox headless."
                    );
                }
                break;
            }

            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        webDriver.manage().window().maximize();
        driver.set(webDriver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
}