package stepdefs;

import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.PageObjectFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartStepDefinitions {
//    private final WebDriver driver;
    private final CartPage cartPage;


    public CartStepDefinitions(TestContext context){
 //       driver = context.driver;
        cartPage = PageObjectFactory.getCartPage(context.driver);
    }

    @Then("I should see {product} in the cart")
//@Then("I should see (.*) in the cart")
    public void i_should_see_in_the_cart(Product product) {

        String actualProduct = cartPage.verifyProductInCart();

//        By quantityAdded = By.cssSelector("//input[@type= 'number']");
//        int actualQuantity = Integer.parseInt(driver.findElement(quantityAdded).getAttribute("value"));
//        System.out.println("quantity is " + driver.findElement(quantityAdded).getAttribute("value"));

        Assert.assertEquals(actualProduct, product.getName());
        //       Assert.assertEquals(actualQuantity, Quantity);

    }

}
