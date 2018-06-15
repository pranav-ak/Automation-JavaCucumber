package org.pranav.cucumber.core.elements;

import org.openqa.selenium.WebElement;
import org.pranav.cucumber.core.BaseElement;



public class Button extends BaseElement {
	
	public Button(SelectBy selector, String locator) {
		setSelectBy(selector);
		setLocatorStr(locator);
	}
	public void click() {
		WebElement element = findElement();
		if(element!=null) {
			element.click();
		}
	}

}

