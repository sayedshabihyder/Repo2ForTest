package com.qa.automation.stepdefs;

import java.io.*;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

public class GetORData {

	public static String getSelectorFromProperties(String key, String page) throws DocumentException {
		// System.out.println("key is "+key);
		String value = null;
		String type = null;
		String finalValue = null;
		// Reading XML File
		File inputFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\selectors\\OR.xml");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputFile);
		List<Node> nodes = document.selectNodes("Page/" + page + "/object");
		for (Node node : nodes) {

			if (node.valueOf("@name").equalsIgnoreCase(key)) {

				value = node.selectSingleNode("value").getText();

				type = node.selectSingleNode("type").getText();

				finalValue = type + " :" + value;

			}

		}

		return finalValue;

	}

	public static By getCompleteElement(String key, String page) throws DocumentException {
		By result;
		String selector = getSelectorFromProperties(key, page);
		if (selector == null) {
			throw new NotFoundException("Object " + key + " Not Found");

		}
		System.out.println("selector value reurned is " + selector);
		String locatorType = selector.split(" :")[0];
		String locatorValue = selector.split(" :")[1];
		switch (locatorType) {
		case "className":
			result = By.className(locatorValue);
			break;
		case "cssSelector":
			result = By.cssSelector(locatorValue);
			break;
		case "id":
			result = By.id(locatorValue);
			break;
		case "linkText":
			result = By.linkText(locatorValue);
			break;
		case "name":
			result = By.name(locatorValue);
			break;
		case "partialLinkText":
			result = By.partialLinkText(locatorValue);
			break;
		case "tagName":
			result = By.tagName(locatorValue);
			break;
		case "xpath":
			result = By.xpath(locatorValue);
			break;
		default:
			throw new IllegalArgumentException("By type " + locatorType + " is not found.");
		}
		return result;
	}

}