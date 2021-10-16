package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registrationObject;
	MyAccountPage accountObject;
	String oldPass = "123456";
	String newPass = "123451223";
	String fName = "Shit";
	String lName = "fuck";
	String email = "fuck@shit.com";
	LoginPage loginObject;

	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registrationObject = new UserRegistrationPage(driver);
		registrationObject.userRegistration(fName, lName, email, oldPass);
		
		Assert.assertTrue(registrationObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods = {"userCanRegisterSuccessfully"})
	public void registeredUserCanChangePassword() {
		accountObject = new MyAccountPage(driver);
		registrationObject.openMyAccountPage();
		accountObject.openChangePasswordPage();
		accountObject.changePassword(oldPass, newPass);
//		Assert.assertTrue(accountObject.resultLbl.getText().contains("Password was changed"));
	}
	
	@Test(dependsOnMethods = {"registeredUserCanChangePassword"})
	public void registeredUserCanLogout() {
		registrationObject.userLogout();
	}
	
	@Test(dependsOnMethods = {"registeredUserCanLogout"})
	public void registeredUserCanLogin() {
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userlogin(email, newPass);
//		Assert.assertTrue(registrationObject.logoutLink.isDisplayed());
	}
	
}
	

