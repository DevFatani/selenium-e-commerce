package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {


	@FindBy(id="Email")
	WebElement emailTxtBox;

	@FindBy(id="Password")
	WebElement passwordTxtBox;

	@FindBy(css = "button.button-1.login-button")
	WebElement loginBtn;

	//	@FindBy(css ="div.result")
	//	public WebElement successMessage;

	public LoginPage(WebDriver driver) {
		super(driver);
	}


	public void userlogin(String email, String password) {
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		clickButton(loginBtn);
	}

}
