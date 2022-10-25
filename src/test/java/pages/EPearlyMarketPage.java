package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EPearlyMarketPage {
    public EPearlyMarketPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Brands(markalar)

    @FindBy(xpath ="//*[@value='35']" )
    public WebElement ElegantAutoGroup;

    @FindBy(xpath ="//*[@value='41']" )
    public WebElement  GreenGrass;

    @FindBy(xpath ="(//*[@value='46'])[1]" )
    public WebElement  NodeJs;

    @FindBy(xpath ="(//*[@value='47'])[1]" )
    public WebElement NS8;

    @FindBy(xpath =" (//*[@value='50'])[1]" )
    public WebElement RED;

    @FindBy(xpath ="(//*[@value='52'])[1]" )
    public WebElement SkysuiteTech;

    @FindBy(xpath ="(//*[@value='55'])[1]" )
    public WebElement Sterling;

    //Shipping
    @FindBy (xpath = "(//*[@class='page_collapsible_content_holder'])[4]")
    public WebElement Shippingbutonu;

    @FindBy (xpath = "//*[@class='weight wcfm_title']")
    public WebElement weightButonuTitle;

    @FindBy(xpath = "(//*[@class='wcfm-text wcfm_ele simple variable booking'])[1]")
    public  WebElement weightButonu;

    @FindBy(xpath = "(//*[@class='wcfm-text wcfm_ele simple variable booking'])[2]")
    public WebElement length;

    @FindBy(xpath = "(//*[@class='wcfm-text wcfm_ele simple variable booking'])[3]")
    public WebElement Width;

    @FindBy(xpath = "(//*[@class='wcfm-text wcfm_ele simple variable booking'])[4]")
    public WebElement Heigth;

    @FindBy(xpath = "//*[@id='_wcfmmp_processing_time']")
    public WebElement ProcessingTime;

    //inventory
    @FindBy(xpath = "//*[@class='wcfmfa fa-database']")
    public WebElement inventory;

    @FindBy(xpath = "//*[@id='sku']")
    public WebElement skuButonu;

    @FindBy(xpath = "//*[@id='stock_status']")
    public WebElement stockStatus;

    @FindBy(xpath = "//*[@id='sold_individually']")
    public WebElement soldIndividually;

    @FindBy(xpath = "//input[@class='wcfm-checkbox wcfm_ele simple variable manage_stock_ele non-job_package non-resume_package non-auction non-redq_rental non-appointment non-accommodation-booking non-pw-gift-card']")
    public WebElement manageStock;

    @FindBy(xpath = "//*[@class='stock_qty wcfm_title wcfm_ele simple variable non_manage_stock_ele non-job_package non-resume_package non-auction non-redq_rental non-appointment non-accommodation-booking']")
    public WebElement stockQty;

    @FindBy(xpath = "//*[@id='stock_qty']")
    public WebElement stockQtyButonu;

    @FindBy(xpath = "//*[@class='backorders wcfm_title wcfm_ele simple variable non_manage_stock_ele non-job_package non-resume_package non-auction non-redq_rental non-appointment non-accommodation-booking']")
    public WebElement allowBackorders;

    @FindBy(xpath = "//*[@id='backorders']")
    public WebElement allowBackordersMenu;

    @FindBy(id = "wcfm_products_manage_form_attribute_head")
    public WebElement attributesButonu;

    @FindBy(id = "attributes_is_active_1")
    public WebElement colorButonu;

    @FindBy(xpath = "(//*[text()='Select all'])[1]")
    public WebElement selectAllColorButonu;

    @FindBy(xpath = "(//*[@class='fields_collapser attributes_collapser wcfmfa fa-arrow-circle-down'])[3]")
    public WebElement sizeButonu;

    @FindBy(xpath = "//*[@class='button wcfm_add_attribute_term wcfm_select_all_attributes']")
    public WebElement selectAllSizeButonu;


//pearlymarketbaska UserKeyslerin loketleri

    @FindBy (xpath = "(//*[@class='woocommerce-Input woocommerce-Input--text input-text'])[1]")
    public  WebElement usernameButonu;

    @FindBy (xpath = "(//*[@class='woocommerce-Input woocommerce-Input--text input-text'])[2]")
    public  WebElement passwordButonu;

    @FindBy(xpath = "//*[@class='woocommerce-button button woocommerce-form-login__submit']")
    public WebElement signbutonu;

    @FindBy (xpath = "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--wcfm-store-manager']")
    public  WebElement storeManagerButonu;

    @FindBy (xpath = "(//*[@class='wcfmfa fa-cube'])[1]")
    public  WebElement productButonu;

    @FindBy(xpath = "(//*[text()='Add New'])[1]")
    public WebElement addNewButonu;

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signInButonu;

    @FindBy (xpath = "//*[text()='Sign Out']")
    public WebElement myAccount;

    @FindBy(id = "pro_title")
    public WebElement productTitleButonu;

    @FindBy(id = "featured_img_display")
    public WebElement resimeklemeButonu;

    @FindBy(id="menu-item-browse")
    public WebElement mediaLibrary;

    @FindBy(xpath = "(//*[@class='attachment save-ready'])[5]")
    public WebElement tablo;

    @FindBy(xpath = "//*[@class='button media-button button-primary button-large media-button-select']")
    public WebElement selectResimEklemeButonu;
    @FindBy(id = "gallery_img_gimage_0_display")
    public WebElement resimeklemebutonu2;

    @FindBy(xpath = "(//*[@src='http://pearlymarket.com/wp-content/uploads/2022/10/Who-Am-I_-300x188.jpg'])[2]")
    public WebElement tablo2;

    @FindBy(xpath = "(//*[@class='button media-button button-primary button-large media-button-select'])[2]")
    public WebElement addToGaleryBotonu;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[17]")
    public WebElement coksatanlar;

    @FindBy(id = "wcfm_products_simple_submit_button")
    public WebElement submit;

    @FindBy(xpath = "(//tbody//td/a[2])[1]")
    public WebElement viewButonu;

    @FindBy(xpath = "(//a[@class='nav-link'])[2]")
    public WebElement speficationButonu;

    @FindBy(xpath = "//*[@class='woocommerce-product-attributes-item__value']")
    public List< WebElement> WigthVeLengthDegeri;

    @FindBy(xpath = "(//*[@class='woocommerce-product-attributes-item__label'])[1]")
    public  WebElement Wigth;

    @FindBy(xpath = "//tbody/tr//td[6][1]")
    public  WebElement inStock;
}
