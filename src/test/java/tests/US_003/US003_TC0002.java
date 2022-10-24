package tests.US_003;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.S8PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US003_TC0002 {
    S8PearlyMarketPage pearlyMarketPage = new S8PearlyMarketPage();

    @Test
    public void testCase0002() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        //ReusableMethods.prMrktlogIn();
        Thread.sleep(2000);
        ReusableMethods.besUrunEkle();
        ReusableMethods.waitFor(1);
        Assert.assertEquals(pearlyMarketPage.s8cartCount.getText(), "5");

        /*
        Thread.sleep(1000);
        ReusableMethods.waitForClickablility(pearlyMarketPage.s8cart, 5);
        pearlyMarketPage.s8cart.click();
        pearlyMarketPage.viewCart.click();
        WebElement clearCart = pearlyMarketPage.clearCart;
        ReusableMethods.scrollIntoView(clearCart);
        Thread.sleep(1000);
        ReusableMethods.waitForClickablility(clearCart, 5);
        ReusableMethods.click(clearCart);

        */

        //Driver.closeDriver();
    }
}
