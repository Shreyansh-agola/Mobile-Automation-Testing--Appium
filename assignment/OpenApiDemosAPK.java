package com.assignment;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class OpenApiDemosAPK {
	
	AndroidDriver driver;
	AppiumDriverLocalService service;
	
	@Test
	
	public void openApiDemoApk() throws MalformedURLException, InterruptedException
	{
		UiAutomator2Options option=new UiAutomator2Options();
		option.setPlatformName("shrey");
		option.setApp("D:\\Automation FIles\\Appium Apk Files\\ApiDemos-debug.apk");
		
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		
		driver.quit();
	}

}
