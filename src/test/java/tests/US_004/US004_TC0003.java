package tests.US_004;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.S8PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US004_TC0003 {

    S8PearlyMarketPage pearlyMarketPage = new S8PearlyMarketPage();


    @Test
    public void TC0004() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        Thread.sleep(1000);
        //ReusableMethods.prMrktlogIn();
        //ReusableMethods.besUrunEkle();
        ReusableMethods.waitFor(2);
        ReusableMethods.waitForClickablility(pearlyMarketPage.s8cart, 5);
        ReusableMethods.click(pearlyMarketPage.s8cart);
        ReusableMethods.waitFor(1);
        WebElement viewCart = pearlyMarketPage.viewCart;
        ReusableMethods.waitFor(1);
        ReusableMethods.click(viewCart);
        Thread.sleep(3000);
        ReusableMethods.scrollIntoView(pearlyMarketPage.coupon);
        ReusableMethods.waitFor(1);
        ReusableMethods.waitForVisibility(pearlyMarketPage.coupon,5);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(pearlyMarketPage.coupon.isDisplayed());
        //Driver.closeDriver();

    }
}
