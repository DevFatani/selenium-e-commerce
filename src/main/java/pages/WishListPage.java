package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase {

	@FindBy(css="td.product")
	public WebElement prodcutCell;
	
	@FindBy(css="h1")
	public WebElement wishlistHeader;
	
	@FindBy(name="updatecart")
	public WebElement updateWishlistBtn;
	
	@FindBy(className ="remove-btn")
	public WebElement removefromCartCheck;
	
	@FindBy(css = "div.no-data" )
	public WebElement emptyCartLbl;
	
	public WishListPage(WebDriver driver) {
		super(driver);
		executor = (JavascriptExecutor) driver;
	}
	
	public void removeProductFromWishlist() {
		System.out.println("shit taking !!223");
		clickButton(removefromCartCheck);
//		clickButton(updateWishlistBtn);
	
	}
	

}
