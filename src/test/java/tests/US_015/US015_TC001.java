package tests.US_015;

import com.github.javafaker.Faker;
import org.apache.http.util.Asserts;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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

public class US015_TC001 extends TestBaseRapor {
    C3PearlyMarketPage pearlyMarketPage = new C3PearlyMarketPage();
    Actions actions= new Actions(Driver.getDriver());
    Asserts asserts;
    Faker faker=new Faker();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    String url;
    String couponCode;

    @Test (priority = 1)
    public void testLogin() throws InterruptedException, IOException {
        extentTest = extentReports.createTest("testLogin", "Web automation");
        //Vendor basarili bir sekilde sign in olur
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        ReusableMethods.prMrktlogIn();
        extentTest.pass("Basarili login yapildi");
    }

    @Test(priority = 2)
    public void testLimitsCoupon() throws InterruptedException {
        extentTest = extentReports.createTest("testLimitsCoupon", "Web automation");
        //Store manager bolumune tiklar
        ReusableMethods.prMrktstoreManager();
        extentTest.info("Store manager bolumune tiklar");
        //Coupons butonuna tiklar
        ReusableMethods.scrollIntoView(pearlyMarketPage.c3Coupons);
        ReusableMethods.click(pearlyMarketPage.c3Coupons);
        extentTest.info("Coupons butonuna tiklar");
        String url = Driver.getDriver().getCurrentUrl();
        //Add New' tiklar
        ReusableMethods.click(pearlyMarketPage.c3AddNews);
        extentTest.info("Add New' tiklar");
        Thread.sleep(2000);
        //Kupon kodu girer
        //String couponCode = Faker.instance().color().name();
        String couponCode= faker.color().name();
        actions.sendKeys(pearlyMarketPage.c3CouponCode, couponCode).perform();
        extentTest.info("Kupon kodu girer ");
        Thread.sleep(2000);
        ReusableMethods.scrollIntoView(pearlyMarketPage.c3Limit);
        Thread.sleep(2000);
        //'Limit' butonuna tıklar
        pearlyMarketPage.c3Limit.click();
        extentTest.info("'Limit' butonuna tıklar ");
        Thread.sleep(2000);
        //'Usage limit per coupon'  textbox'ına limitPerKupon degerini girer
        actions.sendKeys(pearlyMarketPage.c3LimitCoupon, ConfigReader.getProperty("limitPerKupon")).sendKeys(Keys.TAB)
                .sendKeys(pearlyMarketPage.c3LimitItems, ConfigReader.getProperty("limitItems")).sendKeys(Keys.TAB)
                .sendKeys(pearlyMarketPage.c3LimitUser, ConfigReader.getProperty("limitPerUser")).perform();
        extentTest.info("'Usage limit per coupon'  textbox'ına limitPerKupon degerini girer ");
        Thread.sleep(2000);
        pearlyMarketPage.c3Submit.click();
        extentTest.info("Submit butonuna tıklar ");
        Thread.sleep(2000);
        ReusableMethods.click(pearlyMarketPage.c3Coupons);
        extentTest.info("Coupons sayfasina gider ");
        //Driver.getDriver().get(url);
        ReusableMethods.waitForPageToLoad(15000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertEquals(pearlyMarketPage.c3CouponCodeFirst.getText(), couponCode);
        Assert.assertEquals(pearlyMarketPage.c3UsageLimit.getText(),ConfigReader.getProperty("limitPerKupon"));
        extentTest.pass("Coupons Limit yapılabildigi dogrulandi");
        Driver.closeDriver();


    }
}
