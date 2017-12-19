package com.owls.crm.index;




import javax.activation.CommandMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.beust.testng.TestNG;
import com.owls.init.Common;
import com.owls.init.ITestStatus;
import com.owls.init.SeleniumInit;
import com.owls.init.TestData;

public class CRMIndex extends SeleniumInit {

	/**
	 * TestNG's test method contains (annotated with @Test)
	 * 1. Test steps log.
	 * 2. TestNG log [Common.logstep()] which will print in testNG report.
	 * 3. Calling method to indexpage class  and verification class.
	 */
	@Test(alwaysRun=true)
	public void validateReviewAppliactionTask() {

		int numOfFailure = 0;
		int logStep = 1;
		
		Common.logcase("Testcase Id: TC_CRM_001");
		Common.logcase("Testcase Name: To verify submitted Application workflow for application having Convictions and wildlife possession.");
		Assert.assertTrue(true);
		String Application_Created = Common.readProperties("Application_Created_Sucessfully");
		
		if(Application_Created.contains("False"))
		{
			throw new SkipException("Skipping Test case as Application is not created in portal.");
		}

		Common.logstep("Step " + (logStep++) + " : Open portal url:<a>" + testUrl + "</a>");
		appdata.setApplicationSubject(Common.readDataProperties("ApplicationName"));
		
		Common.logstep("Step " + (logStep++) + " : Open CRM url:<a>" + TestData.getCRMURL() + "</a>");
		Common.switchToNewtabWithUrl(driver,TestData.getCRMURL());
		
		Common.logstep("Step " + (logStep++) + " Choose 'Standard Authentication' login method from Drop down.");
		crmpage.chooseLoginMethod();
		Common.pause(5);
		Common.logstep("Step " + (logStep++) + " Login to CRM as admin");
		crmpage.enterCRMUsername(TestData.getCRMUsername());
		Common.pause(1);
		crmpage.enterCRMPassword(TestData.getCRMPassword());
		Common.pause(1);
		crmpage.clickonCRMLoginbutton();
		
		Common.logstep("Step " + (logStep++) + " Advance search filter feeding with Application Name.");
		crmpage.advanceSearchForApplicationTask();
		
		Common.logverification("Verify that Task status should be 'Review Application' ");
		if (crmverify.VerifycurrentTaskAndQueue("Review Application",appdata.getApplicationSubject(),"Wildlife Licensing Queue")) {
			logStatus(ITestStatus.PASSED);
			Common.writeProperties("Task_status_Review_Application", "True", "");
		} else {
			logStatus(ITestStatus.FAILED);
			numOfFailure++;
			Common.writeProperties("Task_status_Review_Application", "False", "");
		}
		
		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(alwaysRun=true)
	public void completeReviewApplicationTask() {

		int numOfFailure = 0;
		int logStep = 1;
		
		Common.logcase("Testcase Id: TC_CRM_002 ");
		Common.logcase("Testcase Name: To verify user can complete 'Review Application Task' and take the workflow to 'Interview/Site Inspection'.");

		//String Conviction_assertion = Common.readProperties("Conviction_data_added_Sucessfully");
		try {
			String Application_Created = Common.readProperties("Task_status_Review_Application");
			
			if(Application_Created.contains("False"))
			{
				throw new SkipException("Skipping Test case as task status is not 'Review Application'.");
			}
		} catch (Exception e) {
			throw new SkipException("Skipping Test case as task status is not 'Review Application'.");
		}
		
		appdata.setApplicationSubject(Common.readDataProperties("ApplicationName"));
		
		Common.logstep("Step " + (logStep++) + " : Open CRM url:<a>" + TestData.getCRMURL() + "</a>");
		Common.switchToNewtabWithUrl(driver,TestData.getCRMURL());
		
		Common.logstep("Step " + (logStep++) + " Choose 'Standard Authentication' login method from Drop down.");
		crmpage.chooseLoginMethod();
		Common.pause(5);
		Common.logstep("Step " + (logStep++) + " Login to CRM as admin");
		crmpage.enterCRMUsername(TestData.getCRMUsername());
		Common.pause(1);
		crmpage.enterCRMPassword(TestData.getCRMPassword());
		Common.pause(1);
		crmpage.clickonCRMLoginbutton();
		
		Common.logstep("Step " + (logStep++) + " Feed the advance search options and filter current application :"+appdata.getApplicationSubject());
		crmpage.advanceSearchForApplicationTask();
		
		Common.logstep("Step " + (logStep++) + " Click on Action link of "+appdata.getApplicationSubject());
		crmpage.clickOnActionlink(appdata.getApplicationSubject());
		
		Common.logstep("Step " + (logStep++) + " Click on Start link to Start Review Application Task.");
		crmverify=crmpage.clickOnStart();
		
		Common.logverification("Verify that Validation Error for Review Application task persisted correctly.");
		if(crmverify.verifyValidationError())
		{
			Common.assertPassed("Validation error verified.");
		}
		else
		{
			Common.assertFailed("Validation error is incorrect");
			Common.makeScreenshot(driver, "incorrectValidationError.png");
			numOfFailure++;
		}
				
		Common.logstep("Step " + (logStep++) + " Mousehover on Completion option and choose 'Completed' option to completed Review Application Errors.");
		crmpage.mouseHoverOnCompletion(appdata.getApplicationSubject());
		
		Common.logstep("Step " + (logStep++) + " Click on the Application link to redirect to Application Detail Page.");
		crmpage.clickOnApplication(appdata.getApplicationSubject());
	
		Common.logstep("Step " + (logStep++) + " Click on 'Current Task' sub-panel.");
		crmpage.clickOnCurrentTask();
		
		Common.logverification(" Verify that 'Interview / Site Inspection' task is available in 'Current Task' sub-panel.");
		if (crmverify.verifyCurrentTask("Interview / Site Inspection")) {
			logStatus(ITestStatus.PASSED);
			Common.logStatus("Pass");
			Common.writeProperties("Review_Application_Task_Complete", "True", "");
		} else {
			logStatus(ITestStatus.FAILED);
			Common.logStatus("Fail");
			Common.writeProperties("Review_Application_Task_Complete", "False", "");
			numOfFailure++;
		}
		
		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test(alwaysRun=true)
	 public void completeInterviewInspectionTask() {

	  int numOfFailure = 0;
	  int logStep = 1;
	  
	  Common.logcase("Testcase Id: TC_CRM_004 ");
	  Common.logcase("Testcase Name: To verify submitted Application's 'Interview/Site Inspection' task and it should be wildlife licensing queue and inspecting screen should be visibile to the role - Manager wildlife licensing.");

		appdata.setApplicationSubject(Common.readDataProperties("ApplicationName"));
	  
		try {
			String Application_Created = Common.readProperties("Review_Application_Task_Complete");

			if (Application_Created.contains("False")) {
				throw new SkipException("Skipping Test case as task status is not 'Interview / Site Inspection'.");
			}
		} catch (Exception e) {
			throw new SkipException("Skipping Test case as task status is not 'Interview / Site Inspection'.");
		}
	   
	  Common.logstep("Step " + (logStep++) + " : Open CRM url:<a>" + TestData.getCRMURL() + "</a>");
	  Common.switchToNewtabWithUrl(driver,TestData.getCRMURL());
	  
	  Common.logstep("Step " + (logStep++) + " Choose 'Standard Authentication' login method from Drop down.");
	  crmpage.chooseLoginMethod();
	  Common.pause(2);
	  Common.logstep("Step " + (logStep++) + " Login to CRM as admin");
	  crmpage.enterCRMUsername(TestData.getCRMInspecterUsername());
	  Common.pause(1);
	  crmpage.enterCRMPassword(TestData.getCRMInspectorPassword());
	  Common.pause(1);
	  crmpage.clickonCRMLoginbutton();
	  
	  Common.logstep("Step " + (logStep++) + " Feed the advance search options and filter current application :"+appdata.getApplicationSubject());
	  crmpage.advanceSearchForApplicationTask();
	  
		Common.logverification("Verify that Task status should be 'Interview/Site Inspection' ");
		if (crmverify.VerifycurrentTaskAndQueue("Interview / Site Inspection",appdata.getApplicationSubject(),"Wildlife Licensing Queue")) {
			Common.assertPassed("'Interview/Site Inspection' is available to the Inspection User. ");
		} else {
			Common.assertFailed("'Interview/Site Inspection' is not available to the Inspection User. ");
			throw new SkipException("'Interview/Site Inspection' is not available to the Inspection User.");
		}
	  
		Common.logstep("Step " + (logStep++) + " Click on Action link of "+appdata.getApplicationSubject());
		crmpage.clickOnActionlink(appdata.getApplicationSubject());
		
		Common.logstep("Step " + (logStep++) + " Click on Start link to Start 'Interview/Site Inspection' task.");
		crmverify=crmpage.clickOnStart();
	  
	  Common.pause(2);
	  Common.SwitchtoTab(driver,2);
	  
	  Common.logverification("Verify that the user is redirected to Application Details Page and 'Interview/Site Inspection' panel is expanded to the user.");
		if(crmverify.verifyInspectingOfficerAssessmentTabExpanded())
		{
			Common.assertPassed("'Interview/Site Inspection' panel is expanded to the Inspection User.");
		}
		else
		{
			Common.assertFailed("Something went wrong! Please look at screenshot.");
			Common.makeScreenshot(driver, "incorrectInspectionTask.png");
			numOfFailure++;
		}

		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		}
	  
	  
	  Common.logstep("Step " + (logStep++) + " Complete 'INSPECTING OFFICER ASSESSMENT' form as below and click on Save button.");
	  crmpage.enteronDate();
	  crmpage.clickonsiteRadiobutton();
	  crmpage.enterPresentcomment();
	  crmpage.enterInspectionComment();
	  crmpage.enterConcernsComment();
	  crmpage.dropdown_selectDelegate();
	  crmpage.clickonApprovedRadiobutton();
	  crmpage.clickonSavebutton();
	  crmpage.clickonSubmiteToDelegate();
	  
	  Common.pause(5);	
	  driver.navigate().refresh();
		Common.logstep("Step " + (logStep++) + " Click on 'Current Task' sub-panel.");
		crmpage.clickOnCurrentTask();
	  
	  Common.logverification(" Verify that 'Approval By Delegate' task is available in 'Current Task' sub-panel.");
		if (crmverify.verifyCurrentTask("Approval By Delegate")) {
			logStatus(ITestStatus.PASSED);
			Common.logStatus("Pass");
			Common.writeProperties("Interview_Inspection_Task_Complete", "True", "");
		} else {
			logStatus(ITestStatus.FAILED);
			Common.logStatus("Fail");
			Common.writeProperties("Interview_Inspection_Task_Complete", "False", "");
			numOfFailure++;
		}
		
		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		}
	 
	 }
	 
	 @Test(alwaysRun=true)
	 public void verifyAndCompleteApproveDelegateTask() {

	  int numOfFailure = 0;
	  int logStep = 1;
	  
	  Common.logcase("Testcase Id: TC_CRM_005 ");
	  Common.logcase("Testcase Name: To verify submitted Application task is 'Approval By Delegate' .");

		appdata.setApplicationSubject(Common.readDataProperties("ApplicationName"));
	  
		try {
			String interview_inspection = Common.readProperties("Interview_Inspection_Task_Complete");
			if (interview_inspection.contains("False")) {
				throw new SkipException("Skipping Test case as Task status is not 'Approval By Delegate'.");
			}
		} catch (Exception e) {
			throw new SkipException("Skipping Test case as Task status is not 'Approval By Delegate'.");
		}
	  

	  Common.logstep("Step " + (logStep++) + " : Open portal url:<a>" + testUrl + "</a>");
	  appdata.setApplicationSubject("Wildlife Basic Licence-Ankit ANKIT");
	  
	  Common.logstep("Step " + (logStep++) + " : Open CRM url:<a>" + TestData.getCRMURL() + "</a>");
	  Common.switchToNewtabWithUrl(driver,TestData.getCRMURL());
	  
	  Common.logstep("Step " + (logStep++) + " Choose 'Standard Authentication' login method from Drop down.");
	  crmpage.chooseLoginMethod();
	  Common.pause(5);
	  Common.logstep("Step " + (logStep++) + " Login to CRM as admin");
	  crmpage.enterCRMUsername(TestData.getCRMDelegateUsername());
	  Common.pause(1);
	  crmpage.enterCRMPassword(TestData.getCRMDelegatePassword());
	  Common.pause(1);
	  crmpage.clickonCRMLoginbutton();
	  
	  Common.logstep("Step " + (logStep++) + " Advance search filter feeding with Application Name("+appdata.getApplicationSubject()+") and short Task in desanding order according to date created.");
	  crmpage.advanceSearchForApplicationTask();
	  
	  Common.logverification("Verify that Task status of application '"+appdata.getApplicationSubject()+"' should be 'Approval By Delegate' ");
	  if (crmverify.VerifycurrentTaskAndQueue("Approval By Delegate",appdata.getApplicationSubject(),"Wildlife Licensing Queue")) {
	   logStatus(ITestStatus.PASSED);
	   Common.writeProperties("Task_status_Approval_By_Delegate", "True", "");
	  } else {
	   logStatus(ITestStatus.FAILED);
	   Common.writeProperties("Task_status_Approval_By_Delegate", "False", "");
	   numOfFailure++;
	  }
	  
		Common.logstep("Step " + (logStep++) + " Click on Action link of "+appdata.getApplicationSubject());
		crmpage.clickOnActionlink(appdata.getApplicationSubject());
		
		Common.logstep("Step " + (logStep++) + " Click on Start link to Start 'Approval By Delegate' task.");
		crmverify=crmpage.clickOnStart();
	  
	  Common.pause(2);
	  Common.SwitchtoTab(driver,2);
	  
	  Common.logverification("Verify that the user is redirected to Application Details Page and 'Delegate Decision' panel is expanded to the user.");
		if(crmverify.verifyInspectingOfficerAssessmentTabExpanded())
		{
			Common.assertPassed("'Delegate Decision' panel is expanded to the Delegate User.");
		}
		else
		{
			Common.assertFailed("Something went wrong! Please look at screenshot.");
			Common.makeScreenshot(driver, "incorrectDelegateScreen.png");
			numOfFailure++;
		}
		
		Common.logverification("Verify that Comments provided by Inspecting officer is correctly displayed to the Delegate Officer.");
		if(crmverify.verifyInspectionComment())
		{
			Common.assertPassed("Verified");
		}
		else
		{
			Common.assertFailed("Something went wrong! Please look at screenshot.");
			Common.makeScreenshot(driver, "incorrectInspectionComment.png");
			numOfFailure++;
		}

		Common.logstep("Step " + (logStep++) + " Choose 'Approve' from Delegate 'Delegate Determination'.");
		crmpage.approveFromDelegate();
		
		Common.logstep("Step " + (logStep++) + " Click on 'Verify' button to validate Delegate Signed .");
		crmpage.clickOnVerifyButton();
		
		Common.logverification("Verify that Delegate Signature validated and 'Record Decision' button enable to Click.");
		if(crmverify.verifyDelegateSign())
		{
			Common.assertPassed("Verified");
		}
		else
		{
			Common.assertFailed("Something went wrong! Please look at screenshot.");
			Common.makeScreenshot(driver, "incorrectInspectionComment.png");
			numOfFailure++;
		}
		
		Common.logstep("Step " + (logStep++) + " Click on 'Deleate Decision' button to complete Delegate Task .");
		crmpage.clickDelegateDecision();
		
		Common.pause(10);
		driver.navigate().refresh();
		
		Common.logstep("Step " + (logStep++) + " Click on 'Current Task' sub-panel.");
		crmpage.clickOnCurrentTask();
		
		Common.logverification("Verify that Approval By Delagate Task Completed successfully and 'Await payment confirmation' task is available in Current Task Panel.");
		if(crmverify.verifyCurrentTask("Await payment confirmation"))
		{
			logStatus(ITestStatus.PASSED);
			Common.logStatus("Pass");
			Common.writeProperties("Delegate_Approval_Task_Complete", "True", "");
		} else {
			logStatus(ITestStatus.FAILED);
			Common.logStatus("Fail");
			Common.writeProperties("Delegate_Approval_Task_Complete", "False", "");
			numOfFailure++;
		}
		
		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		}
	}
	 
	 
	 @Test(alwaysRun=true)
	 public void completeAwaitingPaymentConfirmationTask() {

	  int numOfFailure = 0;
	  int logStep = 1;
	  
	  Common.logcase("Testcase Id: TC_CRM_006 ");
	  Common.logcase("Testcase Name: To verify user can complete 'Awaitin Payment Confirmation' task and 'Permit' document has been generated.");

		appdata.setApplicationSubject(Common.readDataProperties("ApplicationName"));
	  
		try {
			String interview_inspection = Common.readProperties("Delegate_Approval_Task_Complete");
			if (interview_inspection.contains("False")) {
				throw new SkipException("Skipping Test case as task status is not 'Await payment confirmation'.");
			}
		} catch (Exception e) {
			throw new SkipException("Skipping Test case as task status is not 'Await payment confirmation'.");
		}
	  

	  Common.logstep("Step " + (logStep++) + " : Open portal url:<a>" + testUrl + "</a>");
	  
		Common.logstep((logStep++)+" Enter Username.");
		applicationIndexPage.enterAdminUsername();
		
		Common.logstep((logStep++)+" Enter Password.");
		applicationIndexPage.enterAdminPassword();
		
		Common.logstep((logStep++)+" Click on Login icon.");
		applicationIndexPage.clickonlogin();
		
		Common.logstep((logStep++)+" Click on Personal Menu.");
		applicationIndexPage.clickPersonalMenu();
	
		Common.logstep((logStep++)+" Click on Permit Menu.");
		applicationIndexPage.clickonPermit();
	
		Common.logstep((logStep++)+" Get current number of Permit records.");
		applicationIndexPage.currentPermitRecords();
		
		Common.logstep("Step " + (logStep++) + " : Open CRM url:<a>" + TestData.getCRMURL() + "</a>");
	  Common.switchToNewtabWithUrl(driver,TestData.getCRMURL());
	  
	  Common.logstep("Step " + (logStep++) + " Choose 'Standard Authentication' login method from Drop down.");
	  crmpage.chooseLoginMethod();
	  Common.pause(5);
	  Common.logstep("Step " + (logStep++) + " Login to CRM as admin");
	  crmpage.enterCRMUsername(TestData.getCRMUsername());
	  Common.pause(1);
	  crmpage.enterCRMPassword(TestData.getCRMPassword());
	  Common.pause(1);
	  crmpage.clickonCRMLoginbutton();
	  
	  Common.logstep("Step " + (logStep++) + "Advance search filter feeding with Application Name("+appdata.getApplicationSubject()+") and short Task in desanding order according to date created.");
	  crmpage.advanceSearchForApplicationTask();
	  
	  Common.logverification("Verify that Task status of application '"+appdata.getApplicationSubject()+"' should be 'Await payment confirmation' ");
	  if (crmverify.VerifycurrentTaskAndQueue("Await payment confirmation",appdata.getApplicationSubject(),"Wildlife Licensing Queue")) {
	   logStatus(ITestStatus.PASSED);
	   Common.writeProperties("Task_status_Await_Payment_Confirmation", "True", "");
	  } else {
	   logStatus(ITestStatus.FAILED);
	   Common.writeProperties("Task_status_Await_Payment_Confirmation", "False", "");
	   numOfFailure++;
		throw new SkipException("Skipping Test case as 'Await Payment Confirmation' task.");
	  }
	  
		Common.logstep("Step " + (logStep++) + " Click on Action link of "+appdata.getApplicationSubject());
		crmpage.clickOnActionlink(appdata.getApplicationSubject());
		
		Common.logstep("Step " + (logStep++) + " Click on Start link to Start 'Approval By Delegate' task.");
		crmverify=crmpage.clickOnStart();
	  
	  Common.pause(2);
	  Common.SwitchtoTab(driver,2);
	  driver.navigate().refresh();
	  
	  Common.logstep("Step " + (logStep++) + " Click on Business Process icon available on the top right corner.");
	  crmverify=crmpage.clickOnBusinessProcess();
	  
	  Common.logstep("Step " + (logStep++) + " Choose 'Approved' Option to complete 'Await payment confirmation' task.");
	  crmpage.chooseApproveOption();
	  
	  
	  Common.pause(10);
	  Common.SwitchtoTab(driver,0);
	  driver.navigate().refresh();
	  
	  Common.logverification("Verify that the number of permit records are increased to 1.");
		if(!crmverify.verifyNumberOfPermitRecordss())
		{
			logStatus(ITestStatus.PASSED);
			Common.logStatus("Pass");
			Common.writeProperties("Await_Payment_Confirmation_Complete", "True", "");
		} else {
			logStatus(ITestStatus.FAILED);
			Common.logStatus("Fail");
			Common.writeProperties("Await_Payment_Confirmation_Complete", "False", "");
			numOfFailure++;
		}
		
		
	
		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		}
	}
	 
	 
	 
	 
		
}
	
