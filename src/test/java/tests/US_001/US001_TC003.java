package tests.US_001;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Y9PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US001_TC003 {

    Y9PearlyMarketPage pearlyMarketPage;
    Actions actions;

    @Test
    public void US001_TC003() {
        pearlyMarketPage=new Y9PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));

        //2. vendor register butonuna tıklayabilmeli
        pearlyMarketPage.y9registerGiriş.click();

        //3. vendor açılan ekranda become a vendor'a tıklayabilmeli
        pearlyMarketPage.y9becomeVendor.click();

        //   4. vendor email kutusu boş bırakır
        pearlyMarketPage.y9emailBox.click();

        //   5. vendor geçerli password girer
        pearlyMarketPage.y9registerPassword.sendKeys("testng1081");

        //   6. vendor confirm password'e geçerli password girer
        pearlyMarketPage.y9registerConfirmPassword.sendKeys("testng1081");
        actions.sendKeys(Keys.TAB).perform();
        ReusableMethods.waitFor(1);
        //   7. vendor register butonunu tıklar
        pearlyMarketPage.y9registerOnay.click();

        //   8. vendor register yapılamadığını görebilmeli
        Assert.assertTrue(pearlyMarketPage.y9emailZorunluMesaji.isDisplayed());

        Driver.closeDriver();


    }
}
