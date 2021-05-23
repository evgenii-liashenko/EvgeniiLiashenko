package ru.training.at.hw4.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.training.at.hw4.listeners.ScreenshotListener;
import ru.training.at.hw4.tests.steps.CommonTestSteps;
import ru.training.at.hw4.tests.steps.DifferentElementsPageTestSteps;


@Listeners(ScreenshotListener.class)
@Feature("Different Elements page (feature)")
@Story("Different Elements page functionality testing (story)")
public class Exercise2DifferentElementsPageTest extends BaseTest {

    CommonTestSteps commonTestSteps;
    DifferentElementsPageTestSteps differentElementsPageTestSteps;
    @BeforeClass
    @Step("Creating step objects")
    public void createStepObjects() {
        commonTestSteps = new CommonTestSteps(webDriver);
        differentElementsPageTestSteps = new DifferentElementsPageTestSteps(webDriver);
    }

    @Test(dataProvider = "credentials", dataProviderClass = UserData.class)
    public void executeTestSteps(String userName, String password) {
        //1. Open test site by URL
        commonTestSteps.openUrl();

        //2. Assert Browser title
        commonTestSteps.checkTabTitle();

        //3. Perform login
        commonTestSteps.signIn(userName, password);

        //4. Assert User name in the left-top side of screen that user is loggined
        commonTestSteps.checkUsernameAfterLogin();

        //5. Open through the header menu Service -> Different Elements Page
        differentElementsPageTestSteps.openDifferentElementsPage();

        //6. Select checkboxes
        differentElementsPageTestSteps.selectCheckboxes();

        //7. Select radio
        differentElementsPageTestSteps.selectRadioButton();

        //8. Select in dropdown
        differentElementsPageTestSteps.selectOptionInDropdownList();

        //9. Assert that
        //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //•	for radio button there is a log row and value is corresponded to the status of radio button
        //•	for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPageTestSteps.checkLogs();

        //10. Close Browser
        //Closing the browser is implemented in the DriverConfigurator class
    }

}
