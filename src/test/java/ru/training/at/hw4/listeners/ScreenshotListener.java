package ru.training.at.hw4.listeners;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult testResult) {
        //Getting a WebDriver instance with ITestContext
        WebDriver webDriverItc = (WebDriver) testResult.getTestContext().getAttribute("webDriverInstance");

        //Taking a screenshot
        screenshotToByteArray(webDriverItc);
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] screenshotToByteArray(WebDriver webDriver){
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }

    public void screenshotToFile(WebDriver webDriver){
        //Defining screenshot file name and directory
        Date dateObject = Calendar.getInstance().getTime();
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(dateObject);
        String currentTime = new SimpleDateFormat("HH.mm.ss").format(dateObject);
        String filePath = "screenshots/Screenshot " + currentDate + " at " + currentTime + ".png";

        //Writing the file
        File image = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(image, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

