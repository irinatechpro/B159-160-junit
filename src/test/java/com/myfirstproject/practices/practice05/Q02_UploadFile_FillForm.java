package com.myfirstproject.practices.practice05;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class Q02_UploadFile_FillForm extends TestBase {

    /*
    Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
    Fill the username, password and textArea comment:
    Choose a file and upload it
    Select checkbox, radio item and dropdowns
    Click on submit
    Verify that uploaded file name is on the Form Details.
    */
    @Test
    public void uploadFile_FillForm() {
//        Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

//        Fill the username, password and textArea comment:
        driver.findElement(By.name("username")).sendKeys(Faker.instance().name().username());
        driver.findElement(By.name("password")).sendKeys(Faker.instance().internet().password());
        driver.findElement(By.xpath("//textarea")).clear();
        driver.findElement(By.xpath("//textarea")).sendKeys("Hello, this is my application");

//        Choose a file and upload it
        driver.findElement(By.name("filename")).sendKeys(System.getProperty("user.home") + "/Desktop\\1.JPG");

//        Select all checkboxes, radio buttons and first dropdowns
        driver
                .findElements(By.xpath("//input[@type='checkbox']"))
                .stream()
                .filter(t -> !t.isSelected())
                .forEach(WebElement::click);

        driver.findElement(By.xpath("//input[@value='rd1']")).click();

        Select multSelect = new Select(driver.findElement(By.xpath("//select[@multiple='multiple']")));
        multSelect.deselectAll();
        multSelect.selectByIndex(0);

        new Select(driver.findElement(By.xpath("//select[@name='dropdown']"))).selectByIndex(0);

//        Click on submit
        driver.findElement(By.xpath("//input[@type='submit']")).click();

//        Verify that uploaded file name is on the Form Details.
        String fileName = driver.findElement(By.id("_valuefilename")).getText();
        assertEquals("1.JPG", fileName);

    }
}