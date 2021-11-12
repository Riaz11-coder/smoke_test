package com.Vytrack.TestScripts;

import com.Vytrack.Pages.dataTablesPage;
import com.Vytrack.Utilities.BrowserUtils;
import com.Vytrack.Utilities.ConfigurationReader;
import com.Vytrack.Utilities.ExcelUtil;
import com.Vytrack.base.Environment;
import com.Vytrack.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class dataTables extends TestBase {

    dataTablesPage dt = new dataTablesPage();
    ExcelUtil excelData = new ExcelUtil(ConfigurationReader.getProperty("excelfile"),"sheet1");
    @Test
    @Environment(url = "url_16")
    public void testDataTablesCell(){

        String expected = excelData.getCellData(1,0);
        System.out.println(expected);

        String actual = dt.rowOneCellOne.getText();
        System.out.println(actual);

        Assert.assertEquals(actual,expected);
        System.out.println(actual.equals(expected));

    }

    @Test
    @Environment(url = "url_16")
    public void testDataTablesRow(){

        WebElement table = driver.findElement(By.cssSelector("table[id='table1']"));

        List<WebElement> tableData = table.findElements(By.tagName("th"));

        List<String> actual = BrowserUtils.getElementsText(tableData);
        System.out.println("Data from Excel File: "+actual);
        List<String> expected = excelData.getColumnsNames();
        System.out.println("Data from Table UI (Environment): "+expected);
        System.out.println("Data Tables from UI / Excel File displaying same info = "+actual.equals(expected));

        Assert.assertEquals(actual,expected);

    }

    @Test
    @Environment(url = "url_16")
    public void testDataTablesRowAndColumns(){

        WebElement table = driver.findElement(By.cssSelector("table[id='table1']"));

        List<WebElement> tableData = table.findElements(By.tagName("tr"));
        List<WebElement> Data = new ArrayList<>();
        for(WebElement row : tableData){
            List<WebElement> cellData = row.findElements(By.tagName("td"));

            for (WebElement cell:cellData) {
                System.out.println(cell.getText());
                Data.add(cell);
            }

        }

        List<String> expectedData = excelData.getAllData();
        System.out.println(expectedData);

        List<String> actualData = BrowserUtils.getElementsText(Data);
        System.out.println(actualData);

        Assert.assertEquals(actualData,expectedData);

        System.out.println(actualData.equals(expectedData));





    }
}
