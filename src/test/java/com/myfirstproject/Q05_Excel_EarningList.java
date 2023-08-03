package com.myfirstproject;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Q05_Excel_EarningList {
   /*
Given
    Save EarningList.xlsx file into your project
When
    In the row column, write the row numbers according to the earnings amount(Natural Order).
Then
    Assert that row number of Wednesday is 1
 */
    @Test
    public void exel_EarningList(){
        FileInputStream fileInputStream= new FileInputStream(("EarningList.xlsx"));
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet=workbook.getSheet("Sheet1");
        List<Double> earningList= new ArrayList<>();

        for (int i=0;i<=sheet.getLastRowNum();i++){
        earningList.add()


            List<Double> earningListSorted= new ArrayList<>(earningList);
        }
    }
}
