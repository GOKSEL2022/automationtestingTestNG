package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Test13 {
    HomePage homePage;
    Actions actions;

    @Test
    public void Test13() {
        homePage = new HomePage();
        actions = new Actions(Driver.getDriver());
    }
}
