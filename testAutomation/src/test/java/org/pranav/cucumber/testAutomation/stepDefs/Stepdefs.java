package org.pranav.cucumber.testAutomation.stepDefs;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.openqa.selenium.WebDriver;
import org.pranav.cucumber.core.WebDriverFactory;





@SuppressWarnings("unused")
public class Stepdefs {
	
	@Given("^user is on homepage$")
	public void user_is_on_github_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriver driver = WebDriverFactory.GetCurrentWebDriver();
		driver.get("https://www.google.com");
	}
	
	@When("^user waits for '(.*)' secs$")
	public void user_waits(int secs) throws InterruptedException, ClassNotFoundException {
		
		Thread.sleep((secs*1000));
		this.invokeElementMethod("ProceedButton", "click", null);
	}
	
	@When("^user clicks '(.*)'$")
	public void user_clicks(String element)
	{
		this.invokeElementMethod(element, "click", null);		
	}
	
	@Then("^validate '(.*)' is the inner text of '(.*)'$")
	public void validate_innertext_of(String expectedText, String element)
	{
		Object[] parameters = {expectedText.toString()};
		boolean result = (boolean)invokeElementMethod(element, "validateInnerText", parameters); 
	}
	
	public Object invokeElementMethod(String elementName, String methodName, Object[] parameters) 
	{
		String pageObjectPackage = "org.pranav.cucumber.testAutomation.pages.";
		Type[] abc=null;
		try 
		{
			String currentPageObject = WebDriverFactory.getCurrentPageObject();
			if(currentPageObject.isEmpty())
			{
				//throw error
			}
			Class<?> page= Class.forName(currentPageObject);
			Constructor<?> constructor = page.getConstructor(null);
			Object pageInstance = constructor.newInstance(null);
			Method[] method = pageInstance.getClass().getMethods();
			Method pageElementMethod = null;
			for(Method m :method) 
			{
				if(m.getName().equals(elementName)) 
				{
					pageElementMethod=m;
					break;
				}
			}
		Object elementObject = pageElementMethod.invoke(pageInstance, null);
		Method[] elementMethod = elementObject.getClass().getMethods();
		Type[] pTypes= {};
		if(parameters!=null)
		{
			pTypes = new Type[parameters.length] ;
			for (int i =0; i<parameters.length;i++)
			{
				pTypes[i] = parameters[i].getClass();
				
			}
		}
		
		Method elementObjectMethod = null;
		for(Method m :elementMethod) 
		{
			Type[] genericTypes = m.getParameterTypes();
			if(m.getName().equals(methodName)&& genericTypes.length==pTypes.length) 
			{
				elementObjectMethod=m;
				break;
			}
		}
		 Object result = elementObjectMethod.invoke(elementObject, parameters);
		return result;
		
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Given("^user is on '(.*)'$")
	public void user_is_on(String pageObjectName) 
	{
		try {
		String pageObjectPackage = "org.pranav.cucumber.testAutomation.pages.";
		Class<?> page= Class.forName(pageObjectPackage+pageObjectName);
		Constructor<?> constructor = page.getConstructor(null);
		Object pageInstance = constructor.newInstance(null);
		Method[] method = pageInstance.getClass().getMethods();
				//.getMethod("open", null);
		Method m1 = null;
		for(Method m :method) 
		{
			if(m.getName().equals("open")) 
			{
				m1=m;
				break;
			}
		}
		Object returnType = m1.invoke(pageInstance, true,null);
				
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
	

}