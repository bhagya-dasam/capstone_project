package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;
import org.testng.Assert;

public class SearchSteps {
    HomePage home = new HomePage(BaseTest.driver);
    SearchPage searchPage;

    @When("User searches for product {string}")
    public void user_searches(String product) {
        home.searchProduct(product);
        searchPage = new SearchPage(BaseTest.driver);
    }

    @Then("Search results should display at least one product")
    public void at_least_one_product() {
        Assert.assertTrue(searchPage.getProductCount() > 0);
    }

    @Then("No products message should appear")
    public void no_products_message() {
        Assert.assertTrue(searchPage.isNoProductMessageDisplayed());
    }

    @When("User clicks on the first product")
    public void click_first_product() {
        searchPage.clickFirstProduct();
    }

    @Then("Product details page should open")
    public void product_details_page() {
        Assert.assertTrue(BaseTest.driver.getCurrentUrl().contains("product_id"));
    }
}