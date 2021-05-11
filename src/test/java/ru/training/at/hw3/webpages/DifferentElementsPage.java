package ru.training.at.hw3.webpages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw3.webpages.components.LogArea;

public class DifferentElementsPage extends BasePage {

    public LogArea logArea;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        this.logArea = new LogArea(webDriver);
    }

    //CheckBoxes
    @FindBy(css = "div>label.label-checkbox:nth-child(1)>input")
    public WebElement waterCheckbox;
    @FindBy(css = "div>label.label-checkbox:nth-child(3)>input")
    public WebElement windCheckbox;

    //RadioButtons
    @FindBy(css = "div.main-content-hg>div.checkbox-row:nth-child(3)>label:nth-child(4)>input")
    public WebElement selenRadioButton;

    //Selector options
    @FindBy(css = "div.main-content-hg>div.colors>select.uui-form-element>option:nth-child(4)")
    public WebElement yellowSelectorOption;



    public void openPage(){
        menuBar.service.click();
        menuBar.differentElements.click();
    }
}
