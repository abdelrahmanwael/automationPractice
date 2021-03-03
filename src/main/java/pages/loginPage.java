package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends pageBase {
	
	public loginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="email")
	WebElement emailTxtBox;
	
	@FindBy(id="passwd")
	WebElement passwordTxtBox;
	
	@FindBy(id="SubmitLogin")
	WebElement loginBtn;
	
	@FindBy(css="p.info-account")
	public WebElement successMsg;
	
	@FindBy(css="div.alert.alert-danger")
	public WebElement errorMsg;
	
	public void login(String mail, String password)
	{
		setTxtElementTxt(emailTxtBox, mail);
		setTxtElementTxt(passwordTxtBox, password);
		clickButton(loginBtn);
	}

}
