package tests.US_022;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.M6PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class US022_TC0003 extends TestBaseRapor {
    M6PearlyMarketPage pearlyMarketPage;
    Select select;

    @Test
    public void TC0002() throws IOException {
        pearlyMarketPage = new M6PearlyMarketPage();
        extentTest = extentReports.createTest("US0022 TestCase_0003", "Trend Ürünler Fiyata göre sırala: Düşükten yükseğe\" seçildiğinde, fiyatların düşükten yükseğe sıralandığını doğrula.");
        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");
        ReusableMethods.waitFor(2);
        //2. vendor Trendin ürünler sayfasına git
        ReusableMethods.scrollIntoView(pearlyMarketPage.M6TumunuGor);
        ReusableMethods.waitFor(2);
        ReusableMethods.click(pearlyMarketPage.M6TumunuGor);
        extentTest.info("Tümünü gör sayfasına gidildi");
        // 3. vendor  Açılır menüde kullanici "Fiyata göre sırala: Düşükten yükseğe" seçeceğe git.
        Select select = new Select(pearlyMarketPage.M6Select);
        select.selectByIndex(4);
        ReusableMethods.waitFor(3);
        extentTest.info("Trend ürünler Düşükten yükseğe seçeneği seçildi");
        // 4.vendor "Fiyata göre sırala: Düşükten yükseğe" seçildiğinde, fiyatların düşükten yükseğe sıralandığını doğrula.
        String expetedEnucuz="$25.68";
        String actualEnucuz=pearlyMarketPage.M6Birinci.getText();
        Assert.assertEquals(actualEnucuz, expetedEnucuz);
        ArrayList<Double> urunlerDoubleDY= new ArrayList<Double>();
        String FiyatStr="";
        for (WebElement each:pearlyMarketPage.M6fiyatlistesi){
            FiyatStr=each.getText().replaceAll("\\D", "").replaceAll(",","");
            System.out.println(FiyatStr);;
            urunlerDoubleDY.add(Double.parseDouble(FiyatStr));
        }
        ArrayList<Double> kontrolListe= new ArrayList<>(urunlerDoubleDY);;
        Collections.sort(kontrolListe);
        Assert.assertEquals(urunlerDoubleDY, kontrolListe);
        extentTest.pass("Fiyatların düşükten yükseğe göre sıralandığı doğrulandı");
        Driver.closeDriver();

    }
}