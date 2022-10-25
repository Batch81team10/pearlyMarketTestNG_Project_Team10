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

import java.util.List;

public class US_013_TC_004 {
    APearlyMarketPage pm;
    Actions actions;

    @Test
    public void cuopponInvalidDate() throws InterruptedException {
        pm = new APearlyMarketPage();
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        //  1. vendor basarili bir sekilde sign in olur
        ReusableMethods.prMrktlogIn();
        //  3.My acount secenegine tiklar
        //  2.store manager bolumune tiklar
        ReusableMethods.prMrktstoreManager();
        //  4.coupons bolumunden "add new" secenegini secer
        actions = new Actions(Driver.getDriver());
        WebElement couppon = pm.acoupons;
        WebElement addNew = pm.aaddNewLink;
        actions.sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).perform();
        actions.moveToElement(couppon).click(addNew).perform();
        //5.code butonuna  sayisal deger ve harf yazar
        pm.acode.sendKeys(ConfigReader.getProperty("coupponName4"));
        //6.kuponu turune gore aciklar
        pm.adescription.sendKeys(ConfigReader.getProperty("description4"));
        //7.Discount Type menusundeki seceneklerden birini secer
        WebElement discountType = pm.adiscountType;
        Select options = new Select(discountType);
        options.selectByIndex(0);
        //8.secilen discount type'a uygun amount degeri girilir
        pm.aamount.clear();
        pm.aamount.sendKeys(ConfigReader.getProperty("amount4"));
        //9.Coupon expiry date bolumune guncel tarih oncesi  bir deger  girer
        ReusableMethods.click(pm.adate);
        ReusableMethods.click(pm.aYearNumber);
        ReusableMethods.click(pm.aSelectYEar);
        ReusableMethods.click(pm.adayNumber);
        //10.Kupon ücretsiz gönderim sağlıyorsa Free shipping kutucugunu isaretller
        WebElement free = pm.afreeShipping;
        ReusableMethods.click(free);
        //11.Kuponu mağaza sayfasında göstermek istiyorsa "Show on store" kutucugunu secebilmeli
        WebElement show = pm.ashow;
        ReusableMethods.click(show);
        //12.submit'e basar
        WebElement submit = pm.asubmit;
        ReusableMethods.click(submit);
        //13.girilen expiry date degerinin kaydedilmedigini dogrular
        ReusableMethods.click(pm.acoupons);
        List<WebElement> dateCells = Driver.getDriver().findElements(By.xpath("//tbody//td[5]"));
        Thread.sleep(2000);
        String actualDate = dateCells.get(0).getText();
        String expectedDate = "–";
        Assert.assertEquals(actualDate, expectedDate);
    }
}
