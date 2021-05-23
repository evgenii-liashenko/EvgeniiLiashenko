package ru.training.at.hw4.pageobjects._void.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LogArea {

    private WebDriver webDriver;

    public LogArea(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "div.info-panel-section>ul.panel-body-list.logs>li")
    public List<WebElement> logEntries;


}
