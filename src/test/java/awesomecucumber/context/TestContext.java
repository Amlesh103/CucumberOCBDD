package awesomecucumber.context;

import awesomecucumber.domainobjects.BillingDetails;
import org.openqa.selenium.WebDriver;
import awesomecucumber.domainobjects.Cookies;

public class TestContext {

    public String scenarioName;
    public WebDriver driver;
    public BillingDetails billingDetails;
    public Cookies cookies;

    public TestContext(){
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies()); // Initialize with empty cookies as we can't have null cookies as we are logging in without user and it can throw null pointer exception
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }




}
