package tests.US_004;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.S8PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US004_TC0002 {
    S8PearlyMarketPage pearlyMarketPage = new S8PearlyMarketPage();

    @Test
    public void testCase0002() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        Thread.sleep(1000);
        ReusableMethods.prMrktlogIn();
        //ReusableMethods.besUrunEkle();
        Thread.sleep(1000);
        pearlyMarketPage.s8cart.click();
        WebElement viewCart = pearlyMarketPage.viewCart;
        ReusableMethods.click(viewCart);
        List<WebElement> mktrList = pearlyMarketPage.miktarList;

        Actions actions = new Actions(Driver.getDriver());

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

        Thread.sleep(1000);

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
/*
        Thread.sleep(1000);
        WebElement clearCart = pearlyMarketPage.clearCart;
        ReusableMethods.scrollIntoView(clearCart);
        Thread.sleep(1000);
        ReusableMethods.waitForClickablility(clearCart, 5);
        ReusableMethods.click(clearCart);

 */
        Driver.closeDriver();
        ReusableMethods.waitFor(1);

    }
}
