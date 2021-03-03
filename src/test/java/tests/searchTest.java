package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.homePage;
import pages.loginPage;
import pages.searchPage;

public class searchTest extends testBase {
	
	homePage homeObject;
	loginPage loginObject;
	searchPage searchObject;
	
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
	public void userLogout()
	{
		homeObject.userLogout();
	}

}
