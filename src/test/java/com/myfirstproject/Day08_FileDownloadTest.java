package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Day08_FileDownloadTest extends TestBase {
    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("test1.txt")).click();
        Thread.sleep(3000);//waiting for the file download
        //download files goes to Download folder. So path include  /Downloads/testFile.txt
      //  String filePath = System.getProperty("user.home")+"/Downloads/testFile.txt";//MAC
        String filePath = System.getProperty("user.home")+"\\Download\\test1.txt";//WINDOWS
        boolean isFileDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isFileDownloaded);
    }
}