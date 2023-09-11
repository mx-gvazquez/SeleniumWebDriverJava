package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.function.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GST {
	
	private WebDriver driver;
	
	By videoLinkLocator = By.cssSelector("a[aria-label='Introducción a la Automatización de Pruebas de Software de Quality-Stream en YouTube. Reproducir en Google. 7 minutos y 24 segundos. 27 ene 2019']");
	
	@Before
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	
	@Test
	public void testGooglePage() throws InterruptedException {


		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");
		searchbox.submit();

	// # 1 - Implicit Wait
	//	# 1.1 
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Espera por un evento específico, y continúa.
		
	
	// # 2 - Explicit Wait
	//	# 2.1
		//Thread.sleep(10000); // Espera tonta de 10 seg, no se recomienda utilizar ya que detiene TODO.
		
	// # 2.2 Espera un máximo de 10s haciendo consultas cada 0.5s (default), por el elemento explicito declarado, y avanza cuando se cumple.
	/*
	 * WebDriverWait ewait = new WebDriverWait(driver,Duration.ofSeconds(10));
	 * ewait.until(ExpectedConditions.titleContains("quality-stream"));
	 */
		
	//	# 3 - Fluent Waits
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		        .withTimeout(Duration.ofSeconds(10))
		        .pollingEvery(Duration.ofSeconds(2))
		        .ignoring(NoSuchElementException.class);
		
		WebElement video = fluentWait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(videoLinkLocator);
			}
		}
		);
		
		assertTrue(driver.findElement(videoLinkLocator).isDisplayed());
		
		
//		System.out.println(driver.getTitle());
		
	//	assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Google Search", driver.getTitle());	//Inglés
		
//		assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Buscar con Google", driver.getTitle());	//Español
		
	}
	
	@After 
	public void tearDown() {
		driver.quit();

	}
	
}
