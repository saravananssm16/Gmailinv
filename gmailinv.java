package com.zogo.listener;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class gmailinv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "Browser FilePath");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// enter the email address
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("testing@gmail.com");
		// click the next button 
		driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
		// Clear the password text box
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		// Enter the password 
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("**********");
		// Enter the next button 
		driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
		// Check title 
		String actualTitle = driver.getTitle();
		String expectedTitle = "Inbox - Testing@gmail.com"; 
		Assert.assertEquals(actualTitle, expectedTitle); 
		// Logout
		driver.findElement(By.className("gb_Da gbii")).click();
		driver.findElement(By.id("gb_71")).click();
		driver.quit();
	}

}
