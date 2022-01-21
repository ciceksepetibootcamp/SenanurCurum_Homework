package tests;

import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {

    @Test
    public void signupwith_exist_email() throws InterruptedException{
        SignUpPage signuppage= new SignUpPage(driver);
        signuppage.signupwithCredentials("test_mail","test_password","test_password");
        MobileElement el_tik = (MobileElement) driver.findElementById("com.mavi.kartus:id/imgCheckBoxEmailPermission");
        el_tik.click();
        MobileElement el_devam_et = (MobileElement) driver.findElementByXPath("(//android.widget.RelativeLayout)[13]");
        el_devam_et.click();

    }
    @Test
    public void signupwith_invalid_email() throws InterruptedException{
        SignUpPage signuppage= new SignUpPage(driver);
        signuppage.signupwithCredentials("test","P@ssw0rd.","P@ssw0rd.");
        MobileElement el_tik = (MobileElement) driver.findElementById("com.mavi.kartus:id/imgCheckBoxEmailPermission");
        el_tik.click();
        MobileElement el_devam_et = (MobileElement) driver.findElementByXPath("(//android.widget.RelativeLayout)[13]");
        el_devam_et.click();


    }
}
