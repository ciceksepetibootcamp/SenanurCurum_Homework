package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.Assert;


public class LoginPage extends BasePage {
    public static final By el1=By.id("com.mavi.kartus:id/viewClose");
    public static final By profile= By.xpath("//*[@text=\"Profilim\"]");
    String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Mavi.com'a Giriş Yap\").instance(0))";
    public static final By el_email=By.xpath("(//android.widget.EditText)[1]");
    public static final By el_password=By.xpath("(//android.widget.EditText)[2]");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }
    public void loginwithCredentials(String email,String password){
        driver.findElement(el1).click();
        driver.findElement(profile).click();
        driver.findElementByAndroidUIAutomator(scrollElement).click();
        driver.findElement(el_email).click();
        driver.findElement(el_password).click();

    }
    public void checkLoginMessage(String msg){
        MobileElement el_check=driver.findElementByXPath("//android.widget.TextView[1]");
        Assert.assertTrue(el_check.getText().contains("Merhaba"));
    }
    public void checkErrorMessage(String msg){
        MobileElement el_check=driver.findElementByXPath("//*[@text=\"Girilen email adresi veya parola hatalıdır.\"]");
        Assert.assertTrue(el_check.getText().contains("Girilen email adresi veya parola hatalıdır"));
    }
}