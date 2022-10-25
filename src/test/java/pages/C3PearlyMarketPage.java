package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class C3PearlyMarketPage {
    public C3PearlyMarketPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//input[@id='show_on_store']")
    public WebElement c3ShowOnStore;

    @FindBy(xpath ="//input[@id='maximum_amount']")
    public WebElement c3MaxSpend;

    @FindBy(xpath ="//input[@id='minimum_amount']")
    public WebElement c3MinSpend;

    @FindBy(xpath = "//input[@id='individual_use']")
    public WebElement c3IndividualUse;

    @FindBy(xpath = "//input[@id='exclude_sale_items']")
    public WebElement c3ExcludeSale;

    @FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
    public WebElement c3ExcludeProducts;

    @FindBy(xpath = "(//input[@class='select2-search__field'])[4]")
    public WebElement c3ExcludeCategories;

    @FindBy(xpath = "//li[@class='select2-selection__choice']")
    public WebElement c3Ring;

    @FindBy(xpath = "//*[text()='Coupon Successfully Published.']")
    public WebElement textMessage;


    @FindBy(xpath = "(//span[@class='text'])[6]")
    public WebElement c3Coupons;

    @FindBy(xpath = "(//span[@class='wcfmfa fa-gift'])[3]")
    public WebElement c3AddNews;
    //span[@class='wcfm_sub_menu_items wcfm_sub_menu_items_coupon_manage moz_class']//a

    @FindBy(xpath = "//div[@id='coupons_manage_limit']")
    public WebElement c3Limit;

    @FindBy(xpath = "//input[@id='title']")
    public WebElement c3CouponCode;

    @FindBy(xpath = "//input[@id='usage_limit']")
    public WebElement c3LimitCoupon;

    @FindBy(xpath = "//input[@id='limit_usage_to_x_items']")
    public WebElement c3LimitItems;

    @FindBy(xpath = "//input[@id='usage_limit_per_user']")
    public WebElement c3LimitUser;

    @FindBy(xpath = "//input[@id='wcfm_coupon_manager_submit_button']")
    public WebElement c3Submit;

    @FindBy(xpath = "//*[text()='Coupon Successfully Published.']")
    public WebElement c3SuccesMessage;

    @FindBy(xpath = "(//tbody//a[1])[1]")
    public WebElement c3CouponCodeFirst;

    @FindBy(xpath = "//tr[1]//td[4]")
    public WebElement c3UsageLimit;



}
