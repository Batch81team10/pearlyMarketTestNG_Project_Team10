package tests.US_006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BPearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class US006_TC0001 {
    BPearlyMarketPage pearlyMarketPage = new BPearlyMarketPage();

    @Test
    public void US006_TC0001() {

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        ReusableMethods.prMrktlogIn();
        ReusableMethods.waitFor(5);

       // 1-Store Manager butonuna basar
        ReusableMethods.prMrktstoreManager();

       // 2-Products butonuna basar
        pearlyMarketPage.b2productsButton.click();
        ReusableMethods.waitFor(3);

       // 3-Add New butonuna basar
        pearlyMarketPage.b2addNewButton.click();
        ReusableMethods.waitFor(2);

       // 4-Categories alanının göründüğünü onaylar
        pearlyMarketPage.b2CategoriesList.forEach(t-> Assert.assertTrue(t.isDisplayed()));
        ReusableMethods.waitFor(1);

       // 5-Categories alanından seçim yapılabildiğini onaylar
        pearlyMarketPage.b2ProductCategoriesClickButtonList.forEach(t-> ReusableMethods.click(t));
        pearlyMarketPage.b2ProductCategoriesClickButtonList.forEach(t-> Assert.assertTrue(t.isSelected()));

        Driver.getDriver().close();



    }
}
