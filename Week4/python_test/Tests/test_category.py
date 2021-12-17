
from selenium import webdriver
from selenium.webdriver.common.by import By


from Pages.categoryPage import CategoryPage


class Test_Category():
    def setup_method(self, method):
        self.driver = webdriver.Chrome("C:/Users/senan/Desktop/chromedriver.exe")
        self.vars = {}

    def teardown_method(self, method):
        self.driver.quit()

    def test_category(self):
        self.driver.get("https://www.kaft.com/")
        self.driver.set_window_size(1662, 902)
        category=CategoryPage(self.driver)
        category.get_orderid()
        category.get_customer_email()
        category.get_alert()
        assert self.driver.find_element(By.CSS_SELECTOR,category.alerttext).text == "Sipariş bulunamadı.Lütfen girdiğin değerleri kontrol edip tekrar dene."

