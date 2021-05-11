package ru.training.at.hw3.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw3.webpages.DifferentElementsPage;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise2DifferentElementsPageTest extends BaseTest {

    DifferentElementsPage differentElementsPage;

    @BeforeClass
    public void createDifferentElementsPageObject() {
        differentElementsPage = new DifferentElementsPage(webDriver);
    }

    @Test(dataProvider = "credentials", dataProviderClass = UserData.class)
    public void executeTestSteps(String userName, String password) {
        //1. Open test site by URL
        openUrl();

        //2. Assert Browser title
        checkTabTitle();

        //3. Perform login
        signIn(userName, password);

        //4. Assert User name in the left-top side of screen that user is loggined
        checkUsernameAfterLogin();

        //5. Open through the header menu Service -> Different Elements Page
        openDifferentElementsPage();

        //6. Select checkboxes
        selectCheckboxes();

        //7. Select radio
        selectRadioButton();

        //8. Select in dropdown
        selectOptionInDropdownList();

        //9. Assert that
        //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //•	for radio button there is a log row and value is corresponded to the status of radio button
        //•	for dropdown there is a log row and value is corresponded to the selected value.
        checkLogs();

        //10. Close Browser
        //Closing the browser is implemented in the DriverConfigurator class
    }


    public void openUrl() {
        //Opening the URL with the webdriver
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public void checkTabTitle() {
        //Asserting that the tab title matches the expected
        assertEquals(differentElementsPage.getTabTitle(), "Home Page");
    }

    public void signIn(String userName, String password) {
        //Performing a sign-in
        differentElementsPage.userAccountMenu.authorizeUser(userName, password);
    }

    public void checkUsernameAfterLogin() {
        //Asserting that the username is displayed
        assertTrue(differentElementsPage.userAccountMenu.displayedName.isDisplayed());

        //Asserting that the displayed username matches the expected username
        assertEquals(differentElementsPage.userAccountMenu.displayedName.getText(), "ROMAN IOVLEV");
    }

    public void openDifferentElementsPage() {
        differentElementsPage.openPage();
    }

    public void selectCheckboxes() {
        //Activating the checkboxes
        differentElementsPage.waterCheckbox.click();
        differentElementsPage.windCheckbox.click();
    }

    public void selectRadioButton() {
        //Selecting the Selen radio button
        differentElementsPage.selenRadioButton.click();
    }

    public void selectOptionInDropdownList() {
        //Setting the Yellow option in the selector
        differentElementsPage.yellowSelectorOption.click();
    }

    public void checkLogs() {
        Deque<WebElement> testLog = new ArrayDeque<>(differentElementsPage.logArea.logEntries);
        assertTrue(testLog.removeLast().getText().contains("Water: condition changed to true"));
        assertTrue(testLog.removeLast().getText().contains("Wind: condition changed to true"));
        assertTrue(testLog.removeLast().getText().contains("metal: value changed to Selen"));
        assertTrue(testLog.removeLast().getText().contains("Colors: value changed to Yellow"));
    }


}
