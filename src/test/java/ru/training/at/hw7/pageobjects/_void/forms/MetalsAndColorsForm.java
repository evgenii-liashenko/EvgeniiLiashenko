package ru.training.at.hw7.pageobjects._void.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw7.testdata.TestDataSet;


public class MetalsAndColorsForm extends Form<TestDataSet> {
    //Summary block
    @UI("#odds-selector>p")
    public WebList oddSummary;
//    public RadioButtons oddSummary;       //This does not work and I wonder why
    @UI("#even-selector>p")
    public WebList evenSummary;

    //Elements block
    @UI("#elements-checklist input[type=checkbox]")
    public Checklist elements;

    //Dropdowns
    @JDropdown(root = "#colors", value = ".filter-option", list = "li", expand = ".caret")
    public Dropdown colors;
    @JDropdown(root = "#metals", value = ".filter-option", list = "li", expand = ".caret")
    public Dropdown metals;
    @JDropdown(root = "#vegetables", value = "#salad-dropdown>button.dropdown-toggle", list = "li", expand = ".caret")
    public Dropdown vegetables;
//    public MultiDropdown sameVegetables;   //I wonder how to import this class

    @UI("#submit-button")
    public Button submit;

    //I gave up trying to get uncheckAll() and uncheck() methods to work. The workaround is unchecking checkboxes with Selenium
    @FindBy(css = "#salad-dropdown>ul.dropdown-menu>li>a>input[checked = 'checked']+label")
    WebElement vegetablesCheckbox;    //This checkbox is selected by default
    @FindBy(id = "salad-dropdown")
    WebElement vegetablesDropdown;
    public void uncheckDefaultVegetablesCheckbox(){
        vegetablesDropdown.click();
        vegetablesCheckbox.click();
    }

    @Override
    public void fill(TestDataSet dataSet){
        //Setting everything but Vegetables
        oddSummary.select(dataSet.getSummary().get(0).toString());
        evenSummary.select(dataSet.getSummary().get(1).toString());
        elements.select(dataSet.getElements().toArray(new String[0]));
        colors.select(dataSet.getColor());
        metals.select(dataSet.getMetals());

        //Setting Vegetables involves a workaround to make select() work with multiple arguments
        String[] veggies = dataSet.getVegetables().toArray(new String[0]);
        for (int i = 0; i < veggies.length; i++) {
            vegetables.select(veggies[i]);
        }
    }
}
