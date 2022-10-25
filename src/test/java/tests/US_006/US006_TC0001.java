package tests.US_006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BPearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class US006_TC0001 extends TestBaseRapor {
    BPearlyMarketPage pearlyMarketPage = new BPearlyMarketPage();

    @Test
    public void US006_TC0001() {
        extentTest = extentReports.createTest("Kategori testi","Tum kategorilere tiklanip tiklanamadigi test edilir");
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        ReusableMethods.prMrktlogIn();
        ReusableMethods.waitFor(5);
        extentTest.info("My Account sayfasina gidildi");

       // 1-Store Manager butonuna basar.
        ReusableMethods.prMrktstoreManager();
        extentTest.info("Store Manager sayfasina gidildi");

       // 2-Products butonuna basar
        pearlyMarketPage.b2productsButton.click();
        ReusableMethods.waitFor(3);
        extentTest.info("Product sayfasina gidildi");

       // 3-Add New butonuna basar
        pearlyMarketPage.b2addNewButton.click();
        ReusableMethods.waitFor(2);
        extentTest.info("Add new butonuna basildi");

       // 4-Categories alanının göründüğünü onaylar
        pearlyMarketPage.b2CategoriesList.forEach(t-> Assert.assertTrue(t.isDisplayed()));
        ReusableMethods.waitFor(1);
        extentTest.info("Tum kategorilerin gorunurlugu test edildi");

       // 5-Categories alanından seçim yapılabildiğini onaylar
        pearlyMarketPage.b2ProductCategoriesClickButtonList.forEach(t-> ReusableMethods.click(t));
        pearlyMarketPage.b2ProductCategoriesClickButtonList.forEach(t-> Assert.assertTrue(t.isSelected()));
        extentTest.info("Tum kategorilere tiklanabildigi test edildi");

        extentReports.flush();




    }
}
