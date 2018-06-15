package org.pranav.cucumber.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;	

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
	
	public enum SelectBy {ClassName, CssSelector, Id, Xpath, Name, TagName};
	protected String PageTitle = "";
	protected String PageUrl="";
	protected String XpathValidator="";
	protected String BaseUrl = "";
	
	public void open(Boolean expectToOpen, String urlParams ) {
		if(urlParams==null)
			urlParams="";

		BaseUrl = PropertyHelper.getProperty("BaseUrl");
		WebDriverFactory.GetCurrentWebDriver().navigate().to(BaseUrl+PageUrl+urlParams);
		
	}
	
	public Boolean isOpen() {

		double timeout = Constants.DefaultPageLoadTimeOut;
		double timer=0;
		WebDriver driver = WebDriverFactory.GetCurrentWebDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		while (timer<=timeout) {
			  if (js.executeScript("return document.readyState;").equals("complete")) {
				  
				  try {
					  if(WebDriverFactory.GetCurrentWebDriver().findElement(By.xpath(XpathValidator))!=null) {
						  if(WebDriverFactory.GetCurrentWebDriver().getCurrentUrl().contains(PageUrl)) {
							  return true;
							  
						  }
					  }
					  
				  }catch(Exception e) {
					  
					  return false;
				  }
			  }
              timer+=0.1;
              try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public String getPageSource() {
		String PageSource ="";
		if(isOpen()) {
			PageSource=WebDriverFactory.GetCurrentWebDriver().getPageSource();
			
		}
		return PageSource;
	}
	
	public abstract void navigateTo(String username, String password) 	;

}
