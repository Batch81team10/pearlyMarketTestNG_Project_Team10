package tests.US_003;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.S8PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US003_TC0003 {
    S8PearlyMarketPage pearlyMarketPage = new S8PearlyMarketPage();

    @Test
    public void testCase0003() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        //ReusableMethods.prMrktlogIn();
        //ReusableMethods.besUrunEkle();
        //ReusableMethods.waitForVisibility(pearlyMarketPage.s8signOut, 5);
        pearlyMarketPage.s8cart.click();
        ReusableMethods.waitFor(1);
        pearlyMarketPage.s8checkOut.click();
        Assert.assertTrue(pearlyMarketPage.s8checkOutYazisi.isDisplayed());
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
