package tests.US_005;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BPearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class US005_TC0001 {

    BPearlyMarketPage pearlymarketPage = new BPearlyMarketPage();
    Actions actions;
    WebElement iframe;


    @Test
    public void US005_TC001() throws AWTException {
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        ReusableMethods.prMrktlogIn();
        ReusableMethods.waitFor(5);

        //1-Store Manager butonuna basar
        ReusableMethods.prMrktstoreManager();

        //2-Products butonuna basar
        pearlymarketPage.b2productsButton.click();
        ReusableMethods.waitFor(3);


        //3-Ürün listesinin ve status, stock, price, date bölümlerinin olduğunu onaylar
       actions = new Actions(Driver.getDriver());
       actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
       Assert.assertTrue(pearlymarketPage.b2urunListesi.isDisplayed());
       Assert.assertTrue(pearlymarketPage.b2statusText.isDisplayed());
       Assert.assertTrue(pearlymarketPage.b2stockText.isDisplayed());
       Assert.assertTrue(pearlymarketPage.b2priceText.isDisplayed());
       Assert.assertTrue(pearlymarketPage.b2dateText.isDisplayed());

       //4-Add New butonuna basar
        pearlymarketPage.b2addNewButton.click();

        //5-Eklenecek ürün için urun icin virtual butonuna tıklar
        pearlymarketPage.b2virtualButton.click();

        //6-Eklenecek ürün için  downloadable butonuna tıklar
        pearlymarketPage.b2downloadableButton.click();

        //7-Product title'a urun ismi girilir
        pearlymarketPage.b2productTitleBox.sendKeys("Elmas Kupe");

        //8-Price'a ürün fiyatı girilir
        pearlymarketPage.b2regularPriceBox.sendKeys("500");

        //9-Sale Price'a indirimli fiyat girilir
        pearlymarketPage.b2salePriceBox.sendKeys("400");

        //10-Short description alanına açıklama yazılır, Add media butonuna tıklanır
         ReusableMethods.scrollIntoView(pearlymarketPage.b2shortDescriptionIframe);
         ReusableMethods.click(pearlymarketPage.b2ShortDescriptionAddMediaButton);
         ReusableMethods.click(pearlymarketPage.b2ShortDescriptionAddMediaCloseButton);
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().frame(pearlymarketPage.b2shortDescriptionIframe);
        ReusableMethods.click(pearlymarketPage.b2shortDescriptionTextBox);
        pearlymarketPage.b2shortDescriptionTextBox.sendKeys("Elmas Kupe");
        ReusableMethods.waitFor(3);
        Driver.getDriver().switchTo().defaultContent();


       // //11- Description alanına açıklama yazılır, Add media butonuna tıklanır
        ReusableMethods.scrollIntoView(pearlymarketPage.b2DescriptionIFrame);
        ReusableMethods.click(pearlymarketPage.b2descriptionAddMediaButton);
        ReusableMethods.click(pearlymarketPage.b2DescriptionAddMediaCloseButton);
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().frame(pearlymarketPage.b2DescriptionIFrame);
        ReusableMethods.click(pearlymarketPage.b2descriptionTextBox);
        pearlymarketPage.b2descriptionTextBox.sendKeys("Guzel bir elmas kupe");
        ReusableMethods.waitFor(3);
        Driver.getDriver().switchTo().defaultContent();


        //12-Featured Images alanına fotoğraf yuklenir
        ReusableMethods.click(pearlymarketPage.b2featuredImg);
        ReusableMethods.click(pearlymarketPage.b2FeaturedImageSelectFileButton);

        Robot rb =new Robot();
        StringSelection str=new StringSelection("\"C:\\Users\\busra\\OneDrive\\Masaüstü\\picForTest\\elmas küpe.png\"");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);


        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        ReusableMethods.waitFor(4);
        ReusableMethods.switchToWindow("Choose Image");
        pearlymarketPage.b2FeaturedImageSelectButton.click();


        // 13-Gallery Images alanına fotoğraf yüklenir
        ReusableMethods.click(pearlymarketPage.b2galleryImg);
        ReusableMethods.click(pearlymarketPage.b2GalleryImageSelectFileButton);
        ReusableMethods.waitFor(3);

        Robot rb2 =new Robot();
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);


        // press Contol+V for pasting
        rb2.keyPress(KeyEvent.VK_CONTROL);
        rb2.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        rb2.keyRelease(KeyEvent.VK_CONTROL);
        rb2.keyRelease(KeyEvent.VK_V);

        ReusableMethods.waitFor(2);

        // for pressing and releasing Enter
        rb2.keyPress(KeyEvent.VK_ENTER);
        rb2.keyRelease(KeyEvent.VK_ENTER);



        ReusableMethods.waitFor(6);
        ReusableMethods.switchToWindow("Add to Gallery");
        pearlymarketPage.b2GalleryImageAddToGalleryButton.click();


        // 14-Categories alanının erişilebilir olduğu onaylanır
        pearlymarketPage.b2CategoriesList.forEach(t-> Assert.assertTrue(t.isEnabled()));

        ReusableMethods.waitFor(2);

        Driver.getDriver().close();




    }


}
