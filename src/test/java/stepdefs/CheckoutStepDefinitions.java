package stepdefs;

import awesomecucumber.constants.Endpoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.ConfirmationPage;
import awesomecucumber.pages.PageObjectFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutStepDefinitions {

    private final WebDriver driver;
  //  private BillingDetails billingDetails;
    TestContext context;
    private final CheckoutPage checkoutPage;
    private final ConfirmationPage confirmationPage;

    public CheckoutStepDefinitions(TestContext context){
        driver = context.driver;
        this.context = context;
        checkoutPage = PageObjectFactory.getCheckoutPage(context.driver);
        confirmationPage = PageObjectFactory.getConfirmationPage(context.driver);
//        this.billingDetails = context.billingDetails;
    }




    @When("I provide billing details")
    public void i_provide_billing_details()  {

       /*
        By firstNameField = By.id("billing_first_name");
        By lastNameField = By.id("billing_last_name");
      //  By countryField = By.xpath("//span[@id='select2-billing_country-container']");
        By countryDropdown = By.cssSelector("span#select2-billing_country-container");
        By countryInput = By.xpath("//input[@role='combobox']");
        //span[@id='select2-billing_country-container']
        By address = By.id("billing_address_1");
        By city = By.id("billing_city");
   //     By stateField = By.id("select2-billing_state-container");
        By stateField = By.cssSelector("span#select2-billing_state-container");
        By stateInput = By.xpath("//input[@role='combobox']");
        By zip = By.id("billing_postcode");
        By email = By.id("billing_email");

        */
   //     CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterBillingDetails(context.billingDetails);
/*
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(billingDetails.get(0).get("firstname"));
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(billingDetails.get(0).get("lastname"));
    //    Select country = new Select(driver.findElement(countryField));
    //    country.selectByVisibleText(billingDetails.get(0).get("country"));
        Thread.sleep(2000);
        driver.findElement(countryDropdown).click();
        driver.findElement(countryInput).sendKeys(billingDetails.get(0).get("country")+"\n");
        Thread.sleep(3000);

        driver.findElement(address).clear();
        driver.findElement(address).sendKeys(billingDetails.get(0).get("address_line1"));
        Thread.sleep(2000);

        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(billingDetails.get(0).get("city"));

        Thread.sleep(2000);
//        Select state = new Select(driver.findElement(stateField));
//        state.selectByVisibleText(billingDetails.get(0).get("state"));
        driver.findElement(stateField).click();
        driver.findElement(stateInput).sendKeys(billingDetails.get(0).get("state") + "\n");
        Thread.sleep(2000);
        driver.findElement(zip).clear();
        driver.findElement(zip).sendKeys(billingDetails.get(0).get("zip"));
        Thread.sleep(2000);
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(billingDetails.get(0).get("email"));
        Thread.sleep(2000);
*/
    }
    @When("I place an order")
    public void i_place_an_order() throws InterruptedException {

//        By placeOrderBtn = By.id("place_order");
//        driver.findElement(placeOrderBtn).click();
 //       new CheckoutPage(driver).placeOrder();
        checkoutPage.placeOrder();
   //     Thread.sleep(2000);
    }

    @Given("I am on the checkout page")
    public void i_am_on_the_checkout_page() {
        //     By checkoutBtn = By.xpath("//a[normalize-space()='Proceed to checkout']");
        //     driver.findElement(checkoutBtn).click();
        //  cartPage.proceedToCheckout();
        checkoutPage.load(Endpoint.CHECKOUT.url);

    }

    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {

        //    By message = By.cssSelector(".woocommerce-notice");
        //  String actualConfirmationMsg = driver.findElement(message).getText();
        Assert.assertEquals(confirmationPage.getConfirmationMessage(), "Thank you. Your order has been received.");
    }


}
