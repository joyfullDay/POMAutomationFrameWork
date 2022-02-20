package com.nopcommerce.tests;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteTest {
    @Test
    public void chromeTest() throws MalformedURLException,InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome");
        URL url = new URL("https://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url,dc);
        driver.get("https://demo.nopcommerce.com/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
