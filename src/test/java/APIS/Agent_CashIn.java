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

public class Agent_CashIn {
    JSONObject request = new JSONObject();
    UUID uuid = UUID.randomUUID();
    static String clientuuid = UUID.randomUUID().toString();
    static String suuid = UUID.randomUUID().toString();

    static String newtrxid = UUID.randomUUID().toString();

    static String uuids = UUID.randomUUID().toString();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss");
    java.util.Date date = new Date();
    String Date = dateFormat.format(date);
    String walletnumber = "00201110693883";
    String current = System.getProperty("user.dir");
    String AgentCashInMeezaTransactionId;
    String InitiatedCashInOutDetailsId;
    String SendAgentCashOutTrxID;
    String SendAgentCashOutTrxRef;
    Generate_OTP Generate_OTP = new Generate_OTP();

    //Run Receive_Agent_Cash_Out_Off_US
    @SuppressWarnings("unchecked")
    @Test(priority = 0, enabled = true)
    public void Initiate_Agent_Cash_In() throws IOException {
        JSONObject request = new JSONObject();
        Generate_OTP.Generate_OTP();
        baseURI = "https://apisit.axispay.app:444/cashinout/axispay-wallet-transactions/v1/user/ebeafd05-8245-4dfd-9a10-ba3095971aab/initiateCashOut";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Initiate Agent Cash In.json")));
        String InitiateAgentCashIn = jsonBody.replace("TrxTimeStamp", Date);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(InitiateAgentCashIn)
                .when()
                .post()
                .then().assertThat()
                .statusCode(200)
                .log().body().extract().response();
        InitiatedCashInOutDetailsId = response.path("initiatedCashInOutDetailsId");
    }

    //Run Receive_Agent_Cash_In_Off_US
    @SuppressWarnings("unchecked")
    @Test(priority = 1, enabled = true)
    public void Receive_Agent_Cash_In_Off_US() throws IOException {
        baseURI = "https://apisit.axispay.app:444/cashinout/axispay-wallet-transactions/v1/wallet/"+walletnumber+"/receiveCashIn";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Receive Agent Cash In - Off US.json")));
        String ReceiveAgentCashInOffUS = jsonBody.replace("TRXID", suuid)
                .replace("CLIENTID" ,clientuuid)
                .replace("TRXTIMESTMP",Date)
                .replace("REQTIMESTMP", Date)
                .replace("OTP", Generate_OTP.OTP)
                .replace("WALLETNUMBER", walletnumber);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(ReceiveAgentCashInOffUS)
                .when()
                .post()
                .then().assertThat()
                .statusCode(200)
                .body("meezaResponse.responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                .body("meezaResponse.responseCode", Matchers.equalTo("00000"))
                .log().body().extract().response();
        AgentCashInMeezaTransactionId = response.path("meezaTransactionId");
    }

    //Run Receive Agent Cash In Advice - Off US
    @SuppressWarnings("unchecked")
    @Test(priority = 2, enabled = true)
    public void Receive_Agent_Cash_In_Advice_Off_US() throws IOException {
        baseURI = "https://apisit.axispay.app:444/cashinout/axispay-wallet-transactions/v1//transaction/"+AgentCashInMeezaTransactionId+"/receiveCashInAdvice";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Receive Agent Cash In Advice - Off US.json")));
        String ReceiveAgentCashInAdviceOffUS = jsonBody
                .replace("CLIENTID" ,suuid)
                .replace("ADVICEID" ,suuid)
                .replace("TRXTIMESTMP",Date)
                .replace("REQTIMESTMP", Date)
                .replace("WALLETNUMBER", walletnumber);

        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(ReceiveAgentCashInAdviceOffUS)
                .when()
                .post()
                .then().assertThat()
                .statusCode(200)
                .body("responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                .body("responseCode", Matchers.equalTo("00000"))
                .log().body().extract().response();
    }
}
