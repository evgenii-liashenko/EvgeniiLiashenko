package ru.training.at.hw4.tests.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw4.pageobjects._void.BasePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CommonTestSteps  {

    private WebDriver webDriverCts;
    private BasePage basePage;

    public CommonTestSteps(WebDriver webDriverObject) {
        this.webDriverCts = webDriverObject;
        basePage = new BasePage(webDriverObject);
    }


    @Step("Opening test website")
    public void openUrl() {
        //Opening the URL with the webdriver
        webDriverCts.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Step("Verifying tab title")
    public void checkTabTitle() {
        //Asserting that the tab title matches the expected
        assertEquals(basePage.getTabTitle(), "Home Page");
    }

    @Step("Signing in user {userName} with password {password}")
    public void signIn(String userName, String password) {
        //Performing a sign-in
        basePage.userAccountMenu.authorizeUser(userName, password);
    }

    @Step("Verifying displayed username")
    public void checkUsernameAfterLogin() {
        //Asserting that the username is displayed
        assertTrue(basePage.userAccountMenu.displayedName.isDisplayed());

        //Asserting that the displayed username matches the expected username
        assertEquals(basePage.userAccountMenu.displayedName.getText(), "ROMAN IOVLEV");
    }

}
