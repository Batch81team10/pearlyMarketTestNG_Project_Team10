package tests.US_004;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.S8PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US004_TC0007 {
    S8PearlyMarketPage pearlyMarketPage = new S8PearlyMarketPage();

    @Test
    public void testCase0007() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        Thread.sleep(1000);
        ReusableMethods.prMrktlogIn();
        pearlyMarketPage.searchBox.sendKeys("legobricks", Keys.ENTER);
        Thread.sleep(1000);
        Actions actions = new Actions(Driver.getDriver());
        WebElement ekle = pearlyMarketPage.legoBricksAddCart;
        WebElement adetKutusu=pearlyMarketPage.legoBricksUrunAdetKutusu;
        ReusableMethods.scrollIntoView(ekle);
        Thread.sleep(1000);
        adetKutusu.clear();
        adetKutusu.sendKeys("5");
        Thread.sleep(1000);
        ReusableMethods.click(ekle);
        Thread.sleep(2000);
        Assert.assertEquals(pearlyMarketPage.s8cartCount.getText(), "0");
        Driver.closeDriver();
        ReusableMethods.waitFor(1);
    }
}
