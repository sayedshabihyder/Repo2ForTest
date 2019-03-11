package com.qa.automation.stepdefs;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.And;

public class ScreenshotStepDefs {

	WebDriver driver;
	/******** Log Attribute ********/
    private static Logger log = Logger.getLogger(ScreenshotStepDefs.class);
	
	public ScreenshotStepDefs(){
		 driver= Hooks.driver;
	}

	/** Take a screenshot */
    @And("^User take screenshot$")
    public void takeScreenshot() throws IOException
    {
    	 String scnShotUser = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
         Reporter.addScreenCaptureFromPath("data:image/jpeg;base64," + scnShotUser);
         log.info("Screenshot Attached");
    }
}
