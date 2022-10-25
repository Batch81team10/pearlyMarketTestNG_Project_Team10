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

public class US022_TC0004 extends TestBaseRapor {
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
        select.selectByIndex(5);
        ReusableMethods.waitFor(4);
        extentTest.info("Trend ürünler Yüksekten düşüğe göre seçeneği seçildi");
        // 4.vendor "Fiyata göre sırala: Düşükten yükseğe" seçildiğinde, fiyatların düşükten yükseğe sıralandığını doğrula.
        String expextedEnpahali="$450.68";
        String actualEnpahali=pearlyMarketPage.M6Birinci.getText();
        Assert.assertEquals(actualEnpahali, expextedEnpahali);
        ArrayList<Double> urunlerDoubleYD= new ArrayList<Double>();
        String FiyatStr="";
        for (WebElement each:pearlyMarketPage.M6fiyatlistesi){
            FiyatStr=each.getText().replaceAll("\\D", "").replaceAll(",","");
            System.out.println(FiyatStr);;
            urunlerDoubleYD.add(Double.parseDouble(FiyatStr));
        }
        ArrayList<Double> kontrolListe= new ArrayList<>(urunlerDoubleYD);;
        Collections.sort(kontrolListe, Collections.reverseOrder());
        Assert.assertEquals(urunlerDoubleYD, kontrolListe);
        extentTest.pass("Fiyatların yüksekten düşüğe göre sıralandığı doğrulandı");
        Driver.closeDriver();
    }
}
