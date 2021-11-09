package com.Vytrack.Pages;

import com.Vytrack.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class googlePage {

    public googlePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css="div[id='logo']")
    public WebElement GoogleLogo;
}
