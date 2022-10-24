package tests.US_004;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.S8PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US004_TC0005 {
    S8PearlyMarketPage pearlyMarketPage = new S8PearlyMarketPage();


    @Test
    public void TC0005() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        Thread.sleep(1000);
        //ReusableMethods.prMrktlogIn();
        //ReusableMethods.besUrunEkle();
        ReusableMethods.waitFor(2);
        pearlyMarketPage.s8cart.click();
        ReusableMethods.waitFor(1);
        WebElement viewCart = pearlyMarketPage.viewCart;
        ReusableMethods.click(viewCart);
        Thread.sleep(3000);
        ReusableMethods.scrollIntoView(pearlyMarketPage.shippingBilgisi1);
        //ReusableMethods.waitForVisibility(pearlyMarketPage.shoping,5);
        Assert.assertTrue(pearlyMarketPage.shippingBilgisi1.isDisplayed());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(pearlyMarketPage.shippingBilgisi2.isDisplayed());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(pearlyMarketPage.shippingTotalBilgisi.isDisplayed());
        ReusableMethods.waitFor(1);
        //Driver.quitDriver();

    }
}
