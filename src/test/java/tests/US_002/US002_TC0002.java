package tests.US_002;

import org.apache.xmlbeans.impl.xb.xsdschema.DerivationControl;
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

public class US002_TC0002 {
    S8PearlyMarketPage pearlyMarketPage = new S8PearlyMarketPage();

    @Test
    public void testCase0002() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        ReusableMethods.prMrktlogIn();
        WebElement myAccount = pearlyMarketPage.myAccountYazisi;
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(myAccount);

    //    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(3);
     //   jse.executeScript("arguments[0].scrollIntoView(true);", myAccount);
        Thread.sleep(1000);
        pearlyMarketPage.myAccount.click();
        Thread.sleep(3000);
        ReusableMethods.scrollIntoView(pearlyMarketPage.s8sutunOrder);
        Thread.sleep(2000);
        Assert.assertTrue(pearlyMarketPage.s8sutunOrder.isDisplayed());
        Driver.closeDriver();
    }
}
