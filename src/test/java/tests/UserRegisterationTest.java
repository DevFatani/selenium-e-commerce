package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registrationObject;
	LoginPage loginObject;
	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registrationObject = new UserRegistrationPage(driver);
		registrationObject.userRegistration("Ah3mad", "Ali", (int)(Math.random()*10000) + "Shit@schaaait.com", "1234566");
		
		Assert.assertTrue(registrationObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods = {"userCanRegisterSuccessfully"})
	public void registeredUserCanLogout() {
		registrationObject.userLogout();
	}
	
	@Test(dependsOnMethods = {"registeredUserCanLogout"})
	public void registeredUserCanLogin() {
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userlogin("1Shaieet093a4@schaaait.com", "1234566");
//		Assert.assertTrue(registrationObject.logoutLink.isDisplayed());
	}
}
