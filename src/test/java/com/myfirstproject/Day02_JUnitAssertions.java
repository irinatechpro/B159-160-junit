package com.myfirstproject;

import org.junit.Assert;
import org.junit.Test;

public class Day02_JUnitAssertions {
    /*
    ***What is Assertion?
    Assertion is used to check if expected is equal to actual
    Assertion is very important and is a MUST to improve the quality of the application
    expected = actual => PASS
    expected != actual => FAIL
    * *************************
    * assertEquals
    * assertTrue
    * assertFalse
    * *************************
    * These assertions are HARD ASSERTION, meaning that if JUnit assertion fails, then test case stop executing
    * verification = soft assertion = not hard assert, meaning that if soft assert fails, test case continue to execute
    * Note that there is no soft assert in JUnit.
     */
    @Test
    public void assertions(){
        Assert.assertEquals(5,5);
        Assert.assertEquals("Test Case Failed",5,5);//If test case fails, we see the message
        Assert.assertTrue("apple".contains("a"));
        Assert.assertFalse("apple".contains("b"));
    }
}
