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

public class US003_TC0005 extends TestBaseRapor {

    S8PearlyMarketPage pearlyMarketPage;
    Actions actions;

    @Test
    public void testCase0005() throws InterruptedException {

        pearlyMarketPage= new S8PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("TestCase_0001", "MyAccount gorunur olmalı");

        //1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("url'ye gidildi");

        //2. vendor signin butonuna tıklar
        //3. vendor gecerli bir username girer
        //4. vendor gecerli bir password girer
        //5. vendor sign in butonuna basar
        ReusableMethods.waitFor(1);
        ReusableMethods.prMrktlogIn();
        extentTest.info("sayfaya login olundu");

        //6. vendor sepete tıklar
        pearlyMarketPage.s8cart.click();
        extentTest.info("sepete tıklandı");

        //7. vendor checkout!a tıklar
        ReusableMethods.waitFor(1);
        pearlyMarketPage.s8checkOut.click();
        extentTest.info("checkOut tıklandı");

        //8. vendor country'ye tıklar ülke secer
        //9. vendor firstname bilgisi girer
        //10. vendor lastname bilgisi girer
        //11. vendorstreet adres satırına adres yazar
        //12. vendor town city bilgisi girer
        //13. vendor satate bilgisi girer
        //14. vendor zıp code bilgisi girer
        //15. vendor phone bilgisi girer
        //16. vendor email bilgisi girer
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
        Thread.sleep(1000);
        extentTest.info("siparis ve Fatura Bilgileri dolduruldu.");

        //17. vendor place order'a tıklar
        pearlyMarketPage.s8placeHolder.click();
        extentTest.pass("Siparis Başarı ile olusturuldu.");

        Assert.assertTrue(pearlyMarketPage.s8siparisAlindiYazisi.isDisplayed());

        //18. vendor Logout yapar
        ReusableMethods.waitFor(4);
        pearlyMarketPage.s8signOut.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.scrollIntoView(pearlyMarketPage.logOut);
        ReusableMethods.waitFor(1);
        pearlyMarketPage.logOut.click();

        Driver.closeDriver();
    }
}
