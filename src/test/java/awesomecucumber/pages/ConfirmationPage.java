package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmationPage extends BasePage{
    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".woocommerce-notice") private WebElement message;

    public String getConfirmationMessage() {
        wait.until(ExpectedConditions.visibilityOf(message));
        return message.getText();
    }


}
