package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {
	
	WebDriver driver;

    @FindBy(xpath = "//div[@class='table-responsive']//tbody//tr[1]")
    List<WebElement> wishlistRows;

    @FindBy(xpath = "(//a[@data-original-title=\"Remove\"])[1]")
    WebElement removeFirstItemButton;

    @FindBy(xpath = "(//button[@data-original-title='Add to Cart'])[1]")
    WebElement addToCartButtonFirstItem;

    @FindBy(xpath = "//p[text()='Your wish list is empty.']")
    WebElement emptyWishlistMessage;

    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueButton;

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getWishlistItemCount() {
        return wishlistRows.size();
    }

    public void removeFirstItem() {
        removeFirstItemButton.click();
    }

    public void addFirstItemToCart() {
        addToCartButtonFirstItem.click();
    }

    public boolean isWishlistEmpty() {
        try {
            return emptyWishlistMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickContinue() {
        continueButton.click();
    }

}
