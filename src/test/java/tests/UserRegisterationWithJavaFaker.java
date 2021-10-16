package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationWithJavaFaker extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registrationObject;
	LoginPage loginObject;


	Faker fakerData = new Faker();
	String fName = fakerData.name().firstName();
	String lName = fakerData.name().lastName();
	String email = fakerData.internet().emailAddress();
	String password = fakerData.number().digits(45).toString();

	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully(){
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
