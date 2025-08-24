package awesomecucumber.pages;

import awesomecucumber.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
   protected WebDriver driver;
   protected WebDriverWait wait;

   public BasePage(WebDriver driver){
       this.driver= driver;
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       PageFactory.initElements(driver, this);
   }

   public void load(String endpoint){
       driver.get(ConfigReader.getInstance().getBaseURL() + endpoint);
   }


}
