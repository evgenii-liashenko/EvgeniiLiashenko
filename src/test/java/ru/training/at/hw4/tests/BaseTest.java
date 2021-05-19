package ru.training.at.hw4.tests;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.utils.webdriver.DriverConfigurator;

import java.util.Map;


public class BaseTest {

    //Webdriver setup
    public DriverConfigurator driverConfigurator = new DriverConfigurator();
    public WebDriver webDriver;

    @BeforeClass
    @Step("Loading webdriver")
    public void loadWebDriver(ITestContext context) {
        if (webDriver == null) {
            webDriver = driverConfigurator.setUpDriver();
        }
        context.setAttribute("webDriverInstance", webDriver);
    }

    @AfterClass
    @Step("Discarding webdriver instance")
    public void shutDownWebDriver() {
        if (webDriver != null) {
            driverConfigurator.resetDriver();
        }
    }


    //Setting up soft assert functionality
    public SoftAssert softAssert = null;

    @BeforeClass
    @Step("Setting up soft assertion")
    public void createSoftAssertObject() {
        softAssert = new SoftAssert();
    }

    @AfterClass
    @Step("Performing soft assertion")
    public void executeAssertAll() {
        if (softAssert != null)
            softAssert.assertAll();
    }


    //Auxiliary test methods
    public void checkTextAndVisibility(Map<String, WebElement> items) {
        for (Map.Entry<String, WebElement> item : items.entrySet()) {
            softAssert.assertTrue(item.getValue().isDisplayed());
            softAssert.assertEquals(item.getValue().getText(), item.getKey());
        }
    }


}
