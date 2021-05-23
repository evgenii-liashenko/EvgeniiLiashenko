package ru.training.at.hw4.pageobjects._void;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw4.pageobjects._void.components.MenuBar;
import ru.training.at.hw4.pageobjects._void.components.SideBar;
import ru.training.at.hw4.pageobjects._void.components.UserAccountMenu;


public class BasePage {
    public MenuBar menuBar;
    public UserAccountMenu userAccountMenu;
    public SideBar sideBar;
    protected WebDriver webDriver;
    protected String url;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.menuBar = new MenuBar(webDriver);
        this.sideBar = new SideBar(webDriver);
        this.userAccountMenu = new UserAccountMenu(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    public void openPage(){
        //Opening the Home Page URL
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public String getTabTitle(){
        return webDriver.getTitle();
    }

}
