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

public class CashOut {
    UUID uuid = UUID.randomUUID();
    static String clientuuid = UUID.randomUUID().toString();
    static String suuid = UUID.randomUUID().toString();

    static String uuids = UUID.randomUUID().toString();

    //JSONObject request = new JSONObject();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss");
    java.util.Date date = new Date();
    String Date = dateFormat.format(date);
    String walletnumber = "00201110693883";
    String current = System.getProperty("user.dir");

    String meezaCashoutTranId;



    @SuppressWarnings("unchecked")
    @Test(priority = 0, enabled = true)
    public void ATM_CashOut() throws IOException {
        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/atm/axispay-wallet-transactions/v1/wallet/"+walletnumber+"/ATMCashOut";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\ATM Cashout.json")));
        String receivep2pRequest = jsonBody.replace("clientid", clientuuid)
                .replace("senderid", walletnumber)
                .replace("meezatransactionid",suuid)
                .replace("TrxTimeStamp",Date);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(baseURI)
                .body(receivep2pRequest)
                .when()
                .post()
                .then().assertThat()
                .statusCode(200)
                .body("MeezaResponse.responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                .body("MeezaResponse.responseCode", Matchers.equalTo("00000"))
                .log().body().extract().response();

        meezaCashoutTranId = response.path("meezaTransactionId");
        System.out.println(meezaCashoutTranId);
    }

    @SuppressWarnings("unchecked")
    @Test(priority = 1, enabled = true)
    public void ATM_CashOut_Advice() throws IOException {
        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/atm/axispay-wallet-transactions/v1/transaction/ATMCashOutAdvice";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\ATM Cashout Advice.json")));
        String receivep2pRequest = jsonBody.replace("ADVICEID", suuid)
                .replace("senderid", walletnumber)
                .replaceAll("meezacashouttranid",meezaCashoutTranId)
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
                .post()
                .then().assertThat()
                .statusCode(200)
                .body("responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                .body("responseCode", Matchers.equalTo("00000"))
                .log().body().extract().response();
    }

    @Test(priority = 2, enabled = true)
    public void ATM_CashOut_Reversal() throws IOException {
        JSONObject request = new JSONObject();
        baseURI = "https://apisit.axispay.app:444/atm/axispay-wallet-transactions/v1/wallet/"+walletnumber+"/ATMCashOutReversal";
        String jsonBody = new String(Files.readAllBytes(Paths.get(current + "\\Json files\\ATM Cashout Reversal.json")));
        String atmCashoutReversal = jsonBody.replace("clientid", clientuuid)
                .replace("senderid", walletnumber)
                .replaceAll("transactionid",uuids)
                .replaceAll("meezacashouttranid",meezaCashoutTranId)
                .replace("TrxTimeStamp",Date);
        // @formatter:off
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .log()
                .body()
                .body(atmCashoutReversal)
                .when()
                .post()
                .then().assertThat()
                .statusCode(200)
                .body("responseDescription", Matchers.equalTo("Approved Or Completed Successfully"))
                .body("responseCode", Matchers.equalTo("00000"))
                .log().body().extract().response();
    }
}
