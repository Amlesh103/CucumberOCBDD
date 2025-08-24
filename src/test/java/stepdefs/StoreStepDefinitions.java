package stepdefs;

import awesomecucumber.apis.CartApi;
import awesomecucumber.constants.Endpoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.pages.PageObjectFactory;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StoreStepDefinitions {
    private final WebDriver driver;
    private TestContext context;
    private final StorePage storePage;
    public StoreStepDefinitions(TestContext context){
        driver = context.driver;
        this.context = context;
        storePage = PageObjectFactory.getStorePage(context.driver);
    }

    @Given("I am on the Store Page")
    public void i_am_on_the_store_page() {
        //    driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    //    storePage = new StorePage(driver);
        storePage.load(Endpoint.STORE.url);
    }
    @When("I add a {product} to the cart")
//@When("I add a (.*) to the cart")
    public void i_add_a_to_the_cart(Product product) throws InterruptedException {

        Thread.sleep(2000);
        storePage.addToCart(product.getName());
    }

    @Given("I have a product in the cart")
    public void i_have_a_product_in_the_cart() {
        driver.manage().window().maximize();
  //      storePage = new StorePage(driver);
        storePage.load(Endpoint.STORE.url);
   //     storePage.addToCart("Blue Shoes");
        CartApi cartApi = new CartApi(context.cookies.getCookies()); //initialize CartApi with cookies from context
        cartApi.addToCart(1215,2);
        context.cookies.setCookies(cartApi.getCookies()); //update cookies in context with cookies from CartApi in case there are any other API calls that might need this cookie
        context.cookies.injectCookiesToBrowser(driver); //inject cookies to browser so that we don't have to add product again and again using UI
    }
}
