package com.nopcommerce.pages;

import com.nopcommerce.base.BasePage;
import com.nopcommerce.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    private By loginPageName = By.xpath("//div[@class='page-title']/h1");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By rememberMeCheckbox = By.id("RememberMe");
    private By loginBtn = By.xpath("//button[text()='Register']");
    private By registerBtn = By.xpath("//button[text()='Register']");
    private By myAccountLink = By.linkText("My account");
    private By logoutLink = By.linkText("Log out");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(driver);

    }
    public String getLoginPageName(){
       //return driver.findElement(loginPageName).getText();
        return elementUtil.doGetText(loginPageName);
    }

    //page chaining : if an action takes you to a new page
    //return type of the action must be  the object of loading page
    public HomePage doLogin(String userID, String password){
        elementUtil.doSendKeys(emailField, userID);
        elementUtil.doSendKeys(passwordField,password);
        elementUtil.doClick(loginBtn);
      //  driver.findElement(emailField).sendKeys(userID);
      //  driver.findElement(passwordField).sendKeys(password);
     //   driver.findElement(loginBtn).click();
        return new HomePage(driver);

    }
    public boolean verifyRegisterButtonStatus(){
       // return driver.findElement(registerBtn).isDisplayed();
        return elementUtil.doIsDisplayed(registerBtn);
    }

}
