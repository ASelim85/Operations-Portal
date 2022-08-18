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

public class P2P {
    UUID uuid = UUID.randomUUID();
    static String suuid = UUID.randomUUID().toString();
    //JSONObject request = new JSONObject();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss");
    java.util.Date date = new Date();
    String Date = dateFormat.format(date);
    String walletNumber = "00201110693883";
    String walletno = "00201302546622";
    String meezaTranId;
    String mpin = "123456";
    String walletnum = "56d38b5d-26bc-4811-b089-c3539afbf2ff";

    @SuppressWarnings("unchecked")
    @Test(priority = 0, enabled = true)
    public void Receieve_P2P() throws IOException {
        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/p2p/axispay-wallet-transactions/v1/wallet/"+ walletNumber +"/";
        String jsonBody = new String(Files.readAllBytes(Paths.get("C:\\Users\\bezzat\\IdeaProjects\\AxisPayWebAutomationBank\\Json files\\Receive P2P.json")));
        String receivep2pRequest = jsonBody.replace("clientid", suuid)
                .replace("walletnumber", walletNumber)
                .replace("transactionid",suuid)
                .replace("TrxTimeStamp",Date);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(receivep2pRequest)
                .when()
                .post("receiveP2P")
                .then().assertThat()
                .statusCode(200)
                .body("MeezaResponse.responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                .body("MeezaResponse.responseCode", Matchers.equalTo("00000"))
                .log().body().extract().response();

        meezaTranId = response.path("meezaTransactionId");
        System.out.println(meezaTranId);
    }

    @SuppressWarnings("unchecked")
    @Test(priority = 1, enabled = true)
    public void Receieve_P2P_OffUs_Advice() throws IOException {
        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/p2p/axispay-wallet-transactions/v1/transaction/"+meezaTranId+"/";
        String jsonBody = new String(Files.readAllBytes(Paths.get("C:\\Users\\bezzat\\IdeaProjects\\AxisPayWebAutomationBank\\Json files\\Receive P2P Advice.json")));
        String receivep2pRequest = jsonBody.replace("ADVICEID", suuid)
                .replace("walletnumber", walletNumber)
                .replace("CLIENTID",suuid)
                .replace("TrxTimeStamp",Date);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(receivep2pRequest)
                .when()
                .post("receiveP2PAdvice")
                .then().assertThat()
                .statusCode(200)
                .body("responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                .body("responseCode", Matchers.equalTo("00000"))
                .log().body().extract().response();
    }

    @Test(priority = 2, enabled = true)
    public void Send_P2P() throws IOException {
        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/p2p/axispay-wallet-transactions/v1/wallet/"+ walletnum +"/";
        String jsonBody = new String(Files.readAllBytes(Paths.get("C:\\Users\\bezzat\\IdeaProjects\\AxisPayWebAutomationBank\\Json files\\Send P2P.json")));
        String sendp2pRequest = jsonBody.replace("mpin", mpin)
                .replace("TrxTimeStamp",Date);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(sendp2pRequest)
                .when()
                .post("sendP2P")
                .then().assertThat()
                .statusCode(200)
                .body("interchangeAction", Matchers.equalTo("Debit"))
                .body("receiverSchemeName", Matchers.equalTo("Vodafone"))
                .log().body().extract().response();

        meezaTranId = response.path("meezaTransactionId");
        System.out.println(meezaTranId);
    }

    @Test(priority = 3, enabled = true)
    public void Send_P2P_OffUs_Advice() throws IOException {
        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/p2p/axispay-wallet-transactions/v1/transaction/"+meezaTranId+"/";
        String jsonBody = new String(Files.readAllBytes(Paths.get("C:\\Users\\bezzat\\IdeaProjects\\AxisPayWebAutomationBank\\Json files\\Send P2P Advice.json")));
        String receivep2pRequest = jsonBody.replace("ADVICEID", suuid)
                .replace("walletnumber", walletno)
                .replace("CLIENTID",suuid)
                .replace("TrxTimeStamp",Date);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(receivep2pRequest)
                .when()
                .post("receiveP2PAdvice")
                .then().assertThat()
                .statusCode(200)
                .body("responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                .body("responseCode", Matchers.equalTo("00000"))
                .log().body().extract().response();
    }
}
