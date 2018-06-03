package cf.core.elements;

public class Label extends BaseElement {

	public Label(SelectBy byToUse, String locator) {
		setLocatorStr(locator);
		setSelectBy(byToUse);
	}
	
}
