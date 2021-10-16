package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	@FindBy(id="small-searchterms")
	WebElement searchTxtBox;

	@FindBy(css="button.button-1.search-box-button")
	WebElement searchBtn;

	@FindBy(id="ui-id-1")
	List<WebElement> productList;

	@FindBy(css="h2.product-title")
	WebElement productTitle;

	public SearchPage(WebDriver driver) {
		super(driver);
	}


	public void productSearch(String productName) {
		setTextElementText(searchTxtBox, productName);
		clickButton(searchBtn);
	}

	public void openProductDetailsPage() {
		clickButton(productTitle);
	}

	
	public void productSearchUsingAutoSuggestion(String searchTxt) {
		setTextElementText(searchTxtBox, searchTxt);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clickButton(productList.get(0));
	}

}
