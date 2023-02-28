package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class Test09 {
    HomePage homePage;
    Actions actions;

    @Test
    public void Test09() throws IOException {
        homePage = new HomePage();
        actions = new Actions(Driver.getDriver());

        //1) Tarayıcıyı açın
        //2) "http://practice.automationtesting.in/" URL'sini girin
        Driver.getDriver().get(ConfigReader.getProperty("automationtesting_url"));
        //3) Mağaza Menüsüne tıklayın
        homePage.shopButon.click();
        ReusableMethods.waitFor(2);
        Driver.getDriver().navigate().refresh();
        homePage.shopButon.click();
        ReusableMethods.waitFor(2);
        //4) Şimdi Ana menü düğmesine tıklayın
        homePage.homeButon.click();
        //5) Ana sayfada yalnızca Üç Varış olup olmadığını test edin
        ReusableMethods.waitFor(2);
        Assert.assertTrue(homePage.kayanResim1.isDisplayed());
        ReusableMethods.waitFor(2);
        homePage.sagTus.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(homePage.kayanResim2.isDisplayed());
        ReusableMethods.waitFor(2);
        homePage.sagTus.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(homePage.kayanResim3.isDisplayed());
        //6) Ana sayfa yalnızca üç Varış içermelidir
        Assert.assertEquals(homePage.tumNewArrivals.size(), 3);
        //7) Şimdi Gelenler bölümündeki resme tıklayın
        homePage.gelenUcuncuResim.click();
        //8) Kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gidip gitmediğini test edin.
        Assert.assertTrue(homePage.sepeteEkle.isDisplayed());
        //9) Resim tıklanabilir olmalı ve kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir.
        Assert.assertTrue(homePage.eklenenSiparis.isEnabled());
        //10) O kitabı sepetinize ekleyen Sepete Ekle düğmesine tıklayın
        ReusableMethods.waitFor(2);
        for (int i=1;i<5;i++){
            homePage.sepeteEkle.click();
        }
        //11) Kullanıcı o Kitabı Menü öğesinde fiyatla görüntüleyebilir.
        ReusableMethods.waitFor(2);
        Assert.assertTrue(homePage.urunFiyati.isDisplayed());
        ReusableMethods.waitFor(3);
        //12) Şimdi, ödeme sayfasına ilerlemek için gezinen Öğe bağlantısına tıklayın.
        homePage.urunSepeti.click();
        //homePage.sepetiGöster.click();
        //13) Kullanıcı, kitabı sepete ekledikten sonra, ödeme sayfasına yönlendiren
        // menü öğesindeki Öğe bağlantısına tıklayabilir.
        ReusableMethods.waitFor(2);
        Assert.assertTrue(homePage.urunSepeti.isEnabled());
        //14) Toplamda 50rps indirim kazanmak için Kupon kodunu 'krishnasakinala' olarak girin.
        homePage.kuponKodu.sendKeys("krishnasakinala", Keys.ENTER);
        Assert.assertTrue(homePage.kuponBasarıMesajı.isDisplayed());
        //15) Kullanıcı, toplam fiyat üzerinden 50rps indirim sağlayan kupon metin kutusuna
        // "krishnasakinala" yazarak kupon için başvurabilir
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(homePage.kuponİndirimi.isDisplayed());
        ReusableMethods.getScreenshot("kuponİndirimi");

    }
}
