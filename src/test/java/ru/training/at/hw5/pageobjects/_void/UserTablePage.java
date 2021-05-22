package ru.training.at.hw5.pageobjects._void;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw5.pageobjects._void.components.LogArea;

import java.util.List;
import java.util.NoSuchElementException;

public class UserTablePage extends BasePage {

    public LogArea logArea;

    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
        this.logArea = new LogArea(webDriver);
        this.url = "https://jdi-testing.github.io/jdi-light/user-table.html";
    }

    //Table columns
    @FindBy(css = "#user-table>tbody>tr>td:nth-child(2)>select")
    public List<WebElement> numberTypeSelectors;
    @FindBy(css = "#user-table>tbody>tr>td:nth-child(3)>a")
    public List<WebElement> users;
    @FindBy(css = "#user-table>tbody>tr>td:nth-child(4)>div.user-descr>span")
    public List<WebElement> descriptionTexts;
    @FindBy(css = "#user-table>tbody>tr>td:nth-child(4)>div.user-descr>input[type='checkbox']")
    public List<WebElement> checkBoxes;


    //Cucumber interaction methods

    public List<WebElement> getColumn(String columnName) {
        if (columnName.equalsIgnoreCase("Number Type Dropdowns"))
            return numberTypeSelectors;
        else if (columnName.equalsIgnoreCase("Usernames"))
            return users;
        else if (columnName.equalsIgnoreCase("Description texts under images"))
            return descriptionTexts;
        else if (columnName.equalsIgnoreCase("checkboxes"))
            return checkBoxes;
        else
            throw new NoSuchElementException("Failed to find column " + columnName);
    }

    public WebElement getRowItem(int rowNumber, String itemType) {
        String rowCssSelector = "#user-table>tbody>tr:nth-child(" + rowNumber + ")";
        String columnCssSuffix;
        if (itemType.equalsIgnoreCase("NUMBER"))
            columnCssSuffix = ">td:nth-child(1)";
        else if (itemType.equalsIgnoreCase("USER"))
            columnCssSuffix = ">td:nth-child(3)";
        else if (itemType.equalsIgnoreCase("DESCRIPTION"))
            columnCssSuffix = ">td:nth-child(4)>div.user-descr>span";
        else
            throw new NoSuchElementException("Failed to find item " + itemType);
        String itemCssSelector = rowCssSelector + columnCssSuffix;
        return webDriver.findElement(By.cssSelector(itemCssSelector));
    }

    public List<WebElement> getDropdownValues(int rowNumber) {
        String cssSelector = "#user-table>tbody>tr:nth-child(" + rowNumber + ")>td:nth-child(2)>select>option";
        return webDriver.findElements(By.cssSelector(cssSelector));
    }

    public void selectCheckBox(int rowNumber) {
        String checkBoxCss = "#user-table>tbody>tr:nth-child(" + rowNumber + ")>td:nth-child(4)>div.user-descr>input[type='checkbox']";
        webDriver.findElement(By.cssSelector(checkBoxCss)).click();
    }


    @Override
    public void openPage() {
        menuBar.service.click();
        menuBar.userTable.click();
    }
}
