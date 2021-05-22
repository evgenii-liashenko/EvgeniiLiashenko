package ru.training.at.hw5.pageobjects._void.components;

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

    //Header items
    @FindBy(css = ".uui-header.dark-gray>nav>div.epam-logo>a")
    public WebElement epamLogo;
    @FindBy(css = "ul.uui-navigation>li:nth-child(1)>a[href='index.html']")
    public WebElement home;
    @FindBy(css = "ul.uui-navigation>li:nth-child(2)>a[href='contacts.html']")
    public WebElement contactForm;
    @FindBy(css = "ul.uui-navigation>li:nth-child(3).dropdown>a")
    public WebElement service;
    @FindBy(css = "ul.uui-navigation>li:nth-child(4)>a[href='metals-colors.html']")
    public WebElement metalsAndColors;

    //Items in the Service dropdown
    @FindBy(css = "li.dropdown.open>ul.dropdown-menu[role='menu']>li:nth-child(8)>a[href='different-elements.html']")
    public WebElement differentElements;
    @FindBy(css = "li.dropdown.open>ul.dropdown-menu[role='menu']>li:nth-child(6)>a[href='user-table.html']")
    public WebElement userTable;


    public void clickHeaderItem(String menuBarItemName) {
        if (menuBarItemName.equalsIgnoreCase("HOME"))
            home.click();
        else if (menuBarItemName.equalsIgnoreCase("CONTACT FORM"))
            contactForm.click();
        else if (menuBarItemName.equalsIgnoreCase("SERVICE"))
            service.click();
        else
            System.out.println("Failed to find menubar item " + menuBarItemName);
    }


    public void clickServiceItem(String serviceItemName){
        if (serviceItemName.equalsIgnoreCase("DIFFERENT ELEMENTS"))
            differentElements.click();
        else if (serviceItemName.equalsIgnoreCase("USER TABLE"))
            userTable.click();
        else
            System.out.println("Failed to find SERVICE dropdown item " + serviceItemName);
    }


}
