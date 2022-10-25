package tests.US_013;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.APearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class US_013_TC_001 extends TestBaseRapor {
    APearlyMarketPage pm;
    Actions actions;

    @Test

    public void cuopponPersentage() throws InterruptedException {
        extentTest = extentReports.createTest("couppon testi", "olusturulan couppon'un kaydi");
        pm = new APearlyMarketPage();
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        //1. vendor basarili bir sekilde sign in olur
        Thread.sleep(2000);
        ReusableMethods.prMrktlogIn();
        extentTest.info("log in yapildi");
        // 2.MY ACCOUNT secenegine tiklar
        // 3.store manager bolumune tiklar
        ReusableMethods.prMrktstoreManager();
        extentTest.info("store manager'a tiklandi");
        //4.coupons bolumunden "add new" secenegini secer
        actions = new Actions(Driver.getDriver());
        WebElement couppon = pm.acoupons;
        WebElement addNew = pm.aaddNewLink;
        actions.sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).perform();
        actions.moveToElement(couppon).click(addNew).perform();
        extentTest.info("couppon olusturmak icin add new secenegine tiklandi");
        // 5.code butonuna  sayisal deger ve harf yazar
        pm.acode.sendKeys(ConfigReader.getProperty("coupponName1"));
        extentTest.info("couppon code'u girildi");
        // 6.kuponu turune gore aciklar
        pm.adescription.sendKeys(ConfigReader.getProperty("description1"));
        extentTest.info("couppon icin aciklama yapildi");
        // 7.Discount Type menusundeki seceneklerden "percentage discount'u" secer
        WebElement discountType = pm.adiscountType;
        Select options = new Select(discountType);
        options.selectByIndex(0);
        extentTest.info("indirim turu secildi");
        //8.Coupon Amount butonuna 1-100 arasinda bir rakam girer
        pm.aamount.clear();
        pm.aamount.sendKeys(ConfigReader.getProperty("amount1"));
        extentTest.info("indirimin degeri girildi");
        // 9.Coupon expiry date bolumune guncel tarih veya sonrasi bir deger  girer
        ReusableMethods.click(pm.adate);
        pm.adate.sendKeys("2022-10-30");
        extentTest.info("son gecerlilij tarihi belirlendi");
        //10.Kupon ücretsiz gönderim sağlıyorsa Free shipping kutucugunu isaretller
        WebElement free =pm.afreeShipping;
        ReusableMethods.click(free);
        extentTest.info("free shippin kutucugu isaretlendi");
        // 11.Kuponu mağaza sayfasında göstermek istiyorsa "Show on store" kutucugunu secebilmeli
        WebElement show=pm.ashow;
        ReusableMethods.click(show);
        extentTest.info("anasayfada gosterme kutucugu isaretlendi");
        // 12.submit'e basar
        WebElement submit=pm.asubmit;
        ReusableMethods.click(submit);
        extentTest.info("couppon kaydedildi");


        //13.kazan25 isimli kuponun kaydedildigini dogrular
        ReusableMethods.click(pm.acoupons);
        List<WebElement> codeCells=Driver.getDriver().findElements(By.xpath("//tbody//td[1]"));
        String actualAmount=codeCells.get(0).getText();
        String expectedAmount="kazan25";
        Assert.assertEquals(actualAmount,expectedAmount);
        extentTest.pass("kaydedilen couppon listede gorundu");
    }
}
