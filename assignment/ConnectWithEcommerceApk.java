package com.assignment;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

/**
 * Unit test for simple App.
 */
public class ConnectWithEcommerceApk{
    
	public AndroidDriver driver;
 
	public AppiumDriverLocalService service;

	@Test
	public void Test() throws MalformedURLException, InterruptedException {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("shrey");
		options.setApp("D:\\Automation FIles\\Appium Apk Files\\General-Store.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		
		/*
		 * dropown
		 */
		WebElement dropdown=driver.findElement(By.id("android:id/text1"));
		dropdown.click();
		Thread.sleep(2000);
		
		/*
		 * scrolldown
		 */
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		Thread.sleep(2000);
		
		/*
		 * name field
		 */
		driver.findElement(By.className("android.widget.EditText")).sendKeys("shrey");
		Thread.sleep(2000);
		
		/*
		 * checkbox
		 */
		WebElement checkbox=driver.findElement(By.id("com.androidsample.generalstore:id/radioMale"));
		checkbox.click();
		Thread.sleep(2000);
		
		/*
		 * click on button
		 */
		driver.findElement(By.className("android.widget.Button")).click();
		Thread.sleep(2000);
		
		/*
		 * home page
		 */
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		int productcount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<productcount;i++)
		{
			String productname=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			Thread.sleep(2000);
			if(productname.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(2000);
	
		
		
		driver.quit();

	}
}

