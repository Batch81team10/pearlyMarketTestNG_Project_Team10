package tests.US_005;

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

public class US005_TC0003 {
    BPearlyMarketPage pearlyMarketPage = new BPearlyMarketPage();
    Select select;

    @Test
    public void US005_TC0003() throws AWTException {
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

        //5-Product Title'ı doldurur
        pearlyMarketPage.b2productTitleBox.sendKeys("Elmas Kupe");
        ReusableMethods.waitFor(1);

        //7-Gallery Images alanına fotoğraf yükler
        ReusableMethods.click(pearlyMarketPage.b2galleryImg);
        ReusableMethods.click(pearlyMarketPage.b2GalleryImageSelectFileButton);
        ReusableMethods.waitFor(3);

        Robot rb2 =new Robot();
        StringSelection str=new StringSelection("\"C:\\Users\\busra\\OneDrive\\Masaüstü\\picForTest\\elmas küpe.png\"");
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
        ReusableMethods.scrollIntoView(pearlyMarketPage.b2categoriesTable);
        ReusableMethods.click(pearlyMarketPage.b2accessoriesBox);

        //9-Submit butonuna basar
        ReusableMethods.click(pearlyMarketPage.b2submitButton);

        //10-Featured Image olmadan ürün eklenemeyeceğini görür
        String hataText="Featured img: This field is required.";
        ReusableMethods.waitFor(2);
        Assert.assertTrue(pearlyMarketPage.b2ButunHataYazilari.getText().contains(hataText));
        System.out.println(pearlyMarketPage.b2ButunHataYazilari.getText());

    }
}
