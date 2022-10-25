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
import utilities.TestBaseRapor;

public class US004_TC0003 extends TestBaseRapor {

    S8PearlyMarketPage pearlyMarketPage;
    Actions actions;

    @Test
    public void testCase0003() throws InterruptedException {

        pearlyMarketPage= new S8PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("US004 TestCase_0003", "Coupon butonu golulmeli");

        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");

        //2. vendor signin butonuna tıklar
        //3. vendor gecerli bir username girer
        //4. vendor gecerli bir password girer
        //5. vendor sign in butonuna basar
        Thread.sleep(1000);
        ReusableMethods.prMrktlogIn();
        extentTest.info("sayfaya login olundu");

        //6. vendor cart'a tıklar
        ReusableMethods.waitFor(2);
        ReusableMethods.click(pearlyMarketPage.s8cart);
        extentTest.info("sepete tıklandı");

        //7. vendor wiew Cart'a tıklar
        ReusableMethods.waitFor(1);
        WebElement viewCart = pearlyMarketPage.viewCart;
        ReusableMethods.waitFor(1);
        ReusableMethods.click(viewCart);
        extentTest.info("wiew karta tıklandı");

        //8. vendor Coupon secenegini gorebilmeli
        Thread.sleep(3000);
        ReusableMethods.scrollIntoView(pearlyMarketPage.coupon);
        ReusableMethods.waitFor(1);
        ReusableMethods.waitForVisibility(pearlyMarketPage.coupon,5);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(pearlyMarketPage.coupon.isDisplayed());
        extentTest.pass("Coupon butonunun gorunurlugu dogrulandı");

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
