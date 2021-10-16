package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	@FindBy(css="button.remove-btn")
	public WebElement removeCheck;

	@FindBy(name="updatecart")
	WebElement updateCartBtn;
	
	@FindBy(css="input.qty-input valid")
	public WebElement qtyTxt;
	
	@FindBy(css="td.subtotal")
	public WebElement totalLbl;
	
	@FindBy(id="checkout")
	public WebElement checkoutBtn;
	
	@FindBy(id="termsofservice")
	public WebElement agreeCheckbox;
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	public void removeProductFromCart() {
		clickButton(removeCheck);
//		clickButton(updateCartBtn);
	}
	
	
	public void openCheckoutPage() {
		clickButton(agreeCheckbox);
		clickButton(checkoutBtn);
	}
	
	
	
	public void updateProductQTYInCart(String qty) {
		clearText(qtyTxt);
		setTextElementText(qtyTxt, qty);
		clickButton(updateCartBtn);
	}

}
