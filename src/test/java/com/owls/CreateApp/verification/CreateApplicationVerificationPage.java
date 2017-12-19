package com.owls.CreateApp.verification;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.owls.CreateApp.indexpage.CreateApplicationIndexPage;
import com.owls.init.AbstractPage;
import com.owls.init.Common;
import com.owls.utility.ContactAddressDetails;
import com.owls.utility.PostalAddressDetails;
import com.owls.utility.WildlifePossession;

public class CreateApplicationVerificationPage extends AbstractPage{
	
	public static String applicationURL="";

	public CreateApplicationVerificationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement btnLogout;

	public boolean VerifyAdminLogin() {

		boolean bool = false;
		Common.waitForElement(driver, btnLogout);
		if(Common.isElementDisplayed(btnLogout))
		{
		
			bool = true;
		}

		return bool;
	}
	
	@FindBy(xpath = "//table//tbody//tr[1]/td[3]/a")
	WebElement ApplicationStatus;
	
	 @FindBy(xpath="//table//tbody//tr[1]/td[2]/a")
	 WebElement applicationName;
	
	public boolean VerifyCreatedApplicationStatus() {
	
		Common.writeDataProperties("ApplicationName", applicationName.getText(), "Store Application Subject ");

		return ApplicationStatus.getAttribute("href").contains(applicationURL) 
				&& ApplicationStatus.getText().contains("In Progress");
		
	}
	
	/*
	 * Method to verify Specified Permises and Postal address pasted correctly upon selecting "SAME AS ABOVE option
	 * */
	
	@FindBy (xpath=".//input[@id='edit-operating-address-street']")
	WebElement operatingAddressStreet;
	
	@FindBy (xpath=".//input[@id='edit-operating-address-city']")
	WebElement operatingCity;

	@FindBy (xpath=".//input[@id='edit-operating-address-state']")
	WebElement operatingState;
	
	@FindBy (xpath=".//input[@id='edit-operating-address-postalcode']")
	WebElement operatingPostcode;

	public boolean verifyOperatingAddress() {
		// TODO Auto-generated method stub
		
		System.err.println(ContactAddressDetails.getPrimaryAddress()+"--"+ContactAddressDetails.getPrimaryPostcode()+"--"+ContactAddressDetails.getPrimaryState()+"--"+ContactAddressDetails.getPrimaryCity());
		System.out.println(operatingAddressStreet.getAttribute("value")+operatingCity.getAttribute("value")+operatingState.getAttribute("value")+operatingPostcode.getAttribute("value"));
		
		if (ContactAddressDetails.primaryAddress.equalsIgnoreCase(operatingAddressStreet.getAttribute("value"))
				&& ContactAddressDetails.primaryCity.equalsIgnoreCase(operatingCity.getAttribute("value"))
				&& ContactAddressDetails.primaryState.equalsIgnoreCase(operatingState.getAttribute("value"))
				&& ContactAddressDetails.primaryPostcode.equalsIgnoreCase(operatingPostcode.getAttribute("value")))
		{
			return true;
		}
		else
			return false;
	}
	
	/*
	 * Method to verify 'Same as Above' checkboxe  functionality.
	 * 
	 * */
	
	public boolean verifyPostalAddress() {
		// TODO Auto-generated method stub
		
		if(PostalAddressDetails.getPostalAddress().equalsIgnoreCase(operatingAddressStreet.getAttribute("value"))
				&& PostalAddressDetails.getPostalCity().equalsIgnoreCase(operatingCity.getAttribute("value"))
				&& PostalAddressDetails.getPostalState().equalsIgnoreCase(operatingState.getAttribute("value"))
				&& PostalAddressDetails.getPostalPostcode().equalsIgnoreCase(operatingPostcode.getAttribute("value")))
		{
			return true;
		}else
			return false;
	}
	
	/*
	 * Method will verify species added at the time of application are persisted correctly in Species table. 
	 * 
	 * */			
	
	
	public boolean verifySpeciesTable() {
		// TODO Auto-generated method stub
		
		WebElement speciesLineItem=driver.findElement(By.xpath("//*[@id='edit-owls-number-of-species-table']//span[text()='"+WildlifePossession.getSpecies()+"']"));
		WebElement speciesNumber=driver.findElement(By.xpath("//*[@id='edit-owls-number-of-species-table']//span[text()='"+WildlifePossession.getSpecies()+"']//..//..//td[3]//span"));
		WebElement speciesAlive_Dead=driver.findElement(By.xpath("//*[@id='edit-owls-number-of-species-table']//span[text()='"+WildlifePossession.getSpecies()+"']//..//..//td[4]//span"));
		
		if(speciesLineItem.isDisplayed() &&speciesNumber.getText().equalsIgnoreCase(WildlifePossession.getNumber())
				&& speciesAlive_Dead.getText().equalsIgnoreCase(WildlifePossession.getAlive_dead()))
		{
			return true;
		}
		else
			return false;
				
	}
	/**
	 * 
	 * verifyUploadedDocument will verify uploaded document table that document are uploaded correctly. 
	 * @return whether Document uploaded are persisted in Uploaded Document Table. 
	 */
	
	public boolean verifyUploadedDocument() {
		// TODO Auto-generated method stub
		WebElement docName=driver.findElement(By.xpath(".//td//span[contains(text(),'"+CreateApplicationIndexPage.fileName+"')]"));
		if(docName.isDisplayed())
			return true;
		else
				return false;
	}
	
	@FindBy(xpath="//table[@id='edit-owls-convictions-table']//tbody/tr[2]//span[contains(@data-get-to,'convictions')]")
	 List<WebElement> addedConvictiondata;
	 
	 public boolean VerifyAddedConvictiondata(String offence, String offenceYear, String offenceState) {
	  
	  if(addedConvictiondata.get(0).getText().toLowerCase().contains(offence.toLowerCase()) && 
	    addedConvictiondata.get(1).getText().toLowerCase().contains(offenceYear.toLowerCase()) &&
	    addedConvictiondata.get(2).getText().toLowerCase().contains(offenceState.toLowerCase()))
		  return true;
	  else
		  return false;
	 }

	 /**
	  * Method will verify that 'Pay Fee' and 'Payment Notice' links are available for pending payment application.
	  * @return
	  */
	 
	 @FindBy (xpath="//a[text()='Payment Pending']//..//..//a[text()='Pay Fee']")
	 WebElement payFee;
	 
	 @FindBy (xpath="//a[text()='Payment Pending']//..//..//a[text()='Payment Notice']")
	 WebElement paymentNotice;
	 
	public boolean verifyPaymentPendingApplication() {
		// TODO Auto-generated method stub
		return Common.isElementDisplayed(payFee) && Common.isElementDisplayed(paymentNotice);
	}

	
	 
}
