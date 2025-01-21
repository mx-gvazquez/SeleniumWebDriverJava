package com.checkingLinks.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;


public class CheckLinksTest {

    WebDriver driver;
    CheckingLinksPage page;


    @Before
    public void setUp() {
        driver = new ChromeDriver(); // Since Selenium 4.0, WebDrivers come with libraries.
        page = new CheckingLinksPage(driver);
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/");	// Open 'System Under Test'.
    }

    @Test
    public void checkingPageLinks()  {
        assertTrue("There are broken Links", page.checkingPageLinks());
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
