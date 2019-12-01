package com.interview.eBayAuto;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.interview.eBay.Config.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;


public class BaseClass {
    public AppiumDriver driver;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;
    @BeforeClass
    public void setup(){
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Report/eBayTestReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", "Android");
        extent.setSystemInfo("Host Name", "Gayathri");
        extent.setSystemInfo("Environment", "Prod");
        extent.setSystemInfo("User Name", "Gayathri Bolineni");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
        htmlReporter.config().setReportName("eBay Test Report");
        try {
            driver= DriverManager.getDriver();
        }catch (IOException e){
            System.out.print("Unhandled Exception"+e.getMessage());
        }
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
        extent.flush();
    }


}
