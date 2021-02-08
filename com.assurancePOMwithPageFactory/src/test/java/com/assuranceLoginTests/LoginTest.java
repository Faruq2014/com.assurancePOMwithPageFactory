package com.assuranceLoginTests;

import org.testng.annotations.Test;

import com.assuranceBase.BaseTest;
import com.assuranceLoginPages.LoginPage;

public class LoginTest extends BaseTest{
	

	@Test(priority=1, groups={"functional"} )
	public void myAccountLoginLinkTest() {
		LoginPage lp = new LoginPage(driver);
		lp.myAccountLoginLink();
	}
	@Test(priority=2, groups={"functional"} )
	public void switchToChildWindowTest(){
		LoginPage lp = new LoginPage(driver);
		lp.switchToChildWindow();
	}

	@Test(priority=3, groups= {"functional"})
	public void userNameTest() {
		LoginPage lp = new LoginPage(driver);
		lp.username("Farid");
	}

	@Test(priority=4, groups= {"functional"})
	public void passwordLinkTest() {
		LoginPage lp = new LoginPage(driver);
		lp.passwordLink("1233444");
	}

	@Test(priority=5, groups= {"functional"})
	public void submitTest() {
		LoginPage lp = new LoginPage(driver);
		lp.submitFunctionalty();
	}

	@Test(priority=6, groups= {"regression","smoke"})
	public void loginRegresationTest() {
		LoginPage lp = new LoginPage(driver);
		lp.loginRegresation("Farid", "12345");
	}
	
	


}
