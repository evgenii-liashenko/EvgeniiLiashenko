package ru.training.at.hw5.pageobjects._void;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw5.pageobjects._void.components.LogArea;


public class DifferentElementsPage extends BasePage {

    public LogArea logArea;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        this.logArea = new LogArea(webDriver);
        this.url = "https://jdi-testing.github.io/jdi-light/different-elements.html";
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


    public void selectCheckBox(String checkBoxName){
        if (checkBoxName.equalsIgnoreCase("WIND"))
            windCheckbox.click();
        else if (checkBoxName.equalsIgnoreCase("WATER"))
            waterCheckbox.click();
        else
            System.out.println("Failed to find checkbox " + checkBoxName);
    }

    public void selectRadioButton(String radioButtonName){
        if (radioButtonName.equalsIgnoreCase("SELEN")){
            selenRadioButton.click();
        }
        else
            System.out.println("Failed to find radio button " + radioButtonName);
    }

    public void setSelectorOption(String optionName){
        if (optionName.equalsIgnoreCase("YELLOW")){
            yellowSelectorOption.click();
        }
        else
            System.out.println("Failed to find selector option " + yellowSelectorOption);
    }


    @Override
    public void openPage(){
        menuBar.service.click();
        menuBar.differentElements.click();
    }
}
