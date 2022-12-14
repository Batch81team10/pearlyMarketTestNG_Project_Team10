package tests.US_014;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.C3PearlyMarketPage;
import pages.PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.time.Duration;

public class US014_TC001 extends TestBaseRapor {
    C3PearlyMarketPage pearlyMarketPage ;
    Actions actions= new Actions(Driver.getDriver());


    @Test(priority = 1)
    public void testLogin() {
        pearlyMarketPage = new C3PearlyMarketPage();
        extentTest = extentReports.createTest("testLogin", "Web automation");
        //Vendor basarili bir sekilde sign in olur
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        ReusableMethods.prMrktlogIn();
        //extentTest.info("Vendor basarili bir sekilde sign in olur");
        extentTest.pass("Basarili login yapildi");

    }

    @Test(priority = 2)
    public void testMinMaxSpend()  {
        pearlyMarketPage = new C3PearlyMarketPage();
        extentTest = extentReports.createTest("testMinMaxSpend", "Web automation");

        //Store manager bolumune tiklar
        ReusableMethods.prMrktstoreManager();
        extentTest.info("Store manager bolumune tiklar");

        //Coupons butonuna tiklar
        ReusableMethods.scrollIntoView(pearlyMarketPage.c3Coupons);
        ReusableMethods.click(pearlyMarketPage.c3Coupons);
        extentTest.info("Coupons butonuna tiklar");

        //Add New' tiklar
        ReusableMethods.click(pearlyMarketPage.c3AddNews);
        ReusableMethods.waitFor(2);
        extentTest.info("Add New' tiklar");

        //Kupon kodu girer
        String couponCode = Faker.instance().color().name();
        actions.sendKeys(pearlyMarketPage.c3CouponCode, couponCode).perform();
        ReusableMethods.waitFor(2);
        extentTest.info("Kupon kodu girer ");

        //minimum spend' de??erini girer
        ReusableMethods.scrollIntoView(pearlyMarketPage.c3MinSpend);
        pearlyMarketPage.c3MinSpend.sendKeys(ConfigReader.getProperty("minSpend"));
        extentTest.info("minimum spend' de??erini girer");

        //maximum spend' de??erini girer
        pearlyMarketPage.c3MaxSpend.sendKeys(ConfigReader.getProperty("maxSpend"));
        extentTest.info("maximum spend' de??erini girer");

    }

    @Test(priority = 9)
    public void testMinSpendTextBoxIsNotEmpty() {
        pearlyMarketPage = new C3PearlyMarketPage();
        extentTest = extentReports.createTest("testMinSpendTextBoxIsNotEmpty");

        Assert.assertTrue(Driver.getDriver().getPageSource().contains(ConfigReader.getProperty("minSpend")));
        //extentTest.info("Minimum spend degerinin kaydoldugu do??ruland??");
        extentTest.pass("Minimum spend degerinin kaydoldugu do??ruland??");

    }
    @Test(priority = 10)
    public void testMaxSpendTextBoxIsNotEmpty() {
        pearlyMarketPage = new C3PearlyMarketPage();
        extentTest = extentReports.createTest("testMaxSpendTextBoxIsNotEmpty");

        Assert.assertTrue(Driver.getDriver().getPageSource().contains(ConfigReader.getProperty("maxSpend")));
        //extentTest.info("Maximum spend degerinin kaydoldugu do??ruland??");
        extentTest.pass("Maximum spend degerinin kaydoldugu do??ruland??");

    }

    @Test(priority = 4)
    public void testCheckBoxClick() {
        pearlyMarketPage = new C3PearlyMarketPage();
        extentTest = extentReports.createTest("testCheckBoxClick");

        //individual use only' se??ene??ine t??klar
        pearlyMarketPage.c3IndividualUse.sendKeys(Keys.SPACE);
        //exclude sale item' se??ene??ini t??klar
        pearlyMarketPage.c3ExcludeSale.sendKeys(Keys.SPACE);
        //extentTest.info("Check boxlara tiklandi");
        extentTest.pass("Check boxlara tiklandi");
    }

    @Test(priority = 11)
    public void testIndividualUseIsSelected() {
        pearlyMarketPage = new C3PearlyMarketPage();
        extentTest = extentReports.createTest("testIndividualUseIsSelected", "Web automation");

        Assert.assertTrue(pearlyMarketPage.c3IndividualUse.isSelected());
        //extentTest.info("Check box seciminin kaydoldugu dogrulandi");
        extentTest.pass("Check box seciminin kaydoldugu dogrulandi");
    }

    @Test(priority = 5)
    public void testExcludeProducts()  {
        pearlyMarketPage = new C3PearlyMarketPage();
        extentTest = extentReports.createTest("testExcludeProducts");

        ReusableMethods.sendText(pearlyMarketPage.c3ExcludeProducts,"Air frayer (HD9650)");
        ReusableMethods.waitFor(3);
        //extentTest.info("Exclude Products secildi");
        extentTest.pass("Exclude Products secildi");
    }

    @Test(priority = 12)
    public void testExcludeProductsIsListed() {
        pearlyMarketPage = new C3PearlyMarketPage();
        extentTest = extentReports.createTest("testExcludeProductsIsListed");

        Assert.assertTrue(pearlyMarketPage.c3ExcludeProducts.getText().contains("Air"));
        //extentTest.info("Exclude Products seciminin kaydoldugu dogrulandi");
        extentTest.fail("Exclude Products seciminin kaydoldugu dogrulandi");
    }

    @Test(priority = 6)
    public void testExcludeCategories()  {
        pearlyMarketPage = new C3PearlyMarketPage();
        extentTest = extentReports.createTest("testExcludeCategories");

        //PearlyMarketPage.c3ExcludeCategories.sendKeys("For Men");
        ReusableMethods.sendText(pearlyMarketPage.c3ExcludeCategories,"Bracelet");
        ReusableMethods.waitFor(2);
        extentTest.pass("Exclude Categories secildi");
    }
    @Test(priority = 13)
    public void testExcludeCategoriesIsListed() {
        pearlyMarketPage = new C3PearlyMarketPage();
        extentTest = extentReports.createTest("testExcludeCategoriesIsListed");

        Assert.assertTrue(pearlyMarketPage.c3ExcludeCategories.getText().contains("Bracelet"));
        //extentTest.info("Exclude Products seciminin kaydoldugu dogrulandi");
        extentTest.fail("Exclude Products seciminin kaydoldugu dogrulandi");
    }



    @Test(priority = 7)
    public void testSubmit() {
        pearlyMarketPage = new C3PearlyMarketPage();
        extentTest = extentReports.createTest("testSubmit");

        ReusableMethods.click(pearlyMarketPage.c3Submit);
        ReusableMethods.waitFor(2);
        //extentTest.info("Coupons Restriction yap??labildigi dogrulandi");
        extentTest.pass("Coupons Restriction yap??labildigi dogrulandi");
    }

    @Test(priority = 3)
    public void testMaxGreaterThanMinSpend() {
        pearlyMarketPage = new C3PearlyMarketPage();
        extentTest = extentReports.createTest("testMaxGreaterThanMinSpend");

        int max= Integer.parseInt(pearlyMarketPage.c3MaxSpend.getText());
        System.out.println("max = " + max);
        int min= Integer.parseInt(pearlyMarketPage.c3MinSpend.getText());
        System.out.println("min = " + min);
        Assert.assertTrue(max>min);
        //extentTest.info("Coupons Restriction yap??labildigi dogrulandi");
        extentTest.fail("max spend degerinin min spend degerinden buyuk oldugu dogrulandi");

    }

    @Test(priority = 8)
    public void testPublishedMessage() {
        pearlyMarketPage = new C3PearlyMarketPage();
        extentTest = extentReports.createTest("testPublishedMessage");

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text()='Coupon Successfully Published.']")).isDisplayed());
       /* WebElement element = Driver.getDriver().findElement(By.xpath("//*[text()='Coupon Successfully Published.']"));
        String text = element.getText();
        Assert.assertTrue(text.contains("Successfully"));*/
        //extentTest.info("Coupons Restriction yap??labildigi dogrulandi");
        extentTest.pass("Coupons Restriction yap??labildigi dogrulandi");

    }
    @Test(priority = 14)
    public void testCloseDriver() {
        Driver.closeDriver();
    }
}
