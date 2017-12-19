package com.owls.CreateApp.index;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.owls.init.Common;
import com.owls.init.ITestStatus;
import com.owls.init.SeleniumInit;

public class CreateApplicationIndex extends SeleniumInit {

	/**
	 * TestNG's test method contains (annotated with @Test)
	 * 1. Test steps log.
	 * 2. TestNG log [Common.logstep()] which will print in testNG report.
	 * 3. Calling method to indexpage class  and verification class.
	 */
	@Test // pass
	public void SubmitApplication_Wildlife_Basic_Licence() {

		int numOfFailure = 0;
		int logStep = 1;

		Common.logcase("Testcase Id: TC_001 ");
		Common.logcase("Testcase Name: To verify that user is able to submite application to OWLS portal.");

		Common.logstep("Step " + (logStep++) + " : Open url:<a>" + testUrl + "</a>");
		
		Common.logstep((logStep++)+" Enter Username.");
		applicationIndexPage.enterAdminUsername();
		
		Common.logstep((logStep++)+" Enter Password.");
		applicationIndexPage.enterAdminPassword();
		
		Common.logstep((logStep++)+" Click on Login icon.");
		applicationIndexPage.clickonlogin();
		
		Common.logstep((logStep++)+" Click on Personal Menu.");
		applicationIndexPage.clickPersonalMenu();
		
		Common.logstep((logStep++)+" Click on Application Menu.");
		applicationIndexPage.clickonApplication();
		
		Common.logstep((logStep++)+" Click on Create Application button.");
		applicationIndexPage.clickonCreateApplication();
		
		Common.logstep((logStep++)+" Select Application type from Drop down.");
		applicationIndexPage.SelectApplicationType("Wildlife Basic Licence");
		
		Common.logstep((logStep++)+" Click on Next button");
		applicationIndexPage.clickonNext();
		
		Common.logstep((logStep++)+" Select 'Same as above' checkbox'.");
		applicationIndexPage.checkboxSameasAbove();
		
		Common.logstep((logStep++)+" Upload file.");
		applicationIndexPage.UploadFile();
		
		Common.logstep((logStep++)+" Click on submit.");
		applicationIndexPage.clickonSubmit();
		
		Common.logstep((logStep++)+" Navigate to My Application page.");
		applicationIndexPage.clickonApplication();
	
		Common.logverification("Verify that created application is displayed on Apllication list of 'My Application' page.");
		
		if (applicationVerificatioPage.VerifyCreatedApplicationStatus()) {
			logStatus(ITestStatus.PASSED);
		} else {
			logStatus(ITestStatus.FAILED);
			numOfFailure++;
		}

		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		}

	}

	
	@Test // pass
	public void SubmitApplication_Wildlife_Specimen_Licence() {

		int numOfFailure = 0;
		int logStep = 1;

		Common.logcase("Testcase Id: TC_002 ");
		Common.logcase("Testcase Name: To verify that user is able to submite application for 'Wildlife Specimen Licence'.");

		Common.logstep("Step " + (logStep++) + " : Open url:<a>" + testUrl + "</a>");
		
		Common.logstep((logStep++)+" Enter Username.");
		applicationIndexPage.enterAdminUsername();
		
		Common.logstep((logStep++)+" Enter Password.");
		applicationIndexPage.enterAdminPassword();
		
		Common.logstep((logStep++)+" Click on Login icon.");
		applicationIndexPage.clickonlogin();
		
		Common.logstep((logStep++)+" Click on Personal Menu.");
		applicationIndexPage.clickPersonalMenu();
		
		Common.logstep((logStep++)+" Click on Application Menu.");
		applicationIndexPage.clickonApplication();
		
		Common.logstep((logStep++)+" Click on Create Application button.");
		applicationIndexPage.clickonCreateApplication();
		
		Common.logstep((logStep++)+" Select Application type from Drop down.");
		applicationIndexPage.SelectApplicationType("Wildlife Specimen Licence");
	
		Common.logstep((logStep++)+" Click on Next button");
		applicationIndexPage.clickonNext();
		
		Common.logstep((logStep++)+" Select 'Same as above' checkbox'.");
		applicationIndexPage.checkboxSameasAbove();
		
		Common.logstep((logStep++)+" Select 'Do you have any wildlife in your possession at the time of this application?' to YES.");
		applicationIndexPage.HaveanyWildInPossession();
		
		Common.logstep((logStep++)+" Enter 'Licence Number'.");
		applicationIndexPage.enterLicenceNumber();
		
		Common.logstep((logStep++)+" Select 'Species'.");
		applicationIndexPage.selectSpecies();
		
		Common.logstep((logStep++)+" Enter number of species.");
		applicationIndexPage.enterNumberofSpecies();
		
		Common.logstep((logStep++)+"Select Species description (Alive/Dead)");
		applicationIndexPage.selectspeciesDiscription();
		
		Common.logstep((logStep++)+" Click on 'Add Species' button");
		applicationIndexPage.clickonAddSpecies();
		
		Common.logstep((logStep++)+" Upload file.");
		applicationIndexPage.UploadFile();
		
		Common.logstep((logStep++)+" Click on submit.");
		applicationIndexPage.clickonSubmit();
		
		Common.logstep((logStep++)+" Navigate to My Application page.");
		applicationIndexPage.clickonApplication();
	
		Common.logverification("Verify that created application is displayed on Apllication list of 'My Application' page.");
		
		if (applicationVerificatioPage.VerifyCreatedApplicationStatus()) {
			logStatus(ITestStatus.PASSED);
		} else {
			logStatus(ITestStatus.FAILED);
			numOfFailure++;
		}

		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		}
	}
	
	@Test // pass
	public void verifyCreateApplication() {

		int numOfFailure = 0;
		int logStep = 1;

		Common.logcase("Testcase Id: TC_Portal_001 ");
		Common.logcase("Testcase Name: To verify that Online User submits a basic application with a condition which will trigger review of the application.");

		Common.logstep("Step " + (logStep++) + " : Open url:<a>" + testUrl + "</a>");
		
		Common.logstep((logStep++)+" Enter Username.");
		applicationIndexPage.enterAdminUsername();
		
		Common.logstep((logStep++)+" Enter Password.");
		applicationIndexPage.enterAdminPassword();
		
		Common.logstep((logStep++)+" Click on Login icon.");
		applicationIndexPage.clickonlogin();
		
		Common.logstep((logStep++)+" Click on Personal Menu.");
		applicationIndexPage.clickPersonalMenu();
		
		Common.logstep((logStep++)+" Click on Details Menu.");
		applicationVerificatioPage=applicationIndexPage.clickonDetails();		
		
		Common.logstep((logStep++)+" Click on Contact Details Option.");
		applicationVerificatioPage=applicationIndexPage.clickonContactDetail();		
	
		Common.logstep((logStep++)+" Click on Application Menu.");
		applicationIndexPage.clickonApplication();
		
		Common.logstep((logStep++)+" Click on Create Application button.");
		applicationIndexPage.clickonCreateApplication();
		
		Common.logstep((logStep++)+" Select Application type from Drop down.");
		applicationIndexPage.SelectApplicationType("Wildlife Basic Licence");
	
		Common.logstep((logStep++)+" Click on Next button");
		applicationIndexPage.clickonNext();
		
		Common.logverification("Verify Operating Address retrived correctly from User's Contact Details->Primary Address.");
		if(applicationVerificatioPage.verifyOperatingAddress()) {
			Common.assertPassed("Operating address retrived correctly from Contact Details.");;
		}else {
			Common.assertFailed("Operating address is incorrect as compare to Contact Details.");
			numOfFailure++;
		}
		
		Common.logstep((logStep++)+" Select 'Same as above' checkbox'.");
		applicationIndexPage.checkboxSameasAbove();
		
		Common.logverification("Verify Postal Address pasted correctly as same as Specified Premises.");
		if(applicationVerificatioPage.verifyPostalAddress()) {
			Common.assertPassed("Postal Address verified");;
		}else {
			Common.assertFailed("Postal Address incorrect ! Please take a look");
			numOfFailure++;
		}
		
		
		Common.logstep((logStep++)+" Select 'I have prior convictions' radio button and enter offence details as below.");
		applicationIndexPage.ClickonIHavepriorConviction();
		  
		  String offence = Common.generateRandomChars(10);
		  appdata.setOffenceName(offence);
		  String offenceYear = String.valueOf(Common.randBetween(2000, 2016));
		  appdata.setOffenceYear(offenceYear);
		  String offenceState="VIC";
		  appdata.setOffencestate(offenceState);
		  
		  Common.log("Offence: "+offence);
		  Common.log("Offence Year: "+offenceYear);
		  Common.log("Offence State: "+offenceState);
		  
		  applicationIndexPage.EnterOffenceDetails(offence,offenceYear,offenceState);
		  
		  applicationIndexPage.clickonAddpriorConvictionsButton();
		  
		  Common.logverification("Verify that Conviction data should be displayed below conviction form.");
		  if (applicationVerificatioPage.VerifyAddedConvictiondata(offence,offenceYear,offenceState)) {
		   logStatus(ITestStatus.PASSED);
		  } else {
		   logStatus(ITestStatus.FAILED);
		   numOfFailure++;
		  }
		
		Common.logstep((logStep++)+" Select 'Do you have any wildlife in your possession at the time of this application?' to YES.");
		applicationIndexPage.HaveanyWildInPossession();
		
		Common.logstep((logStep++)+" Enter 'Licence Number'.");
		applicationIndexPage.enterLicenceNumber();
		
		Common.logstep((logStep++)+" Select 'Species'.");
		applicationIndexPage.selectSpecies();
		
		Common.logstep((logStep++)+" Enter number of species.");
		applicationIndexPage.enterNumberofSpecies();
		
		Common.logstep((logStep++)+"Select Species description (Alive/Dead)");
		applicationIndexPage.selectspeciesDiscription();
		
		Common.logstep((logStep++)+" Click on 'Add Species' button");
		applicationIndexPage.clickonAddSpecies();
		
		Common.logverification("Verify that if User has selected any wildlife possession at the time of application persisted in the Species Table");
		
		if(applicationVerificatioPage.verifySpeciesTable()) {
			Common.assertPassed("Wildlife possession species adeed at the time of application submition are persisted correctly in Species Table.");;
		}else {
			Common.assertFailed("Wildlife possession species adeed at the time of application submition are not persisted in Species Table! Please take a look.");
			Common.makeScreenshot(driver, "incorrectSpeciesTable");
			numOfFailure++;
		}
		
		Common.logstep((logStep++)+" Upload file.");
		applicationIndexPage.UploadFile();
		
		Common.logverification("Verify that Uploaded file persisted in 'Uploaded Documents Table.'");
		
		if(applicationVerificatioPage.verifyUploadedDocument()) {
			Common.assertPassed("All the uploaded documents are available in 'Uploaded Documents Table.'");;
		}else {
			Common.assertFailed("Uploaded Documents are not persisted in 'Uploaded Documents Table! Please take a look.");
			Common.makeScreenshot(driver, "incorrectDocumentTable");
			numOfFailure++;
		}
		
		Common.logstep((logStep++)+" Click on submit.");
		applicationIndexPage.clickonSubmit();
		
		Common.logstep((logStep++)+" Navigate to My Application page.");
		applicationIndexPage.clickonApplication();
	
		Common.logverification("Verify that created application is displayed on Apllication list of 'My Application' page.");
		
		if (applicationVerificatioPage.VerifyCreatedApplicationStatus()) {
			Common.writeProperties("Application_Created_Sucessfully","True"," ");
			logStatus(ITestStatus.PASSED);
		} else {
			Common.writeProperties("Application_Created_Sucessfully","False"," ");

			logStatus(ITestStatus.FAILED);
			numOfFailure++;
		}

		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		}
	}
	
	
	@Test // pass
	public void verifyPaymentNoticeAndAwaitingTask() throws IOException {

		int numOfFailure = 0;
		int logStep = 1;

		Common.logcase("Testcase Id: TC_Portal_001 ");
		Common.logcase("Testcase Name: To verify that user is able to submite application to OWLS portal.");

		Common.logstep("Step " + (logStep++) + " : Open url:<a>" + testUrl + "</a>");
		
		Common.logstep((logStep++)+" Enter Username.");
		applicationIndexPage.enterAdminUsername();
		
		Common.logstep((logStep++)+" Enter Password.");
		applicationIndexPage.enterAdminPassword();
		
		Common.logstep((logStep++)+" Click on Login icon.");
		applicationIndexPage.clickonlogin();
		
		Common.logstep((logStep++)+" Click on Personal Menu.");
		applicationIndexPage.clickPersonalMenu();
		
		Common.logstep((logStep++)+" Click on Application Menu.");
		applicationIndexPage.clickonApplication();
		
		Common.logverification("Verify that 'Payment Notice' and 'Pay Fee' Links are available for Payment Pending Application.");
		
		if(applicationVerificatioPage.verifyPaymentPendingApplication()) {
			Common.assertPassed("'Payment Notice' and 'Pay Fee' links are available.");;
		}else {
			Common.assertFailed("Something went wrong! Please take a look.");
			Common.makeScreenshot(driver, "missingPaymentNotice.png");
			numOfFailure++;
		}
		
		Common.logstep((logStep++)+" Click on Payment Notice link to download Payment Notice PDF.");
		applicationIndexPage.clickonPaymentNotice();
		
		String pdfURL="file:///G:/KiwiQA%20Automation%20Projects/OWLS_Automation/Resource/Downloads/OWLS%20Payment%20Notice%20(Application)Template.pdf";
		
		Common.switchToNewtabWithUrl(driver, pdfURL);
		URL url=new URL	(driver.getCurrentUrl());
		
		BufferedInputStream fileToParse=new BufferedInputStream (url.openStream());
/*		PDFReader reader = new PDFReader(new File("my.pdf"));
*/
	}
	
}
	
