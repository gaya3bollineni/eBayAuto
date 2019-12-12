package com.interview.eBay.pages;

import com.interview.eBay.Config.ScrollElement;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {
    AndroidDriver driver;
    ScrollElement scrollElement;
    Logger logger = Logger.getLogger(WelcomePage.class);
    public WelcomePage(AndroidDriver ldriver)
    {
        this.driver=ldriver;
    }

    @AndroidFindBy(id = "com.ebay.mobile:id/button_sign_in")
    public WebElement SignInWelcomePage;

    @AndroidFindBy(id="com.ebay.mobile:id/textview_deals")
    public  WebElement FeaturedDeals;
    
    @AndroidFindBy(id="com.ebay.mobile:id/ebay")
    public WebElement ebaytext;


    public void waitForAppToLoadLogo()
    {
            logger.info("Waiting for App to load");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(FeaturedDeals));
        try {
        	 
        	 wait.until(ExpectedConditions.textToBePresentInElement(ebaytext,"ebay"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
       Assert.assertEquals(ebaytext,"ebay");
        logger.info("App to loaded successfully");

    }

    public LoginPage ClickOnSignIn()
    {
        logger.info("Click on Sign in button");
        try {
        	 WebDriverWait wait = new WebDriverWait(driver, 30);
            SignInWelcomePage.click();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("Clicked on Sign in button");
        return new LoginPage(driver);
    }


}
