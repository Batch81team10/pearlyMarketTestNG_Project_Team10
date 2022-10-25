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
import utilities.TestBaseRapor;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class US005_TC0001 extends TestBaseRapor {

    BPearlyMarketPage pearlymarketPage = new BPearlyMarketPage();
    Actions actions;
    WebElement iframe;


    @Test
    public void US005_TC001() throws AWTException {
        extentTest = extentReports.createTest("Urun ekleme", "Urun listesine yeni ürün eklenip eklenemedigi test edilir");
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        ReusableMethods.prMrktlogIn();
        ReusableMethods.waitFor(5);
        extentTest.info("My Account sayfasina gidildi");

        //1-Store Manager butonuna basar
        ReusableMethods.prMrktstoreManager();
        extentTest.info("Store Manager sayfasina gidildi");

        //2-Products butonuna basar
        pearlymarketPage.b2productsButton.click();
        ReusableMethods.waitFor(3);
        extentTest.info("Product sayfasina gidildi");


        //3-Ürün listesinin ve status, stock, price, date bölümlerinin olduğunu onaylar
       actions = new Actions(Driver.getDriver());
       actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
       Assert.assertTrue(pearlymarketPage.b2urunListesi.isDisplayed());
       Assert.assertTrue(pearlymarketPage.b2statusText.isDisplayed());
       Assert.assertTrue(pearlymarketPage.b2stockText.isDisplayed());
       Assert.assertTrue(pearlymarketPage.b2priceText.isDisplayed());
       Assert.assertTrue(pearlymarketPage.b2dateText.isDisplayed());
       extentTest.info("Ürün listesinin ve status, stock, price, date bölümlerinin gorunurlugu test edildi");

       //4-Add New butonuna basar
        pearlymarketPage.b2addNewButton.click();
        extentTest.info("Add new butonuna basildi");

        //5-Eklenecek ürün için urun icin virtual butonuna tıklar
        pearlymarketPage.b2virtualButton.click();
        extentTest.info("Virtual secenegi aktiflestirildi");

        //6-Eklenecek ürün için  downloadable butonuna tıklar
        pearlymarketPage.b2downloadableButton.click();
        ReusableMethods.waitFor(1);
        pearlymarketPage.b2downloadableButton.click();
        extentTest.info("Downloadable secenegi aktiflestirildi");

        //7-Product title'a urun ismi girilir
        pearlymarketPage.b2productTitleBox.sendKeys("Elmas Kupe");
        extentTest.info("Product Title bolumune urun ismi girildi");

        //8-Price'a ürün fiyatı girilir
        pearlymarketPage.b2regularPriceBox.sendKeys("500");
        extentTest.info("Price bolumune urun fiyati yazildi");

        //9-Sale Price'a indirimli fiyat girilir
        pearlymarketPage.b2salePriceBox.sendKeys("400");
        extentTest.info("Sale price bolumune  indirimli urun fiyati yazildi");

        //10-Short description alanına açıklama yazılır, Add media butonuna tıklanır
         ReusableMethods.scrollIntoView(pearlymarketPage.b2shortDescriptionIframe);
         ReusableMethods.click(pearlymarketPage.b2ShortDescriptionAddMediaButton);
         ReusableMethods.click(pearlymarketPage.b2ShortDescriptionAddMediaCloseButton);
        extentTest.info("Add Media butonuna basildi");

        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().frame(pearlymarketPage.b2shortDescriptionIframe);
        ReusableMethods.click(pearlymarketPage.b2shortDescriptionTextBox);
        pearlymarketPage.b2shortDescriptionTextBox.sendKeys("Elmas Kupe");
        ReusableMethods.waitFor(3);
        Driver.getDriver().switchTo().defaultContent();
        extentTest.info("Short description yazildi");


       // //11- Description alanına açıklama yazılır, Add media butonuna tıklanır
        ReusableMethods.scrollIntoView(pearlymarketPage.b2DescriptionIFrame);
        ReusableMethods.click(pearlymarketPage.b2descriptionAddMediaButton);
        ReusableMethods.click(pearlymarketPage.b2DescriptionAddMediaCloseButton);
        extentTest.info("Add Media butonuna basildi");

        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().frame(pearlymarketPage.b2DescriptionIFrame);
        ReusableMethods.click(pearlymarketPage.b2descriptionTextBox);
        pearlymarketPage.b2descriptionTextBox.sendKeys("Guzel bir elmas kupe");
        ReusableMethods.waitFor(3);
        Driver.getDriver().switchTo().defaultContent();
        extentTest.info("Description yazildi");


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
        extentTest.info("Featured Image yuklendi");


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
        extentTest.info("Gallery Image yuklendi");


        // 14-Categories alanının erişilebilir olduğu onaylanır
        pearlymarketPage.b2CategoriesList.forEach(t-> Assert.assertTrue(t.isEnabled()));
        ReusableMethods.waitFor(2);
        extentTest.info("Tum kategorilere erisilebildigi test edildi");

        ReusableMethods.scrollIntoView(pearlymarketPage.b2categoriesTable);
        ReusableMethods.click(pearlymarketPage.b2accessoriesBox);
        extentTest.info("Accessories kategorisine tiklandi");

        ReusableMethods.click(pearlymarketPage.b2submitButton);
        extentTest.info("Urun ekle butonuna basildi");

        ReusableMethods.waitForVisibility(pearlymarketPage.b2UrunEklendiText,6);
        Assert.assertTrue(pearlymarketPage.b2UrunEklendiText.isDisplayed());
        extentTest.info("Urunun eklendigi goruldu");

        extentReports.flush();




    }


}
