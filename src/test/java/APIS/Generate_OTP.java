package APIS;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Generate_OTP {
    public static String OTP;
    static String ID;
    static String meezaTranId;
    UUID uuid = UUID.randomUUID();
    static String suuid = UUID.randomUUID().toString();
    JSONObject request = new JSONObject();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss");
    java.util.Date date = new Date();
    String Date = dateFormat.format(date);
    String current = System.getProperty("user.dir");

    @SuppressWarnings("unchecked")
    @Test(priority = 0, enabled = true)
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
                .body()
                .when()
                .post("generateOTP")
                .then().assertThat()
                .statusCode(200)
                .body("transactionAmount", Matchers.equalTo(10))
                .log().body().extract().response();
        OTP = response.path("otp");
        ID = response.path("id");
    }
}
