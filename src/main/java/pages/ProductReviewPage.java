package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {
	
	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="AddProductReview_Title")
	WebElement addProductReviewTitle;

	@FindBy(id="AddProductReview_ReviewText")
	WebElement addProductReviewReviewText;
	
	@FindBy(id="addproductrating_4")
	WebElement rating4RdoBtn;

	@FindBy(name="add-review")
	WebElement submitReviewBtn;


	@FindBy(css="div.result")
	public WebElement successMessage;



	public void addProductReview(String reviewTitle, String reviewMessage) {
		setTextElementText(addProductReviewTitle, reviewTitle);
		setTextElementText(addProductReviewReviewText, reviewMessage);
		clickButton(rating4RdoBtn);
		clickButton(submitReviewBtn);
	}

	public void openLoginPage() {
		//		clickButton(loginLink);
	}

}
