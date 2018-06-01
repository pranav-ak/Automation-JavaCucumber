package cf.core;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

@SuppressWarnings("unused")
public final class WebDriverFactory {
	
	private static WebDriver driver = null;
	
	public static WebDriver GetCurrentWebDriver() {
		if(driver== null)
		{
			 System.setProperty("webdriver.chrome.driver",
                     "C:\\Projects\\_paynetexchange\\NSpector\\Packages\\WebDriver.ChromeDriver.win32.2.24.0.0\\content\\chromedriver.exe");   
			driver = new ChromeDriver();
			
		}
		return driver;
		
	}

}
