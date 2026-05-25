package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;

    @FindBy(xpath = "//form[@action='https://tutorialsninja.com/demo/index.php?route=checkout/cart/edit']//tbody/tr")
    List<WebElement> cartRows;

    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement quantityInput;

    @FindBy(xpath = "//button[@data-original-title='Update']")
    WebElement updateCartButton;

    @FindBy(xpath = "(//button[@data-original-title='Remove'])[1]")
    WebElement removeFirstItemButton;

    @FindBy(xpath = ("(//table[@class='table table-bordered']//tr[1]//td[6])[2]"))
    WebElement totalAmount;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement checkoutButton;

    @FindBy(xpath = "(//p[text()='Your shopping cart is empty!'])[2]")
    WebElement emptyCartMessage;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getCartItemCount() {
        return cartRows.size();
    }

    public void updateQuantity(String quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
        updateCartButton.click();
    }

    public void removeFirstItem() {
        removeFirstItemButton.click();
    }

    public String getTotalAmount() {
        return totalAmount.getText();
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }

    public boolean isCartEmpty() {
        return emptyCartMessage.isDisplayed();
    }

}
