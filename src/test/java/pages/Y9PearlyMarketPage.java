package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Y9PearlyMarketPage {
    public Y9PearlyMarketPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Register']")
    public WebElement y9registerGiriş;

    @FindBy (xpath = "//a[text()='Become a Vendor']")
    public WebElement y9becomeVendor;

    @FindBy (xpath = "//*[@id='user_email']")
    public WebElement y9emailBox;

    @FindBy (xpath = "//input[@id='passoword']")
    public WebElement y9registerPassword;

    @FindBy (xpath = "//input[@id='confirm_pwd']")
    public WebElement y9registerConfirmPassword;

    @FindBy (xpath = "//*[@id='wcfm_membership_register_button']")
    public WebElement y9registerOnay;

    @FindBy (xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement y9emailZorunluMesaji;

    @FindBy (xpath = "//*[@class='wcfm-message email_verification_message wcfm-success']")
    public WebElement y9basariliRegisterMesaji;

    @FindBy (xpath = "//*[@class='wcfm-message email_verification_message wcfm-error']")
    public WebElement y9gecersizMailMesaji;

    @FindBy (xpath = "//div[@id='password_strength']")
    public WebElement y9strongPassword;

    @FindBy (xpath = "//input[@type='button']")
    public WebElement y9resendCode;

    @FindBy (xpath = "//input[@type='email']")
    public WebElement y9gmailGiris;

    @FindBy (xpath = "//*[text()='Sonraki']")
    public WebElement y9sonrakiButonu;

    @FindBy (xpath = "//*[@name='Passwd']")
    public WebElement y9gmailSifre;

    @FindBy (xpath = "(//span[@class='VfPpkd-vQzf8d'])[2]")
    public WebElement y9sifreSonrakiButonu;

    @FindBy (xpath = "//img[@class='gb_yc']")
    public WebElement y9gmailLogo;

    @FindBy (xpath = "//*[@class='wcfm-message wcfm-error']")
    public WebElement y9kayitliMailVar;

    @FindBy (xpath = "//*[@name='wcfm_email_verified_input']")
    public WebElement y9dogrulamaKodu;

    @FindBy (xpath = "(//span[@class='text'])[4]")
    public WebElement y9productsButton;


    @FindBy (xpath = "//*[@id='add_new_product_dashboard']")
    public WebElement y9addNew;

    @FindBy (xpath = "(//*[@class='page_collapsible_content_holder'])[9]")
    public WebElement y9toptanGosterme;

    @FindBy (xpath = "//select[@id='piecetype']")
    public WebElement y9pieceType;

    @FindBy (xpath = "//input[@id='unitpercart']")
    public WebElement y9unitPerpiece;

    @FindBy (xpath = "//*[@id='minorderqtytr']")
    public WebElement y9minOrderQuantity;

    @FindBy (xpath = "//*[text()='Hatalı Urun']")
    public WebElement y9hataliUrunKaydi;

    @FindBy (xpath = "//*[@name='submit-data']")
    public WebElement y9hataliUrunSubmit;

    @FindBy (xpath = "")
    public WebElement y9hataliUrunBasariliKayitYazisi;


    @FindBy (xpath = "(//*[@class='w-icon-account'])[1]")
    public WebElement y9signOut;

    @FindBy (xpath = "//span[@class='icon-box-icon icon-orders']")
    public WebElement y9orders;

    @FindBy (xpath = "//*[@class='icon-box-title text-normal']")
    public WebElement y9ordersListesi;

    @FindBy (xpath = "(//*[text()='Wishlist'])[2]")
    public WebElement y9wishList;


    @FindBy (xpath = "(//*[@class='product-thumbnail'])[1]")
    public WebElement y9productList;

    @FindBy (xpath = "(//*[text()='Addresses'])[1]")
    public WebElement y9addresses;

    @FindBy (xpath = "//h3[1]")
    public WebElement y9billingAdres;

    @FindBy (xpath = "//*[text()='Shipping address']")
    public WebElement y9shippingAdres;

    @FindBy (xpath = "(//*[text()='Account details'])[1]")
    public WebElement y9accountDetails;

    @FindBy (xpath = "//*[@class='icon-box-title text-normal']")
    public WebElement y9accountBilgileri;

    @FindBy (xpath = "//*[@id='account_email']")
    public WebElement y9accountEmail;

    @FindBy (xpath = "//button[@name='save_account_details']")
    public WebElement y9accountSaveChanges;

}
