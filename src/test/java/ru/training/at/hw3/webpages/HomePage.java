package ru.training.at.hw3.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.url = "https://jdi-testing.github.io/jdi-light/index.html";
    }

    //Graphical items
    @FindBy(css = "div.benefit-icon>span.icons-benefit.icon-practise")
    public WebElement microscopeIcon;
    @FindBy(css = "div.benefit-icon>span.icons-benefit.icon-custom")
    public WebElement headsetIcon;
    @FindBy(css = "div.benefit-icon>span.icons-benefit.icon-multi")
    public  WebElement screenIcon;
    @FindBy(css = "div.benefit-icon>span.icons-benefit.icon-base")
    public  WebElement rocketIcon;

    //Text under the graphical items
    @FindBy(css = "div.row.clerafix.benefits>div:nth-child(1).col-sm-3>div.benefit>span.benefit-txt")
    public  WebElement microscopeText;
    @FindBy(css = "div.row.clerafix.benefits>div:nth-child(2).col-sm-3>div.benefit>span.benefit-txt")
    public  WebElement headsetText;
    @FindBy(css = "div.row.clerafix.benefits>div:nth-child(3).col-sm-3>div.benefit>span.benefit-txt")
    public  WebElement screenText;
    @FindBy(css = "div.row.clerafix.benefits>div:nth-child(4).col-sm-3>div.benefit>span.benefit-txt")
    public  WebElement rocketText;

    //iFrames
    @FindBy(id = "frame")
    public List<WebElement> iFrames;
    @FindBy(id = "frame-button")
    public List<WebElement> iFrameButtons;


    public void switchToTopIframe(){
        webDriver.switchTo().frame("frame");
    }

    public void switchFromIframe() {
        //Switching the webdriver back to the original window
        webDriver.switchTo().defaultContent();
    }

    public void openPage(){
        webDriver.get(url);
    }
}
