package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public class DashboardPage extends PageBase{
    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    public String BPAmount;
    public String BPCount;
    public String cashInAmount;
    public String cashInCount;

    public String cashOutAmount;
    public String cashOutCount;
    public String depositAmount;
    public String depositCount;
    public String IntRimAmount;
    public String IntRimCount;
    public String P2MAmount;
    public String P2MCount;

    public String P2PAmount;
    public String P2PCount;

    public By btnViewDetials = By.xpath("//span[contains(@class,'ant-typography _view-details-text_617v1_54')]");
    public static By txtDashboardTitle = By.xpath("//*[@id=\"root\"]/div/section/section/main/div/h1");
    public static By txtVolumeValue = By.xpath("//span[contains(@class,'volume-amount')]");
    public By txtVolumetarnscations = By.xpath("//span[contains(@class,'_volume-transaction')]");
    public By txtRevenueValue = By.xpath("//span[contains(@class,'revenue-amount')]");
    public By txtRevenueTrx = By.xpath("//span[contains(@class,'_revenue-transaction')]");
    public By txtCashInValue = By.xpath("//span[contains(@class,'_cashin-amount')]");
    public By txtCashInTrx = By.xpath("//span[contains(@class,'_cashin-transaction')]");
    public By txtCashOutValue = By.xpath("//span[contains(@class,'_cashout-amount')]");
    public By txtCashOutTrx = By.xpath("//span[contains(@class,'_cashout-transaction')]");
    public By txtRegisteredWallets = By.xpath("(//div[contains(@class,'_wallet-value')])[1]");
    public By txtPinSetWallets = By.xpath("(//div[contains(@class,'_wallet-value')])[2]");
    public By txtTotalWalletsBalance = By.xpath("(//div[contains(@class,'_wallet-value')])[3]");
    public By txtQAW = By.xpath("(//div[contains(@class,'_wallet-value')])[4]");
    public By txtMAW = By.xpath("(//div[contains(@class,'_wallet-value')])[5]");
    public By txtDAW = By.xpath("(//div[contains(@class,'_wallet-value')])[6]");
    public By txtUnregisteredWallets = By.xpath("(//div[contains(@class,'_wallet-value')])[7]");
    public By Value_BP = By.id("Bill Payments-ReportingType_BILL_PAYMENTS");
    public By Value_Cashin = By.id("Cash in-ReportingType_CASH_IN");
    public By Value_Cashout = By.id("Cash out-ReportingType_CASH_OUT");
    public By Value_Deposit = By.id("Deposit-ReportingType_DEPOSIT");
    public By Value_IntRim = By.id("International Remittance-ReportingType_INTERNATIONAL_REMITTANCE");
    public By Value_P2M = By.id("P2M-ReportingType_P2M");
    public By Value_P2P = By.id("P2P-ReportingType_P2P");

    public static boolean isDashboardDisplayed(){
        waitElement(txtDashboardTitle);
        return action(txtDashboardTitle).isDisplayed();
    }

    public static String getDashBoardText() {
        waitElement(txtDashboardTitle);
        String DashTitle = action(txtDashboardTitle).getText();
        return DashTitle;
    }
    public static boolean checkVolume(){
        waitElement(txtVolumeValue);
        return action(txtVolumeValue).isDisplayed();
    }

    public String getVolumeValue() {
        waitElement(txtVolumeValue);
        String VolumeValue = action(txtVolumeValue).getText().replaceAll(",","");
        return VolumeValue;
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

    public String getRevenueValue() {
        waitElement(txtRevenueValue);
        String RevenueValue = action(txtRevenueValue).getText().replaceAll(",","");
        return RevenueValue;
    }
    public boolean checkRevenueTrx(){
        waitElement(txtRevenueTrx);
        return action(txtRevenueTrx).isDisplayed();
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

    public String getCashOutValue() {
        waitElement(txtCashOutValue);
        String CashOutValue = action(txtCashOutValue).getText().replaceAll(",","");;
        return CashOutValue;
    }

    public boolean checkCashOutTrx(){
        waitElement(txtCashOutTrx);
        return action(txtCashOutTrx).isDisplayed();
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
        waitElement(txtTotalWalletsBalance);
        return action(txtTotalWalletsBalance).isDisplayed();
    }

    public String getTotalWalletsBalance() {
        waitElement(txtTotalWalletsBalance);
        String TotalWalletsBalance = action(txtTotalWalletsBalance).getText().replaceAll(",", "").replaceAll("EGP","");
        return TotalWalletsBalance;
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

    public void cLickViewDetials() {
        waitElement(btnViewDetials);
        click(btnViewDetials);
    }
    public String[] get_BPValue(){
        waitElement(Value_BP);
        String[] BPlines = action(Value_BP).getText().replaceAll("TXNS","").split(" ");
        BPAmount = BPlines[0];
        BPCount = BPlines[1];
        return new String[] {BPAmount, BPCount};
    }

    public String[] get_CashinValue(){
        waitElement(Value_Cashin);
        String[] cashInLines = action(Value_Cashin).getText().replaceAll("TXNS","").split(" ");
        cashInAmount = cashInLines[0]; // 004
        cashInCount = cashInLines[1];
        return new String[] {cashInAmount, cashInCount};
    }

    public String[] get_CashoutValue(){
        waitElement(Value_Cashout);
        String[] cashOutLines = action(Value_Cashout).getText().replaceAll("TXNS","").split(" ");
        cashOutAmount = cashOutLines[0]; // 004
        cashOutCount = cashOutLines[1];
        return new String[] {cashOutAmount, cashOutCount};
    }

    public String[] get_DepositValue(){
        waitElement(Value_Deposit);
        String[] depositLines = action(Value_Deposit).getText().replaceAll("TXNS","").split(" ");
        depositAmount = depositLines[0]; // 004
        depositCount = depositLines[1];
        return new String[] {depositAmount, depositCount};
    }

    public String[] get_IntRemittanceValue(){
        waitElement(Value_IntRim);
        String[] intRimLines = action(Value_IntRim).getText().replaceAll("TXNS","").split(" ");
        IntRimAmount = intRimLines[0]; // 004
        IntRimCount = intRimLines[1];
        return new String[] {IntRimAmount, IntRimCount};
    }
    public String[] get_P2MValue(){
        waitElement(Value_P2M);
        String[] intRimLines = action(Value_P2M).getText().replaceAll("TXNS","").split(" ");
        P2MAmount = intRimLines[0]; // 004
        P2MCount = intRimLines[1];
        return new String[] {P2MAmount, P2MCount};
    }

    public String[] get_P2PValue(){
        waitElement(Value_P2P);
        String[] intRimLines = action(Value_P2P).getText().replaceAll("TXNS","").split(" ");
        P2PAmount = intRimLines[0]; // 004
        P2PCount = intRimLines[1];
        return new String[] {P2PAmount, P2PCount};
    }
}