package Tests;

import Utils.ExcelFileManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login extends TestBase {

    @Test (priority = 0, enabled = true)
    public void LoginWithValid() throws IOException {
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