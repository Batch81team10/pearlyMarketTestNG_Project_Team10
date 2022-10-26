package tests.US_004;

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

import java.util.ArrayList;
import java.util.List;

public class US004_TC0002 extends TestBaseRapor {

    S8PearlyMarketPage pearlyMarketPage;
    Actions actions;

    @Test
    public void testCase0002() throws InterruptedException {

        pearlyMarketPage= new S8PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("US004 TestCase_0002", "urun miktarının artırılıp azaltıldıgı gorulmeli");

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
        pearlyMarketPage.s8cart.click();
        extentTest.info("sepete tıklandı");

        //7. vendor wiew Cart'a tıklar
        ReusableMethods.waitFor(1);
        WebElement viewCart = pearlyMarketPage.viewCart;
        ReusableMethods.click(viewCart);
        extentTest.info("wiew karta tıklandı");

        //8. vendor ilk urunun miktarını 1arttırır
        //9. vendor ilk urunun miktarını 1 azaltır
        List<WebElement> mktrList = pearlyMarketPage.miktarList;

        for (int i = 0; i < mktrList.size(); i++) {

            WebElement now=
                    Driver.getDriver()
                            .findElement(By.xpath("//tbody//tr//td["+(i+1)+"]"));

            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].scrollIntoView(true);", now);

            if (pearlyMarketPage.urunArtir.isDisplayed()){
                Thread.sleep(1000);
                pearlyMarketPage.urunArtir.click();
                break;
            }
        }

        ReusableMethods.waitFor(2);

        List<WebElement> mktrList1 = pearlyMarketPage.miktarList;

        for (int i = 0; i < mktrList1.size(); i++) {

            WebElement now=
                    Driver.getDriver()
                            .findElement(By.xpath("//tbody//tr//td["+(i+1)+"]"));

            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].scrollIntoView(true);", now);

            if (pearlyMarketPage.urunAzalt.isDisplayed()){
                Thread.sleep(1000);
                pearlyMarketPage.urunAzalt.click();
                Thread.sleep(1000);
                break;
            }
        }

        extentTest.pass("urun miktarının artırılıp azaltıldıgı dogrulandı");

        //13. vendor Logout yapar
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
