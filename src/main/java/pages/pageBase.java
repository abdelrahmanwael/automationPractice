package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pageBase {
	
	protected WebDriver driver;
	public JavascriptExecutor jse;
	public Select select;


	//Create Constructor
	public pageBase (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	protected  static void clickButton(WebElement button) 
	{
		button.click();
		
	}
	
	protected  static void setTxtElementTxt(WebElement textElement, String value) 
	{
		textElement.sendKeys(value);
		
	}
	
}

