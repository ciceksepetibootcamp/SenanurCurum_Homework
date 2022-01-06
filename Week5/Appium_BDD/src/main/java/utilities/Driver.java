package utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class Driver {
    private static AndroidDriver driver;
    public WebDriverWait wait;

    public static AndroidDriver Driver_Execute() throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities caps=new DesiredCapabilities();
            caps.setCapability("platformName","Android");
            caps.setCapability("app","C:\\Users\\senan\\Downloads\\Mavi_v5.1.6_apkpure.com.apk");
            caps.setCapability("devicename","emulator-5554");
            caps.setCapability("fullReset","true");
            caps.setCapability("noReset","false");
            caps.setCapability("autoGrantPermissions","true");

            driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            //wait=new WebDriverWait(driver,15);
        }
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
        driver = null;
    }

}