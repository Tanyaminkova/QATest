package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage2 extends BasePage{
    @FindBy(id = "finish")
    WebElement FinishButton;
    public CheckoutPage2(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public boolean isAt() {
        return FinishButton.isDisplayed();
    }
    public CheckoutPage3 finishClick(){
        FinishButton.click();
        return new CheckoutPage3(driver);
    }
}
