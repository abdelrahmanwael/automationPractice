package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addProductToCartPage extends pageBase {

	public addProductToCartPage(WebDriver driver) {
		super(driver);
	}
	
	/*@FindBy(css="a.product-name")
	WebElement productNameBtn;*/
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")
	WebElement productNameBtn;
	
	@FindBy(id="add_to_cart")
	WebElement addToCartBtn;
	
	@FindBy(css="a.btn.btn-default.button.button-medium")
	WebElement proceedToCheckOutBtn;
	
	@FindBy(css="a.button.btn.btn-default.standard-checkout.button-medium")
	WebElement summaryProceedToCheckOutBtn;
	
	@FindBy(name="processAddress")
	WebElement addressProceedToCheckOutBtn;
	
	@FindBy(id="cgv")
	WebElement agreeToTermsBtn;
	
	@FindBy(name="processCarrier")
	WebElement shippingProceedToCheckOutBtn;
	
	@FindBy(css="a.bankwire")
	WebElement payByBankWireBtn;
	
	@FindBy(css="button.button.btn.btn-default.button-medium")
	WebElement confirmOrderBtn;
	
	@FindBy(css="span.navigation_page")
	public WebElement successMsg;
	
	public void addProductToCart()
	{
		clickButton(productNameBtn);
		clickButton(addToCartBtn);
	}
	public void cartCheckout()
	{
		clickButton(proceedToCheckOutBtn);
		clickButton(summaryProceedToCheckOutBtn);
		clickButton(addressProceedToCheckOutBtn);
		clickButton(agreeToTermsBtn);
		clickButton(shippingProceedToCheckOutBtn);
		clickButton(payByBankWireBtn);
		clickButton(confirmOrderBtn);
	}

}
