package tests.US_012;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Y9PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US012_TC003 {

    Y9PearlyMarketPage pearlyMarketPage=new Y9PearlyMarketPage();
    Actions actions=new Actions(Driver.getDriver());

    @Test
    public void US012_TC003() {

        //  1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));

        //  2. vendor Sign in butonuna tıklar
        //  3. vendor kullanıcı adı ve password girip sign in ile hesabına giriş yapar
        ReusableMethods.prMrktlogIn();
        ReusableMethods.waitFor(3);

        //  4.Ana sayfadaki Profile logosuna (Sign Out) tıklayıp My Acount a ulaşır
        pearlyMarketPage.y9signOut.click();

        // 5. My Account sayfasında "Adresses" sekmesine tıklayabilmeli
        pearlyMarketPage.y9addresses.click();

        // 6.Açılan sayfada "Billing Adress" olduğunu görebilmeli
        Assert.assertTrue(pearlyMarketPage.y9billingAdres.isDisplayed());

        // 7.Açılan sayfada "Shipping Adress" olduğunu görebilmeli
        Assert.assertTrue(pearlyMarketPage.y9shippingAdres.isDisplayed());

        Driver.closeDriver();

    }
}
