package com.mypack;
//update diaglogue
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class planit {
    public WebDriver d;
	@BeforeMethod
	public void setUp() {
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		d.manage().deleteAllCookies();
		
	}
	@Test
	public void script() {
		d.get("https://magento.softwaretestingboard.com/");
		Actions a=new Actions(d);
		a.moveToElement(d.findElement(By.xpath("//span[contains(text(),'Women')]//parent::a[@role='menuitem']"))).moveToElement(d.findElement(By.xpath("//span[contains(text(),'Tops')]")))
		.moveToElement(d.findElement(By.xpath("//span[contains(text(),'Tees')]"))).build().perform();
		
	}
	
	
}
