package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setup is  being done and test case is getting ready",true);

		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();

		try {
			ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html"));

			report = new ExtentReports();

			report.attachReporter(extent);
		} catch (Exception e) {
			
			System.out.println("Not able to find the path" + e.getMessage());
		}
		Reporter.log("Setup is  done and test case is ready",true);
	}

	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) {
		Reporter.log("broser setup and application url is getting ready",true);
		driver = BrowserFactory.startApplication(driver,browser, config.getQaUrl());
		Reporter.log("browser Setup is done and application is running",true);
	}

	@AfterClass
	public void tearDown() {
		Reporter.log("test case completed and browser is about to quit",true);
		BrowserFactory.quitApplication(driver);
		Reporter.log("browser closed successfully",true);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) {

		
		Reporter.log("Test case is executed successfully and about to capture screenshot",true);
		
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				logger.fail("Test failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			try {
				logger.pass("Test passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		report.flush();
		Reporter.log("Test case executed and screenshot captured",true);
	}

}
