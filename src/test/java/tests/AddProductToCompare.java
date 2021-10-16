package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.ContactUsPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompare extends TestBase {

	ContactUsPage contactUsObject;
	String productName = "Apple MacBook Pro 13-inch";
	String prodcutName2 = "Asus N551JK-XO076H Laptop";

	HomePage homeObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ComparePage comparePage;

	@Test(priority = 1)
	public void userCanCompareProducts() {
		try {
			searchObject = new SearchPage(driver);
			detailsObject = new ProductDetailsPage(driver);
			comparePage = new ComparePage(driver);

			searchObject.productSearchUsingAutoSuggestion("MacB");
			Assert.assertTrue(detailsObject.prodcutNamebreadCrumb.getText().contains(productName));
			detailsObject.addProductToCompare();

			searchObject.productSearchUsingAutoSuggestion("Asus");
			Assert.assertTrue(detailsObject.prodcutNamebreadCrumb.getText().contains(prodcutName2));
			detailsObject.addProductToCompare();
			Thread.sleep(5000);
			driver.navigate().to("https://demo.nopcommerce.com" + "/compareproducts");
			Assert.assertTrue(comparePage.firstProductName.isDisplayed());
			Assert.assertTrue(comparePage.secondProductName.isDisplayed());
			comparePage.compareProducts();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void userCanClearList() {
		comparePage.clearList();
		Assert.assertTrue(comparePage.noDataLbl.isDisplayed());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	@Test(priority = 3)
//	public void userCanRemoveProductFromCart() {
//		System.out.println("shit taking !!");
//		wishlistPage = new WishListPage(driver);
//		wishlistPage.removeProductFromWishlist();
//		Assert.assertTrue(wishlistPage.emptyCartLbl.getText().contains("The wishlist is empty!"));
//
//	}
}
