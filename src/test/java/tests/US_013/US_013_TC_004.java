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

public class US_013_TC_004 extends TestBaseRapor {
    APearlyMarketPage pm;
    Actions actions;

    @Test
    public void dCuopponInvalidDate() throws InterruptedException {
        extentTest = extentReports.createTest("couppon testi", "invalid  expiry date kaydi");
        pm = new APearlyMarketPage();
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("log in yapildi");
        //  1. vendor basarili bir sekilde sign in olur
        ReusableMethods.waitFor(3);
        ReusableMethods.prMrktlogIn();
        //  3.My acount secenegine tiklar
        //  2.store manager bolumune tiklar
        ReusableMethods.waitFor(2);
        ReusableMethods.prMrktstoreManager();
        extentTest.info("store manager'a tiklandi");
        //  4.coupons bolumunden "add new" secenegini secer
        actions = new Actions(Driver.getDriver());
        WebElement couppon = pm.acoupons;
        WebElement addNew = pm.aaddNewLink;
        actions.sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).perform();
        actions.moveToElement(couppon).perform();
        ReusableMethods.waitFor(2);
        actions.click(addNew).perform();
        extentTest.info("couppon olusturmak icin add new secenegine tiklandi");
        //5.code butonuna  sayisal deger ve harf yazar
        pm.acode.sendKeys(ConfigReader.getProperty("coupponName4"));
        extentTest.info("couppon code'u girildi");
        //6.kuponu turune gore aciklar
        pm.adescription.sendKeys(ConfigReader.getProperty("description4"));
        extentTest.info("couppon icin aciklama yapildi");
        //7.Discount Type menusundeki seceneklerden birini secer
        WebElement discountType = pm.adiscountType;
        Select options = new Select(discountType);
        ReusableMethods.waitFor(2);
        options.selectByIndex(0);
        extentTest.info("indirim turu secildi");
        //8.secilen discount type'a uygun amount degeri girilir
        pm.aamount.clear();
        pm.aamount.sendKeys(ConfigReader.getProperty("amount4"));
        extentTest.info("indirimin degeri girildi");
        //9.Coupon expiry date bolumune guncel tarih oncesi  bir deger  girer
        ReusableMethods.click(pm.adate);
        pm.adate.sendKeys(ConfigReader.getProperty("invalidDate"));
        extentTest.info("son gecerlilik tarihi belirlendi");
        //10.Kupon ücretsiz gönderim sağlıyorsa Free shipping kutucugunu isaretller
        WebElement free = pm.afreeShipping;
        ReusableMethods.click(free);
        extentTest.info("free shippin kutucugu isaretlendi");
        //11.Kuponu mağaza sayfasında göstermek istiyorsa "Show on store" kutucugunu secebilmeli
        WebElement show = pm.ashow;
        ReusableMethods.click(show);
        extentTest.info("anasayfada gosterme kutucugu isaretlendi");
        //12.submit'e basar
        ReusableMethods.waitFor(2);
        WebElement submit = pm.asubmit;
        ReusableMethods.click(submit);
        extentTest.info("couppon kaydedildi");

        //13.girilen expiry date degerinin kaydedilmedigini dogrular
        ReusableMethods.click(pm.acoupons);
        ReusableMethods.waitFor(2);
        List<WebElement> dateCells = Driver.getDriver().findElements(By.xpath("//tbody//td[5]"));
        ReusableMethods.waitFor(3);
        String actualDate = dateCells.get(0).getText();
        String expectedDate = "–";
        Assert.assertEquals(actualDate, expectedDate);

        extentTest.pass("invalid expiry date kaydedilmedi ");
    }
}
