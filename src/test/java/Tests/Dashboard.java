package Tests;

import APIS.ReceiveATMCashOut;
import Utils.ExcelFileManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Dashboard extends TestBase{

    @Test
    public void CheckRevenueBalance_ATM_CashOut() throws IOException, InterruptedException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        String prevRevBalance = dashboardPage.getRevenuePrevBalance();
        String finalprevBalance = prevRevBalance.replaceAll(",","");
        double finalNumberprevBalance = Double.parseDouble(finalprevBalance);
        System.out.println(finalNumberprevBalance);
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
        Assert.assertTrue(dashboardPage.checkRevenue());
        ReceiveATMCashOut apis = new ReceiveATMCashOut();
        apis.Generate_OTP();
        apis.Receive_ATM_CashOut();
        apis.Receive_ATM_CashOut_Advice();
        Thread.sleep(6000);
        refresh();
        String prevRvBalance = dashboardPage.getRevenuePrevBalance();
        String finalRvBalance = prevRvBalance.replaceAll(",","");
        double finalNumberRvBalance = Double.parseDouble(finalRvBalance);
        System.out.println(finalNumberRvBalance);
        Assert.assertEquals(finalNumberRvBalance,finalNumberprevBalance);
    }

    @Test
    public void Log() throws IOException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        //Volume
        String prevVolumeBalance = dashboardPage.getVolumePrevBalance();
        String finalVolumeBalance = prevVolumeBalance.replaceAll(",","");
        double finalNumberVolumeBalance = Double.parseDouble(finalVolumeBalance);
        System.out.println("Volume: "+ finalNumberVolumeBalance);

        //Volume Transactions
        String prevVolumetrx = dashboardPage.getVolumePrevTrx();
        String finalVolumetrx = prevVolumetrx.replaceAll(",","");
        int finalNumberVolumetrx = Integer.parseInt(finalVolumetrx);
        System.out.println("Volume Transactions: "+ finalNumberVolumetrx);

        //Revenue
        String prevRvBalance = dashboardPage.getRevenuePrevBalance();
        String finalRvBalance = prevRvBalance.replaceAll(",","");
        double finalNumberRvBalance = Double.parseDouble(finalRvBalance);
        System.out.println("Revenues: "+ finalNumberRvBalance);

        //Revenue Transactions
        String prevRvtrx = dashboardPage.getRevenuePrevTrx();
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

        //CashOut
        String prevCashOutBalance = dashboardPage.getCashOutPrevBalance();
        String finalCashOutBalance = prevCashOutBalance.replaceAll(",","");
        double finalNumberCashOutBalance = Double.parseDouble(finalCashOutBalance);
        System.out.println("CashOut: "+ finalNumberCashOutBalance);

        //CashOut Transactions
        String prevCashOutTrx = dashboardPage.getCashOutPrevTrx();
        String finalCashOutTrx = prevCashOutTrx.replaceAll(",","");
        int finalNumberCashOutTrx = Integer.parseInt(finalCashOutTrx);
        System.out.println("CashOut Transactions: "+ finalNumberCashOutTrx);

        //Registered Wallets
        String prevRegWalletsTrx = dashboardPage.getRegisteredWalletsPrevTrx();
        int finalRegWalletsTrx = Integer.parseInt(prevRegWalletsTrx);
        System.out.println("Registered Wallets: "+ finalRegWalletsTrx);

        //Pin Set Wallets
        String prevPinSetWalletsTrx = dashboardPage.getPinSetPrevTrx();
        int finalPinSetWalletsTrx = Integer.parseInt(prevPinSetWalletsTrx);
        System.out.println("Pin Set Wallets: "+ finalPinSetWalletsTrx);

        //Total Wallets Balance
        String prevTotalWalletsBalance = dashboardPage.getTotalWalletsPrevBalance();
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
}
