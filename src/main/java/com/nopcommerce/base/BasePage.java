package com.nopcommerce.base;

import com.nopcommerce.util.OptionsManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
   // public WebDriver driver;
    public Properties prop;
    public static String highlight;
    public  static ThreadLocal< WebDriver > tlDriver = new ThreadLocal<WebDriver>();
    private OptionsManager optionsManager;


    public WebDriver init_driver(String browser) {
      highlight =   prop.getProperty("highlight");
        optionsManager = new OptionsManager(prop);


        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
           // driver = new ChromeDriver();
            tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
           // driver = new ChromeDriver();
            tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));

        }
        
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getDriver();

    }
    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }

    public Properties init_prop() {
        prop = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("./src/main/java/com/nopcommerce/config/config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return prop;

    }

    public String getScreenshot() {
        File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";

        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}