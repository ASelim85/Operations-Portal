package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends PageBase{
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public By btnProfile = By.xpath("(//button[@type='button'])[2]");
    public By btnRewards = By.xpath("//li[contains(@data-menu-id,'rewards')]");
    public By txtVolumeValue = By.xpath("//span[contains(@class,'volume-amount')]");
    public By txtVolumetarnscations = By.xpath("//span[contains(@class,'_volume-transaction')]");
    public By txtRevenueValue = By.xpath("//span[contains(@class,'revenue-amount')]");
    public By txtRevenueTrx = By.xpath("//span[contains(@class,'_revenue-transaction')]");

    public By txtCashInValue = By.xpath("//span[contains(@class,'_cashin-amount')]");
    public By txtCashInTrx = By.xpath("//span[contains(@class,'_cashin-transaction')]");
    public By txtCashOutValue = By.xpath("//span[contains(@class,'_cashout-amount')]");
    public By txtCashOutTrx = By.xpath("//span[contains(@class,'_cashout-transaction')]");

    public By txtRegisteredWallets = By.xpath("(//div[contains(@class,'_wallet-value')])[1]");
    public By txtPinSetWallets = By.xpath("(//div[contains(@class,'_wallet-value')])[2]");
    public By txtTotalWaleltsBalance = By.xpath("(//div[contains(@class,'_wallet-value')])[3]");
    public By txtQAW = By.xpath("(//div[contains(@class,'_wallet-value')])[4]");
    public By txtMAW = By.xpath("(//div[contains(@class,'_wallet-value')])[5]");
    public By txtDAW = By.xpath("(//div[contains(@class,'_wallet-value')])[6]");
    public By txtUnregisteredWallets = By.xpath("(//div[contains(@class,'_wallet-value')])[7]");


    public boolean isDashboardDisplayed(){
        waitElement(btnProfile);
        return action(btnProfile).isDisplayed();
    }

    public void clickRewards(){
        waitElement(btnRewards);
        click(btnRewards);
    }

    public boolean checkVolume(){
        waitElement(txtVolumeValue);
        return action(txtVolumeValue).isDisplayed();
    }

    public String getVolumePrevBalance() {
        waitElement(txtVolumeValue);
        String prevBalance = action(txtVolumeValue).getText();
        return prevBalance;
    }

    public boolean checkVolumeTrx(){
        waitElement(txtVolumetarnscations);
        return action(txtVolumetarnscations).isDisplayed();
    }

    public String getVolumePrevTrx() {
        waitElement(txtVolumetarnscations);
        String prevTrx = action(txtVolumetarnscations).getText();
        return prevTrx;
    }

    public boolean checkRevenue(){
        waitElement(txtRevenueValue);
        return action(txtRevenueValue).isDisplayed();
    }

    public String getRevenuePrevBalance() {
        waitElement(txtRevenueValue);
        String prevBalance = action(txtRevenueValue).getText();
        return prevBalance;
    }

    public boolean checkRevenueTrx(){
        waitElement(txtRevenueTrx);
        return action(txtRevenueTrx).isDisplayed();
    }

    public String getRevenuePrevTrx() {
        waitElement(txtRevenueTrx);
        String prevTrx = action(txtRevenueTrx).getText();
        return prevTrx;
    }

    public boolean checkCheckIn(){
        waitElement(txtCashInValue);
        return action(txtCashInValue).isDisplayed();
    }

    public String getCashInPrevBalance() {
        waitElement(txtCashInValue);
        String prevBalance = action(txtCashInValue).getText();
        return prevBalance;
    }

    public boolean checkCashInTrx(){
        waitElement(txtRevenueTrx);
        return action(txtRevenueTrx).isDisplayed();
    }

    public String getCashInPrevTrx() {
        waitElement(txtCashInTrx);
        String prevTrx = action(txtCashInTrx).getText();
        return prevTrx;
    }

    public boolean checkCashOut(){
        waitElement(txtCashOutValue);
        return action(txtCashOutValue).isDisplayed();
    }

    public String getCashOutPrevBalance() {
        waitElement(txtCashOutValue);
        String prevBalance = action(txtCashOutValue).getText();
        return prevBalance;
    }

    public boolean checkCashOutTrx(){
        waitElement(txtCashOutTrx);
        return action(txtCashOutTrx).isDisplayed();
    }

    public String getCashOutPrevTrx() {
        waitElement(txtCashOutTrx);
        String prevTrx = action(txtCashOutTrx).getText();
        return prevTrx;
    }

    public boolean checkRegisteredWalletsTrx(){
        waitElement(txtRegisteredWallets);
        return action(txtRegisteredWallets).isDisplayed();
    }

    public String getRegisteredWalletsPrevTrx() {
        waitElement(txtRegisteredWallets);
        String prevTrx = action(txtRegisteredWallets).getText();
        return prevTrx;
    }

    public boolean checkPinSet(){
        waitElement(txtPinSetWallets);
        return action(txtPinSetWallets).isDisplayed();
    }

    public String getPinSetPrevTrx() {
        waitElement(txtPinSetWallets);
        String prevTrx = action(txtPinSetWallets).getText();
        return prevTrx;
    }

    public boolean checkTotalWalletsBalance(){
        waitElement(txtTotalWaleltsBalance);
        return action(txtTotalWaleltsBalance).isDisplayed();
    }

    public String getTotalWalletsPrevBalance() {
        waitElement(txtTotalWaleltsBalance);
        String prevTrx = action(txtTotalWaleltsBalance).getText();
        return prevTrx;
    }

    public boolean checkQAW(){
        waitElement(txtQAW);
        return action(txtQAW).isDisplayed();
    }

    public String getQAWPrevTrx() {
        waitElement(txtQAW);
        String prevTrx = action(txtQAW).getText();
        return prevTrx;
    }

    public boolean checkMAW(){
        waitElement(txtMAW);
        return action(txtMAW).isDisplayed();
    }

    public String getMAWPrevTrx() {
        waitElement(txtMAW);
        String prevTrx = action(txtMAW).getText();
        return prevTrx;
    }

    public boolean checkDAW(){
        waitElement(txtDAW);
        return action(txtDAW).isDisplayed();
    }

    public String getDAWPrevTrx() {
        waitElement(txtDAW);
        String prevTrx = action(txtDAW).getText();
        return prevTrx;
    }

    public boolean checkUnregisteredWallets(){
        waitElement(txtDAW);
        return action(txtDAW).isDisplayed();
    }

    public String getUnregisteredWalletsPrevTrx() {
        waitElement(txtUnregisteredWallets);
        String prevTrx = action(txtUnregisteredWallets).getText();
        return prevTrx;
    }
}