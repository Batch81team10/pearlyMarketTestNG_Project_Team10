package tests.US_018;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.C4PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US018_TC004 {
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    C4PearlyMarketPage c4PearlyMarketPage = new C4PearlyMarketPage();
    Actions actions = new Actions(Driver.getDriver());
    List<String> list;
    @Test
    public void US017_TC001() throws InterruptedException {

        // Kullanıcı https://pearlymarket.com/ sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        c4PearlyMarketPage.signIn.click();
        ReusableMethods.waitForVisibility(c4PearlyMarketPage.username, 15);
        c4PearlyMarketPage.username.sendKeys("bunedirya@gmail.com");
        c4PearlyMarketPage.password.sendKeys("Muzaffer");
        c4PearlyMarketPage.signIn2.click();
        //  Kullanıcı sepete ürün/ürünler ekler
        jse.executeScript("arguments[0].scrollIntoView(true);", c4PearlyMarketPage.shopNow);
        jse.executeScript("arguments[0].click();", c4PearlyMarketPage.shopNow);
        c4PearlyMarketPage.shopNow.click();
        Thread.sleep(10000);
        jse.executeScript("arguments[0].scrollIntoView(true);", c4PearlyMarketPage.airFrayer);
        Thread.sleep(5000);
        jse.executeScript("arguments[0].click();", c4PearlyMarketPage.frayerAddToCart);
        Thread.sleep(5000);
        // actions.moveToElement(c4PearlyMarketPage.yastik).perform();
        //c4PearlyMarketPage.frayerAddToCart.click();
        jse.executeScript("arguments[0].scrollIntoView(true);", c4PearlyMarketPage.CardButton);
        //  jse.executeScript("arguments[0].click();", c4PearlyMarketPage.atToCardButton);

        c4PearlyMarketPage.CardButton.click();
        Thread.sleep(10000);
        c4PearlyMarketPage.CheckOutButton.click();


        //  Kullanıcı Billing Address bilgilerini doğru girer
        c4PearlyMarketPage.firstName.clear();
        c4PearlyMarketPage.firstName.sendKeys("Cuneyt");
        actions.sendKeys(Keys.TAB).sendKeys("Erdemir").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("United States").sendKeys(Keys.TAB).
                sendKeys("41. Street").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Dolapdere").sendKeys(Keys.TAB).sendKeys("Massachusetts").
                sendKeys(Keys.TAB).sendKeys("38400").sendKeys(Keys.TAB).sendKeys("1234567").perform();
        // Shipping Address seçeneğini tıklamadan sipariş verir
        c4PearlyMarketPage.placeOrderbttn.click();
        Thread.sleep(3000);

        // Alışverişin tamamlandığı bilgisi görüntülenir
        Assert.assertTrue(c4PearlyMarketPage.orderReceived.isDisplayed());
        c4PearlyMarketPage.logOut.click();
        Thread.sleep(8000);

        jse.executeScript("arguments[0].scrollIntoView(true);", c4PearlyMarketPage.logOut2);
        Thread.sleep(5000);
        // jse.executeScript("arguments[0].click();", c4PearlyMarketPage.logOut2);
        c4PearlyMarketPage.logOut2.click();
        Thread.sleep(15000);
        c4PearlyMarketPage.signIn.click();
        Thread.sleep(5000);
        jse.executeScript("arguments[0].scrollIntoView(true);", c4PearlyMarketPage.username);

        c4PearlyMarketPage.username.sendKeys("team10.batch81@gmail.com");
        c4PearlyMarketPage.password.sendKeys("testng1081");
        c4PearlyMarketPage.signIn2.click();
        Thread.sleep(8000);

        // Vendor my account a tıklar
        jse.executeScript("arguments[0].scrollIntoView(true);", c4PearlyMarketPage.myAccount);
        //jse.executeScript("arguments[0].click();", c4PearlyMarketPage.myAccount);
        // c4PearlyMarketPage.myAccount.click();
        Thread.sleep(5000);
        //  Vendor Store Manager a tıklar
        c4PearlyMarketPage.storeManager.click();
        //Vendor Orders a tıklar
        jse.executeScript("arguments[0].scrollIntoView(true);", c4PearlyMarketPage.orders);
        //jse.executeScript("arguments[0].click();", c4PearlyMarketPage.orders);
        c4PearlyMarketPage.orders.click();
        Thread.sleep(15000);
        //Vendor (Mark as Complete) müşterinin siparişini onaylar
        //   jse.executeScript("arguments[0].click();", c4PearlyMarketPage.);
        jse.executeScript("arguments[0].scrollIntoView(true);", c4PearlyMarketPage.tikOrder);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();

        c4PearlyMarketPage.tikOrder.click();
        Thread.sleep(2000);
        //actions.sendKeys(Keys.ENTER).perform();
        Driver.getDriver().switchTo().alert().accept();
        ReusableMethods.waitForClickablility(c4PearlyMarketPage.refundRequest,15);
        //Vendor Refund Request kutucuğuna tıklar
        //c4PearlyMarketPage.refundRequest.click();
        jse.executeScript("arguments[0].click();", c4PearlyMarketPage.refundRequest);
        Thread.sleep(5000);
        // Vendor iade edilecek ürün miktarını belirler
        //Vendor (*) talep nedenini belirtmez ve hata alır
        c4PearlyMarketPage.partialRefund.sendKeys(Keys.ENTER);
        actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys("").perform();
        c4PearlyMarketPage.submitRequest.click();
        Thread.sleep(4000);
        //Vendor Refund Request i tamamlayamaz
        Assert.assertTrue(c4PearlyMarketPage.errorMessage.isDisplayed());


    }}
