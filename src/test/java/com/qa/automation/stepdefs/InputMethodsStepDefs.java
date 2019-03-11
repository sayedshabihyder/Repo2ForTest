package com.qa.automation.stepdefs;



import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import jdk.internal.jline.internal.Log;

public class InputMethodsStepDefs {

	WebDriver driver; 
	/******** Log Attribute ********/
	private static Logger log = Logger.getLogger(InputMethodsStepDefs.class);
	
	public InputMethodsStepDefs(){
		 driver= Hooks.driver;
	}
	//InputMethods inputMethodsObj = new InputMethods();
	@Then("^User types \"([^\"]*)\" in \"([^\"]*)\" on \"([^\"]*)\"$")
	public void userTypes(String text, String key,String page) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//inputMethodsObj.inputText(text,key);
		
		By element = GetORData.getCompleteElement(key,page);
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.presenceOfElementLocated(element));
		
		WebElement input= driver.findElement(element);
		input.click();
		input.clear();
		log.info("Sending text: "+text+"into element"+element);
		input.sendKeys(text);
	}
	
	/** Enter a text into an input field element slowly */
	@When("^User slowly enter \"([^\"]*)\" into \"([^\"]*)\" on \"([^\"]*)\"$")
	public void slowSendKeys(String text,String key,String page) throws Exception
	{
		By element = GetORData.getCompleteElement(key,page);
		WebElement input = driver.findElement(element);
		input.click();
		for (char c : text.toCharArray()) {
			//ProgressMethodsStepDefs.wait(5);
			input.sendKeys(""+c);
		}
	}
	@Then("^User verifies \"([^\"]*)\" is \"([^\"]*)\" on \"([^\"]*)\"$")
	public void checkedCheckbox(String Key, String State, String Page) throws Exception
	{
		if(Key.equals("UncheckedCheckbox")){
			By element = GetORData.getCompleteElement(Key,Page);
			State = driver.findElement(element).getAttribute("class");
			 Assert.assertTrue("Checkbox is checked ", driver.findElement(element).getAttribute("class").contentEquals(State));
			 log.info("Assertion Ccheckbox Passed");	}	
		/*if(State.equals("Unchecked")){
			
		    Assert.assertTrue("Checkbox is checked ", driver.findElement(element).getAttribute("class").contentEquals(State));
		    log.info("Assertion Ccheckbox Passed");
		}*/
			 else if (Key.equals("CheckedCheckbox")) {
		    	By Element = GetORData.getCompleteElement(Key,Page);
				String Checked = driver.findElement(Element).getAttribute("class");
				Assert.assertTrue("Checkbox is not checked ", driver.findElement(Element).getAttribute("class").contentEquals(Checked));
			    log.info("Assertion checkbox Passed");
			    /*if(State.equals("Checked")){
					
			    	Assert.assertTrue("Checkbox is not checked ", driver.findElement(Element).getAttribute("class").contentEquals(Checked));
				    log.info("Assertion checkbox Passed");
			    }*/
			    }
		    }
	
		    
	/** Check an option from a checkbox */
	@When("^User check the \"(.*?)\" checkbox on \"([^\"]*)\"$") 
	public void checkCheckbox(String key, String page) throws Exception
	{
		By element = GetORData.getCompleteElement(key, page);	
		boolean isChecked = driver.findElement(element).isSelected();
		if(!isChecked){
			log.info("Clicking the checkbox with name " +key+ " to check");
			driver.findElement(element).click();
		}
		/*By element = GetORData.getCompleteElement(key,page);	
		boolean isChecked = driver.findElement(element).isSelected();
		driver.findElement(element).click();
		WebElement Element=driver.findElement(By.xpath("//*[@id='userLoginSection']/div/div/div[1]/label/span/span"));
		String Checked = Element.getAttribute("class");
		log.info(Checked);
		Assert.assertTrue("Checkbox is not checked ", Element.getAttribute("class").contentEquals(Checked));
		log.info("Assertion Passed");
		Element.click();
		Thread.sleep(3000);
		String Unchecked = driver.findElement(element).getAttribute("class");
		log.info(Unchecked);
		try {
			Assert.assertTrue("Checkbox is not checked ", "check".contentEquals(Unchecked));
			log.info("");
		} catch (AssertionError e) {
			 log.info("Catched Exception: Checkbox not checked");
		}
		Element.click();
		Assert.assertTrue("Checkbox is not checked ", "check".contentEquals(Checked));
		log.info("Now checked");
		
		
		    /*if(Checked.contains("check"))
		     {
		        System.out.println("Status: checked");
		        //This will return Null, since it is not a real check box(type=checkbox), 
		        //so there is no checked attribute in it
		     }
		    else
		     {

		        System.out.println("Not Checked");
		     }
		if(!isChecked){
			log.info("Clicking on the checkbox to select:" +element);
			driver.findElement(element).click();
			Thread.sleep(3000);
			String checked = driver.findElement(element).getAttribute("class");
			log.info(checked);
			Thread.sleep(3000);
		}*/
	
	}
	

	/** Uncheck an option from a checkbox */
	@When("^User uncheck the \"(.*?)\" checkbox on \"([^\"]*)\"$")
	public void uncheckCheckbox(String key,String page) throws Exception
	{
		By element = GetORData.getCompleteElement(key,page);	
		boolean isChecked = driver.findElement(element).isSelected();
		if(isChecked){
			log.info("Clicking the checkbox with name " +key+ " to uncheck");
			driver.findElement(element).click();
			
		}
	}
	
	/** Select a radio button */
	@When("^User select \"(.*?)\" radio button on \"([^\"]*)\"$")
	public void selectRadioButton(String strArg1, String strArg2) throws Exception
	{
		By element = GetORData.getCompleteElement(strArg1,strArg2);	
		boolean isSelected = driver.findElement(element).isSelected();
		if(!isSelected){
			log.info("Clicking on the radio button to select:" +element);
			driver.findElement(element).click();
		}
}
	
	/** Clear input field element. */
	@When("^User clears text present in \"([^\"]*)\" on \"([^\"]*)\"$") 
	public void clearText(String key, String page) throws Exception
	{
		By element = GetORData.getCompleteElement(key, page);
		WebElement input= driver.findElement(element);
		input.click();
		input.clear();
		log.info("Cleared text present in " +key);
	
	}
	/** Select an option by text/value from a drop-down */
	@When("^User selects \"([^\"]*)\" \"([^\"]*)\" from dropdown \"([^\"]*)\" on \"([^\"]*)\"$")
	public void selectOptionDropdown(String optionBy,String option,String key,String page) throws Exception
	{
		By dropdown = GetORData.getCompleteElement(key, page);		
		Select opt = new Select(driver.findElement(dropdown));
		
		if(optionBy.equals("text")){
			log.info("Select option: " + option + "by text");		
			opt.selectByVisibleText(option);				
		}
		else if(optionBy.equals("value")){
			log.info("Select option: " + option + "by value");			
			opt.selectByValue(option);				
			
		}					
	}
	/** Select an option by index from a drop-down */
	@When("^User selects option \"([^\"]*)\" by index from dropdown \"([^\"]*)\" on \"([^\"]*)\"$")
	public void selectOptionDropdownByIndex(int option, String key, String page) throws Exception
	{
		By dropdown = GetORData.getCompleteElement(key, page);		
		Select opt = new Select(driver.findElement(dropdown));
		log.info("Select option: " + option + "by text");		
		opt.selectByIndex(option);				
	}
	/** Clear all options selected from a drop-down */
	@When("^User clears all options selected from dropdown \"([^\"]*)\" on \"([^\"]*)\"$")
	public void deselectAllOptionDropdown(String Key, String Page) throws Exception
	{
		By dropdown = GetORData.getCompleteElement(Key, Page);		
		Select opt = new Select(driver.findElement(dropdown));
		log.info("Clear all options selected from drop-down");		
		opt.deselectAll();			
	}
	/** Unselect an option by text/value from a drop-down */
	@When("^User unselects \"([^\"]*)\" option by \"([^\"]*)\" from dropdown \"([^\"]*)\" on \"([^\"]*)\"$")
	public void unselectOptionMultiDropdown(String option,String optionBy, String key,String page) throws Exception
	{
		By dropdown = GetORData.getCompleteElement(key,page);		
		Select opt = new Select(driver.findElement(dropdown));
		
		if(optionBy.equals("text")){
			log.info("Unselect option: " + option + "by text");		
			opt.deselectByVisibleText(option);				
		}
		else if(optionBy.equals("value")){
			log.info("Unselect option: " + option + "by value");			
			opt.deselectByValue(option);				
		}		
	}
	/** Unselect an option by index from a drop-down */
	@When("^User unselects \"([^\"]*)\" option by index from dropdown \"([^\"]*)\" on \"([^\"]*)\"$")
	public void unselectOptionMultiDropdownByIndex(int option, String key, String page) throws Exception
	{
		By dropdown = GetORData.getCompleteElement(key, page);		
		Select opt = new Select(driver.findElement(dropdown));
		log.info("Select option: " + option + "by text");		
		opt.deselectByIndex(option);	
	}
	@Then("^User selects element \"([^\"]*)\" from autocomplete list$")
	public void autoComplete(String strArg1) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@role='listbox']/li")));    
	List<WebElement> optionsToSelect = driver.findElements(By.xpath("//*[@role='listbox']/li"));
	log.info(optionsToSelect.size());

	for(WebElement option : optionsToSelect){
	     if(option.getText().equals(strArg1)) {
	        System.out.println("Trying to select: "+strArg1);
	        option.click();
	        break;
	    }
	}
	}
}