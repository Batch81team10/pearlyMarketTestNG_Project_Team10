package tests.US_008;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EPearlyMarketPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class US008_TC0002 extends TestBaseRapor {

    EPearlyMarketPage pearlyMarketPage=new EPearlyMarketPage();
    @Test
    public void AllowBackordersAlanıSecenekTesti() {
        extentTest = extentReports.createTest("Allow Backorders Alanı Secenek Testi","Allow Backorders Alanındaki seceneklerin tek tek secilebildiğini test eder. ");
        //Add product bölümündeki tüm ayrıntılar doldurur
        ReusableMethods.PearlyDriver();
        extentTest.info("Add product bölümündeki tüm ayrıntılar doldurur");

        //Inventory bölümüne tıklar
        ReusableMethods.click(pearlyMarketPage.inventory);
        extentTest.info("Inventory bölümüne gelinir");

        //SKU alanını uniqe bir değer girer
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        pearlyMarketPage.skuButonu.sendKeys("1234ATY");
        extentTest.info("SKU alanını  bir değer girer");

        //Manage Stock alanını işaretler
        ReusableMethods.waitFor(10);
        ReusableMethods.click( pearlyMarketPage.manageStock);
        ReusableMethods.waitFor(3);

        //Stock Qty ve Allow Backorders bölümünüm görünür olduğunu kontrol eder
        Assert.assertTrue(pearlyMarketPage.stockQtyButonu.isDisplayed());
        Assert.assertTrue(pearlyMarketPage.allowBackordersMenu.isDisplayed());
        extentTest.info("Stock Qty ve Allow Backorders bölümünün görünür olduğunu kontrol eder");

        //Stock Qty  değer girer
        pearlyMarketPage.stockQtyButonu.clear();
        pearlyMarketPage.stockQtyButonu.sendKeys("45");
        extentTest.info("Stock Qty  değer girer");

        //Allow Backorders? alanından seçenekleri tek tek seçilebilir oduğunu test eder
        Select select=new Select(pearlyMarketPage.allowBackordersMenu);
        List<WebElement> tumSecenekler= select.getOptions();
        int sayac=0;
        for (int i = 0; i < tumSecenekler.size() ; i++) {
            ReusableMethods.waitFor(1);
            tumSecenekler.get(i).click();
            ReusableMethods.waitFor(1);
            sayac++;

        }
        extentTest.info("Allow Backorders? alanından seçenekleri tek tek seçilebilir oduğunu test eder");
        Assert.assertEquals(sayac,tumSecenekler.size());


        extentReports.flush();
    }
}