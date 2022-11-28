package Tests;

import APIS.*;
import Utils.ExcelFileManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;

public class MeezaSettlementReport extends TestBase {

    P2P p2p = new P2P();
    ATM_CashOut ATMCashOut = new ATM_CashOut();
    ATM_CahIn ATMCashIN =new ATM_CahIn();
    Deposit deposit = new Deposit();
    Agent_CashIn agentCashIn = new Agent_CashIn();
    Generate_OTP generateOtp = new Generate_OTP();
    Agent_CashOut agentCashOut = new Agent_CashOut();
    IMT Imt = new IMT();
    @Test (priority = 0, enabled = true)
    public void Receive_P2P_OffUs() throws IOException, ParseException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //VOLUMES
        //Transactions
        String finalTransactionsVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTransaction().add(new BigDecimal(1)));
        System.out.println("Transactions: " + finalTransactionsVolumeBeforeTrx);

        //Interchange Debit
        String finalInterchangeDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("Interchange Debit: " + finalInterchangeDebitVolumeBeforeTrx);

        //Total Debit
        String finalTotalDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("Total Debit: " + finalTotalDebitVolumeBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit().add(new BigDecimal(1)));
        System.out.println("finalInterchangeCreditVolumeBeforeTrx: " + finalInterchangeCreditVolumeBeforeTrx);

        //Total Credit
        String finalTotalCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit().add(new BigDecimal(1)));
        System.out.println("finalTotalCreditVolumeBeforeTrx: " + finalTotalCreditVolumeBeforeTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String finalTransactionsValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue().add(new BigDecimal(11)));
        System.out.println("finalTransactionsValueBeforeTrx: " + finalTransactionsValueBeforeTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueBeforeTrx: " + finalInterchangeDebitValueBeforeTrx);

        //Total Debit
        String finalTotalDebitValueBeforeTrx = String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueBeforeTrx: " + finalTotalDebitValueBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit().add(new BigDecimal(1)));
        System.out.println("finalInterchangeCreditBeforeTrx: " + finalInterchangeCreditBeforeTrx);

        //Total Credit
        String finalTotalCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetTotalCredit().add(new BigDecimal(11)));
        System.out.println("finalTotalCreditBeforeTrx: " + finalTotalCreditBeforeTrx);

        //Processing Fees
        double finalProcessingFeesBeforeTrx = meezaReportPage.value_GetProcessingFees().add(new BigDecimal(1)).doubleValue();
        System.out.println("finalProcessingFeesBeforeTrx: " + finalProcessingFeesBeforeTrx);

        //Net Position
        String finalNetPositionBeforeTrx = String.valueOf(meezaReportPage.value_GetNetPosition().add(new BigDecimal(11)));
        System.out.println("finalNetPositionBeforeTrx: " + finalNetPositionBeforeTrx);

        p2p.Receieve_P2P_OffUs();
        p2p.Receieve_P2P_OffUs_Advice();
        refresh();

        //VOLUMES After
        //Transactions
        String finalTransactionsVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTransaction());
        System.out.println("finalTransactionsVolumeAfterTrx " + finalTransactionsVolumeAfterTrx);

        //Interchange Debit
        String finalInterchangeDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitVolumeAfterTrx " + finalInterchangeDebitVolumeAfterTrx);

        //Total Debit
        String finalTotalDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("finalTotalDebitVolumeAfterTrx " + finalTotalDebitVolumeAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeAfterTrx: " + finalInterchangeCreditVolumeAfterTrx);

        //Total Credit
        String finalTotalCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeAfterTrx: " + finalTotalCreditVolumeAfterTrx);


        Assert.assertEquals(finalTransactionsVolumeAfterTrx, finalTransactionsVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitVolumeAfterTrx, finalInterchangeDebitVolumeBeforeTrx);
        Assert.assertEquals(finalTotalDebitVolumeAfterTrx, finalTotalDebitVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditVolumeAfterTrx, finalInterchangeCreditVolumeBeforeTrx);
        Assert.assertEquals(finalTotalCreditVolumeAfterTrx, finalTotalCreditVolumeBeforeTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values After
        //Transactions
        String finalTransactionsValueAfterTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueAfterTrx: " + finalTransactionsValueAfterTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueAfterTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueAfterTrx: " + finalInterchangeDebitValueAfterTrx);

        //Total Debit
        String finalTotalDebitValueAfterTrx = String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueAfterTrx: " + finalTotalDebitValueAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditValueAfterTrx: " + finalInterchangeCreditValueAfterTrx);

        //Total Credit
        String finalTotalCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditValueAfterTrx: " + finalTotalCreditValueAfterTrx);

        //Processing Fees
        double finalProcessingFeesValueAfterTrx = meezaReportPage.value_GetProcessingFees().doubleValue();
        System.out.println("finalProcessingFeesValueAfterTrx: " + finalProcessingFeesValueAfterTrx);

        //Net Position
        String finalNetPositionValueAfterTrx = String.valueOf(meezaReportPage.value_GetNetPosition());
        System.out.println("finalNetPositionValueAfterTrx: " + finalNetPositionValueAfterTrx);

        Assert.assertEquals(finalTransactionsValueAfterTrx, finalTransactionsValueBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitValueAfterTrx, finalInterchangeDebitValueBeforeTrx);
        Assert.assertEquals(finalTotalDebitValueAfterTrx, finalTotalDebitValueBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditValueAfterTrx, finalInterchangeCreditBeforeTrx);
        Assert.assertEquals(finalTotalCreditValueAfterTrx, finalTotalCreditBeforeTrx);
        Assert.assertEquals(finalProcessingFeesValueAfterTrx, finalProcessingFeesBeforeTrx);
        Assert.assertEquals(finalNetPositionValueAfterTrx, finalNetPositionBeforeTrx);
        driver.quit();
    }

    @Test(priority = 1, enabled = true)
    public void Send_P2P_OffUs() throws IOException, ParseException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //Get VOLUMES Numbers
        //Transactions
        String finalTransactionsVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTransaction().add(new BigDecimal(1)));
        System.out.println("Transactions: " + finalTransactionsVolumeBeforeTrx);

        //Interchange Debit
        String finalInterchangeDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit().add(new BigDecimal(1)));
        System.out.println("Interchange Debit: " + finalInterchangeDebitVolumeBeforeTrx);

        //Total Debit
        String finalTotalDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit().add(new BigDecimal(1)));
        System.out.println("Total Debit: " + finalTotalDebitVolumeBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeBeforeTrx: " + finalInterchangeCreditVolumeBeforeTrx);

        //Total Credit
        String finalTotalCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeBeforeTrx: " + finalTotalCreditVolumeBeforeTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String finalTransactionsValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueBeforeTrx: " + finalTransactionsValueBeforeTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit().add(new BigDecimal(1)));
        System.out.println("finalInterchangeDebitValueBeforeTrx: " + finalInterchangeDebitValueBeforeTrx);

        //Total Debit
        String finalTotalDebitValueBeforeTrx = String.valueOf(meezaReportPage.value_getTotalDebit().add(new BigDecimal(11)));
        System.out.println("finalTotalDebitValueBeforeTrx: " + finalTotalDebitValueBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditBeforeTrx: " + finalInterchangeCreditBeforeTrx);

        //Total Credit
        String finalTotalCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditBeforeTrx: " + finalTotalCreditBeforeTrx);

        //Processing Fees
        double finalProcessingFeesBeforeTrx = meezaReportPage.value_GetProcessingFees().add(new BigDecimal(1)).doubleValue();
        System.out.println("finalProcessingFeesBeforeTrx: " + finalProcessingFeesBeforeTrx);

        //Net Position
        String finalNetPositionBeforeTrx = String.valueOf(meezaReportPage.value_GetNetPosition().subtract(new BigDecimal(11)));
        System.out.println("finalNetPositionBeforeTrx: " + finalNetPositionBeforeTrx);

        p2p.Send_P2P_OffUs();
        p2p.Send_P2P_OffUs_Advice();
        refresh();

        //Get VOLUMES After execute P2P transaction
        //Transactions
        String finalTransactionsVolumeAfterTrx= String.valueOf(meezaReportPage.volume_GetTransaction());
        System.out.println("finalTransactionsVolumeAfterTrx "+finalTransactionsVolumeAfterTrx);

        //InterChagedebit
        String finalInterchangeDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitVolumeAfterTrx "+finalInterchangeDebitVolumeAfterTrx);

        //Total Debit
        String finalTotalDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("finalTotalDebitVolumeAfterTrx "+finalTotalDebitVolumeAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeAfterTrx: " + finalInterchangeCreditVolumeAfterTrx);

        //Total Credit
        String finalTotalCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeAfterTrx: " + finalTotalCreditVolumeAfterTrx);

        Assert.assertEquals(finalTransactionsVolumeAfterTrx,finalTransactionsVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitVolumeAfterTrx,finalInterchangeDebitVolumeBeforeTrx);
        Assert.assertEquals(finalTotalDebitVolumeAfterTrx,finalTotalDebitVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditVolumeAfterTrx,finalInterchangeCreditVolumeBeforeTrx);
        Assert.assertEquals(finalTotalCreditVolumeAfterTrx,finalTotalCreditVolumeBeforeTrx);

        //Click Values
        meezaReportPage.clickValues();

        //Values After execute P2P transaction
        //Transactions
        String finalTransactionsValueAfterTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueAfterTrx: " + finalTransactionsValueAfterTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueAfterTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueAfterTrx: " + finalInterchangeDebitValueAfterTrx);

        //Total Debit
        String finalTotalDebitValueAfterTrx = String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueAfterTrx: " + finalTotalDebitValueAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditValueAfterTrx: " + finalInterchangeCreditValueAfterTrx);

        //Total Credit
        String finalTotalCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditValueAfterTrx: " + finalTotalCreditValueAfterTrx);

        //Processing Fees
        double finalProcessingFeesValueAfterTrx = meezaReportPage.value_GetProcessingFees().doubleValue();
        System.out.println("finalProcessingFeesValueAfterTrx: " + finalProcessingFeesValueAfterTrx);

        //Net Position
        String finalNetPositionValueAfterTrx = String.valueOf(meezaReportPage.value_GetNetPosition());
        System.out.println("finalNetPositionValueAfterTrx: " + finalNetPositionValueAfterTrx);


        Assert.assertEquals(finalTransactionsValueAfterTrx,finalTransactionsValueBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitValueAfterTrx,finalInterchangeDebitValueBeforeTrx);
        Assert.assertEquals(finalTotalDebitValueAfterTrx,finalTotalDebitValueBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditValueAfterTrx,finalInterchangeCreditBeforeTrx);
        Assert.assertEquals(finalTotalCreditValueAfterTrx,finalTotalCreditBeforeTrx);
        Assert.assertEquals(finalProcessingFeesValueAfterTrx,finalProcessingFeesBeforeTrx);
        Assert.assertEquals(finalNetPositionValueAfterTrx,finalNetPositionBeforeTrx);
        driver.quit();

    }


    @Test (priority = 2, enabled = true)
    public void ATM_CashOut_OffUs() throws IOException, ParseException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //Get VOLUMES Numbers
        //Transactions
        String finalTransactionsVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTransaction().add(new BigDecimal(1)));
        System.out.println("Transactions: " + finalTransactionsVolumeBeforeTrx);

        //Interchange Debit
        String finalInterchangeDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit().add(new BigDecimal(1)));
        System.out.println("Interchange Debit: " + finalInterchangeDebitVolumeBeforeTrx);

        //Total Debit
        String finalTotalDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit().add(new BigDecimal(1)));
        System.out.println("Total Debit: " + finalTotalDebitVolumeBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeBeforeTrx: " + finalInterchangeCreditVolumeBeforeTrx);

        //Total Credit
        String finalTotalCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeBeforeTrx: " + finalTotalCreditVolumeBeforeTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String finalTransactionsValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueBeforeTrx: " + finalTransactionsValueBeforeTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit().add(new BigDecimal(1)));
        System.out.println("finalInterchangeDebitValueBeforeTrx: " + finalInterchangeDebitValueBeforeTrx);

        //Total Debit
        String finalTotalDebitValueBeforeTrx = String.valueOf(meezaReportPage.value_getTotalDebit().add(new BigDecimal(11)));
        System.out.println("finalTotalDebitValueBeforeTrx: " + finalTotalDebitValueBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditBeforeTrx: " + finalInterchangeCreditBeforeTrx);

        //Total Credit
        String finalTotalCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditBeforeTrx: " + finalTotalCreditBeforeTrx);

        //Processing Fees
        double finalProcessingFeesBeforeTrx = meezaReportPage.value_GetProcessingFees().add(new BigDecimal(1)).doubleValue();
        System.out.println("finalProcessingFeesBeforeTrx: " + finalProcessingFeesBeforeTrx);

        //Net Position
        String finalNetPositionBeforeTrx = String.valueOf(meezaReportPage.value_GetNetPosition().subtract(new BigDecimal(11)));
        System.out.println("finalNetPositionBeforeTrx: " + finalNetPositionBeforeTrx);

        ATMCashOut.ATM_CashOut();
        ATMCashOut.ATM_CashOut_Advice();
        refresh();

        //Get VOLUMES After execute ATM_CashOut transaction
        //Transactions
        String finalTransactionsVolumeAfterTrx= String.valueOf(meezaReportPage.volume_GetTransaction());
        System.out.println("finalTransactionsVolumeAfterTrx "+finalTransactionsVolumeAfterTrx);

        //InterChagedebit
        String finalInterchangeDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitVolumeAfterTrx "+finalInterchangeDebitVolumeAfterTrx);

        //Total Debit
        String finalTotalDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("finalTotalDebitVolumeAfterTrx "+finalTotalDebitVolumeAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeAfterTrx: " + finalInterchangeCreditVolumeAfterTrx);

        //Total Credit
        String finalTotalCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeAfterTrx: " + finalTotalCreditVolumeAfterTrx);

        Assert.assertEquals(finalTransactionsVolumeAfterTrx,finalTransactionsVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitVolumeAfterTrx,finalInterchangeDebitVolumeBeforeTrx);
        Assert.assertEquals(finalTotalDebitVolumeAfterTrx,finalTotalDebitVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditVolumeAfterTrx,finalInterchangeCreditVolumeBeforeTrx);
        Assert.assertEquals(finalTotalCreditVolumeAfterTrx,finalTotalCreditVolumeBeforeTrx);


        //Click Values
        meezaReportPage.clickValues();

        //Values After execute P2P transaction
        //Transactions
        String finalTransactionsValueAfterTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueAfterTrx: " + finalTransactionsValueAfterTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueAfterTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueAfterTrx: " + finalInterchangeDebitValueAfterTrx);

        //Total Debit
        String finalTotalDebitValueAfterTrx = String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueAfterTrx: " + finalTotalDebitValueAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditValueAfterTrx: " + finalInterchangeCreditValueAfterTrx);

        //Total Credit
        String finalTotalCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditValueAfterTrx: " + finalTotalCreditValueAfterTrx);

        //Processing Fees
        double finalProcessingFeesValueAfterTrx = meezaReportPage.value_GetProcessingFees().doubleValue();
        System.out.println("finalProcessingFeesValueAfterTrx: " + finalProcessingFeesValueAfterTrx);

        //Net Position
        String finalNetPositionValueAfterTrx = String.valueOf(meezaReportPage.value_GetNetPosition());
        System.out.println("finalNetPositionValueAfterTrx: " + finalNetPositionValueAfterTrx);


        Assert.assertEquals(finalTransactionsValueAfterTrx,finalTransactionsValueBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitValueAfterTrx,finalInterchangeDebitValueBeforeTrx);
        Assert.assertEquals(finalTotalDebitValueAfterTrx,finalTotalDebitValueBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditValueAfterTrx,finalInterchangeCreditBeforeTrx);
        Assert.assertEquals(finalTotalCreditValueAfterTrx,finalTotalCreditBeforeTrx);
        Assert.assertEquals(finalProcessingFeesValueAfterTrx,finalProcessingFeesBeforeTrx);
        Assert.assertEquals(finalNetPositionValueAfterTrx,finalNetPositionBeforeTrx);
        driver.quit();
    }

    @Test (priority = 3, enabled = true)
    public void ATM_CashOut_OffUs_Reversal() throws IOException, ParseException {
              loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //Get VOLUMES Numbers
        //Transactions
        String finalTransactionsVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTransaction().add(new BigDecimal(1)));
        System.out.println("Transactions: " + finalTransactionsVolumeBeforeTrx);

        //Interchange Debit
        String finalInterchangeDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("Interchange Debit: " + finalInterchangeDebitVolumeBeforeTrx);

        //Total Debit
        String finalTotalDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("Total Debit: " + finalTotalDebitVolumeBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit().add(new BigDecimal(1)));
        System.out.println("finalInterchangeCreditVolumeBeforeTrx: " + finalInterchangeCreditVolumeBeforeTrx);

        //Total Credit
        String finalTotalCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit().add(new BigDecimal(1)));
        System.out.println("finalTotalCreditVolumeBeforeTrx: " + finalTotalCreditVolumeBeforeTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String finalTransactionsValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue().add(new BigDecimal(11)));
        System.out.println("finalTransactionsValueBeforeTrx: " + finalTransactionsValueBeforeTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueBeforeTrx: " + finalInterchangeDebitValueBeforeTrx);

        //Total Debit
        String finalTotalDebitValueBeforeTrx = String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueBeforeTrx: " + finalTotalDebitValueBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit().add(new BigDecimal(1)));
        System.out.println("finalInterchangeCreditBeforeTrx: " + finalInterchangeCreditBeforeTrx);

        //Total Credit
        String finalTotalCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetTotalCredit().add(new BigDecimal(11)));
        System.out.println("finalTotalCreditBeforeTrx: " + finalTotalCreditBeforeTrx);

        //Processing Fees
        double finalProcessingFeesBeforeTrx = meezaReportPage.value_GetProcessingFees().add(new BigDecimal(1)).doubleValue();
        System.out.println("finalProcessingFeesBeforeTrx: " + finalProcessingFeesBeforeTrx);

        //Net Position
        String finalNetPositionBeforeTrx = String.valueOf(meezaReportPage.value_GetNetPosition().add(new BigDecimal(11)));
        System.out.println("finalNetPositionBeforeTrx: " + finalNetPositionBeforeTrx);

//        cashout.ATM_CashOut();
//        cashout.ATM_CashOut_Advice();
        ATMCashOut.ATM_CashOut_Reversal();
        refresh();

        //Get VOLUMES After execute ATM_CashOut_Reversal transaction
        //Transactions
        String finalTransactionsVolumeAfterTrx= String.valueOf(meezaReportPage.volume_GetTransaction());
        System.out.println("finalTransactionsVolumeAfterTrx "+finalTransactionsVolumeAfterTrx);

        //InterChagedebit
        String finalInterchangeDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitVolumeAfterTrx "+finalInterchangeDebitVolumeAfterTrx);

        //Total Debit
        String finalTotalDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("finalTotalDebitVolumeAfterTrx "+finalTotalDebitVolumeAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeAfterTrx: " + finalInterchangeCreditVolumeAfterTrx);

        //Total Credit
        String finalTotalCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeAfterTrx: " + finalTotalCreditVolumeAfterTrx);

        Assert.assertEquals(finalTransactionsVolumeAfterTrx,finalTransactionsVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitVolumeAfterTrx,finalInterchangeDebitVolumeBeforeTrx);
        Assert.assertEquals(finalTotalDebitVolumeAfterTrx,finalTotalDebitVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditVolumeAfterTrx,finalInterchangeCreditVolumeBeforeTrx);
        Assert.assertEquals(finalTotalCreditVolumeAfterTrx,finalTotalCreditVolumeBeforeTrx);


        //Click Values
        meezaReportPage.clickValues();

        //Values After execute P2P transaction
        //Transactions
        String finalTransactionsValueAfterTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueAfterTrx: " + finalTransactionsValueAfterTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueAfterTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueAfterTrx: " + finalInterchangeDebitValueAfterTrx);

        //Total Debit
        String finalTotalDebitValueAfterTrx = String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueAfterTrx: " + finalTotalDebitValueAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditValueAfterTrx: " + finalInterchangeCreditValueAfterTrx);

        //Total Credit
        String finalTotalCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditValueAfterTrx: " + finalTotalCreditValueAfterTrx);

        //Processing Fees
        double finalProcessingFeesValueAfterTrx = meezaReportPage.value_GetProcessingFees().doubleValue();
        System.out.println("finalProcessingFeesValueAfterTrx: " + finalProcessingFeesValueAfterTrx);

        //Net Position
        String finalNetPositionValueAfterTrx = String.valueOf(meezaReportPage.value_GetNetPosition());
        System.out.println("finalNetPositionValueAfterTrx: " + finalNetPositionValueAfterTrx);


        Assert.assertEquals(finalTransactionsValueAfterTrx,finalTransactionsValueBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitValueAfterTrx,finalInterchangeDebitValueBeforeTrx);
        Assert.assertEquals(finalTotalDebitValueAfterTrx,finalTotalDebitValueBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditValueAfterTrx,finalInterchangeCreditBeforeTrx);
        Assert.assertEquals(finalTotalCreditValueAfterTrx,finalTotalCreditBeforeTrx);
        Assert.assertEquals(finalProcessingFeesValueAfterTrx,finalProcessingFeesBeforeTrx);
        Assert.assertEquals(finalNetPositionValueAfterTrx,finalNetPositionBeforeTrx);
        driver.quit();
       }


    @Test (priority = 2, enabled = true)
    public void Receive_ATM_Cash_In_OffUS() throws IOException, ParseException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //Get VOLUMES Numbers
        //Transactions
        String finalTransactionsVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTransaction().add(new BigDecimal(1)));
        System.out.println("Transactions: " + finalTransactionsVolumeBeforeTrx);

        //Interchange Debit
        String finalInterchangeDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("Interchange Debit: " + finalInterchangeDebitVolumeBeforeTrx);

        //Total Debit
        String finalTotalDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("Total Debit: " + finalTotalDebitVolumeBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeBeforeTrx: " + finalInterchangeCreditVolumeBeforeTrx);

        //Total Credit
        String finalTotalCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeBeforeTrx: " + finalTotalCreditVolumeBeforeTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String finalTransactionsValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueBeforeTrx: " + finalTransactionsValueBeforeTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueBeforeTrx =
                String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueBeforeTrx: " + finalInterchangeDebitValueBeforeTrx);

        //Total Debit
        String finalTotalDebitValueBeforeTrx =
                String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueBeforeTrx: " + finalTotalDebitValueBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditBeforeTrx =
                String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditBeforeTrx: " + finalInterchangeCreditBeforeTrx);

        //Total Credit
        String finalTotalCreditBeforeTrx =
                String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditBeforeTrx: " + finalTotalCreditBeforeTrx);

        //Processing Fees
        double finalProcessingFeesBeforeTrx =
                meezaReportPage.value_GetProcessingFees().add(new BigDecimal(1)).doubleValue();
        System.out.println("finalProcessingFeesBeforeTrx: " + finalProcessingFeesBeforeTrx);

        //Net Position
        String finalNetPositionBeforeTrx = String.valueOf(meezaReportPage.value_GetNetPosition());
        System.out.println("finalNetPositionBeforeTrx: " + finalNetPositionBeforeTrx);

        generateOtp.Generate_OTP();
        ATMCashIN.Receive_ATM_Cash_In_Off_US();
        ATMCashIN.Receive_ATM_Cash_In_Advice_Off_US();
        refresh();

        //Get VOLUMES After execute ATM_CashIn transaction
        //Transactions
        String finalTransactionsVolumeAfterTrx= String.valueOf(meezaReportPage.volume_GetTransaction());
        System.out.println("finalTransactionsVolumeAfterTrx "+finalTransactionsVolumeAfterTrx);

        //InterChagedebit
        String finalInterchangeDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitVolumeAfterTrx "+finalInterchangeDebitVolumeAfterTrx);

        //Total Debit
        String finalTotalDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("finalTotalDebitVolumeAfterTrx "+finalTotalDebitVolumeAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeAfterTrx: " + finalInterchangeCreditVolumeAfterTrx);

        //Total Credit
        String finalTotalCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeAfterTrx: " + finalTotalCreditVolumeAfterTrx);

        Assert.assertEquals(finalTransactionsVolumeAfterTrx,finalTransactionsVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitVolumeAfterTrx,finalInterchangeDebitVolumeBeforeTrx);
        Assert.assertEquals(finalTotalDebitVolumeAfterTrx,finalTotalDebitVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditVolumeAfterTrx,finalInterchangeCreditVolumeBeforeTrx);
        Assert.assertEquals(finalTotalCreditVolumeAfterTrx,finalTotalCreditVolumeBeforeTrx);


        //Click Values
        meezaReportPage.clickValues();

        //Values After execute P2P transaction
        //Transactions
        String finalTransactionsValueAfterTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueAfterTrx: " + finalTransactionsValueAfterTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueAfterTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueAfterTrx: " + finalInterchangeDebitValueAfterTrx);

        //Total Debit
        String finalTotalDebitValueAfterTrx = String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueAfterTrx: " + finalTotalDebitValueAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditValueAfterTrx: " + finalInterchangeCreditValueAfterTrx);

        //Total Credit
        String finalTotalCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditValueAfterTrx: " + finalTotalCreditValueAfterTrx);

        //Processing Fees
        double finalProcessingFeesValueAfterTrx = meezaReportPage.value_GetProcessingFees().doubleValue();
        System.out.println("finalProcessingFeesValueAfterTrx: " + finalProcessingFeesValueAfterTrx);

        //Net Position
        String finalNetPositionValueAfterTrx = String.valueOf(meezaReportPage.value_GetNetPosition());
        System.out.println("finalNetPositionValueAfterTrx: " + finalNetPositionValueAfterTrx);


        Assert.assertEquals(finalTransactionsValueAfterTrx,finalTransactionsValueBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitValueAfterTrx,finalInterchangeDebitValueBeforeTrx);
        Assert.assertEquals(finalTotalDebitValueAfterTrx,finalTotalDebitValueBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditValueAfterTrx,finalInterchangeCreditBeforeTrx);
        Assert.assertEquals(finalTotalCreditValueAfterTrx,finalTotalCreditBeforeTrx);
        Assert.assertEquals(finalProcessingFeesValueAfterTrx,finalProcessingFeesBeforeTrx);
        Assert.assertEquals(finalNetPositionValueAfterTrx,finalNetPositionBeforeTrx);
        driver.quit();
    }

    @Test (priority = 4, enabled = true)
    public void Receive_Deposit_OffUs() throws IOException, ParseException {
       loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //VOLUMES
        //Transactions
        String finalTransactionsVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTransaction().add(new BigDecimal(1)));
        System.out.println("Transactions: " + finalTransactionsVolumeBeforeTrx);

        //Interchange Debit
        String finalInterchangeDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("Interchange Debit: " + finalInterchangeDebitVolumeBeforeTrx);

        //Total Debit
        String finalTotalDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("Total Debit: " + finalTotalDebitVolumeBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit().add(new BigDecimal(1)));
        System.out.println("finalInterchangeCreditVolumeBeforeTrx: " + finalInterchangeCreditVolumeBeforeTrx);

        //Total Credit
        String finalTotalCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit().add(new BigDecimal(1)));
        System.out.println("finalTotalCreditVolumeBeforeTrx: " + finalTotalCreditVolumeBeforeTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String finalTransactionsValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue().add(new BigDecimal(11)));
        System.out.println("finalTransactionsValueBeforeTrx: " + finalTransactionsValueBeforeTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueBeforeTrx: " + finalInterchangeDebitValueBeforeTrx);

        //Total Debit
        String finalTotalDebitValueBeforeTrx = String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueBeforeTrx: " + finalTotalDebitValueBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit().add(new BigDecimal(1)));
        System.out.println("finalInterchangeCreditBeforeTrx: " + finalInterchangeCreditBeforeTrx);

        //Total Credit
        String finalTotalCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetTotalCredit().add(new BigDecimal(11)));
        System.out.println("finalTotalCreditBeforeTrx: " + finalTotalCreditBeforeTrx);

        //Processing Fees
        double finalProcessingFeesBeforeTrx = meezaReportPage.value_GetProcessingFees().add(new BigDecimal(1)).doubleValue();
        System.out.println("finalProcessingFeesBeforeTrx: " + finalProcessingFeesBeforeTrx);

        //Net Position
        String finalNetPositionBeforeTrx = String.valueOf(meezaReportPage.value_GetNetPosition().add(new BigDecimal(11)));
        System.out.println("finalNetPositionBeforeTrx: " + finalNetPositionBeforeTrx);

        deposit.Receive_Deposit_OffUS();
        deposit.Receive_Deposit_OffUs_Advice();
        refresh();

        //VOLUMES After Receive_Deposit transaction
        //Transactions
        String finalTransactionsVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTransaction());
        System.out.println("finalTransactionsVolumeAfterTrx " + finalTransactionsVolumeAfterTrx);

        //Interchange Debit
        String finalInterchangeDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitVolumeAfterTrx " + finalInterchangeDebitVolumeAfterTrx);

        //Total Debit
        String finalTotalDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("finalTotalDebitVolumeAfterTrx " + finalTotalDebitVolumeAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeAfterTrx: " + finalInterchangeCreditVolumeAfterTrx);

        //Total Credit
        String finalTotalCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeAfterTrx: " + finalTotalCreditVolumeAfterTrx);


        Assert.assertEquals(finalTransactionsVolumeAfterTrx, finalTransactionsVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitVolumeAfterTrx, finalInterchangeDebitVolumeBeforeTrx);
        Assert.assertEquals(finalTotalDebitVolumeAfterTrx, finalTotalDebitVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditVolumeAfterTrx, finalInterchangeCreditVolumeBeforeTrx);
        Assert.assertEquals(finalTotalCreditVolumeAfterTrx, finalTotalCreditVolumeBeforeTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values After
        //Transactions
        String finalTransactionsValueAfterTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueAfterTrx: " + finalTransactionsValueAfterTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueAfterTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueAfterTrx: " + finalInterchangeDebitValueAfterTrx);

        //Total Debit
        String finalTotalDebitValueAfterTrx = String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueAfterTrx: " + finalTotalDebitValueAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditValueAfterTrx: " + finalInterchangeCreditValueAfterTrx);

        //Total Credit
        String finalTotalCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditValueAfterTrx: " + finalTotalCreditValueAfterTrx);

        //Processing Fees
        double finalProcessingFeesValueAfterTrx = meezaReportPage.value_GetProcessingFees().doubleValue();
        System.out.println("finalProcessingFeesValueAfterTrx: " + finalProcessingFeesValueAfterTrx);

        //Net Position
        String finalNetPositionValueAfterTrx = String.valueOf(meezaReportPage.value_GetNetPosition());
        System.out.println("finalNetPositionValueAfterTrx: " + finalNetPositionValueAfterTrx);

        Assert.assertEquals(finalTransactionsValueAfterTrx, finalTransactionsValueBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitValueAfterTrx, finalInterchangeDebitValueBeforeTrx);
        Assert.assertEquals(finalTotalDebitValueAfterTrx, finalTotalDebitValueBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditValueAfterTrx, finalInterchangeCreditBeforeTrx);
        Assert.assertEquals(finalTotalCreditValueAfterTrx, finalTotalCreditBeforeTrx);
        Assert.assertEquals(finalProcessingFeesValueAfterTrx, finalProcessingFeesBeforeTrx);
        Assert.assertEquals(finalNetPositionValueAfterTrx, finalNetPositionBeforeTrx);
        driver.quit();
    }

    @Test (priority = 6, enabled = true)
    public void Receive_Agent_Cash_In_OffUS() throws IOException, ParseException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //Get VOLUMES Numbers
        //Transactions
        String finalTransactionsVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTransaction().add(new BigDecimal(1)));
        System.out.println("Transactions: " + finalTransactionsVolumeBeforeTrx);

        //Interchange Debit
        String finalInterchangeDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit().add(new BigDecimal(1)));
        System.out.println("Interchange Debit: " + finalInterchangeDebitVolumeBeforeTrx);

        //Total Debit
        String finalTotalDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit().add(new BigDecimal(1)));
        System.out.println("Total Debit: " + finalTotalDebitVolumeBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeBeforeTrx: " + finalInterchangeCreditVolumeBeforeTrx);

        //Total Credit
        String finalTotalCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeBeforeTrx: " + finalTotalCreditVolumeBeforeTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String finalTransactionsValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueBeforeTrx: " + finalTransactionsValueBeforeTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit().add(new BigDecimal(1)));
        System.out.println("finalInterchangeDebitValueBeforeTrx: " + finalInterchangeDebitValueBeforeTrx);

        //Total Debit
        String finalTotalDebitValueBeforeTrx = String.valueOf(meezaReportPage.value_getTotalDebit().add(new BigDecimal(11)));
        System.out.println("finalTotalDebitValueBeforeTrx: " + finalTotalDebitValueBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditBeforeTrx: " + finalInterchangeCreditBeforeTrx);

        //Total Credit
        String finalTotalCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditBeforeTrx: " + finalTotalCreditBeforeTrx);

        //Processing Fees
        double finalProcessingFeesBeforeTrx = meezaReportPage.value_GetProcessingFees().add(new BigDecimal(1)).doubleValue();
        System.out.println("finalProcessingFeesBeforeTrx: " + finalProcessingFeesBeforeTrx);

        //Net Position
        String finalNetPositionBeforeTrx = String.valueOf(meezaReportPage.value_GetNetPosition().subtract(new BigDecimal(11)));
        System.out.println("finalNetPositionBeforeTrx: " + finalNetPositionBeforeTrx);

        generateOtp.Generate_OTP();
        agentCashIn.Initiate_Agent_Cash_In();
        agentCashIn.Receive_Agent_Cash_In_Off_US();
        agentCashIn.Receive_Agent_Cash_In_Advice_Off_US();

        refresh();

        //Get VOLUMES After execute Agent Cah In transaction
        //Transactions
        String finalTransactionsVolumeAfterTrx= String.valueOf(meezaReportPage.volume_GetTransaction());
        System.out.println("finalTransactionsVolumeAfterTrx "+finalTransactionsVolumeAfterTrx);

        //InterChagedebit
        String finalInterchangeDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitVolumeAfterTrx "+finalInterchangeDebitVolumeAfterTrx);

        //Total Debit
        String finalTotalDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("finalTotalDebitVolumeAfterTrx "+finalTotalDebitVolumeAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeAfterTrx: " + finalInterchangeCreditVolumeAfterTrx);

        //Total Credit
        String finalTotalCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeAfterTrx: " + finalTotalCreditVolumeAfterTrx);

        Assert.assertEquals(finalTransactionsVolumeAfterTrx,finalTransactionsVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitVolumeAfterTrx,finalInterchangeDebitVolumeBeforeTrx);
        Assert.assertEquals(finalTotalDebitVolumeAfterTrx,finalTotalDebitVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditVolumeAfterTrx,finalInterchangeCreditVolumeBeforeTrx);
        Assert.assertEquals(finalTotalCreditVolumeAfterTrx,finalTotalCreditVolumeBeforeTrx);


        //Click Values
        meezaReportPage.clickValues();

        //Values After execute P2P transaction
        //Transactions
        String finalTransactionsValueAfterTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueAfterTrx: " + finalTransactionsValueAfterTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueAfterTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueAfterTrx: " + finalInterchangeDebitValueAfterTrx);

        //Total Debit
        String finalTotalDebitValueAfterTrx = String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueAfterTrx: " + finalTotalDebitValueAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditValueAfterTrx: " + finalInterchangeCreditValueAfterTrx);

        //Total Credit
        String finalTotalCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditValueAfterTrx: " + finalTotalCreditValueAfterTrx);

        //Processing Fees
        double finalProcessingFeesValueAfterTrx = meezaReportPage.value_GetProcessingFees().doubleValue();
        System.out.println("finalProcessingFeesValueAfterTrx: " + finalProcessingFeesValueAfterTrx);

        //Net Position
        String finalNetPositionValueAfterTrx = String.valueOf(meezaReportPage.value_GetNetPosition());
        System.out.println("finalNetPositionValueAfterTrx: " + finalNetPositionValueAfterTrx);


        Assert.assertEquals(finalTransactionsValueAfterTrx,finalTransactionsValueBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitValueAfterTrx,finalInterchangeDebitValueBeforeTrx);
        Assert.assertEquals(finalTotalDebitValueAfterTrx,finalTotalDebitValueBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditValueAfterTrx,finalInterchangeCreditBeforeTrx);
        Assert.assertEquals(finalTotalCreditValueAfterTrx,finalTotalCreditBeforeTrx);
        Assert.assertEquals(finalProcessingFeesValueAfterTrx,finalProcessingFeesBeforeTrx);
        Assert.assertEquals(finalNetPositionValueAfterTrx,finalNetPositionBeforeTrx);
        driver.quit();
    }

    @Test (priority = 7, enabled = true)
    public void Send_Agent_Cash_In_OffUS() throws IOException, ParseException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //Get VOLUMES Numbers
        //Transactions
        String finalTransactionsVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTransaction().add(new BigDecimal(1)));
        System.out.println("Transactions: " + finalTransactionsVolumeBeforeTrx);

        //Interchange Debit
        String finalInterchangeDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit().add(new BigDecimal(1)));
        System.out.println("Interchange Debit: " + finalInterchangeDebitVolumeBeforeTrx);

        //Total Debit
        String finalTotalDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit().add(new BigDecimal(1)));
        System.out.println("Total Debit: " + finalTotalDebitVolumeBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeBeforeTrx: " + finalInterchangeCreditVolumeBeforeTrx);

        //Total Credit
        String finalTotalCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeBeforeTrx: " + finalTotalCreditVolumeBeforeTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String finalTransactionsValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueBeforeTrx: " + finalTransactionsValueBeforeTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit().add(new BigDecimal(1)));
        System.out.println("finalInterchangeDebitValueBeforeTrx: " + finalInterchangeDebitValueBeforeTrx);

        //Total Debit
        String finalTotalDebitValueBeforeTrx = String.valueOf(meezaReportPage.value_getTotalDebit().add(new BigDecimal(11)));
        System.out.println("finalTotalDebitValueBeforeTrx: " + finalTotalDebitValueBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditBeforeTrx: " + finalInterchangeCreditBeforeTrx);

        //Total Credit
        String finalTotalCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditBeforeTrx: " + finalTotalCreditBeforeTrx);

        //Processing Fees
        double finalProcessingFeesBeforeTrx = meezaReportPage.value_GetProcessingFees().add(new BigDecimal(1)).doubleValue();
        System.out.println("finalProcessingFeesBeforeTrx: " + finalProcessingFeesBeforeTrx);

        //Net Position
        String finalNetPositionBeforeTrx = String.valueOf(meezaReportPage.value_GetNetPosition().subtract(new BigDecimal(11)));
        System.out.println("finalNetPositionBeforeTrx: " + finalNetPositionBeforeTrx);

        generateOtp.Generate_OTP();
        agentCashIn.Initiate_Agent_Cash_In();
        agentCashIn.Receive_Agent_Cash_In_Advice_Off_US();

        refresh();

        //Get VOLUMES After execute Agent Cah In transaction
        //Transactions
        String finalTransactionsVolumeAfterTrx= String.valueOf(meezaReportPage.volume_GetTransaction());
        System.out.println("finalTransactionsVolumeAfterTrx "+finalTransactionsVolumeAfterTrx);

        //InterChagedebit
        String finalInterchangeDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitVolumeAfterTrx "+finalInterchangeDebitVolumeAfterTrx);

        //Total Debit
        String finalTotalDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("finalTotalDebitVolumeAfterTrx "+finalTotalDebitVolumeAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeAfterTrx: " + finalInterchangeCreditVolumeAfterTrx);

        //Total Credit
        String finalTotalCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeAfterTrx: " + finalTotalCreditVolumeAfterTrx);

        Assert.assertEquals(finalTransactionsVolumeAfterTrx,finalTransactionsVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitVolumeAfterTrx,finalInterchangeDebitVolumeBeforeTrx);
        Assert.assertEquals(finalTotalDebitVolumeAfterTrx,finalTotalDebitVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditVolumeAfterTrx,finalInterchangeCreditVolumeBeforeTrx);
        Assert.assertEquals(finalTotalCreditVolumeAfterTrx,finalTotalCreditVolumeBeforeTrx);


        //Click Values
        meezaReportPage.clickValues();

        //Values After execute P2P transaction
        //Transactions
        String finalTransactionsValueAfterTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueAfterTrx: " + finalTransactionsValueAfterTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueAfterTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueAfterTrx: " + finalInterchangeDebitValueAfterTrx);

        //Total Debit
        String finalTotalDebitValueAfterTrx = String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueAfterTrx: " + finalTotalDebitValueAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditValueAfterTrx: " + finalInterchangeCreditValueAfterTrx);

        //Total Credit
        String finalTotalCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditValueAfterTrx: " + finalTotalCreditValueAfterTrx);

        //Processing Fees
        double finalProcessingFeesValueAfterTrx = meezaReportPage.value_GetProcessingFees().doubleValue();
        System.out.println("finalProcessingFeesValueAfterTrx: " + finalProcessingFeesValueAfterTrx);

        //Net Position
        String finalNetPositionValueAfterTrx = String.valueOf(meezaReportPage.value_GetNetPosition());
        System.out.println("finalNetPositionValueAfterTrx: " + finalNetPositionValueAfterTrx);


        Assert.assertEquals(finalTransactionsValueAfterTrx,finalTransactionsValueBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitValueAfterTrx,finalInterchangeDebitValueBeforeTrx);
        Assert.assertEquals(finalTotalDebitValueAfterTrx,finalTotalDebitValueBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditValueAfterTrx,finalInterchangeCreditBeforeTrx);
        Assert.assertEquals(finalTotalCreditValueAfterTrx,finalTotalCreditBeforeTrx);
        Assert.assertEquals(finalProcessingFeesValueAfterTrx,finalProcessingFeesBeforeTrx);
        Assert.assertEquals(finalNetPositionValueAfterTrx,finalNetPositionBeforeTrx);
        driver.quit();
    }
    @Test (priority = 8, enabled = true)
    public void Receive_Agent_Cash_Out_OffUS() throws IOException, ParseException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //Get VOLUMES Numbers
        //Transactions
        String finalTransactionsVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTransaction().add(new BigDecimal(1)));
        System.out.println("Transactions: " + finalTransactionsVolumeBeforeTrx);

        //Interchange Debit
        String finalInterchangeDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit().add(new BigDecimal(1)));
        System.out.println("Interchange Debit: " + finalInterchangeDebitVolumeBeforeTrx);

        //Total Debit
        String finalTotalDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit().add(new BigDecimal(1)));
        System.out.println("Total Debit: " + finalTotalDebitVolumeBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeBeforeTrx: " + finalInterchangeCreditVolumeBeforeTrx);

        //Total Credit
        String finalTotalCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeBeforeTrx: " + finalTotalCreditVolumeBeforeTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String finalTransactionsValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueBeforeTrx: " + finalTransactionsValueBeforeTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit().add(new BigDecimal(1)));
        System.out.println("finalInterchangeDebitValueBeforeTrx: " + finalInterchangeDebitValueBeforeTrx);

        //Total Debit
        String finalTotalDebitValueBeforeTrx = String.valueOf(meezaReportPage.value_getTotalDebit().add(new BigDecimal(11)));
        System.out.println("finalTotalDebitValueBeforeTrx: " + finalTotalDebitValueBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditBeforeTrx: " + finalInterchangeCreditBeforeTrx);

        //Total Credit
        String finalTotalCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditBeforeTrx: " + finalTotalCreditBeforeTrx);

        //Processing Fees
        double finalProcessingFeesBeforeTrx = meezaReportPage.value_GetProcessingFees().add(new BigDecimal(1)).doubleValue();
        System.out.println("finalProcessingFeesBeforeTrx: " + finalProcessingFeesBeforeTrx);

        //Net Position
        String finalNetPositionBeforeTrx = String.valueOf(meezaReportPage.value_GetNetPosition().subtract(new BigDecimal(11)));
        System.out.println("finalNetPositionBeforeTrx: " + finalNetPositionBeforeTrx);

        agentCashOut.Receive_Agent_Cash_Out_Off_US();
        agentCashOut.Receive_Agent_Cash_Out_Advice_Off_US();

        refresh();

        //Get VOLUMES After execute Agent Cah In transaction
        //Transactions
        String finalTransactionsVolumeAfterTrx= String.valueOf(meezaReportPage.volume_GetTransaction());
        System.out.println("finalTransactionsVolumeAfterTrx "+finalTransactionsVolumeAfterTrx);

        //InterChagedebit
        String finalInterchangeDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitVolumeAfterTrx "+finalInterchangeDebitVolumeAfterTrx);

        //Total Debit
        String finalTotalDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("finalTotalDebitVolumeAfterTrx "+finalTotalDebitVolumeAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeAfterTrx: " + finalInterchangeCreditVolumeAfterTrx);

        //Total Credit
        String finalTotalCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeAfterTrx: " + finalTotalCreditVolumeAfterTrx);

        Assert.assertEquals(finalTransactionsVolumeAfterTrx,finalTransactionsVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitVolumeAfterTrx,finalInterchangeDebitVolumeBeforeTrx);
        Assert.assertEquals(finalTotalDebitVolumeAfterTrx,finalTotalDebitVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditVolumeAfterTrx,finalInterchangeCreditVolumeBeforeTrx);
        Assert.assertEquals(finalTotalCreditVolumeAfterTrx,finalTotalCreditVolumeBeforeTrx);


        //Click Values
        meezaReportPage.clickValues();

        //Values After execute P2P transaction
        //Transactions
        String finalTransactionsValueAfterTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueAfterTrx: " + finalTransactionsValueAfterTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueAfterTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueAfterTrx: " + finalInterchangeDebitValueAfterTrx);

        //Total Debit
        String finalTotalDebitValueAfterTrx = String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueAfterTrx: " + finalTotalDebitValueAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditValueAfterTrx: " + finalInterchangeCreditValueAfterTrx);

        //Total Credit
        String finalTotalCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditValueAfterTrx: " + finalTotalCreditValueAfterTrx);

        //Processing Fees
        double finalProcessingFeesValueAfterTrx = meezaReportPage.value_GetProcessingFees().doubleValue();
        System.out.println("finalProcessingFeesValueAfterTrx: " + finalProcessingFeesValueAfterTrx);

        //Net Position
        String finalNetPositionValueAfterTrx = String.valueOf(meezaReportPage.value_GetNetPosition());
        System.out.println("finalNetPositionValueAfterTrx: " + finalNetPositionValueAfterTrx);


        Assert.assertEquals(finalTransactionsValueAfterTrx,finalTransactionsValueBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitValueAfterTrx,finalInterchangeDebitValueBeforeTrx);
        Assert.assertEquals(finalTotalDebitValueAfterTrx,finalTotalDebitValueBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditValueAfterTrx,finalInterchangeCreditBeforeTrx);
        Assert.assertEquals(finalTotalCreditValueAfterTrx,finalTotalCreditBeforeTrx);
        Assert.assertEquals(finalProcessingFeesValueAfterTrx,finalProcessingFeesBeforeTrx);
        Assert.assertEquals(finalNetPositionValueAfterTrx,finalNetPositionBeforeTrx);
        driver.quit();
    }
    @Test (priority = 9, enabled = true)
    public void Receive_Agent_Cash_Out_Reversal() throws IOException, ParseException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //Get VOLUMES Numbers
        //Transactions
        String finalTransactionsVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTransaction().add(new BigDecimal(1)));
        System.out.println("Transactions: " + finalTransactionsVolumeBeforeTrx);

        //Interchange Debit
        String finalInterchangeDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit().add(new BigDecimal(1)));
        System.out.println("Interchange Debit: " + finalInterchangeDebitVolumeBeforeTrx);

        //Total Debit
        String finalTotalDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit().add(new BigDecimal(1)));
        System.out.println("Total Debit: " + finalTotalDebitVolumeBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeBeforeTrx: " + finalInterchangeCreditVolumeBeforeTrx);

        //Total Credit
        String finalTotalCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeBeforeTrx: " + finalTotalCreditVolumeBeforeTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String finalTransactionsValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueBeforeTrx: " + finalTransactionsValueBeforeTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit().add(new BigDecimal(2)));
        System.out.println("finalInterchangeDebitValueBeforeTrx: " + finalInterchangeDebitValueBeforeTrx);

        //Total Debit
        String finalTotalDebitValueBeforeTrx = String.valueOf(meezaReportPage.value_getTotalDebit().add(new BigDecimal(12)));
        System.out.println("finalTotalDebitValueBeforeTrx: " + finalTotalDebitValueBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditBeforeTrx: " + finalInterchangeCreditBeforeTrx);

        //Total Credit
        String finalTotalCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditBeforeTrx: " + finalTotalCreditBeforeTrx);

        //Processing Fees
        double finalProcessingFeesBeforeTrx = meezaReportPage.value_GetProcessingFees().add(new BigDecimal(1)).doubleValue();

        System.out.println("finalProcessingFeesBeforeTrx: " + finalProcessingFeesBeforeTrx);

        //Net Position
        String finalNetPositionBeforeTrx = String.valueOf(meezaReportPage.value_GetNetPosition().subtract(new BigDecimal(12)));
        System.out.println("finalNetPositionBeforeTrx: " + finalNetPositionBeforeTrx);

        agentCashOut.Receive_Agent_Cash_Out_Reversal();
        refresh();

        //Get VOLUMES After execute Agent Cah Reversal In transaction
        //Transactions
        String finalTransactionsVolumeAfterTrx= String.valueOf(meezaReportPage.volume_GetTransaction());
        System.out.println("finalTransactionsVolumeAfterTrx "+finalTransactionsVolumeAfterTrx);

        //InterChagedebit
        String finalInterchangeDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitVolumeAfterTrx "+finalInterchangeDebitVolumeAfterTrx);

        //Total Debit
        String finalTotalDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("finalTotalDebitVolumeAfterTrx "+finalTotalDebitVolumeAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeAfterTrx: " + finalInterchangeCreditVolumeAfterTrx);

        //Total Credit
        String finalTotalCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeAfterTrx: " + finalTotalCreditVolumeAfterTrx);

        Assert.assertEquals(finalTransactionsVolumeAfterTrx,finalTransactionsVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitVolumeAfterTrx,finalInterchangeDebitVolumeBeforeTrx);
        Assert.assertEquals(finalTotalDebitVolumeAfterTrx,finalTotalDebitVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditVolumeAfterTrx,finalInterchangeCreditVolumeBeforeTrx);
        Assert.assertEquals(finalTotalCreditVolumeAfterTrx,finalTotalCreditVolumeBeforeTrx);
        Assert.assertEquals(meezaReportPage.volume_GetTotalCredit(),meezaReportPage.volume_GetTotalCredit());


        //Click Values
        meezaReportPage.clickValues();

        //Values After execute P2P transaction
        //Transactions
        String finalTransactionsValueAfterTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueAfterTrx: " + finalTransactionsValueAfterTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueAfterTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueAfterTrx: " + finalInterchangeDebitValueAfterTrx);

        //Total Debit
        String finalTotalDebitValueAfterTrx = String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueAfterTrx: " + finalTotalDebitValueAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditValueAfterTrx: " + finalInterchangeCreditValueAfterTrx);

        //Total Credit
        String finalTotalCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditValueAfterTrx: " + finalTotalCreditValueAfterTrx);

        //Processing Fees
        double finalProcessingFeesValueAfterTrx = meezaReportPage.value_GetProcessingFees().doubleValue();
        System.out.println("finalProcessingFeesValueAfterTrx: " + finalProcessingFeesValueAfterTrx);

        //Net Position
        String finalNetPositionValueAfterTrx = String.valueOf(meezaReportPage.value_GetNetPosition());
        System.out.println("finalNetPositionValueAfterTrx: " + finalNetPositionValueAfterTrx);


        Assert.assertEquals(finalTransactionsValueAfterTrx,finalTransactionsValueBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitValueAfterTrx,finalInterchangeDebitValueBeforeTrx);
        Assert.assertEquals(finalTotalDebitValueAfterTrx,finalTotalDebitValueBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditValueAfterTrx,finalInterchangeCreditBeforeTrx);
        Assert.assertEquals(finalTotalCreditValueAfterTrx,finalTotalCreditBeforeTrx);
        Assert.assertEquals(finalProcessingFeesValueAfterTrx,finalProcessingFeesBeforeTrx);
        Assert.assertEquals(finalNetPositionValueAfterTrx,finalNetPositionBeforeTrx);
        driver.quit();
    }

    @Test (priority = 10, enabled = true)
    public void Send_Deposit_OffUs() throws IOException, ParseException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //Get VOLUMES Numbers
        //Transactions
        String finalTransactionsVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTransaction().add(new BigDecimal(1)));
        System.out.println("Transactions: " + finalTransactionsVolumeBeforeTrx);

        //Interchange Debit
        String finalInterchangeDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit().add(new BigDecimal(1)));
        System.out.println("Interchange Debit: " + finalInterchangeDebitVolumeBeforeTrx);

        //Total Debit
        String finalTotalDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit().add(new BigDecimal(1)));
        System.out.println("Total Debit: " + finalTotalDebitVolumeBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeBeforeTrx: " + finalInterchangeCreditVolumeBeforeTrx);

        //Total Credit
        String finalTotalCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeBeforeTrx: " + finalTotalCreditVolumeBeforeTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String finalTransactionsValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueBeforeTrx: " + finalTransactionsValueBeforeTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit().add(new BigDecimal(1)));
        System.out.println("finalInterchangeDebitValueBeforeTrx: " + finalInterchangeDebitValueBeforeTrx);

        //Total Debit
        String finalTotalDebitValueBeforeTrx = String.valueOf(meezaReportPage.value_getTotalDebit().add(new BigDecimal(11)));
        System.out.println("finalTotalDebitValueBeforeTrx: " + finalTotalDebitValueBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditBeforeTrx: " + finalInterchangeCreditBeforeTrx);

        //Total Credit
        String finalTotalCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditBeforeTrx: " + finalTotalCreditBeforeTrx);

        //Processing Fees
        double finalProcessingFeesBeforeTrx = meezaReportPage.value_GetProcessingFees().add(new BigDecimal(0)).doubleValue();
        System.out.println("finalProcessingFeesBeforeTrx: " + finalProcessingFeesBeforeTrx);

        //Net Position
        String finalNetPositionBeforeTrx = String.valueOf(meezaReportPage.value_GetNetPosition().subtract(new BigDecimal(11)));
        System.out.println("finalNetPositionBeforeTrx: " + finalNetPositionBeforeTrx);

        deposit.Send_Deposit_OffUS();
        deposit.Send_Deposit_Advice_OffUs();
        refresh();

        //Get VOLUMES After execute Send_Deposit transaction
        //Transactions
        String finalTransactionsVolumeAfterTrx= String.valueOf(meezaReportPage.volume_GetTransaction());
        System.out.println("finalTransactionsVolumeAfterTrx "+finalTransactionsVolumeAfterTrx);

        //InterChagedebit
        String finalInterchangeDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitVolumeAfterTrx "+finalInterchangeDebitVolumeAfterTrx);

        //Total Debit
        String finalTotalDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("finalTotalDebitVolumeAfterTrx "+finalTotalDebitVolumeAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeAfterTrx: " + finalInterchangeCreditVolumeAfterTrx);

        //Total Credit
        String finalTotalCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeAfterTrx: " + finalTotalCreditVolumeAfterTrx);

        Assert.assertEquals(finalTransactionsVolumeAfterTrx,finalTransactionsVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitVolumeAfterTrx,finalInterchangeDebitVolumeBeforeTrx);
        Assert.assertEquals(finalTotalDebitVolumeAfterTrx,finalTotalDebitVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditVolumeAfterTrx,finalInterchangeCreditVolumeBeforeTrx);
        Assert.assertEquals(finalTotalCreditVolumeAfterTrx,finalTotalCreditVolumeBeforeTrx);


        //Click Values
        meezaReportPage.clickValues();

        //Values After execute P2P transaction
        //Transactions
        String finalTransactionsValueAfterTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueAfterTrx: " + finalTransactionsValueAfterTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueAfterTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueAfterTrx: " + finalInterchangeDebitValueAfterTrx);

        //Total Debit
        String finalTotalDebitValueAfterTrx = String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueAfterTrx: " + finalTotalDebitValueAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditValueAfterTrx: " + finalInterchangeCreditValueAfterTrx);

        //Total Credit
        String finalTotalCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditValueAfterTrx: " + finalTotalCreditValueAfterTrx);

        //Processing Fees
        double finalProcessingFeesValueAfterTrx = meezaReportPage.value_GetProcessingFees().doubleValue();
        System.out.println("finalProcessingFeesValueAfterTrx: " + finalProcessingFeesValueAfterTrx);

        //Net Position
        String finalNetPositionValueAfterTrx = String.valueOf(meezaReportPage.value_GetNetPosition());
        System.out.println("finalNetPositionValueAfterTrx: " + finalNetPositionValueAfterTrx);


        Assert.assertEquals(finalTransactionsValueAfterTrx,finalTransactionsValueBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitValueAfterTrx,finalInterchangeDebitValueBeforeTrx);
        Assert.assertEquals(finalTotalDebitValueAfterTrx,finalTotalDebitValueBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditValueAfterTrx,finalInterchangeCreditBeforeTrx);
        Assert.assertEquals(finalTotalCreditValueAfterTrx,finalTotalCreditBeforeTrx);
        Assert.assertEquals(finalProcessingFeesValueAfterTrx,finalProcessingFeesBeforeTrx);
        Assert.assertEquals(finalNetPositionValueAfterTrx,finalNetPositionBeforeTrx);
        driver.quit();
    }

    @Test (priority = 5, enabled = true)
    public void Recieve_Deposit_OffUs() throws IOException, ParseException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //Get VOLUMES Numbers
        //Transactions
        String finalTransactionsVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTransaction().add(new BigDecimal(1)));
        System.out.println("Transactions: " + finalTransactionsVolumeBeforeTrx);

        //Interchange Debit
        String finalInterchangeDebitVolumeBeforeTrx =
                String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("Interchange Debit: " + finalInterchangeDebitVolumeBeforeTrx);

        //Total Debit
        String finalTotalDebitVolumeBeforeTrx =
                String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("Total Debit: " + finalTotalDebitVolumeBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeBeforeTrx =
                String.valueOf(meezaReportPage.volume_GetInterchangeCredit().add(new BigDecimal(1)));
        System.out.println("finalInterchangeCreditVolumeBeforeTrx: " + finalInterchangeCreditVolumeBeforeTrx);

        //Total Credit
        String finalTotalCreditVolumeBeforeTrx =
                String.valueOf(meezaReportPage.volume_GetTotalCredit().add(new BigDecimal(1)));
        System.out.println("finalTotalCreditVolumeBeforeTrx: " + finalTotalCreditVolumeBeforeTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String finalTransactionsValueBeforeTrx =
                String.valueOf(meezaReportPage.Value_GetTransactionValue().add(new BigDecimal(11)));
        System.out.println("finalTransactionsValueBeforeTrx: " + finalTransactionsValueBeforeTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueBeforeTrx =
                String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueBeforeTrx: " + finalInterchangeDebitValueBeforeTrx);

        //Total Debit
        String finalTotalDebitValueBeforeTrx =
                String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueBeforeTrx: " + finalTotalDebitValueBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditBeforeTrx =
                String.valueOf(meezaReportPage.value_GetInterchangeCredit().add(new BigDecimal(1)));
        System.out.println("finalInterchangeCreditBeforeTrx: " + finalInterchangeCreditBeforeTrx);

        //Total Credit
        String finalTotalCreditBeforeTrx =
                String.valueOf(meezaReportPage.value_GetTotalCredit().add(new BigDecimal(11)));
        System.out.println("finalTotalCreditBeforeTrx: " + finalTotalCreditBeforeTrx);

        //Processing Fees
        double finalProcessingFeesBeforeTrx =
                meezaReportPage.value_GetProcessingFees().add(new BigDecimal(1)).doubleValue();
        System.out.println("finalProcessingFeesBeforeTrx: " + finalProcessingFeesBeforeTrx);

        //Net Position
        String finalNetPositionBeforeTrx =
                String.valueOf(meezaReportPage.value_GetNetPosition().add(new BigDecimal(11)));
        System.out.println("finalNetPositionBeforeTrx: " + finalNetPositionBeforeTrx);

        deposit.Receive_Deposit_OffUS();
        deposit.Receive_Deposit_OffUs_Advice();
        refresh();

        //Get VOLUMES After execute Recieve_Deposit transaction
        //Transactions
        String finalTransactionsVolumeAfterTrx=
                String.valueOf(meezaReportPage.volume_GetTransaction());
        System.out.println("finalTransactionsVolumeAfterTrx "+finalTransactionsVolumeAfterTrx);

        //InterChagedebit
        String finalInterchangeDebitVolumeAfterTrx =
                String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitVolumeAfterTrx "+finalInterchangeDebitVolumeAfterTrx);

        //Total Debit
        String finalTotalDebitVolumeAfterTrx =
                String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("finalTotalDebitVolumeAfterTrx "+finalTotalDebitVolumeAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeAfterTrx =
                String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeAfterTrx: " + finalInterchangeCreditVolumeAfterTrx);

        //Total Credit
        String finalTotalCreditVolumeAfterTrx =
                String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeAfterTrx: " + finalTotalCreditVolumeAfterTrx);

        Assert.assertEquals(finalTransactionsVolumeAfterTrx,finalTransactionsVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitVolumeAfterTrx,finalInterchangeDebitVolumeBeforeTrx);
        Assert.assertEquals(finalTotalDebitVolumeAfterTrx,finalTotalDebitVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditVolumeAfterTrx,finalInterchangeCreditVolumeBeforeTrx);
        Assert.assertEquals(finalTotalCreditVolumeAfterTrx,finalTotalCreditVolumeBeforeTrx);


        //Click Values
        meezaReportPage.clickValues();

        //Values After execute P2P transaction
        //Transactions
        String finalTransactionsValueAfterTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueAfterTrx: " + finalTransactionsValueAfterTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueAfterTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueAfterTrx: " + finalInterchangeDebitValueAfterTrx);

        //Total Debit
        String finalTotalDebitValueAfterTrx = String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueAfterTrx: " + finalTotalDebitValueAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditValueAfterTrx: " + finalInterchangeCreditValueAfterTrx);

        //Total Credit
        String finalTotalCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditValueAfterTrx: " + finalTotalCreditValueAfterTrx);

        //Processing Fees
        double finalProcessingFeesValueAfterTrx = meezaReportPage.value_GetProcessingFees().doubleValue();
        System.out.println("finalProcessingFeesValueAfterTrx: " + finalProcessingFeesValueAfterTrx);

        //Net Position
        String finalNetPositionValueAfterTrx = String.valueOf(meezaReportPage.value_GetNetPosition());
        System.out.println("finalNetPositionValueAfterTrx: " + finalNetPositionValueAfterTrx);


        Assert.assertEquals(finalTransactionsValueAfterTrx,finalTransactionsValueBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitValueAfterTrx,finalInterchangeDebitValueBeforeTrx);
        Assert.assertEquals(finalTotalDebitValueAfterTrx,finalTotalDebitValueBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditValueAfterTrx,finalInterchangeCreditBeforeTrx);
        Assert.assertEquals(finalTotalCreditValueAfterTrx,finalTotalCreditBeforeTrx);
        Assert.assertEquals(finalProcessingFeesValueAfterTrx,finalProcessingFeesBeforeTrx);
        Assert.assertEquals(finalNetPositionValueAfterTrx,finalNetPositionBeforeTrx);
        driver.quit();
    }

    @Test (priority = 5, enabled = true)
    public void Recieve_Int_Remittance() throws IOException, ParseException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //Get VOLUMES Numbers
        //Transactions
        String finalTransactionsVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTransaction().add(new BigDecimal(1)));
        System.out.println("Transactions: " + finalTransactionsVolumeBeforeTrx);

        //Interchange Debit
        String finalInterchangeDebitVolumeBeforeTrx =
                String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("Interchange Debit: " + finalInterchangeDebitVolumeBeforeTrx);

        //Total Debit
        String finalTotalDebitVolumeBeforeTrx =
                String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("Total Debit: " + finalTotalDebitVolumeBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeBeforeTrx =
                String.valueOf(meezaReportPage.volume_GetInterchangeCredit().add(new BigDecimal(1)));
        System.out.println("finalInterchangeCreditVolumeBeforeTrx: " + finalInterchangeCreditVolumeBeforeTrx);

        //Total Credit
        String finalTotalCreditVolumeBeforeTrx =
                String.valueOf(meezaReportPage.volume_GetTotalCredit().add(new BigDecimal(1)));
        System.out.println("finalTotalCreditVolumeBeforeTrx: " + finalTotalCreditVolumeBeforeTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String finalTransactionsValueBeforeTrx =
                String.valueOf(meezaReportPage.Value_GetTransactionValue().add(new BigDecimal(11)));
        System.out.println("finalTransactionsValueBeforeTrx: " + finalTransactionsValueBeforeTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueBeforeTrx =
                String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueBeforeTrx: " + finalInterchangeDebitValueBeforeTrx);

        //Total Debit
        String finalTotalDebitValueBeforeTrx =
                String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueBeforeTrx: " + finalTotalDebitValueBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditBeforeTrx =
                String.valueOf(meezaReportPage.value_GetInterchangeCredit().add(new BigDecimal(1)));
        System.out.println("finalInterchangeCreditBeforeTrx: " + finalInterchangeCreditBeforeTrx);

        //Total Credit
        String finalTotalCreditBeforeTrx =
                String.valueOf(meezaReportPage.value_GetTotalCredit().add(new BigDecimal(11)));
        System.out.println("finalTotalCreditBeforeTrx: " + finalTotalCreditBeforeTrx);

        //Processing Fees
        double finalProcessingFeesBeforeTrx =
                meezaReportPage.value_GetProcessingFees().add(new BigDecimal(1)).doubleValue();
        System.out.println("finalProcessingFeesBeforeTrx: " + finalProcessingFeesBeforeTrx);

        //Net Position
        String finalNetPositionBeforeTrx =
                String.valueOf(meezaReportPage.value_GetNetPosition().add(new BigDecimal(11)));
        System.out.println("finalNetPositionBeforeTrx: " + finalNetPositionBeforeTrx);

        Imt.IMT_Receive_Deposit();
        Imt.IMT_Receiv_Deposit_Advice();
        refresh();

        //Get VOLUMES After execute Recieve_Deposit transaction
        //Transactions
        String finalTransactionsVolumeAfterTrx=
                String.valueOf(meezaReportPage.volume_GetTransaction());
        System.out.println("finalTransactionsVolumeAfterTrx "+finalTransactionsVolumeAfterTrx);

        //InterChagedebit
        String finalInterchangeDebitVolumeAfterTrx =
                String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitVolumeAfterTrx "+finalInterchangeDebitVolumeAfterTrx);

        //Total Debit
        String finalTotalDebitVolumeAfterTrx =
                String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("finalTotalDebitVolumeAfterTrx "+finalTotalDebitVolumeAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeAfterTrx =
                String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeAfterTrx: " + finalInterchangeCreditVolumeAfterTrx);

        //Total Credit
        String finalTotalCreditVolumeAfterTrx =
                String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeAfterTrx: " + finalTotalCreditVolumeAfterTrx);

        Assert.assertEquals(finalTransactionsVolumeAfterTrx,finalTransactionsVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitVolumeAfterTrx,finalInterchangeDebitVolumeBeforeTrx);
        Assert.assertEquals(finalTotalDebitVolumeAfterTrx,finalTotalDebitVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditVolumeAfterTrx,finalInterchangeCreditVolumeBeforeTrx);
        Assert.assertEquals(finalTotalCreditVolumeAfterTrx,finalTotalCreditVolumeBeforeTrx);


        //Click Values
        meezaReportPage.clickValues();

        //Values After execute P2P transaction
        //Transactions
        String finalTransactionsValueAfterTrx =
                String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueAfterTrx: " + finalTransactionsValueAfterTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueAfterTrx =
                String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueAfterTrx: " + finalInterchangeDebitValueAfterTrx);

        //Total Debit
        String finalTotalDebitValueAfterTrx =
                String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueAfterTrx: " + finalTotalDebitValueAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditValueAfterTrx =
                String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditValueAfterTrx: " + finalInterchangeCreditValueAfterTrx);

        //Total Credit
        String finalTotalCreditValueAfterTrx =
                String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditValueAfterTrx: " + finalTotalCreditValueAfterTrx);

        //Processing Fees
        double finalProcessingFeesValueAfterTrx =
                meezaReportPage.value_GetProcessingFees().doubleValue();
        System.out.println("finalProcessingFeesValueAfterTrx: " + finalProcessingFeesValueAfterTrx);

        //Net Position
        String finalNetPositionValueAfterTrx =
                String.valueOf(meezaReportPage.value_GetNetPosition());
        System.out.println("finalNetPositionValueAfterTrx: " + finalNetPositionValueAfterTrx);


        Assert.assertEquals(finalTransactionsValueAfterTrx,finalTransactionsValueBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitValueAfterTrx,finalInterchangeDebitValueBeforeTrx);
        Assert.assertEquals(finalTotalDebitValueAfterTrx,finalTotalDebitValueBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditValueAfterTrx,finalInterchangeCreditBeforeTrx);
        Assert.assertEquals(finalTotalCreditValueAfterTrx,finalTotalCreditBeforeTrx);
        Assert.assertEquals(finalProcessingFeesValueAfterTrx,finalProcessingFeesBeforeTrx);
        Assert.assertEquals(finalNetPositionValueAfterTrx,finalNetPositionBeforeTrx);
        driver.quit();
    }
}
