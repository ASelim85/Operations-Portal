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

public class IMT {
    String current = System.getProperty("user.dir");
    UUID uuid = UUID.randomUUID();
    static String suuid = UUID.randomUUID().toString();
    JSONObject request = new JSONObject();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss");
    java.util.Date date = new Date();
    String Date = dateFormat.format(date);
    String walletNumber = "00201110693883";
    String walletNum2 = "00201001009000";
    String SendP2MmeezaTransactionId;
    String RecieveP2MmeezaTransactionId;
    String Wallet_ID1 = "d1f9938e-7b12-4be3-9d72-a7cff7711d35";
    String P2MRefundTrxID;
    String IMTtransactionId;


    @SuppressWarnings("unchecked")
    @Test(priority = 0, enabled = true)
    public void IMT_Receive_Deposit() throws IOException {
//        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/deposit/axispay-wallet-transactions/v1/wallet/"+ walletNumber +"/receiveDeposit";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\IMT Receive Deposit.json")));
        String Send_P2M_Off_Us_Request = jsonBody.replace("CLIENTID", suuid)
                .replace("walletnumber", walletNumber)
                .replace("TRANSACTIONID",suuid)
                .replace("reqTimestamp",Date);
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

        IMTtransactionId = response.path("transactionId");

    }

    @SuppressWarnings("unchecked")
    @Test(priority = 1, enabled = true)
    public void IMT_Receiv_Deposit_Advice() throws IOException {
//        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/deposit/axispay-wallet-transactions/v1/transaction/"+IMTtransactionId+"/receiveDepositAdvice";

        System.out.println(baseURI);
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\IMT Receive Deposit Advice.json")));
        String Send_P2M_Off_Us_Request = jsonBody.replace("ADVICEID" ,suuid)
                .replace("CLIENTID", suuid)
                .replace("walletNumber", walletNumber)
                .replace("reqTimestamp",Date);
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
