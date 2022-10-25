package tests.US_021;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.M6PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US021_TC0002 extends TestBaseRapor {
    M6PearlyMarketPage pearlyMarketPage;
    @Test
    public void TestCase_0001() throws InterruptedException, IOException {
        pearlyMarketPage = new M6PearlyMarketPage();
        extentTest = extentReports.createTest("US0021 TestCase_0002", "Raporlarda specific bir tarih araligi secilebilmeli");

        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");
        //2. vendor signin butonuna tıklar
        //3. vendor gecerli bir username girer
        //4. vendor gecerli bir password girer
        //5. vendor sign in butonuna basar
        ReusableMethods.prMrktlogIn();
        extentTest.info("sayfaya login olundu");
        //6. vendor my account butonuna basar
        // 7.vendor store manager butonuna basar
        ReusableMethods.waitFor(5);
        ReusableMethods.prMrktstoreManager();
        ReusableMethods.waitFor(5);
        extentTest.info("Store Manager sayfasına gidildi");
        // 8. vendor  sol kosede yer alan seceneklerden raporlar secenegine tıklar
        ReusableMethods.scrollIntoView(pearlyMarketPage.M6Reportsbutonu);
        ReusableMethods.click(pearlyMarketPage.M6Reportsbutonu);
        pearlyMarketPage.M6ReportsYear.click();
        ReusableMethods.scrollBy(500);;
        extentTest.info("reports sayfasına gidildi");
        //9. vendor custom kutusuna tıklar ve spesifik bir tarih aralıgı secer
        ReusableMethods.waitFor(2);
        pearlyMarketPage.M6Custom.click();
        pearlyMarketPage.M6Custom.sendKeys("2022-10-10 to 2022-10-21");
        ReusableMethods.waitFor(2);
        extentTest.info("custom butonuna basıldı ve tarih girildi");
        //10. vendor  gelen tabloyu göruntulendigini test eder ve bilgileri yazdırır
        System.out.println("raporlar spesik tarih " + pearlyMarketPage.M6RaporlarTablosu.getText());
        extentTest.info("gelen tablo göruntulendi ve bilgiler yazdırıldı");
        Assert.assertTrue(pearlyMarketPage.M6RaporlarTablosu.isDisplayed());
        extentTest.pass("Raporlarda specific bir tarih araligi bilgileri dogrulandı");
        Driver.closeDriver();



}
}
