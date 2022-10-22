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
        ReusableMethods.prMrktlogIn();
        //ReusableMethods.besUrunEkle();
        Thread.sleep(1000);
        pearlyMarketPage.s8cart.click();
        ReusableMethods.waitFor(2);
        WebElement viewCart = pearlyMarketPage.viewCart;
        ReusableMethods.waitFor(2);
        ReusableMethods.click(viewCart);
        Thread.sleep(3000);
        ReusableMethods.scrollIntoView(pearlyMarketPage.coupon);
        ReusableMethods.waitFor(1);
        ReusableMethods.waitForVisibility(pearlyMarketPage.coupon,5);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(pearlyMarketPage.coupon.isDisplayed());
        Driver.closeDriver();
        ReusableMethods.waitFor(1);

    }
}
