package ru.training.at.hw4.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.training.at.hw4.listeners.ScreenshotListener;
import ru.training.at.hw4.tests.steps.CommonTestSteps;
import ru.training.at.hw4.tests.steps.HomePageTestSteps;


@Listeners(ScreenshotListener.class)
@Feature("Home Page (feature) [purposely failed]")
@Story("Home Page functionality testing (story) [purposely failed]")
public class FailedHomePageTest extends BaseTest {

    CommonTestSteps commonTestSteps;
    HomePageTestSteps homePageTestSteps;
    @BeforeClass
    @Step("Creating step objects")
    public void createStepObjects(){
        commonTestSteps = new CommonTestSteps(webDriver);
        homePageTestSteps = new HomePageTestSteps(webDriver);
    }

    @Test(dataProvider = "credentials", dataProviderClass = UserData.class)
    public void executeTestSteps(String userName, String password) {


        //1. Open test site by URL
        commonTestSteps.openUrl();

        //2. Assert Browser title
        commonTestSteps.checkTabTitle();

        //3. Perform login
        commonTestSteps.signIn(userName, password);

        //4. Assert Username is loggined
        commonTestSteps.checkUsernameAfterLogin();

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        homePageTestSteps.checkHeaderItems();

        //6. Assert that there are 4 images on the Index Page and they are displayed
        homePageTestSteps.checkIndexPageIcons();

        //Copy the first test from HW3 to a separate class and make it failed
        homePageTestSteps.failTestOnPurpose();



        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePageTestSteps.checkTextUnderIcons();
        //8. Assert that there is the iframe with “Frame Button” exist
        homePageTestSteps.checkTopIframePresence();
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePageTestSteps.checkTopIframeButton();
        //10. Switch to original window back
        homePageTestSteps.switchFromIframe();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        homePageTestSteps.checkSidebarItems();
        //12. Close Browser
        // Closing the browser is implemented in the DriverConfigurator class
    }
}

