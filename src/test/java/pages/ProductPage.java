package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{

    private final static String PRODUCT_BASE_ID = "add-to-cart-sauce-labs-";
    private final static String REMOVE_PRODUCT_BASE_ID = "remove-sauce-labs-";
    @FindBy(className = "product_sort_container")
    WebElement ProductSortButton;

    @FindBy(className = "shopping_cart_link")
    WebElement CartButton;

    @FindBy(className = "shopping_cart_badge")
    WebElement CartBadge;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public int getItemsInCart(){
        return Integer.parseInt(CartBadge.getText());
    }
    public void addToCart(String ItemName){
        WebElement itemToAdd = driver.findElement(By.id(PRODUCT_BASE_ID + ItemName));
        itemToAdd.click();
    }
    public void removeFromCart(String ItemName){
        WebElement itemToRemove = driver.findElement(By.id(REMOVE_PRODUCT_BASE_ID + ItemName));
        itemToRemove.click();
    }
    @Override
    public boolean isAt() {
        return ProductSortButton.isDisplayed();
    }
    public CartPage openBasket(){
        CartButton.click();
        return new CartPage(driver);
    }
}
