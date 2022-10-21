package tests.US_012;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Y9PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US012_TC004 {

    Y9PearlyMarketPage pearlyMarketPage=new Y9PearlyMarketPage();
    Actions actions=new Actions(Driver.getDriver());

    @Test
    public void US012_TC004() {

        //  1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));

        //  2. vendor Sign in butonuna tıklar
        //  3. vendor kullanıcı adı ve password girip sign in ile hesabına giriş yapar
        ReusableMethods.prMrktlogIn();
        ReusableMethods.waitFor(3);

        //  4.Ana sayfadaki Profile logosuna (Sign Out) tıklayıp My Acount a ulaşır
        pearlyMarketPage.y9signOut.click();

        //  5. My Account sayfasında "Account Details" sekmesine tıklayabilmeli
        pearlyMarketPage.y9accountDetails.click();

        //  6.Account Details sayfasında hesap bilgileri olduğunu görebilmeli
        Assert.assertTrue(pearlyMarketPage.y9accountBilgileri.isDisplayed());

        //  7.Account Details sayfasında e-posta adresi olduğunu görebilmeli
        Assert.assertTrue(pearlyMarketPage.y9accountEmail.isDisplayed());

        //  8.Account Details sayfasında değişiklik yapıldığında "Save Changes" butonuna tıklayabilmeli
        ReusableMethods.scrollIntoView(pearlyMarketPage.y9accountSaveChanges);
        ReusableMethods.waitFor(1);
        pearlyMarketPage.y9accountSaveChanges.click();

        Driver.closeDriver();

    }
}
