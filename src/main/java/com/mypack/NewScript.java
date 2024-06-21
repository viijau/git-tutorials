package com.mypack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class NewScript {
public WebDriver d;

	@BeforeMethod
	public void startUp() {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("disable-popup-blocking");
		d=new ChromeDriver(opt);
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().deleteAllCookies();
		d.manage().window().maximize();
	}
	@Test
	public void script() {
		
		d.get("https://redbus.com/");
		//Assert.assertEquals(d.getTitle(), "Best Bus Booking Platform in the World - redBus.com");
		d.findElement(By.xpath("//input[@placeholder=\"Ex: Paris\"]")).sendKeys("Chennai, Tamil Nadu, India");
		d.findElement(By.xpath("//input[@placeholder=\"Ex: London Airport\"]")).sendKeys("Visakhapatnam, Andhra Pradesh, India");
		d.findElement(By.xpath("//div[@id='date-box']")).click();
		d.findElement(By.xpath("(//span[contains(text(),'21')])[1]")).click();
		WebDriverWait w=new WebDriverWait(d,Duration.ofSeconds(60));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'SEARCH')]")));
		d.findElement(By.xpath("//div[contains(text(),'SEARCH')]")).click();
	}
	@AfterMethod
	public void end() {
		d.quit();
	}
	
}
