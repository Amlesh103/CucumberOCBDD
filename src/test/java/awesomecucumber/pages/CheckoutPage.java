package awesomecucumber.pages;

import awesomecucumber.domainobjects.BillingDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "billing_first_name") private WebElement firstNameField;
    @FindBy(id = "billing_last_name") private WebElement lastNameField;
    @FindBy(css = "span#select2-billing_country-container") private WebElement countryDropdown;
    @FindBy(xpath = "//input[@role='combobox']") private WebElement countryInput;
    @FindBy(id = "billing_address_1") private WebElement addressField;
    @FindBy(id = "billing_city") private WebElement city;
    @FindBy(css = "span#select2-billing_state-container") private WebElement stateField;
    @FindBy(xpath = "//input[@role='combobox']") private WebElement stateInput;
    @FindBy(id = "billing_postcode") private WebElement zip;
    @FindBy(id = "billing_email") private WebElement email;
    @FindBy(id = "place_order") private WebElement placeOrderBtn;


    public void enterBillingDetails(BillingDetails billingDetails) {
        firstNameField.clear();
        firstNameField.sendKeys(billingDetails.getBillingFirstName());

        lastNameField.clear();
        lastNameField.sendKeys(billingDetails.getBillingLastName());

        countryDropdown.click();
        countryInput.sendKeys(billingDetails.getBillingCountry() + "\n");

        addressField.clear();
        addressField.sendKeys(billingDetails.getBillingAddressLine1());

        city.clear();
        city.sendKeys(billingDetails.getBillingCity());

        stateField.click();
        stateInput.sendKeys(billingDetails.getBillingState() + "\n");

        zip.clear();
        zip.sendKeys(billingDetails.getBillingZip());

        email.clear();
        email.sendKeys(billingDetails.getBillingEmail());
    }

    public void placeOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }
}
