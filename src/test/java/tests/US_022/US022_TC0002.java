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
import java.util.List;

public class US022_TC0002 extends TestBaseRapor {
    M6PearlyMarketPage pearlyMarketPage;
    Select select;

    @Test
    public void TC0002() throws IOException {
        pearlyMarketPage = new M6PearlyMarketPage();
        extentTest = extentReports.createTest("US0022 TestCase_0002", "Trend Ürünler siralanabilmeli  :Varsayılan Sıralama -> Bu default seçenek olmali -");
        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");
        ReusableMethods.waitFor(2);
        //2. vendor Trendin ürünler sayfasına git
        ReusableMethods.click(pearlyMarketPage.M6TumunuGor);
        extentTest.info("Tümünü gör sayfasına gidildi");
        // 3. vendor  Açılır menüde default seçeneğin "Varsayılan Sıralama" olduğunu doğrula.
        select = new Select(pearlyMarketPage.M6Select);
        ReusableMethods.getScreenshot("varsayılan sıralama");
        Assert.assertTrue(select.getOptions().get(0).getText().equalsIgnoreCase("Default sorting"));
        extentTest.info("Defsult Sorting Doğrulandı");
        //4.vendor Açılır menüde bu seçeneklerin olduğunu doğrula:
        ReusableMethods.waitFor(2);
        List<WebElement> menu = select.getOptions();
        menu.forEach(t -> System.out.println(t.getText()));
        String expectedSiralaMenusu = "Default sorting" +
                "Sort by popularity" +
                "Sort by average rating" +
                "Sort by latest" +
                "Sort by price: low to high" +
                "Sort by price: high to low";

        String actualSiralamaMenusu1 = "";
        for (WebElement each : menu
        ) {
            actualSiralamaMenusu1 += each.getText();
        }
        Assert.assertEquals(expectedSiralaMenusu, actualSiralamaMenusu1);
        extentTest.pass(" Açılır menüde bu seçeneklerin olduğunu doğrulandı");
        Driver.closeDriver();

    }
}
