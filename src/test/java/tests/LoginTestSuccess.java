package tests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class LoginTestSuccess extends TestUtil {
    @Test
    public void SuccessfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user","secret_sauce");

        Assert.assertTrue(productPage.isAt());
    }
}
