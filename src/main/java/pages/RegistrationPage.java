package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	 WebDriver driver;

	    @FindBy(xpath = "//input[@id='input-firstname']")
	    WebElement firstNameField;

	    @FindBy(xpath = "//input[@id='input-lastname']")
	    WebElement lastNameField;

	    @FindBy(xpath = "//input[@id='input-email']")
	    WebElement emailField;

	    @FindBy(xpath = "//input[@id='input-telephone']")
	    WebElement telephoneField;

	    @FindBy(xpath = "//input[@id='input-password']")
	    WebElement passwordField;

	    @FindBy(xpath = "//input[@id='input-confirm']")
	    WebElement confirmPasswordField;

	    @FindBy(xpath = "//input[@name='agree']")
	    WebElement privacyPolicyCheckbox;

	    @FindBy(xpath = "//input[@value='Continue']")
	    WebElement continueButton;

	    @FindBy(xpath = "//div[@id='content']/h1")
	    WebElement successMessage;

	    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	    WebElement warningMessage;

	    @FindBy(xpath = "//div[@class='text-danger']")
	    WebElement validationError;

	    public RegistrationPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void enterFirstName(String firstName) {
	        firstNameField.sendKeys(firstName);
	    }

	    public void enterLastName(String lastName) {
	        lastNameField.sendKeys(lastName);
	    }

	    public void enterEmail(String email) {
	        emailField.sendKeys(System.currentTimeMillis()+email);
	    }

	    public void enterTelephone(String telephone) {
	        telephoneField.sendKeys(telephone);
	    }

	    public void enterPassword(String password) {
	        passwordField.sendKeys(password);
	    }

	    public void enterConfirmPassword(String confirmPassword) {
	        confirmPasswordField.sendKeys(confirmPassword);
	    }

	    public void checkPrivacyPolicy() {
	        privacyPolicyCheckbox.click();
	    }

	    public void clickContinue() {
	        continueButton.click();
	    }

	    public String getSuccessMessage() {
	        return successMessage.getText();
	    }

	    public String getWarningMessage() {
	        return warningMessage.getText();
	    }

	    public boolean isValidationErrorDisplayed() {
	        return validationError.isDisplayed();
	    }

}
