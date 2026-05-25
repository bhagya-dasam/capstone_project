package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    WebElement address;

    @FindBy(xpath = "//input[@id='input-payment-city']")
    WebElement city;

    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    WebElement postcode;

    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement country;
    
    @FindBy(xpath = "//select[@name='zone_id']")
    WebElement region;

    @FindBy(xpath = "//input[@id='button-payment-address']")
    WebElement continueBilling;

    @FindBy(xpath = "//input[@id='button-shipping-address']")
    WebElement continueDelivery;

    @FindBy(xpath = "//input[@id='button-shipping-method']")
    WebElement continueShippingMethod;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement termsCheckbox;

    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continuePaymentMethod;

    @FindBy(xpath = "//input[@id='button-confirm']")
    WebElement confirmOrderButton;

    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement orderSuccessMessage;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void fillBillingDetails(String fName, String lName, 
                                   String addr, String cityName, String postCode, String countryName, String regionName) {

        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        address.sendKeys(addr);
        city.sendKeys(cityName);
        postcode.sendKeys(postCode);
        wait.until(ExpectedConditions.visibilityOf(country));
        new Select(country).selectByVisibleText(countryName);
        wait.until(ExpectedConditions.visibilityOf(region));
        new Select(region).selectByVisibleText(regionName);
    }

    public void clickContinueBilling() {
        continueBilling.click();
    }

    public void clickContinueDelivery() {
        wait.until(ExpectedConditions.elementToBeClickable(continueDelivery)).click();
    }

    public void clickContinueShippingMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShippingMethod)).click();
    }

    public void acceptTermsAndConditions() {
        wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox)).click();
    }

    public void clickContinuePaymentMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(continuePaymentMethod)).click();
    }

    public void clickConfirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton)).click();
    }

    public String getOrderSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(orderSuccessMessage));
        return orderSuccessMessage.getText();
    }
}