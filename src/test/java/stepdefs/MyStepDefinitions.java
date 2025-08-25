package stepdefs;

import awesomecucumber.constants.Endpoint;
import awesomecucumber.constants.MyConstants;
import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.factory.DriverFactory;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.ConfirmationPage;
import awesomecucumber.pages.StorePage;
import awesomecucumber.utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class MyStepDefinitions {

    private WebDriver driver;
//    BillingDetails billingDetails;


 //   StorePage storePage;
 //   CartPage cartPage;

    public MyStepDefinitions(TestContext context){
        this.driver = context.getDriver();
        System.out.println("Step Def: DI: Scenario Name -> " + context.scenarioName);
    }









}
