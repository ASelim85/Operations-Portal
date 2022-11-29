package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestCases extends TestBase {

    @Test //(priority = 0, enabled = true)
    public void LoginWithValidCredentials() throws IOException {
        loginPage.setUsername("Bankuser");
        loginPage.setPassword("P@ssw0rd");
        loginPage.clickSignIn();
        loginPage.setOTP("245345");
        loginPage.clickVerifyOTP();
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
        String test = dashboardPage.getDashBoardText();
        Assert.assertEquals(test, "Dashboard");
    }
}