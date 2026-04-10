package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"Regression","Master"})
	public void verifyAccountRegistration() {

		logger.info("****** Starting TC001_AccountRegistrationTest ******");

		try {

			HomePage homepage = new HomePage(driver);
			homepage.clickMyAccount();

			logger.info(" Clicked On MyAccount Link.");

			homepage.clickRegistr();

			logger.info(" Clicked On Register Link.");

			AccountRegistrationPage registerPage = new AccountRegistrationPage(driver);

			logger.info(" Providing customer Details..");

			// registerPage.firstName("Rohit");
			registerPage.firstName(randomString().toUpperCase());// Randomly Generated name
			// registerPage.lastName("Sharma");
			registerPage.lastName(randomString().toUpperCase());
			registerPage.email(randomString() + "+@gmail.com"); // Randomly Generated Mail
			registerPage.telephone(randomNumber());// Randomly Generated Number

			String password = randomAlphaNumeric();// Randomly Generated password stored in a variable
			registerPage.password(password);
			registerPage.confirmPassword(password);
			registerPage.radioButton();

			registerPage.checkboxPrivacy();
			registerPage.continueBtn();

			logger.info(" Validating Expected message....");

			String confirmMessage = registerPage.getConfirmationMsg();

			Assert.assertEquals(confirmMessage, "Your Account Has Been Created!", "Account creation failed or message mismatch");

		} catch (Exception e) {

			logger.error("Test Failed...", e);
			Assert.fail("Exception occurred: " + e.getMessage());
		}

		logger.info("****** Finished TC001_AccountRegistrationTest ******");
	}

}