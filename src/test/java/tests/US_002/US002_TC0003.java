package tests.US_002;

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

public class US002_TC0003 extends TestBaseRapor {

    S8PearlyMarketPage pearlyMarketPage;
    Actions actions;

    @Test
    public void testCase0003() throws InterruptedException {

        pearlyMarketPage= new S8PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("US002 TestCase_0003", "storeManager butonunu gorunur olmalı");

        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");

        //2. vendor signin butonuna tıklar
        //3. vendor gecerli bir username girer
        //4. vendor gecerli bir password girer
        //5. vendor sign in butonuna basar
        ReusableMethods.prMrktlogIn();
        WebElement myAccount = pearlyMarketPage.myAccountYazisi;
        ReusableMethods.waitForVisibility(myAccount, 5);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", myAccount);
        ReusableMethods.waitFor(1);
        extentTest.info("sayfaya login olundu");

        //6. vendor My Account butonuna basar
        pearlyMarketPage.myAccount.click();

        //7. vendor Dashboard butonuna basar
        pearlyMarketPage.s8dashboard.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(pearlyMarketPage.storeManager.isDisplayed());
        extentTest.pass("storeManager butonunun gorunurlugu dogrulandi");

        //8. vendor Logout yapar
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
