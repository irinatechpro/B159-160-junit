package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSourceTest {
//    Test if amazon contains “Registry” on the homepage
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        String actualPageSource = driver.getPageSource();
        if (actualPageSource.contains("Registry")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("Page Source doesn't contain 'Registry' keyword");
        }
        driver.quit();
    }
}
