package com.qa.automation.stepdefs;

import java.awt.AWTException;
import java.awt.Robot;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.qa.automation.env.PropertiesHandler;

import cucumber.api.java.en.When;

public class KeyBoardStepDefs {

	static WebDriver driver;
	public static final int EXPLICIT_TIMEOUT = 5; 
	
	/******** Log Attribute ********/
    private static Logger log = Logger.getLogger(KeyBoardStepDefs.class);
	
	public KeyBoardStepDefs(){
		 driver= Hooks.driver;
	}
	
	/** Press Key 
	 * @throws Throwable */
	@When("^User press the \"([^\"]*)\" key$")
    public static void pressKey(String key) throws Throwable {
		Robot r;
        try {
            r = new Robot();
            ProgressMethodsStepDefs.wait(EXPLICIT_TIMEOUT * 1000);
            int keycode = PropertiesHandler.getSelectorFromProperties(key);
            r.keyPress(keycode);
            ProgressMethodsStepDefs.wait(EXPLICIT_TIMEOUT * 1000);
        } catch (AWTException e) {
            log.error("The platform configuration does not allow low-level input control", e);
        }
     }
}
