package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.RegistrationPage;
import utils.WaitUtil;

import org.testng.Assert;

public class RegistrationSteps {
    HomePage home = new HomePage(BaseTest.driver);
    RegistrationPage regPage = new RegistrationPage(BaseTest.driver);

    @Given("User navigates to registration page")
    public void user_navigates_to_registration_page() {
        home.clickRegister();
    }

    @When("User enters valid details {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_enters_valid_details(String firstName, String lastName, String email,
                                          String telephone, String password, String confirmPassword) throws InterruptedException {
        regPage.enterFirstName(firstName);
        regPage.enterLastName(lastName);
        regPage.enterEmail(email);
        regPage.enterTelephone(telephone);
        regPage.enterPassword(password);
        regPage.enterConfirmPassword(confirmPassword);
        regPage.checkPrivacyPolicy();
        regPage.clickContinue();
        WaitUtil.waitSec();
    }
    

    @Then("Registration should be successful with message {string}")
    public void registration_successful(String expectedMsg) {
        Assert.assertEquals(regPage.getSuccessMessage(), expectedMsg);
    }

    @When("User enters existing email {string}")
    public void user_enters_existing_email(String email) {
        regPage.enterEmail(email);
        regPage.clickContinue();
    }

    @Then("Error message for existing email is displayed")
    public void error_existing_email() {
        Assert.assertTrue(regPage.getWarningMessage().contains("Warning"));
    }

    @When("User leaves mandatory fields empty")
    public void user_leaves_mandatory_fields_empty() {
        regPage.clickContinue();
    }

    @Then("Validation errors are shown")
    public void validation_errors() {
        Assert.assertTrue(regPage.isValidationErrorDisplayed());
    }
}