package org.pranav.cucumber.core.elements;

import org.openqa.selenium.WebElement;
import org.pranav.cucumber.core.BaseElement;



public class RadioButton extends BaseElement {
	
	public RadioButton(SelectBy byToUse, String locator) {
		setLocatorStr(locator);
		setSelectBy(byToUse);
	}
	
	public void select() {
		WebElement element = findElement();
		if(element!=null&&!isSelected()) {
			element.click();
		}
	}

}

