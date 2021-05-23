package ru.training.at.hw4.tests.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.training.at.hw4.pageobjects._void.HomePage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTestSteps  {

    private HomePage homePage;

    public HomePageTestSteps(WebDriver webDriverObject) {
        this.homePage = new HomePage(webDriverObject);
    }

    @Step("Verifying text and visibility of menubar items")
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

    @Step("Verifying visibility of 4 icons")
    public void checkIndexPageIcons() {
        //SoftAsserting that the icons are displayed
        List<WebElement> greenIcons = Arrays.asList(homePage.microscopeIcon, homePage.headsetIcon, homePage.screenIcon, homePage.rocketIcon);
        for (WebElement icon : greenIcons) {
            assertTrue(icon.isDisplayed());
        }
    }

    @Step("Verifying texts under 4 icons")
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

    @Step("Verifying iFrame presence")
    public void checkTopIframePresence() {
        //SoftAsserting that the iframe exists
        assertTrue(homePage.iFrames.size() != 0);
    }

    @Step("Verifying button presence in iFrame")
    public void checkTopIframeButton() {
        //Switching the webdriver to the top iFrame
        homePage.switchToTopIframe();
        //SoftAsserting that the "Frame Button" exists
        assertTrue(homePage.iFrameButtons.size() != 0);
    }

    @Step("Switching webdriver back from iFrame")
    public void switchFromIframe() {
        //Switching the webdriver back to the original window
        homePage.switchFromIframe();
    }

    @Step("Verifying text and visibility of sidebar items")
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

    @Step("Running a test method that fails")
    public void failTestOnPurpose(){
        assertTrue(false);
    }

    private void checkTextAndVisibility(Map<String, WebElement> items) {
        for (Map.Entry<String, WebElement> item : items.entrySet()) {
            assertTrue(item.getValue().isDisplayed());
            assertEquals(item.getValue().getText(), item.getKey());
        }
    }
}
