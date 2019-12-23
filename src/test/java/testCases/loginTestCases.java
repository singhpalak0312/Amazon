package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Framework.launch;
import PageObjects.loginPageobjects;
import io.appium.java_client.MobileBy;

/**
 * @author Developer Class to Test all the login Scenario
 */
public class loginTestCases extends launch {

	@Test
	public void startapp() throws IOException {
		capabilities();
	}

	@Test(priority = 0)
	public void TestCasse1() {
		loginPageobjects log = new loginPageobjects(driver);
		test = extent.createTest("Test1 - Keeping email Blank");
		test.log(Status.INFO, " Started Testing Logging Scenarrio , Keeping Email Blank");
		log.ContinueButton.click();
		test.log(Status.PASS, "Pressed Continue Button");
		Assert.assertTrue(log.ErrorEnterMobileNumber.isDisplayed());
		test.log(Status.PASS, "Toast Message Displayed ");

	}

	@Test(priority = 1)
	public void TestCase2() {
		loginPageobjects log = new loginPageobjects(driver);
		test = extent.createTest("Test2 - Incorrect Number");
		test.log(Status.INFO, " Started Testing Logging Scenarrio , Keeping Incorrect Number");
		log.LoginTextBox.sendKeys("9238");
		test.log(Status.PASS, " Sent Incorrect Number");
		log.ContinueButton.click();
		test.log(Status.PASS, "Pressed Continue Button");
		Assert.assertTrue(log.ErrorThereWasAProblem.isDisplayed());
		test.log(Status.PASS, "Toast Message Displayed ");

	}

	@Test(priority = 2)
	public void TestCase3() {
		loginPageobjects log = new loginPageobjects(driver);
		test = extent.createTest("Test3 - Incorrect email");
		test.log(Status.INFO, " Started Testing Logging Scenarrio , Keeping Incorrect Email");
		log.LoginTextBox.sendKeys("xyz@gmail.com");
		test.log(Status.PASS, " Sent Incorrect Email");
		log.ContinueButton.click();
		test.log(Status.PASS, "Pressed Continue Button");
		Assert.assertTrue(log.ErrorThereWasAProblem.isDisplayed());
		test.log(Status.PASS, "Toast Message Displayed ");

	}

	@Test(priority = 3)
	public void TestCase4() {
		loginPageobjects log = new loginPageobjects(driver);
		test = extent.createTest("Test4 - correct Number");
		test.log(Status.INFO, " Started Testing Logging Scenarrio , Keeping correct Number");
		log.LoginTextBox.sendKeys("7566237715");
		test.log(Status.PASS, " Sent correct Number");
		log.ContinueButton.click();
		test.log(Status.PASS, "Pressed Continue Button");
		// Password Vaala Button dikhne lagega yeh likho

	}

	@Test(priority = 4)
	public void TestCase5() {
		loginPageobjects log = new loginPageobjects(driver);
		test = extent.createTest("Test5 - correct number");
		test.log(Status.INFO, " Started Testing Logging Scenarrio , Keeping correct Number");
		log.LoginTextBox.sendKeys("7566237715");
		test.log(Status.PASS, " Sent correct Number");
		log.ContinueButton.click();
		test.log(Status.PASS, "Pressed Continue Button");
		Assert.assertTrue(log.PasswordTextBox.isDisplayed());
		test.log(Status.PASS, "Correct Number is Sent and passwod Text Box is Displayed ");

	}

	@Test(priority = 5)
	public void TestCase6() {
		loginPageobjects log = new loginPageobjects(driver);
		test = extent.createTest("Test6 - Blanks Password");
		test.log(Status.INFO, " Started Testing Logging Scenarrio , Keeping correct Number but Blank Password");
		log.LoginTextBox.sendKeys("7566237715");
		test.log(Status.PASS, " Sent correct Number");
		log.ContinueButton.click();
		test.log(Status.PASS, "Pressed Continue Button");
		log.LoginButton.click();
		test.log(Status.PASS, "Clicked on login button without providing password");
		Assert.assertTrue(log.ErrorYourPasswordr.isDisplayed());
		test.log(Status.PASS, "Got Error Message Enter Your Password");

	}

	@Test(priority = 6)
	public void TestCase7() {
		loginPageobjects log = new loginPageobjects(driver);
		test = extent.createTest("Test6 - Incorrect Password");
		test.log(Status.INFO, " Started Testing Logging Scenarrio , Keeping correct Number but Incorrect Password");
		log.LoginTextBox.sendKeys("7566237715");
		test.log(Status.PASS, " Sent correct Number");
		log.ContinueButton.click();
		test.log(Status.PASS, "Pressed Continue Button");
		log.PasswordTextBox.sendKeys("sahd");
		test.log(Status.PASS, "Sent Incorrect Password");
		log.LoginButton.click();
		test.log(Status.PASS, "Clicked on login button");
		Assert.assertTrue(log.ErrorThereWasAProblem.isDisplayed());
		test.log(Status.PASS, "Got Error There was a problem");


	}

}
