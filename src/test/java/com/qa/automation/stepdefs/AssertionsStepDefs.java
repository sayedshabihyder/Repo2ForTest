package com.qa.automation.stepdefs;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;

public class AssertionsStepDefs {

	 WebDriver driver; 
	 public static final int EXPLICIT_TIMEOUT = 15; 
	/******** Log Attribute ********/
	private static Logger log = Logger.getLogger(AssertionsStepDefs.class);
	//AssertionMethods assertionObj = new AssertionMethods();
	
	public AssertionsStepDefs(){
		 driver= Hooks.driver;
	}
	@Then("^User \"([^\"]*)\" see page title as \"([^\"]*)\"$")
	public void user_verify_page_tile_as(String present, String title) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	//	assertionObj.checkPageTitle(present, title);
	//	System.out.println(present);
		 
		String pageTitle = driver.getTitle();
		log.info("The title of page is "+ pageTitle);
		if(present.equals("should")){
			log.info("The title should be present");
			Assert.assertTrue("The title is not present", pageTitle.equals(title));			
		}
		else if(present.equals("should not")){
			log.info("The title should not be present");
			Assert.assertFalse("The title is present", pageTitle.equals(title));		
		}
	}
	@Then("^radio button having title \"([^\"]*)\" should be \"([^\"]*)\" on \"([^\"]*)\"$")
	public void checkRadioButtonSelected(String strArg1, String strArg2, String strArg3) throws Exception
	{
		By element = GetORData.getCompleteElement(strArg1, strArg3);
		boolean selected = driver.findElement(element).isSelected();
		
		if(strArg2.equals("selected")){
			log.info("The element: " + element +" should be selected");
			Assert.assertTrue("The element by " + element + "is not selected", selected);
			
		}
		else if(strArg2.equals("unselected")){
			log.info("The element: " + element +" should be unselected");
			Assert.assertFalse("The element by " + element + "is selected", selected);		
		}
	}
	@Then("^User \"([^\"]*)\" partial text of page title as \"([^\"]*)\" on \"([^\"]*)\"$")
	public void checkTitlePartialText(String strArg1, String strArg2, String strArg3)
	{
		String pageTitle = driver.getTitle();
		
		if(strArg1.equals("should see")){
			log.info("The partial text on the title should be present");
			Assert.assertTrue("The partial title is not present", pageTitle.contains(strArg2));		
			log.info("The partial text"+" " +strArg2 +" "+"is present in the page title");
			log.info("The page title is"+" " +pageTitle);
		}
		else if(strArg1.equals("should not see")){
			log.info("The partial text on the title should not be present");
			Assert.assertFalse("The partial title is present", pageTitle.contains(strArg2));
			
		}
	}
	@Then("^Element \"([^\"]*)\" \"([^\"]*)\" have text as \"([^\"]*)\" on \"([^\"]*)\"$")
	public void checkElementText(String strArg1, String strArg2, String strArg3, String strArg4) throws Exception 
	{
		By element = GetORData.getCompleteElement(strArg1, strArg4);
		WebElement Element = driver.findElement(element);
		String title=Element.getText();
		

		if(strArg2.equals("should have")){			
			log.info("The element with the text " + strArg3 +" should be present");
			Assert.assertEquals("The element with the text " + strArg3 + " is not present", strArg3, Element.getText());
			log.info("The element with the text " +title +" is present");
			
		}
		else if(strArg2.equals("should not have")){
			log.info("The element: "+ element +"with the text" + strArg3 +" should not be present");
			Assert.assertFalse("The element with the text " +title +" is present",strArg3.contentEquals(title));
		
		}
		}
	@Then("^User verifies \"([^\"]*)\" \"([^\"]*)\" be present and should be in \"([^\"]*)\" state on \"([^\"]*)\"$")
	public void checkElementEnable(String Key, String Present, String State, String Page) throws Exception
	{
		By element = GetORData.getCompleteElement(Key, Page);
		boolean enable = driver.findElement(element).isEnabled();
		
		if(Present.equals("should")){			
			log.info("The element" + Key +" should be present");
			if(State.equals("Enabled")){
				log.info("The element" + Key +" should be present and enabled");
				Assert.assertTrue("The element " + Key + "is disabled", enable);
			}
			else if(State.equals("Disabled")){
				log.info("The element" + Key +" should be present and disabled");
				Assert.assertFalse("The element " + Key + "is enabled", enable);
				log.info("The element is disabled");
			}
		}
		else if(Present.equals("should not")){
			log.info("The element " + Key + " should not be present");
			if(State.equals("Enabled")){
				log.info("The element" + Key +" should not be present and enabled");
				Assert.assertTrue("The element " + Key + "is disabled", enable);
			}
			else if(State.equals("Disabled")){
				log.info("The element" + Key +" should not be present and disable");
				Assert.assertFalse("The element " + Key + "is enabled", enable);
			}
		}
		}
		@Then("^User verifies \"([^\"]*)\" element \"([^\"]*)\" be present on \"([^\"]*)\"$") 
		public void checkElementPresent(String Key,String Present,String Page) throws Exception
		{
			By element = GetORData.getCompleteElement(Key, Page);
			boolean eleSelected= driver.findElement(element).isDisplayed();
//			boolean isPresent = driver.findElements(element).isEmpty();
			String s=driver.findElement(element).getText();
			log.info(s);
			
			if(Present.equals("should")){
				log.info("The element: " + Key +" should be present");
				Assert.assertTrue("The element " + Key + "is not present", eleSelected);
				log.info("The element: " + Key +" is present");
			}
			else if(Present.equals("should not")){
				log.info("The element: " + Key +" should not be present");
				Assert.assertFalse("The element " + Key + " is present", eleSelected);
				log.info("The element: " + Key +" is not present");
			}
		}
		@Then("^User verifies \"([^\"]*)\" should be \"([^\"]*)\" on \"([^\"]*)\"$")
		public void checkCheckboxChecked(String Key, String State,String Page) throws Exception
		{
			By element = GetORData.getCompleteElement(Key, Page);
			boolean selected = driver.findElement(element).isSelected();
						
			if(State.equals("checked")){
				log.info("Checkbox with name " + Key +" is checked");
				Assert.assertTrue("Checkbox with name " + Key + " is not checked", selected);
			}
			else if(State.equals("unchecked")){
				log.info("The element: " + Key +" should be unchecked");
				Assert.assertFalse("The element " + Key + " is checked", selected);		
			}
		}
		@Then("^User verifies \"([^\"]*)\" element \"([^\"]*)\" present by partial text \"([^\"]*)\" on \"([^\"]*)\"$") 
		public void checkPartialElementPresent(String Key, String Present, String Text, String Page) throws DocumentException 
		{
			By element = GetORData.getCompleteElement(Key, Page);
			WebElement Element=driver.findElement(By.linkText(Text));
			String s=Element.getText();
			log.info(s);
			WebDriverWait w = new WebDriverWait(driver, EXPLICIT_TIMEOUT);
			boolean isPresent = w.until(ExpectedConditions.textToBePresentInElement(Element,  Text));
			
			if(Present.equals("is")){
				log.info("The element: " + Key +" should be present");
				Assert.assertTrue("The element by " + Key + "is not present", isPresent);
			}
			else if(Present.equals("is not")){
				log.info("The element: " + Key +" should not be present");
				Assert.assertFalse("The element by " + Key + "is present", isPresent);		
			}
			
		}	
		@Then("^User should see alert text as \"(.*?)\"$") 
		public void checkJavascriptAlertText(String actualValue) throws InterruptedException 
		{
			driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();
	WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.alertIsPresent());
		    
			String alert = driver.switchTo().alert().getText();
		    log.info("Switched to alert");
		    log.info("Alert text is " +alert);
		    log.info("Expected text was " +actualValue);
		    Assert.assertTrue("The JavaScript pop-up alert does not contains the text", alert.equals(actualValue));
		    
				}


@Then("^option with value \"([^\"]*)\" having string length \"([^\"]*)\" from dropdown \"([^\"]*)\" should be \"([^\"]*)\" on \"([^\"]*)\"$")
public void checkDropdownOptionSelected(String value,int length, String dropdownname, String state, String page) throws Exception
{
	By dropdown = GetORData.getCompleteElement(dropdownname,page);
	driver.findElement(dropdown).click();
	Select menuitem=new Select(driver.findElement(dropdown));
	String expected=value.toString();
	log.info(expected);
	String Expected=expected.substring(1,length);
	String actual=menuitem.getFirstSelectedOption().getText().toString();
	log.info(actual);
	String Actual=actual.substring(1,length);
	if(state.equals("selected")){
		log.info("The option: " + value +" should be selected");			
       Assert.assertTrue("The element " + value + " is not selected", Expected.equals(Actual));
		log.info("Expected was "+expected+" Actual is "+actual);
	}
	else if(state.equals("unselected")){
		log.info("The option: " + value +" should be unselected");
		Assert.assertNotEquals("Assertion Failed", Expected,Actual);
		log.info("The option: " + value +" is not selected");
		log.info("The option: " + value +" is not selected");
		/*if(menuitem.isSelected()){
			selectElement.click();
		}			
		Assert.assertTrue("The element" + optionToSelect + "is selected", selectElement.isSelected());
	}	
}	*/
}
}
}
	




