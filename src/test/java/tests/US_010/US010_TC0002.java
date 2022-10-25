package tests.US_010;

import org.testng.annotations.Test;
import pages.EPearlyMarketPage;
import utilities.ReusableMethods;

public class US010_TC0002 {
    EPearlyMarketPage pearlyMarketPage;

    @Test
    public void sizeMenuTest() {
        ReusableMethods.PearlyDriver();

        pearlyMarketPage = new EPearlyMarketPage();

        //Add product bölümündeki tüm ayrıntılar doldurur
        // Acilan sayfada asagiya inerek 'attributes' butonuna tiklar
        ReusableMethods.click(pearlyMarketPage.attributesButonu);

        // 'size' butonuna tiklar
        ReusableMethods.waitFor(10);
        ReusableMethods.waitForVisibility(pearlyMarketPage.sizeButonu,5);
        ReusableMethods.click(pearlyMarketPage.sizeButonu);

        // SELECT ALL' butonuna tiklayarak tum bedenleri secer
        ReusableMethods.waitForVisibility(pearlyMarketPage.selectAllSizeButonu,5);
        ReusableMethods.click(pearlyMarketPage.selectAllSizeButonu);

    }
}