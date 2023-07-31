package com.myfirstproject;

import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Day08_FileExistTest {
    @Test
    public void isExistTest(){
//        Class: FileExistTest
//        Method: isExist
//        Pick a file on your desktop
        //1. write the path of your file
        //terminal CMD
        //     /Users/techproed/Desktop/image.jpeg
        //     /Users/techproed   = user.home
        String pathOfImage = System.getProperty("user.home")+"/Desktop/image_360.jpg";
        System.out.println(pathOfImage);
//        And verify if that file exists on your computer or not
        boolean isImageExist = Files.exists(Paths.get(pathOfImage));
        Assert.assertTrue(isImageExist);
    }
}
