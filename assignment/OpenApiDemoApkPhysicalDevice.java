package com.assignment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class OpenApiDemoApkPhysicalDevice {
	
	static AppiumDriver driver=null;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		openCalculater();
		
	}
	
	public static void openCalculater() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "Xiaomi 2201117TI");
		cap.setCapability("udid", "e1b0f00a");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "13.0");
		
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		cap.setCapability("automationName", "UiAutomator2");
		URL url=new URL("http://127.0.0.1:4723/");
		driver= new AppiumDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
