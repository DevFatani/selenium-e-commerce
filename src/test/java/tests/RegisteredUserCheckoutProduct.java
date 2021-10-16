package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.ContactUsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegistrationPage;

public class RegisteredUserCheckoutProduct extends TestBase {

	ContactUsPage contactUsObject;

	String fullName = "Muhammad Fatani";
	String email = getRandomNumber() + "fuck@shit.com";
	String enquiry = "your website is like shit";
	String productName = "Apple MacBook Pro 13-inch";


	HomePage homeObject;
	UserRegistrationPage registrationObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPage;
	CheckoutPage checkoutPage;
	OrderDetailsPage orderDetailsPage;


	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();

		registrationObject = new UserRegistrationPage(driver);
		registrationObject.userRegistration("Ah3mad", getRandomNumber() + "Ali",email, "123456789");

		Assert.assertTrue(registrationObject.successMessage.getText().contains("Your registration completed"));
	}


	@Test(priority = 2)
	public void userCanSearchWithAutoSuggestion() {
		try {
			searchObject = new SearchPage(driver);
			detailsObject = new ProductDetailsPage(driver);
			searchObject.productSearchUsingAutoSuggestion("MacB");
			Assert.assertEquals(detailsObject.prodcutNamebreadCrumb.getText(), productName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	@Test(priority = 3)
	public void userCanAddProductToShoppingCart() throws InterruptedException {
		detailsObject.addProductToCart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
		cartPage = new ShoppingCartPage(driver);
		Assert.assertTrue(cartPage.totalLbl.getText().contains("$3,600.00"));
	}


	@Test(priority = 4)
	public void userCanCheckoutProduct() throws InterruptedException {
		checkoutPage = new CheckoutPage(driver);
		cartPage.openCheckoutPage();
		checkoutPage.registeredUserCheckoutProduct("Thailand", "Pattani-nong chick", getRandomNumber() + "", "0566698417", "Pattani", productName);
		Assert.assertTrue(checkoutPage.productName.isDisplayed());
		Assert.assertTrue(checkoutPage.productName.getText().contains(productName));
		checkoutPage.confirmOrder();
		Assert.assertTrue(checkoutPage.thankYouLbl.isDisplayed());
		checkoutPage.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderDetailsPage = new OrderDetailsPage(driver);
		orderDetailsPage.DownloadPDFInvoice();
		orderDetailsPage.printOrderDetails();
	}
	
	@Test(priority = 5)
	public void userCanLogout() throws InterruptedException {
		registrationObject.userLogout();
//		Thread.sleep(1000);
	}

}


