package com.qa.automation.stepdefs;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//plugin = {"html:target/cucumberHtmlReport"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/extentreport/report.html"},
				
		//pretty:target/cucumber-json-report.json
		features = "classpath:features",
		
		tags= {"@Test5"}
)


	 
public class RunCukesTest{
	
	
	@AfterClass
    public static void teardown() throws IOException, InterruptedException {
		System.out.println("Inside Run Cukes setup function");
		
       Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
	     Reporter.setSystemInfo("Selenium", "3.7.0");
	     Reporter.setSystemInfo("Maven", "3.5.2");
	     Reporter.setSystemInfo("Java Version", "1.8.0_151");
	     Reporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\test\\resources\\extent-config.xml");
	     System.out.println("Inside Run Cukes setup function before send mail");
	   }

}
