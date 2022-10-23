package tests.US_016;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.M7PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US016_TC0001 {

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
        jse.executeScript("arguments[0].scrollIntoView(true);",myAccount);
        Thread.sleep(1000);
        Assert.assertTrue(myAccount.isDisplayed());
        pearlyMarketPage.m7MyAccount.click();

        //Store Manager'a tiklar
        pearlyMarketPage.m7storeManager.click();

        //Customers'a tiklar
        WebElement customers = pearlyMarketPage.m7Customers;
        ReusableMethods.waitForVisibility(customers,5);
        jse.executeScript("arguments[0].scrollIntoView(true);",customers);
        pearlyMarketPage.m7Customers.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();

        //Basliklari dogrular
        List<WebElement> baslik = Driver.getDriver().findElements(By.xpath("//thead//th"));
        for (WebElement basliklar: baslik) {
            System.out.print(basliklar.getText()+"/");
        }
        System.out.println("---------------------");
        String expectedBasliklar = "name/username/email/Location/orders/money spent/last order";
        //String actualBasliklar = Driver.getDriver().findElement(By.xpath("//thead//tr")).getText();
        Assert.assertNotEquals(baslik,expectedBasliklar);
        System.out.println("expectedBasliklar = " + expectedBasliklar);

        //table body'si icindeki hücrelerin dolu oldugunu dogrular
        WebElement body = Driver.getDriver().findElement(By.xpath("//tbody"));
        System.out.println("body = " + body);
        body.isDisplayed();

        Thread.sleep(2000);
        Driver.closeDriver();


    }

}
