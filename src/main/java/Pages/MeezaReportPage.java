package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

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

    public BigDecimal volume_GetTransaction(){
        waitElement(trxTransactions);
        String TransactionValue = action(trxTransactions).getText().replaceAll(",", "");
        BigDecimal finalTransactionValueBeforeTrx = new BigDecimal(TransactionValue);
        return finalTransactionValueBeforeTrx;
    }

    public BigDecimal volume_GetInterchangeDebit(){
        waitElement(trxInterchangeDebit);
        String InterchangeDebitVolume = action(trxInterchangeDebit).getText().replaceAll(",", "");
        BigDecimal decimalInterchangeDebitVolume = new BigDecimal(InterchangeDebitVolume);
        return decimalInterchangeDebitVolume;
    }

    public BigDecimal volume_GetTotalDebit(){
        waitElement(trxTotalDebit);
        String TotalDebitVolume = action(trxTotalDebit).getText().replaceAll(",","");
        BigDecimal decimalTotalDebitVolume = new BigDecimal(TotalDebitVolume);
        return decimalTotalDebitVolume;
    }

    public BigDecimal volume_GetInterchangeCredit(){
        waitElement(trxInterchangeCredit);
        String InterchangeCreditVolume = action(trxInterchangeCredit).getText().replaceAll(",","");
        BigDecimal decimalInterchangeCreditVolume = new BigDecimal(InterchangeCreditVolume);
        return decimalInterchangeCreditVolume;
    }

    public BigDecimal volume_GetTotalCredit(){
        waitElement(trxTotalCredit);
        String TotalCreditVolume = action(trxTotalCredit).getText().replaceAll(",","");
        BigDecimal decimalCreditVolume = new BigDecimal(TotalCreditVolume);
        return decimalCreditVolume;
    }



    public BigDecimal Value_GetTransactionValue(){
        waitElement(valTransactions);
        String TotalTransactionsValue = action(trxTotalCredit).getText().replaceAll("EGP","").replaceAll(",","");
        BigDecimal decimalTotalTransactionsValue = new BigDecimal(TotalTransactionsValue);
        return decimalTotalTransactionsValue;
    }

    public BigDecimal Value_GetInterchangeDebit(){
        waitElement(valInterchangeDebit);
        String InterchangeDebitValue = action(valInterchangeDebit).getText().replaceAll("EGP","").replaceAll(",","");
        BigDecimal decimalInterchangeDebitValue = new BigDecimal(InterchangeDebitValue);
        return decimalInterchangeDebitValue;
    }

    public BigDecimal value_getTotalDebit(){
        waitElement(valTotalDebit);
        String TotalDebitValue = action(valTotalDebit).getText().replaceAll("EGP","").replaceAll(",","");
        BigDecimal decimalTotalDebitValue = new BigDecimal(TotalDebitValue);
        return decimalTotalDebitValue;
    }

    public BigDecimal value_GetInterchangeCredit(){
        waitElement(valInterchangeCredit);
        String InterchangeCreditValue = action(valInterchangeCredit).getText().replaceAll("EGP","").replaceAll(",","");
        BigDecimal decimalInterchangeCreditValue = new BigDecimal(InterchangeCreditValue);
        return decimalInterchangeCreditValue;
    }

    public BigDecimal value_GetTotalCredit(){
        waitElement(valTotalCredit);
        String TotalCreditValue = action(valTotalCredit).getText().replaceAll("EGP","").replaceAll(",","");
        BigDecimal decimalTotalCreditValue = new BigDecimal(TotalCreditValue);
        return decimalTotalCreditValue;
    }

    public BigDecimal value_GetProcessingFees(){
        waitElement(valProcessingFees);
        String TotalProcessingFees = action(valProcessingFees).getText().replaceAll("EGP","").replaceAll(",","");
        BigDecimal decimalTotalProcessingFees = new BigDecimal(TotalProcessingFees);
        return decimalTotalProcessingFees;
    }

    public BigDecimal value_GetNetPosition(){
        waitElement(valNetPosition);
        String TotalNetPosition = action(valNetPosition).getText().replaceAll("EGP","").replaceAll(",","");
        BigDecimal decimalTotalNetPosition = new BigDecimal(TotalNetPosition);
        return decimalTotalNetPosition;
    }
}
