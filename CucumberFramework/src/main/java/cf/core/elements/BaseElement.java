package cf.core.elements;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cf.core.Constants;
import cf.core.WebDriverFactory;

public abstract class BaseElement {

	public enum SelectBy {ClassName, CssSelector, Id, Xpath, Name, TagName};
	private SelectBy sourceBy;
	private String locatorStr;
	
	protected SelectBy getSelectBy() {
		return sourceBy;
	}
	protected void setSelectBy(SelectBy selectBy) {
		this.sourceBy = selectBy;
	}
	protected String getLocatorStr() {
		return locatorStr;
	}
	protected void setLocatorStr(String locatorStr) {
		this.locatorStr = locatorStr;
	}
	
	protected WebElement FindElement() {
		double counter = 0;
		WebElement element = null;
		if(locatorStr != null && WebDriverFactory.GetCurrentWebDriver()!=null) {
			while (element == null && counter < Constants.DefaultFindElementTimeOut) {
				try {
					switch (sourceBy) {
					
					case CssSelector :
						element = WebDriverFactory.GetCurrentWebDriver().findElement(By.cssSelector(locatorStr));
						break;
						
					case ClassName :
						element = WebDriverFactory.GetCurrentWebDriver().findElement(By.className(locatorStr));
						break;
						
					case Id :
						element = WebDriverFactory.GetCurrentWebDriver().findElement(By.id(locatorStr));
						break;
						
					case Xpath:
						element = WebDriverFactory.GetCurrentWebDriver().findElement(By.id(locatorStr));
						break;
						
					case Name:
						element = WebDriverFactory.GetCurrentWebDriver().findElement(By.name(locatorStr));
						break;
						
					case TagName:
						element = WebDriverFactory.GetCurrentWebDriver().findElement(By.tagName(locatorStr));
						
					default:
						break;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return element;
	}
	
	
	
}
