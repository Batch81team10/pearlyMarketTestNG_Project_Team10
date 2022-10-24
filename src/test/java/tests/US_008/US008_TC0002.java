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

import java.util.List;

public class US008_TC0002 {

    EPearlyMarketPage pearlyMarketPage=new EPearlyMarketPage();
    @Test
    public void manageStockPozitifTest() {

        //Add product bölümündeki tüm ayrıntılar doldurur
        ReusableMethods.PearlyDriver();

        //Inventory bölümüne tıklar
        ReusableMethods.click(pearlyMarketPage.inventory);

        //SKU alanını uniqe bir değer girer
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        pearlyMarketPage.skuButonu.sendKeys("1234ATY");

        //Manage Stock alanını işaretler
        ReusableMethods.waitFor(10);
       ReusableMethods.click( pearlyMarketPage.manageStock);
        ReusableMethods.waitFor(3);

        //Stock Qty ve Allow Backorders bölümünüm görünür olduğunu kontrol eder
        Assert.assertTrue(pearlyMarketPage.stockQtyButonu.isDisplayed());
        Assert.assertTrue(pearlyMarketPage.allowBackordersMenu.isDisplayed());

        //Stock Qty  değer girer
        pearlyMarketPage.stockQtyButonu.clear();
        pearlyMarketPage.stockQtyButonu.sendKeys("45");

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
        Assert.assertEquals(sayac,tumSecenekler.size());
    }
}