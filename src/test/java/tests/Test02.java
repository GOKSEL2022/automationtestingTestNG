package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class Test02 {
    HomePage homePage;

    @Test
    public void Test02() {
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
        //5) Ana sayfada yalnızca Üç Varış olup olmadığını test edin
        ReusableMethods.waitFor(1);
        Assert.assertTrue(homePage.kayanResim1.isDisplayed());
        ReusableMethods.waitFor(1);
        homePage.sagTus.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(homePage.kayanResim2.isDisplayed());
        ReusableMethods.waitFor(1);
        homePage.sagTus.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(homePage.kayanResim3.isDisplayed());
        //6) Ana sayfa yalnızca üç Varış içermelidir
        Assert.assertEquals(homePage.tumNewArrivals.size(), 3);

    }
}
