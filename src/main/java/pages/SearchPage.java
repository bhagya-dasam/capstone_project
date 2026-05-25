package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;

    @FindBy(xpath = "//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']")
    List<WebElement> productItems;

    @FindBy(xpath = "(//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//h4/a)[1]")
    WebElement firstProductTitle;

    @FindBy(xpath = "(//button[contains(@onclick, 'cart.add')])[1]")
    WebElement addToCartButtonFirstProduct;
    
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement innerAddToCart;

    @FindBy(xpath = "(//button[contains(@onclick, 'wishlist.add')])[1]")
    WebElement addToWishlistButtonFirstProduct;

    @FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
    WebElement noProductMessage;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getProductCount() {
        return productItems.size();
    }

    public void clickFirstProduct() {
        firstProductTitle.click();
    }

    public void addFirstProductToCart() {
        addToCartButtonFirstProduct.click();
    }
    
    public void innerAddToCart() {
    	innerAddToCart.click();
    }

    public void addFirstProductToWishlist() {
        addToWishlistButtonFirstProduct.click();
    }

    public boolean isNoProductMessageDisplayed() {
        return noProductMessage.isDisplayed();
    }

}
