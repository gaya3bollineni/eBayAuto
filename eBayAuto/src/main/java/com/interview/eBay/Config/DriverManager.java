package com.interview.eBay.Config;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

public class DriverManager {


    public static AndroidDriver driver;
    public static Properties prop = new Properties();
    static InputStream input = null;
    static Logger logger = Logger.getLogger(DriverManager.class);


    public static AndroidDriver getDriver() throws IOException {
        input = new FileInputStream("property/config.properties");
        prop.load(input);
        if (prop.getProperty("platform").equalsIgnoreCase("android")) {
            logger.info("Device property found for Android ");
            ADB adbdriver=new ADB(prop.getProperty("DeviceID"));
            boolean result=adbdriver.isAppAlradyInstalled(prop.getProperty("Package"));
            if(result==true){
                logger.info("App is alredy installed clearing content");
                adbdriver.clearAppsData(prop.getProperty("Package"));
            }
            else{
                adbdriver.installApp(System.getProperty("user.dir")+ prop.getProperty("AppPath"),prop.getProperty("Package"));
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("App Installed Succesfully");
            }
            androidSetup();

        } 
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver;
    }

    public static AndroidDriver androidSetup() throws MalformedURLException {
        Reporter.log("Setting Android Driver");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", prop.getProperty("DeviceID"));
        caps.setCapability("app", System.getProperty("user.dir") + prop.getProperty("AppPath"));
        caps.setCapability("package", prop.getProperty("Package"));
        caps.setCapability("appActivity", prop.getProperty("Activity"));
        caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, prop.getProperty("Activity"));
        caps.setCapability("newCommandTimeout", 10000);
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Reporter.log("Android Driver set succesfully");
        return driver;
    }
    


}
