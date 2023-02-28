package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class Test11 {
    HomePage homePage;
    Actions actions;

    @Test
    public void Test11() throws IOException {
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
        homePage.sepeteEkle.click();
        //11) Kullanıcı o Kitabı Menü öğesinde fiyatla görüntüleyebilir.
        ReusableMethods.waitFor(2);
        Assert.assertTrue(homePage.urunFiyati.isDisplayed());
        ReusableMethods.waitFor(2);
        //12) Şimdi, ödeme sayfasına ilerlemek için gezinen Öğe bağlantısına tıklayın.
        homePage.urunSepeti.click();
        ReusableMethods.waitFor(2);
        //13) Şimdi, bu kitabı ızgaradan kaldıran Çıkış sayfasındaki Bu simgeyi kaldır'a tıklayın.
        homePage.kitabıKaldir.click();
        ReusableMethods.waitFor(2);
        //14) Kullanıcı, check-out sırasında kitabı çıkarma olanağına da sahiptir.
        Assert.assertTrue(homePage.bosSepetMesaji.isDisplayed());

    }
}
