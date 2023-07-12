package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_Navigations {
    public static void main(String[] args) {
//        Test Case Steps:
//        Create a new class under : BasicNavigations -DONE
//        Create main method - DONE
//        Set Path
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");//MAC
//        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");//WIN

//        Create chrome driver
        WebDriver driver = new ChromeDriver();

//        Maximize the window
        driver.manage().window().maximize();

//        Open google home page https://www.walmart.com/
        driver.get("https://www.walmart.com/");

//        On the same class, Navigate to amazon home page https://www.amazon.com/
//        driver.get("https://www.amazon.com/");//ALTERNATIVELY WE CAN USE NAVIGATE TO METHOD
        driver.navigate().to("https://www.amazon.com/");

//        Navigate back to walmart
        driver.navigate().back();

//        Navigate forward to amazon
        driver.navigate().forward();

//        Refresh the page
        driver.navigate().refresh();

//        Close/Quit the browser
//        driver.close(); // closes only last active window
        driver.quit(); //closed all open windows. stronger.
        /*
        1. What is the difference between get and navigate to?
        -Similarities : both is used to go to a URL
        -get is shorter and easier to use
        -get accepts only string parameter; however navigate to accepts either string or URL object in the parameter
        -navigate has more options such as to, back, forward, refresh.

        2. What is the difference between close and quit?
        -close closes only the last active browser
        -quit closes all active browsers
        -I prefer to use quit to close all browser after my test case
         */
    }
}
