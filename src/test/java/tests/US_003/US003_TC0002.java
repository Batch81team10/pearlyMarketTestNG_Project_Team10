package tests.US_003;

import org.openqa.selenium.By;
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

import java.util.List;

public class US003_TC0002 extends TestBaseRapor {

    S8PearlyMarketPage pearlyMarketPage;
    Actions actions;

    @Test
    public void testCase0002() throws InterruptedException {

        pearlyMarketPage= new S8PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("US003_TestCase_0002", "Vendor 5 adet urun ekler");

        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");

        //2. vendor signin butonuna tıklar
        //3. vendor gecerli bir username girer
        //4. vendor gecerli bir password girer
        //5. vendor sign in butonuna basar
        ReusableMethods.waitFor(1);
        ReusableMethods.prMrktlogIn();
        Thread.sleep(2000);
        extentTest.info("sayfaya login olundu");

        //6. vendor My Account butonuna basar
        //7. vendor Orders butonuna basar
        //8. vendor Go Shop'a tıklar
        //9. vendor 5 adet ürün secip tek tek sepete ekler
        ReusableMethods.besUrunEkle();
        ReusableMethods.waitFor(1);
        extentTest.info("Vendor 5 adet urun ekler");

        //10. vendor 5 adet ürün eklendigini dogrular
        Assert.assertEquals(pearlyMarketPage.s8cartCount.getText(), "5");
        extentTest.pass("Vendor 5 adet urun eklendiğini dogrular");

        //11. vendor Logout yapar
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
