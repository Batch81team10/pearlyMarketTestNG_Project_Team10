package tests.US_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Y9PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US001_TC002 {

    Y9PearlyMarketPage pearlyMarketPage=new Y9PearlyMarketPage();

    @Test
    public void US001_TC002() {

        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));

        //2. vendor register butonuna tıklayabilmeli
        pearlyMarketPage.y9registerGiriş.click();

        //3. vendor açılan ekranda become a vendor'a tıklayabilmeli
        pearlyMarketPage.y9becomeVendor.click();

        //  4. vendor registration sayfasında email kutusunun kullanılabildiğini görebilmeli
        pearlyMarketPage.y9emailBox.click();
        Assert.assertTrue(pearlyMarketPage.y9emailBox.isDisplayed());
        ReusableMethods.waitFor(1);

        //  5. vendor registration sayfasında password kutusunun  kullanılabildiğini görebilmeli
        pearlyMarketPage.y9registerPassword.click();
        Assert.assertTrue(pearlyMarketPage.y9registerPassword.isDisplayed());
        ReusableMethods.waitFor(1);

        //  6. vendor registration sayfasında confirm password kutusunun   kullanılabildiğini görebilmeli
        pearlyMarketPage.y9registerConfirmPassword.click();
        Assert.assertTrue(pearlyMarketPage.y9registerConfirmPassword.isDisplayed());
        ReusableMethods.waitFor(1);

        Driver.closeDriver();

    }
}
