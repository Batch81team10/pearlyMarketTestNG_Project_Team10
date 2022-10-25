package tests.US_004;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.S8PearlyMarketPage;
import tests.US_003.US003_TC0002;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US004_TC0001 extends TestBaseRapor {

    S8PearlyMarketPage pearlyMarketPage;
    Actions actions;

    @Test
    public void testCase0001() throws InterruptedException {

        pearlyMarketPage= new S8PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("US004 TestCase_0001", "urun rakam, miktar ve fiyat bilgilerinin gorulmeli");

        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");

        //2. vendor signin butonuna tıklar
        //3. vendor gecerli bir username girer
        //4. vendor gecerli bir password girer
        //5. vendor sign in butonuna basar
        ReusableMethods.waitFor(1);
        ReusableMethods.prMrktlogIn();
        extentTest.info("sayfaya login olundu");

        //6. vendor my account butonuna basar
        //7. vendor Orders butonuna basar
        //8. vendor go to shop'a tıklar
        //9. vendor 5 adet ürün secip tek tek sepete ekler
        ReusableMethods.besUrunEkle();
        Thread.sleep(1000);
        extentTest.info("sepete 5 urun eklendi");

        //10. vendor cart'a tıklar
        pearlyMarketPage.s8cart.click();
        extentTest.info("sepete tıklandı");

        //11. vendor wiew Cart'a tıklar
        WebElement viewCart = pearlyMarketPage.viewCart;
        ReusableMethods.click(viewCart);
        extentTest.info("wiew karta tıklandı");

        //12. vendor seçilen urunlerin rakam miktar ve toplam olarak gorunmeli
        Thread.sleep(3000);
        Assert.assertTrue(pearlyMarketPage.sepettekiIlkUrunFiyatYazisi.isDisplayed());
        Thread.sleep(1000);
        Assert.assertTrue(pearlyMarketPage.sepettekiIlkUrunAdetYazisi.isDisplayed());
        Thread.sleep(1000);
        Assert.assertTrue(pearlyMarketPage.sepettekiIlkUrunToplamFiyatYazisi.isDisplayed());
        extentTest.pass("urun rakam, miktar ve fiyat bilgilerinin gorunurlugu dogrulandı");


        //13. vendor Logout yapar
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.HOME).perform();
        ReusableMethods.waitFor(2);
        pearlyMarketPage.s8signOut.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.scrollIntoView(pearlyMarketPage.logOut);
        ReusableMethods.waitFor(1);
        pearlyMarketPage.logOut.click();

        Driver.closeDriver();
    }
}
