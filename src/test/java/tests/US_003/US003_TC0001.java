package tests.US_003;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.S8PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US003_TC0001 extends TestBaseRapor {

    S8PearlyMarketPage pearlyMarketPage;
    Actions actions;

    @Test
    public void testCase0001() throws InterruptedException {

        pearlyMarketPage= new S8PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("US003_TestCase_0001", "go shop butonunu gorunur olmalı");

        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");

        //2. vendor signin butonuna tıklar
        //3. vendor gecerli bir username girer
        //4. vendor gecerli bir password girer
        //5. vendor sign in butonuna basar
        ReusableMethods.waitFor(1);
        ReusableMethods.prMrktlogIn();
        WebElement myAccount = pearlyMarketPage.myAccountYazisi;
        ReusableMethods.waitForVisibility(myAccount, 5);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", myAccount);
        Thread.sleep(1000);
        extentTest.info("sayfaya login olundu");

        //6. vendor My Account'a tıklar
        pearlyMarketPage.myAccount.click();
        Thread.sleep(1000);
        extentTest.info("My Account butonuna tıklar");

        //7. vendor Orders butonuna basar
        pearlyMarketPage.s8sutunOrder.click();
        JavascriptExecutor jse1 = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", pearlyMarketPage.s8goToShop);
        Thread.sleep(1000);
        extentTest.info("Orders butonuna tıklar");

        //8. vendor Go Shop'a tıklar
        pearlyMarketPage.s8goToShop.click();
        Thread.sleep(1000);
        Assert.assertTrue(pearlyMarketPage.s8shopYazisi.isDisplayed());
        extentTest.pass("go shop butonunun gorunurlugu dogrulandi");


        //9. vendor Logout yapar
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.HOME).perform();
        ReusableMethods.waitFor(2);
        pearlyMarketPage.s8signOut.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.scrollIntoView(pearlyMarketPage.logOut);
        ReusableMethods.waitFor(1);
        pearlyMarketPage.logOut.click();

        Driver.closeDriver();

    }
}
