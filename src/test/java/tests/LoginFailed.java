package tests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class LoginFailed extends TestUtil {
    @Test(dataProvider = "wrongUsers")
    public void FailedLogin(String username,String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);

        Assert.assertTrue(loginPage.isAt());
    }
}
