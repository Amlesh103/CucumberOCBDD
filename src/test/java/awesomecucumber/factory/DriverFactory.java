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

    //commenting this part for pico container
  //  private static final ThreadLocal<WebDriver> TLdriver = new ThreadLocal<>();
    private DriverFactory(){}
/*
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
*/
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
