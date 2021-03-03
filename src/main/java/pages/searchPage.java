package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchPage extends pageBase{

	public searchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="search_query_top")
	WebElement searchTxtBox;
	
	@FindBy(name="submit_search")
	WebElement sumbitBtn;
	
	@FindBy(css="span.heading-counter")
	public WebElement successMsg;
	
	public void userSearchForProduct(String product)
	{
		setTxtElementTxt(searchTxtBox, product);
		clickButton(sumbitBtn);
	}

}
