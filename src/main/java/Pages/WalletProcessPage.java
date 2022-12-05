package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WalletProcessPage extends PageBase{
    public WalletProcessPage(WebDriver driver) {
        super(driver);
    }

    public By walletProcessesLink = By.linkText("Wallet Processes");
    public By WalletNum = By.id("walletNumber");
    public By NIDNum = By.id("nationalId");
    public By SubmitWalletNum = By.xpath("//button[@type='submit']");



    public void clickWalletProcess()
    {
        click(walletProcessesLink);
    }
}
