package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {


	@FindBy(linkText="Change password")
	WebElement changePasswordLink;

	@FindBy(id="OldPassword")
	WebElement oldPasswordTxt;

	@FindBy(id="NewPassword")
	WebElement newPasswordTxt;

	@FindBy(id="ConfirmNewPassword")
	WebElement confirmPasswordTxt;

	@FindBy(linkText="Change password")
	WebElement changePasswordBtn;

	@FindBy(css="div.result")
	public WebElement resultLbl;



	public MyAccountPage(WebDriver driver) {
		super(driver);
	}


	public void changePassword( String oldPassword, String newPassword) {
		setTextElementText(oldPasswordTxt, oldPassword);
		setTextElementText(newPasswordTxt, newPassword);
		setTextElementText(confirmPasswordTxt, newPassword);
		clickButton(changePasswordBtn);
	}

	public void openChangePasswordPage() {
		clickButton(changePasswordLink);		
	}


}
