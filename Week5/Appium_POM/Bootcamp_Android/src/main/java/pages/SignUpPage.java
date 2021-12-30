package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SignUpPage extends BasePage {
    public SignUpPage(AndroidDriver driver) {
        super(driver);
    }
    public SignUpPage signupwithCredentials(String email, String password1,String password2){
        By el1=By.id("com.mavi.kartus:id/viewClose");
        wait.until(ExpectedConditions.visibilityOfElementLocated(el1)).click();

        MobileElement el_profil = (MobileElement) driver.findElementByXPath("//*[@text=\"Profilim\"]");
        el_profil.click();
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Mavi.com'a Üye Ol\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement).click();
        By el2=By.xpath("(//android.widget.EditText)[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(el2)).click();
        MobileElement el_mail = (MobileElement) driver.findElementByXPath("(//android.widget.EditText)[1]");
        el_mail.click();
        el_mail.sendKeys(email);

        MobileElement el_ps1 = (MobileElement) driver.findElementByXPath("(//android.widget.EditText)[2]");
        el_ps1.click();
        el_ps1.sendKeys(password1);

        MobileElement el_ps2 = (MobileElement) driver.findElementByXPath("(//android.widget.EditText)[3]");
        el_ps2.click();
        el_ps2.sendKeys(password2);

        return this;

    }
}
