package tests.US_003;

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

public class US003_TC0004 extends TestBaseRapor {

    S8PearlyMarketPage pearlyMarketPage;
    Actions actions;

    @Test
    public void testCase0004() throws InterruptedException {

        pearlyMarketPage= new S8PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("US003_TestCase_0003", "checkOut butonunun gorunur olmalı");

        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");

        //2. vendor signin butonuna tıklar
        //3. vendor gecerli bir username girer
        //4. vendor gecerli bir password girer
        //5. vendor sign in butonuna basar
        ReusableMethods.prMrktlogIn();
        extentTest.info("sayfaya login olundu");

        //6. vendor sepete tıklar
        pearlyMarketPage.s8cart.click();
        extentTest.info("vendor cart'a tıklar");

        //7. vendor checkout!a tıklar
        ReusableMethods.waitFor(1);
        pearlyMarketPage.s8checkOut.click();
        extentTest.info("checkOut'a tıklar");

        //8. vendor country'ye tıklar ülke secer
        //9. vendor firstname bilgisi girer
        //10. vendor lastname bilgisi girer
        //11. vendorstreet adres satırına adres yazar
        //12. vendor town city bilgisi girer
        //13. vendor satate bilgisi girer
        //14. vendor zıp code bilgisi girer
        ReusableMethods.waitFor(1);
        pearlyMarketPage.s8firsName.sendKeys("can");
        actions.sendKeys(Keys.TAB)
                .sendKeys("caner")
                .sendKeys(Keys.TAB)
                .sendKeys("Team 10")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys("united s")
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys("salladım mah. attım sokak no:bilmiyorum")
                .sendKeys(Keys.TAB)
                .sendKeys("salladım mah. attım sokak no:bilmiyorum")
                .sendKeys(Keys.TAB)
                .sendKeys("kasaba yok")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .sendKeys("Florida")
                .sendKeys(Keys.ENTER).perform();
        pearlyMarketPage.s8zipcode.clear();
        pearlyMarketPage.s8zipcode.sendKeys("382541");
        actions.sendKeys(Keys.TAB)
                .sendKeys("1234567890")
                .sendKeys(Keys.TAB)
                .sendKeys("musterii0@musteri.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Hello")
                .sendKeys(Keys.TAB)
                .perform();
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(3000);
        if (!pearlyMarketPage.s8kapidaOde.isSelected()) {
            pearlyMarketPage.s8kapidaOde.click();
        }
        Assert.assertTrue(pearlyMarketPage.s8kapidaOde.isSelected());
        extentTest.pass("Vendor kapıda ode seceneginin secildigini dogrular");

        //15. vendor Logout yapar
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
