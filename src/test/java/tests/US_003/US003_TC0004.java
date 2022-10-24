package tests.US_003;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.S8PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US003_TC0004 {
    S8PearlyMarketPage pearlyMarketPage = new S8PearlyMarketPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void testCase0004() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        //ReusableMethods.prMrktlogIn();
        //ReusableMethods.waitForVisibility(pearlyMarketPage.s8signOut, 5);
        pearlyMarketPage.s8cart.click();
        ReusableMethods.waitFor(1);
        pearlyMarketPage.s8checkOut.click();
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
        Assert.assertTrue(pearlyMarketPage.s8kapidaOde.isSelected());
/*
        Thread.sleep(1000);
        actions.sendKeys(Keys.HOME);
        Thread.sleep(1000);
        ReusableMethods.waitForClickablility(pearlyMarketPage.s8cart, 5);
        pearlyMarketPage.s8cart.click();
        pearlyMarketPage.viewCart.click();
        WebElement clearCart = pearlyMarketPage.clearCart;
        ReusableMethods.scrollIntoView(clearCart);
        Thread.sleep(1000);
        ReusableMethods.waitForClickablility(clearCart, 5);
        ReusableMethods.click(clearCart);

 */

        //Driver.closeDriver();
    }
}
