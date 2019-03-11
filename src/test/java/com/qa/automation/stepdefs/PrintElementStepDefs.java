package com.qa.automation.stepdefs;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;

public class PrintElementStepDefs {

	WebDriver driver;
	
	 private static Logger log = Logger.getLogger(PrintElementStepDefs.class);
	  
	 public PrintElementStepDefs(){
		 driver= Hooks.driver;
	 }
	 	 
		 @Then("^User prints title of window")
		 public void PrintTitle() {
			 log.info("Window title is" +driver.getTitle());
		 }
		 }
	 
	 