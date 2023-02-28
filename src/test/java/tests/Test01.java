package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Listeners;
import utilities.ReusableMethods;

import java.util.List;

public class Test01 {
    HomePage homePage;


    @Test
    public void Test01(){
        homePage=new HomePage();
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
        ReusableMethods.waitFor(2);
        //5) Ana sayfada yalnızca Üç Kaydırıcı olup olmadığını test edin
        Assert.assertTrue(homePage.kayanResim1.isDisplayed());
        homePage.sagTus.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(homePage.kayanResim2.isDisplayed());
        homePage.sagTus.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(homePage.kayanResim3.isDisplayed());
        ReusableMethods.waitFor(2);
        homePage.sagTus.click();
        //ReusableMethods.waitFor(2);

        //6) Ana sayfa yalnızca üç kaydırıcı içermelidir
        Assert.assertEquals(homePage.tumNewArrivals.size(), 3);


    }

}
