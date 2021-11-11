package com.Vytrack.TestScripts;

import com.Vytrack.Pages.googlePage;
import com.Vytrack.base.Environment;
import com.Vytrack.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class google extends TestBase {

    googlePage gp = new googlePage();

   @Test(priority = 1)
    @Environment(url = "url_19")
    public void testingPageTitle(){

       String actualPageTitle = driver.getTitle();
       System.out.println(actualPageTitle);
       String expectedPageTitle = "Google";
       System.out.println(expectedPageTitle);

       System.out.println(actualPageTitle.equals(expectedPageTitle));
       Assert.assertEquals(actualPageTitle,expectedPageTitle);
   }

    @Test(priority = 0 )
    @Environment(url = "url_19")
    public void testingLogo(){

        TestBase.logger.info("Validating presence of Google Logo on Google Home Page");
        Assert.assertTrue(gp.GoogleLogo.isDisplayed());

    }


}
