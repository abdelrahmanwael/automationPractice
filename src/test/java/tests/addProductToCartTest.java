package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.addProductToCartPage;
import pages.homePage;
import pages.loginPage;
import pages.searchPage;

public class addProductToCartTest extends testBase {
	
	homePage homeObject;
	loginPage loginObject;
	searchPage searchObject;
	addProductToCartPage addProductObject;
	
	@Test(priority = 1)
	public void userLoginSuccessfully()
	{
		homeObject = new homePage(driver);
		loginObject = new loginPage(driver);
		homeObject.userLogin();
		loginObject.login("abdo1@test.com", "123456789");
		Assert.assertTrue(loginObject.successMsg.getText().contains("Welcome to your account. Here you can manage all of your personal information and orders."));
	}
	@Test(dependsOnMethods = "userLoginSuccessfully")
	public void userSearchForProduct()
	{
		searchObject = new searchPage(driver);
		searchObject.userSearchForProduct("Blouse");
		Assert.assertTrue(searchObject.successMsg.getText().contains("1 result has been found."));
	}
	@Test(dependsOnMethods = "userSearchForProduct")
	public void userAddProductToCart()
	{
		addProductObject = new addProductToCartPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,400)");
		addProductObject.addProductToCart();
	}
	@Test(dependsOnMethods = "userAddProductToCart")
	public void userCheckOut()
	{
		addProductObject.cartCheckout();
		Assert.assertTrue(addProductObject.successMsg.getText().contains("Order confirmation"));
	}

}
