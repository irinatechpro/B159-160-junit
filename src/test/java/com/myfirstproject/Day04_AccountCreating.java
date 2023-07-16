package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_AccountCreating {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void accountCreatingTest(){
//        1. Launch browser - DONE IN setUp
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//        3. Verify that home page is visible successfully
        Assert.assertTrue(driver.getTitle().equals("Automation Exercise"));
//        4. Click on 'Signup / Login' button
        driver.findElement(By.partialLinkText("Signup / Login")).click();
//        WebElement signUpLink = driver.findElement(By.partialLinkText("Signup / Login"));
//        signUpLink.click();
//        5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='New User Signup!']")).isDisplayed());
//        6. Enter name and email address
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("John Walker");
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("testab123@gmail.com");
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();

//        7. Click 'Signup' button
//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
//        9. Fill details: Title, Name, Email, Password, Date of birth
//        10. Select checkbox 'Sign up for our newsletter!'
//        11. Select checkbox 'Receive special offers from our partners!'
//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//        13. Click 'Create Account button'
//        14. Verify that 'ACCOUNT CREATED!' is visible
//        15. Click 'Continue' button
//        16. Verify that 'Logged in as username' is visible
//        17. Click 'Delete Account' button
//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    }
}
