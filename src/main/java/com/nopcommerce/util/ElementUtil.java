package com.nopcommerce.util;
import com.nopcommerce.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementUtil {
    private WebDriver driver;
    private JavaScriptUtil javaScriptUtil;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
        javaScriptUtil = new JavaScriptUtil(this.driver);
    }

    public WebElement getElement(By locator) {
        WebElement element = driver.findElement(locator);
        if (BasePage.highlight.equalsIgnoreCase("true")) {
            javaScriptUtil.flash(element);
        }
        return element;
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);

    }

    public void doClick(By locator) {
        getElement(locator).click();
    }



    public void doSendKeys(By locator, String value) {
        getElement(locator).sendKeys(value);
    }

    public boolean doIsDisplayed(By locator) {
        return getElement(locator).isDisplayed();
    }

    public String doGetText(By locator) {
        return getElement(locator).getText();
    }

    public void waitFor(long milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String randomString(int length) {
        String abc = "0123456789abcdefghijklmnopqrstuvwxyz";
        SecureRandom sr = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(abc.charAt(sr.nextInt(abc.length())));
        }
        return sb.toString();
    }

    public List<WebElement> getAllDropdownOptions(By locator) {
        Select select = new Select(getElement(locator));
        List<WebElement> options = select.getOptions();
        return options;


    }

    public boolean compareDropdownOptions(By locator, String[] expected) {
        System.out.println(Arrays.deepToString(expected)+ " -- this is the array of expected CONSTANT");
        List<WebElement> options = getAllDropdownOptions(locator);
        int i = 0;
        for (WebElement opt : options) {
            if (!opt.getText().equals(expected[i])) {
                return false;
            }
             System.out.println(opt.getText()+ " --this is web element option");
            System.out.println(expected[i]+" --this is expected constant array index value");
           i = i + 1;

        }
        return true;

    }

    public void convertDropDownOptionsToArray(By locator){
        List<String> dropDowns = new ArrayList<>();
        List<WebElement> options =getAllDropdownOptions(locator);
        int i=0;
        for (WebElement e : options){
            System.out.println(e.getText()+" --this is from elementutil class");
        dropDowns.add(e.getText());
        i=i+1;
        }
        System.out.println(dropDowns + " This is from elementUtil class");
    }

    }

