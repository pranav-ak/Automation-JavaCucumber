package org.pranav.cucumber.core.elements;

import org.pranav.cucumber.core.BaseElement;

public class Label extends BaseElement {

	public Label(SelectBy byToUse, String locator) {
		setLocatorStr(locator);
		setSelectBy(byToUse);
	}
	
}
