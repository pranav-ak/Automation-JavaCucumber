package cf.automation;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;

import cf.core.WebDriverFactory;



public class Stepdefs {
	
	@Given("^user is on github homepage$")
	public void user_is_on_github_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriver driver = WebDriverFactory.GetCurrentWebDriver();
		driver.get("https://www.google.com");
	}
	
	@Then("^user waits for ten secs$")
	public void user_waits() throws InterruptedException {
		
		Thread.sleep(10000);	
	}
	
	
	

}