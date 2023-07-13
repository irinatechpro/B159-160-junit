package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyTitleTest {

    public static void main(String[] args) {


//      set up driver
        WebDriverManager.chromedriver().setup();
        //create the driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //START TESTING....
//        1.Create a new class: VerifyTitleTest
//        2.Navigate to amazon homepage
        driver.get("https://www.amazon.com");
//        3.Verify if page title contains “Amazon”
        String actualPageTitle = driver.getTitle();//getTitle() returns the title of the page as String
        String expectedPageTitle = "Amazon";
        if (actualPageTitle.contains(expectedPageTitle)){
            System.out.println("PASS...");
        }else {
            System.out.println("FAIL...");
            System.out.println("ACTUAL TITLE : "+driver.getTitle());
            System.out.println("BUT EXPECTED TITLE : Amazon");
            System.out.println("Actual title doesn't contain Amazon");
        }
        driver.quit();

    }
}
