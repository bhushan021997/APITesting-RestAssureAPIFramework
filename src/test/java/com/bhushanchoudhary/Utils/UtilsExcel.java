package com.bhushanchoudhary.Utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;



public class UtilsExcel {
//Open File Stram
//Understand the Workbook
//Sheet
//Row
//Cell (Column)
//Close the Stream

    public static String FILE_NAME = "src/test/resources/TD.xlsx";
    static Workbook book;
    static Sheet sheet;


    public static Object[][] getTestData(String Sheetname){
        FileInputStream fileInuputStream=null;

        try {
            fileInuputStream = new FileInputStream(FILE_NAME);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
        book = WorkbookFactory.create(fileInuputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sheet=book.getSheet(Sheetname);

        Object [][] data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i=0; i< sheet.getLastRowNum(); i++)
        {
            for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++)
            {
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();

            }
        }



        return data;
    }




    @DataProvider
    public Object[][] getData() {

     return getTestData("Sheet1");
    }


}



