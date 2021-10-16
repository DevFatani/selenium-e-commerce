package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {

	HomePage homeObject;
	ContactUsPage contactUsObject;

	String fullName = "Muhammad Fatani";
	String email = "fuck@shit.com";
	String enquiry = "your website is like shit";

	
	@Test
	public void userCanUserContactUs() {
		homeObject = new HomePage(driver);
		homeObject.openContactUsPage();
		
		contactUsObject = new ContactUsPage(driver);
		contactUsObject.contactUs(fullName, email, enquiry);
		
		Assert.assertTrue(contactUsObject.successMessage.getText().contains("Your enquiry has been successfully sent to the store owner"));
	}
	
}
	

