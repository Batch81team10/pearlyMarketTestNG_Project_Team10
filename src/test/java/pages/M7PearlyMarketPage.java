package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;
import utilities.Driver;

public class M7PearlyMarketPage {

    public M7PearlyMarketPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signIn;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@value='Sign In']")
    public WebElement signIn2;

    @FindBy(xpath = "//*[text()='MY ACCOUNT']")
    public WebElement myAccountYazisi;

    @FindBy(xpath = "(//*[@href='https://pearlymarket.com/my-account-2/'])[1]")
    public WebElement myAccount;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement s8signOut;

    @FindBy(xpath = "//*[@id='menu-item-1079']")
    public WebElement m7MyAccount;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement m7storeManager;

    @FindBy(xpath = "(//*[@class='text'])[7]")
    public WebElement m7Customers;

    @FindBy(xpath = "(//*[@class='text'])[7]")
    public static WebElement m7CustomersYazisi;
    @FindBy(xpath = "//a[@class='dt-button buttons-pdf buttons-html5']")
    public WebElement m7PdfButton;
    @FindBy(xpath = "//a[@class='dt-button buttons-excel buttons-html5']")
    public WebElement m7ExcelButton;
    @FindBy(xpath = "//a[@class='dt-button buttons-csv buttons-html5']")
    public WebElement m7CsvButton;
    @FindBy(xpath = "//span[@class='wcfm_sub_menu_items wcfm_sub_menu_items_customer_manage moz_class']")
    public WebElement m7AddNewButonu;
    @FindBy(xpath = "//input[@id='user_name']")
    public WebElement m7userName;
    @FindBy(xpath = "//input[@id='wcfm_customer_submit_button']")
    public WebElement m7SubmitButonu;
    @FindBy(xpath = "//*[@class='wcfm_menu_items wcfm_menu_wcfm-reviews']")
    public WebElement m7Reviews;
    @FindBy(xpath = "//*[@id='add_new_product_dashboard']")
    public WebElement m7productReviews;
    @FindBy(xpath = "//div[@class='wcfmmp-rating']")
    public WebElement m7Rating;
    @FindBy(xpath = "//*[text()='15 October 2022 02:01']")
    public WebElement m7Dated;
    @FindBy(xpath = "//*[@class='wcfmfa fa-power-off']")
    public WebElement m7Logout;
    @FindBy(xpath = "//*[@class='sorting_asc']")
    public WebElement m7Name;
    @FindBy(xpath = "(//*[text()='Email'])[1]")
    public WebElement m7Email;
    @FindBy(xpath = "(//*[text()='Username'])[1]")
    public WebElement m7Username;
    @FindBy(xpath = "(//*[text()='Location'])[1]")
    public WebElement m7Location;
    @FindBy(xpath = "(//*[text()='Orders'])[1]")
    public WebElement m7Orders;
    @FindBy(xpath = "(//*[text()='Money Spent'])[1]")
    public WebElement m7MoneySpent;
    @FindBy(xpath = "(//*[text()='Last Order'])[1]")
    public WebElement m7LastOrder;

}
