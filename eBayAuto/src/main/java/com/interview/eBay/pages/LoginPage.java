package com.interview.eBay.pages;

import com.interview.eBay.Config.ExcelDataProvider;
import com.interview.eBay.Config.ScrollElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static com.interview.eBay.Config.DriverManager.prop;

public class LoginPage {

    AndroidDriver driver;
    ExcelDataProvider s;
    Logger logger = Logger.getLogger(WelcomePage.class);
    WelcomePage pfele = PageFactory.initElements(driver, WelcomePage.class);
    WebDriverWait wait = new WebDriverWait(driver, 30);
   

    public  LoginPage(AndroidDriver driver)
    {
        this.driver=driver;
    }

    @AndroidFindBy(id="com.ebay.mobile:id/edit_text_username")
    private WebElement username;

    @AndroidFindBy(id="com.ebay.mobile:id/edit_text_password")
    private WebElement password;

    @AndroidFindBy(id="com.ebay.mobile:id/button_sign_in")
    private WebElement SignInButton;
    
    @AndroidFindBy(className = "username")
    public WebElement userid;

    public AddProductToCart LoginInApp() throws Exception
    {
        ScrollElement.swipeHorizontal(driver, 10.0, 10.0, 10.0);
        logger.info("In Sign in Frame");
        driver.hideKeyboard();
        logger.info("Entering Username");
        String v=s.getCellData(0,1,1);
        username.sendKeys(v);
        logger.info("Entering password");
        String t=s.getCellData(0,1,1);
        password.sendKeys(t);
        SignInButton.click();
        try {
        		
        	wait.until(ExpectedConditions.textToBePresentInElement(pfele.ebaytext,"ebay"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_DOWN);
        logger.info("Keypad down pressed");
        driver.pressKeyCode(AndroidKeyCode.ENTER);
        logger.info("Clicked Enter");
        logger.info("Signed succesfully in app");
        try {
        	wait.until(ExpectedConditions.textToBePresentInElement(userid,"Gayathri"));
        	Assert.assertEquals(userid,"Gayathri");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return new AddProductToCart(driver);
    }
}
