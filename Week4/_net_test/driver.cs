// Generated by Selenium IDE
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


namespace _net_test
{

public class Driver {
  public static IWebDriver driver;

  public void Initialize() {

    //driver set edilir,pencere boyutu ayarlanır ve kullanılacak url drivera tanıtılır.
    driver = new ChromeDriver();
    driver.Manage().Window.Maximize();
    driver.Url = "https://www.kaft.com/";
  }

  public void TearDown() {
    driver.Quit();
  }

}

}