package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	@FindBy(css="strong.current-item")
	public WebElement prodcutNamebreadCrumb;

	@FindBy(css="button.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	
	@FindBy(css="span.price-value-4")
	public WebElement productPriceLbl;
	
	@FindBy(linkText="Add your review")
	public WebElement addReviewLink;
	
	@FindBy(id="add-to-wishlist-button-4")
	public WebElement addToWishlistBtn;

	@FindBy(css="button.button-2.add-to-compare-list-button")
	public WebElement addToCompareBtn;

	@FindBy(id = "add-to-cart-button-4")
	public WebElement addToCartBtn;

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}


	public void openSendEmail() {
		clickButton(emailFriendBtn);
	}
	
	public void openAddReviewPage() {
		clickButton(addReviewLink);
	}
	
	public void addProductToWishlist() {
		clickButton(addToWishlistBtn);
	}
	
	
	public void addProductToCompare() {
		clickButton(addToCompareBtn);
	}
	
	public void addProductToCart() {
		clickButton(addToCartBtn);
	}

}
