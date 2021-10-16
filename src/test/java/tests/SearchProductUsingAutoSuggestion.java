package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggestion extends TestBase {

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;


	@Test
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
}