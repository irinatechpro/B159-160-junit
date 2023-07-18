package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;

public class Day04_TestBaseTest extends TestBase {
//    1. extent the test base class so that the before and after method are automatically called

    @Test
    public void testBaseTest(){
//        driver is coming from the test base class
//        we no longer need to do the set up or create driver in the test classes
//        because we can use test base
        driver.get("https://www.amazon.com");
    }


}
