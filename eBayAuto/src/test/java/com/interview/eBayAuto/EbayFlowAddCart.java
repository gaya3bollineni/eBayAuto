package com.interview.eBayAuto;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.aventstack.extentreports.ExtentTest;
import com.interview.eBay.pages.AddProductToCart;
import com.interview.eBay.pages.LoginPage;
import com.interview.eBay.Config.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.interview.eBay.pages.WelcomePage;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class EbayFlowAddCart extends BaseClass{

    DriverManager driverManager;
    WelcomePage welcomepage;
    LoginPage loginPage;
    AddProductToCart addProductToCart;
    AndroidDriver driver;
    
    boolean status=true;
    

    @Test
    public void SelectItems() throws Exception
    {
        test=extent.createTest("Add product Test","Login and add product you cart");
        driver=DriverManager.getDriver();
        WelcomePage wep=PageFactory.initElements(driver,WelcomePage.class);
        test.info("Opening app on device");
        test.info("Waiting for app to load device");
        wep.waitForAppToLoadLogo();
        test.info("Clicking on Sign in Button");
        wep.ClickOnSignIn();
        LoginPage lp=PageFactory.initElements(driver,LoginPage.class);
        test.info("Performing login action");
        lp.LoginInApp();
        test.info("Login succesfull");
        AddProductToCart apc=PageFactory.initElements(driver,AddProductToCart.class);
        test.info("Clicking on Search box for product search");
        apc.SearchBox();
        test.info("Searched Item in search box");
        apc.SearchItemFromSearchBox();
        test.info("Add product to cart");
        apc.SelectProduct();
        test.info("Product Added in Cart sucessfully");
    }

}
