from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
class CategoryPage():
    def __init__(self,driver):
        self.driver=driver
        self.categoryname="Sipariş Takibi"
        self.alerttext=".alert-orange > .content"


    def get_orderid(self):
        WebDriverWait(self.driver, 8).until(
            expected_conditions.visibility_of_element_located((By.LINK_TEXT, self.categoryname)))
        self.driver.find_element(By.LINK_TEXT, self.categoryname).click()
        self.driver.find_element(By.ID, "orderId").send_keys("123456789")
    def get_customer_email(self):
        self.driver.find_element(By.ID, "customerEmailAddress").click()
        self.driver.find_element(By.ID, "customerEmailAddress").send_keys("test@gmail.com")
        self.driver.find_element(By.ID, "submit-order-find").click()

    def get_alert(self):
        self.driver.find_element(By.CSS_SELECTOR,self.alerttext ).click()
        WebDriverWait(self.driver, 8).until(
            expected_conditions.visibility_of_element_located((By.CSS_SELECTOR, self.alerttext)))