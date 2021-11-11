package com.Vytrack.TestScripts;

import com.Vytrack.Pages.googlePage;
import com.Vytrack.base.Environment;
import com.Vytrack.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class google2 extends TestBase {


    googlePage gp = new googlePage();


    @Test
    @Environment(url = "url_19")
    public void testingLogo(){


        Assert.assertFalse(gp.GoogleLogo.isDisplayed());

    }
}
