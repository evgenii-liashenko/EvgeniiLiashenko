package ru.training.at.hw5.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pageobjects._void.DifferentElementsPage;


import java.util.ArrayDeque;
import java.util.Deque;

import static org.testng.Assert.assertTrue;

public class DifferentElementsPageTestSteps {

    private WebDriver webDriver = TestContext.getInstance().getObject(TestContext.WEB_DRIVER);

    Deque<String> currentLog;
    DifferentElementsPage differentElementsPage;


    @When("I select {string} checkbox on Different Elements Page")
    public void selectCheckbox(String checkBoxName) {
        new DifferentElementsPage(webDriver).selectCheckBox(checkBoxName);
        updateCurrentLog();
    }

    @When("I select {string} radio button on Different Elements Page")
    public void selectRadioButton(String radioButtonName) {
        new DifferentElementsPage(webDriver).selectRadioButton(radioButtonName);
        updateCurrentLog();
    }

    @When("I select {string} in dropdown on Different Elements Page")
    public void selectOptionInDropdownList(String selectorOption) {
        new DifferentElementsPage(webDriver).setSelectorOption(selectorOption);
        updateCurrentLog();
    }

    @Then("The top log row should be containing {string} text in log section")
    public void checkLog(String textToBePresent) {
        assertTrue(currentLog.removeLast().contains(textToBePresent));
    }



    public void updateCurrentLog() {
        if (currentLog == null) currentLog = new ArrayDeque<>();
        if (differentElementsPage == null) differentElementsPage = new DifferentElementsPage(webDriver);

        String topEntry = differentElementsPage.logArea.topEntry.getText();
        currentLog.addFirst(topEntry);
    }
}
