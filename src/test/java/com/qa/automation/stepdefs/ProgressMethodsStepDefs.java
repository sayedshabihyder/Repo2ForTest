package com.qa.automation.stepdefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;

public class ProgressMethodsStepDefs {

	static WebDriver driver;

	private static Logger log = Logger.getLogger(ProgressMethodsStepDefs.class);

	public ProgressMethodsStepDefs() {
		driver = Hooks.driver;
	}
	// ProgressMethods progressObj = new ProgressMethods();

	/*
	 * @Then("^User wait for \"([^\"]*)\" seconds$") public static void wait(int
	 * seconds) throws InterruptedException { log.info("Waiting for..."+seconds +
	 * " seconds."); new WebDriverWait(driver, seconds); }
	 */

	@Then("^User waits for \"([^\"]*)\" milliseconds$")
	public static void wait(int ms) throws Throwable {

		Thread.sleep(ms);
		// Write code here that turns the phrase above into concrete actions
		// progressObj.waitForElementVisible(key);
		// driver.manage().timeouts().implicitlyWait(seconds,TimeUnit.SECONDS);
		// log.info("Waited for " +seconds+ " seconds");
	}

	@Then("^User wait for \"([^\"]*)\" to be visible on \"([^\"]*)\"$")
	public void waitForVisible(String key, String page) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// progressObj.waitForElementVisible(key);
		By element = GetORData.getCompleteElement(key, page);
		WebDriverWait w = new WebDriverWait(driver, 10);
		log.info("Waiting for the element to be visible");
		w.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	@Then("^User wait for \"([^\"]*)\" to be clickable on \"([^\"]*)\"$")
	public void waitForClickable(String key, String page) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// progressObj.waitForElementToBeClickable(key);

		By element = GetORData.getCompleteElement(key, page);
		WebDriverWait w = new WebDriverWait(driver, 10);
		log.info("Waiting for the element to be clicked");
		w.until(ExpectedConditions.elementToBeClickable(element));
	}

	@Then("^User wait for \"([^\"]*)\" seconds for element \"([^\"]*)\" to be present on \"([^\"]*)\"$")
	public void waitForPresent(int Seconds, String Key, String Page) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// progressObj.waitForElementToBeClickable(key);

		By element = GetORData.getCompleteElement(Key, Page);
		WebDriverWait w = new WebDriverWait(driver, Seconds);
		log.info("Waiting for the element to be clicked");
		w.until(ExpectedConditions.presenceOfElementLocated(element));
	}

	@Then("^User wait for \"([^\"]*)\" to be enabled on \"([^\"]*)\"$")
	public void waitForEnable(String key, String page) throws Throwable {
		By element = GetORData.getCompleteElement(key, page);
		boolean enabled = driver.findElement(element).isEnabled();
		WebDriverWait w = new WebDriverWait(driver, 10);
		log.info("Waiting for the element: " + element + " to be enabled");
		w.until(ExpectedConditions.elementSelectionStateToBe(element, enabled));
	}

}
