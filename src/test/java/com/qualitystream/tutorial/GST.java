package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GST {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	
	@Test
	public void testGooglePage() {


		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");
		searchbox.submit();
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println(driver.getTitle());
		
	//	assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Google Search", driver.getTitle());
		
		assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Buscar con Google", driver.getTitle());
		
	}
	
	@After 
	public void tearDown() {
		driver.quit();

	}
	
}
