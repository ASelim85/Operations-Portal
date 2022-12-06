package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static By txtUsername = By.id("basic_login");
    public static By txtPassword = By.id("basic_password");
    public static By btnSignIn = By.xpath("//button[@type='submit']");
    public static By errorMSG = By.xpath("/html/body/div[2]/div");
    public static By txtOTP = By.id("basic_otp");
    public static By btnVerifyOTP = By.xpath("//button[@type='submit']");

    public static void setUsername(String username) {
        setText(txtUsername, username);
    }

    public static void setPassword(String password) {
        setText(txtPassword, password);
    }

    public static void clickSignIn() {
        click(btnSignIn);
    }

    public static String GetErrorMSG() {
        waitElement(errorMSG);
        String InvalidPassErrMSG = action(errorMSG).getText();
        return InvalidPassErrMSG;
    }

    public static void setOTP(String otp) {
        setText(txtOTP, otp);
    }

    public static void clickVerifyOTP() {
        click(btnVerifyOTP);
    }
}
