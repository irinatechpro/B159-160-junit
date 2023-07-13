package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Day02_WebDriverManagerTest {
    public static void main(String[] args) {
        //        Create a class WebDriverManagerTest
        //        Create a test case that will navigate to amazon page
        //        Use WebDriverManager class to set up chrome driver
//
//        ****************WITHOUR WEBDRIVER MANAGER************
//        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.amazon.com");
//        driver.close();


//        **************WITH WEBDRIVER MANAGER******************
        /*
        WebDriverManager : This is an API that is used to set up the drivers
        From now on, use WebDriverManager to set up driver instead of System.setProperty
        We no longer need to use System.setProperty
         */

        //TESTING ON CHROME
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.close();


//        //TESTING ON FIREFOX
//        WebDriverManager.firefoxdriver().setup();
//        WebDriver firefox = new FirefoxDriver();
//        firefox.get("https://www.amazon.com");
//        firefox.close();

//        //TESTING ON EDGE
//        WebDriverManager.edgedriver().setup();
//        WebDriver edge = new EdgeDriver();
//        edge.get("https://www.amazon.com");
//        edge.close();
//
//        //TESTING ON SAFARI
//        WebDriverManager.safaridriver().setup();
//        WebDriver safari = new SafariDriver();
//        safari.get("https://www.amazon.com");
//        safari.close();


    }
}
