package com.interview.eBay.Config;

import io.appium.java_client.MobileElement;
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
   

}
