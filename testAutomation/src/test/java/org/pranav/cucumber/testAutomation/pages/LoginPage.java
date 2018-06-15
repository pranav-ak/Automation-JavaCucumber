package org.pranav.cucumber.testAutomation.pages;

import org.pranav.cucumber.core.BasePage;
import org.pranav.cucumber.core.*;
import org.pranav.cucumber.core.elements.*;

public class LoginPage extends BasePage {
	 public LoginPage() {
			  PageTitle = "";
			  PageUrl="login.aspx";
			  XpathValidator="//*[@id='txtUsername']";
			  WebDriverFactory.addpageObjects(PageUrl, this.toString());
	}
	 private TextBox usernameField = null;
	 private TextBox passwordField = null;
	 private Button proceedButton = null;

	 public TextBox UsernameField() 
	 {
		 return this.usernameField = new TextBox(BaseElement.SelectBy.Id, "txtUsername");
	 }
	 public TextBox PasswordField() 
	 {
		 return this.passwordField = new TextBox(BaseElement.SelectBy.Id, "txtPassword");
	 }
	 public Button ProceedButton() 
	 {
		 return this.proceedButton = new Button(BaseElement.SelectBy.Id, "CustomImageButtonControl1");
	 }
	 
	 
	@Override
	public void navigateTo(String username, String password) {
		username=Constants.Default_Username;
		password=Constants.Defualt_Password;
		if(!this.isOpen()) 
		{
			this.open(true, null);
		}
		
	}

}

