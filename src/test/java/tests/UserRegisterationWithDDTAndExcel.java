package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationWithDDTAndExcel extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registrationObject;
	LoginPage loginObject;



	@DataProvider(name = "ExcelData")
	public static Object[][] userData() throws IOException {
		ExcelReader excelReader = new ExcelReader();
		return excelReader.getExcelData();
	}

	@Test(priority = 1, dataProvider = "ExcelData")
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
