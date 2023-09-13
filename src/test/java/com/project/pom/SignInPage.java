package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends Base{


	// Localizadores del SEGUNDO Escenario	
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
		By homePageLocator = By.tagName("font");
		
		
	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void signIn() {
		if (isDisplayed(userLocator)) {
			type(userLocator, "UsrTst");
			type(passLocator, "123#");
			click(singInBtnLocator);
		} else {
			print("Username textbox was not present");
		}
	}
	
	public String isHomePageDisplayed() {
		//Validación de éxito.		
		List<WebElement> login = findElements(homePageLocator);	// Haz una lista llamada 'fonts' de todos los WebElement con tag = font
		return getText(login.get(3));	//Valida que el texto del elemento sea exactamente el que indicamos.
		
	}
	

} // Fin clase SignInPage
