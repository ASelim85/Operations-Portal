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

public class Agent_CashOut {
    JSONObject request = new JSONObject();
    UUID uuid = UUID.randomUUID();
    static String clientuuid = UUID.randomUUID().toString();
    static String suuid = UUID.randomUUID().toString();

    static String newtrxid = UUID.randomUUID().toString();

    static String uuids = UUID.randomUUID().toString();

    //JSONObject request = new JSONObject();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss");
    java.util.Date date = new Date();
    String Date = dateFormat.format(date);
    String walletnumber = "00201110693883";
    String current = System.getProperty("user.dir");

    String AgentCashOutMeezaTransactionId;
    String initiatedCashInOutDetailsId;
    String SendAgentCashOutTrxID;
    String SendAgentCashOutTrxRef;
    Generate_OTP Generate_OTP = new Generate_OTP();

    //Run Receive_Agent_Cash_Out_Off_US
    @SuppressWarnings("unchecked")
    @Test(priority = 0, enabled = true)
    public void Receive_Agent_Cash_Out_Off_US() throws IOException {
        JSONObject request = new JSONObject();
        Generate_OTP.Generate_OTP();
        baseURI = "https://apisit.axispay.app:444/cashinout/axispay-wallet-transactions/v1/wallet/"+walletnumber+"/receiveCashOut";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Receive Agent Cash Out - Off US.json")));
        String AgentCashoutReq = jsonBody.replace("TRXID", suuid)
                .replace("CLIENTID", clientuuid)
                .replace("TrxTimeStamp", Date)
                .replace("RqTimeStamp",Date)
                .replace("OTP",Generate_OTP.OTP)
                .replace("WalletNumber", walletnumber);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(AgentCashoutReq)
                .when()
                .post()
                .then().assertThat()
                .statusCode(200)
                .body("meezaResponse.responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                .body("meezaResponse.responseCode", Matchers.equalTo("00000"))
                .log().body().extract().response();

        AgentCashOutMeezaTransactionId = response.path("meezaTransactionId");
    }

    //Run Receive_Agent_Cash_Out_Advice_Off_US
    @SuppressWarnings("unchecked")
    @Test(priority = 1, enabled = true)
    public void Receive_Agent_Cash_Out_Advice_Off_US() throws IOException {
        baseURI = "https://apisit.axispay.app:444/cashinout/axispay-wallet-transactions/v1/transaction/"+AgentCashOutMeezaTransactionId+"/receiveCashOutAdvice";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Receive Agent Cash Out Advice - Off US.json")));
        String AgentCashoutReq_Advice = jsonBody.replace("TRXID", suuid)
                .replace("CLIENTID" ,clientuuid)
                .replace("ADVICEID", newtrxid)
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
                .body(AgentCashoutReq_Advice)
                .when()
                .post()
                .then().assertThat()
                .statusCode(200)
                .body("responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                .body("responseCode", Matchers.equalTo("00000"))
                .log().body().extract().response();
    }

    //Run Receive_Agent_Cash_Out_Reversal
    @SuppressWarnings("unchecked")
    @Test(priority = 2, enabled = true)
    public void Receive_Agent_Cash_Out_Reversal() throws IOException {
        baseURI = "https://apisit.axispay.app:444/cashinout/axispay-wallet-transactions/v1/wallet/"+walletnumber+"/receiveAgentCashOutReversal";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Receive Agent Cash Out -Reversal.json")));
        String AgentCashoutReq_Reversal = jsonBody
                .replace("CLIENTID" ,suuid)
                .replace("MeezaTransactionId", AgentCashOutMeezaTransactionId)
                .replace("WALLETNUMBER", walletnumber)
                .replace("TRXID", uuids)
                .replace("TRXTIMESTMP",Date);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(AgentCashoutReq_Reversal)
                .when()
                .post()
                .then().assertThat()
                .statusCode(200)
                .body("responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                .body("responseCode", Matchers.equalTo("00000"))
                .log().body().extract().response();
    }

    //Run Initiate_Agent_Cash_Out
    @SuppressWarnings("unchecked")
    @Test(priority = 3, enabled = true)
    public void Initiate_Agent_Cash_Out() throws IOException {

        baseURI = "https://apisit.axispay.app:444/cashinout/axispay-wallet-transactions/v1/user/ebeafd05-8245-4dfd-9a10-ba3095971aab/initiateCashOut";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Initiate_Agent_Cash_Out.json")));
        String InitiateAgentCashOut = jsonBody
                .replace("TRXTIMESTMP",Date)
                .replace("WALLETNUMBER", walletnumber);

        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(InitiateAgentCashOut)
                .when()
                .post()
                .then().assertThat()
                .statusCode(200)
                .log().body().extract().response();
        initiatedCashInOutDetailsId = response.path("initiatedCashInOutDetailsId");
    }

    //Run Send_Agent_Cash_Out
    @SuppressWarnings("unchecked")
    @Test(priority = 4, enabled = true)
    public void Send_Agent_Cash_Out() throws IOException {
        Generate_OTP.Generate_OTP();
        baseURI = "https://apisit.axispay.app:444/cashinout/axispay-wallet-transactions/v1/user/ebeafd05-8245-4dfd-9a10-ba3095971aab/sendCashOut";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Send_Agent_Cash_Out.json")));
        String SendAgentCashOut = jsonBody
                .replace("INITIATEDTRX" ,initiatedCashInOutDetailsId)
                .replace("OTP", Generate_OTP.OTP);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(SendAgentCashOut)
                .when()
                .post()
                .then().assertThat()
                .statusCode(200)
                .body("transactionDomain", Matchers.equalTo("TransactionDomains_ON_US"))
                .body("transactionType", Matchers.equalTo("TransactionTypes_AGENT_CASH_OUT"))
                .body("transactionStatus", Matchers.equalTo("TransactionStatus_POSTED"))
                .log().body().extract().response();
        SendAgentCashOutTrxID = response.path("transactionId");
        SendAgentCashOutTrxRef =response.path("transactionReference");
    }

    //Run Send_Agent_Cash_Out_Reversal
    @SuppressWarnings("unchecked")
    @Test(priority = 5, enabled = true)
    public void Send_Agent_Cash_Out_Reversal() throws IOException {
        Generate_OTP.Generate_OTP();
        baseURI = "https://apisit.axispay.app:444/cashinout/axispay-wallet-transactions/v1/user/ebeafd05-8245-4dfd-9a10-ba3095971aab/sendCashOutReversal";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\Send_Agent_Cash_Out_Reversal.json")));
        String SendAgentCashOutReversal = jsonBody
                .replace("ORGTRXID" ,SendAgentCashOutTrxID)
                .replace("WALLETNUMBER", walletnumber)
                .replace("CashOutTrxRef", SendAgentCashOutTrxRef)
                .replace("ReqTimeStmp", Date);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(SendAgentCashOutReversal)
                .when()
                .post()
                .then().assertThat()
                .statusCode(200)
                .body("transactionDomain", Matchers.equalTo("TransactionDomains_ON_US"))
                .body("transactionType", Matchers.equalTo("TransactionTypes_AGENT_CASH_OUT_REVERSAL"))
                .body("transactionStatus", Matchers.equalTo("TransactionStatus_POSTED"))
                .log().body().extract().response();
    }
}
