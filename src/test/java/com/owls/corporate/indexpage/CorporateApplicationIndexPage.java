package com.owls.corporate.indexpage;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.owls.CreateApp.verification.CreateApplicationVerificationPage;
import com.owls.init.AbstractPage;
import com.owls.init.Common;
import com.owls.init.TestData;
import com.owls.utility.ContactAddressDetails;
import com.owls.utility.PostalAddressDetails;
import com.owls.utility.WildlifePossession;
/**
 * Indexpage class contains 
 * 1. Element Locators ( @FindBy(xpath = "//input[@id='edit-name']") WebElement txtUserName;
 * 2. Logic of 
 */

public class CorporateApplicationIndexPage extends AbstractPage {

	
	
	public CorporateApplicationIndexPage(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Method will fill all the operating address details.
	 */

	@FindBy (id="edit-operating-address-street")
	WebElement addressText;
	
	@FindBy (xpath=".//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content'][1]/li[1]")
	WebElement firstAddressOption;
		
	public void completeOperatingDetails(String fileName) {
		// TODO Auto-generated method stub
	
		Common.type(addressText, "32 QUEENS ROAD");
		Common.pause(5);
		Common.type1(addressText, ""+Keys.BACK_SPACE);
		Common.pause(5);
		String Operatingaddress[]=firstAddressOption.getText().split(" ");
		Common.clickOn(driver, firstAddressOption);
		String address=Operatingaddress[0]+" "+Operatingaddress[1]+" "+Operatingaddress[2];
		Common.log("Address :"+address);
		Common.writeDataProperties(fileName, "Primary_Address", address, "");
		
		String city=Operatingaddress[3];
		Common.log("City/Town/Suburb :"+city);
		Common.writeDataProperties(fileName, "City", city, "");
		
		String postCode=Operatingaddress[4];
		Common.log("Postcode :"+postCode);
		Common.writeDataProperties(fileName, "PostCode", postCode, "");
		
		Common.pause(5);	
	}
	
	@FindBy (xpath=".//input[@id='edit-accounts-abn-c']")
	WebElement abnTextbox;
	
	public void abnNumber() {
		// TODO Auto-generated method stub
		String abn="40 507 469 599";
		Common.type(abnTextbox, abn+Keys.TAB);
		Common.pause(5);
		Common.log("ABN Number :"+abn);
	}

	@FindBy (xpath=".//input[@id='edit-accounts-trading-name-c']")
	WebElement traderNameTextbox;
	public void tradingName() {
		// TODO Auto-generated method stub
		String name=Common.generateRandomChars(5);
		Common.type(traderNameTextbox, "TraderName_"+name);
		Common.log("Trader Name :"+"TraderName_"+name);	
	}
	
	@FindBy (xpath=".//input[@id='edit-business-telephone-number-c']")
	WebElement primaryBusinessTelephone;
	
	public void primaryBusinessTelephone(String dataFileName) {
		// TODO Auto-generated method stub
		String number=String.valueOf(Common.generateRandomNumeric(6));
		Common.type(primaryBusinessTelephone, "1800"+number);
		Common.log("Primary Business Telephone : "+number);	
		Common.writeDataProperties(dataFileName, "Business_Telephone", number, "");
	}
	
	@FindBy (xpath=".//input[@id='edit-business-other-number-c']")
	WebElement otherNumber;

	public void otherBusinessTelephone(String dataFileName) {
		// TODO Auto-generated method stub
		String number=String.valueOf(Common.generateRandomNumeric(6));
		Common.type(otherNumber, number);
		Common.log(" Other Business Telephone :"+number);
		Common.writeDataProperties(dataFileName, "Other_Business_Telephone",number,	"");
	}
	
	@FindBy (xpath=".//input[@id='edit-business-email-c']")
	WebElement businessEmail;

	public void corporateEmailAddress(String dataFileName) {
		// TODO Auto-generated method stub
		String email=Common.generateRandomChars(8);
		
		email=(email+"@mailinator.com").toLowerCase().toString();
		Common.type(businessEmail, email);
		Common.log(" Business Email :"+email);
		Common.writeDataProperties(dataFileName, "Business_Email",email	,"");
	}
	
	@FindBy (xpath=".//input[@id='edit-business-website-c']")
	WebElement businessWebsite;

	public void website(String dataFileName) {
		// TODO Auto-generated method stub
		Common.type(businessWebsite, "www.mailinator.com");
		Common.log(" Business Website :"+"www.mailinator.com");
		Common.writeDataProperties(dataFileName, "Business_Website", "www.mailinator.com", "");
	}
	
	@FindBy (xpath=".//input[@id='edit-owls-nominated-lpa-holders-first-name-c']")
	WebElement firstName;

	public void firstName(String dataFileName) {
		// TODO Auto-generated method stub
		String fname="FNAME"+Common.generateRandomChars(4);
		Common.type(firstName, fname);
		Common.log("First Name :"+fname);
		Common.writeDataProperties(dataFileName, "Employee_First_Name", fname, "");
	}
	
	@FindBy (xpath=".//input[@id='edit-owls-nominated-lpa-holders-last-name-c']")
	WebElement lastName;

	public void lastName(String dataFileName) {
		// TODO Auto-generated method stub
		String lname="LNAME"+Common.generateRandomChars(4);
		Common.type(lastName, lname);
		Common.log("Last Name :"+lname);
		Common.writeDataProperties(dataFileName, "Employee_Last_Name", lname, "");
	}
	
	@FindBy (xpath=".//input[@id='edit-owls-nominated-lpa-holders-dob-c']")
	WebElement dateOfBirth;

	public void dateOfBirth(String dataFileName) {
		// TODO Auto-generated method stub
		Common.type(dateOfBirth, "10-04-1994");
		Common.log(" Date of Birth :"+"10-04-1994");
		Common.writeDataProperties(dataFileName, "Date_of_Birth", "10-04-1994", "");
	}
	
	@FindBy (xpath=".//input[@id='edit-owls-nominated-lpa-holders-contact-number-c']")
	WebElement privateNumber;

	public void privateTelephone(String dataFileName) {
		// TODO Auto-generated method stub
		/**
		 * Error in Private Mobile Number.
		 */
		String n1=(String)Common.generateRandomNumeric(2);
		String n2=(String)Common.generateRandomNumeric(4);
		String n3=(String)Common.generateRandomNumeric(4);
		Common.type(privateNumber, n1+" "+n2+" "+n3);
		Common.log("Private Home Telephone Number :"+n1+" "+n2+" "+n3);	
		Common.writeDataProperties(dataFileName, "Private_Telephone_number", n1+" "+n2+" "+n3, "");
	}
	
	@FindBy (xpath=".//input[@id='edit-owls-nominated-lpa-holders-start-date-c']")
	WebElement startDate;
	
	public void startDate(String dataFileName) {
		// TODO Auto-generated method stub
		Common.type(startDate, "10-04-2014");
		Common.log(" Start Date :"+"10-04-2014");
		Common.writeDataProperties(dataFileName, "Start_Date", "10-04-2014"	, "");
	}

	@FindBy (id="edit-owls-nominated-lpa-holders-role-position-c")
	WebElement roleDesignation;
	
	public void roleofEmployee(String dataFileName) {
		// TODO Auto-generated method stub
		Common.type(roleDesignation, "Test Manager");
		Common.log(" Role / Designation :"+"Test Manager");
		Common.writeDataProperties(dataFileName, "Employee_Role", "Test Manager", "");
	}
	
	@FindBy (id="edit-owls-nominated-lpa-holders-street-address-c")
	WebElement streetAddress;

	@FindBy (xpath=".//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content'][3]/li[1]")
	WebElement firstOption;
	
	public void enterStreetAddress(String dataFileName) {
		// TODO Auto-generated method stub
		Common.type(streetAddress, "32 QUEEN CIRCUIT");
		Common.pause(5);
		Common.type1(streetAddress, ""+Keys.BACK_SPACE);
		Common.pause(5);	
		Common.clickOn(driver, firstOption);
		String addressSelected=firstOption.getText();
		Common.log("Selected Address :"+addressSelected);
		Common.pause(5);	
		Common.writeDataProperties(dataFileName, "Employee_address", firstOption.getText(), "");
	}
	
	@FindBy (xpath=".//input[@id='edit-owls-nominated-lpa-holders-email-address-c']")
	WebElement businessEmailAddress;

	public void businessEmail(String dataFileName) {
		// TODO Auto-generated method stub
		String email="Salse"+Common.generateRandomNumeric(3)+"@mailinator.com";
		Common.type(businessEmailAddress, email);
		Common.log("Business Email address :"+email);
		Common.writeDataProperties(dataFileName, "Business_email", email, "");
	}
	
	@FindBy (xpath=".//input[@id='edit-update-employee']")
	WebElement addEmployee;

	public void clickOnAddtoList() {
		// TODO Auto-generated method stub
		Common.jsClick(driver, addEmployee);
		//Common.clickOn(driver, addEmployee);
		Common.pause(1);
	}

	@FindBy (xpath=".//label[@class='option'][contains(text(),'YES')]")
	WebElement yesOption;
	
	public void chooseYes() {
		// TODO Auto-generated method stub
		Actions ac=new Actions(driver);
		ac.moveToElement(yesOption).click();
		ac.build().perform();
		Common.pause(1);
	}
	
	@FindBy (xpath=".//label[contains(@for,'edit-common')]")
	List<WebElement> serviceControl;

	public void controlService() {
		// TODO Auto-generated method stub
		System.err.println(" Number of services : "+serviceControl.size());
		int n=Common.randBetween(0, 1);
		for(int i=0;i <=n ;i++)
		{
			Common.jsClick(driver, serviceControl.get(i));
		
			Common.log("Selected Service "+i+" :"+serviceControl.get(i).getText());
			Common.pause(1);
		}
	}
	
	@FindBy (xpath=".//div[@id='edit-preferred-regions-c']//label")
	List<WebElement> regionList;
	
	public void randomRegion() {
		// TODO Auto-generated method stub
		int n=Common.randBetween(0, 4);
		for(int i=0;i <=n ;i++)
		{
			Common.jsClick(driver, regionList.get(i));
			//Common.clickOn(driver,);
			Common.log("Selected Service "+i+" :"+regionList.get(i).getText());
			Common.pause(1);
		}
	}
	
	@FindBy (xpath=".//input[@name='document_file[]']")
	List<WebElement> uploadFiles;
	public static String fileName="TestUpload.pdf";

	
	public void UploadFiles() {
		// TODO Auto-generated method stub
		
		for(WebElement upload:uploadFiles)
		{
			File uploadDocument = new File("Resource\\"+fileName);
			//upload = driver.findElement(By.xpath(".//input[@name='document_file[]']"));
			System.err.println(" Dingo file will upload ... ");
			  JavascriptExecutor je = (JavascriptExecutor)driver;
			  String js = "arguments[0].style.visibility='visible';";
			  je.executeScript(js,upload);
			  upload.sendKeys(uploadDocument.getAbsolutePath());
		}
	}

	@FindBy (xpath=".//span[text()='Corporate']")
	WebElement corporateMenuOption;

	public void clickOnCorporate() {
		// TODO Auto-generated method stub
		Common.clickOn(driver, corporateMenuOption);
		Common.pause(1);
	}
	
	@FindBy (xpath=".//div[@id='block-portalbodycoporatemenu']//span[contains(text(),'THE SCOUT ASSOCIATION')]")
	WebElement bodyCorporate;

	public void selectBodyCorporate(String fileName) {
		// TODO Auto-generated method stub
		Common.clickOn(driver, bodyCorporate);
		Common.log("Selected Body Corporate Name : "+bodyCorporate.getText());
		Common.writeDataProperties(fileName, "Body_Corporate_Name", bodyCorporate.getText(), "");
		Common.pause(1);
		
	}
	
	@FindBy (xpath=".//div[@id='block-portalbodycoporatemenu']//span[text()='Application']")
	List<WebElement> corporateApplication;

	public void clickonCorporateApplication() {
		// TODO Auto-generated method stub
		Common.clickOn(driver, corporateApplication.get(0));
		Common.pause(2);
	}
	
	@FindBy (xpath=".//label[@for='edit-owls-nominated-lpa-holders-nominated-responsible-person-checkbox']")
	WebElement nominatedOption;
	
	public void chooseNominatedOption() {
		// TODO Auto-generated method stub
		Common.jsClick(driver, nominatedOption);
		Common.pause(2);
	}
	
	@FindBy (xpath=".//label[contains(text(),'Yes')]")
	WebElement yesOptionEelement;

	public void chooseYesOption() {
		// TODO Auto-generated method stub
		Common.clickOn(driver, yesOptionEelement);
		Common.pause(1);
	}
	
	
	
}


