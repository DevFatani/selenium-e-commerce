package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {


	HomePage homeObject;
	UserRegistrationPage registrationObject;
	LoginPage loginObject;
	
	
	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
	}
	
	@When("I click on register link")
	public void i_click_on_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	
	@When("I entered {string}, {string}, {string}, {string},")
	public void i_entered(String fName, String lName, String email, String password) {
		registrationObject = new UserRegistrationPage(driver);
		registrationObject.userRegistration(fName, lName, (int)(Math.random()*10000) + email, password);
		Assert.assertTrue(registrationObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Then("The registration page displayed successfully")
	public void the_registration_page_displayed_successfully() {
		registrationObject.userLogout();
	}
	
	

	


}