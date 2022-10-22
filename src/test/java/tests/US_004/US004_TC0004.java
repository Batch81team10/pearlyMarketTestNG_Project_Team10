package tests.US_004;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.S8PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US004_TC0004 {
    S8PearlyMarketPage pearlyMarketPage = new S8PearlyMarketPage();


    @Test
    public void TC0006() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        Thread.sleep(1000);
        ReusableMethods.prMrktlogIn();
        //ReusableMethods.besUrunEkle();
        Thread.sleep(1000);
        pearlyMarketPage.s8cart.click();
        ReusableMethods.waitFor(1);
        WebElement viewCart = pearlyMarketPage.viewCart;
        ReusableMethods.click(viewCart);
        Thread.sleep(3000);
        ReusableMethods.scrollIntoView(pearlyMarketPage.shoping);
        ReusableMethods.waitFor(1);
        ReusableMethods.waitForVisibility(pearlyMarketPage.shoping,5);
        Assert.assertTrue(pearlyMarketPage.shoping.isDisplayed());
        Driver.closeDriver();
        ReusableMethods.waitFor(1);

    }
}
