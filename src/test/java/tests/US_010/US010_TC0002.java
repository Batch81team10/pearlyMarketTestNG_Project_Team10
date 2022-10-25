package tests.US_010;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EPearlyMarketPage;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US010_TC0002 extends TestBaseRapor {
    EPearlyMarketPage pearlyMarketPage;

    @Test
    public void sizeMenuTest()  {
        extentTest = extentReports.createTest("Size menu testi"," size seceneği;small,medium,large,extra large olmali");
        ReusableMethods.PearlyDriver();

        pearlyMarketPage = new EPearlyMarketPage();

        //Add product bölümündeki tüm ayrıntılar doldurur
        extentTest.info("Add product bölümündeki tüm ayrıntılar doldurur");
        // Acilan sayfada asagiya inerek 'attributes' butonuna tiklar
        extentTest.info("Acilan sayfada asagiya inerek 'attributes' butonuna tiklar");
        ReusableMethods.click(pearlyMarketPage.attributesButonu);

        // 'size' butonuna tiklar
        extentTest.info("'size' butonuna tiklar");
        ReusableMethods.waitFor(10);
        ReusableMethods.waitForVisibility(pearlyMarketPage.sizeButonu,5);
        ReusableMethods.click(pearlyMarketPage.sizeButonu);

        // SELECT ALL' butonuna tiklayarak tum bedenleri secer
        extentTest.info("SELECT ALL' butonuna tiklayarak tum bedenleri secer");
        ReusableMethods.waitForVisibility(pearlyMarketPage.selectAllSizeButonu,5);
        ReusableMethods.click(pearlyMarketPage.selectAllSizeButonu);

        extentTest.info("SELECT ALL' butonuna tiklayarak tum bedenlerin secildiğini test eder");
        Assert.assertTrue(pearlyMarketPage.xlarge.isDisplayed());
        extentReports.flush();
    }
}