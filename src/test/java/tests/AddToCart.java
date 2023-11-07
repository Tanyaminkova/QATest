package tests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class AddToCart extends TestUtil {
    @BeforeMethod
    public void login(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
    }

    @Test
    public void AddToCart(){
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart("bike-light");
        productPage.addToCart("onesie");

        Assert.assertEquals(productPage.getItemsInCart(),2,"ItemsAddedToBasket");
    }
}
