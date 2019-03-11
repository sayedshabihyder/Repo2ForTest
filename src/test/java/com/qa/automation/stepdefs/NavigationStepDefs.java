package com.qa.automation.stepdefs;

import java.util.ArrayList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class NavigationStepDefs {

	WebDriver driver;
	/******** Log Attribute ********/
	private static Logger log = Logger.getLogger(NavigationStepDefs.class);

	public NavigationStepDefs() {
		driver = Hooks.driver;
	}

	@Given("^User navigate to url \"([^\"]*)\"$")
	public void navigateToUrl(String url) throws Throwable {

		log.info("Navigate to: " + url);
		driver.navigate().to(url);
		driver.getTitle();

	}

	@And("^User navigates back")
	public void navigateBack() {
		driver.navigate().back();
		log.info("Navigate backward");
	}

	@And("^User navigates forward")
	public void navigateForward() {
		driver.navigate().forward();
		log.info("Navigate forward");

	}

	/**
	 * Switch to a new window
	 * 
	 * @throws InterruptedException
	 */
	@When("^User switch to new window$")
	public void switchNewWindow() throws InterruptedException {

		for (String winHandle : driver.getWindowHandles()) {
			log.info("Switching to new windows");
			driver.switchTo().window(winHandle);

		}

	}

	@When("^User switch to child window$")
	public void switchtoChildWindow() throws InterruptedException {
		String parentWinHandle = driver.getWindowHandle();
		System.out.println("Parent window handle: " + parentWinHandle);
		Set<String> winHandles = driver.getWindowHandles();

		/** Switch to the previous window */
		for (String handle : winHandles) {
			if (!handle.equals(parentWinHandle)) {
				driver.switchTo().window(handle);
				System.out.println("Title of the new window: " + driver.getTitle());

			}
		}
	}

	@When("^User switch to previous window$")
	public void switchPreviousWindows() {
		log.info("Switching to previous window");
		driver.switchTo().defaultContent();

	}

	/** Switch to a new window by window title */
	@When("^User switch to window having title \"(.*?)\"$")
	public void switchToNewWindowByTitle(String windowTitle) throws Exception {
		log.info("Switching to the window having title: " + windowTitle);
		driver.switchTo().window(windowTitle);
	}

	@When("^User switch to window having index \"([^\"]*)\"$")
	public void switchToNewWindowByIndex(int index) throws Exception {
		Set<String> allWindows = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindows);
		log.info(tabs);
		driver.switchTo().window(tabs.get(index));
		log.info("Switched to window " + driver.getTitle());

	}

	/** Close a windows by title */
	@And("^User closes window having index \"([^\"]*)\"$")
	public void closeWindows(int index) {
		Set<String> allWindows = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allWindows);
		driver.switchTo().window(tabs.get(index));
		log.info("Closing windows " + driver.getTitle());
		driver.close();
	}

}
