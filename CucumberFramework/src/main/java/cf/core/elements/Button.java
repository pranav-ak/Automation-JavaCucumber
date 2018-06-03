package cf.core.elements;

import org.openqa.selenium.WebElement;

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
