package tests.US_004;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.S8PearlyMarketPage;
import tests.US_003.US003_TC0002;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US004_TC0001 extends US003_TC0002 {
    S8PearlyMarketPage pearlyMarketPage = new S8PearlyMarketPage();


    @Test//(dependsOnMethods = "testCase0002")
    public void TC0001() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        Thread.sleep(1000);
        ReusableMethods.prMrktlogIn();
        pearlyMarketPage.s8cart.click();
        WebElement viewCart = pearlyMarketPage.viewCart;
        ReusableMethods.click(viewCart);
        Thread.sleep(3000);
        System.out.println("pearlyMarketPage.sepettekiIlkUrunFiyatYazisi = "
                + pearlyMarketPage.sepettekiIlkUrunFiyatYazisi.getText());
        System.out.println("pearlyMarketPage.sepettekiIlkUrunAdetYazisi = "
                + pearlyMarketPage.sepettekiIlkUrunAdetYazisi.getText());
        System.out.println("pearlyMarketPage.sepettekiIlkUrunToplamFiyatYazisi = "
                + pearlyMarketPage.sepettekiIlkUrunToplamFiyatYazisi.getText());
        Assert.assertTrue(pearlyMarketPage.sepettekiIlkUrunFiyatYazisi.isDisplayed());
        Thread.sleep(1000);
        Assert.assertTrue(pearlyMarketPage.sepettekiIlkUrunAdetYazisi.isDisplayed());
        Thread.sleep(1000);
        Assert.assertTrue(pearlyMarketPage.sepettekiIlkUrunToplamFiyatYazisi.isDisplayed());

    }
}
