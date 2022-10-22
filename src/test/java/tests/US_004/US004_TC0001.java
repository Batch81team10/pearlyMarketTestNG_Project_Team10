package tests.US_004;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.S8PearlyMarketPage;
import tests.US_003.US003_TC0002;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US004_TC0001{
    S8PearlyMarketPage pearlyMarketPage = new S8PearlyMarketPage();

    @Test
    public void TC0001() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        Thread.sleep(1000);
        ReusableMethods.prMrktlogIn();
        ReusableMethods.besUrunEkle();
        Thread.sleep(1000);
        pearlyMarketPage.s8cart.click();
        WebElement viewCart = pearlyMarketPage.viewCart;
        ReusableMethods.click(viewCart);
        Thread.sleep(3000);
        Assert.assertTrue(pearlyMarketPage.sepettekiIlkUrunFiyatYazisi.isDisplayed());
        Thread.sleep(1000);
        Assert.assertTrue(pearlyMarketPage.sepettekiIlkUrunAdetYazisi.isDisplayed());
        Thread.sleep(1000);
        Assert.assertTrue(pearlyMarketPage.sepettekiIlkUrunToplamFiyatYazisi.isDisplayed());
/*
        WebElement clearCart = pearlyMarketPage.clearCart;
        ReusableMethods.scrollIntoView(clearCart);
        Thread.sleep(1000);
        ReusableMethods.waitForClickablility(clearCart, 5);
        ReusableMethods.click(clearCart);

 */
        Driver.closeDriver();
        ReusableMethods.waitFor(1);

    }
}
