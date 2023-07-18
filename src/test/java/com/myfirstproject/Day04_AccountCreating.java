package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
//        2. Navigate to url 'http://automationexercise.com'
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
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("testt11212120198@gmail.com");
//        test1121212012@gmail.com
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();

//        7. Click 'Signup' button
//        NA
//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
//        NA
//        9. Fill details: Title, Name, Email, Password, Date of birth
//        title
        driver.findElement(By.id("id_gender1")).click();
//        name already filled
//        email already filled
//        password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test123!");
//        Date of birth -> DROPDOWN : 1. index 2. value 3. visible text
//        DAY
//        1. locate the day dropdown element
        WebElement day = driver.findElement(By.xpath("//select[@data-qa='days']"));
//        2. create select object
        Select daySelect = new Select(day);
//        3. use select object to interact with dropdown
        daySelect.selectByIndex(5);//using index to select day 5. index starts at 0.
//        MONTH
//        1. locate the month dropdown element
        WebElement month = driver.findElement(By.cssSelector("select[data-qa='months']"));
//        2. create select object
        Select monthSelect = new Select(month);
//        3. use select object to interact with dropdown
        monthSelect.selectByValue("5");//using value to select May
//        YEAR
//        1. locate the year dropdown element
        WebElement year = driver.findElement( By.cssSelector("select[data-qa='years']"));
//        2. create select object
        Select yearSelect = new Select(year);
//        3. use select object to interact with dropdown
        yearSelect.selectByVisibleText("2000");//using visible text to select 2000
//        10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.cssSelector("input#newsletter")).click();
//        11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.cssSelector("#optin")).click();
//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//        first name
        driver.findElement(By.id("first_name")).sendKeys("John");
//        last name
        driver.findElement(By.id("last_name")).sendKeys("Walker");
//        company
        driver.findElement(By.id("company")).sendKeys("Amazon");
//        address
        driver.findElement(By.id("address1")).sendKeys("123 main st");
//        country - selecting United States
        WebElement country = driver.findElement(By.id("country"));
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("United States");
//        state
        driver.findElement(By.id("state")).sendKeys("TX");
//        city
        driver.findElement(By.id("city")).sendKeys("Dallas");
//        zip
        driver.findElement(By.id("zipcode")).sendKeys("75001");
//        mobile
        driver.findElement(By.id("mobile_number")).sendKeys("+12141234567");
//        13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[.='Create Account']")).click();



//        14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[.='Account Created!']")).isDisplayed());
//        15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
//        NOTE: THERE IS A WEB POP UP THAT IS SHOWING UP AFTER CLICKING CREATE ACCOUNT AND WE MUST CLOSE TO PROCEED
//        USING TRY CATCH BECAUSE THIS POP UP MAY NOT ALWAYS SHOW UP
        try {
//
            Thread.sleep(5000);
//            try to click the web pop up if it shows up
//            if the pop-up doesn't up, then do not fail.... just catch it.. and continue the test case
//            the pop up is inside the iframe so we must switch to the iframe first
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='ad_iframe']")));
            Thread.sleep(5000);
            driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
        }catch (Exception e){
            System.out.println("POP UP IS NOT DISPLAYED... JUST CONTINUE");
        }
        try {
//
            Thread.sleep(5000);
//            try to click the web pop up if it shows up
//            if the pop-up doesn't up, then do not fail.... just catch it.. and continue the test case
//            the pop up is inside the iframe so we must switch to the iframe first
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='aswift_1']")));
            Thread.sleep(5000);
            driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
        }catch (Exception e){
            System.out.println("POP UP IS NOT DISPLAYED... JUST CONTINUE");
        }
//        16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Logged in as')]")).isDisplayed());
//        17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[contains(text(),'Delete Account')")).click();
//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Account Deleted!')]")).isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();


    }
}
