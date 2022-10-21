package tests.US_003;

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

public class US003_TC0002 {
    S8PearlyMarketPage pearlyMarketPage = new S8PearlyMarketPage();

    @Test
    public void testCase0002() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));

        ReusableMethods.prMrktlogIn();
        Thread.sleep(2000);
        WebElement myAccount = pearlyMarketPage.myAccountYazisi;
        //ReusableMethods.waitForVisibility(myAccount, 5);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", myAccount);
        Thread.sleep(1000);
        pearlyMarketPage.myAccount.click();
        Thread.sleep(1000);
        pearlyMarketPage.s8sutunOrder.click();
        //JavascriptExecutor jse1 = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", pearlyMarketPage.s8goToShop);
        Thread.sleep(1000);
        pearlyMarketPage.s8goToShop.click();
        Thread.sleep(2000);
        List<WebElement> urunListesi = pearlyMarketPage.s8shopList;
        //System.out.println("urunListesi = " + urunListesi);

        int count = 0;
        int index = 0;

        for (int i = 0; i <= urunListesi.size(); i++) {
            index = i + 1;
            WebElement tiklanacakURun = Driver.getDriver().findElement(By.xpath("(//*[@class='product-media'])[" + index + "]"));
            //JavascriptExecutor jse2 = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].scrollIntoView(true);", tiklanacakURun);
            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(tiklanacakURun).perform();

            if (pearlyMarketPage.s8sepetSimge.isDisplayed()) {
                pearlyMarketPage.s8sepetSimge.click();
                Thread.sleep(6000);
            }
            count = Integer.parseInt(pearlyMarketPage.s8cartCount.getText());
            if (count==5) {
                break;
            }
        }
        Assert.assertEquals(pearlyMarketPage.s8cartCount.getText(), "5");

        Driver.closeDriver();
    }
}
