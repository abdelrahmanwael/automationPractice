package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.homePage;
import pages.userRegistrationPage;

public class userRegistrationTest extends testBase {
	
	homePage homeObject;
	userRegistrationPage registerObject;
	
	@Test(priority = 1)
	public void userRegisterWithRegisteredMail()
	{
		homeObject = new homePage(driver);
		registerObject = new userRegistrationPage(driver);
		homeObject.userRegistration("abdo6@test.com");
		//Assert.assertTrue(homeObject.createAccountErrorMsg.getText().contains("An account using this email address has already been registered. Please enter a valid password or request a new one. "));
	}
	
	@Test(dependsOnMethods = "userRegisterWithRegisteredMail")
	public void userRegisterWithoutInsertingFirstName()
	{
		homeObject = new homePage(driver);
		registerObject = new userRegistrationPage(driver);
		homeObject.userRegistration("Abdelrahman26@test.com");
		registerObject.userRegistration("", "Wael", "123456789", "address", "Cairo", "11111", "01000000000", "Alias Address");
		Assert.assertTrue(registerObject.errorMsg.getText().contains("error"));
	}
	@Test(dependsOnMethods = "userRegisterWithoutInsertingFirstName")
	public void userRegisterWithoutInsertingLastName()
	{
		homeObject = new homePage(driver);
		registerObject = new userRegistrationPage(driver);
		homeObject.userRegistration("Abdelrahman26@test.com");
		registerObject.userRegistration("Abdelrahman", "", "123456789", "address", "Cairo", "11111", "01000000000", "Alias Address");
		Assert.assertTrue(registerObject.errorMsg.getText().contains("error"));
	}
	@Test(dependsOnMethods = "userRegisterWithoutInsertingLastName")
	public void userRegisterWithoutInsertingPassword()
	{
		homeObject = new homePage(driver);
		registerObject = new userRegistrationPage(driver);
		homeObject.userRegistration("Abdelrahman26@test.com");
		registerObject.userRegistration("Abdelrahman", "Wael", "", "address", "Cairo", "11111", "01000000000", "Alias Address");
		Assert.assertTrue(registerObject.errorMsg.getText().contains("error"));
	}
	@Test(dependsOnMethods = "userRegisterWithoutInsertingPassword")
	public void userRegisterWithoutInsertingAddress()
	{
		homeObject = new homePage(driver);
		registerObject = new userRegistrationPage(driver);
		homeObject.userRegistration("Abdelrahman26@test.com");
		registerObject.userRegistration("Abdelrahman", "Wael", "123456789", "", "Cairo", "11111", "01000000000", "Alias Address");
		Assert.assertTrue(registerObject.errorMsg.getText().contains("error"));
	}
	@Test(dependsOnMethods = "userRegisterWithoutInsertingAddress")
	public void userRegisterWithoutInsertingCity()
	{
		homeObject = new homePage(driver);
		registerObject = new userRegistrationPage(driver);
		homeObject.userRegistration("Abdelrahman26@test.com");
		registerObject.userRegistration("Abdelrahman", "Wael", "123456789", "address", "", "11111", "01000000000", "Alias Address");
		Assert.assertTrue(registerObject.errorMsg.getText().contains("error"));
	}
	@Test(dependsOnMethods = "userRegisterWithoutInsertingCity")
	public void userRegisterWithoutInsertingPostalCode()
	{
		homeObject = new homePage(driver);
		registerObject = new userRegistrationPage(driver);
		homeObject.userRegistration("Abdelrahman26@test.com");
		registerObject.userRegistration("Abdelrahman", "Wael", "123456789", "address", "Cairo", "", "01000000000", "Alias Address");
		Assert.assertTrue(registerObject.errorMsg.getText().contains("error"));
	}
	@Test(dependsOnMethods = "userRegisterWithoutInsertingPostalCode")
	public void userRegisterWithoutInsertingPhoneNumber()
	{
		homeObject = new homePage(driver);
		registerObject = new userRegistrationPage(driver);
		homeObject.userRegistration("Abdelrahman26@test.com");
		registerObject.userRegistration("Abdelrahman", "Wael", "123456789", "address", "Cairo", "11111", "", "Alias Address");
		Assert.assertTrue(registerObject.errorMsg.getText().contains("error"));
	}
	@Test(dependsOnMethods = "userRegisterWithoutInsertingPhoneNumber")
	public void userCanRegisterSuccessfully()
	{
		homeObject.userRegistration("Abdelrahman26@test.com");
		registerObject.userRegistration("Abdelrahman", "Wael", "123456789", "address", "Cairo", "11111", "01000000000", "Alias Address");
		Assert.assertTrue(registerObject.successMsg.getText().contains("My account"));
	}
	@Test(dependsOnMethods = "userCanRegisterSuccessfully")
	public void userLogout()
	{
		homeObject.userLogout();
	}
	

}
