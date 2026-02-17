package base;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
    }

    @AfterMethod
    public void teardown() {
        if(driver != null) driver.quit();
    }
}
