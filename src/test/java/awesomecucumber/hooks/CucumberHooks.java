/*

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

*/

package awesomecucumber.hooks;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {

    private final TestContext context;

    public CucumberHooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setup() {
        String browser = System.getProperty("browser", "chrome");
        boolean isRemote = Boolean.parseBoolean(System.getProperty("remote", "true"));
        String gridURL = System.getProperty("gridURL", "http://13.127.45.124:4444/wd/hub");

        WebDriver driver = new DriverFactory().createDriver(browser, isRemote, gridURL);
        context.setDriver(driver);
    }

    @After
    public void teardown() {
        if (context.getDriver() != null) {
            context.getDriver().quit();
        }
    }
}
