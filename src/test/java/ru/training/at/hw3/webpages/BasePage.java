package ru.training.at.hw3.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw3.webpages.components.MenuBar;
import ru.training.at.hw3.webpages.components.SideBar;
import ru.training.at.hw3.webpages.components.UserAccountMenu;

public abstract class BasePage {
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


    abstract void openPage();

    public String getTabTitle(){
        return webDriver.getTitle();
    }

}
