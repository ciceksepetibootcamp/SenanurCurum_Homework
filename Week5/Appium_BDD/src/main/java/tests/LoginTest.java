package tests;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import utilities.Driver;

import java.net.MalformedURLException;

public class LoginTest {
    AndroidDriver driver;
    @Given("Kullanici mavi anasayfasina girer")
    public void enter_homepage() throws MalformedURLException {
        driver= Driver.Driver_Execute();
        PageFactory.initElements(driver,this);
    }
    @When(" Profilim'e tiklayip mail adresi \"senanurcurum@gmail.com\" ve sifresini \"P@ssw0rd.\" girdiginde")
    public void successfull_login(String email,String password){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.loginwithCredentials(email,password);
    }
    @Then("Hesabina giris yapmali")
    public void check_successfull_login(){
        LoginPage loginPage= new LoginPage(driver);
        loginPage.checkLoginMessage("Merhaba");
    }
     @When( "Profilim'e tiklayip mail adresi \"senanurcurum@gmail.com\" ve sifresini hatali "password" girdiginde")
    public void successfull_login(String email,String password){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.loginwithCredentials(email,password);
    }
    @Then("Hesabina giris yapamamali")
    public void check_error_login(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.checkErrorMessage("Girilen email adresi veya parola hatalıdır");
    }
    @After
    public void quitDriver(){
        Driver.quitDriver();
    }
}
