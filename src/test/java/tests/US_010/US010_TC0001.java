package tests.US_010;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EPearlyMarketPage;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US010_TC0001 extends TestBaseRapor {
    EPearlyMarketPage pearlyMarketPage;

    @Test
    public void colorMenuTest() throws InterruptedException {
        extentTest = extentReports.createTest("Color menu testi","renk seceneği;beyaz,siyah,yesil vs. tum renkler belirtilebilmeli");
        ReusableMethods.PearlyDriver();

        pearlyMarketPage = new EPearlyMarketPage();

        //Add product bölümündeki tüm ayrıntılar doldurur
        extentTest.info("Add product bölümündeki tüm ayrıntılar doldurur");
        // Acilan sayfada asagiya inerek 'attributes' butonuna tiklar
        extentTest.info("Acilan sayfada asagiya inerek 'attributes' butonuna tiklar");
        ReusableMethods.click(pearlyMarketPage.attributesButonu);


        // 'color' butonuna tiklar
        extentTest.info("'color' butonuna tiklar");
        ReusableMethods.waitFor(5);
        ReusableMethods.click(pearlyMarketPage.colorButonu);

        // SELECT ALL' butonuna tiklayarak tum renkleri secer
        extentTest.info("SELECT ALL' butonuna tiklayarak tum renkleri secer");
        Thread.sleep(5000);

        ReusableMethods.waitForVisibility(pearlyMarketPage.selectAllColorButonu,5);
        ReusableMethods.click(pearlyMarketPage.selectAllColorButonu);

        extentTest.info("SELECT ALL' butonuna tiklayarak tum renklerin seçildiğini test eder");
        Assert.assertTrue(pearlyMarketPage.yesilRenk.isDisplayed());
        extentReports.flush();
    }
}