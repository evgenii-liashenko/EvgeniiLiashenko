package ru.training.at.hw3.utils.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class DriverConfigurator {
    public static WebDriver webDriverDc;
    public WebDriver setUpDriver(){
        if (webDriverDc == null){
            WebDriverManager.chromedriver().setup();
            webDriverDc = new ChromeDriver();
            webDriverDc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webDriverDc.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            webDriverDc.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
            webDriverDc.manage().window().maximize();
        }
        return webDriverDc;
    }
    public void resetDriver(){
        webDriverDc.close();
        webDriverDc.quit();
        webDriverDc = null;
    }
}
