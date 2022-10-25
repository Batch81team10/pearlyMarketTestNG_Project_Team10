package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class APearlyMarketPage {
    public APearlyMarketPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='text'])[6]")
    public WebElement acoupons;

    //add new kismi link hali
    // @FindBy(linkText = "https://pearlymarket.com/store-manager/coupons-manage/")
    //public WebElement addNewLink;

    @FindBy(xpath = "//span[@class='wcfm_sub_menu_items wcfm_sub_menu_items_coupon_manage moz_class']")
    public WebElement aaddNewLink;
    //ad new sayfadan tiklanan hali
    @FindBy(xpath = "(//span[@class='text'])[18]")
    public WebElement addNew;

    @FindBy(xpath = "//input[@id='title']")
    public WebElement acode;

    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement adescription;

    @FindBy(xpath = "//select[@id='discount_type']")
    public WebElement adiscountType;

    @FindBy(xpath = "//input[@id='coupon_amount']")
    public WebElement aamount;


    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    public WebElement afreeShipping;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement ashow;

    @FindBy(xpath = "//input[@id='expiry_date']")
    public WebElement adate;

    @FindBy(name = "submit-data")
    public WebElement asubmit;

    @FindBy(xpath = "(//a[@class='ui-state-default'])[29]")
    public WebElement adayNumber;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    public WebElement aYearNumber;

    @FindBy(xpath="//option[@value='2020']")
    public WebElement aSelectYEar;






}
