package tests.US_001;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Y9PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US001_TC009 {
    Y9PearlyMarketPage pearlyMarketPage=new Y9PearlyMarketPage();
    Actions actions=new Actions(Driver.getDriver());

    @Test
    public void US001_TC009() {

        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));

        //2. vendor register butonuna tıklayabilmeli
        pearlyMarketPage.y9registerGiriş.click();

        //3. vendor açılan ekranda become a vendor'a tıklayabilmeli
        pearlyMarketPage.y9becomeVendor.click();

        //  4. vendor email kutusuna geçerli email girer
        pearlyMarketPage.y9emailBox.sendKeys(ConfigReader.getProperty("username"));

        // 5."RE-SEND CODE" kutucuğuna tıklayabilmeli
        pearlyMarketPage.y9resendCode.click();

        // 6.Kayıt olunan E-maile onay kodu gönderildiğini görebilmeli ve onaylayabilmeli
        Driver.getDriver().get("https://mail.google.com/mail/u/4/#inbox");
        pearlyMarketPage.y9gmailGiris.sendKeys(ConfigReader.getProperty("username"));
        pearlyMarketPage.y9sonrakiButonu.click();
        ReusableMethods.waitFor(3);
        pearlyMarketPage.y9gmailSifre.sendKeys("techpro81");
        ReusableMethods.waitFor(3);
        pearlyMarketPage.y9sifreSonrakiButonu.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(pearlyMarketPage.y9gmailLogo.isDisplayed());

    }
}
