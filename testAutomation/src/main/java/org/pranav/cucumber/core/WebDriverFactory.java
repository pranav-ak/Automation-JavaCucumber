package org.pranav.cucumber.core;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.reflections.Reflections;

@SuppressWarnings("unused")
public final class WebDriverFactory {
	
	private static WebDriver driver = null;
	private static boolean pageTrackerInit = false;
	private static String packageName="org.pranav.cucumber.testAutomation.pages.";
	
	public static WebDriver GetCurrentWebDriver() {
		if(driver== null)
		{
			 System.setProperty("webdriver.chrome.driver",
                     "C:\\Projects\\_paynetexchange\\NSpector\\Packages\\WebDriver.ChromeDriver.win32.2.24.0.0\\content\\chromedriver.exe");   
			driver = new ChromeDriver();
			
		}
		return driver;
		
	}
	
	public static String getCurrentPageObject() throws ClassNotFoundException
	{
		String currentURL = GetCurrentWebDriver().getCurrentUrl().toLowerCase();
		if(currentURL.contains(".aspx"))
		{
			currentURL=currentURL.substring(0,currentURL.indexOf(".aspx")+5);
		}
		
		if(!pageTrackerInit)
		{
			String pageObjectPackage = "org.pranav.cucumber.core.";
			Class<?> page= Class.forName(pageObjectPackage+"BasePage");
			
			Reflections reflections = new Reflections(packageName);
			Set<Class<? extends BasePage>> pages= reflections.getSubTypesOf(BasePage.class);
			for(Class<?> c : pages)
			{
				try 
				{
					Constructor<?> constructor = c.getConstructor(null);
					Object pageInstance = constructor.newInstance(null);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
				pageTrackerInit=true;
			}
		}
		
		if(Constants.Page_Object_URLs.containsKey(currentURL))
		{
			return Constants.Page_Object_URLs.get(currentURL);
		}
		return "";
	}
	
	public static void addpageObjects(String url, String pageObject) 
	{
		if(!Constants.Page_Object_URLs.containsKey(PropertyHelper.getProperty("BaseUrl")+url)) 
		{
			Constants.Page_Object_URLs.putIfAbsent(PropertyHelper.getProperty("BaseUrl")+url, pageObject.substring(0,pageObject.indexOf('@')));
			
		}
	}

	private List<String> getAllPageObjects()
	{
	    String path = packageName.replaceAll("\\.", File.separator);
	    List<Class<?>> classes = new ArrayList<>();
	    String[] classPathEntries = System.getProperty("java.class.path").split(
	            System.getProperty("path.separator")
	            );
	    return null;
		
	}
}

