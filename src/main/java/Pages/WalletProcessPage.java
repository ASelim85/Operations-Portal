package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WalletProcessPage extends PageBase {
    public static By walletProcessesLink = By.linkText("Wallet Processes");
    public static By WalletNum = By.id("walletNumber");
    public static By NIDNum = By.id("nationalId");
    public static By SubmitWalletNum = By.xpath("//button[@type='submit']");
    public WalletProcessPage(WebDriver driver) {
        super(driver);
    }

    public static void clickWalletProcess() {
        click(walletProcessesLink);
    }

    public static void addWalletNum() {
        setText(WalletNum, "01110693883");
    }

    public static void addNIDlastDigits() {
        setText(NIDNum, "03883");
    }

    public static void clickSubmitWalletNum() {
        click(SubmitWalletNum);
    }
}
