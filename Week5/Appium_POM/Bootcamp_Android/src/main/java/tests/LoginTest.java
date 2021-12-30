package tests;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    @Test
    public void successfullLogin() throws InterruptedException {

        LoginPage loginPage=new LoginPage(driver);
        loginPage.loginwithCredentials("senanurcurum@gmail.com","P@ssw0rd.");
        MobileElement els7 = (MobileElement) driver.findElementByXPath("//*[@text=\"Mavi.com'a Giriş Yap\"]");
        els7.click();
        MobileElement els8 = (MobileElement) driver.findElementByXPath("//*[@text=\"Onayla\"]");
        els8.click();
        loginPage.checkLoginMessage("Merhaba");


    }
    @Test
    public void wrongpasswordLogin() throws InterruptedException{

        LoginPage loginPage=new LoginPage(driver);
        loginPage.loginwithCredentials("senanurcurum@gmail.com","1905");
        MobileElement els7 = (MobileElement) driver.findElementByXPath("//*[@text=\"Mavi.com'a Giriş Yap\"]");
        els7.click();
        loginPage.checkErrorMessage("Girilen email adresi veya parola hatalıdır");

    }
}
