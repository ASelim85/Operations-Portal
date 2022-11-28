package Tests;

import APIS.ATM_CashOut;
import APIS.ReceiveATMCashOut;
import Utils.ExcelFileManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.math.BigDecimal;

public class Dashboard extends TestBase{
    ATM_CashOut atmCashOut = new ATM_CashOut();
    @Test (priority = 0, enabled = true)
    public void CheckDashboardIsDisplayed() throws IOException, InterruptedException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
//        driver.quit();
    }
    @Test (priority = 0, enabled = true)
    public void CheckChartValues() throws IOException, InterruptedException {
        this.CheckDashboardIsDisplayed();
        dashboardPage.get_BPValue();
        dashboardPage.get_CashinValue();
        dashboardPage.get_CashoutValue();
        dashboardPage.get_DepositValue();
        dashboardPage.get_IntRemittanceValue();
        dashboardPage.get_P2MValue();
        dashboardPage.get_P2PValue();

        System.out.println(dashboardPage.BPAmount);
        System.out.println(dashboardPage.BPCount);
        System.out.println(dashboardPage.cashInAmount);
        System.out.println(dashboardPage.cashInCount);
        System.out.println(dashboardPage.cashOutAmount);
        System.out.println(dashboardPage.cashOutCount);
        System.out.println(dashboardPage.depositAmount);
        System.out.println(dashboardPage.depositCount);
        System.out.println(dashboardPage.IntRimAmount);
        System.out.println(dashboardPage.IntRimCount);
        System.out.println(dashboardPage.P2MAmount);
        System.out.println(dashboardPage.P2MCount);
        System.out.println(dashboardPage.P2PAmount);
        System.out.println(dashboardPage.P2PCount);
        driver.quit();
    }


    @Test (priority = 1, enabled = true)
    public void CheckDashboardValues() throws IOException, InterruptedException {
        this.CheckDashboardIsDisplayed();
        BigDecimal prevRevValue = new BigDecimal(dashboardPage.getRevenueValue()).add(new BigDecimal(0));//
        BigDecimal preVolValue  = new BigDecimal(dashboardPage.getVolumeValue()).add(new BigDecimal(12));
        BigDecimal preCashOutValue =  new BigDecimal(dashboardPage.getCashOutValue()).add(new BigDecimal(12));
        BigDecimal preTotalWalletsBalance = new BigDecimal(dashboardPage.getTotalWalletsBalance()).subtract(new BigDecimal(11));
        dashboardPage.get_CashoutValue();
        BigDecimal preCashOutChartValue = new BigDecimal(dashboardPage.cashOutAmount.replaceAll(",", "")).add(new BigDecimal(12));//
        System.out.println("preVolValue is " + preVolValue);
        System.out.println("preCashOutValue is " + preCashOutValue);
        System.out.println("preTotalWalletsBalance is "+ preTotalWalletsBalance);
        System.out.println("preCashOutChartValue is "+preCashOutChartValue);
        Assert.assertTrue(dashboardPage.checkRevenue());
        ReceiveATMCashOut apis = new ReceiveATMCashOut();
        apis.Generate_OTP();
        atmCashOut.ATM_CashOut();
        atmCashOut.ATM_CashOut_Advice();
        Thread.sleep(60000);
        refresh();
        Thread.sleep(2000);
        BigDecimal finalRevValue = new BigDecimal(dashboardPage.getRevenueValue());//
        BigDecimal finalVolValue = new BigDecimal(dashboardPage.getVolumeValue());
        BigDecimal finalCashOutValue = new BigDecimal(dashboardPage.getCashOutValue());
        BigDecimal finalTotalWalletsBalance  = new BigDecimal(dashboardPage.getTotalWalletsBalance());
        dashboardPage.get_CashoutValue();
        BigDecimal finalCashOutChartValue = new BigDecimal(dashboardPage.cashOutAmount.replaceAll(",", ""));//
        System.out.println("finalRevValue is "+finalRevValue);
        System.out.println("finalVolValue is "+finalVolValue);
        System.out.println("finalCashOutValue is "+finalCashOutValue);
        System.out.println("finalTotalWalletsBalance is "+finalTotalWalletsBalance);
        System.out.println("finalCashOutChartValue is "+finalCashOutChartValue);
        Assert.assertEquals(finalRevValue,prevRevValue);
        Assert.assertEquals(finalVolValue,preVolValue);
        Assert.assertEquals(finalCashOutValue,preCashOutValue);
        Assert.assertEquals(finalTotalWalletsBalance,preTotalWalletsBalance);
        Assert.assertEquals(finalCashOutChartValue,preCashOutChartValue);

    }
/*
    @Test (priority = 1, enabled = false)
    public void Log() throws IOException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        //Volume
        String prevVolumeBalance = String.valueOf(dashboardPage.getVolumeValue());
        String finalVolumeBalance = prevVolumeBalance.replaceAll(",","");
        double finalNumberVolumeBalance = Double.parseDouble(finalVolumeBalance);
        System.out.println("Volume: "+ finalNumberVolumeBalance);

        //Volume Transactions
        String prevVolumetrx = dashboardPage.getVolumePrevTrx();
        String finalVolumetrx = prevVolumetrx.replaceAll(",","");
        int finalNumberVolumetrx = Integer.parseInt(finalVolumetrx);
        System.out.println("Volume Transactions: "+ finalNumberVolumetrx);

        //Revenue
        String prevRvBalance = String.valueOf(dashboardPage.getRevenueValue());
        String finalRvBalance = prevRvBalance.replaceAll(",","");
        double finalNumberRvBalance = Double.parseDouble(finalRvBalance);
        System.out.println("Revenues: "+ finalNumberRvBalance);

        //Revenue Transactions
        String prevRvtrx = String.valueOf(dashboardPage.getRevenueValue());
        String finalRvtrx = prevRvtrx.replaceAll(",","");
        int finalNumberRvtrx = Integer.parseInt(finalRvtrx);
        System.out.println("Revenues Transactions: "+ finalNumberRvtrx);

        //CashIn
        String prevCashInBalance = dashboardPage.getCashInPrevBalance();
        String finalCashInBalance = prevCashInBalance.replaceAll(",","");
        double finalNumberCashInBalance = Double.parseDouble(finalCashInBalance);
        System.out.println("CashIn: "+ finalNumberCashInBalance);

        //CashIn Transactions
        String prevCashIntrx = dashboardPage.getCashInPrevTrx();
        String finalCashIntrx = prevCashIntrx.replaceAll(",","");
        int finalNumberCashIntrx = Integer.parseInt(finalCashIntrx);
        System.out.println("CashIn Transactions: "+ finalNumberCashIntrx);

        //ATM_CashOut
        String prevCashOutBalance = String.valueOf(dashboardPage.getCashOutValue());
        String finalCashOutBalance = prevCashOutBalance.replaceAll(",","");
        double finalNumberCashOutBalance = Double.parseDouble(finalCashOutBalance);
        System.out.println("ATM_CashOut: "+ finalNumberCashOutBalance);

        //ATM_CashOut Transactions
        String prevCashOutTrx = dashboardPage.getCashOutPrevTrx();
        String finalCashOutTrx = prevCashOutTrx.replaceAll(",","");
        int finalNumberCashOutTrx = Integer.parseInt(finalCashOutTrx);
        System.out.println("ATM_CashOut Transactions: "+ finalNumberCashOutTrx);

        //Registered Wallets
        String prevRegWalletsTrx = dashboardPage.getRegisteredWalletsPrevTrx();
        int finalRegWalletsTrx = Integer.parseInt(prevRegWalletsTrx);
        System.out.println("Registered Wallets: "+ finalRegWalletsTrx);

        //Pin Set Wallets
        String prevPinSetWalletsTrx = dashboardPage.getPinSetPrevTrx();
        int finalPinSetWalletsTrx = Integer.parseInt(prevPinSetWalletsTrx);
        System.out.println("Pin Set Wallets: "+ finalPinSetWalletsTrx);

        //Total Wallets Balance
        String prevTotalWalletsBalance = String.valueOf(dashboardPage.getTotalWalletsBalance());
        String finalTotalWalletsBalanceEGP = prevTotalWalletsBalance.replaceAll(",","");
        String finalTotalWalletsBalance = finalTotalWalletsBalanceEGP.replaceAll("EGP","");
        double finalNumberTotalWalletsBalance = Double.parseDouble(finalTotalWalletsBalance);
        System.out.println("Total Wallets Balance: "+ finalNumberTotalWalletsBalance);

        //Quarterly Active Wallets
        String prevQAW = dashboardPage.getQAWPrevTrx();
        int finalPrevQAW = Integer.parseInt(prevQAW);
        System.out.println("Quarterly Active Wallets: "+ finalPrevQAW);

        //Monthly Active Wallets
        String prevMAW = dashboardPage.getMAWPrevTrx();
        int finalPrevMAW = Integer.parseInt(prevMAW);
        System.out.println("Monthly Active Wallets: "+ finalPrevMAW);

        //Daily Active Wallets
        String prevDAW = dashboardPage.getDAWPrevTrx();
        int finalPrevDAW = Integer.parseInt(prevDAW);
        System.out.println("Daily Active Wallets: "+ finalPrevDAW);

        //UNRegistered Wallets
        String prevUnRegWalletsTrx = dashboardPage.getUnregisteredWalletsPrevTrx();
        int finalPrevUnRegWalletsTrx = Integer.parseInt(prevUnRegWalletsTrx);
        System.out.println("UNRegistered Wallets: "+ finalPrevUnRegWalletsTrx);
    }

 */
}
