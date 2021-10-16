package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	@FindBy(id="FullName")
	WebElement fullNameTxt;

	@FindBy(id="Email")
	WebElement emailTxt;

	@FindBy(id="Enquiry")
	WebElement enquiryTxt;

	@FindBy(css="button.button-1.contact-us-button")
	WebElement btnSubmit;

	@FindBy(css="div.result")
	public WebElement successMessage;

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}


	public void contactUs(String fullName, String email, String enquiry) {
		setTextElementText(fullNameTxt, fullName);
		setTextElementText(emailTxt, email);
		setTextElementText(enquiryTxt, enquiry);
		clickButton(btnSubmit);
	}

	public void openLoginPage() {
		//		clickButton(loginLink);
	}

}
