package Tests;

import Pages.WalletProcessPage;
import org.testng.annotations.Test;

public class walletProcessTestCases extends TestBase {

    @Test(priority = 0, enabled = true)
    public void OpenWalletProcess() {
        loginTestCases.LoginWithValidCredentials();
        WalletProcessPage.clickWalletProcess();
        WalletProcessPage.addWalletNum();
        WalletProcessPage.addNIDlastDigits();
        WalletProcessPage.clickSubmitWalletNum();
    }
}