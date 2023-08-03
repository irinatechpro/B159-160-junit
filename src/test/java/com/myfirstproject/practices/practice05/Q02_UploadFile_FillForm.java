package com.myfirstproject.practices.practice05;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

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
//       Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
driver.get("testpages.herokuapp.com/styled/basic-html-form-test.html");
//        Fill the username, password and textArea comment:
        driver.findElement(By.name("username"))
//        Choose a file and upload it
//        Select checkbox, radio item and dropdowns
//        Click on submit
//        Verify that uploaded file name is on the Form Details.


    }


}