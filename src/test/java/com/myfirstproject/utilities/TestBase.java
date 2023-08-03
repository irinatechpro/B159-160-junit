package com.myfirstproject.utilities;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
//import org.openqprotecteda.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class TestBase {
    //    Test base is used to run @Before and After classes automatically in the child classes
    protected static WebDriver driver;
    //    Create the 3 Extent report objects
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;
    @BeforeClass
    public static void extentReportsSetup(){
//        these steps must be executed before each class so that the reports generation happens
//        path: reports will be created in Reports folder
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Reports/"+now+"extent-reports.html";
//        html report can be created using extenthtmlreporter in that path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        create extent report object so the report template can be generated
        extentReports = new ExtentReports();
//        *****OPTIONALLY ADD CUSTOM SYSTEM INFORMATION****
        extentReports.setSystemInfo("Project Name","Apple Macbook Project");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Environment","Regression");
        extentReports.setSystemInfo("Team Name","Eagles");
        extentReports.setSystemInfo("SQA","Shabnam");
//        *****OPTIONALLY ADD DOCUMENT INFORMATION****
        extentHtmlReporter.config().setDocumentTitle("My Extent Report");
        extentHtmlReporter.config().setReportName("My Regression Report");
//        ****DONE WITH CONFIGURATIONS****
//        attaching the extent report and extent html report
        extentReports.attachReporter(extentHtmlReporter);
//        ****CREATE EXTENT TEST THAT IS ALSO KNOWS AS LOGGER TO LOG TEST STEPS ON THE REPORT
        extentTest = extentReports.createTest("My Apple Regression Report","Team Eagles Reports");

    }
    @AfterClass
    public static void tearDownReports(){
//        required to generate the report
        extentReports.flush();
    }
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
//        WebDriverManager.firefoxdriver().setup();
//        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //driver.manage().window().maximize();

    }

    @After
    public void tearDown(){
      // driver.quit();
    }

    //    creating a method that will capture the screenshot of the entire page
//    the should be used when we want to capture the enrite page screenshot
    public void captureScreenshotEntirePage() {
//        1. getScreenShotAs method to capture the screenshot
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        2. save the image in a path with a dynamic name
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Screenshot/"+now+"image.png";
//        3. save the image in the path
        try {
            FileUtils.copyFile(image,new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    This method will be used to attach the screenshots in the automation reports
//    This method captures the screenshot and returns the screenshot path as string
//    so that we can attach this screenshot in out reports
    public static String captureScreenshotEntirePageAsString() {
//        1. getScreenShotAs method to capture the screenshot
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        2. save the image in a path with a dynamic name
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Reports/"+now+"image.png";
//        3. save the image in the path
        try {
            FileUtils.copyFile(image,new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        4. return the absolute path of the image path that is a string
        return new File(path).getAbsolutePath();
    }


    /*
    captures the screenshot of specific elements
    @param : WebElement
     */
    public void captureScreenshotElement(WebElement element)  {
//        1. getScreenShotAs method to capture the screenshot of the element
//        this is the only difference between capturing the entire page or specific element
        File image = element.getScreenshotAs(OutputType.FILE);
//        2. save the image in a path with a dynamic name
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/ElementScreenshot/"+now+"image.png";
//        3. save the image in the path
        try {
            FileUtils.copyFile(image,new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    JS EXECUTOR METHODS
    /*
    click with JS
    param : WebElement
    action : clicks on the given element
     */
    public static void clickByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }

    //    EXPLICITLY WAIT FOR ELEMENT TO BE VISIBLE, SCROLL INTO THE ELEMENT, THEN CLICK BY JS
    public static void clickWithTimeoutByJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", waitForVisibility(element,5));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }



    /*
    scroll into specific elements
    param : WebElement
    action: scrolls into the given element
     */
    public static void scrollIntoViewJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    /*
    scroll all the way down
     */
    public static void scrollAllDownJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    /*
    scroll all the way UP
     */
    public static void scrollAllUpJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    /*
     locating elements by javascript executor-normally we may not need this at all
    param : id of the element
    return WebElement
     */
    public WebElement locateElementByJS(String id){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return ((WebElement)js.executeScript("return document.getElementById('"+id+"')"));
    }

    /*
    getting the VALUE of elements-useful to get the values of input elements where getText() doesn't work
    param : id of the element
    locating the element and returning the value of the element
    return document.getElementById('"+id+"') -> RETURNS THE ELEMENT BY ID
    return document.getElementById('"+id+"').value -> RETURNS THE VALUE ATTRIBUTE OF THE ELEMENT
    toString() -> RETURN THE VALUE AS STRING
     */
    public static String getValueByJS(String id){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.getElementById('"+id+"').value").toString();
    }
    /*
    @param1 WebElement, @param2 String
    type the string in that input element
     */
    public static void setValueByJS(WebElement inputElement,String text){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+text+"')",inputElement);
    }

    /*   HARD WAIT:
    @param : second
  */
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /*
    SELENIUM WAIT REUSABLE METHODS
     */
    //    DYNAMIC SELENIUM WAITS:
    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    public static String getTextWithTimeout(WebElement element, int timeout) {
        String text="";
        for (int i = 0; i < timeout; i++) {
            try {
                text = element.getText();
                return text;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
        return null;
    }

    /*
    Custom method to wait to type in an input
     */
    public static void sendKeysWithTimeout(WebElement element,String text,int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }


    //    This can be used when a new page opens
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }
    //======Fluent Wait====
    // params : xpath of teh element , max timeout in seconds, polling in second
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }


    //    RADIO BUTTON
    public void clickRadioByIndex(int index){
        int numOfRadio =driver.findElements(By.xpath("//input[@type='radio']")).size();
        for (int i=0;i<numOfRadio;i++){
            if (!driver.findElements(By.xpath("//input[@type='radio']")).get(index).isSelected()) {
                driver.findElements(By.xpath("//input[@type='radio']")).get(index).click();
            }
        }
    }

    //    CHECKBOX BUTTON
    public void clickCheckboxByIndex(int index){
        int numOfRadio =driver.findElements(By.xpath("//input[@type='checkbox']")).size();
        try{
            for (int i=0;i<numOfRadio;i++){
                if (!driver.findElements(By.xpath("//input[@type='checkbox']")).get(index).isSelected()) {
                    driver.findElements(By.xpath("//input[@type='checkbox']")).get(index).click();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //    DROPDOWN
//    USE THIS ONE TO SELECT FROM A DROPDOWN
    public static void selectByVisibleText(WebElement element, String text){
        Select select =new Select(element);
        for (int i =0;i<select.getOptions().size();i++){
            if(select.getOptions().get(i).getText().equalsIgnoreCase(text)){
                select.getOptions().get(i).click();
                break;
            }
        }
    }

    public static void selectByIndex(WebElement element, int index){
        Select objSelect =new Select(element);
        objSelect.selectByIndex(index);
    }

    public static void selectByValue(WebElement element, String value) {
        Select objSelect = new Select(element);
        objSelect.selectByValue(value);
    }

    public static void selectDropdownByValue(WebElement element,String textOfDropdown){
        List<WebElement> options = element.findElements(By.tagName("option"));
        for (WebElement option : options){
            System.out.println(option.getText());
            if (option.getText().equals(textOfDropdown)){
                option.click();
                break;
            }
        }
    }
    //  DROPDOWN
    /**
     * Selects a random value from a dropdown list and returns the selected Web Element
     * @param select
     * @return
     */
    public static WebElement selectRandomTextFromDropdown(Select select) {
        Random random = new Random();
        List<WebElement> list = select.getOptions();
        int optionIndex = 1 + random.nextInt(list.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }

    //    DROPDOWN: accepts dropdown element and returns all selected element texts as an arraylist
    public ArrayList<String> getDropdownSelectedOptions(WebElement element) throws Exception {
        if (element!=null){
            Select list = new Select(element);
            ArrayList<WebElement> allSelectedOptions = (ArrayList<WebElement>) list.getAllSelectedOptions();
            ArrayList<String> result = new ArrayList<String>();
            for (WebElement eachSelected : allSelectedOptions){
                result.add(eachSelected.getText());
            }
            return result;
        }else {
            throw new Exception("No element is returned");
        }
    }

    //    VERIFY ELEMENT IS DISPLAYED
    /**
     * Verifies whether the element is displayed on page
     * fails if the element is not found or not displayed
     *
     * @param element
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            assertTrue("Element is not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found: " + element);
        }
    }

    /**
     * Verifies whether the element matching the provided locator is displayed on page
     * fails if the element matching the provided locator is not found or not displayed
     *
     * @param by
     */
    public static void verifyElementDisplayed(By by) {
        try {
            assertTrue("Element not visible: " + by, driver.findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + by);
        }
    }

    //VERIFY ELEMENT IS NOT DISPLAYED
    /**
     * Verifies whether the element matching the provided locator is NOT displayed on page
     * fails if the element matching the provided locator is not found or not displayed
     *
     * @param by
     */
    public static void verifyElementNotDisplayed(By by) {
        try {
            assertFalse("Element should not be visible: " + by, driver.findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
    /**
     * Verifies whether the element matching the provided WebElement is NOT displayed on page
     * fails if the element matching the WebElement is not found or not displayed
     * @paramWebElement
     */
    public static void verifyElementNotDisplayed(WebElement element) {
        try {
            assertFalse("Element should not be visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public static void verifyElementClickable(WebElement element) {
        try {
            assertTrue("Element not visible: " + element, element.isEnabled());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);

        }
    }
    public static void verifyElementNotClickable(WebElement element) {
        try {
            assertFalse("Element not visible: " + element, element.isEnabled());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    //    ALERT
    public void acceptAlert() throws InterruptedException {
        driver.switchTo().alert().accept();
    }
    public void dismissAlert() throws InterruptedException {
        driver.switchTo().alert().accept();
    }
    //    IFRAME
    public static void switchIframeByWebElement(String xpath){
        WebElement iframeElement = driver.findElement(By.xpath(xpath));
        driver.switchTo().frame(iframeElement);
    }
    //    IFRAME
    public static void switchIframeByIndex(int index){
        driver.switchTo().frame(index);
    }
    //    MULTIPLE WINDOW !!!
    public static void switchToWindowByTitle(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String childWindow : driver.getWindowHandles()) {
            driver.switchTo().window(childWindow);
            if (driver.getTitle().equals(targetTitle)) {
                System.out.println("Switched to the window : "+targetTitle);
                return;
            }
        }
        driver.switchTo().window(origin);
    }
    //    windowNumber starts at (0)
    public static void switchToWindow(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }
    //    ACTIONS_RIGHT CLICK
    public static void rightClickOnElementActions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
    //ACTIONS_DOUBLE CLICK
    public static void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }
    //    ACTIONS_HOVER_OVER
    public static void hoverOverOnElementActions(WebElement element) {
        //        Actions actions = new Actions(driver);
        new Actions(driver).moveToElement(element).perform();
    }
    //    ACTIONS_SCROLL_DOWN
    public static void scrollDownActions() {
        //        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }
    //    ACTIONS_SCROLL_UP
    public static void scrollUpActions() {
        //        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }
    //    ACTIONS_SCROLL_RIGHT
    public static void scrollRightActions(){
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }
    //    ACTIONS_SCROLL_LEFT
    public static void scrollLeftActions(){
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }
    //    ACTIONS_DRAG_AND_DROP
    public static void dragAndDropActions(WebElement source, WebElement target) {
        //        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDrop(source,target).perform();
    }
    //    ACTIONS_DRAG_AND_DROP_BY
    public static void dragAndDropActions(WebElement source, int x, int y) {
        //        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDropBy(source,x,y).perform();
    }
    //    Accept a URL and navigates to that page
    public static void openURL(String url){
        driver.get(url);
    }

    //    Java Faker
    public static Faker getFaker(){
        return new Faker();
    }



}
