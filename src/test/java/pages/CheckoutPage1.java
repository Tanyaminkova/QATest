package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage1 extends BasePage{
    @FindBy(id = "first-name")
    WebElement firstnameinput;

    @FindBy(id = "last-name")
    WebElement lastnameinput;

    @FindBy(id = "postal-code")
    WebElement postalcodeinput;
    @FindBy(id = "continue")
    WebElement continuebutton;


    public CheckoutPage1(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public boolean isAt() {
        return firstnameinput.isDisplayed();
    }
    public CheckoutPage2 checkoutDetails (String firstname,String lastname,String postalcode){
        firstnameinput.click();
        firstnameinput.clear();
        firstnameinput.sendKeys(firstname);

        lastnameinput.click();
        lastnameinput.clear();
        lastnameinput.sendKeys(lastname);

        postalcodeinput.click();
        postalcodeinput.clear();
        postalcodeinput.sendKeys(postalcode);

        continuebutton.click();

        return new CheckoutPage2(driver);
    }
}
