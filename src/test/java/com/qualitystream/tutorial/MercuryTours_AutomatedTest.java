package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MercuryTours_AutomatedTest {
	
// Declaramos la variable 'driver'
	private WebDriver driver;
	
//Dentro de la clase, pero antes de las instancias, creamos el catálogo de Localizadores
	// #1
	By registerLinkLocator = By.linkText("REGISTER");
	// #2
	By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	// #3
	By usernameLocator = By.id("email");
	// #4
	By passwordLocator = By.name("password");
	// #5
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	// #6
	By registerBtnLocator = By.name("submit");
	// #7
	/*
	 * Este elemento es un tag = Font, y el que necesitamos está en la 'posición = 6', de JavaScript.
	 * Necesitamos crear una lista de WebElementS, en PLURAL, y apuntar al índice = 5. Java cuenta desde CERO.
	 * F12 on WebBrowser opens 'Inspector'
	 * CRTL + F = opens search toolbar.   Así fue como supimos que hay 6 'fonts'.
	 */
	
	// #8
	By userLocator = By.name("userName");
	// #9
	By passLocator =By.name("password");	
	// #10
	By singInBtnLocator = By.name("submit");
	// #11
	/*
	 * Este elemento es un tag = Font, y el que necesitamos está en la 'posición = 4/6', de JavaScript.
	 * Necesitamos crear una lista de WebElementS, en PLURAL, y apuntar al índice = 3. Java cuenta desde CERO.
	 * F12 on WebBrowser opens 'Inspector'
	 * CRTL + F = opens search toolbar.   Así fue como supimos que hay 6 'fonts'.
	 */

	@Before
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup(); 	// Utilizamos la libreria WebDriverManager de bonigarcia
		driver = new ChromeDriver();				// Invocamos el ChromeDriver
		driver.manage().window().maximize();		// Maximiza la ventana del Google Chrome
// Paso # 0 - Entrar a la url principal
	//Mala práctica - HARD CODE de URL's de prueba en el código.	
		driver.get("https://demo.guru99.com/test/newtours/");	// Abre nuestra url, nuestro 'System Under Test'.
	}


// Primer escenario, crear un nuevo usuario.
	@Test
	public void registerUser() throws InterruptedException {
		// Paso # 1 - Click en el botón REGISTER.
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000); // Espera tonta de 2 seg para que carge la página.
		// Paso # 2 - Valida estar en la página correcta, con la imagen específica.
		if (driver.findElement(registerPageLocator).isDisplayed()) { 		//Busca la imagen del Banner
	//Mala práctica - HARD CODE de credenciales en el código.			
			driver.findElement(usernameLocator).sendKeys("UsrTst"); 		// Escribe el nombre del usuario
			driver.findElement(passwordLocator).sendKeys("123#"); 			// Escribe la contraseña
			driver.findElement(confirmPasswordLocator).sendKeys("123#");	// Confirma la contraseña
			driver.findElement(registerBtnLocator).click();					// Click en 'Enviar Consulta' / 'Submit' 			
		}
		else {
			System.out.println("Register Page was NOT found");
		}
		
	//Validación de éxito.		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));	// Haz una lista llamada 'fonts' de todos los WebElement con tag = font
		assertEquals("Note: Your user name is UsrTst.", fonts.get(5).getText());	//Valida que el texto del elemento sea exactamente el que indicamos.
		
	}
	
//Segundo escenario, hacer login con el nuevo usuario, en la página principal.
	
	@Test
	public void signIn() throws InterruptedException {
		if (driver.findElement(userLocator).isDisplayed()) {
			driver.findElement(userLocator).sendKeys("UsrTst");
			driver.findElement(passLocator).sendKeys("123#");
			driver.findElement(singInBtnLocator).click();
			Thread.sleep(2000); // Espera tonta de 2 seg para que carge la página.	
		
	//Validación de éxito.		
			List<WebElement> login = driver.findElements(By.tagName("font"));	// Haz una lista llamada 'fonts' de todos los WebElement con tag = font
			assertEquals("Thank you for Loggin.", login.get(3).getText());	//Valida que el texto del elemento sea exactamente el que indicamos.
		}
		else {
			System.out.println("username textbox was not present");
		}
	
	}

	
	@After
	public void tearDown() throws Exception {
	//	driver.quit();
	}	
	
}
