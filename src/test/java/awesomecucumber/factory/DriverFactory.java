// commenting to include parallel grid browser testing
/*
package awesomecucumber.factory;

import awesomecucumber.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
/*
    private static volatile WebDriver driver =null;

    private DriverFactory() {
        // Private constructor to prevent instantiation
    }

    public static WebDriver initializeDriver(){
        if(driver ==null){
            synchronized(DriverFactory.class){
                if(driver == null){
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                }
            }
        }
        return driver;
    }
 public static WebDriver getDriver() {
        return driver;
    }

//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
*/
/*
import org.openqa.selenium.WebDriver;//commenting this part for pico container
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

//  private static final ThreadLocal<WebDriver> TLdriver = new ThreadLocal<>();
    private DriverFactory(){}

    public static WebDriver getDriver(){
        if(TLdriver.get() == null){
        //    String browser = ConfigReader.getInstance();
            String browser = System.getProperty("browser","chrome");
           WebDriver driver = initializeDriver(browser);
           TLdriver.set(driver);
            driver.manage().window().maximize();
        }
        return TLdriver.get();
    }

    public static void quitDriver(){
        if(TLdriver.get()!=null){
            TLdriver.get().quit();
            TLdriver.remove();
        }
    }

    public static WebDriver initializeDriver(String browser){
        WebDriver driver;
        switch(browser.toLowerCase()) {
            case "chrome" -> driver = new ChromeDriver();

            case "firefox" -> driver = new FirefoxDriver();

            default-> throw new IllegalStateException("Invalid Browser" + browser);
        }
        return driver;
    }


}

*/
//comment ended here, after this new code for grid testing

package awesomecucumber.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

  public class DriverFactory {

      public WebDriver createDriver(String browser, boolean isRemote, String gridURL) {
          WebDriver driver;

          if (isRemote) {
              try {
                  switch (browser.toLowerCase()) {
                      case "chrome" -> driver = new RemoteWebDriver(new URL(gridURL), new ChromeOptions());
                      case "firefox" -> driver = new RemoteWebDriver(new URL(gridURL), new FirefoxOptions());
                      default -> throw new IllegalStateException("Unsupported Browser: " + browser);
                  }
              } catch (MalformedURLException e) {
                  throw new RuntimeException("Invalid Grid URL: " + gridURL, e);
              }
          } else {
              // Local execution
              switch (browser.toLowerCase()) {
                  case "chrome" -> driver = new org.openqa.selenium.chrome.ChromeDriver();
                  case "firefox" -> driver = new org.openqa.selenium.firefox.FirefoxDriver();
                  default -> throw new IllegalStateException("Unsupported Browser: " + browser);
              }
          }

          driver.manage().window().maximize();
          return driver;
      }
  }
