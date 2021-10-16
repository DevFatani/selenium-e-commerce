package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.ContactUsPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCart extends TestBase {

	ContactUsPage contactUsObject;
	String productName = "Apple MacBook Pro 13-inch";
	String prodcutName2 = "Asus N551JK-XO076H Laptop";

	HomePage homeObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPage;

	@Test(priority = 1)
	public void userCanCompareProducts() {
		try {
			searchObject = new SearchPage(driver);
			detailsObject = new ProductDetailsPage(driver);

			searchObject.productSearchUsingAutoSuggestion("MacB");
			Assert.assertTrue(detailsObject.prodcutNamebreadCrumb.getText().contains(productName));


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void userCanAddProductToShoppingCart() {
		detailsObject.addProductToCart();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
		cartPage = new ShoppingCartPage(driver);
		Assert.assertTrue(cartPage.totalLbl.getText().contains("$3,600.00"));


	}

	@Test(priority = 3)
	public void userCanRemoveProductFromCart() {
		System.out.println("shit taking !!");

		cartPage.removeProductFromCart();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
