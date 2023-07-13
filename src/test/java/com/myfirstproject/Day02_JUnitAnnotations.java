package com.myfirstproject;

import org.junit.*;

public class Day02_JUnitAnnotations {
    /*
    In JUnit, there are 6 annotations:
    1. @Test : creates test cases
        -All test cases should be void
    2. @Before and @After : runs before or after each @Test annotation
    3. @BeforeClass and @AfterClass :  runs only ONCE FOR EACH CLASS
    4. @Ignore : used to SKIP/IGNORE a test case
     */
    @Before
    public void setUp(){
        System.out.println("before method...");
    }
    @After
    public void tearDown(){
        System.out.println("tear down...");
    }
    @BeforeClass
    public static void setUpClass(){
        System.out.println("before class...");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("after class...");
    }
    @Test
    public void test1(){
        System.out.println("test case 1");
    }
    @Test @Ignore
    public void test2(){
        System.out.println("test case 2");
    }
    @Test
    public void test3(){
        System.out.println("test case 3");
    }
    @Test
    public void test4(){
        System.out.println("test case 4");
    }

    @Test@Ignore
    public void test5(){
        System.out.println("test case 5");
    }
    @Test
    public void test6(){
        System.out.println("test case 6");
    }

}
