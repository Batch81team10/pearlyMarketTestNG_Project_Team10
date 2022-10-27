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

public class US_013_TC_003 {
    APearlyMarketPage pm;
    Actions actions;

    @Test
    public void cCuopponInvalidAmount() throws InterruptedException {
        pm = new APearlyMarketPage();
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        //1. vendor basarili bir sekilde sign in olur
        ReusableMethods.waitFor(2);
        ReusableMethods.prMrktlogIn();
        //  2.MY ACCOUNT secenegine tiklar
        // 3.store manager bolumune tiklar
        ReusableMethods.waitFor(2);
        ReusableMethods.prMrktstoreManager();
        //4.coupons bolumunden "add new" secenegini secer
        actions = new Actions(Driver.getDriver());
        WebElement couppon = pm.acoupons;
        WebElement addNew = pm.aaddNewLink;
        actions.sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).perform();
        actions.moveToElement(couppon).perform();
        ReusableMethods.waitFor(2);
        actions.click(addNew).perform();
        //5.code butonuna  sayisal deger ve harf yazar
        pm.acode.sendKeys(ConfigReader.getProperty("coupponName3"));
        //6.kuponu turune gore aciklar
        pm.adescription.sendKeys(ConfigReader.getProperty("description3"));
        //7.Discount Type menusundeki seceneklerden "percentage discount'u" secer
        WebElement discountType = pm.adiscountType;
        Select options = new Select(discountType);
        ReusableMethods.waitFor(2);
        options.selectByIndex(0);
        //8.Coupon Amount butonuna 100'den buyuk bir deger girer
        pm.aamount.clear();
        pm.aamount.sendKeys(ConfigReader.getProperty("amount3"));
        // 9.Coupon expiry date bolumune guncel tarih veya sonrasi bir deger  girer
        ReusableMethods.click(pm.adate);
        pm.adate.sendKeys(ConfigReader.getProperty("validDate"));
        //10.Kupon ücretsiz gönderim sağlıyorsa Free shipping kutucugunu isaretller
        WebElement free = pm.afreeShipping;
        ReusableMethods.click(free);
        //11.Kuponu mağaza sayfasında göstermek istiyorsa "Show on store" kutucugunu secebilmeli
        WebElement show = pm.ashow;
        ReusableMethods.click(show);
        //12.submit'e basar
        ReusableMethods.waitFor(2);
        WebElement submit = pm.asubmit;
        ReusableMethods.click(submit);
        //13.girilen amount degerinin kaydedilmedigini dogrular
        ReusableMethods.click(pm.acoupons);
        ReusableMethods.waitFor(2);
        List<WebElement> amountCells = Driver.getDriver().findElements(By.xpath("//tbody//td[3]"));
        ReusableMethods.waitFor(2);
        String actualAmount = amountCells.get(0).getText();
        String expectedAmount = "0";
        Assert.assertEquals(actualAmount, expectedAmount);
        Driver.closeDriver();
    }
}
