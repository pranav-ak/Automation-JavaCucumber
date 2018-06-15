package org.pranav.cucumber.core.elements;

import org.openqa.selenium.WebElement;
import org.pranav.cucumber.core.BaseElement;

public class TextBox extends BaseElement {
	public TextBox(SelectBy byToUse, String locator) {
		setLocatorStr(locator);
		setSelectBy(byToUse);
	}

	public void inputText(String text) 
	{
		WebElement element = findElement();
		element.click();
		element.clear();
		element.sendKeys(text);
		return;
	}
}
