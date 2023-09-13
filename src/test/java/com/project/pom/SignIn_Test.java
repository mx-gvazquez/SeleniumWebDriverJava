package com.project.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SignIn_Test {
	
// Primero, declaramos la variable 'driver'
	private WebDriver driver;
	
// Creamos un objeto tipo SingnInPage para utilizar los métodos de esa página
	SignInPage signInPage;
	

	@Before
	public void setUp() throws Exception {
		signInPage = new SignInPage(driver);
		driver = signInPage.chromeDriverConnection();
		signInPage.visit("https://demo.guru99.com/test/newtours/");
	}
	
	@Test
	public void test() throws InterruptedException {
		signInPage.signIn();
		Thread.sleep(2000);
		assertEquals("Thank you for Loggin.",signInPage.isHomePageDisplayed());
	}
	
	@After
	public void tearDown() throws Exception {
    //	driver.quit();
	}

}
