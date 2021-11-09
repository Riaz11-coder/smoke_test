package com.Vytrack.TestScripts;

import com.Vytrack.Pages.googlePage;
import com.Vytrack.base.Environment;
import com.Vytrack.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class google extends TestBase {

    googlePage gp = new googlePage();

   @Test
    @Environment(url = "url_19")
    public void testingPageTitle(){

       String actualPageTitle = driver.getTitle();
       System.out.println(actualPageTitle);
       String expectedPageTitle = "Google";
       System.out.println(expectedPageTitle);

       System.out.println(actualPageTitle.equals(expectedPageTitle));
       Assert.assertEquals(actualPageTitle,expectedPageTitle);
   }

    @Test
    @Environment(url = "url_19")
    public void testingLogo(){


       Assert.assertTrue(gp.GoogleLogo.isDisplayed());

    }

}
