package ru.training.at.hw4.pageobjects._void.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuBar {

    private WebDriver webDriver;

    public MenuBar(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "ul.uui-navigation>li:nth-child(1)>a[href='index.html']")
    public WebElement home;
    @FindBy(css = "ul.uui-navigation>li:nth-child(2)>a[href='contacts.html']")
    public WebElement contactForm;
    @FindBy(css = "ul.uui-navigation>li:nth-child(3).dropdown>a")
    public WebElement service;

    @FindBy(css = "li.dropdown.open>ul.dropdown-menu[role='menu']>li:nth-child(8)>a[href='different-elements.html']")
    public WebElement differentElements;

    @FindBy(css = "ul.uui-navigation>li:nth-child(4)>a[href='metals-colors.html']")
    public WebElement metalsAndColors;
}
