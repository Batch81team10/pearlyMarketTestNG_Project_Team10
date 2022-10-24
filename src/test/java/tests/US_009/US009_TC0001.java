package tests.US_009;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EPearlyMarketPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.ArrayList;

public class US009_TC0001 {

   EPearlyMarketPage pearlyMarketPage;
   @Test
    public void kiloBoyutPozitifTest() throws IOException {
      ReusableMethods.PearlyDriver();
       //Add product bölümündeki tüm ayrıntılar doldurur
       pearlyMarketPage=new EPearlyMarketPage();
       pearlyMarketPage.productTitleButonu.sendKeys("tablo");
       pearlyMarketPage.resimeklemeButonu.click();
       ReusableMethods.click(pearlyMarketPage.mediaLibrary);
       pearlyMarketPage.tablo.click();
       pearlyMarketPage.selectResimEklemeButonu.click();
       ReusableMethods.waitFor(8);
       ReusableMethods.click(pearlyMarketPage.resimeklemebutonu2);

       ReusableMethods.waitFor(4);
       ReusableMethods.click(pearlyMarketPage.tablo2);
       ReusableMethods.click(pearlyMarketPage.addToGaleryBotonu);
       ReusableMethods.waitFor(3);

       ReusableMethods.click(pearlyMarketPage.coksatanlar);
/////////////////////////////////////////////////////////////////////////

       //Add product bölümündeki tüm ayrıntılar doldurur
       //Shipping butonuna tıklar
       ReusableMethods.click(pearlyMarketPage.Shippingbutonu);
      //Shipping bölümünün açıldığını test eder
       Assert.assertTrue(pearlyMarketPage.weightButonuTitle.isDisplayed());
      //Weight(kg) bölümüne  sayı değeri girer
       pearlyMarketPage.weightButonu.sendKeys("35");
      //Length bölümüne pozitif sayı değeri girer
       pearlyMarketPage.length.sendKeys("20");

///////////////////////////////////////////////////////////////////////////////

    // pozitif değerler girilebildiğini test eder
    ReusableMethods.waitFor(3);
    ReusableMethods.click(pearlyMarketPage.submit);
    ReusableMethods.waitFor(4);
    ReusableMethods.click(pearlyMarketPage.productButonu);
    ReusableMethods.waitFor(10);
    ReusableMethods.click(pearlyMarketPage.viewButonu);

    ArrayList<String> windowHandle = new ArrayList<>(Driver.getDriver().getWindowHandles());
    Driver.getDriver().switchTo().window(windowHandle.get(1));
    ReusableMethods.click(pearlyMarketPage.speficationButonu);
    ReusableMethods.waitFor(5);

    ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", pearlyMarketPage.Wigth);

    ReusableMethods.waitFor(4);
    ReusableMethods.getScreenshot("Ağırlık ve Boyut pozitif Test Sonuc");
    System.out.println(pearlyMarketPage.WigthVeLengthDegeri.get(0).getText());
    Assert.assertEquals(pearlyMarketPage.WigthVeLengthDegeri.get(0).getText(),"35 kg");
    Assert.assertEquals(pearlyMarketPage.WigthVeLengthDegeri.get(1).getText(),"20 cm");
       }

}