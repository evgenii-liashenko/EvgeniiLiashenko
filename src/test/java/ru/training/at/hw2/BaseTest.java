package ru.training.at.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver webDriver = null;

    @BeforeClass    //setting up the webdriver for Chrome
    public void setupWebDriver() {
        if (webDriver == null) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
//            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            webDriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        }
    }


    public SoftAssert softAssertObject = null;

    @BeforeClass    //creating a soft assert object
    public void createSoftAssertObject(){
        softAssertObject = new SoftAssert();
    }

    @AfterClass //executing assertAll() method on the soft assert object
    public void executeAssertAll(){
        if (softAssertObject != null)
            softAssertObject.assertAll();
    }


    @AfterClass
    public void shutDownWebDriver() {
        if (webDriver != null) {
            webDriver.close();
//            webDriver.quit();
        }
    }


    @DataProvider(name = "credentials")
    public Object[][] dpMethod() {
        return new Object[][]{{"Roman", "Jdi1234"}};
    }

}
