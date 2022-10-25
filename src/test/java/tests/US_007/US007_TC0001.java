package tests.US_007;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EPearlyMarketPage;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US007_TC0001 extends TestBaseRapor {
    EPearlyMarketPage pearlyMarketPage;

    @Test
    public void brandsSecilir() {
        extentTest = extentReports.createTest("Marka testi","Belirtilen markalara tiklanip tiklanamadigi test edilir");
        ReusableMethods.PearlyDriver();
        pearlyMarketPage = new EPearlyMarketPage();

        List<WebElement> brands = new ArrayList<>(Arrays.asList(pearlyMarketPage.ElegantAutoGroup,
                pearlyMarketPage.GreenGrass,
                pearlyMarketPage.Sterling,
                pearlyMarketPage.SkysuiteTech,
                pearlyMarketPage.RED,
                pearlyMarketPage.NS8,
                pearlyMarketPage.NodeJs));
        int sayac = 0;
        for (WebElement w : brands
        ) {
            Assert.assertTrue(w.isDisplayed());
          ReusableMethods.click(w);
            ReusableMethods.waitFor(3);
            Assert.assertTrue(w.isSelected());
            sayac++;

        }
        System.out.println(sayac);
        extentTest.info("Belirtilen markalarin gorunurlugu test edildi");
        extentTest.info("Belirtilen markalara tiklanabildigi test edildi");

        extentReports.flush();
    }


}
