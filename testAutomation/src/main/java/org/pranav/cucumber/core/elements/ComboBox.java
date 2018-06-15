package org.pranav.cucumber.core.elements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.pranav.cucumber.core.BaseElement;

public class ComboBox extends BaseElement {
	
	public ComboBox(SelectBy byToUse, String locator) {
		setLocatorStr(locator);
		setSelectBy(byToUse);
	}
	
	public void selectByText(String textToSelect) {
		Select combo = new Select(findElement());
		if(combo!=null) {
			combo.deselectAll();
			combo.selectByVisibleText(textToSelect);
		}
	}
	
	public void selectByIndex(int index) {
		Select combo = new Select(findElement());
		if(combo!=null) {
			combo.deselectAll();
			combo.selectByIndex(index);			
		}
	}
	
	public String getSelectedOption() {
		Select combo = new Select(findElement());
		String selectedOption="";
		if(combo!=null) {
		selectedOption=combo.getFirstSelectedOption().getText();
		}
		return selectedOption;
	}
	
	public String getAttributeTextOfSelectedOption(String attribute) {
		Select combo = new Select(findElement());
		String selectedOption="";
		if(combo!=null) {
			selectedOption=combo.getFirstSelectedOption().getAttribute(attribute);
			}
		return selectedOption;
	}
	
	public int getCount() {
		int count=0;
		Select combo = new Select(findElement());
		if(combo!=null) {
			count = combo.getOptions().size();
		}
		return count;
	}
	
	public boolean containsOption(String optionText) {
		boolean result = false;
		Select combo = new Select(findElement());
		if(combo!=null) {
			List<WebElement> options = combo.getOptions();
			for(WebElement el : options) {
				if(el.getText().equals(optionText)) {
					result=true;
				}
			}
		}
		return result;
	}
	
}