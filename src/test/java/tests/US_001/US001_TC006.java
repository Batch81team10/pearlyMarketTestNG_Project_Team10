package tests.US_001;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Y9PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US001_TC006 {
    Y9PearlyMarketPage pearlyMarketPage=new Y9PearlyMarketPage();
    Actions actions=new Actions(Driver.getDriver());


    @Test
    public void US001_TC006() {

        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));

        //2. vendor register butonuna tıklayabilmeli
        pearlyMarketPage.y9registerGiriş.click();

        //3. vendor açılan ekranda become a vendor'a tıklayabilmeli
        pearlyMarketPage.y9becomeVendor.click();

        //  4. vendor email kutusuna kayıtlı email girer
        pearlyMarketPage.y9emailBox.sendKeys(ConfigReader.getProperty("username"));

        //   5. vendor geçerli password girer
        pearlyMarketPage.y9registerPassword.sendKeys(ConfigReader.getProperty("password"));

        //   6. vendor confirm password'e geçerli password girer
        pearlyMarketPage.y9registerConfirmPassword.sendKeys(ConfigReader.getProperty("password"));
        actions.sendKeys(Keys.TAB).perform();
        ReusableMethods.waitFor(1);

        // 7.Dogrulama kodunu girer
        pearlyMarketPage.y9dogrulamaKodu.sendKeys("123456");

        //   8. vendor register butonunu tıklar
        pearlyMarketPage.y9registerOnay.click();
        ReusableMethods.waitFor(5);

        //9. vendor aynı mail ile register yapılamadığını görebilmeli
        Assert.assertTrue(pearlyMarketPage.y9kayitliMailVar.isDisplayed());

        Driver.closeDriver();




    }
}
