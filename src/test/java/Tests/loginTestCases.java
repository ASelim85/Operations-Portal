package Tests;

import Pages.DashboardPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginTestCases extends TestBase {
    static String Username = "selim";
    static String Password = "P@ssw0rd";
    
    @Test(priority = 0, enabled = true)
    public static void LoginWithValidCredentials() {
        LoginPage.setUsername(Username);
        LoginPage.setPassword(Password);
        LoginPage.clickSignIn();
        LoginPage.setOTP("245345");
        LoginPage.clickVerifyOTP();
        Assert.assertTrue(DashboardPage.isDashboardDisplayed());
        Assert.assertEquals(DashboardPage.getDashBoardText(), "Dashboard");
    }

    @Test(priority = 1, enabled = false)
    public void LoginWithInValidCredentials() {
        LoginPage.setUsername(Username);
        LoginPage.setPassword("P@ssw0rd1");
        LoginPage.clickSignIn();
        LoginPage.GetErrorMSG();
        Assert.assertEquals(LoginPage.GetErrorMSG(), "Invalid Login");
    }
}