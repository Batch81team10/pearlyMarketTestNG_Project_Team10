package tests.US_021;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.M6PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US021_TC0001 extends TestBaseRapor {
    M6PearlyMarketPage pearlyMarketPage;
    @Test
    public void TestCase_0001() throws InterruptedException, IOException {
        pearlyMarketPage = new M6PearlyMarketPage();
        extentTest = extentReports.createTest("US0021 TestCase_0001", "Yillik rakamlar, en son ay, icinde bulunan ay, en son 7 gun içindeki raporlar bilgileri görülmeli");

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
        //9. vendor  yıllık tabloyu göruntulendigini test eder ve bilgileri yazdırır
        System.out.println("raporlar year" + pearlyMarketPage.M6RaporlarTablosu.getText());
        Assert.assertTrue(pearlyMarketPage.M6RaporlarTablosu.isDisplayed());
        ReusableMethods.getScreenshot("tablo");
        extentTest.info("yıllık rapor bilgileri test edildi");
        ReusableMethods.waitFor(2);
        //10. vendor  geçmiş aydakı tabloyu  test eder ve bilgileri yazdırır
        pearlyMarketPage.M6ReportsLastmount.click();
        ReusableMethods.scrollBy(500);;
        System.out.println("raporlar son ay" + pearlyMarketPage.M6ReportsLastmount.getText());
        Assert.assertTrue(pearlyMarketPage.M6RaporlarTablosu.isDisplayed());
        extentTest.info("geçmiş ay bilgileri test edildi");
        ReusableMethods.waitFor(1);
        //11. vendor  ıcınde bulunan aydakı tabloyu test eder ve bilgileri yazdırır
        pearlyMarketPage.M6ReportsThisMount.click();
        ReusableMethods.scrollBy(500);;
        System.out.println("raporlar bu ay" + pearlyMarketPage.M6ReportsThisMount.getText());
        Assert.assertTrue(pearlyMarketPage.M6RaporlarTablosu.isDisplayed());
        extentTest.info("içinde bulunan ay bilgileri test edildi");
        ReusableMethods.waitFor(2);
        // 12. vendor en son 7 gundeki tabloyu  test eder ve bilgilerini yazdırır
        pearlyMarketPage.M6ReportsLast7Days.click();
        ReusableMethods.scrollBy(500);;
        System.out.println("raporlar bu hafta " + pearlyMarketPage.M6ReportsLast7Days.getText());
        Assert.assertTrue(pearlyMarketPage.M6RaporlarTablosu.isDisplayed());
        extentTest.info("son 7 gündeki bilgileri test edildi");
        ReusableMethods.waitFor(2);
        extentTest.pass("Yillik rakamlar, en son ay, icinde bulunan ay, en son 7 gun içindeki raporlar bilgileri dogrulandı");
        Driver.closeDriver();

    }
}

