package ru.training.at.hw3.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw3.webpages.HomePage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise1HomePageTest extends BaseTest {

    HomePage homePage;

    @BeforeClass
    public void createHomePageObject() {
        homePage = new HomePage(webDriver);
    }

    @Test(dataProvider = "credentials", dataProviderClass = UserData.class)
    public void executeTestSteps(String userName, String password) {
        //1. Open test site by URL
        openTestSiteUrl();

        //2. Assert Browser title
        checkTabTitle();

        //3. Perform login
        signIn(userName, password);

        //4. Assert Username is loggined
        checkUsernameAfterLogin();

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        checkHeaderItems();

        //6. Assert that there are 4 images on the Index Page and they are displayed
        checkIndexPageIcons();

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        checkTextUnderIcons();

        //8. Assert that there is the iframe with “Frame Button” exist
        checkTopIframePresence();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        checkTopIframeButton();

        //10. Switch to original window back
        switchFromIframe();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        checkSidebarItems();

        //12. Close Browser
        // Closing the browser is implemented in the DriverConfigurator class
    }

    public void openTestSiteUrl() {
        //Opening the URL
        homePage.openPage();
    }

    public void checkTabTitle() {
        //SoftAsserting that the tab title matches the expected
        softAssert.assertEquals(homePage.getTabTitle(), "Home Page");
    }

    public void signIn(String userName, String password) {
        //Performing a sign-in
        homePage.userAccountMenu.authorizeUser(userName, password);
    }

    public void checkUsernameAfterLogin() {
        //SoftAsserting that the username is displayed
        softAssert.assertTrue(homePage.userAccountMenu.displayedName.isDisplayed());

        //SoftAsserting that the displayed username matches the expected username
        softAssert.assertEquals(homePage.userAccountMenu.displayedName.getText(), "ROMAN IOVLEV");
    }

    public void checkHeaderItems() {
        //Expected texts
        Map<String, WebElement> headerItems = new HashMap<>();
        headerItems.put("HOME", homePage.menuBar.home);
        headerItems.put("CONTACT FORM", homePage.menuBar.contactForm);
        headerItems.put("SERVICE", homePage.menuBar.service);
        headerItems.put("METALS & COLORS", homePage.menuBar.metalsAndColors);

        //SoftAsserting that the elements are visible and contain correct texts
        checkTextAndVisibility(headerItems);
    }

    public void checkIndexPageIcons() {
        //SoftAsserting that the icons are displayed
        List<WebElement> greenIcons = Arrays.asList(homePage.microscopeIcon, homePage.headsetIcon, homePage.screenIcon, homePage.rocketIcon);
        for (WebElement icon : greenIcons) {
            softAssert.assertTrue(icon.isDisplayed());
        }
    }

    public void checkTextUnderIcons() {
        //Expected texts
        String expectedMicroscopeText = "To include good practices\nand ideas from successful\nEPAM project";
        String expectedHeadsetText = "To be flexible and\ncustomizable";
        String expectedScreenText = "To be multiplatform";
        String expectedRocketText = "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…";
        Map<String, WebElement> iconTexts = new HashMap<>();
        iconTexts.put(expectedMicroscopeText, homePage.microscopeText);
        iconTexts.put(expectedHeadsetText, homePage.headsetText);
        iconTexts.put(expectedScreenText, homePage.screenText);
        iconTexts.put(expectedRocketText, homePage.rocketText);

        //SoftAsserting that the elements are visible and contain correct texts
        checkTextAndVisibility(iconTexts);
    }

    public void checkTopIframePresence() {
        //SoftAsserting that the iframe exists
        softAssert.assertTrue(homePage.iFrames.size() != 0);
    }

    public void checkTopIframeButton() {
        //Switching the webdriver to the top iFrame
        homePage.switchToTopIframe();
        //SoftAsserting that the "Frame Button" exists
        softAssert.assertTrue(homePage.iFrameButtons.size() != 0);
    }

    public void switchFromIframe() {
        //Switching the webdriver back to the original window
        homePage.switchFromIframe();
    }

    public void checkSidebarItems() {
        //Expected texts
        HashMap<String, WebElement> sidebarItems = new HashMap<>();
        sidebarItems.put("Home", homePage.sideBar.homeSection);
        sidebarItems.put("Contact form", homePage.sideBar.contactFormSection);
        sidebarItems.put("Service", homePage.sideBar.serviceSection);
        sidebarItems.put("Metals & Colors", homePage.sideBar.metalsAndColorsSection);
        sidebarItems.put("Elements packs", homePage.sideBar.elementsPacksSection);

        //SoftAsserting that the elements are visible and contain correct texts
        checkTextAndVisibility(sidebarItems);
    }

}
