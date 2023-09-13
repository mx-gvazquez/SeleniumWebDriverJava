package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends Base{
	
//Dentro de la clase, pero antes de las instancias, creamos el catálogo de Localizadores
	
	// Localizadores del PRIMER Escenario
	
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
		
	//Validación de éxito.
		By registeredMessage = By.tagName("font"); //Para utilizar el método de listas

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
// Métodos
	public void registerUser() throws InterruptedException {
		// Paso # 1 - Click en el botón REGISTER.
		click(registerLinkLocator);
		Thread.sleep(2000); // Espera tonta de 2 seg para que carge la página.
		// Paso # 2 - Valida estar en la página correcta, con la imagen específica.
		if (isDisplayed(registerPageLocator)) {
	//Mala práctica - HARD CODE de credenciales en el código.
			
			//driver.findElement(usernameLocator).sendKeys("UsrTst"); 		// Escribe el nombre del usuario
			type(usernameLocator, "UsrTst");
			//driver.findElement(passwordLocator).sendKeys("123#"); 			// Escribe la contraseña
			type(passwordLocator, "123#");
			//driver.findElement(confirmPasswordLocator).sendKeys("123#");	// Confirma la contraseña
			type(confirmPasswordLocator, "123#");		
			//driver.findElement(registerBtnLocator).click();					// Click en 'Enviar Consulta' / 'Submit' 
			click(registerBtnLocator);			
		} else {
			print("Register page was not found");
		}
		
	}
	
	public String registeredMessage() {
		
		List<WebElement> fonts = findElements(registeredMessage);
		return getText(fonts.get(5));
		
	}

}
