package pages;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{
    @FindBy(id = "checkout")
    WebElement CheckoutButton;
    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public boolean isAt() {
        return CheckoutButton.isDisplayed();
    }
    public CheckoutPage1 cartContinue(){
        CheckoutButton.click();
        return new CheckoutPage1(driver);
    }
}
