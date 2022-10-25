package tests.US_008;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EPearlyMarketPage;
import utilities.ReusableMethods;

public class US008_TC0001 {

    EPearlyMarketPage pearlyMarketPage;
    @Test
    public void stockMiktariBelirleme() throws InterruptedException {
        ReusableMethods.PearlyDriver();
        pearlyMarketPage=new EPearlyMarketPage();
        pearlyMarketPage.productTitleButonu.sendKeys("tablo");
        pearlyMarketPage.resimeklemeButonu.click();
        ReusableMethods.click(pearlyMarketPage.mediaLibrary);
        pearlyMarketPage.tablo.click();
        pearlyMarketPage.selectResimEklemeButonu.click();
        ReusableMethods.waitFor(8);
        ReusableMethods.click(pearlyMarketPage.resimeklemebutonu2);

        ReusableMethods.waitFor(4);
        ReusableMethods.click(pearlyMarketPage.tablo2);
        ReusableMethods.click(pearlyMarketPage.addToGaleryBotonu);
        ReusableMethods.waitFor(3);

        ReusableMethods.click(pearlyMarketPage.coksatanlar);

///////////////////////////////////////////////////////////////////////////////

        pearlyMarketPage = new EPearlyMarketPage();
        //Add product bölümündeki tüm ayrıntılar doldurur


        //Inventory bölümüne gelinir
        ReusableMethods.click(pearlyMarketPage.inventory);

        //SKU alanını  bir değer girer
        pearlyMarketPage.skuButonu.sendKeys("1234AERT");

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

        ReusableMethods.waitFor(3);
        ReusableMethods.click(pearlyMarketPage.submit);
        ReusableMethods.waitFor(4);
        ReusableMethods.click(pearlyMarketPage.productButonu);
        ReusableMethods.waitFor(10);

        String actual=pearlyMarketPage.inStock.getText();
        Assert.assertEquals(actual,"In stock (45)");
    }
}