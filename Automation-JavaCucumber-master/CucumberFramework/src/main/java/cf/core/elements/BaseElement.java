package cf.core.elements;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
	
	protected WebElement findElement() {
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
	
	public String getTextOfAttribute(String attribute) {
		WebElement element = findElement();
		String output = "";
		if(element!=null && !attribute.equals("") && attribute!=null) {
			output = element.getAttribute(attribute);
		}
		return output;			
	}
	
	public String getInnerText() {
		WebElement element = findElement();
		String output = "";
		if(element!=null) {
			output = element.getText();
		}
		return output;
	}
	
	public boolean containsInnerText(String expectedText) {
		WebElement element = findElement();
		boolean result = false;
		int staleAttempts=0;
		// Need to implement stale state handling
		if(element!=null) {
			result = element.getText().contains(expectedText);
		}
		
		return result;
	}
	public boolean validateInnerText(String expectedText) {
		WebElement element = findElement();
		boolean result = false;
		int staleAttempts=0;
		// Need to implement stale state handling
		if(element!=null) {
			 result = element.getText().equals(expectedText);
		}
		return result;
	}
	
	public boolean validateAttributeText(String attribute, String expectedText) {
		WebElement element = findElement();
		boolean result = false;
		int staleAttempts=0;
		// Need to implement stale state handling
		if(element!=null) {
			result = element.getAttribute(attribute).equals(expectedText);
		}
		return result;		
	}
	
	public boolean validateAttributeTextContains(String attribute, String expectedText) {
		WebElement element = findElement();
		boolean result = false;
		int staleAttempts=0;
		// Need to implement stale state handling
		if(element!=null) {
			result = element.getAttribute(attribute).contains(expectedText);
		}
		return result;		
	}
	
	public boolean isDisplayed() {
			WebElement element = findElement();
			boolean result = false;
			int staleAttempts=0;
			// Need to implement stale state handling
			if(element!=null) {
				//Need to implement additional check to make validation more robust.
				result = element.isDisplayed();
			}
			return result;		
		}
	
	public boolean isEnabled() {
		WebElement element = findElement();
		boolean result = false;
		int staleAttempts=0;
		// Need to implement stale state handling
		if(element!=null) {
			//Need to implement additional check to make validation more robust.
			result = element.isEnabled();
		}
		return result;		
	}
	
	public boolean isFocused() {
		WebElement element = findElement();
		boolean result = false;
		
		if(element!=null) {
			WebElement activeElement = WebDriverFactory.GetCurrentWebDriver().switchTo().activeElement();
			result = element.equals(activeElement);
		}
		return result;
	}
	
	public boolean isSelected() {
		WebElement element = findElement();
		boolean result = false;
		if(element!=null) {
			result = element.isSelected();
		}
		return result;
	}
	
	public String getElementId() {
		WebElement element = findElement();
		String id = "";
		if(element!=null) {
		id = element.getAttribute("id");
		}
		return id;
	}
}
