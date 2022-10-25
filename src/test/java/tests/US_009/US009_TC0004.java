package tests.US_009;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EPearlyMarketPage;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.IOException;
import java.util.ArrayList;

public class US009_TC0004 {
    EPearlyMarketPage pearlyMarketPage;
    @Test
    public void hacimTeslimatNegatifTest() throws IOException {
        ReusableMethods.PearlyDriver();

        pearlyMarketPage=new EPearlyMarketPage();

        //Add product bölümündeki tüm ayrıntılar doldurur

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
        //Shipping butonuna tıklar
        ReusableMethods.click(pearlyMarketPage.Shippingbutonu);
        //Shipping bölümünün açıldığını test eder
        String expectedTitle = "Weight (kg)";
        ReusableMethods.waitFor(5);
        String actualTitle = pearlyMarketPage.weightButonuTitle.getText();
        ReusableMethods.waitFor(3);
        Assert.assertEquals(expectedTitle,actualTitle);
        //Weight(kg) bölümüne negatif sayı değerleri girer
        pearlyMarketPage.weightButonu.sendKeys("-35");
        //Length, Width, Heigth bölümüne  negatif değerler girilerek hacim belirlenemediğini test eder
        pearlyMarketPage.length.sendKeys("-20");
        pearlyMarketPage.Width.sendKeys("-30");
        pearlyMarketPage.Heigth.sendKeys("-15");

        ReusableMethods.waitFor(3);
        ReusableMethods.click(pearlyMarketPage.submit);
        ReusableMethods.waitFor(4);
        ReusableMethods.click(pearlyMarketPage.productButonu);
        ReusableMethods.waitFor(10);
        ReusableMethods.click(pearlyMarketPage.viewButonu);
        ArrayList<String> pencereler = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(pencereler.get(1));
        ReusableMethods.click(pearlyMarketPage.speficationButonu);
        ReusableMethods.waitFor(5);

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", pearlyMarketPage.Wigth);
        System.out.println();
        ReusableMethods.waitFor(4);
        ReusableMethods.getScreenshot("Hacim Negatif Test Sonuc");
        System.out.println(pearlyMarketPage.WigthVeLengthDegeri.get(1).getText());

        Assert.assertNotEquals(pearlyMarketPage.WigthVeLengthDegeri.get(1).getText(),"-20 × -30 × -15 cm");

    }
}