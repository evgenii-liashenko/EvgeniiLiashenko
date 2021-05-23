package ru.training.at.hw5.steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pageobjects._void.HomePage;

import java.util.Deque;

import static org.testng.Assert.assertTrue;


public class CommonTestSteps {

    private WebDriver webDriver = TestContext.getInstance().getObject(TestContext.WEB_DRIVER);


    @Given("I open JDI GitHub site")
    public void openUrl() {
        new HomePage(webDriver).openPageUrl();
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void signIn() {
        new HomePage(webDriver).userAccountMenu.authorizeUser();
    }

    @Given("I click on {string} button in Header")
    public void clickMenubarItem(String button){
        new HomePage(webDriver).menuBar.clickHeaderItem(button);
    }

    @Given("I click on {string} button in Service dropdown")
    public void clickInServiceDropdown(String button){
        new HomePage(webDriver).menuBar.clickServiceItem(button);
    }


}
