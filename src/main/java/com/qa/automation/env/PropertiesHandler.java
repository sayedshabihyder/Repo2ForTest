package com.qa.automation.env;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;



public class PropertiesHandler {

	private static String properties = "keyboardevents.properties";
    private static Properties selectorProp = new Properties();
    private static InputStream in = WebDriverFactory.class.getResourceAsStream("/keyboardevents.properties");    
    static String selector;
    
    /******** Log Attribute ********/
    private static Logger log = Logger.getLogger(PropertiesHandler.class);
    
    private PropertiesHandler(){
    	
    }
    
    /**
     * Get the selector of a properties file with its key.
     */
     public static int getSelectorFromProperties(String key){
        try {
        	log.info("***********************************************************************************************************");
        	log.info("[ Properties Configuration ] - Read the selector properties from: " + properties);
        	selectorProp.load(in);
        	selector = selectorProp.getProperty(key);
            
        } catch (IOException e) {
        	log.error("getSelectorFromProperties Error", e);
        }
        
        return Integer.parseInt(selector);
    }
}
