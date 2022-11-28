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

import static io.restassured.RestAssured.given;

public class ReceiveATMCashOut {
    static String OTP;
    static String ID;
    static String meezaTranId;
    UUID uuid = UUID.randomUUID();
    static String suuid = UUID.randomUUID().toString();
    JSONObject request = new JSONObject();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss");
    java.util.Date date = new Date();
    String Date = dateFormat.format(date);

    @SuppressWarnings("unchecked")
    @Test(priority = 0, enabled = false)
    public void Generate_OTP() {
        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/crossfunction/axispay-cross-functions/v1/wallet/a3e3daa7-b7f8-45f5-a7ac-fbb61608544b";
        request.put("transactionAmount", "10");
        request.put("transactionCurrency", "EGP");
        request.put("mpin", "111111");
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .all()
                .when()
                .post("generateOTP")
                .then().assertThat()
                .statusCode(200)
                .body("transactionAmount", Matchers.equalTo(10))
                .log().all().extract().response();
        OTP = response.path("otp");
        ID = response.path("id");
        System.out.println(OTP);
        System.out.println(ID);
    }
    @Test(priority = 1, enabled = true)
    public void Receive_ATM_CashOut() throws IOException {
        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/atm/axispay-wallet-transactions/v1/wallet/00201110693883/";
        String jsonBody = new String(Files.readAllBytes(Paths.get("C:\\Users\\bezzat\\IdeaProjects\\AxisPayWebAutomationBank\\Json files\\Json Request.json")));
        String body = jsonBody.replace("MezzaID", suuid).replace("date", Date);
        Response response =
                given().
                        contentType("application/json")
                        .accept("application/json")
                        .header("Content-Type", "application/json")
                        .log()
                        .body()
                        .body(body)
                        .when()
                        .post("ATMCashOut")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .body("MeezaResponse.responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                        .log().body().extract().response();
        meezaTranId = response.path("meezaTransactionId");
        System.out.println("meezaTranId is " + meezaTranId);

    }
    @SuppressWarnings("unchecked")
    @Test(priority = 1, enabled = true)
    public void Receive_ATM_CashOut_Advice() throws IOException {

        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/atm/axispay-wallet-transactions/v1/transaction/";
        request.put("adviceId", "eb9b245d-8c96-4ab4-80d6-c124e078fc65");
        request.put("clientId", "95849bb2-bc60-4612-a21a-f1cca814e748");
        request.put("interchangeAction", "Debit");
        request.put("interchangeCurrency", "EGP");
        request.put("interchangeValue", "1");
        request.put("meezaOriginalTransactionId", meezaTranId);
        request.put("receiverAddress", "24 El dokki street");
        request.put("receiverName", "Ahmed Selim");
        request.put("responseCode", "00000");
        request.put("responseDescription", "Approved Or Completed Successfully");
        request.put("senderId", "00201110693883");
        request.put("transactionCurrency", "EGP");
        request.put("transactionDescription", "Gift");
        request.put("transactionTimestamp", "2022-08-09T14:17:38.523");
        request.put("transactionValue", "11");
        Response response =
                given().
                        contentType("application/json")
                        .accept("application/json")
                        .header("Content-Type", "application/json")
                        .body(request.toJSONString())
                        .log().all()
                        .when()
                        .post("ATMCashOutAdvice")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .body("responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                        .log().all()
                        .extract().response();

    }
}
