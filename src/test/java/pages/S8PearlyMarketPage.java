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

    @FindBy(xpath = "//*[@class='cart-name']")
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

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement sepettekiIlkUrunFiyatYazisi;

    @FindBy(xpath = "(//*[@class='input-text qty text'])[1]")
    public WebElement sepettekiIlkUrunAdetYazisi;

    @FindBy(xpath = "(//*[@class='input-text qty text'])[1]")
    public WebElement sepettekiIlkUrunToplamFiyatYazisi;


    @FindBy(xpath = "//*[text()='View cart']")
    public WebElement viewCart;


}
