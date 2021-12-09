import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CategoryTest {
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
    @Given("Kullanici anasayfadadir")
    public void kullaniciAnasayfadadir(){
        driver.get("https://www.idefix.com/");
        driver.manage().window().setSize(new Dimension(1662, 902));

    }
    //kategorinin bulunduğu xpath girildi
    @When("Kategori secer")
    public void kategoriSecer(){

        WebElement category=driver.findElement(By.xpath("//a[text()=\"KIRTASİYE\"]"));
        category.click();

    }
    //kategorinin bulunduğu url içinde seçilen kategori ismi bulunmalıdır
    @Then("Kategori urunlerini gormelidir")
    public void kategoriUrunleriniGormelidir(){
        Assert.assertTrue(driver.getCurrentUrl().contains("Kirtasiye"));

    }
}
