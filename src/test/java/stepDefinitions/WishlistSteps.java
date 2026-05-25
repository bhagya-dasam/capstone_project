package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import pages.WishlistPage;
import org.testng.Assert;

public class WishlistSteps {
    
    HomePage home;
    LoginPage loginPage;
    SearchPage searchPage;
    WishlistPage wishlistPage;
    
    private void initializePages() {
        home = new HomePage(BaseTest.driver);
        loginPage = new LoginPage(BaseTest.driver);
    }
    
    @Given("User adds a product to wishlist")
    public void add_product_to_wishlist() {
        initializePages();
        
        home.clickLogin();
        loginPage.enterEmail("bhagyadasam2@gmail.com");  
        loginPage.enterPassword("bhagya@123");            
        loginPage.clickLogin();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        home.searchProduct("iPhone");
        searchPage = new SearchPage(BaseTest.driver);
        searchPage.addFirstProductToWishlist();
    }
    
    @When("User navigates to wishlist page")
    public void go_to_wishlist() {
        if (home == null) {
            home = new HomePage(BaseTest.driver);
        }
        home.goToWishlist();
        wishlistPage = new WishlistPage(BaseTest.driver);
    }
    
    @Then("Product should be present in wishlist")
    public void product_should_be_present_in_wishlist() {
        if (wishlistPage == null) {
            wishlistPage = new WishlistPage(BaseTest.driver);
        }
        Assert.assertTrue(wishlistPage.getWishlistItemCount() > 0, 
            "Wishlist is empty, product not added successfully");
    }
    
    @When("User removes product from wishlist")
    public void user_removes_product_from_wishlist() {
        if (wishlistPage == null) {
            wishlistPage = new WishlistPage(BaseTest.driver);
        }
        wishlistPage.removeFirstItem();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Then("Wishlist should be empty")
    public void wishlist_should_be_empty() {
        if (wishlistPage == null) {
            wishlistPage = new WishlistPage(BaseTest.driver);
        }
        Assert.assertTrue(wishlistPage.isWishlistEmpty(), 
            "Wishlist is not empty after removal");
    }
    
    @Then("Wishlist page should show correct item details")
    public void wishlist_page_should_show_correct_item_details() {
        if (wishlistPage == null) {
            wishlistPage = new WishlistPage(BaseTest.driver);
        }
        Assert.assertTrue(wishlistPage.getWishlistItemCount() > 0, 
            "Wishlist page does not show any items");
    }
}