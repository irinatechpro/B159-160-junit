package com.myfirstproject.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public abstract class TestBase {
//    Test base is used to run @Before and After classes automatically in the child classes
    protected static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
//        WebDriverManager.firefoxdriver().setup();
//        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

//    @After
//    public void tearDown(){
//        driver.quit();
//    }
}
