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

import java.util.List;

public class US004_TC0008 {
    S8PearlyMarketPage pearlyMarketPage = new S8PearlyMarketPage();

    @Test
    public void TC0001() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        Thread.sleep(1000);
        //ReusableMethods.prMrktlogIn();
        ReusableMethods.waitFor(2);
        WebElement myAccount = pearlyMarketPage.myAccountYazisi;
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", myAccount);
        Thread.sleep(1000);
        pearlyMarketPage.myAccount.click();
        Thread.sleep(1000);
        pearlyMarketPage.s8sutunOrder.click();

        jse.executeScript("arguments[0].scrollIntoView(true);", pearlyMarketPage.s8goToShop);
        Thread.sleep(1000);
        pearlyMarketPage.s8goToShop.click();
        Thread.sleep(2000);

        List<WebElement> urunListesi = pearlyMarketPage.s8shopList;

        ReusableMethods.waitFor(1);

        int count = 0;
        int index = 0;
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i <= urunListesi.size(); i++) {
            index = i + 1;
            WebElement tiklanacakURun = Driver.getDriver().findElement(By.xpath("(//*[@class='product-media'])[" + index + "]"));

            jse.executeScript("arguments[0].scrollIntoView(true);", tiklanacakURun);

            actions.moveToElement(tiklanacakURun).perform();

            if (pearlyMarketPage.s8sepetSimge.isDisplayed()) {
                pearlyMarketPage.s8sepetSimge.click();

                Thread.sleep(7000);
            }
            count = Integer.parseInt(pearlyMarketPage.s8cartCount.getText());
            if (count == 2) {
                break;
            }

        }
        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(1000);
        ReusableMethods.waitForClickablility(pearlyMarketPage.home, 5);
        pearlyMarketPage.home.click();

        Thread.sleep(1000);
        pearlyMarketPage.s8cart.click();
        ReusableMethods.waitFor(1);
        WebElement viewCart = pearlyMarketPage.viewCart;
        ReusableMethods.click(viewCart);

        WebElement proceedChechOut=pearlyMarketPage.proceedToCheckOut;
        ReusableMethods.scrollIntoView(proceedChechOut);
        ReusableMethods.click(proceedChechOut);
        Thread.sleep(3000);
        ReusableMethods.scrollIntoView(pearlyMarketPage.paymentYazisi);
        ReusableMethods.waitFor(1);
        ReusableMethods.waitForVisibility(pearlyMarketPage.paymentYazisi, 5);
        Thread.sleep(1000);
        Assert.assertTrue(pearlyMarketPage.paymentYazisi.isDisplayed());
        Thread.sleep(1000);
        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(1000);
        pearlyMarketPage.s8cart.click();
        ReusableMethods.waitFor(1);
        ReusableMethods.click(viewCart);
        Thread.sleep(1000);
        WebElement clearCart = pearlyMarketPage.clearCart;
        ReusableMethods.scrollIntoView(clearCart);
        Thread.sleep(1000);
        ReusableMethods.waitForClickablility(clearCart, 5);
        ReusableMethods.waitFor(1);
        ReusableMethods.click(clearCart);
        ReusableMethods.waitFor(1);
        Driver.closeDriver();

    }
}
