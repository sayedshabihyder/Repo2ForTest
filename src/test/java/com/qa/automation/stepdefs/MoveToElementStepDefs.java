/*package com.qa.automation.stepdefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Then;

public class MoveToElementStepDefs {
	WebDriver driver;
	
	 private static Logger log = Logger.getLogger(ClickElementsStepDefs.class);
	 public MoveToElementStepDefs(){
		 driver= Hooks.driver;
	}

	@Then("^User hovers on \"([^\"]*)\" on \"([^\"]*)\"$")
	public void moveToElement(String key,String page) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//clickObj.click();
		WebElement elements = null;
		By element = GetORData.getCompleteElement(key,page);
		elements=driver.findElement(element);
		Actions builder = new Actions(driver);
		builder.moveToElement(elements).build().perform();
		Thread.sleep(4000);
		
}
}*/
