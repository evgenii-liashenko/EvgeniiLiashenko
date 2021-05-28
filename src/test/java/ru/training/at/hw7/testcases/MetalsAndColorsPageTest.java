package ru.training.at.hw7.testcases;

import org.testng.annotations.Test;
import ru.training.at.hw7.JdiWebsite;
import ru.training.at.hw7.entities.User;
import ru.training.at.hw7.pageobjects._void.components.ResultArea;
import ru.training.at.hw7.pageobjects._void.forms.MetalsAndColorsForm;
import ru.training.at.hw7.testdata.TestDataLoader;
import ru.training.at.hw7.testdata.TestDataSet;

import java.util.Locale;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertTrue;


public class MetalsAndColorsPageTest extends BaseTest {
    //"1. Login on JDI site as User"
    @Test
    public void checkLogin() {
        User jdiRoman = new User();
        JdiWebsite.homePage.open();
        JdiWebsite.homePage.authorizeUser(jdiRoman);
        JdiWebsite.homePage.menuBar.displayedFullName.is().text(jdiRoman.getFullName().toUpperCase(Locale.ROOT));
    }

    //"2. Open Metals & Colors page by Header menu"
    @Test(dependsOnMethods = {"checkLogin"})
    public void loadMetalsAndColorsPage() {
        JdiWebsite.homePage.menuBar.metalsAndColors.click();
        JdiWebsite.metalsAndColorsPage.checkOpened();
    }

    //"3. Fill form Metals & Colors by data"
    // "Submit form Metals & Colors"
    @Test(dependsOnMethods = {"loadMetalsAndColorsPage"}, dataProvider = "metalsAndColorsPageTestData", dataProviderClass = TestDataLoader.class)
    public void enterTestData(TestDataSet testDataSet) {
        //Setting up the form
        MetalsAndColorsForm form = JdiWebsite.metalsAndColorsPage.metalsAndColorsForm;
        refresh();
        form.uncheckDefaultVegetablesCheckbox();

        //Entering test data
        form.fill(testDataSet);

        //Submitting test data
        form.submit();

        //Verifying the results
        verifyResults(testDataSet);
    }

    //"4. Result sections should contains data"
    public void verifyResults(TestDataSet expectedValues) {
        ResultArea results = JdiWebsite.metalsAndColorsPage.resultArea;

        results.summary.is().text(containsString(expectedValues.getSummary().stream().collect(Collectors.summingInt(Integer::intValue)).toString()));
        results.color.is().text(containsString(expectedValues.getColor()));
        results.metal.is().text(containsString(expectedValues.getMetals()));
        for (String element : expectedValues.getElements()){
            results.elements.is().text(containsString(element));
        }
        for (String vegetable : expectedValues.getVegetables()) {
            String valuesOnly = results.vegetables.getText().replace("Vegetables: ", "");
            assertTrue(valuesOnly.contains(vegetable));
//            results.vegetables.is().text(containsString(vegetable));
        }
    }

}
