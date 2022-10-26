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

public class tekClastaDeneme extends TestBaseRapor {

    S8PearlyMarketPage pearlyMarketPage;
    Actions actions;


    @Test(priority = 1)
    public void myAccountGorunurlugu() throws InterruptedException {
        pearlyMarketPage= new S8PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("US002 TestCase_0001", "MyAccount gorunur olmalı");

        //1. vendor url'ye adresine gider ==>ortak class
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");


        //2. vendor signin butonuna tıklar  ==>ortak class
        //3. vendor gecerli bir username girer  ==>ortak class
        //4. vendor gecerli bir password girer  ==>ortak class
        //5. vendor signIn butonuna basar
        ReusableMethods.prMrktlogIn();
        extentTest.info("sayfaya login olundu");

        WebElement myAccount = pearlyMarketPage.myAccountYazisi;
        ReusableMethods.waitForVisibility(myAccount, 5);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", myAccount);
        Thread.sleep(1000);

        //6. vendor My Account'u gorur
        Assert.assertTrue(myAccount.isDisplayed());
        extentTest.pass("myAccount elementinin gorunurlugu dogrulandi");

        //6. vendor Logout yapar
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




    @Test (priority = 4)
    public void followingsButonununGorunurluguTesti() throws InterruptedException {
        pearlyMarketPage= new S8PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("US002 TestCase_0004", "followings butonunu gorunur olmalı");

        //1. vendor url'ye adresine gider ==>ortak class
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");


        //2. vendor signin butonuna tıklar  ==>ortak class
        //3. vendor gecerli bir username girer  ==>ortak class
        //4. vendor gecerli bir password girer  ==>ortak class
        //5. vendor signIn butonuna basar
        ReusableMethods.prMrktlogIn();
        extentTest.info("sayfaya login olundu");


        WebElement myAccount = pearlyMarketPage.myAccountYazisi;
        ReusableMethods.waitForVisibility(myAccount, 5);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", myAccount);
        Thread.sleep(1000);
        extentTest.info("sayfaya login olundu");

        //6. vendor My Account butonuna basar
        pearlyMarketPage.myAccount.click();

        //7. vendor followings butonunu gorur
        ReusableMethods.waitFor(1);
        Assert.assertTrue(pearlyMarketPage.s8followings.isDisplayed());
        extentTest.pass("followings butonunun gorunurlugu dogrulandi");

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




    @Test (priority = 2)
    public void ordersElementininGorunurluguTesti() throws InterruptedException {
        pearlyMarketPage= new S8PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("US002 TestCase_0002", "Order butonu gorunur olmalı");

        //1. vendor url'ye adresine gider ==>ortak class
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");


        //2. vendor signin butonuna tıklar  ==>ortak class
        //3. vendor gecerli bir username girer  ==>ortak class
        //4. vendor gecerli bir password girer  ==>ortak class
        //5. vendor signIn butonuna basar
        ReusableMethods.prMrktlogIn();
        extentTest.info("sayfaya login olundu");


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




    @Test (priority = 3)
    public void storeManagerButonununGorunurluguTesti() {
        pearlyMarketPage= new S8PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("US002 TestCase_0003", "storeManager butonunu gorunur olmalı");

        //1. vendor url'ye adresine gider ==>ortak class
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");


        //2. vendor signin butonuna tıklar  ==>ortak class
        //3. vendor gecerli bir username girer  ==>ortak class
        //4. vendor gecerli bir password girer  ==>ortak class
        //5. vendor signIn butonuna basar
        ReusableMethods.prMrktlogIn();
        extentTest.info("sayfaya login olundu");


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
