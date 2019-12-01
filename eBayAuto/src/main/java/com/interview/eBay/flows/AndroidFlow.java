package com.interview.eBay.flows;

import com.interview.eBay.Config.CommonAppiumTest;
import com.interview.eBay.Config.DeviceInterface;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import com.interview.eBay.pages.LoginPage;
import com.interview.eBay.pages.WelcomePage;
import java.io.IOException;

public class AndroidFlow extends CommonAppiumTest {


    public AndroidFlow(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


}
