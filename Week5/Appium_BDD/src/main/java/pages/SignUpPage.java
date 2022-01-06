package pages;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import io.appium.java_client.MobileElement;

public class SignUpPage extends BasePage {
    public static final By el1=By.id("com.mavi.kartus:id/viewClose");
    public static final By profile= By.xpath("//*[@text=\"Profilim\"]");
    String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Mavi.com'a Giriş Yap\").instance(0))";
    public static final By el_email=By.xpath("(//android.widget.EditText)[1]");
    public static final By el_password1=By.xpath("(//android.widget.EditText)[2]");
    public static final By el_password2=By.xpath("(//android.widget.EditText)[3]");


    public SignUpPage(AndroidDriver driver) {
        super(driver);
    }
    public void signupwithCredentials(String email, String password1,String password2){
        driver.findElement(el1).click();
        driver.findElement(profile).click();
        driver.findElementByAndroidUIAutomator(scrollElement).click();
        driver.findElement(el_email).click();
        driver.findElement(el_password1).click();
        driver.findElement(el_password2).click();

    }
    public void check_signup(){
        MobileElement el_tik = (MobileElement) driver.findElementById("com.mavi.kartus:id/imgCheckBoxEmailPermission");
        el_tik.click();
        MobileElement el_devam_et = (MobileElement) driver.findElementByXPath("(//android.widget.RelativeLayout)[13]");
        el_devam_et.click();
    }
}
