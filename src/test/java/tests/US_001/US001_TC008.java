package tests.US_001;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Y9PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US001_TC008 {

    Y9PearlyMarketPage pearlyMarketPage=new Y9PearlyMarketPage();
    Actions actions=new Actions(Driver.getDriver());

    @Test
    public void US001_TC008() {
        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));

        //2. vendor register butonuna tıklayabilmeli
        pearlyMarketPage.y9registerGiriş.click();

        //3. vendor açılan ekranda become a vendor'a tıklayabilmeli
        pearlyMarketPage.y9becomeVendor.click();

        //  4. vendor email kutusuna geçerli email girer
        pearlyMarketPage.y9emailBox.sendKeys(ConfigReader.getProperty("username"));

        //5. vendor password kutusuna 8 haneli kucuk harf, büyük harf, rakam ve special karakter girer
        pearlyMarketPage.y9registerPassword.sendKeys("Team10./");

        //6.Password kutusu altında "Strong" yazısını görebilmeli
        Assert.assertTrue(pearlyMarketPage.y9strongPassword.isDisplayed());
        actions.sendKeys(Keys.ARROW_DOWN).perform();


        //7.Confirm Password kutusuna oluşturulan password  girilebilmeli
        pearlyMarketPage.y9registerConfirmPassword.sendKeys("Team10./");
        ReusableMethods.waitFor(3);

        Driver.closeDriver();



    }
}
