package com.myfirstproject.practices.practice05;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class Q03_Wait_AjaxLoader extends TestBase {
     /*
    Given
        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
    When
        Click on Ajax Loader
    And
        Click on "Click Me!" button
    Then
        Assert that button is clicked
    And
        Take screenshot after each step
     */

    @Test
    public void wait_AjaxLoader() throws IOException {
//        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        extentTest.pass("Go to 'http://webdriveruniversity.com/Popup-Alerts/index.html'")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString());

//        Click on Ajax Loader
        driver.findElement(By.id("button3")).click();
        extentTest.pass("Click on Ajax Loader").addScreenCaptureFromPath(captureScreenshotEntirePageAsString());

//        Click on "Click Me!" button
        waitForClickablility(By.id("button1"), 10).click();
        extentTest.pass("Click on \"Click Me!\" button").addScreenCaptureFromPath(captureScreenshotEntirePageAsString());

//        Assert that button is clicked
//        String successMessage = driver.findElement(By.xpath("//h4[.='Well Done For Waiting....!!!']")).getText();
//        assertTrue(successMessage.contains("Well Done"));

        String successMessage = waitForVisibility(By.xpath("//h4[.='Well Done For Waiting....!!!']"), 10).getText();
        System.out.println("successMessage = " + successMessage);
        assertTrue(successMessage.contains("Well Done"));
        extentTest.pass("Assert that button is clicked").addScreenCaptureFromPath(captureScreenshotEntirePageAsString());

//        Take screenshot after each step

    }
}