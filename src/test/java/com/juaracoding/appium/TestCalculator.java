package com.juaracoding.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.appium.pages.Calculator;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestCalculator {

    private static AndroidDriver<MobileElement> driver;
    private Calculator calculator;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Galaxy A50");
        capabilities.setCapability("udid", "RR8M40MPJBB");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @BeforeMethod
    public void pageObject() {
        calculator = new Calculator(driver);
    }

    @Test
    public void testAdd() {
        calculator.calcsubtraction();
        System.out.println("Result = "+calculator.getTxtResult());
        Assert.assertEquals(calculator.getTxtResult(), "2");
    }

    @Test
    public void testMultiplication() {
        calculator.calcMultiplication();
        System.out.println("Result = "+calculator.getTxtResult());
        Assert.assertEquals(calculator.getTxtResult(), "30");
    }

    @Test
    public void testdivide() {
        calculator.calcdivide();
        System.out.println("Result = "+calculator.getTxtResult());
        Assert.assertEquals(calculator.getTxtResult(), "2");
    }


    @AfterClass
    public void closeApp() {
        driver.quit();
    }

}
