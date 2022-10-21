package tests.US_011;

import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.Y9PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US011_TC003 {

    Y9PearlyMarketPage pearlyMarketPage=new Y9PearlyMarketPage();
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();



    @Test
    public void US011_TC003() {

        //  1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));

        //  2. vendor Sign in butonuna tıklar
        //  3. vendor kullanıcı adı ve password girip sign in ile hesabına giriş yapar
        ReusableMethods.prMrktlogIn();
        ReusableMethods.waitFor(3);

        //  4.Ana sayfadaki Profile logosuna (Sign Out) tıklayıp My Acount a ulaşır
        //  5. Açılan sayfada Store Manager sekmesine tıklar
        ReusableMethods.prMrktstoreManager();

        //  6.My Store altındaki once Products a ve sonra "Hatalı Urun" e tıklar
        pearlyMarketPage.y9productsButton.click();
        ReusableMethods.scrollIntoView(pearlyMarketPage.y9hataliUrunKaydi);
        ReusableMethods.waitFor(1);
        pearlyMarketPage.y9hataliUrunKaydi.click();

        //  7.Açılan sayfada Toptan Ürün Gösterme Ayarları na tıklayabilmeli
        ReusableMethods.scrollIntoView(pearlyMarketPage.y9toptanGosterme);
        ReusableMethods.waitFor(1);
        pearlyMarketPage.y9toptanGosterme.click();

        //8.Units Per Piece a negatif bir sayı girememeli
        ReusableMethods.scrollIntoView(pearlyMarketPage.y9unitPerpiece);
        ReusableMethods.waitFor(1);
        pearlyMarketPage.y9unitPerpiece.click();
       // actions.sendKeys(Keys.BACK_SPACE).perform();
        pearlyMarketPage.y9unitPerpiece.clear();

        long piece=-faker.number().randomNumber();
        pearlyMarketPage.y9unitPerpiece.sendKeys(String.valueOf(piece));

        pearlyMarketPage.y9hataliUrunSubmit.click();

        ReusableMethods.waitFor(2);
        try {
            ReusableMethods.getScreenshot("Hatali Urun");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
