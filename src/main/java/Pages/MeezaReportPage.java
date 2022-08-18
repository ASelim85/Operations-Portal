package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MeezaReportPage extends PageBase{
    public MeezaReportPage(WebDriver driver) {
        super(driver);
    }

    public By btnReports = By.xpath("//span[.='Reports']");
    public By btnMeezaReport = By.xpath("//a[@href='/meeza-settlement-report']");
    public By btnValues = By.xpath("//span[.='Values']");
    public By trxTransactions = By.xpath("(//h2[@class='ant-typography _header_1j4zp_8'])[1]");
    public By trxInterchangeDebit = By.xpath("(//h2[@class='ant-typography _header_1j4zp_8'])[2]");
    public By trxTotalDebit = By.xpath("(//h2[@class='ant-typography _header_1j4zp_8'])[3]");
    public By trxInterchangeCredit = By.xpath("(//h2[@class='ant-typography _header_1j4zp_8'])[4]");
    public By trxTotalCredit = By.xpath("(//h2[@class='ant-typography _header_1j4zp_8'])[5]");

    public By valTransactions = By.xpath("(//h2[@class='ant-typography _header_1j4zp_8'])[1]");
    public By valInterchangeDebit = By.xpath("(//h2[@class='ant-typography _header_1j4zp_8'])[2]");
    public By valTotalDebit = By.xpath("(//h2[@class='ant-typography _header_1j4zp_8'])[3]");
    public By valInterchangeCredit = By.xpath("(//h2[@class='ant-typography _header_1j4zp_8'])[4]");
    public By valTotalCredit = By.xpath("(//h2[@class='ant-typography _header_1j4zp_8'])[5]");
    public By valProcessingFees = By.xpath("(//h2[@class='ant-typography _header_1j4zp_8'])[6]");
    public By valNetPosition = By.xpath("(//h2[@class='ant-typography _header_1j4zp_8'])[7]");

    public void clickReports(){
        click(btnReports);
    }

    public void clickMeezaReport(){
        click(btnMeezaReport);
    }

    public void clickValues(){
        click(btnValues);
    }

    public String getTransactionPrevTrx(){
        waitElement(trxTransactions);
        String prevTransactionValue = action(trxTransactions).getText();
        return prevTransactionValue;
    }

    public String getInterchangeDebitPrevTrx(){
        waitElement(trxInterchangeDebit);
        String prevInterchangeDebitValue = action(trxInterchangeDebit).getText();
        return prevInterchangeDebitValue;
    }

    public String getTotalDebitTrx(){
        waitElement(trxTotalDebit);
        String prevTotalDebitValue = action(trxTotalDebit).getText();
        return prevTotalDebitValue;
    }

    public String getInterchangeCreditTrx(){
        waitElement(trxInterchangeCredit);
        String prevInterchangeCreditValue = action(trxInterchangeCredit).getText();
        return prevInterchangeCreditValue;
    }

    public String getTotalCreditPrevTrx(){
        waitElement(trxTotalCredit);
        String prevTotalCreditValue = action(trxTotalCredit).getText();
        return prevTotalCreditValue;
    }

    public String getTransactionPrevValue(){
        waitElement(valTransactions);
        String prevTransactionValue = action(valTransactions).getText();
        return prevTransactionValue;
    }

    public String getInterchangeDebitPrevValue(){
        waitElement(valInterchangeDebit);
        String prevInterchangeDebitValue = action(valInterchangeDebit).getText();
        return prevInterchangeDebitValue;
    }

    public String getTotalDebitValue(){
        waitElement(valTotalDebit);
        String prevTotalDebitValue = action(valTotalDebit).getText();
        return prevTotalDebitValue;
    }

    public String getInterchangeCreditValue(){
        waitElement(valInterchangeCredit);
        String prevInterchangeCreditValue = action(valInterchangeCredit).getText();
        return prevInterchangeCreditValue;
    }

    public String getTotalCreditPrevValue(){
        waitElement(valTotalCredit);
        String prevTotalCreditValue = action(valTotalCredit).getText();
        return prevTotalCreditValue;
    }

    public String getProcessingFeesPrevValue(){
        waitElement(valProcessingFees);
        String prevTotalProcessingFees = action(valProcessingFees).getText();
        return prevTotalProcessingFees;
    }

    public String getNetPositionPrevValue(){
        waitElement(valNetPosition);
        String prevNetPosition = action(valNetPosition).getText();
        return prevNetPosition;
    }

}
