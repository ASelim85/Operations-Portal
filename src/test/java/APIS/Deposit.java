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

public class Deposit {
    String current = System.getProperty("user.dir");
    UUID uuid = UUID.randomUUID();
    static String suuid = UUID.randomUUID().toString();
    static String adviceuuid = UUID.randomUUID().toString();
    //JSONObject request = new JSONObject();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss");
    java.util.Date date = new Date();
    String Date = dateFormat.format(date);
    String walletNumber = "00201110693883";
    String receiverId = "00201008855588";
    String meezaTranId;
    String mpin = "123456";
    String walletnum = "ea2bb7d5-8d7c-43f7-b1e3-6c67972959d3";

    @Test(priority = 0, enabled = true)
    public void Receive_Deposit_OffUS() throws IOException {
        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/deposit/axispay-wallet-transactions/v1/wallet/" + walletNumber + "/";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Receive Deposit.json")));
        String receiveDepositRequest = jsonBody.replace("clientid", suuid)
                .replace("walletnumber", walletNumber)
                .replace("transactionid", suuid)
                .replace("TrxTimeStamp", Date);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(receiveDepositRequest)
                .when()
                .post("receiveDeposit")
                .then().assertThat()
                .statusCode(200)
                .body("responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                .body("responseCode", Matchers.equalTo("00000"))
                .log().body().extract().response();

        meezaTranId = response.path("transactionId");
        System.out.println(meezaTranId);
    }

    @Test(priority = 1, enabled = true)
    public void Receive_Deposit_OffUs_Advice() throws IOException {
        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/deposit/axispay-wallet-transactions/v1/transaction/"+meezaTranId+"/receiveDepositAdvice";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Receive Deposit Advice.json")));
        String receiveDepositRequest = jsonBody.replace("ADVICEID", adviceuuid)
                .replace("walletnumber", walletNumber)
                .replace("CLIENTID",suuid)
                .replace("TrxTimeStamp",Date);
        System.out.println(baseURI);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(receiveDepositRequest)
                .when()
                .post()
                .then().assertThat()
                .statusCode(200)
                .body("responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                .body("responseCode", Matchers.equalTo("00000"))
                .log().body().extract().response();
    }

    @Test(priority = 2, enabled = true)
    public void Send_Deposit_OffUS() throws IOException {
        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/deposit/axispay-wallet-transactions/v1/wallet/"+walletnum+"/";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Send Deposit.json")));
        String receiveDepositRequest = jsonBody.replace("receiverid", receiverId)
                .replace("TrxTimeStamp", Date);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(receiveDepositRequest)
                .when()
                .post("payrollDeposit")
                .then().assertThat()
                .statusCode(200)
                .body("depositType", Matchers.equalTo("TransactionTypes_PAYROLL_DEPOSIT"))
                .body("receiverSchemeName", Matchers.equalTo("Vodafone"))
                .log().body().extract().response();

        meezaTranId = response.path("meezaTransactionId");
        System.out.println(meezaTranId);
    }

    @Test(priority = 3, enabled = true)
    public void Send_Deposit_Advice_OffUs() throws IOException {
        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/deposit/axispay-wallet-transactions/v1/transaction/"+meezaTranId+"/";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current+ "\\Json files\\Send Deposit Advice.json")));
        String receiveDepositRequest = jsonBody.replace("ADVICEID", adviceuuid)
                .replace("receiverid", receiverId)
                .replace("CLIENTID",suuid)
                .replace("TrxTimeStamp",Date);
        System.out.println(baseURI);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(receiveDepositRequest)
                .when()
                .post("receiveDepositAdvice")
                .then().assertThat()
                .statusCode(200)
                .body("responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                .body("responseCode", Matchers.equalTo("00000"))
                .log().body().extract().response();
    }
}
