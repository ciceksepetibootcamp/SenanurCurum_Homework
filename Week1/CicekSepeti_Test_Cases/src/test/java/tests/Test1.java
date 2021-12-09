package tests;

// Generated by Selenium IDE
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
public class Test1 {
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
    public void headerpopulerurunsepeteekle() throws InterruptedException {

        // Windows acildi
        driver.get("https://www.ciceksepeti.com/");

        // Window boyutlari ayarlandi
        driver.manage().window().setSize(new Dimension(1662, 902));
        Thread.sleep(3000);
        driver.findElement(By.className("js-subheader-close")).click();

        // Header a tiklandi
        driver.findElement(By.cssSelector(".header__banner-img")).click();
        driver.findElement(By.className("js-policy-close")).click();

        // Populer urun secildi
        driver.findElement(By.cssSelector(".o-products__item:nth-child(1) .o-products__item-img")).click();
        String productname=driver.findElement(By.className("js-product-title")).getText();
        System.out.println(productname);
        Thread.sleep(1000);

        // Sepete eklendi
        driver.findElement(By.cssSelector(".btn-xlg")).click();

        String basket_product_name = driver.findElement(By.className("cart__item-col-link")).getText(); // Sepetteki ürün ismi alindi
        Assert.assertEquals(productname,basket_product_name);

    }

    @Test
    public void sepettencikar() throws InterruptedException {

        driver.get("https://www.ciceksepeti.com/");

        driver.manage().window().setSize(new Dimension(1662, 902));
        driver.findElement(By.className("js-subheader-close")).click();
        // Header a tiklandi
        driver.findElement(By.cssSelector(".header__banner-img")).click();
        driver.findElement(By.className("js-policy-close")).click();
        // Populer urun secildi
        driver.findElement(By.cssSelector(".o-products__item:nth-child(1) .o-products__item-img")).click();
        // Sepete ekle butonuna tiklandi
        driver.findElement(By.cssSelector(".btn-xlg")).click();
        // Kupon kodu kullan label a gelindi

        driver.findElement(By.id("discountCouponCode")).click();
        // Gecersiz kod tanimlandi
        driver.findElement(By.id("discountCouponCode")).sendKeys("kod20");
        // Butona tiklandi
        driver.findElement(By.cssSelector(".btn-orange")).click();
        // Sepetten cikartmak için 'x' isaretine tiklandi
        driver.findElement(By.cssSelector(".cart__item-delete")).click();
        // Sepetten cikar butonuna tiklandi
        driver.findElement(By.cssSelector(".agree-button")).click();
    }
}


