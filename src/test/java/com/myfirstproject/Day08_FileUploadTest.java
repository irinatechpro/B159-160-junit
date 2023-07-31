package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;

public class Day08_FileUploadTest extends TestBase {

    @Test
    public void fileUploadTest() throws InterruptedException {

//        When user goes to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

//        When user selects an image from the desktop
        //Set the path of the file
        String pathOfTheFile = System.getProperty("user.home") + "/Desktop/image_360.jpg";

        //Since the input type is "File" we can use sendKeys() method to upload the file
        //Alternatively we can use Java Robot class
        //Locate the input web element

        WebElement chooseFileInput = driver.findElement(By.id("file-upload"));
        Thread.sleep(2000);
        chooseFileInput.sendKeys(pathOfTheFile);

//        And click on the upload button
        Thread.sleep(2000);
        driver.findElement(By.id("file-submit")).click();

//        Then verify the File Uploaded! Message displayed
        String fileUploadedMessage = driver.findElement(By.xpath("/h3")).getText();
        assertEquals("File Uploaded!", fileUploadedMessage);

        //Assert.assertTrue(driver.findElement(By.xpath("//div[@class='explanation']//p")).getText().equals("File Uploaded!"));

    }
        //    ROBOT ALTERNATIVE- may not work with mac
        @Test
        public void fileUploadRobot() throws InterruptedException, AWTException {
            //    Class Name: FileUploadTest
//    Method Name: fileUploadTest
//    When user goes to https://testpages.herokuapp.com/styled/file-upload-test.html
            driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");
//    When user selects an image from the desktop
        /*
        TAG = input,ATTRIBUTE = type, VALUE = file Then we can use sendKeys("PATH")
        ALTERNATIVELY Java Robot class can be used to upload file
         */
            //locating the path image that I want to uplaod
            String pathOfImage = System.getProperty("user.home")+"/Desktop/image.jpeg";
            //sending path to the choose a file element !!!!!!!!!
//        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(pathOfImage);
            // file path passed as parameter to StringSelection
            StringSelection s = new StringSelection(pathOfImage);//ROBOT
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);//ROBOT
            Robot robot = new Robot();
//        pressing control V
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
//        unpress control v
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
//        click enter
            robot.keyPress(KeyEvent.VK_ENTER);
//        release enter
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
//    And click on the upload button
            //clicking the upload button
            driver.findElement(By.xpath("//input[@type='submit']")).click();
            Thread.sleep(2000);
//    Then verify the ‘You uploaded a file. This is the result.’ Message displayed
            Assert.assertTrue(
                    driver
                            .findElement(By.xpath("//div[@class='explanation']//p"))
                            .getText()
                            .equals("You uploaded a file. This is the result."));
    }
}