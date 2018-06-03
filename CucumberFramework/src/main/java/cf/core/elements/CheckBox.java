package cf.core.elements;

import org.openqa.selenium.WebElement;

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
