package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	// constructor
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// locators

	@FindBy(id = "input-firstname")
	WebElement txtFirstName;

	@FindBy(name = "lastname")
	WebElement txtLastName;

	@FindBy(name = "email")
	WebElement txtEmail;

	@FindBy(name = "telephone")
	WebElement txtTelephone;

	@FindBy(id = "input-password")
	WebElement txtPassword;

	@FindBy(id = "input-confirm")
	WebElement txtPasswordConfirm;

	@FindBy(xpath = "//label[text()= 'No']")

	WebElement radioButtonNo;

	@FindBy(name = "agree")
	WebElement checkBoxPrivacy;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	// Actions

	public void firstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}

	public void lastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}

	public void email(String email)

	{
		txtEmail.sendKeys(email);
	}

	public void telephone(String telephone) {

		txtTelephone.sendKeys(telephone);
	}

	public void password(String password) {

		txtPassword.sendKeys(password);
	}

	public void confirmPassword(String confirmPassword) {
		txtPasswordConfirm.sendKeys(confirmPassword);
	}

	public void radioButton() {
		radioButtonNo.click();
	}

	public void checkboxPrivacy() {
		checkBoxPrivacy.click();
	}

	public void continueBtn() {
		btnContinue.click();
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());

		} catch (Exception e) {
			return (e.getMessage());
		}

	}

}
