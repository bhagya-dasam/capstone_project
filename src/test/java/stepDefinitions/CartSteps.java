package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.CartPage;
import pages.HomePage;
import pages.SearchPage;
import org.testng.Assert;

public class CartSteps {
    HomePage home = new HomePage(BaseTest.driver);
    CartPage cartPage;
    SearchPage searchPage;

    @Given("User adds a product to cart")
    public void add_to_cart() {
        home.searchProduct("HP LP3065");
        searchPage = new SearchPage(BaseTest.driver);
        searchPage.addFirstProductToCart();
        searchPage.innerAddToCart();
        
    }

    @When("User goes to cart page")
    public void user_goes_to_cart_page() {
        home.goToCart();
        cartPage = new CartPage(BaseTest.driver);
    }

    @Then("Product should be in cart")
    public void product_should_be_in_cart() {
        Assert.assertTrue(cartPage.getCartItemCount() > 0);
    }

    @When("User updates quantity to {string}")
    public void user_updates_quantity_to(String qty) {
        cartPage.updateQuantity(qty);
    }

    @Then("Cart total should be updated")
    public void cart_total_should_be_updated() {
        String total = cartPage.getTotalAmount();
        Assert.assertNotNull(total);
//        Assert.assertTrue();        
    }

    @When("User removes item from cart")
    public void user_removes_item_from_cart() {
        cartPage.removeFirstItem();
    }

    @Then("Cart should be empty")
    public void cart_should_be_empty() {
        Assert.assertTrue(cartPage.isCartEmpty());
    }
}