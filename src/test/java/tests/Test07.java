package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Test07 {
    HomePage homePage;
    Actions actions;

    @Test
    public void Test07() {
        homePage=new HomePage();
        actions=new Actions(Driver.getDriver());
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
        homePage.sepeteEkle.click();
        //11) Kullanıcı o Kitabı Menü öğesinde fiyatla görüntüleyebilir.
        ReusableMethods.waitFor(2);
        Assert.assertTrue(homePage.urunFiyati.isDisplayed());
        ReusableMethods.waitFor(5);
        //Assert.assertTrue(homePage.eklenmedenOnce.isDisplayed());
        //12) Kullanıcı, o kitabı Sepetine ekleyen Sepete Ekle düğmesine tıklayarak bir kitap ekleyebilir.
        homePage.sepeteEkle.click();
        ReusableMethods.waitFor(2);
        homePage.sepetiGöster.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(5);
        Assert.assertTrue(homePage.urunCıkıs.isDisplayed());
        //13) Stoktaki kitaplardan daha fazla kitap seçin.Örneğin, stokta 20 kitap varsa, eklemeye çalışın
        ReusableMethods.waitFor(2);
        homePage.shopButon.click();
        ReusableMethods.waitFor(2);
        homePage.homeButon.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(8);
        for (int i=1;i<125;i++){
            homePage.kitapEkle.click();
        }
        homePage.gelenUcuncuResim.click();
        //14) Sepete Ekle düğmesine tıklayın
        homePage.sepeteEkle.click();
        //15) Şimdi 1 ile 20 arasında bir değer girmeniz gerekiyormuş gibi bir hata mesajı veriyor.
        homePage.kitapSayisi.sendKeys("5550",Keys.ENTER);
        ReusableMethods.waitFor(2);
        homePage.sepeteEkle.click();
        /*
        String str = masteringPage.textStokFazlasiMesaji.getAttribute("validationMessage");
        Assert.assertTrue(str.contains("Değer 5574 veya daha küçük olmalıdır."));
        System.out.println(str);
        ReusableMethods.waitFor(5);

         */




    }
}
