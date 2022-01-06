package tests;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.SignUpPage;
import utilities.Driver;

import java.net.MalformedURLException;

public class SignUpTest {
    AndroidDriver driver;
    @Given("Kullanici mavi anasayfasina girer")
    public void enter_homepage() throws MalformedURLException {
        driver= Driver.Driver_Execute();
        PageFactory.initElements(driver,this);
    }
    @When("Profilime tiklayip gecersiz mail adresi ile kaydolmak istediginde")
    public void check_invalid_mail(){
        SignUpPage signUpPage= new SignUpPage(driver);
        signUpPage.signupwithCredentials("test","P@ssw0rd.","P@ssw0rd.");
    }
    @When("Profilime tiklayip zaten var olan bir mail adresi ile kaydolmak istediginde")
    public void check_already_exist_mail(){
        SignUpPage signUpPage= new SignUpPage(driver);
        signUpPage.signupwithCredentials("senanurcurum@gmail.com","P@ssw0rd.","P@ssw0rd.");
    }
    @Then("Hata mesaji gormeli")
    public void check_error_message(){
        SignUpPage signUpPage= new SignUpPage(driver);
        signUpPage.check_signup();
    }
    @After
    public void quitDriver(){
        Driver.quitDriver();
    }
}
