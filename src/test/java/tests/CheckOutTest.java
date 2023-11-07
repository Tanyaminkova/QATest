package tests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class CheckOutTest extends TestUtil {
    @BeforeMethod
    public void login(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart("onesie");
        productPage.addToCart("bike-light");
        productPage.openBasket();
    }

    @Test
    public void Checkout() {
        CartPage cartPage = new CartPage(driver);
        cartPage.cartContinue();

        CheckoutPage1 checkoutPage1 = new CheckoutPage1(driver);
        checkoutPage1.checkoutDetails("Tanya", "Minkova", "4000");

        CheckoutPage2 checkoutPage2 = new CheckoutPage2(driver);
        checkoutPage2.finishClick();

        CheckoutPage3 checkoutPage3 = new CheckoutPage3(driver);
        Assert.assertTrue(checkoutPage3.isAt());
    }
}
