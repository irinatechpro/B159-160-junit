package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FirstSeleniumClass {
    public static void main(String[] args) {
//        Introduce this class the path of your driver and the type of that driver
//        System.setProperty("type of driver","path of the driver");

//        1. setting the path of the driver
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");//MAC = no .exe extension
//        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");//WINDOWS = .exe is required

//        2. creating the driver
        WebDriver driver = new ChromeDriver();

//        3. go to amazon
        driver.get("https://www.google.com");
    }
}
