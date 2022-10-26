package tests.US_017;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.C4PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US017_TC001 {
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    C4PearlyMarketPage c4PearlyMarketPage=new C4PearlyMarketPage();
    Actions actions=new Actions(Driver.getDriver());
    @Test
    public void US017_TC001() throws InterruptedException {

        // Kullanıcı https://pearlymarket.com/ sitesine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        c4PearlyMarketPage.signIn.click();
        ReusableMethods.waitForVisibility(c4PearlyMarketPage.username,15);
        c4PearlyMarketPage.username.sendKeys("bunedirya@gmail.com");
        c4PearlyMarketPage.password.sendKeys("Muzaffer");
        c4PearlyMarketPage.signIn2.click();
        //  Kullanıcı sepete ürün/ürünler ekler
        //*[@href='https://pearlymarket.com/my-account-2/customer-logout/?_wpnonce=0bf2643280'])[1]
        jse.executeScript("arguments[0].click();", c4PearlyMarketPage.shopNow);
        c4PearlyMarketPage.shopNow.click();
        Thread.sleep(10000);
        jse.executeScript("arguments[0].scrollIntoView(true);", c4PearlyMarketPage.yastik);
        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();", c4PearlyMarketPage.yastikAddToCart);

       // actions.moveToElement(c4PearlyMarketPage.yastik).perform();
       // c4PearlyMarketPage.yastikAddToCart.click();
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



    }

}




