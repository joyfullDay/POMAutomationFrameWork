package com.nopcommerce.base;

import com.nopcommerce.pages.HomePage;
import com.nopcommerce.pages.LoginPage;
import com.nopcommerce.pages.RegisterPage;
import com.nopcommerce.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public BasePage basePage;
    public Properties prop;
    public HomePage homePage;
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public SearchPage searchPage;
//@BeforeTest
    @BeforeMethod
    public void setup(){
        basePage = new BasePage();
        prop = basePage.init_prop();
        String browserType = prop.getProperty("browser");
        driver = basePage.init_driver(browserType);
        homePage = new HomePage(driver);
        driver.get(prop.getProperty("url"));

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
