package testCases;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
 * Data is valid - login success - test pass - logout login failed - test fail
 * 
 * Data is invalid - login success - test fail - logout login failed - test pass
 */

public class TC003_LoginDataDrivenTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups = "DataDriven") // getting data provider from different
																				// class
	public void verifyLoginDataDrivenTest(String email, String password, String exp) {
		// logger.info("***** Stating TC003_LoginDataDrivenTest ******");

		try {

			// Homepage

			HomePage homePage = new HomePage(driver);
			homePage.clickMyAccount();
			homePage.clickLogin();

			// Login

			LoginPage login = new LoginPage(driver);
			login.setEmail(email);
			login.setPassword(password);
			login.clickLogin();

			// My Account

			MyAccountPage myAccount = new MyAccountPage(driver);
			boolean targetPage = myAccount.isMyAccountPageExists();

			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					myAccount.setlogout();
					Assert.assertTrue(true);

				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					myAccount.setlogout();
					Assert.assertTrue(false);

				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {

			Assert.fail();
		}

		// logger.info("***** Finished TC003_LoginDataDrivenTest ******");
	}

}
