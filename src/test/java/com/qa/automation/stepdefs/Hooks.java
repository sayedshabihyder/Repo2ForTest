package com.qa.automation.stepdefs;

import java.io.IOException;
import java.net.MalformedURLException;


import org.apache.log4j.Logger;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.cucumber.listener.Reporter;
import com.qa.automation.env.CreateDriver;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {


	
	public static WebDriver driver;
	
	
	Logger log = Logger.getLogger(Hooks.class);
	Scenario scenario = null;
	
	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
		
	}

	
   
	@Before 
    public void initDriver() throws MalformedURLException {
		log.info("***********************************************************************************************************");
		log.info("[ Configuration ] - Initializing driver configuration");
		log.info("***********************************************************************************************************");
    	driver = CreateDriver.initConfig();	    
    	
    	log.info("***********************************************************************************************************");
		log.info("[ Scenario ] - "+scenario.getName());
		log.info("***********************************************************************************************************");
    }	 
     
 	@After
 	///**
    // * Embed a screenshot in test report if test is marked as failed
    // 
    public void embedScreenshot(Scenario scenario) throws IOException {
       
        if(scenario.isFailed()) {
	        try {
	        	 
			    	
		            String scnShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		            Reporter.addScreenCaptureFromPath("data:image/jpeg;base64," + scnShot);
	        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
	            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
	        }	        
        }
        
		log.info("***********************************************************************************************************");
		log.info("[ Driver Status ] - Clean and close the intance of the driver");
		log.info("***********************************************************************************************************");
        driver.quit();
        
    }

}
