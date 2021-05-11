package ru.training.at.hw3.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw3.webpages.HomePage;

public class Exercise1HomePageTest extends BaseTest{

    HomePage homePage;
    @BeforeClass
    public void createHomePageObject(){
        homePage = new HomePage(webDriver);
    }

    @Test(dataProvider = "credentials", dataProviderClass = UserData.class)
    public void executeTestSteps(String userName, String password){
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
        // SoftAsserting the visibility of the elements
        softAssert.assertTrue(homePage.menuBar.home.isDisplayed());
        softAssert.assertTrue(homePage.menuBar.contactForm.isDisplayed());
        softAssert.assertTrue(homePage.menuBar.service.isDisplayed());
        softAssert.assertTrue(homePage.menuBar.metalsAndColors.isDisplayed());
        // SoftAsserting button texts
        softAssert.assertEquals(homePage.menuBar.home.getText(),"HOME");
        softAssert.assertEquals(homePage.menuBar.contactForm.getText(),"CONTACT FORM");
        softAssert.assertEquals(homePage.menuBar.service.getText(),"SERVICE");
        softAssert.assertEquals(homePage.menuBar.metalsAndColors.getText(),"METALS & COLORS");
    }

    public void checkIndexPageIcons() {
        //SoftAsserting that the icons are displayed
        softAssert.assertTrue(homePage.microscopeIcon.isDisplayed());
        softAssert.assertTrue(homePage.headsetIcon.isDisplayed());
        softAssert.assertTrue(homePage.screenIcon.isDisplayed());
        softAssert.assertTrue(homePage.rocketIcon.isDisplayed());
    }

    public void checkTextUnderIcons() {
        //Expected texts
        String expectedMicroscopeText = "To include good practices\nand ideas from successful\nEPAM project";
        String expectedHeadsetText = "To be flexible and\ncustomizable";
        String expectedScreenText = "To be multiplatform";
        String expectedRocketText = "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…";

        //SoftAsserting that the texts are displayed
        softAssert.assertTrue(homePage.microscopeText.isDisplayed());
        softAssert.assertTrue(homePage.headsetText.isDisplayed());
        softAssert.assertTrue(homePage.screenText.isDisplayed());
        softAssert.assertTrue(homePage.rocketText.isDisplayed());

        //SoftAsserting that the displayed texts match the expected texts
        softAssert.assertEquals(homePage.microscopeText.getText(), expectedMicroscopeText);
        softAssert.assertEquals(homePage.headsetText.getText(), expectedHeadsetText);
        softAssert.assertEquals(homePage.screenText.getText(), expectedScreenText);
        softAssert.assertEquals(homePage.rocketText.getText(), expectedRocketText);
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
        //SoftAsserting that the sidebar items are displayed
        softAssert.assertTrue(homePage.sideBar.homeSection.isDisplayed());
        softAssert.assertTrue(homePage.sideBar.contactFormSection.isDisplayed());
        softAssert.assertTrue(homePage.sideBar.serviceSection.isDisplayed());
        softAssert.assertTrue(homePage.sideBar.metalsAndColorsSection.isDisplayed());
        softAssert.assertTrue(homePage.sideBar.elementsPacksSection.isDisplayed());

        //SoftAsserting that the sidebar items contain correct text
        softAssert.assertEquals(homePage.sideBar.homeSection.getText(),"Home");
        softAssert.assertEquals(homePage.sideBar.contactFormSection.getText(), "Contact form");
        softAssert.assertEquals(homePage.sideBar.serviceSection.getText(),"Service");
        softAssert.assertEquals(homePage.sideBar.metalsAndColorsSection.getText(),"Metals & Colors");
        softAssert.assertEquals(homePage.sideBar.elementsPacksSection.getText(),"Elements packs");
    }
}
