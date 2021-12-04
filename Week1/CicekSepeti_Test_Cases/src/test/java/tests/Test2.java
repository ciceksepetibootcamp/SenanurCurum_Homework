package tests;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class Test2 {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeClass
    public static void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\senan\\Desktop\\chromedriver.exe");
    }
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void sepeteekledekupontanimi() throws InterruptedException {
        // Window acildi
        driver.get("https://www.ciceksepeti.com/");

        // Window boyutu ayarlandi
        driver.manage().window().setSize(new Dimension(1662, 902));
        Thread.sleep(1000);
        driver.findElement(By.className("js-subheader-close")).click();

        // Header a tiklandi
        driver.findElement(By.cssSelector(".header__banner-img")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("js-policy-close")).click();

        // Populer urun secildi
        driver.findElement(By.cssSelector(".o-products__item:nth-child(1) .o-products__item-img")).click();
        Thread.sleep(1000);

        // Sepete ekle butonuna tiklandi
        driver.findElement(By.cssSelector(".btn-xlg")).click();
        Thread.sleep(1000);

        // Kupon kodu kullan label kismina gelindi
        driver.findElement(By.id("discountCouponCode")).click();
        Thread.sleep(1000);

        // Gecersiz bir kod girildi
        driver.findElement(By.id("discountCouponCode")).sendKeys("kod20");
        Thread.sleep(1000);
        // Butona tiklandi
        driver.findElement(By.cssSelector(".btn-orange")).click();
        boolean label=driver.findElement(By.className("js-show-used-coupon-error")).isDisplayed();//kampanyo kodu bulunamadı yazısı gözükmeli
        Assert.assertTrue(String.valueOf(true),label);

    }
    @Test
    public void siparistakibi() throws InterruptedException {
        // Window acildi
        driver.get("https://www.ciceksepeti.com/");
        // Window boyutlari ayarlandi
        driver.manage().window().setSize(new Dimension(1662, 902));
        Thread.sleep(1000);
        driver.findElement(By.className("js-subheader-close")).click();
        // Siparis takibi kismina tiklandi
        driver.findElement(By.cssSelector(".user-menu-container:nth-child(3) .user-menu__link--order > .user-menu__title")).click();
        Thread.sleep(1000);
        // Siparis numarasi alanina gelindi
        driver.findElement(By.name("OrderCode")).click();
        Thread.sleep(1000);
        // Gecersiz bir numara girildi
        driver.findElement(By.name("OrderCode")).sendKeys("123456789");
        Thread.sleep(1000);
        // Kullanici mail adresi alanina gelindi
        driver.findElement(By.name("CustomerEmail")).click();
        Thread.sleep(1000);
        // Gecersiz bir mail adresi girildi
        driver.findElement(By.name("CustomerEmail")).sendKeys("testotomasyon@hotmail.com");
        Thread.sleep(1000);
        // Sorgula butonuna tiklandi
        driver.findElement(By.cssSelector(".order-tracking-form__btn")).click();
        boolean label2=driver.findElement(By.className("js-order-tracking-message")).isEnabled();//Girdiğiniz sipariş numarası veya e-posta hatalıdır. yazisi alindi.
        Thread.sleep(1000);
        Assert.assertTrue(String.valueOf(true),label2);//karsilastirmasi yapildi
    }

}
