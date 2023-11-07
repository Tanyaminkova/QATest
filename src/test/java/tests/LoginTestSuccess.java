package tests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class LoginTestSuccess extends TestUtil {
    @Test(dataProvider = "correctUsers")
    public void SuccessfulLogin(String username,String password){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login(username,password);

        Assert.assertTrue(productPage.isAt());
    }
}
