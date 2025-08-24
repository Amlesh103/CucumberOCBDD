package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "td[class='product-name'] a")
    private WebElement productAdded;

    @FindBy(xpath = "//a[normalize-space()='Proceed to checkout']")
    private WebElement checkoutBtn;

    public String verifyProductInCart(){
        wait.until(ExpectedConditions.visibilityOf(productAdded));
        return productAdded.getText();
    }

    public void proceedToCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
    }
}
