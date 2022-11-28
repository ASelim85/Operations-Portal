package APIS;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ATM_CahIn {
    String current = System.getProperty("user.dir");
    static String suuid = UUID.randomUUID().toString();
    JSONObject request = new JSONObject();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss");
    java.util.Date date = new Date();
    String Date = dateFormat.format(date);
    String walletNumber = "00201110693883";
    String WalletPIN = "111111";
    String ATMCashInMmeezaTransactionId;
    String Wallet_ID = "6a317702-3f44-46c1-b05a-86173d72fc34";
    static String OTP;
    Generate_OTP GenerateOTP = new Generate_OTP();

    @SuppressWarnings("unchecked")
    @Test(priority = 0, enabled = true)
    public void Generate_OTP() throws IOException {
        baseURI = "https://apisit.axispay.app:444/crossfunction/axispay-cross-functions/v1/wallet/"+ Wallet_ID +"/generateOTP";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Generate OTP.json")));
        String Send_P2M_Off_Us_Request = jsonBody.replace("MPIN", WalletPIN);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(Send_P2M_Off_Us_Request)
                .when()
                .post()
                .then().assertThat()
                .statusCode(200)
                .log().body().extract().response();

        OTP = response.path("otp");
    }

    @SuppressWarnings("unchecked")
    @Test(priority = 1, enabled = true)
    public void Receive_ATM_Cash_In_Off_US() throws IOException {
//        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/atm/axispay-wallet-transactions/v1/wallet/"+ walletNumber +"/ATMCashIn";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Receive ATM Cash In - Off US.json")));
        String Send_P2M_Off_Us_Request = jsonBody.replace("CLIENTID" ,suuid)
                .replace("TRANSID", suuid)
                .replace("walletNumber", walletNumber)
                .replace("reqTimestamp",Date)
                .replace("OTP", GenerateOTP.OTP);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(Send_P2M_Off_Us_Request)
                .when()
                .post()
                .then().assertThat()
                .statusCode(200)
                .body("MeezaResponse.responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                .body("MeezaResponse.responseCode", Matchers.equalTo("00000"))
                .log().body().extract().response();
        ATMCashInMmeezaTransactionId = response.path("meezaTransactionId");
    }

    //Run Receive_ATM_Cash_In_Advice_Off_US
    @SuppressWarnings("unchecked")
    @Test(priority = 2, enabled = true)
    public void Receive_ATM_Cash_In_Advice_Off_US() throws IOException {
//        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/atm/axispay-wallet-transactions/v1/transaction/ATMCashInAdvice";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Receive ATM Cash In Advice - Off US.json")));
        String Send_P2M_Off_Us_Request = jsonBody.replace("ADVICEID" ,suuid)
                .replace("CLIENTID", suuid)
                .replace("walletNumber", walletNumber)
                .replace("reqTimestamp",Date)
                .replace("ATMCashInMmeezaTransactionId", ATMCashInMmeezaTransactionId);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(Send_P2M_Off_Us_Request)
                .when()
                .post()
                .then().assertThat()
                .statusCode(200)
                .body("responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                .body("responseCode", Matchers.equalTo("00000"))
                .log().body().extract().response();
    }
}
