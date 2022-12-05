package Tests;

import Pages.WalletProcessPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class WalletProcessTestCases extends TestBase {
    String Username = "Bankuser";

    public WalletProcessTestCases(WebDriver driver) {
        super(driver);
    }

    @Test (priority = 0, enabled = true)
    public void OpenWalletProcess() throws IOException {
        loginPage.setUsername(Username);
        loginPage.setPassword("P@ssw0rd");
        loginPage.clickSignIn();
        loginPage.setOTP("245345");
        loginPage.clickVerifyOTP();
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
        String test = dashboardPage.getDashBoardText();
        Assert.assertEquals(test, "Dashboard");
    }
}