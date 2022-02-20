package com.nopcommerce.tests;

import com.nopcommerce.base.BasePage;
import com.nopcommerce.base.BaseTest;
import com.nopcommerce.pages.SearchPage;
import com.nopcommerce.util.Constants;
import com.nopcommerce.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchPageTest extends BaseTest {

    @BeforeMethod
    public void searchPageSetup() {
        searchPage = homePage.doSearch(prop.getProperty("searchItem"));
    }

    @Test(priority = 1)
    public void verifySearchPageNameTest() {
        Assert.assertEquals(searchPage.getSearchPageName(), Constants.SEARCHPAGE_NAME);
    }

    @Test(priority = 2)
    public void verifyManufactureDropdownListTest() throws  Exception{

    Assert.assertTrue(searchPage.verifyManufactureDropdownList());
        searchPage.convertDropDownOptionsToArray();
    }

    @Test(priority = 3)
    public void validateCategoryListTest() {
        Assert.assertEquals(searchPage.getCategoryItem(), Constants.actualCategoryList());
    }

}










