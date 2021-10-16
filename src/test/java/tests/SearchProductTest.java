package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;


	@Test
	public void userCanSearchForProduct() throws InterruptedException {
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.productSearch(productName);
		
		searchObject.openProductDetailsPage();
		Thread.sleep(2000);
		Assert.assertTrue(detailsObject.prodcutNamebreadCrumb.getText().equalsIgnoreCase(productName));
	}
}