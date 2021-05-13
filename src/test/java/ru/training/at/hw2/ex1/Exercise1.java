package ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.training.at.hw2.BaseTest;

import java.util.*;


public class Exercise1 extends BaseTest {

    @Test(dataProvider = "credentials", dataProviderClass = BaseTest.class)
    public void executeTestSteps(String userName, String password) {
        //1. Open test site by URL
        openUrl();

        //2. Assert Browser title
        checkTabTitle();

        //3. Perform login
        checkAuthorization(userName, password);

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
        // Closing the browser is implemented in the BaseTest class
    }


    public void openUrl() {
        //Opening the URL with the webdriver
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public void checkTabTitle() {
        //Obtaining tab title form the webdriver
        String actualTabTitle = webDriver.getTitle();

        //SoftAsserting that the tab title matches the expected
        String expectedTabTitle = "Home Page";
        softAssertObject.assertEquals(actualTabTitle, expectedTabTitle);
    }

    public void checkAuthorization(String userName, String password) {
        //Locating the user icon and performing a click on it
        WebElement userIcon = webDriver.findElement(By.id("user-icon"));
        userIcon.click();

        //Locating the login field and filling it in
        WebElement loginField = webDriver.findElement(By.id("name"));
        loginField.sendKeys(userName);

        //Locating the password field and filling it in
        WebElement passwordField = webDriver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        //Locating the enter button and performing a clock on it
        WebElement enterButton = webDriver.findElement(By.className("fa-sign-in"));
        enterButton.click();
    }

    public void checkUsernameAfterLogin() {
        //Locating the username element with id
        WebElement displayedName = webDriver.findElement(By.id("user-name"));

        //SoftAsserting that the username is displayed
        softAssertObject.assertTrue(displayedName.isDisplayed());

        //SoftAsserting that the displayed username matches the expected username
        String expectedUsername = "ROMAN IOVLEV";
        softAssertObject.assertEquals(displayedName.getText(), expectedUsername);
    }

    public void checkHeaderItems() {
        //Locating the elements with CSS selectors
        WebElement homeButton = webDriver.findElement(By.cssSelector("ul.uui-navigation>li:nth-child(1)>a[href='index.html']"));
        WebElement contactFormButton = webDriver.findElement(By.cssSelector("ul.uui-navigation>li:nth-child(2)>a[href='contacts.html']"));
        WebElement serviceButton = webDriver.findElement(By.cssSelector("ul.uui-navigation>li:nth-child(3).dropdown>a"));
        WebElement metalsAndColorsButton = webDriver.findElement(By.cssSelector("ul.uui-navigation>li:nth-child(4)>a[href='metals-colors.html']"));

        //Expected texts
        Map<String, WebElement> headerItems = new HashMap<>();
        headerItems.put("HOME", homeButton);
        headerItems.put("CONTACT FORM", contactFormButton);
        headerItems.put("SERVICE", serviceButton);
        headerItems.put("METALS & COLORS", metalsAndColorsButton);

        //SoftAsserting that the header items are displayed and contain correct text
        for (Map.Entry<String, WebElement> item : headerItems.entrySet()) {
            softAssertObject.assertTrue(item.getValue().isDisplayed());
            softAssertObject.assertEquals(item.getKey(), item.getValue().getText());
        }
    }

    public void checkIndexPageIcons() {
        //Locating elements with CSS selectors
        List<WebElement> greenIcons = webDriver.findElements(By.cssSelector("div.benefit-icon>span.icons-benefit"));

        //SoftAsserting that the 4 icons are displayed
        for (WebElement icon : greenIcons) {
            softAssertObject.assertTrue(icon.isDisplayed());
        }
        softAssertObject.assertTrue(greenIcons.size() == 4);
    }

    public void checkTextUnderIcons() {
        //Expected texts
        String expectedTextMicroscope = "To include good practices\nand ideas from successful\nEPAM project";
        String expectedTextHeadset = "To be flexible and\ncustomizable";
        String expectedTextScreen = "To be multiplatform";
        String expectedTextRocket = "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…";
        List<String> expectedTexts = Arrays.asList(expectedTextMicroscope, expectedTextHeadset, expectedTextScreen, expectedTextRocket);

        //Locating the text elements with a CSS selector
        List<WebElement> actualTexts = webDriver.findElements(By.cssSelector("div.row.clerafix.benefits>div.col-sm-3>div.benefit>span.benefit-txt"));

        //SoftAsserting that the 4 texts are displayed
        softAssertObject.assertTrue(actualTexts.size() == 4);
        for (WebElement text : actualTexts) {
            softAssertObject.assertTrue(text.isDisplayed());
        }

        //SoftAsserting that the displayed texts match the expected texts
        for (int i = 0; i < 4; i++) {
            softAssertObject.assertEquals(actualTexts.get(i).getText(), expectedTexts.get(i));
        }
    }

    public void checkTopIframePresence() {
        //Searching for the iframe with the “Frame Button”
        List<WebElement> iFrames = webDriver.findElements(By.id("frame"));

        //SoftAsserting that the iframe exists
        softAssertObject.assertTrue(iFrames.size() != 0);
    }

    public void checkTopIframeButton() {
        //Switching the webdriver to the iframe
        webDriver.switchTo().frame("frame");

        //Searching for the "Frame Button" within the iframe
        List<WebElement> frameButtons = webDriver.findElements(By.id("frame-button"));

        //SoftAsserting that the "Frame Button" exists
        softAssertObject.assertTrue(frameButtons.size() != 0);
    }

    public void switchFromIframe() {
        //Switching the webdriver back to the original window
        webDriver.switchTo().defaultContent();
    }

    public void checkSidebarItems() {
        //Locating the sidebar items with CSS selectors
        WebElement homeSection = webDriver.findElement(By.cssSelector("#mCSB_1_container>ul.sidebar-menu.left>li[index='1']"));
        WebElement contactFormSection = webDriver.findElement(By.cssSelector("#mCSB_1_container>ul.sidebar-menu.left>li[index='2']"));
        WebElement serviceSection = webDriver.findElement(By.cssSelector("#mCSB_1_container>ul.sidebar-menu.left>li[index='3']"));
        WebElement metalsAndColorsSection = webDriver.findElement(By.cssSelector("#mCSB_1_container>ul.sidebar-menu.left>li[index='4']"));
        WebElement elementsPacksSection = webDriver.findElement(By.cssSelector("#mCSB_1_container>ul.sidebar-menu.left>li[index='5']"));

        //Expected text
        Map<String, WebElement> sidebarItems = new HashMap<>();
        sidebarItems.put("Home", homeSection);
        sidebarItems.put("Contact form", contactFormSection);
        sidebarItems.put("Service", serviceSection);
        sidebarItems.put("Metals & Colors", metalsAndColorsSection);
        sidebarItems.put("Elements packs", elementsPacksSection);

        //SoftAsserting that the sidebar items are displayed and contain correct text
        for (Map.Entry<String, WebElement> item : sidebarItems.entrySet()) {
            softAssertObject.assertTrue(item.getValue().isDisplayed());
            softAssertObject.assertEquals(item.getKey(), item.getValue().getText());
        }
    }

}
