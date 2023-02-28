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
import java.io.ObjectInputFilter;

public class Test04 {
    HomePage homePage;
    Actions actions;
    @Test
    public void Test04() throws IOException {
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
        ReusableMethods.waitFor(1);
        Assert.assertTrue(homePage.kayanResim1.isDisplayed());
        homePage.sagTus.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(homePage.kayanResim2.isDisplayed());
        homePage.sagTus.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(homePage.kayanResim3.isDisplayed());
        //6) Ana sayfa yalnızca üç Varış içermelidir
        Assert.assertEquals(homePage.tumNewArrivals.size(), 3);
        //7) Şimdi Gelenler bölümündeki resme tıklayın
        homePage.gelenUcuncuResim.click();
        ReusableMethods.waitFor(3);
        //8) Kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gidip gitmediğini test edin.
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(homePage.sepeteEkle.isDisplayed());
        ReusableMethods.waitFor(3);
        //9) Resim tıklanabilir olmalı ve kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir.
        Assert.assertTrue(homePage.eklenenSiparis.isEnabled());
        homePage.sepeteEkle.click();
        //10) Tıkladığınız kitap için Açıklama sekmesine tıklayın.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        homePage.reviewsButon.click();
        ReusableMethods.waitFor(3);
        homePage.descrıptıonButon.click();
        ReusableMethods.waitFor(2);
        //11) Kullanıcının tıkladığı kitapla ilgili bir açıklama olmalıdır.
        Assert.assertTrue(homePage.urunDescrıptıon.isDisplayed());
        //11) Kullanıcının tıkladığı kitapla ilgili bir İnceleme olmalı
        ReusableMethods.waitFor(3);
        homePage.reviewsButon.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(homePage.urunİncelemesi.isDisplayed());
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("Yeni sayfa");


    }
}
