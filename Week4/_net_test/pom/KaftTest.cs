using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Threading;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Remote;
using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium.Interactions;
using NUnit.Framework;
using SeleniumExtras.PageObjects;
namespace _net_test{
    //driver.cs dosyasındaki Driver classı burada çağrılır.
    public class KaftTest  : Driver{
        public KaftTest(IWebDriver driver){
            KaftTest.driver=driver;
            PageFactory.InitElements(driver,this);
            //driver tanımlanır.
        }
        //kullanılacak web elementler bulunur.
        [FindsBy(How=How.TagName,Using ="b")]
        private IWebElement menu;
        [FindsBy(How=How.ClassName,Using ="icon-menu icon-woman-pant")]
        private IWebElement womanPantCategory;
        
        [FindsBy(How=How.XPath,Using ="//div[@class='product'][1]/a")]
        private IWebElement product;
        //siteye gidilir.
        public String getSite(){
            return driver.Url;
        }   
        //anasayfadaki menü yazısına tıklanır
        public void menuClick(){
            menu.Click();
        }
        //kategori seçilir
        public void getCategory(){
            womanPantCategory.Click();
        }
        //kadın pantolonları kategorisinde ilk ürün seçilir.
        public void productSelect(){
            product.Click();
            Assert.True(driver.Url.Contains("panoes_storm-pantolon/1524"));
        }
        
    }


}