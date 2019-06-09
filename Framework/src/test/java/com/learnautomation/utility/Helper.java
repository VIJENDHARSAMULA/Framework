package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//screenshots,handle alerts,handle frames, handle windows, sync issue,java script executor etc
	
	public static String captureScreenshot(WebDriver driver) {
		
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/FreeCRM_" + getCurrentDateTime() + ".png";
		
		File capturedImg = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(capturedImg, new File(screenshotPath));
			System.out.println("ScreenShot is Captured");
		} catch (Exception e) {
		System.out.println("Not able to capture the screen shot>>"+ e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
		
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
		
	}

}
