package tests.US_002;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.S8PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US002_TC0001 extends TestBaseRapor {
    S8PearlyMarketPage pearlyMarketPage = new S8PearlyMarketPage();
    @Test
    public void TestCase_0001() throws InterruptedException {

        extentTest = extentReports.createTest("TestCase_0001", "MyAccount gorunur olmalı");

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");
        ReusableMethods.prMrktlogIn();
        extentTest.info("sayfaya login olundu");
        WebElement myAccount = pearlyMarketPage.myAccountYazisi;
        ReusableMethods.waitForVisibility(myAccount, 5);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", myAccount);
        Thread.sleep(1000);
        Assert.assertTrue(myAccount.isDisplayed());
        extentTest.pass("myAccount elementinin gorunurlugu dogrulandi");
        Driver.closeDriver();
    }
}
