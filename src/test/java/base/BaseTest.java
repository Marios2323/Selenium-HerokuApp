package base;

import drivers.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import config.ConfigReader;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(@Optional("edge") String browser) {
        DriverFactory.initDriver(browser);
        DriverFactory.getDriver().get(ConfigReader.getBaseUrl());
    }

    @AfterMethod
    public void teardown() {
        DriverFactory.quitDriver();
    }
}