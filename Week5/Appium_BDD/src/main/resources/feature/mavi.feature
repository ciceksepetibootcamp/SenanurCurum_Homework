Feature: Mavi Appium Android Tests
@Positive
Scenario: Login Testi
  Given Kullanici mavi anasayfasina girer
  When Profilim'e tiklayip mail adresi "senanurcurum@gmail.com" ve sifresini "P@ssw0rd." girdiginde
  Then Hesabina giris yapmali

  @Negative
  Scenario: Hatali Login Testi
    Given Kullanici mavi anasayfasina girer
    When Profilim'e tiklayip mail adresi "senanurcurum@gmail.com" ve sifresini hatali "password" girdiginde
    Then Hesabina giris yapamamali

  @Negative
    Scenario:Basarisiz Uye Olma Testi
      Given Kullanici mavi anasayfasina girer
      When Profilime tiklayip gecersiz mail adresi ile kaydolmak istediginde
      Then Hata mesaji görmeli

    @Negative
    Scenario:Basarisiz Uye Olma
      Given Kullanici mavi anasayfasina girer
      When Profilime tiklayip zaten var olan bir mail adresi ile kaydolmak istediginde
      Then Hata mesaji gormeli





