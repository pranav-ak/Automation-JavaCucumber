package org.pranav.cucumber.core.elements;

import org.openqa.selenium.WebElement;
import org.pranav.cucumber.core.BaseElement;


public class CheckBox extends BaseElement {
	
	public CheckBox(SelectBy byToUse, String locator) {
		setLocatorStr(locator);
		setSelectBy(byToUse);
	}

	
	public void check() {
		WebElement element = findElement();
		if(element!=null&&!isSelected()) {
			element.click();
		}
	}
	
	public void unCheck() {
		WebElement element = findElement();
		if(element!=null&&isSelected()) {
			element.click();
		}
	}
	
}
