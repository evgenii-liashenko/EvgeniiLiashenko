package ru.training.at.hw3.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.utils.webdriver.DriverConfigurator;


public class BaseTest {
    //Setting up the webdriver
    public DriverConfigurator driverConfigurator = new DriverConfigurator();
    public WebDriver webDriver;
    @BeforeClass
    public void loadWebDriver() {
        if (webDriver == null) {
            webDriver = driverConfigurator.setUpDriver();
        }
    }
    @AfterClass
    public void shutDownWebDriver() {
        if (webDriver != null) {
            //webDriverBt = null;
            driverConfigurator.resetDriver();
        }
    }

    //Setting up soft assert functionality
    public SoftAssert softAssert = null;
    @BeforeClass
    public void createSoftAssertObject() {
        softAssert = new SoftAssert();
    }
    @AfterClass
    public void executeAssertAll() {
        if (softAssert != null)
            softAssert.assertAll();
    }
}
