package com.interview.eBayAuto;

import io.appium.java_client.android.AndroidDriver;
import com.interview.eBay.Config.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class StartApplication {



	static ExcelDataProvider s;

	private static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "device");
		capabilities.setCapability("platformVersion", "5.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.ebay.mobile");
		capabilities.setCapability("appActivity", "com.ebay.mobile.Activities.MainActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String v= s.getCellData(0,3,1);
		driver.findElement(By.id("com.ebay.mobile:id/search_box")).sendKeys(v);
		Thread.sleep(10000);


	}



}