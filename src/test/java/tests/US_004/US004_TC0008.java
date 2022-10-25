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

import java.util.List;

public class US004_TC0008 extends TestBaseRapor {

    S8PearlyMarketPage pearlyMarketPage;
    Actions actions;

    @Test
    public void testCase0008() throws InterruptedException {

        pearlyMarketPage= new S8PearlyMarketPage();
        actions=new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("US004 TestCase_0008", "Odeme adımına gecilebildigi gorulmeli");

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

        //6. vendor my account butonuna basar
        ReusableMethods.waitFor(2);
        WebElement myAccount = pearlyMarketPage.myAccountYazisi;
        ReusableMethods.scrollIntoView(myAccount);
        Thread.sleep(1000);
        pearlyMarketPage.myAccount.click();
        extentTest.info("My Account'a tıklandı");

        //7. vendor Orders butonuna basar
        Thread.sleep(1000);
        pearlyMarketPage.s8sutunOrder.click();
        extentTest.info("Orders butonuna tıklandı");

        //8. vendor go to shop'a tıklar
        ReusableMethods.scrollIntoView(pearlyMarketPage.s8goToShop);
        Thread.sleep(1000);
        pearlyMarketPage.s8goToShop.click();
        extentTest.info("go shop'a tıklandı");

        //9. vendor 2 adet ürün secip tek tek sepete ekler
        Thread.sleep(2000);
        List<WebElement> urunListesi = pearlyMarketPage.s8shopList;
        ReusableMethods.waitFor(1);

        int count = 0;
        int index = 0;

        for (int i = 0; i <= urunListesi.size(); i++) {
            index = i + 1;
            WebElement tiklanacakURun = Driver.getDriver().findElement(By.xpath("(//*[@class='product-media'])[" + index + "]"));

            ReusableMethods.scrollIntoView(tiklanacakURun);

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
        extentTest.info("2 adet urunsecilip sepete eklendi");

        //10. vendor cart'a tıklar
        Thread.sleep(1000);
        pearlyMarketPage.s8cart.click();
        extentTest.info("sepet'e tıklandı");

        //11. vendor wiew Cart'a tıklar
        ReusableMethods.waitFor(1);
        WebElement viewCart = pearlyMarketPage.viewCart;
        ReusableMethods.click(viewCart);
        extentTest.info("Wiew Cart'a tıklandı");

        //12. vendor proceed to checkout'a tıklar
        WebElement proceedChechOut=pearlyMarketPage.proceedToCheckOut;
        ReusableMethods.scrollIntoView(proceedChechOut);
        ReusableMethods.click(proceedChechOut);
        extentTest.info("Checkout'a tıklandı");

        //13. vendor basarılı bir şekilde odeme adımına gecebilmeli
        Thread.sleep(3000);
        ReusableMethods.scrollIntoView(pearlyMarketPage.paymentYazisi);
        ReusableMethods.waitFor(1);
        ReusableMethods.waitForVisibility(pearlyMarketPage.paymentYazisi, 5);
        Thread.sleep(1000);
        Assert.assertTrue(pearlyMarketPage.paymentYazisi.isDisplayed());
        extentTest.pass("Odeme adımına gecildigi dogrulandı");


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

        //14. vendor Logout yapar
        ReusableMethods.waitFor(2);
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
