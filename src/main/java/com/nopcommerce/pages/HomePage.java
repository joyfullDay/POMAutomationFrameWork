package com.nopcommerce.pages;

import com.nopcommerce.base.BasePage;
import com.nopcommerce.util.ElementUtil;
import org.openqa.selenium.*;

public class HomePage extends BasePage {
    WebDriver driver;
    ElementUtil elementUtil ;
    //1. Capture elements on the page by its locator - Object Repository
/*    @FindBy(xpath = "//img[@alt='nopcommerce demo store']")
    WebElement logo;
    WebElement logo;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(how = How.LINK_TEXT,using = "Login")
    WebElement LoginLink;

    public HomePage (){
        PageFactory.initElements(driver,this);

    }
 */
    private By logo = By.xpath("//img[@alt='nopCommerce demo store']");
    private By registerLink = By .linkText("Register");
    private By loginLink = By.linkText("Log in");
    private By wishlistLink = By.linkText("Wishlist");
    private By shoppingCart = By.linkText("Shopping cart");
    private By searchField = By.id("small-searchterms");
    private By searchBtn = By.xpath("//*[@id='small-search-box-form']/button");
    private By myAccountLink = By.linkText("");
    private By logoutLink = By.linkText("Log out");

    //constructor:

    public HomePage( WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    // methods that perform actions on the elements:

    public boolean verifyLogo(){
        //return  driver.findElement(logo).isDisplayed();
        return elementUtil.doIsDisplayed(logo);

    }
    public String getPageTitle(){
        return driver.getTitle();
    }



    public boolean verifyRegisterLink(){
       return driver.findElement(registerLink).isDisplayed();
    }
    public RegisterPage goToRegisterPage() {
        driver.findElement(registerLink).click();
        return new RegisterPage(driver);
    }


    public boolean verifyLoginLink() {
       return driver.findElement(loginLink).isDisplayed();
    }
    public LoginPage goToLoginPage(){
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }
    public boolean verifyMyAccountLink(){
        return driver.findElement(myAccountLink).isDisplayed();
    }
    public  boolean verifyLogoutLink(){
        return driver.findElement(logoutLink).isDisplayed();
    }
    public SearchPage doSearch(String keyword){
        elementUtil.doSendKeys(searchField,keyword);
        elementUtil.doClick(searchBtn);
        return new SearchPage(driver);
    }
}
