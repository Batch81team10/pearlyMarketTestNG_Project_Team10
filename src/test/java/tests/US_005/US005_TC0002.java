package tests.US_005;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BPearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class US005_TC0002 {

    BPearlyMarketPage pearlyMarketPage;
    Select select;

    Actions actions;

    @Test
    public void US005_TC0002() throws AWTException, InterruptedException {
        pearlyMarketPage = new BPearlyMarketPage();
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        ReusableMethods.prMrktlogIn();
        ReusableMethods.waitFor(5);

       //1-Store Manager butonuna basar
        ReusableMethods.prMrktstoreManager();

       //2-Products butonuna basar
        pearlyMarketPage.b2productsButton.click();
        ReusableMethods.waitFor(3);

       //3-Add New butonuna basar
        pearlyMarketPage.b2addNewButton.click();

       //4-Product özelliğini seçer
        select = new Select(pearlyMarketPage.b2productTypeTable);
        select.selectByVisibleText("Simple Product");




       //6- Featured Image alanına fotoğraf yükler

         ReusableMethods.click(pearlyMarketPage.b2featuredImg);
         ReusableMethods.waitFor(2);
         ReusableMethods.click(pearlyMarketPage.b2FeaturedImageSelectFileButton);
         ReusableMethods.waitFor(3);


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
         ReusableMethods.click(pearlyMarketPage.b2FeaturedImageSelectButton);


        //7-Gallery Images alanına fotoğraf yükler
         ReusableMethods.click(pearlyMarketPage.b2galleryImg);
         ReusableMethods.click(pearlyMarketPage.b2GalleryImageSelectFileButton);
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
         pearlyMarketPage.b2GalleryImageAddToGalleryButton.click();


        //8-Categories'den ürünün kategorisini seçer
         // ReusableMethods.scrollIntoView(pearlyMarketPage.b2categoriesTable);
         // ReusableMethods.click(pearlyMarketPage.b2accessoriesBox);

       //9-Submit butonuna basar
        ReusableMethods.click(pearlyMarketPage.b2submitButton);

       //10-Product Title olmadan ürün eklenemeyeceğini görür
        String hataText="Please insert Product Title before submit.";
        ReusableMethods.waitFor(2);
        Assert.assertTrue(pearlyMarketPage.b2ButunHataYazilari.getText().contains(hataText));
        System.out.println(pearlyMarketPage.b2ButunHataYazilari.getText());



    }
}
