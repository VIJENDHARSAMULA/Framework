package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties prop;
	
	public ConfigDataProvider() {
		
		File file = new File("./Config/Config.properties");
		try {
			FileInputStream fis= new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			
			System.out.println("Not able to read>>"+e.getMessage());
		} 
	}
	
	public String getDataFromConfig(String keyToSearch) {
		
		return prop.getProperty(keyToSearch);
	}
	
	
	public String getBrowser() {
		
		return prop.getProperty("browser");
	}
	
	
	public String getQaUrl() {
		
		return prop.getProperty("qaUrl");
	}
	
}
