package com.qa.automation.stepdefs;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ClickElementsStepDefs {

	WebDriver driver;
	
	 private static Logger log = Logger.getLogger(ClickElementsStepDefs.class);
	  
	 public ClickElementsStepDefs(){
		 driver= Hooks.driver;
	}
//	ClickMethods clickObj = new ClickMethods();
	@Then("^User clicks on \"([^\"]*)\" on \"([^\"]*)\"$")
	public void clicksOn(String key,String page) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//clickObj.click();
		By element = GetORData.getCompleteElement(key,page);
		driver.findElement(element).click();
		log.info("Clicked on "+element);
		Thread.sleep(20000);
		
	}
	@Then("^User hovers and click on \"([^\"]*)\" on \"([^\"]*)\"$") 
	public void Hoverandclick(String Key, String Page) throws Exception{
	WebElement elements = null;
	By element = GetORData.getCompleteElement(Key, Page);
	elements=driver.findElement(element);
	Actions builder = new Actions(driver);
	builder.moveToElement(elements).build().perform();
	elements.click();
	Thread.sleep(3000);
	}
	/** Double click on a WebElement */
	@When("^User double click on \"(.*?)\" on \"([^\"]*)\"$") 
	public void doubleClick(String key,String page) throws Exception
	{
		Actions action = new Actions(driver);
		By element = GetORData.getCompleteElement(key,page);
		action.moveToElement(driver.findElement(element)).doubleClick().perform();
		log.info("Double click on element: " + element);	
	}
		
	/** Click on a link having text */
	@When("^User click on link having text \"(.*?)\" on \"([^\"]*)\"$")
	public void clickElementByLink(String text,String page) throws Exception
	{
		By element = GetORData.getCompleteElement(text,page);
		driver.findElement(element).click();
    	log.info("Click on link having text: " + text);
	}
		
	/** Click on a link having partial text 
	 * @throws Throwable */
	@When("^User click on link having partial text as \"([^\"]*)\" on \"([^\"]*)\"$")
	public void clickElementByPartialLink(String text, String Page) throws Throwable
	{
    	By element = GetORData.getCompleteElement(text,Page);
    	
		driver.findElement(element).click();
		log.info("Click on link having partial text: " + text);
	}
}