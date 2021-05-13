package ru.training.at.hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.training.at.hw2.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class Exercise2 extends BaseTest {

    @Test(dataProvider = "credentials", dataProviderClass = BaseTest.class)
    public void executeTestSteps(String userName, String password) {
        //1. Open test site by URL
        openUrl();

        //2. Assert Browser title
        checkTabTitle();

        //3. Perform login
        checkAuthorization(userName, password);

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
        //Closing the browser is implemented in the BaseTest class
    }


    public void openUrl() {
        //Opening the URL with the webdriver
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public void checkTabTitle() {
        //Obtaining tab title form the webdriver
        String actualTabTitle = webDriver.getTitle();

        //Asserting that the tab title matches the expected
        String expectedTabTitle = "Home Page";
        assertEquals(actualTabTitle, expectedTabTitle);
    }

    public void checkAuthorization(String userName, String password) {
        //Locating the user icon and performing a click on it
        WebElement userIcon = webDriver.findElement(By.id("user-icon"));
        userIcon.click();

        //Locating the login field and filling it in
        WebElement loginField = webDriver.findElement(By.id("name"));
        loginField.sendKeys(userName);

        //Locating the password field and filling it in
        WebElement passwordField = webDriver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        //Locating the enter button and performing a clock on it
        WebElement enterButton = webDriver.findElement(By.className("fa-sign-in"));
        enterButton.click();
    }

    public void checkUsernameAfterLogin() {
        //Locating the username element with id
        WebElement displayedName = webDriver.findElement(By.id("user-name"));

        //Asserting that the username is displayed
        assertTrue(displayedName.isDisplayed());

        //Asserting that the displayed username matches the expected username
        String expectedUsername = "ROMAN IOVLEV";
        assertEquals(displayedName.getText(), expectedUsername);
    }

    public void openDifferentElementsPage() {
        //Locating the Service block and performing a click on it
        WebElement serviceBlock = webDriver.findElement(By.cssSelector("ul.uui-navigation>li:nth-child(3).dropdown>a"));
        serviceBlock.click();

        //Locating the Different elements block and performing a click on it
        WebElement differentElementsBlock = webDriver.findElement(By.cssSelector("li.dropdown.open>ul.dropdown-menu[role='menu']>li:nth-child(8)>a[href='different-elements.html']"));
        differentElementsBlock.click();
    }

    public void selectCheckboxes(){
        //Locating the Water and Wind checkboxes with CSS selectors
        WebElement waterCheckbox = webDriver.findElement(By.cssSelector("div>label.label-checkbox:nth-child(1)>input"));
        WebElement windCheckbox = webDriver.findElement(By.cssSelector("div>label.label-checkbox:nth-child(3)>input"));

        //Activating the checkboxes
        waterCheckbox.click();
        windCheckbox.click();
    }

    public void selectRadioButton(){
        //Locating and selecting the Selen radio button
        WebElement selenRadioButton = webDriver.findElement(By.cssSelector("div.main-content-hg>div.checkbox-row:nth-child(3)>label:nth-child(4)>input"));
        selenRadioButton.click();
    }

    public void selectOptionInDropdownList(){
        //Locating and setting the Yellow option in the selector
        WebElement yellowInSelector = webDriver.findElement(By.cssSelector("div.main-content-hg>div.colors>select.uui-form-element>option:nth-child(4)"));
        yellowInSelector.click();
    }

    public void checkLogs(){
        //Obtaining the first two log entries
        String firstLogEntry = webDriver.findElement(By.cssSelector("div.info-panel-section>ul.panel-body-list.logs>li:nth-child(4)")).getText();
        String secondLogEntry = webDriver.findElement(By.cssSelector("div.info-panel-section>ul.panel-body-list.logs>li:nth-child(3)")).getText();
        String thirdLogEntry = webDriver.findElement(By.cssSelector("div.info-panel-section>ul.panel-body-list.logs>li:nth-child(2)")).getText();
        String fourthLogEntry = webDriver.findElement(By.cssSelector("div.info-panel-section>ul.panel-body-list.logs>li:nth-child(1)")).getText();

        //Asserting that the first two log entries correspond to the checkboxes ticked in selectCheckboxes()
        assertTrue(firstLogEntry.contains("Water: condition changed to true"));
        assertTrue(secondLogEntry.contains("Wind: condition changed to true"));

        //Asserting that the third log entry corresponds to the radio button selected in selectRadioButton()
        assertTrue(thirdLogEntry.contains("metal: value changed to Selen"));

        //Asserting that the fourth log entry corresponds to the selector option activated in selectOptionInDropdownList()
        assertTrue(fourthLogEntry.contains("Colors: value changed to Yellow"));
    }
}
