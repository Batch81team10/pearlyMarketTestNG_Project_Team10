package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class C4PearlyMarketPage {
    public C4PearlyMarketPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signIn;

    @FindBy(xpath = "(//*[@id='username'])[1]")
    public WebElement username;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@value='Sign In']")
    public WebElement signIn2;
    @FindBy(xpath ="(//*[@href='?add-to-cart=13861'])[1]")
    public WebElement atToCardButton;

    @FindBy(xpath ="(//*[@class='w-icon-cart'])[1]")
    public WebElement CardButton;

    @FindBy(xpath="//*[@class='button checkout wc-forward']")
    public WebElement CheckOutButton;

    @FindBy(xpath = "//*[@id='billing_first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id='place_order']")
    public WebElement placeOrderbttn;

    @FindBy(xpath = "//*[text()='Thank you. Your order has been received.']")
    public WebElement orderReceived;
    @FindBy(xpath = "//*[@href='?add-to-cart=15242']")
    public WebElement yastikAddToCart;

    @FindBy(xpath = "(//*[@class='banner-item elementor-repeater-item-561a3f7 item-inline  btn btn-solid btn-lg btn-rounded btn-primary btn-icon-right'])[2]")
    public WebElement shopNow;

    @FindBy(xpath = "(//*[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail'])[4]")
    public WebElement yastik;

    @FindBy(xpath = "//*[@id='ship-to-different-address-checkbox']" )
    public  WebElement diffAddress;

    @FindBy(xpath = "//*[@id='shipping_first_name']" )
    public  WebElement fistNameShipping;

    @FindBy(xpath ="(//*[@href='https://pearlymarket.com/my-account-2/'])[1]" )
    public WebElement myAccount;

    @FindBy(xpath="//*[@href='https://pearlymarket.com/store-manager/']")
    public WebElement storeManager;

    @FindBy(xpath = "(//*[@class='text'])[5]")
    public WebElement orders;

    @FindBy(xpath = "(//*[@class='text'])[18]")
    public WebElement addNew;

    @FindBy(xpath = "//*[@class='wcfm_order_add_new_customer_box']")
    public WebElement addNewCustomer;

    @FindBy(xpath = "(//*[@class='wcfm_popup_input'])[1]")
    public WebElement emailCustomer;

    @FindBy(xpath = "(//*[text()='Add to cart'])[4]")
    public WebElement airFrayer;

    @FindBy(xpath = "//*[@href='?add-to-cart=14080']")
    public WebElement frayerAddToCart;

    @FindBy(xpath="(//*[@class='wcfmfa fa-check-circle text_tip'])[1]")
    public WebElement tikOrder;

    @FindBy(xpath="(//*[@class='wcfmmp_order_refund_request wcfm-action-icon'])[1]")
    public WebElement refundRequest;

    @FindBy(xpath="(//*[@id='wcfm_refund_request'])")
    public WebElement partialRefund;

    @FindBy(xpath = "//*[@id='wcfm_refund_requests_submit_button']")
    public WebElement submitRequest;

    @FindBy(xpath = "//*[@href='https://pearlymarket.com/store-manager/refund-requests/']")
    public WebElement refundButton;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> refunList;

    @FindBy(xpath = "//*[@class='wcfm-message wcfm-error']")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[@class='login logout inline-type']")
    public WebElement logOut;

    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout is-active']")
    public WebElement logOut2;


}
