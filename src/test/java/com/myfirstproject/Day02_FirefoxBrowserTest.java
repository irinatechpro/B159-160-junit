package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day02_FirefoxBrowserTest {

    public static void main(String[] args) {
//        https://www.mozilla.org/en-US/firefox/new/
//        https://github.com/mozilla/geckodriver/releases
//        Create a new class under : FirefoxBrowserTest
//        Create main method
//        Set Path
        System.setProperty("webdriver.firefox.driver","./drivers/geckodriver");//MAC
//        System.setProperty("webdriver.firefox.driver",".\\drivers\\geckodriver.exe");//WINDOWS

//        Create gecko driver
        WebDriver driver = new FirefoxDriver();

//        REST IS THE SAME FOR ALL BROWSERS
//        Open google home page https://www.amazon.com/
        driver.get("https://www.amazon.com/");

//        Maximize the window
        driver.manage().window().maximize();

//        Close/Quit the browser
        driver.quit();
    }
}
