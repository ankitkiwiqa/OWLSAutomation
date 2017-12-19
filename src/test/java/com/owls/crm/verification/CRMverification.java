package com.owls.crm.verification;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.owls.crm.index.CRMIndex;
import com.owls.crm.indexpage.CRMIndexpage;
import com.owls.init.AbstractPage;
import com.owls.init.Common;
import com.owls.utility.CustomeDateConverter;

import ch.qos.logback.classic.pattern.DateConverter;


public class CRMverification extends AbstractPage  {


	public CRMverification(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Method will verify validation error contents 'Documents, Wildlife in possession and convictions'
	 * @return true/false
	 */
	
	@FindBy (xpath=".//span[@id='validation_errors_c']")
	WebElement validationError;
	
	@FindBy(xpath=".//span[@id='validation_errors_c']")
	WebElement validation;

	public boolean verifyValidationError() {
		// TODO Auto-generated method stub
		Common.SwitchtoTab(driver, 2);
		if(!Common.isElementDisplayed(validation))
		{
			driver.navigate().refresh();
		}
		
		return validationError.getText().contains("Documents") || validationError.getText().contains("Wildlife in possession") || validationError.getText().contains("conviction");
		
	}
	/**
	 * Method will verify Current Task for selected Application which will Assert 'Interview / Site Inspection' task available.
	 * @return
	 */
	
	@FindBy (xpath=".//a[contains(text(),'Interview/Site Inspection")
	WebElement interviewTask;
	
	public boolean verifyCurrentTask(String string) {
		// TODO Auto-generated method stub
		String start=".//a[contains(text(),'";
		String end="')]";
		WebElement currentTask=driver.findElement(By.xpath(start+string+end));
		return Common.isElementDisplayed(currentTask);
	}

	@FindBy(xpath = "//div[@id='delegate-screen-panel-body']")
	WebElement expandedinspectionTab;

	/**
	 * Method will verify the Inspection screen is displayed and expanded to the Inspection CRM user.
	 * @return
	 */
	public boolean verifyInspectingOfficerAssessmentTabExpanded() {
		
		Common.waitForElement(driver, expandedinspectionTab);
		Common.pause(5);
		
		return Common.isElementDisplayed(expandedinspectionTab);
 }
	
	@FindBy(xpath=".//*[@id='MassUpdate']/div[3]/table/tbody/tr[1]/td[5]//a")
	WebElement applicationstatus_first;
	
	@FindBy(xpath=".//*[@id='MassUpdate']/div[3]/table/tbody/tr[1]/td[7]//a")
	WebElement applicationRelatedTo;
	
	@FindBy(xpath=".//*[@id='MassUpdate']/div[3]/table/tbody/tr[1]/td[10]")
	WebElement queueName;


	/**
	 * Method will verify whether Approval by delegate task is available.
	 * @param string:"Approval By Delegate" task.
	 * @param applicationSubject
	 * @param Queue name
	 * @return
	 */
	
	public boolean VerifycurrentTaskAndQueue(String applicationStatustoMatch, String ApplicationSubject,
			String applicationQueue) {

		Common.waitForElement(driver, applicationstatus_first);

		String applicationStatus = applicationstatus_first.getText();
		String applicationName = applicationRelatedTo.getText();
		String queue = queueName.getText();

		System.err.println(applicationStatus + " " + "Approval By Delegate");
		System.err.println(applicationName + "=====" + ApplicationSubject);
		System.err.println(queue + "===" + "Wildlife Licensing Queue");
		
		return applicationStatus.contains(applicationStatustoMatch)
				&& applicationName.toLowerCase().contains(ApplicationSubject.toLowerCase())
				&& queue.contains(applicationQueue);

	}


	/**
	 * Method will verify Comment provided by Inspection is displayed correctly to delegate user.
	 * @return boolean
	 */
	
	public boolean verifyInspectionComment(String fileName) {
		// TODO Auto-generated method stub
		String start=".//table[@id='inspecting_officer_screen']//td[contains(text(),'";
		String end="')]";
		String comment=Common.readDataProperties(fileName,"Comment");
		String concern=Common.readDataProperties(fileName,"Concern_Comment");
		System.err.println(Common.readDataProperties(fileName,"Comment")+"\n ========== "+start+comment+end);
		System.err.println(Common.readDataProperties(fileName,"Concerns")+"\n ========== "+start+concern+end);

		WebElement commentText=driver.findElement(By.xpath(start+comment+end));
		WebElement concernsText=driver.findElement(By.xpath(start+concern+end));

		return Common.isElementDisplayed(commentText) && Common.isElementDisplayed(concernsText) ;

	}

	@FindBy(xpath=".//span[@id='everify']//font[contains(text(),'Valid')]")
	WebElement validationMessage;
	
	/**
	 * Method will verify 'Delegate' signature is correctly verified and Delegate Decision is enable to click.
	 * @return boolean
	 */
	public boolean verifyDelegateSign() {
		// TODO Auto-generated method stub
		Actions ac=new Actions(driver);
		ac.moveToElement(validationMessage);
		ac.perform();
		return Common.isElementDisplayed(validationMessage);
	}


	/**
	 * Method will get the current number of permit records from property file and compare it with current permit records.
	 * @return boolean
	 */
	
	@FindBy (xpath=".//*[@id='table-container_info']")
	WebElement records;
	
	public boolean verifyNumberOfPermitRecordss(String fileName) {
		// TODO Auto-generated method stub
		Common.waitForElement(driver, records);
		String[] str=records.getText().split(" ");
		
		System.err.println(" String "+str[(str.length)-2]);
		System.err.println(" Permit property : "+Common.readDataProperties(fileName,"Permit_records"));
		return str[(str.length)-2].equalsIgnoreCase(Common.readDataProperties(fileName,"Permit_records"));
	}
	
	@FindBy (xpath=".//div[@id='myTabs1']//li[text()='Inspections']")
	WebElement inspection_link;
	
	@FindBy (xpath=".//div[@id='inspinner']//tr")
	List<WebElement> table_Row;

	
	@FindBy (xpath=".//div[@id='inspinner']//td[text()='Site Inspection']")
	WebElement method;
	
	public boolean verifyInspectionRecord(String dataFileName) throws ParseException {
		// TODO Auto-generated method stub
		String start=".//div[@id='inspinner']//a[text()='";
		String end="']";
		String end2="//..//..//td[3]";
		Common.log(" Click on 'Inspection Tab'.");
		Common.jsClick(driver, inspection_link);
		Common.pause(5);
		String date=CustomeDateConverter.convertDate(Common.readDataProperties(dataFileName, "Assessment_On"));
		System.err.println("  Date Converted === "+date);
		Common.pause(3);
		WebElement date_record=driver.findElement(By.xpath(start+date+end));
		List<WebElement> comment_table=driver.findElements(By.xpath(start+date+end+end2));
		System.err.println(" Comment value : "+comment_table.get(0).getText());
		
		Common.moveToElementByJs(driver, date_record);
		if(Common.isElementDisplayed(date_record))
		{
			Common.log(" Record Added on Date : "+date);
		}
		
		Common.moveToElementByJs(driver, method);
		if( Common.isElementDisplayed(method))
		{
			Common.log(" Inspection Method : "+method.getText());
		}
		
		System.err.println(" Number of records : "+table_Row.size());
		return (table_Row.size() > 0 && Common.isElementDisplayed(date_record) && Common.isElementDisplayed(method) && comment_table.get(0).getText().contains(Common.readDataProperties(dataFileName, "Comment")));
	}

	@FindBy (xpath=".//table[@id='predefinedtable']//tr")
	List<WebElement> condition_row;

	public boolean verifyTableRowCount() {
		// TODO Auto-generated method stub
		System.err.println("Before  : "+CRMIndexpage.comment_count);
		System.err.println("After : "+ condition_row.size());

		if(CRMIndexpage.comment_count < condition_row.size())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

		
}
	
