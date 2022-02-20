package com.nopcommerce.tests;

import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import com.nopcommerce.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @Test(priority = 1)
    public void validatePageTitleTest(){
       Assert.assertEquals(homePage.getPageTitle()," demo store");
    }
    @Test(priority = 2)
    public void verifyLogoTest(){
        Assert.assertTrue(homePage.verifyLogo());
    }
    @Test(priority = 3)
    public void verifyRegisterLinkTest(){
        Assert.assertTrue(homePage.verifyRegisterLink());
    }
    @Test(priority = 4)
    public void verifyLoginLinkTest(){
        Assert.assertTrue(homePage.verifyLoginLink());
    }
}
