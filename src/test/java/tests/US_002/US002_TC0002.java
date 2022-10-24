package tests.US_002;

import org.apache.xmlbeans.impl.xb.xsdschema.DerivationControl;
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

public class US002_TC0002 extends TestBaseRapor {

    S8PearlyMarketPage pearlyMarketPage;
    Actions actions;

    @Test
    public void testCase0002() throws InterruptedException {

        pearlyMarketPage= new S8PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("TestCase_0002", "Order butonu gorunur olmalı");

        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");

        //2. vendor signin butonuna tıklar
        //3. vendor gecerli bir username girer
        //4. vendor gecerli bir password girer
        //5. vendor sign in butonuna basar
        ReusableMethods.prMrktlogIn();
        WebElement myAccount = pearlyMarketPage.myAccountYazisi;
        actions.moveToElement(myAccount);
        ReusableMethods.waitFor(2);
        extentTest.info("sayfaya login olundu");

        //6. vendor My Account butonuna basar
        ReusableMethods.click(pearlyMarketPage.myAccount);
        //pearlyMarketPage.myAccount.click();
        Thread.sleep(3000);
        ReusableMethods.scrollIntoView(pearlyMarketPage.s8sutunOrder);
        Thread.sleep(2000);
        extentTest.info("myAccount'a tıklandı");

        //7. Orders, Downloads, addresses, account details,whislist ve Logout gorulmeli
        Assert.assertTrue(pearlyMarketPage.s8sutunOrder.isDisplayed());
        extentTest.pass("Orders elementinin gorunurlugu dogrulandi");

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
