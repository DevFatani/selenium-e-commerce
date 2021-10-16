package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	@FindBy(linkText="Register")
	WebElement registerLink;
	
	@FindBy(linkText="Log in")
	WebElement loginLink;
	
	
	@FindBy(linkText="Contact us")
	WebElement contactUsLink;
	
	@FindBy(id="customerCurrency")
	WebElement currencyDropDown;
	
	@FindBy(linkText = "Computers" )
	WebElement computerMenu;
	

	@FindBy(linkText="Notebooks")
	WebElement notebooksMenu;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		executor = (JavascriptExecutor) driver;
	}
	

	public void openRegistrationPage() {
		clickButton(registerLink);
	}
	
	public void openLoginPage() {
		clickButton(loginLink);
	}
	
	public void openContactUsPage() {
		scrollToBottom();
		clickButton(contactUsLink);
	}

	public void changeCurrency() {
		select = new Select(currencyDropDown);
		select.selectByVisibleText("Euro");
		
	}
	
	public void selectNotebooksMenu() {
		action
		.moveToElement(computerMenu)
		.click()
		.build()
		.perform();

		action.moveToElement(notebooksMenu)
		.click()
		.build()
		.perform();
	}

}
