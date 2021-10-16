package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {

	HomePage homeObject;
	ProductDetailsPage detailsObject;
	SearchPage searchObject;
	String productName = "Apple MacBook Pro 13-inch";


	
	@Test(priority = 1)
	public void userCanChangeCurrency() {
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();
		detailsObject = new ProductDetailsPage(driver);

	}
	
	@Test(priority = 2)
	public void userCanSearchWithAutoSuggest() {
		try {
			searchObject = new SearchPage(driver);
			searchObject.productSearchUsingAutoSuggestion("MacB");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.prodcutNamebreadCrumb.getText(), productName);
			Assert.assertTrue(detailsObject.productPriceLbl.getText().contains("€"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
	

