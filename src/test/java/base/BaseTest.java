package base;

import drivers.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import config.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver(ConfigReader.getBrowser());
        DriverFactory.getDriver().get(ConfigReader.getBaseUrl());
    }

    @AfterMethod
    public void teardown() {
        DriverFactory.quitDriver();
    }
}