package com.interview.eBay.Config;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import static java.time.Duration.ofMillis;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollElement
{
    AndroidDriver<MobileElement> driver;
    public ScrollElement(AndroidDriver<MobileElement> driver)
    {
        this.driver = driver ;
    }
    public static MobileElement scrollToExactElement(MobileElement ele,String str)
    {
        return ((AndroidElement) ele)
                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().text(\""+str+"\"));");

    }

    public static MobileElement ScrollToElement(MobileElement ele, String str)
    {
        return ((AndroidElement) ele)
                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().textContains(\""+str+"\"));");

    }
    
    public static void swipeHorizontal(AppiumDriver driver, double startPercentage, double finalPercentage, double anchorPercentage) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * finalPercentage);
        new TouchAction(driver).press(startPoint, anchor).waitAction(ofMillis(100)).moveTo(endPoint, anchor).release().perform();
    }


    public static void swipeVertical(AppiumDriver driver, double startPercentage, double finalPercentage, double anchorPercentage) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * finalPercentage);
        new TouchAction(driver).press(anchor, startPoint).waitAction(ofMillis(100)).moveTo(anchor, endPoint).release().perform();
    }
 
   

}
