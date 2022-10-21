package tests.US_001;

import org.testng.annotations.Test;
import pages.Y9PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US001_TC001 {

     Y9PearlyMarketPage pearlyMarketPage=new Y9PearlyMarketPage();

    @Test
    public void US001_TC001() {

        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));

        //2. vendor register butonuna tıklayabilmeli
        pearlyMarketPage.y9registerGiriş.click();

        //3. vendor açılan ekranda become a vendor'a tıklayabilmeli
        pearlyMarketPage.y9becomeVendor.click();

        Driver.closeDriver();

    }
}
