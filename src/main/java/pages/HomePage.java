package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccountDropdown;

    @FindBy(xpath = "//a[text()='Register']")
    WebElement registerLink;

    @FindBy(xpath = "//a[text()='Login']")
    WebElement loginLink;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutLink;

    @FindBy(xpath = "//input[@name='search']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement searchButton;

    @FindBy(xpath = "//a[@id='wishlist-total']")
    WebElement wishlistLink;

    @FindBy(xpath = "//span[text()='Shopping Cart']")
    WebElement cartLink;

    @FindBy(xpath = "//span[text()='Checkout']")
    WebElement checkoutLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickMyAccount() {
        myAccountDropdown.click();
    }

    public void clickRegister() {
        clickMyAccount();
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }

    public void clickLogin() {
        clickMyAccount();
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public void clickLogout() {
        clickMyAccount();
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }

    public boolean isLogoutLinkDisplayed() {
        clickMyAccount();
        try {
            return logoutLink.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void searchProduct(String productName) {
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchButton.click();
    }

    public void goToWishlist() {
        wait.until(ExpectedConditions.elementToBeClickable(wishlistLink)).click();
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }

    public void goToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutLink)).click();
    }
}