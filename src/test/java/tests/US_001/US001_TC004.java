package tests.US_001;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Y9PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US001_TC004 {

    Y9PearlyMarketPage pearlyMarketPage;
    Actions actions;

    @Test
    public void US001_TC004() {

        pearlyMarketPage=new Y9PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));

        //2. vendor register butonuna tıklayabilmeli
        pearlyMarketPage.y9registerGiriş.click();

        //3. vendor açılan ekranda become a vendor'a tıklayabilmeli
        pearlyMarketPage.y9becomeVendor.click();

        //  4. vendor email kutusuna geçerli email girer
        pearlyMarketPage.y9emailBox.sendKeys(ConfigReader.getProperty("username"));

        //   5. vendor geçerli password girer
        pearlyMarketPage.y9registerPassword.sendKeys(ConfigReader.getProperty("password"));

        //   6. vendor confirm password'e geçerli password girer
        pearlyMarketPage.y9registerConfirmPassword.sendKeys(ConfigReader.getProperty("password"));
        actions.sendKeys(Keys.TAB).perform();
        ReusableMethods.waitFor(1);

        //   7. vendor register butonunu tıklar
        pearlyMarketPage.y9registerOnay.click();
        ReusableMethods.waitFor(5);

        //  8. vendor, register yapılabildiğini görür
        Assert.assertTrue(pearlyMarketPage.y9basariliRegisterMesaji.isDisplayed());

        Driver.closeDriver();




    }
}
