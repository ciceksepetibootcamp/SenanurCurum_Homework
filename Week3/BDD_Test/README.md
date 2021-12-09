###### Bu proje Cucumber BDD Test için hazırlanmıştır.
* Projede [İdefix](https://www.idefix.com/) web sitesi kullanılmıştır.
* İlk olarak Cucumber,Selenium,Bonigarcia için gerekli dependecyler pom.xml dosyasına eklenmiştir.
* Ardından Intellij IDEA için default olarak gelen Gherkin,Cucumber for Java pluginleri kontrol edilir.Bu pluginler yoksa eklenir.
* Ardından resources directory oluşturulur, bu directory altında bir feature dosyası açarız.
* Bu dosyada Feature ile test senaryoları yazılır.

Test Senaryosu 1:
> * İdefix anasayfasına girilir.
> * Arama kutusu bulunur ve searchkeyword girilir.
> * Eşleşen ürünler listelenir.

https://user-images.githubusercontent.com/46262318/145475133-7519242e-22e5-4202-82b8-4636870e751a.mp4

Test Senaryosu 2:
> * İdefix anasayfasına girilir.
> * Arama kutusuna kelime yanlış girilir.
> * Ürün bulunamadı şeklinde mesaj döner.(İdefix'in bu noktada ürünlerin birebir eşleşmediği sürece getirmediğini görüyoruz.)

https://user-images.githubusercontent.com/46262318/145475194-30de1eb6-a858-4cba-a7fb-1bad950500cf.mp4

Test Senaryosu 3:
> * İdefix anasayfasına girilir.
> * Kategori seçilir.
> * Kategori ile eşleşen ürünler listelenir.

https://user-images.githubusercontent.com/46262318/145475235-3744ff6e-2a5d-4035-a352-38a323df7de7.mp4




