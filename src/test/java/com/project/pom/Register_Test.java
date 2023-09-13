package com.project.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Register_Test {
	
// Primero, declaramos la variable 'driver'
	private WebDriver driver;
	
// Creamos un objeto tipo RegisterPage para utilizar los métodos de esa página
	RegisterPage registerPage;

	@Before
	public void setUp() throws Exception {
		registerPage = new RegisterPage(driver);
		driver = registerPage.chromeDriverConnection();
		registerPage.visit("https://demo.guru99.com/test/newtours/");
	}


	@Test
	public void test() throws InterruptedException {
		registerPage.registerUser();
		assertEquals("Note: Your user name is UsrTst.", registerPage.registeredMessage());
	}
	
	
	@After
	public void tearDown() throws Exception {
	//	driver.quit();
	}
	
}
