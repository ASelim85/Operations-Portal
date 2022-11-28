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

public class P2M {
    String current = System.getProperty("user.dir");
    String walletnumber = "00201110693883";
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


    @SuppressWarnings("unchecked")
    @Test(priority = 0, enabled = true)
    public void Send_P2M_Off_Us() throws IOException {
//        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/p2m/axispay-wallet-transactions/v1/wallet/"+Wallet_ID1+"/sendP2M";

        System.out.println(baseURI);
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Send P2M Off Us.json")));
        String Send_P2M_Off_Us_Request = jsonBody.replace("clientid", suuid)
                .replace("walletnumber", walletNumber)
                .replace("transactionid",suuid)
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
                .body("transactionDomain", Matchers.equalTo("TransactionDomains_OFF_US"))
                .log().body().extract().response();

        SendP2MmeezaTransactionId = response.path("meezaTransactionId");

    }

    @SuppressWarnings("unchecked")
    @Test(priority = 1, enabled = true)
    public void Send_P2M_Off_Us_Advice() throws IOException {
//        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/p2m/axispay-wallet-transactions/v1/transaction/"+SendP2MmeezaTransactionId+"/receiveP2MAdvice";

        System.out.println(baseURI);
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Send P2M Off Us Advice.json")));
        String Send_P2M_Off_Us_Request = jsonBody.replace("ADVICEID" ,suuid)
                .replace("CLIENTID", suuid)
                .replace("walletNum2", walletNum2)
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

    @SuppressWarnings("unchecked")
    @Test(priority = 2, enabled = true)
    public void Receive_P2M() throws IOException {
//        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/p2m/axispay-wallet-transactions/v1/wallet/123200001/receiveP2M";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Receive P2M.json")));
        String Send_P2M_Off_Us_Request = jsonBody.replace("CLIENTID", suuid)
                .replace("walletNumber", walletNum2)
                .replace("TRXID",suuid)
                .replace("TIMESTMP",Date);
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

        RecieveP2MmeezaTransactionId = response.path("meezaTransactionId");
        System.out.print(RecieveP2MmeezaTransactionId);

    }

    @SuppressWarnings("unchecked")
    @Test(priority = 3, enabled = true)
    public void Recieve_P2M_Off_Us_Advice() throws IOException {
//        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/p2m/axispay-wallet-transactions/v1/transaction/"+RecieveP2MmeezaTransactionId+"/receiveP2MAdvice";
        System.out.print(baseURI);
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Receive P2M Advice.json")));
        String Send_P2M_Off_Us_Request = jsonBody.replace("ADVICEID" ,suuid)
                .replace("CLIENTID", suuid)
                .replace("walletNumber", walletNum2)
                .replace("TIMESTMP",Date);
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


    @SuppressWarnings("unchecked")
    @Test(priority = 4, enabled = true)
    public void Receive_P2M_Refund() throws IOException {
//        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/p2m/axispay-wallet-transactions/v1/wallet/"+ walletNumber+"/receiveP2MRefund";
        System.out.print(baseURI);
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Receive P2M Refund.json")));
        String Send_P2M_Off_Us_Request = jsonBody.replace("CLIENTID", suuid)
                .replace("TRXID" ,suuid)
                .replace("TIMESTMP",Date);
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
        P2MRefundTrxID = response.path("transactionId");
    }
    @SuppressWarnings("unchecked")
    @Test(priority = 5, enabled = true)
    public void Receive_P2M_Refund_Advice() throws IOException {
//        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/p2m/axispay-wallet-transactions/v1/transaction/"+ P2MRefundTrxID +"/receiveP2MRefundAdvice";
        System.out.print(baseURI);
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Receive P2M Refund Advice.json")));
        String Send_P2M_Off_Us_Request = jsonBody.replace("ADVICEID" ,suuid)
                .replace("CLIENTID", suuid)
                .replace("walletNumber", walletNumber)
                .replace("TIMESTMP",Date);
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
