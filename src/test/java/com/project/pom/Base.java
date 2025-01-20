package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	private WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver= driver;	
	}

	public WebDriver chromeDriverConnection() {
		driver = new ChromeDriver();				// Invocamos el ChromeDriver
		return driver;
	}

// Lista de Wrappers (envoltorios, Alias, subrutinas o S-Functions).
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void type(By locator, String inputText) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e){
			return false;
		}
	}
	
	public void visit(String url) {
		driver.get(url);
	}
	
	public void print(String text) {
		System.out.println("text");
	}
	
	
} //Fin de clase Base
