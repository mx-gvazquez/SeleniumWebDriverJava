package com.checkingLinks.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CheckingLinksPage {

    final WebDriver driver;

    public CheckingLinksPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean checkingPageLinks(){
        List<WebElement> links = driver.findElements(By.tagName("a")); // Creates an List with all 'a' WebElements (hyperlinks)
        String url = ""; // Create an empty String object
        List<String> brokenLinks = new ArrayList<String>(); // Mutable Array of broken links
        List<String> okLinks = new ArrayList<String>(); // Mutable Array of OK links

        HttpsURLConnection httpConection = null; // Method that avoid using API's
        int responseCode = 200; // Desired response, initial value 200.



        //Begin For-Each routine
        for (WebElement link : links) {
            // url = link.getAttribute("href"); // https://www.linkedin.com/pulse/selenium-427-deprecates-getattributemethod-ranjit-biswal-bvopc/
            url = link.getDomProperty("href"); // Using new method to store the actual URL from hyperlinks.
            if (url == null || url.isEmpty()) {
                System.out.println(url + "URL is not configured or is Empty"); // Validates Hyperlinks with bad configuration (no URL to go to).
                continue;
            }
            try {
                httpConection = (HttpsURLConnection) (new URL(url).openConnection()); // Request connection
                httpConection.setRequestMethod("HEAD"); // Here we ask for the JSON header, with desired response.
                httpConection.connect();
                responseCode = httpConection.getResponseCode(); // Save response code, with NEW value obtained.

                if (responseCode > 400) {  // Check if reponse is in FAIL scope
                    System.out.println("ERROR BROKEN LINK: --- " + url); // Prints the failed URL.
                    brokenLinks.add(url);  // Stores the String value of a Broken Link.
                } else { // If response is NOT above 400, then it's OK
                    System.out.println("VALID LINK: --- " + url); // Prints the OK url
                    okLinks.add(url); //Stores the OK url in ArrayList.
                }

            } catch (Exception e) {
                // TODO
                e.printStackTrace();
            }

        } // End of For-Each routine

        System.out.println("Valid Links: " + okLinks.size()); // Print number of OK Links
        System.out.println("Broken Links: " + brokenLinks.size()); // Print Number of Broken Links

        // Routine to print Broken Links at bottom of Terminal.
        if (!brokenLinks.isEmpty()){
            System.out.println("******  ERROR --------------------- Broken Links ");
            for (int i = 0; i < brokenLinks.size(); i++) {
                System.out.println(brokenLinks.get(i));
            }
            return false;

        } else {
            return true;

        }



    }

}
