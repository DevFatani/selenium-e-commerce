package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase {

	ContactUsPage contactUsObject;
	String productName = "Apple MacBook Pro 13-inch";

	HomePage homeObject;
	UserRegistrationPage registrationObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailObject;
	ProductReviewPage reviewPage;

	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();

		registrationObject = new UserRegistrationPage(driver);
		registrationObject.userRegistration("Ah3mad", "Ali", (int) (Math.random() * 10000) + "Shit@schaaait.com",
				"1234566");

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
	public void registerUserCanReviewdProduct() {
		detailsObject.openAddReviewPage();
		reviewPage = new ProductReviewPage(driver);
		reviewPage.addProductReview("suck", "the product like sh**");

		Assert.assertTrue(reviewPage.successMessage.getText().contains("Product review is successfully added"));
	}

	@Test(priority = 4)
	public void registeredUserCanLogout() {
		registrationObject.userLogout();

	}

}
