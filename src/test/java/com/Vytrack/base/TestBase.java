package com.Vytrack.base;


import com.Vytrack.Utilities.ConfigurationReader;
import com.Vytrack.Utilities.Driver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBase implements Environment {

    public WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeSuite
    public void beforeTestMethod(){
        htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ File.separator + "reports"+ File.separator + "AutomationReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "AutoBot");


    }




    @BeforeMethod
    public void setUpMethod(ITestResult testResult, Method testMethod){
        String url = "url";

        Environment env = testResult.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(Environment.class);
        if (env != null) {
            url = env.url();
        }
        System.err.println(testResult.getMethod().getQualifiedName() + "() will use the URL : " + url);



        logger = extent.createTest(testMethod.getName());
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);

        driver.get(ConfigurationReader.getProperty(url));

    }

    @AfterMethod
    public void afterTestMethod( ITestResult result){
        if(result.getStatus()==ITestResult.SUCCESS){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Passed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS,m);
        }
        else if(result.getStatus()==ITestResult.FAILURE){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Failed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL,m);
        }
        else if(result.getStatus()==ITestResult.SKIP){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Skipped";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
            logger.log(Status.SKIP,m);
        }
    }


    @AfterSuite
    public void tearDown() throws InterruptedException {

        extent.flush();
        Driver.closeDriver();

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



