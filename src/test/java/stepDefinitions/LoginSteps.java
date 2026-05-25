package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;

public class LoginSteps {
    HomePage home = new HomePage(BaseTest.driver);
    LoginPage loginPage = new LoginPage(BaseTest.driver);

    @Given("User is on login page")
    public void user_on_login_page() {
        home.clickLogin();
    }

    @When("User enters email {string} and password {string}")
    public void user_enters_credentials(String email, String pwd)  {
        loginPage.enterEmail(email);
        loginPage.enterPassword(pwd);
        loginPage.clickLogin();
//        WaitUtil.waitSec();

    }

    @Then("User should be logged in successfully")
    public void user_logged_in() {
        // After login, the "My Account" dropdown should contain "Logout"
        Assert.assertTrue(home.isLogoutLinkDisplayed());
    }

    @Then("Error message {string} is displayed")
    public void error_message_displayed(String expected) {
        Assert.assertTrue(loginPage.getWarningMessage().contains(expected));
    }

    @When("User clicks on forgot password link")
    public void user_clicks_forgot_password()  {
        loginPage.clickForgotPassword();
//        WaitUtil.waitSec();

    }

    @Then("Password recovery page is opened")
    public void password_recovery_page() {
        String currentUrl = BaseTest.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("forgotten"));
    }

    @When("User clicks logout")
    public void user_clicks_logout()  {
        home.clickLogout();
//        WaitUtil.waitSec();

    }

    @Then("User is redirected to home page and login link is visible")
    public void verify_logout() {
        Assert.assertTrue(BaseTest.driver.getCurrentUrl().contains("tutorialsninja"));
        // Optionally check that "Login" link is present again
        home.clickMyAccount();
        Assert.assertTrue(BaseTest.driver.getPageSource().contains("Login"));
    }
}