package stepdefs;

import awesomecucumber.constants.MyConstants;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.pages.PageObjectFactory;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CustomerStepDefinitions {
private final WebDriver driver;
//private  BillingDetails billingDetails;
private final StorePage storePage;
TestContext context;
    public CustomerStepDefinitions(TestContext context){
     driver = context.driver;
     this.context = context;
   //  this.billingDetails = context.billingDetails;
        storePage = PageObjectFactory.getStorePage(context.driver);
    }

    @Given("I am a guest customer")
    public void i_am_a_guest_customer() {
        //    driver = new ChromeDriver();
        //    driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
   //     storePage = new StorePage(driver);
        storePage.load(MyConstants.STORE);

    }

    @Given("my billing details are")
    public void my_billing_details_are(BillingDetails billingDetails) {

        context.billingDetails = billingDetails;
    }

}
