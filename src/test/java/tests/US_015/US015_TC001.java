package tests.US_015;

import com.github.javafaker.Faker;
import org.apache.http.util.Asserts;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.C3PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.time.Duration;

public class US015_TC001 extends TestBaseRapor {
    C3PearlyMarketPage pearlyMarketPage;
    Actions actions;
    Asserts asserts;
    Faker faker;
    WebDriverWait wait;
    String url;
    String couponCode;

    @Test
    public void testLimitsCoupon() throws InterruptedException, IOException {
        pearlyMarketPage = new C3PearlyMarketPage();
        actions = new Actions(Driver.getDriver());
        faker =new Faker();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        extentTest = extentReports.createTest("testLogin", "Web automation");
        //Vendor basarili bir sekilde sign in olur
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        ReusableMethods.prMrktlogIn();
        extentTest.info("Basarili login yapildi");
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
        //'Limit' butonuna t??klar
        pearlyMarketPage.c3Limit.click();
        extentTest.info("'Limit' butonuna t??klar ");
        Thread.sleep(2000);
        //'Usage limit per coupon'  textbox'??na limitPerKupon degerini girer
        actions.sendKeys(pearlyMarketPage.c3LimitCoupon, ConfigReader.getProperty("limitPerKupon")).sendKeys(Keys.TAB)
                .sendKeys(pearlyMarketPage.c3LimitItems, ConfigReader.getProperty("limitItems")).sendKeys(Keys.TAB)
                .sendKeys(pearlyMarketPage.c3LimitUser, ConfigReader.getProperty("limitPerUser")).perform();
        extentTest.info("'Usage limit per coupon'  textbox'??na limitPerKupon degerini girer ");
        Thread.sleep(2000);
        pearlyMarketPage.c3Submit.click();
        extentTest.info("Submit butonuna t??klar ");
        Thread.sleep(2000);
        ReusableMethods.click(pearlyMarketPage.c3Coupons);
        extentTest.info("Coupons sayfasina gider ");
        //Driver.getDriver().get(url);
        ReusableMethods.waitForPageToLoad(15000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertEquals(pearlyMarketPage.c3CouponCodeFirst.getText(), couponCode);
        Assert.assertEquals(pearlyMarketPage.c3UsageLimit.getText(),ConfigReader.getProperty("limitPerKupon"));
        extentTest.pass("Coupons Limit yap??labildigi dogrulandi");
        Driver.closeDriver();


    }
}
