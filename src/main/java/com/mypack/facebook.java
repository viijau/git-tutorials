package com.mypack;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class facebook {

	public static void main(String[] args) throws InterruptedException {
		   WebDriver fb = new ChromeDriver();     

	        fb.get("https://www.facebook.com/r.php/");   
	      
	        fb.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Tomprakash");
	      Select year=new Select(fb.findElement(By.id("year")));
	      ArrayList<WebElement>a=new ArrayList<>(year.getOptions());
	      for(WebElement y:a) {
	    	  if(y.getText().equals("1947")) {
	    		      year.selectByValue(y.getText());
	    		  System.out.println("textfound");
	    		  break;
	    		  
	    	  }
	      }
	      
	}

}
