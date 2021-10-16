package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationWithDDTAndJSON extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registrationObject;
	LoginPage loginObject;

	@Test(priority = 1)
	public void userCanRegisterSuccessfully() throws IOException, ParseException {
		JsonDataReader dataReader =  new JsonDataReader();
		dataReader.jsonReader();
		
		homeObject = new HomePage(driver);
		loginObject = new LoginPage(driver);
		registrationObject = new UserRegistrationPage(driver);
		
		homeObject.openRegistrationPage();
		registrationObject.userRegistration(dataReader.fName, dataReader.lName, dataReader.email, dataReader.password);
		Assert.assertTrue(registrationObject.successMessage.getText().contains("Your registration completed"));
		
		registrationObject.userLogout();
		homeObject.openLoginPage();
		loginObject.userlogin(dataReader.email, dataReader.password);
		Assert.assertTrue(registrationObject.logoutLink.getText().contains("Log out"));
		registrationObject.userLogout();
	}
}
