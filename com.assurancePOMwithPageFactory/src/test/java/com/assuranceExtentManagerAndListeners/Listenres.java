package com.assuranceExtentManagerAndListeners;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.assuranceBase.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Listenres extends BaseTest implements ITestListener {
	
	ExtentTest test;
	static Date d = new Date();
	static String filenameString = "Extent_Report_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
    static String projectPath="./Reports/";
    static String realPath=projectPath+filenameString;
    
	//public static ExtentReports extent = ExtentManager.createInstance("./Reports/Login.html");
    
    // the static one, it will replace the old one. As a result we only have latest report all the time. 
	public static ExtentReports extent = ExtentManager.createInstance(realPath);
	//since it has time stamp, it will always have new one, the history. 
    
	public static ThreadLocal<ExtentTest> testRepor = new ThreadLocal<ExtentTest>();
	// is responsible for multi threading. 
    
  
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getClass().getName() + " @TestCase" + result.getMethod().getMethodName());
		testRepor.set(test);
		
	}
	
	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();

		String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + "  PASSED" + "</b>";

		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);

		// logger.getStatus();
		// logger.log(Status.PASS, " TEST CASE PASS IS " + result.getName());
	
		
	}

	public void onTestFailure(ITestResult result) {

		// First arugement
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		test.fail("<details>" + "<summary>" + "<b>" + "<fontcolor=" + "red>" + "Exception occured:Click to see"
				+ "</font>" + "</b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>" + " \n");

		String failureLogg = "TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		test.log(Status.FAIL, m);

		// second argument
		String methodName = result.getMethod().getMethodName();

		String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + " FAILED" + "</b>";

		Markup m1 = MarkupHelper.createLabel(logText, ExtentColor.RED);
		test.fail(m1);
		
		// Third argument individual
		test.fail(result.getThrowable().getMessage());
		test.log(Status.FAIL, result.getName() + " TEST CASE ERROR IS " + result.getThrowable().getMessage());
		
		// screen shot
		String screenShotPath = ExtentManager.getScreenshot(driver, result.getName());
		try {
			test.addScreenCaptureFromPath(screenShotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
	}

	public void onTestSkipped(ITestResult result) {
		// first argument
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		test.skip("<details>" + "<summary>" + "<b>" + "<fontcolor=" + "red>" + "Exception occured:Click to see"
				+ "</font>" + "</b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>" + " \n");

		String failureLogg = "TEST CASE SKIPPED  " + result.getMethod().getMethodName();
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.ORANGE);
		test.log(Status.SKIP, m);
		// taking screen shot
		String screenShotPath = ExtentManager.getScreenshot(driver, result.getName());
		try {
			test.addScreenCaptureFromPath(screenShotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// second argument
		String methodName = result.getMethod().getMethodName();

		String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + " SKIPPED" + "</b>";

		Markup m1 = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
		test.pass(m1);
		// third argument
		test.skip(result.getThrowable().getMessage());
		test.log(Status.SKIP, result.getName() + " TEST CASE ERROR IS " + result.getThrowable().getMessage());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		System.out.println("Test Failed but within success percentage" +result.getName());
		
	}

	public void onStart(ITestContext context) {
		
		
		System.out.println("This is onStart method" +context.getOutputDirectory());
		
	}

	public void onFinish(ITestContext context) {
			
		if (extent != null) {
			extent.flush();
			System.out.println(context.getName()+" *******   EXECUTED   ********* ");
		}	}

}
