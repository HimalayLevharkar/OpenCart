package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void verifyLogin() {
		logger.info("****** Starting TC002_LoginTest ****** ");

		try {
			// Homepage

			HomePage homepage = new HomePage(driver);

			homepage.clickMyAccount();
			homepage.clickLogin();

			// LoginPage
			LoginPage loginpage = new LoginPage(driver);

			loginpage.setEmail(properties.getProperty("email"));
			loginpage.setPassword(properties.getProperty("password"));
			loginpage.clickLogin();

			// MyAccountPage

			MyAccountPage myAccount = new MyAccountPage(driver);

			boolean targetPage = myAccount.isMyAccountPageExists();
			Assert.assertTrue(targetPage);// Assert.assertEquals(targetPage, true,"Login Failed");
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("****** Finished TC002_LoginTest ****** ");

	}

}
