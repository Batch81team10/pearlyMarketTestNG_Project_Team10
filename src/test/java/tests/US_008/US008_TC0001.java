package tests.US_008;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EPearlyMarketPage;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US008_TC0001 extends TestBaseRapor {

    EPearlyMarketPage pearlyMarketPage;
    @Test
    public void stockMiktariBelirleme() throws InterruptedException {
        extentTest = extentReports.createTest("Stok Miktarı Belirleme Testi","Stok miktarının doğru değerler ile belirlenebildiği test edilir.");
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

        extentTest.info("Add product bölümündeki tüm ayrıntılar doldurur");
        //Inventory bölümüne gelinir
        ReusableMethods.click(pearlyMarketPage.inventory);
        extentTest.info("Inventory bölümüne gelinir");
        //SKU alanını  bir değer girer
        pearlyMarketPage.skuButonu.sendKeys("1234AERT");
        extentTest.info("SKU alanını  bir değer girer");

        //Manage Stock alanını işaretler
        ReusableMethods.waitFor(10);
        ReusableMethods.click( pearlyMarketPage.manageStock);
        ReusableMethods.waitFor(3);
        extentTest.info("Manage Stock alanını işaretler");

        //Stock Qty ve Allow Backorders bölümünüm görünür olduğunu kontrol eder
        Assert.assertTrue(pearlyMarketPage.stockQtyButonu.isDisplayed());
        Assert.assertTrue(pearlyMarketPage.allowBackordersMenu.isDisplayed());
        extentTest.info("Stock Qty ve Allow Backorders bölümünün görünür olduğunu kontrol eder");

        //Stock Qty  değer girer
        pearlyMarketPage.stockQtyButonu.clear();
        pearlyMarketPage.stockQtyButonu.sendKeys("45");
        extentTest.info("Stock Qty  değer girer");

        ReusableMethods.waitFor(3);
        ReusableMethods.click(pearlyMarketPage.submit);
        ReusableMethods.waitFor(4);
        ReusableMethods.click(pearlyMarketPage.productButonu);
        ReusableMethods.waitFor(10);

        extentTest.info("Stok miktarının belirlenebildiği test edildi.");
        String actual=pearlyMarketPage.inStock.getText();
        Assert.assertEquals(actual,"In stock (45)");


        extentReports.flush();
    }
}