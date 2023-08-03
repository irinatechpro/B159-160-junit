package com.myfirstproject;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day13_ReusableMethods extends TestBase {
/*
    When user goes to https://www.automationexercise.com/
    And click on Sing up link
    And enter credentials and click sign up button
    And enter the information
    And click on Create Account
    Then verify the account creating is successful. Account Created! Element is displayed
    GOAL: Use Reusable Methods only.
 */

    @Test
    public void reusableMethodsTest() {
//        When user goes to https://www.automationexercise.com/
        //driver.get("https://www.automationexercise.com/");
        openURL("https://www.automationexercise.com/");

//        And click on Sing up link
        //driver.findElement(By.xpath("//a[.=' Signup / Login']")).click();
        clickWithTimeoutByJS(driver.findElement(By.xpath("//a[.=' Signup / Login']")));

//        And enter credentials and click sign up button
        Faker faker = new Faker();
        String firstname = faker.name().firstName();
        String email = faker.internet().emailAddress();
        sendKeysWithTimeout(driver.findElement(By.xpath("//input[@data-qa='signup-name']")), firstname, 5);
        sendKeysWithTimeout(driver.findElement(By.xpath("//input[@data-qa='signup-email']")), email, 5);
        clickWithTimeoutByJS(driver.findElement(By.xpath("//button[@data-qa='signup-button']")));

//        And enter the information
        clickRadioByIndex(0);//Index starts with 0, it is the first radio button= Mr.
        String password = faker.internet().password();
        System.out.println("password = " + password);
        sendKeysWithTimeout(driver.findElement(By.id("password")), password, 5);
        selectByVisibleText(driver.findElement(By.id("days")), "5");
        selectByVisibleText(driver.findElement(By.id("months")), "June");
        selectByVisibleText(driver.findElement(By.id("years")), "1999");

        sendKeysWithTimeout(driver.findElement(By.id("first_name")), firstname, 5);
        sendKeysWithTimeout(driver.findElement(By.id("last_name")), faker.name().lastName(), 5);
        sendKeysWithTimeout(driver.findElement(By.id("company")), faker.company().name(), 5);
        sendKeysWithTimeout(driver.findElement(By.id("address1")), faker.address().fullAddress(), 5);
        sendKeysWithTimeout(driver.findElement(By.id("address2")), faker.address().secondaryAddress(), 5);

        selectByVisibleText(driver.findElement(By.id("country")), "Canada");
        sendKeysWithTimeout(driver.findElement(By.id("state")), faker.address().state(), 5);
        sendKeysWithTimeout(driver.findElement(By.id("city")), faker.address().city(), 5);
        sendKeysWithTimeout(driver.findElement(By.id("zipcode")), faker.address().zipCode(), 5);
        sendKeysWithTimeout(driver.findElement(By.id("mobile_number")), faker.phoneNumber().cellPhone(), 5);

//        And click on Create Account
        clickWithTimeoutByJS(driver.findElement(By.xpath("//button[@data-qa='create-account']")));


//        Then verify the account creating is successful. Account Created! Element is displayed
//        String accountCreated = getTextWithTimeout(driver.findElement(By.xpath("//b[.='Account Created!']")),5);
//        System.out.println("accountCreated = " + accountCreated);

        verifyElementDisplayed(driver.findElement(By.xpath("//b[.='Account Created!']")));

    }
}