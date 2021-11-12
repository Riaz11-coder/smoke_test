package com.Vytrack.TestScripts;

import com.Vytrack.Utilities.ConfigurationReader;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ExcelIO {

    @Test
    public void readDataFromExcel() throws IOException {
        String path = ConfigurationReader.getProperty("excelfile");

        Workbook workBook = WorkbookFactory.create(new File(path));

        Sheet sheet = workBook.getSheet("Sheet1");
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);

        //System.out.println(cell.getStringCellValue());
        int lastRow = sheet.getLastRowNum();

        for(int i =0;i<=lastRow;i++){

            int lastColumn = sheet.getRow(i).getLastCellNum()-1;
            System.out.print(sheet.getRow(i).getCell(0));
            System.out.print(" "+sheet.getRow(i).getCell(1));
            System.out.print(" "+sheet.getRow(i).getCell(2));
            System.out.print(" "+sheet.getRow(i).getCell(3));
            System.out.print(" "+sheet.getRow(i).getCell(lastColumn));
            System.out.println();
        }


    }
}
