package pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public LoginPage loginwithCredentials(String email, String password){
        By el1=By.id("com.mavi.kartus:id/viewClose");
        wait.until(ExpectedConditions.visibilityOfElementLocated(el1)).click();

        MobileElement el_profil = (MobileElement) driver.findElementByXPath("//*[@text=\"Profilim\"]");
        el_profil.click();
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Mavi.com'a Giriş Yap\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement).click();

        MobileElement el_mail = (MobileElement) driver.findElementByXPath("(//android.widget.EditText)[1]");
       el_mail.sendKeys(email);
        MobileElement el_password = (MobileElement) driver.findElementByXPath("(//android.widget.EditText)[2]");
        el_password.sendKeys(password);

        return this;

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
