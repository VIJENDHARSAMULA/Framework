package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		
		}
	
	@FindBy(name="username") WebElement uName;
	@FindBy(name="password") WebElement pWord;
	@FindBy(xpath="//input[@value='Login']") WebElement loginBtn;
	
	public void loginToCRM(String appUserName,String appPassword) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		uName.sendKeys(appUserName);
		pWord.sendKeys(appPassword);
		loginBtn.click();
	}

}
