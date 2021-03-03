package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.homePage;
import pages.loginPage;

public class loginTest extends testBase {
	
	homePage homeObject;
	loginPage loginObject;
	
	@Test(priority = 1)
	public void userLoginWithInvalidMail()
	{
		homeObject = new homePage(driver);
		loginObject = new loginPage(driver);
		homeObject.userLogin();
		loginObject.login("invalidmail@test.com", "123456789");
		Assert.assertTrue(loginObject.errorMsg.getText().contains("There is 1 error"));
	}
	@Test(dependsOnMethods = "userLoginWithInvalidMail")
	public void userLoginWithInvalidPassword()
	{
		homeObject.userLogin();
		loginObject.login("abdo1@test.com", "invalidpassword");
		Assert.assertTrue(loginObject.errorMsg.getText().contains("There is 1 error"));
	}
	@Test(dependsOnMethods = "userLoginWithInvalidPassword")
	public void userLoginSuccessfully()
	{
		homeObject.userLogin();
		loginObject.login("abdo1@test.com", "123456789");
		Assert.assertTrue(loginObject.successMsg.getText().contains("Welcome to your account. Here you can manage all of your personal information and orders."));
	}
	@Test(dependsOnMethods = "userLoginSuccessfully")
	public void userLogout()
	{
		homeObject.userLogout();
	}

}
