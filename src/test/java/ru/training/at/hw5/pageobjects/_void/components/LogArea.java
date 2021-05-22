package ru.training.at.hw5.pageobjects._void.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class LogArea {

    private WebDriver webDriver;

    public LogArea(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);

    }

    @FindBy(css = "div.info-panel-section>ul.panel-body-list.logs>li")
    public List<WebElement> logEntries;

    @FindBy(css = "div.info-panel-section>ul.panel-body-list.logs>li:nth-child(1)")
    public WebElement topEntry;





    public WebElement getTopEntry(){
        return topEntry;
    }



}
