package Framework;


import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author Developer
    This class is to create extent report to see test results
 *
 */
public class ExtentReportCreation {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;


	@BeforeSuite
	public void reportSetup() {
		htmlReporter = new ExtentHtmlReporter("C:/Users/Developer/eclipse-workspace/Amazontest-output/test-output/extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			
			String s = result.getName();
			String screenShotPath = launch.getScreenshot(s);
			test.log(Status.FAIL, "Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
			test.fail(MarkupHelper.createLabel(result.getName() + "Test Case Failed", ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass(MarkupHelper.createLabel(result.getName() + "Test Case Passed", ExtentColor.GREEN));
		} else {
			test.skip(MarkupHelper.createLabel(result.getName() + "Test Case Skipped", ExtentColor.YELLOW));
			test.fail(result.getThrowable());
		}

	}

	@AfterSuite
	public void reportTearDown() {
		extent.flush();
	}
}
