package awesomecucumber.hooks;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import stepdefs.MyStepDefinitions;

public class CucumberHooks {
 WebDriver driver;
 private final TestContext context;
 public CucumberHooks(TestContext context){
    this.context = context; // we are injecting the value of TestContext class here
 }
    @Before
    public void setup(Scenario scenario){
     context.scenarioName = scenario.getName();
        System.out.println("DI scenario is- " + context.scenarioName);
        System.out.println("Before Scenario");
    //    driver=DriverFactory.getDriver();
        driver = DriverFactory.initializeDriver("chrome");
        context.driver = driver;  // we are setting the value of context driver(from TestContext class) as driver which we will later inject into different classes
    }

    @After
    public void tearDown(){
        System.out.println("After");
    //    DriverFactory.quitDriver();
        driver.quit();
    }
}
