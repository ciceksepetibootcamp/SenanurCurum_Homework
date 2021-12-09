import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.Th;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchTest {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("Kullanici idefix anasayfasina girer")
    public void kullaniciIdefixAnasayfasinaGirer() throws InterruptedException {
        driver.get("https://www.idefix.com/");
        driver.manage().window().setSize(new Dimension(1662, 902));
    }
    //Urun araması yapmak için arama kutusunu bulur ve senaryodaki searchkey girilir
    @When("Arama kutusuna {string} girdiginde")
    public void aramaKutusunaGirdiginde(String searchKeyword) throws InterruptedException {
        WebElement searchInput=driver.findElement(By.xpath("//input[@placeholder='Kitap, Müzik, Hobi, Oyuncak, Elektronik ara...']"));
        searchInput.click();
        searchInput.sendKeys(searchKeyword);
        searchInput.sendKeys(Keys.ENTER);
    }

    //searchkey dogru girildiginde (test senaryosunda kalemlik) ilgili urunlerin listesi gelmektedir.
    @Then("Arama sonuclari {string} icin siralanmali")
    public void aramaSonuclariIcinSiralanmali() throws InterruptedException {
        Thread.sleep(2000);

    }
    //searchkey dogru girilmediginde(test senaryosunda kalemlij) "kalemlij" aradığınız kriterlere göre ürün bulunamadı... şeklinde bir mesaj döner.
    @Then("Arama sonucunun bulunmadigi görülmeli")
    public void aramaSonucununBulunmadigiGörülmeli() {
        Assert.assertTrue(driver.getCurrentUrl().contains("kalemlij"));
    }

}