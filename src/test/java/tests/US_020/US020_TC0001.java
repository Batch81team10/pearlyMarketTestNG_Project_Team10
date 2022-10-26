package tests.US_020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.M7PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.ObjectInputFilter;
import java.util.List;

public class US020_TC0001 {
    M7PearlyMarketPage pearlyMarketPage = new M7PearlyMarketPage();
    Actions action = new Actions(Driver.getDriver());

    @Test
    public void TC0001() throws InterruptedException {
        //vendro URL adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));

        //signin butonuna tiklar vendor hesabiyla giris yapar
        ReusableMethods.prMrktlogIn();

        //MY ACCOUNT yazisini gorur ve My Account'a tiklar
        WebElement myAccount = pearlyMarketPage.myAccountYazisi;
        ReusableMethods.waitForVisibility(myAccount,5);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", myAccount);
        Thread.sleep(1000);
        Assert.assertTrue(myAccount.isDisplayed());
        pearlyMarketPage.m7MyAccount.click();

        //Store Manager'a tiklar
        pearlyMarketPage.m7storeManager.click();

        //reviews'e tiklar
        WebElement revievsYazisi = pearlyMarketPage.m7Reviews;
        ReusableMethods.waitForVisibility(revievsYazisi,5);
        jse.executeScript("arguments[0].scrollIntoView(true);",revievsYazisi);
        Thread.sleep(1000);
        pearlyMarketPage.m7Reviews.click();

        //Product Reviews'e tiklar
        pearlyMarketPage.m7productReviews.click();

        //kullanici bilgisi ve yazmiş oldugu commenti inceler
        Thread.sleep(2000);
        action.sendKeys(Keys.PAGE_DOWN).perform();

        List<WebElement> storeReviews = Driver.getDriver().findElements(By.xpath("//tbody//td"));
        for (WebElement bilgiler:storeReviews) {
            System.out.println(bilgiler.getText());
        }

        storeReviews.get(1).isDisplayed();
        storeReviews.get(2).isDisplayed();
        System.out.print("Kullanici Bilgisi : " +storeReviews.get(1).getText()+"\n"+"KullaniciYorumu : " +storeReviews.get(2).getText());

        Driver.closeDriver();



    }

}
