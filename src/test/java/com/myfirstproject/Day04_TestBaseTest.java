package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;

public class Day04_TestBaseTest extends TestBase {

    @Test
    public void testBaseTest(){
        //Driver is coming from TestBase class
        //We dont need to create setUp() and tearDown() methods in test class.
        //From now on, we will use TestBase class
        driver.get("https://google.com");

    }

}