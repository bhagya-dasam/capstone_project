package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class CheckoutSteps {

    HomePage home;
    LoginPage loginPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    WebDriverWait wait;

    private void initializePages() {
        home = new HomePage(BaseTest.driver);
        loginPage = new LoginPage(BaseTest.driver);
        wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(15));
    }

    @Given("User is on home page")
    public void user_is_on_home_page() {
        
        System.out.println("User is on home page");
    }

    @Given("User has items in cart and proceeds to checkout")
    public void user_has_items_in_cart_and_proceeds_to_checkout() {
        initializePages();

        // Login
        home.clickLogin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
        loginPage.enterEmail("bhagyadasam2@gmail.com");
        loginPage.enterPassword("bhagya@123");
        loginPage.clickLogin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Logout'])[2]")));

        home.searchProduct("HP LP3065");
        SearchPage searchPage = new SearchPage(BaseTest.driver);
        searchPage.addFirstProductToCart();
        searchPage.innerAddToCart();
        
        home.goToCart();
        cartPage = new CartPage(BaseTest.driver);
        cartPage.proceedToCheckout();   

        try {
            By newAddressRadio = By.xpath("(//input[@name='payment_address'])[2]");
            By continueButton = By.xpath("//input[@id='button-payment-address']");
            
            if (BaseTest.driver.findElements(newAddressRadio).size() > 0) {
                BaseTest.driver.findElement(newAddressRadio).click();
                BaseTest.driver.findElement(continueButton).click();
                System.out.println("Selected 'I want to use a new address' and clicked Continue");
            } 

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-payment-firstname']")));
        } catch (Exception e) {
            System.out.println("Checkout options step not needed or already on billing page");
        }
    }
    @Given("User enters billing details {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_enters_billing_details(String firstName, String lastName, String address,
                                            String city, String postcode, String country, String region) {
        checkoutPage = new CheckoutPage(BaseTest.driver);
        checkoutPage.fillBillingDetails(firstName, lastName, address, city, postcode, country, region);
        checkoutPage.clickContinueBilling();
    }

    @Then("Shipping method page is displayed")
    public void shipping_method_page_is_displayed() {
        boolean isShippingPage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='button-shipping-address']"))).isDisplayed();
        Assert.assertTrue(isShippingPage, "Shipping method page is not displayed");
    }

    @When("User selects shipping method and payment method")
    public void user_selects_shipping_method_and_payment_method() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='button-shipping-address']")));
        checkoutPage.clickContinueDelivery();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='button-shipping-method']")));
        checkoutPage.clickContinueShippingMethod();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='agree']")));
        checkoutPage.acceptTermsAndConditions();
        checkoutPage.clickContinuePaymentMethod();
    }

    @Then("Payment information page is displayed")
    public void payment_information_page_is_displayed() {
        boolean isPaymentPage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='button-confirm']"))).isDisplayed();
        Assert.assertTrue(isPaymentPage, "Payment information page is not displayed");
    }

    @When("User enters payment details {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_enters_payment_details(String cardType, String cardHolderName, String cardNumber,
                                            String expiryMonth, String expiryYear, String cvv) {
     System.out.println("Payment details step executed (no real fields on TutorialsNinja)");
    }

    @When("User confirms the order")
    public void user_confirms_the_order() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='button-confirm']")));
        checkoutPage.clickConfirmOrder();
    }

    @Then("Order should be successful with confirmation message")
    public void order_should_be_successful_with_confirmation_message() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1")));
        String msg = checkoutPage.getOrderSuccessMessage();
        Assert.assertTrue(msg.contains("Your order has been placed") ||
                        msg.contains("Order Placed"),
                "Order confirmation message not found. Actual: " + msg);
    }
}