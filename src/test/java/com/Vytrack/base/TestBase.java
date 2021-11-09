package com.Vytrack.base;


import com.Vytrack.Utilities.ConfigurationReader;
import com.Vytrack.Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

public class TestBase implements Environment{

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected String url;



    @BeforeMethod
    public void setUpMethod(ITestResult testResult){
        String url = "url";

        Environment env = testResult.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(Environment.class);
        if (env != null) {
            url = env.url();
        }
        System.err.println(testResult.getMethod().getQualifiedName() + "() will use the URL : " + url);




        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);

        driver.get(ConfigurationReader.getProperty(url));

    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }


    @Override
    public String url() {
        return null;
    }



    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}



