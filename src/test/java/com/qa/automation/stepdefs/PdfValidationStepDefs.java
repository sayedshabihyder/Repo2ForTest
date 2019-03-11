package com.qa.automation.stepdefs;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.testautomationguru.utility.PDFUtil;

import cucumber.api.java.en.Then;

public class PdfValidationStepDefs {
	// private static String properties = "test.properties";
	WebDriver driver;

	/******** Log Attribute ********/
	private static Logger log = Logger.getLogger(PdfValidationStepDefs.class);

	public PdfValidationStepDefs() {
		driver = Hooks.driver;
	}

	PDFUtil pdfUtil = new PDFUtil();

	@Then("User fetch the content of desired page")
	public String getPdfContentPageWise(String pdfPath, int pageNumber) throws IOException {
		String text = pdfUtil.getText(pdfPath, pageNumber);
		return text;
	}

	@Then("^User downloads pdf by clicking on \"([^\"]*)\" on \"([^\"]*)\"$")
	public void downloadPdfFile(String key, String page) throws InterruptedException, DocumentException {
		log.info("Downloading pdf");
		By element = GetORData.getCompleteElement(key, page);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver.findElement(element).click();
		Thread.sleep(8000);
		log.info("Pdf downloaded");

	}

	@Then("^User delete content of folder from location \"([^\"]*)\" $")
	public void clearFolderContent(String location) throws IOException {
		File file = new File(location);
		FileUtils.cleanDirectory(file);
		log.info("Directory content is deleted");
	}

	@Then("^User verify pdf is downloaded in location \"([^\"]*)\"$")
	public void verifyPdfDownloaded(String pdfName, String location) {
		String pdfPath = System.getProperty("user.dir") + location;
		File file = new File(pdfPath);
		File[] fileName = file.listFiles();
		Assert.assertEquals(fileName[0].getName(), pdfName);
		log.info("Pdf" + fileName[0].getName() + "is downloaded");
	}

	@Then("^User verify \"([^\"]*)\" is present in downloaded pdf on location \"([^\"]*)\"$")
	public void verifyTextInPdf(String text, String filePath) throws IOException {
		PDFUtil pdfUtil = new PDFUtil();

		String pdfData = pdfUtil.getText(filePath);
		Assert.assertTrue(pdfData.contains(text));
		log.info("Text" + pdfData + "is available in downloaded pdf");
	}

}