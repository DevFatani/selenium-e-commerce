package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	
	protected WebDriver driver;
	public JavascriptExecutor executor;
	public Select select;
	public Actions action;
	
	public PageBase(WebDriver driver){
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}
	
	protected static void clickButton(WebElement button) {
		button.click();
	}
	
	protected static void setTextElementText(WebElement element, String text) {
		element.sendKeys(text);
	}

	protected void scrollToBottom() {
	  executor.executeScript("scrollBy(0,2500)");
	}
	
	protected static void clearText(WebElement element) {
		element.clear();
	}

}
