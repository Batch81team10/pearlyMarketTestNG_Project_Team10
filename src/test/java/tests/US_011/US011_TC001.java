package tests.US_011;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.Y9PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US011_TC001 {

    Y9PearlyMarketPage pearlyMarketPage=new Y9PearlyMarketPage();
    Actions actions=new Actions(Driver.getDriver());


    @Test
    public void US011_TC001() {

      //  1. vendor url'ye adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));

      //  2. vendor Sign in butonuna tıklar
      //  3. vendor kullanıcı adı ve password girip sign in ile hesabına giriş yapar
        ReusableMethods.prMrktlogIn();
        ReusableMethods.waitFor(3);

      //  4.Ana sayfadaki Profile logosuna (Sign Out) tıklayıp My Acount a ulaşır
      //  5. Açılan sayfada Store Manager sekmesine tıklar
        ReusableMethods.prMrktstoreManager();

      //  6.My Store altındaki once Products a ve sonra  Add new e tıklar
        pearlyMarketPage.y9productsButton.click();
        pearlyMarketPage.y9addNew.click();

      //  7.Açılan sayfada Toptan Ürün Gösterme Ayarları na tıklayabilmeli
        ReusableMethods.scrollIntoView(pearlyMarketPage.y9toptanGosterme);
        ReusableMethods.waitFor(1);
        pearlyMarketPage.y9toptanGosterme.click();

      //  8.Piece Type yanındaki kutucuga tıklayabilmeli
        Select select=new Select(pearlyMarketPage.y9pieceType);
        ReusableMethods.scrollIntoView(pearlyMarketPage.y9pieceType);


      //  9.Açılan seçeneklerden birini seçebilmeli
        select.selectByIndex((int)Math.floor(Math.random()*3));


    }
}
