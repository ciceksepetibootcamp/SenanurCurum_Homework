Feature: İdefix test senaryoları
  @Positive
  Scenario Outline: Arama Testi
    Given Kullanici idefix anasayfasina girer
    When Arama kutusuna "<searchkey>" girdiginde
    Then Arama sonuclari "<searchkey>" icin siralanmali
    Examples:
    |searchkey|
    |kalemlik|
  @Negative
  Scenario Outline:Aranılan kelimeyi yanlis girme testi
    Given Kullanici idefix anasayfasina girer
    When Arama kutusuna "<searchkey>" girdiginde
    Then Arama sonucunun bulunmadigi görülmeli
    Examples:
    |searchkey|
    |kalemlij|


  Scenario:Kategori secme ve kategoriye ait urun listelenmesi
    Given Kullanici anasayfadadir
    When Kategori secer
    Then Kategori urunlerini gormelidir




