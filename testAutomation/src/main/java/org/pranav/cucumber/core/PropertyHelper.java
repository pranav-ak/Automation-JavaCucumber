package org.pranav.cucumber.core;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyHelper {

	private static String propertyFile = "./AppSettings.Properties";
	
	public static String getProperty(String propertyname) 
	{
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(propertyFile));
		} catch (Exception e) {
			System.out.println(e);
		}
		return prop.getProperty(propertyname);
		
	}
	
	public static void SetProperty(String propertyName, String propertyValue) 
	{
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(propertyFile));
		} catch (Exception e) {
			// File Not Found
		}
		
		prop.setProperty(propertyName, propertyValue);
	}
}
