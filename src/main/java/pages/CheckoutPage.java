package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase {

	@FindBy(id="BillingNewAddress_FirstName")
	WebElement fnTxt;

	@FindBy(id="BillingNewAddress_LastName")
	WebElement lnTxt;
	
	@FindBy(id="BillingNewAddress_Email")
	WebElement emailTxt;
	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countryList;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement cityTxt;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement addressTxt;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement zipCodeTxt;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneNumberTxt;
	
	@FindBy(css="button.button-1.new-address-next-step-button")
	WebElement continueBtn;
	
	@FindBy(id="shippingoption_1")
	WebElement shoppingMethodRdo;
	
	@FindBy(css="button.button-1.shipping-method-next-step-button")
	WebElement continueShippingBtn;
	
	@FindBy(css="button.button-1.payment-method-next-step-button")
	WebElement continuePaymentBtn;
	
	@FindBy(css="button.button-1.payment-info-next-step-button")
	WebElement continueInfoBtn;
	
	@FindBy(css="a.product-name")
	public WebElement productName;
	
	@FindBy(css="button.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;
	
	@FindBy(css="h1")
	public WebElement thankYouLbl;
	
	@FindBy(css="div.title")
	public WebElement successMessage;
	
	@FindBy(linkText="Click here for order details.")
	public WebElement orderDetailsLink;
	
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public void registeredUserCheckoutProduct(
			String countryName,
			String address,
			String zipCode,
			String phone,
			String city,
			String productName
			) throws InterruptedException {
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		
		setTextElementText(cityTxt, city);
		setTextElementText(addressTxt, address);
		setTextElementText(zipCodeTxt, zipCode);
		setTextElementText(phoneNumberTxt, phone);
		
		clickButton(continueBtn);
		clickButton(shoppingMethodRdo);
		clickButton(continueShippingBtn);
		Thread.sleep(1000);
		clickButton(continuePaymentBtn);
		Thread.sleep(1000);
		clickButton(continueInfoBtn);
		Thread.sleep(1000);
		

	}
	
	public void confirmOrder() throws InterruptedException {
		Thread.sleep(1000);
		clickButton(confirmBtn);
	}
	
	public void viewOrderDetails() {
		clickButton(orderDetailsLink);
	}

}
