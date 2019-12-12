package com.interview.eBay.pages;


import com.interview.eBay.Config.ExcelDataProvider;
import com.interview.eBay.Config.ScreenShotUtil;
import com.interview.eBay.Config.ScrollElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;


import static com.interview.eBay.Config.DriverManager.prop;

import java.io.IOException;

public class AddProductToCart {
    AndroidDriver driver;
    AppiumDriver dr;
    ExcelDataProvider s;
    WebDriverWait wait= new WebDriverWait(driver,20);
    Logger logger = Logger.getLogger(AddProductToCart.class);
    public AddProductToCart(AndroidDriver ldriver)
    {
        this.driver=ldriver;
    }

    @AndroidFindBy(id = "com.ebay.mobile:id/search_box")
    public WebElement SearchBox;

    @AndroidFindBy(id="com.ebay.mobile:id/search_src_text")
    public WebElement SearchInText;

    @AndroidFindBy(xpath = ".//*[@text='65 inch TV']")
    private WebElement Product;

    @AndroidFindBy(id="com.ebay.mobile:id/button_add_to_cart")
    public WebElement AddToCartButton;

    @AndroidFindBy(id="com.ebay.mobile:id/fragmentContainer")
    public MobileElement ProductContainer;

    @AndroidFindBy(id="com.ebay.mobile:id/top_scrollview_content")
    public MobileElement ScrollinProductPage;

    String str="ADD TO CART";
    String Item="65 inch TV";


    public void SearchBox()
    {
        logger.info("Click button or tap on screen");
        try {
            wait.until(ExpectedConditions.visibilityOf(SearchBox));
            SearchBox.click();
            
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        logger.info("Search button clicked");
    }

    public void SearchItemFromSearchBox()
    {
        logger.info("In search bar searching the Item for purchase");
        String v= s.getCellData(0,3,1);
        try {
            WebDriverWait wait= new WebDriverWait(driver,20);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_PAGE_DOWN);
        driver.pressKeyCode(AndroidKeyCode.ENTER);
    }

    public boolean SelectProduct() throws Exception
    {
        logger.info("In select product");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MobileElement ProductFromList=ScrollElement.scrollToExactElement(ProductContainer,Item);
        driver.rotate(ScreenOrientation.LANDSCAPE);
        ScrollElement.swipeVertical(dr,10.0,10.0,10.0);
        ProductFromList.click();
        logger.info("In product buy page");
        MobileElement AddToCartID=ScrollElement.ScrollToElement(ScrollinProductPage,str);
        AddToCartID.click();
        Assert.assertEquals(Product, Item);
        logger.info("Product Added to cart succesfully");
        return true;

    }



}
