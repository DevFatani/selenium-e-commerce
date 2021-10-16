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
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase {

	ContactUsPage contactUsObject;
	String productName = "Apple MacBook Pro 13-inch";

	HomePage homeObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishListPage wishlistPage;

	@Test(priority = 1)
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

	@Test(priority = 2)
	public void registerUserCanReviewdProduct() {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.addProductToWishlist();
		driver.navigate().to("https://demo.nopcommerce.com" + "/wishlist");
		wishlistPage = new WishListPage(driver);
		Assert.assertTrue(wishlistPage.wishlistHeader.isDisplayed());
		Assert.assertTrue(wishlistPage.prodcutCell.getText().contains(productName));
	}

	@Test(priority = 3)
	public void userCanRemoveProductFromCart() {
		System.out.println("shit taking !!");
		wishlistPage = new WishListPage(driver);
		wishlistPage.removeProductFromWishlist();
		Assert.assertTrue(wishlistPage.emptyCartLbl.getText().contains("The wishlist is empty!"));

	}
}
