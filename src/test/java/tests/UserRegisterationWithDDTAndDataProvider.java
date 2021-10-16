package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationWithDDTAndDataProvider extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registrationObject;
	LoginPage loginObject;



	@DataProvider(name = "testData")
	public static Object[][] userData() {
		return new Object[][] {
			{"Muhammad", "Taning", "ksjjsdfn@skdlk3sn.sfom", "315615sdfsd613asdsf00530"},
			{"Ashari", "Taning", "ksdsjdjsdfn@skd3dflkn.sfom", "31561csdfsd5sdfsd613asdsf00530"},
		};
	}

	@Test(priority = 1, dataProvider = "testData")
	public void userCanRegisterSuccessfully(String fName, String lName, String email, String password) {
		homeObject = new HomePage(driver);
		loginObject = new LoginPage(driver);
		registrationObject = new UserRegistrationPage(driver);
		
		homeObject.openRegistrationPage();
		registrationObject.userRegistration(fName, lName, email,password);
		Assert.assertTrue(registrationObject.successMessage.getText().contains("Your registration completed"));
		
		registrationObject.userLogout();
		homeObject.openLoginPage();
		loginObject.userlogin(email, password);
		Assert.assertTrue(registrationObject.logoutLink.getText().contains("Log out"));
		registrationObject.userLogout();
	}
}
