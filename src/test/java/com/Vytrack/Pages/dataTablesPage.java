package com.Vytrack.Pages;

import com.Vytrack.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dataTablesPage {

    public dataTablesPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"table1\"]/tbody/tr[1]/td[1]")
    public WebElement rowOneCellOne;

    @FindBy(xpath = "//*[@id=\"table1\"]/tbody/tr[1]/td[2]")
    public WebElement rowOneCellTwo;

    @FindBy(xpath = "//*[@id=\"table1\"]/tbody/tr[1]/td[3]")
    public WebElement rowOneCellThree;

    @FindBy(xpath = "//*[@id=\"table1\"]/tbody/tr[1]/td[4]")
    public WebElement rowOneCellFour;

    @FindBy(xpath = "//*[@id=\"table1\"]/tbody/tr[1]/td[5]")
    public WebElement rowOneCellFive;

    @FindBy(xpath = "//*[@id=\"table1\"]/tbody/tr[2]/td[1]")
    public WebElement rowTwoCellOne;

    @FindBy(xpath = "//*[@id=\"table1\"]/tbody/tr[2]/td[2]")
    public WebElement rowTwoCellTwo;

    @FindBy(xpath = "//*[@id=\"table1\"]/tbody/tr[2]/td[3]")
    public WebElement rowTwoCellThree;

    @FindBy(xpath = "//*[@id=\"table1\"]/tbody/tr[2]/td[4]")
    public WebElement rowTwoCellFour;

    @FindBy(xpath = "//*[@id=\"table1\"]/tbody/tr[2]/td[5]")
    public WebElement rowTwoCellFive;
}
