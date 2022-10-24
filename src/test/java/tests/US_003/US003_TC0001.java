package tests.US_003;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.S8PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US003_TC0001 {
    S8PearlyMarketPage pearlyMarketPage = new S8PearlyMarketPage();

    @Test
    public void testCase0001() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        ReusableMethods.prMrktlogIn();
        WebElement myAccount = pearlyMarketPage.myAccountYazisi;
        ReusableMethods.waitForVisibility(myAccount, 5);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", myAccount);
        Thread.sleep(1000);
        pearlyMarketPage.myAccount.click();
        Thread.sleep(1000);
        pearlyMarketPage.s8sutunOrder.click();
        JavascriptExecutor jse1 = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", pearlyMarketPage.s8goToShop);
        Thread.sleep(1000);
        pearlyMarketPage.s8goToShop.click();
        Thread.sleep(1000);
        Assert.assertTrue(pearlyMarketPage.s8shopYazisi.isDisplayed());
        //Driver.closeDriver();
    }
}
