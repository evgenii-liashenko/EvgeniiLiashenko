package ru.training.at.hw3.webpages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountMenu {

    private WebDriver webDriver;

    public UserAccountMenu(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    //Authentication-related items
    @FindBy(id = "user-icon")
    public WebElement userIcon;
    @FindBy(id = "name")
    public WebElement loginField;
    @FindBy(id = "password")
    public WebElement passwordField;
    @FindBy(className = "fa-sign-in")
    public WebElement enterButton;
    @FindBy(id = "user-name")
    public WebElement displayedName;


    public void authorizeUser(String username, String password){
        userIcon.click();
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        enterButton.click();
    }

}
