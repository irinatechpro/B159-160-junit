package com.myfirstproject.practices.practice05;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;

public class Q04_WebTables_RoofHeight extends TestBase {

//We will make a roof of 5% of the height of the earliest built tower.
//Find how many meters we will build.
 /*
Given
    Go to https://www.techlistic.com/p/demo-selenium-practice.html
When
    Put all built years into a list
And
    Calculate min year
And
    Put all heights into a list
And
    Calculate the height to build
Then
    Assert that build height is 25.45 meters
 */
    @Test
    public void webTables_RoofHeight(){
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");


    }

}
