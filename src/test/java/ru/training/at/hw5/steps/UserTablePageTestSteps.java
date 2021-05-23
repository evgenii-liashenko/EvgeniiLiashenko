package ru.training.at.hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pageobjects._void.DifferentElementsPage;
import ru.training.at.hw5.pageobjects._void.UserTablePage;

import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserTablePageTestSteps {

    private WebDriver webDriver = TestContext.getInstance().getObject(TestContext.WEB_DRIVER);

    Deque<String> currentLog;
    UserTablePage userTablePage;

    @Then("{string} page should be opened")
    public void checkOpenedPage(String expectedPageTitle) {
        userTablePage = new UserTablePage(webDriver);
        assertEquals(userTablePage.getTabTitle(), expectedPageTitle);
    }

    @Then("{string} {string} should be displayed on Users Table on User Table Page")
    public void checkItemCount(String expectedAmountStr, String itemType) {
        userTablePage = new UserTablePage(webDriver);
        int expectedAmount = Integer.parseInt(expectedAmountStr);
        int actualAmount = userTablePage.getColumn(itemType).size();
        assertEquals(actualAmount, expectedAmount);
    }

    @Then("User table should contain following values:")
    public void checkRow(DataTable dataTable) {
        //Extracting the data from the table in cucumber .feature file
        List<List<String>> rows = dataTable.asLists(String.class);
        List<List<String>> rowsWithoutHeader = new ArrayList<>(rows);
        rowsWithoutHeader.remove(0);

        //Checking User Table page
        userTablePage = new UserTablePage(webDriver);
        for (List<String> row : rowsWithoutHeader) {
            //Getting expected values
            int expextedNumber = Integer.parseInt(row.get(0));
            String expectedName = row.get(1);
            String expectedDescription = row.get(2);

            //Verifying the Number row
            assertEquals(Integer.parseInt(userTablePage.getRowItem(expextedNumber, "NUMBER").getText()), expextedNumber);
            //Verifying the User row
            assertEquals(userTablePage.getRowItem(expextedNumber, "USER").getText(), expectedName);
            //Verifying the Description row
            assertEquals(userTablePage.getRowItem(expextedNumber, "DESCRIPTION").getText().replaceAll("[\\n]", " "), expectedDescription);
        }
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void checkDropDown(DataTable dataTable) {
        //Extracting the data from the table in cucumber .feature file
        List<List<String>> rows = dataTable.asLists(String.class);
        List<List<String>> rowsWithoutHeader = new ArrayList<>(rows);
        rowsWithoutHeader.remove(0);

        //Processing expected values
        List<String> expectedValues = new ArrayList<>();
        for (List<String> row : rowsWithoutHeader) {
            expectedValues.add(row.get(0));
        }

        //Processing actual values
        userTablePage = new UserTablePage(webDriver);
        List<WebElement> dropDownElements = userTablePage.getDropdownValues(1);
        List<String> actualValues = new ArrayList<>();
        for (WebElement option : dropDownElements) {
            actualValues.add(option.getText());
        }

        //Verifying the dropdown values
        assertEquals(actualValues.size(), expectedValues.size());
        for (int i = 0; i < actualValues.size(); i++) {
            assertEquals(actualValues.get(i), expectedValues.get(i));
        }
    }

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectVipCheckbox(){
        userTablePage = new UserTablePage(webDriver);
        userTablePage.selectCheckBox(2);
        updateCurrentLog();
    }

    @Then("1 log row has {string} text in log section")
    public void checkLog(String textToBePresent){
        assertTrue(currentLog.removeLast().contains(textToBePresent));
    }


    public void updateCurrentLog() {
        if (currentLog == null) currentLog = new ArrayDeque<>();
        if (userTablePage == null) userTablePage = new UserTablePage(webDriver);

        String topEntry = userTablePage.logArea.topEntry.getText();
        currentLog.addFirst(topEntry);
    }

}
