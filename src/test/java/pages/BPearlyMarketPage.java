package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class BPearlyMarketPage {


    public BPearlyMarketPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement b2storeManager;


    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement b2productsButton;

    @FindBy(xpath = "//select[@id='product_type']")
    public WebElement b2productTypeTable;

    @FindBy(xpath = ("//tbody"))
    public WebElement b2urunListesi;

    @FindBy(xpath = ("(//th[@class='sorting_disabled'])[3]"))
    public WebElement b2statusText;

    @FindBy(xpath ="(//th[@class='sorting_disabled'])[4]")
    public WebElement b2stockText;

    @FindBy(xpath ="(//th[@class='sorting'])[2]")
    public WebElement b2priceText;

    @FindBy(xpath ="(//th[@class='sorting'])[4]")
    public WebElement b2dateText;

    @FindBy(xpath ="//a[@id='add_new_product_dashboard']")
    public WebElement b2addNewButton;

    @FindBy(xpath ="//input[@id='is_virtual']")
    public WebElement b2virtualButton;

    @FindBy(xpath ="//input[@id='is_downloadable']")
    public WebElement b2downloadableButton;

    @FindBy(xpath ="//input[@id='pro_title']")
    public WebElement b2productTitleBox;

    @FindBy(xpath = "//input[@id='regular_price']")
    public WebElement b2regularPriceBox;

    @FindBy(xpath ="//input[@id='sale_price']")
    public WebElement b2salePriceBox;

    @FindBy(xpath ="//img[@id='featured_img_display']")
    public WebElement b2featuredImg;

    @FindBy(xpath ="//button[contains(@id,'__wp-uploader-id')]")
    public WebElement b2FeaturedImageSelectFileButton;

    @FindBy(xpath = "(//button[@class='button media-button button-primary button-large media-button-select'])[1]")
    public WebElement b2FeaturedImageSelectButton;

    @FindBy(xpath ="//img[@id='gallery_img_gimage_0_display']")
    public WebElement b2galleryImg;

    @FindBy(xpath ="(//button[@class='browser button button-hero'])[2]")
    public WebElement b2GalleryImageSelectFileButton;

    @FindBy(xpath ="(//button[@class='button media-button button-primary button-large media-button-select'])[2]")
    public WebElement b2GalleryImageAddToGalleryButton;

    @FindBy(xpath ="//ul[@id='product_cats_checklist']")
    public WebElement b2categoriesTable;

    @FindBy(xpath ="//div[contains(@class,'product')]//ul//li//span[2]")
    public List<WebElement> b2CategoriesList;

    @FindBy(xpath ="//div[contains(@class,'product')]//ul//li//input[@name='product_cats[]']")
    public List<WebElement> b2ProductCategoriesClickButtonList;

    @FindBy(xpath ="(//li//input)[1]")
    public WebElement b2accessoriesBox;

    @FindBy(xpath ="//iframe[@id='excerpt_ifr']")
    public WebElement b2shortDescriptionIframe;

    @FindBy(xpath ="(//body[@id='tinymce'])[1]")
    public WebElement b2shortDescriptionTextBox;

    @FindBy(xpath ="//button[@id='insert-media-button']")
    public WebElement b2ShortDescriptionAddMediaButton;

    @FindBy(xpath ="(//span[@class='media-modal-icon'])[1]")
    public WebElement b2ShortDescriptionAddMediaCloseButton;

    @FindBy(xpath = "//iframe[@id='description_ifr']")
    public WebElement b2DescriptionIFrame;

    @FindBy(xpath ="//body[@data-id='description']")
    public WebElement b2descriptionTextBox;

    @FindBy(xpath ="(//span[@class='wp-media-buttons-icon'])[2]")
    public WebElement b2descriptionAddMediaButton;

    @FindBy(xpath ="(//span[@class='media-modal-icon'])[2]")
    public WebElement b2DescriptionAddMediaCloseButton;

    @FindBy(xpath ="//input[@id='wcfm_products_simple_submit_button']")
    public WebElement b2submitButton;

    @FindBy(xpath ="//span[@class='product-status product-status-publish']")
    public WebElement b2UrunEklendiText;

    @FindBy(xpath = "(//*[contains(text(), 'Please insert Product Title before submit.')])[1]")
    public WebElement b2ButunHataYazilari;



}
