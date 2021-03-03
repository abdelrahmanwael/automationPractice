package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class userRegistrationPage extends pageBase {

	public userRegistrationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="id_gender1")
	WebElement genderRdoBtn;
	
	@FindBy(id="customer_firstname")
	WebElement fNameTxtBox;
	
	@FindBy(id="customer_lastname")
	WebElement lNameTxtBox;
	
	@FindBy(id="passwd")
	WebElement passwordTxtBox;
	
	@FindBy(id="address1")
	WebElement addressTxtBox;
	
	@FindBy(id="city")
	WebElement cityTxtBox;
	
	@FindBy(id="id_state")
	WebElement stateDropDownMenu;
	
	@FindBy(id="postcode")
	WebElement postalCodeTxtBox;
	
	@FindBy(id="id_country")
	WebElement countryDropDownMenu;
	
	@FindBy(id="phone_mobile")
	WebElement mobileTxtBox;
	
	@FindBy(id="alias")
	WebElement aliasAddressTxtBox;
	
	@FindBy(id="submitAccount")
	WebElement registerBtn;
	
	@FindBy(css="span.navigation_page")
	public WebElement successMsg;
	
	@FindBy(css="div.alert.alert-danger")
	public WebElement errorMsg;
	
	public void userRegistration(String fName, String lName, String password, String address, String city, String postalCode, String mobile, String aliasAddress)
	{
		clickButton(genderRdoBtn);
		setTxtElementTxt(fNameTxtBox, fName);
		setTxtElementTxt(lNameTxtBox, lName);
		setTxtElementTxt(passwordTxtBox, password);
		setTxtElementTxt(addressTxtBox, address);
		setTxtElementTxt(cityTxtBox, city);
		Select state = new Select(stateDropDownMenu);
		state.selectByVisibleText("Alaska");
		setTxtElementTxt(postalCodeTxtBox, postalCode);
		Select country = new Select(stateDropDownMenu);
		country.selectByIndex(2);
		setTxtElementTxt(mobileTxtBox, mobile);
		setTxtElementTxt(aliasAddressTxtBox, aliasAddress);
		clickButton(registerBtn);
	}

}
