package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationWithDDTAndPropertiesFile extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registrationObject;
	LoginPage loginObject;

	String fName = LoadProperties.userData.getProperty("firstname");
	String lName = LoadProperties.userData.getProperty("lastname");
	String email = LoadProperties.userData.getProperty("email");
	String password = LoadProperties.userData.getProperty("password");


	@Test(priority = 1)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		loginObject = new LoginPage(driver);
		registrationObject = new UserRegistrationPage(driver);

		
		
		homeObject.openRegistrationPage();
		registrationObject.userRegistration(fName, lName, email, password);
		Assert.assertTrue(registrationObject.successMessage.getText().contains("Your registration completed"));

		registrationObject.userLogout();
		homeObject.openLoginPage();
		loginObject.userlogin(email, password);
		Assert.assertTrue(registrationObject.logoutLink.getText().contains("Log out"));
		registrationObject.userLogout();
	}
}
