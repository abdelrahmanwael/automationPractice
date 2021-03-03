package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends pageBase {

	public homePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="a.login")
	WebElement signinBtn;
	
	@FindBy(id="email_create")
	WebElement emailTxtBox;
	
	@FindBy(id="SubmitCreate")
	WebElement createAccountBtn;
	
	@FindBy(css="a.logout")
	WebElement signoutBtn;
	
	@FindBy(css="div.alert.alert-danger")
	public WebElement createAccountErrorMsg;
	
	public void userRegistration(String mail)
	{
		clickButton(signinBtn);
		setTxtElementTxt(emailTxtBox, mail);
		clickButton(createAccountBtn);
	}
	public void userLogin()
	{
		clickButton(signinBtn);
	}
	public void userLogout()
	{
		clickButton(signoutBtn);
	}

}
