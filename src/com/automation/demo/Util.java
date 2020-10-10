package com.automation.demo;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Util {

	public static WebDriver driver;
	public String OS;
	public String browser = "chrome";
	
	
	@BeforeMethod
	public void beforeClass() {
		OS = System.getProperty("os.name").toLowerCase();
		// System.out.println(OS);
		if (OS.contains("windows")) {
			if (browser.contains("chrome")) {
				System.setProperty("webdriver.chrome.driver","./src/resources/chromedriver.exe");
				driver = new ChromeDriver();
			}
		}
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}

	@AfterMethod
	public void afterTest() {
		driver.close();
		driver.quit();
	}
	
	//creating random string for email,name.
	final String lexicon = "abcdefghijklmnopqrstuvwxyz";
	final java.util.Random rand = new java.util.Random(); 
	final  Set<String> identifiers = new HashSet<String>();
	public  String randomIdentifier() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}
	
}
