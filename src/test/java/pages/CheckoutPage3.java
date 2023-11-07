package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage3 extends BasePage{
    @FindBy(id = "checkout_complete_container")
    WebElement CheckoutCompleteContainer;

    public CheckoutPage3(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public boolean isAt() {
        return CheckoutCompleteContainer.isDisplayed();
    }
}
