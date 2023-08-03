package com.myfirstproject.practices.practice05;

import org.junit.Test;


    import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

    public class Q01_Actions_DrawShape extends TestBase {
        /*
    Go to http://szimek.github.io/signature_pad/
    Draw the line or shape you want on the screen
    Press the clear button after drawing
    Close the page
     */

        @Test
        public void actions_DrawShape() {
//        Go to http://szimek.github.io/signature_pad/
            driver.get("http://szimek.github.io/signature_pad/");

//        Draw the line or shape you want on the screen
            WebElement board = driver.findElement(By.xpath("//canvas"));
            Actions actions = new Actions(driver).clickAndHold(board);

            for (int i = 0; i < 20; i++) {
                actions.moveByOffset(-5, -5);
            }

            for (int i = 0; i < 20; i++) {
                actions.moveByOffset(0, 5);
            }

            for (int i = 0; i < 20; i++) {
                actions.moveByOffset(-5, 0).perform();
            }


//        Press the clear button after drawing
            actions.click(driver.findElement(By.xpath("//button[.='Clear']"))).perform();

//        Close the page


        }
    }

