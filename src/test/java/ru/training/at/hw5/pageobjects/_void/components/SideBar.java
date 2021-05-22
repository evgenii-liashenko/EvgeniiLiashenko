package ru.training.at.hw5.pageobjects._void.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideBar {
    private WebDriver webDriver;

    public SideBar(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "#mCSB_1_container>ul.sidebar-menu.left>li[index='1']")
    public WebElement homeSection;
    @FindBy(css = "#mCSB_1_container>ul.sidebar-menu.left>li[index='2']")
    public WebElement contactFormSection;
    @FindBy(css = "#mCSB_1_container>ul.sidebar-menu.left>li[index='3']")
    public WebElement serviceSection;
    @FindBy(css = "#mCSB_1_container>ul.sidebar-menu.left>li[index='4']")
    public WebElement metalsAndColorsSection;
    @FindBy(css = "#mCSB_1_container>ul.sidebar-menu.left>li[index='5']")
    public WebElement elementsPacksSection;

}
