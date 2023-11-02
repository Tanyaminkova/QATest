package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    @FindBy(id = "user-name")
    WebElement UserNameInput;
    @FindBy(id = "password")
    WebElement PasswordInput;
    @FindBy(id = "login-button")
    WebElement LoginButton;
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public boolean isAt() {
        return LoginButton.isDisplayed();
    }

    public ProductPage login(String username, String password){
        UserNameInput.click();
        UserNameInput.clear();
        UserNameInput.sendKeys(username);

        PasswordInput.click();
        PasswordInput.clear();
        PasswordInput.sendKeys(password);

        LoginButton.click();

        return new ProductPage(driver);
    }
}
