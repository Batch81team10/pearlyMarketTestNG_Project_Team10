package tests.US_010;

import org.testng.annotations.Test;
import pages.EPearlyMarketPage;
import utilities.ReusableMethods;

public class US010_TC0001 {
    EPearlyMarketPage pearlyMarketPage;

    @Test
    public void colorMenuTest() throws InterruptedException {
        ReusableMethods.PearlyDriver();

        pearlyMarketPage = new EPearlyMarketPage();

        //Add product bölümündeki tüm ayrıntılar doldurur
        // Acilan sayfada asagiya inerek 'attributes' butonuna tiklar
        ReusableMethods.click(pearlyMarketPage.attributesButonu);

        // 'color' butonuna tiklar
        ReusableMethods.waitFor(5);
        ReusableMethods.click(pearlyMarketPage.colorButonu);

        // SELECT ALL' butonuna tiklayarak tum renkleri secer
        Thread.sleep(5000);

        ReusableMethods.waitForVisibility(pearlyMarketPage.selectAllColorButonu,5);
        ReusableMethods.click(pearlyMarketPage.selectAllColorButonu);
    }
}