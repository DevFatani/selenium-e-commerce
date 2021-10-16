package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {

	ContactUsPage contactUsObject;

	String fullName = "Muhammad Fatani";
	String email = "fuck@shit.com";
	String enquiry = "your website is like shit";
	String productName = "Apple MacBook Pro 13-inch";

	
	HomePage homeObject;
	UserRegistrationPage registrationObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailObject;

	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registrationObject = new UserRegistrationPage(driver);
		registrationObject.userRegistration("Ah3mad", "Ali", (int)(Math.random()*10000) + "Shit@schaaait.com", "1234566");
		
		Assert.assertTrue(registrationObject.successMessage.getText().contains("Your registration completed"));
	}
	
	
	@Test(priority = 2)
	public void userCanSearchWithAutoSuggestion() {
		try {
			searchObject = new SearchPage(driver);
			searchObject.productSearchUsingAutoSuggestion("MacB");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.prodcutNamebreadCrumb.getText(), productName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	@Test(priority = 3)
	public void registerUserCanSendProductToFriend() {
		detailsObject.openSendEmail();
		emailObject = new EmailPage(driver);
		emailObject.sendEmailToFriend("aa@bb.com", "check this mother**");
		Assert.assertTrue(emailObject.successMessage.getText().contains("Your message has been sent."));
		
	}
	
	@Test(priority = 4)
	public void registeredUserCanLogout() {
		registrationObject.userLogout();
		
	}

}
	

