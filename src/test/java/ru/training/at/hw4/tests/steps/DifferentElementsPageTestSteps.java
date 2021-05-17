package ru.training.at.hw4.tests.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.training.at.hw4.pageobjects._void.DifferentElementsPage;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.testng.Assert.assertTrue;

public class DifferentElementsPageTestSteps {

    private DifferentElementsPage differentElementsPage;

    public DifferentElementsPageTestSteps(WebDriver webDriver) {
        this.differentElementsPage = new DifferentElementsPage(webDriver);
    }

    @Step("Opening Different Elements page")
    public void openDifferentElementsPage() {
        differentElementsPage.openPage();
    }

    @Step("Selecting checkboxes")
    public void selectCheckboxes() {
        //Activating the checkboxes
        differentElementsPage.waterCheckbox.click();
        differentElementsPage.windCheckbox.click();
    }

    @Step("Selecting radiobutton")
    public void selectRadioButton() {
        //Selecting the Selen radio button
        differentElementsPage.selenRadioButton.click();
    }

    @Step("Selecting from dropdown list")
    public void selectOptionInDropdownList() {
        //Setting the Yellow option in the selector
        differentElementsPage.yellowSelectorOption.click();
    }

    @Step("Verifying displayed logs")
    public void checkLogs() {
        Deque<WebElement> testLog = new ArrayDeque<>(differentElementsPage.logArea.logEntries);
        assertTrue(testLog.removeLast().getText().contains("Water: condition changed to true"));
        assertTrue(testLog.removeLast().getText().contains("Wind: condition changed to true"));
        assertTrue(testLog.removeLast().getText().contains("metal: value changed to Selen"));
        assertTrue(testLog.removeLast().getText().contains("Colors: value changed to Yellow"));
    }

}
