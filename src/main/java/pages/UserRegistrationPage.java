package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {


	@FindBy(id="gender-male")
	WebElement genderRdoBtn;

	@FindBy(id="FirstName")
	WebElement fnTxtBox;

	@FindBy(id="LastName")
	WebElement lnTxtBox;

	@FindBy(id="Email")
	WebElement emailTxtBox;

	@FindBy(id="Password")
	WebElement passwordTxtBox;

	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTxtBox;

	@FindBy(id="register-button")
	WebElement registerBtn;
	
	@FindBy(css ="div.result")
	public WebElement successMessage;
	
	@FindBy(linkText="Log out")
	public WebElement logoutLink;
	
	@FindBy(linkText="My account")
	 WebElement myAccountLink;

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}


	public void userRegistration(String fName, String lName, String email, String password) {
		clickButton(genderRdoBtn);
		setTextElementText(fnTxtBox, fName);
		setTextElementText(lnTxtBox,lName);
		setTextElementText(emailTxtBox,email);
		setTextElementText(passwordTxtBox,password);
		setTextElementText(confirmPasswordTxtBox,password);
		clickButton(registerBtn);
	}
	
	public void userLogout() {
		clickButton(logoutLink);
	}

	
	public void openMyAccountPage() {
		clickButton(myAccountLink);
	}

}
