package com.qa.automation.env;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {

	static String resourceFolder = "resources/files/";
	/******** Log Attribute ********/
	private static Logger log = Logger.getLogger(WebDriverFactory.class);

	private static WebDriverFactory instance = null;
	private static String downloadDirectory;
    private static String properties = "test.properties";
    private static Properties prop = new Properties();
    private static InputStream in = WebDriverFactory.class.getResourceAsStream("/test.properties");    
   

	private WebDriverFactory() {
	}

	/**
	 * Singleton pattern
	 * 
	 * @return a single instance
	 */
	public static WebDriverFactory getInstance() {
		if (instance == null) {
			instance = new WebDriverFactory();
		}
		return instance;
	}

	public static WebDriver createNewWebDriver(String browser, String os) {
		WebDriver driver;

		 try {
	        	log.info("***********************************************************************************************************");
	        	log.info("[ POM Configuration ] - Read the basic properties configuration from: " + properties);
	            prop.load(in);
	            browser = prop.getProperty("browser");
	            os = prop.getProperty("os");
	            downloadDirectory = prop.getProperty("download.default_directory");
	            
	        } catch (IOException e) {
	        	log.error("initConfig Error", e);
	        }
	        
	        /******** Download Directory Information ********/
	      
	        log.info("[ POM Configuration ] - downloadDirectory is: " + downloadDirectory);
	        log.info("***********************************************************************************************************");
	        
		/******** The driver selected is Local: Firefox ********/
		if ("FIREFOX".equalsIgnoreCase(browser)) {
			if ("WINDOWS".equalsIgnoreCase(os)) {
				System.setProperty("webdriver.gecko.driver", resourceFolder + os + "/geckodriver.exe");
			} else {
				System.setProperty("webdriver.gecko.driver", resourceFolder + os + "/geckodriver");
			}
			driver = new FirefoxDriver();
		}

		/******** The driver selected is Chrome ********/

		else if ("CHROME".equalsIgnoreCase(browser)) {
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer" });
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("plugins.always_open_pdf_externally", true);
			chromePrefs.put("download.default_directory", downloadDirectory);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			if ("WINDOWS".equalsIgnoreCase(os)) {
				System.setProperty("webdriver.chrome.driver", resourceFolder + os + "/chromedriver.exe");
			} else {
				System.setProperty("webdriver.chrome.driver", resourceFolder + os + "/chromedriver");
			}
			driver = new ChromeDriver();
		}

		/******** The driver selected is Internet Explorer ********/
		else if ("INTERNET EXPLORER".equalsIgnoreCase(browser)) {
			System.setProperty("webdriver.ie.driver", resourceFolder + os + "/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		/******** The driver is not selected ********/
		else {
			log.error("The Driver is not selected properly, invalid name: " + browser + ", " + os);
			return null;
		}

		return driver;
	}

}
