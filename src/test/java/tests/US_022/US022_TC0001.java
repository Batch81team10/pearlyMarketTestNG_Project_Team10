package tests.US_022;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.M6PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US022_TC0001 extends TestBaseRapor {
    M6PearlyMarketPage pearlyMarketPage;

    @Test
    public void TC0001() {
        pearlyMarketPage = new M6PearlyMarketPage();
        extentTest = extentReports.createTest("US0022 TestCase_0001", "Trend Ürünler Kategorisinde Tumunu gor linki olmali ve tiklandiginda o kategorinin ana sayfasına götürmeli");
        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");
        //2. Trending kategorisine gider ve  yazısını doğrular
        ReusableMethods.scrollIntoView(pearlyMarketPage.M6Trending);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(pearlyMarketPage.M6Trending.getText().contains("Trending"));
        extentTest.info("Trending yazısı doğrulandı");
        ReusableMethods.waitFor(2);
        //3. Tümünü gör butonuna basar
        ReusableMethods.click(pearlyMarketPage.M6TumunuGor);
        extentTest.info("Tumunu gor butonuna basıldı");
        ReusableMethods.waitFor(2);
        //4. Trend ürünler kategorisinin ana sayfasına götürdüğü kontrol edilir
        String ActualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Trending";
        ReusableMethods.waitFor(2);
        Assert.assertTrue(ActualTitle.contains(expectedTitle));
        extentTest.pass("Trend Ürünler Kategorisinde Tumunu gor linki  ve tiklandiginda  ana sayfasına götürdüğü doğrulandı");
        Driver.closeDriver();



    }
}
