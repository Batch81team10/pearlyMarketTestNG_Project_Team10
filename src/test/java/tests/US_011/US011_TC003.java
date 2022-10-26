package tests.US_011;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Y9PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;




public class US011_TC003 extends TestBaseRapor {

    Y9PearlyMarketPage pearlyMarketPage;
    Actions actions;




    @Test
    public void US011_TC003() throws InterruptedException {
        pearlyMarketPage=new Y9PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        extentTest=extentReports.createTest("Negatif Test","Toptan Urun Gosterme Ayarlarında negatif deger girilmesi");
        //  1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("Pearly sitesine gidildi");
        //  2. vendor Sign in butonuna tıklar
        //  3. vendor kullanıcı adı ve password girip sign in ile hesabına giriş yapar
        ReusableMethods.prMrktlogIn();
        ReusableMethods.waitFor(3);
        extentTest.info("Pearly sitesine giris yapildi");

        //  4.Ana sayfadaki Profile logosuna (Sign Out) tıklayıp My Acount a ulaşır
        //  5. Açılan sayfada Store Manager sekmesine tıklar
        ReusableMethods.prMrktstoreManager();
        extentTest.info("Pearly sitesinde store manager kismina gidildi");

        //  6.My Store altındaki once Products a ve sonra "Hatalı Urun" e tıklar
        pearlyMarketPage.y9productsButton.click();
        ReusableMethods.scrollIntoView(pearlyMarketPage.y9hataliUrunKaydi);
        ReusableMethods.waitFor(1);
        pearlyMarketPage.y9hataliUrunKaydi.click();
        extentTest.info("Products tan Hatali Urune tiklandi");

        //  7.Açılan sayfada Toptan Ürün Gösterme Ayarları na tıklayabilmeli
        ReusableMethods.scrollIntoView(pearlyMarketPage.y9toptanGosterme);
        ReusableMethods.waitFor(1);
        pearlyMarketPage.y9toptanGosterme.click();
        extentTest.info("Toptan Ürün Gösterme Ayarlarına tiklandi");

        //8.Units Per Piece a negatif bir sayı girememeli
        ReusableMethods.scrollIntoView(pearlyMarketPage.y9unitPerpiece);
        ReusableMethods.waitFor(1);
        pearlyMarketPage.y9unitPerpiece.click();
        pearlyMarketPage.y9unitPerpiece.clear();
       pearlyMarketPage.y9unitPerpiece.sendKeys("-23");

        pearlyMarketPage.y9hataliUrunSubmit.click();
        Thread.sleep(1500);
       // ReusableMethods.waitFor(2);

        Assert.assertFalse(Driver.getDriver().getPageSource().contains("-23"),"NEGATİF DEGER GİRİLDİ VE TEST FAIL OLDU");

        extentTest.pass("Negatif deger girilemedigi goruldu");


    }
}
