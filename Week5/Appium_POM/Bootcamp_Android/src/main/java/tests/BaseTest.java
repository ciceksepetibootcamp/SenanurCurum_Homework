package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("app","C:\\Users\\senan\\Downloads\\Mavi_v5.1.6_apkpure.com.apk");
        caps.setCapability("devicename","emulator-5554");
        caps.setCapability("fullReset","true");
        caps.setCapability("noReset","false");
        caps.setCapability("autoGrantPermissions","true");
        driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,15);
    }


    @AfterClass
    public void tearDown(){
        driver.quit();

    }
}
