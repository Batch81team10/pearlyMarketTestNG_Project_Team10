package tests.US_004;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.S8PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US004_TC0007 extends TestBaseRapor {

    S8PearlyMarketPage pearlyMarketPage;
    Actions actions;

    @Test
    public void testCase0007() throws InterruptedException {

        pearlyMarketPage= new S8PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("US004 TestCase_0007", "stok fazlası urun ekleyememeli");

        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");

        //2. vendor signin butonuna tıklar
        //3. vendor gecerli bir username girer
        //4. vendor gecerli bir password girer
        //5. vendor sign in butonuna basar
        Thread.sleep(1000);
        ReusableMethods.prMrktlogIn();
        extentTest.info("sayfaya login olundu");

        //6. vendor bir urun aratır
        //7. vendor gelen urune tıklar
        ReusableMethods.waitFor(2);
        pearlyMarketPage.searchBox.sendKeys("legobricks", Keys.ENTER);
        Thread.sleep(1000);
        extentTest.info("bir urun aratıldı");

        //8. vendormiktarını stok fazlası yazar
        WebElement ekle = pearlyMarketPage.legoBricksAddCart;
        WebElement adetKutusu=pearlyMarketPage.legoBricksUrunAdetKutusu;
        ReusableMethods.scrollIntoView(ekle);
        Thread.sleep(1000);
        adetKutusu.clear();
        adetKutusu.sendKeys("5");
        extentTest.info("stok fazlası bir miktar girildi");

        //9. vendor add to cart basar
        Thread.sleep(1000);
        ReusableMethods.click(ekle);
        extentTest.info("sepete ekle bytonuna basıldı");

        //10. vendor urunun eklenemediğini gorur
        Thread.sleep(2000);
        Assert.assertEquals(pearlyMarketPage.s8cartCount.getText(), "0");
        extentTest.pass("Sepete eklenemedigi goruldu");

        //11. vendor Logout yapar
        pearlyMarketPage.legoBricksPageUp.click();
        ReusableMethods.waitFor(1);
        pearlyMarketPage.s8signOut.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.scrollIntoView(pearlyMarketPage.logOut);
        ReusableMethods.waitFor(1);
        pearlyMarketPage.logOut.click();

        Driver.closeDriver();
    }
}
