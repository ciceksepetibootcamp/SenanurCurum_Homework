##### Bu proje C# dili ile Test Otomasyon için hazırlanmıştır.
Projede tasarım ürün sitesi olan [KAFT](https://www.kaft.com/) kullanılmıştır.
###### Proje Adımları:
* İlk olarak Visual Studio Code kurulu değilse kurulmalıdır, geliştirme bu platform içerisinde gerçekleştirilecektir.
* Ardından gerekli olan paketler View->Command Palent menüsünden Nuget Package Manager yardımı ile indirilmelir.Bunlar Selenium.WebDriver,Microsoft.TestPlatform gibi paketlerdir.
* Chromeda eklenti olarak bulunan Selenium Ide kullanılarak Kaft sitesinin urlsi girilir.Record işlemine başlanır.İlk olarak Anasayfadaki 'Menü' textine tıklanır.
> ![Screenshot_8](https://user-images.githubusercontent.com/46262318/146386568-b1c4399f-01c0-48a9-8843-d105054efc41.jpg)
> ![Screenshot_9](https://user-images.githubusercontent.com/46262318/146386597-5e3aab50-63ea-48ec-ba95-677152172d86.jpg)
> ![Screenshot_10](https://user-images.githubusercontent.com/46262318/146386705-fc792fab-1080-42ff-ae92-4b2bb51e8526.jpg)

* Açılan kategorilerden Pantolon seçilir.
> ![Screenshot_11](https://user-images.githubusercontent.com/46262318/146386746-03a23934-4b79-45c0-8703-f2e458cc6209.jpg)
* Ürün listesi görüntülenir.
![Screenshot_12](https://user-images.githubusercontent.com/46262318/146386794-d236cdec-3437-4d60-86f2-cad8fdb09a79.jpg)
* İlk ürün seçilir.
* Ürünün detayları görünmüş ve kontrol edilmiş olur.
> ![Screenshot_13](https://user-images.githubusercontent.com/46262318/146386885-839800b8-0c9f-49a2-b578-a81ac7cbb0d3.jpg)
* Selenium ile record işlemi yapıldıktan sonra dosya CSharp ile export edilir.
* Vscode yardımı ile bir boş klasör açılır.Bu klasöre .cs uzantılı selenium yardımıyla oluşturulan code scripti eklenir.
* pom klasörü içinde test dosyasının ve driver için gerekli dosyanın içine yazılmasının ardından proje tamamlanmış olur.

