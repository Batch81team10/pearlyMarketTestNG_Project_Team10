package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class S8PearlyMarketPage {
    public S8PearlyMarketPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(text-uppercase text-center mb-0")
    public WebElement s8orders;

    @FindBy(xpath = "//*[text()='Dashboard']")
    public WebElement s8dashboard;

    @FindBy(xpath = "//*[@href='https://pearlymarket.com/my-account-2/followings/']")
    public WebElement s8followings;

    @FindBy(xpath = "//*[@class='btn btn-dark btn-rounded btn-icon-right continue-shopping mb-4 mt-6']")
    public WebElement s8goToShop;

    @FindBy(xpath = "//*[text()='Shop']")
    public WebElement s8shopYazisi;

    @FindBy(xpath = "(//*[@href='https://pearlymarket.com/my-account-2/orders/'])[3]")
    public WebElement s8sutunOrder;

    @FindBy(xpath = "//*[@class='product-media']")
    public List<WebElement> s8shopList;

    @FindBy(xpath = "//*[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart']")
    public WebElement s8sepetSimge;

    @FindBy(xpath = "(//*[@class='cart-count'])[1]")
    public WebElement s8cartCount;

    @FindBy(xpath = "(//*[text()='Cart'])[1]")
    public WebElement s8cart;

    @FindBy(xpath = "//*[@class='button checkout wc-forward']")
    public WebElement s8checkOut;

    @FindBy(xpath = "(//*[text()='Checkout'])[2]")
    public WebElement s8checkOutYazisi;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement s8signOut;

    @FindBy(xpath = "//*[@id='billing_first_name']")
    public WebElement s8firsName;

    @FindBy(xpath = "//*[@id='select2-billing_country-container']")
    public WebElement s8countryMenu;

    @FindBy(xpath = "//*[@id='billing_address_1']")
    public WebElement s8streetAdr;

    @FindBy(xpath = "//*[@id='billing_postcode']")
    public WebElement s8zipcode;

    @FindBy(xpath = "//*[@value='cod']")
    public WebElement s8kapidaOde;

    @FindBy(xpath = "//*[@id='place_order']")
    public WebElement s8placeHolder;

    @FindBy(xpath = "//*[@id='place_order']")
    public WebElement s8siparisAlindiYazisi;

    @FindBy(xpath = "//*[text()='MY ACCOUNT']")
    public WebElement myAccountYazisi;

    @FindBy(xpath = "(//*[@href='https://pearlymarket.com/my-account-2/'])[1]")
    public WebElement myAccount;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement logout;

    @FindBy(xpath = "(//*[@class='product-price'])[2]")
    public WebElement sepettekiIlkUrunFiyatYazisi;

    @FindBy(xpath = "(//*[@class='product-quantity'])[2]")
    public WebElement sepettekiIlkUrunAdetYazisi;

    @FindBy(xpath = "(//*[@class='product-subtotal'])[2]")
    public WebElement sepettekiIlkUrunToplamFiyatYazisi;

    @FindBy(xpath = "//*[text()='View cart']")
    public WebElement viewCart;

    @FindBy(xpath = "(//*[text()='Home'])[1]")
    public WebElement home;

    @FindBy(xpath = "//*[@class='btn btn-rounded btn-outline btn-default btn-border-thin mb-4 ml-2 mr-2 clear-cart-button']")
    public WebElement clearCart;

    @FindBy(xpath = "(//*[@class='quantity-plus w-icon-plus'])[1]")
    public WebElement urunArtir;

    @FindBy(xpath = "(//*[@class='quantity-minus w-icon-minus'])[1]")
    public WebElement urunAzalt;

    @FindBy(xpath = "//tbody//tr//td[4]")
    public List<WebElement> miktarList;


    @FindBy(xpath = "//*[@class='product-quantity']")
    public List<WebElement> artirList;

    @FindBy(xpath = "//*[@value='Update cart']")
    public WebElement updateCart;

    @FindBy(xpath = "//*[@class='woocommerce-notices-wrapper']")
    public WebElement updatedYazisi;

    @FindBy(xpath = "//*[@name='apply_coupon']")
    public WebElement coupon;

    @FindBy(xpath = "//*[@name='apply_coupon']")
    public WebElement shoping;

    @FindBy(xpath = "(//*[@class='select2-selection__rendered'])[1]")
    public WebElement shippingBilgisi1;

    @FindBy(xpath = "(//*[@class='select2-selection__rendered'])[2]")
    public WebElement shippingBilgisi2;

    @FindBy(xpath = "//*[@data-title='Total']")
    public WebElement shippingTotalBilgisi;

    @FindBy(xpath = "//*[@class='count form-control']")
    public WebElement urunShow;

    @FindBy(xpath = "(//*[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail'])[1]")
    public WebElement shopBirinciUrun;

    @FindBy(xpath = "//*[@aria-label='Search']")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@name='add-to-cart']")
    public WebElement legoBricksAddCart;

    @FindBy(xpath = "//*[@id='quantity_6353aa1770a33']")
    public WebElement legoBricksSepetteUrunAdetKutusu;

    @FindBy(xpath = "//*[@class='btn btn-success btn-md']")
    public WebElement legoBricksUrunSepeteEklendiButon;

    @FindBy(xpath = "//*[@type='number']")
    public WebElement legoBricksUrunAdetKutusu;

    @FindBy(xpath = "//*[@class='w-icon-angle-up']")
    public WebElement legoBricksPageUp;

    @FindBy(xpath = "//*[@class='checkout-button button alt wc-forward']")
    public WebElement proceedToCheckOut;

    @FindBy(xpath = "//*[@id='payment']")
    public WebElement paymentYazisi;

    @FindBy(xpath = "(//*[@class='text-uppercase text-center mb-0'])[6]")
    public WebElement logOut;


}
