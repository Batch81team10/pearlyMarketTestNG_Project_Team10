package tests.US_009;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EPearlyMarketPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class US009_TC0003 {
    EPearlyMarketPage pearlyMarketPage;
    @Test
    public void hacimTeslimatPozitifTest () throws InterruptedException, IOException {
        ReusableMethods.PearlyDriver();

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
        ////////////////////////////////////////////////////////////////
        //Add product bölümündeki tüm ayrıntılar doldurur
        //Shipping butonuna tıklar
        ReusableMethods.click(pearlyMarketPage.Shippingbutonu);
        //Shipping bölümünün açıldığını test eder
        String expectedTitle = "Weight (kg)";
        ReusableMethods.waitFor(5);
        String actualTitle = pearlyMarketPage.weightButonuTitle.getText();
        ReusableMethods.waitFor(3);
        Assert.assertEquals(expectedTitle,actualTitle);
        //Weight(kg) bölümüne pozitif sayı değerleri girer
        pearlyMarketPage.weightButonu.sendKeys("35");
        //Length, Width, Heigth bölümüne pozitif sayı değerler girer
        pearlyMarketPage.length.sendKeys("20");
        pearlyMarketPage.Width.sendKeys("30");
        pearlyMarketPage.Heigth.sendKeys("15");
        //Processing Time menüdeki seçeneklerden her biri tek tek seçilebildiğini test eder
        Select select=new Select(pearlyMarketPage.ProcessingTime);
        List<WebElement> tumSecenekler= select.getOptions();


        int sayac=0;
        for (int i = 0; i < tumSecenekler.size() ; i++) {
            ReusableMethods.waitFor(1);
            tumSecenekler.get(i).click();
            ReusableMethods.waitFor(1);
            sayac++;

        }
        Assert.assertEquals(sayac,tumSecenekler.size());
        ////////////////////////////////////////////////////////////////////////
        ReusableMethods.waitFor(3);
        ReusableMethods.click(pearlyMarketPage.submit);
        ReusableMethods.waitFor(4);
        ReusableMethods.click(pearlyMarketPage.productButonu);
        ReusableMethods.waitFor(10);
        ReusableMethods.click(pearlyMarketPage.viewButonu);
        ArrayList<String> windowhandle = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowhandle.get(1));
        ReusableMethods.click(pearlyMarketPage.speficationButonu);
        ReusableMethods.waitFor(5);

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", pearlyMarketPage.Wigth);
        System.out.println();
        ReusableMethods.waitFor(4);
        ReusableMethods.getScreenshot("Hacim pozitif Test Sonuc");
        System.out.println(pearlyMarketPage.WigthVeLengthDegeri.get(1).getText());

        Assert.assertEquals(pearlyMarketPage.WigthVeLengthDegeri.get(1).getText(),"20 × 30 × 15 cm");

    }

}
