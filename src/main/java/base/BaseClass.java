package base;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import config.Configuration;
import utils.DriverManager;
import utils.ExtentManager;

public class BaseClass {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	protected ExtentReports extent;
	protected ExtentTest test;
	ExtentManager extentManager = new ExtentManager();

	@BeforeSuite
	public void setupSuite() {
		// Delete old screenshots
		extentManager.deleteOldScreenshots();
	}

	@BeforeClass
	public void setupTestEnvironment() {

		/*
		 * This will restore a login session, so there is no need to log in repeatedly
		 * after each test commit for now, as the login functionality has not been
		 * implemented yet.
		 */

		// driver = SessionManager.getInstance().getDriver(); // Use the singleton
		// driver instance

		// Initialize Extent Reports
		ExtentManager.setupExtentReports();
		extent = ExtentManager.getExtent();
		// Set up WebDriver and WebDriverWait from DriverManager
		DriverManager.setupDriver(); // This will initialize the driver based on the config
		driver = DriverManager.getDriver();
		wait = DriverManager.getWait();
		js = DriverManager.getJsExecutor();
	}

	@AfterClass
	public void teardownTestEnvironment() {
		// Close browser and report after all tests
		DriverManager.quitDriver(); // Quit the driver using DriverManager
		ExtentManager.closeExtentReports();
	}

	@BeforeMethod
	public void setupBeforeEachTest() {
		// Retrieve baseUrl from the config.properties file
		String baseUrl = Configuration.get("baseUrl");
		driver.get(baseUrl); // Navigate to the specified URL
	}

	@AfterMethod
	public void logTestResultsAndCaptureScreenshot(ITestResult result) {
		if (test == null) {
			System.err.println("ExtentTest instance is null for method: " + result.getMethod().getMethodName());
			return;
		}
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case Failed: " + result.getName());
			test.log(Status.FAIL, "Error: " + result.getThrowable());
			// Capture screenshot and directly attach to Extent report within takeScreenshot
			// method
			ExtentManager.takeScreenshot(driver, result.getName(), test);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Passed: " + result.getName());
		}
		extent.flush(); // Ensure ExtentReports is flushed after each test method
	}

	@AfterSuite
	public void tearDownSuite() {
		ExtentManager.closeExtentReports(); // Ensures Extent reports are finalized
		// Clean up the test-output folder, keeping only Reports folder

	}

	@AfterClass
	public void tearDownSession() {
		extentManager.deleteFilesExceptFolder();
		// commit for the moment beacause logout functionality is not been implemented

//        if (driver != null) {
//            SessionManager.getInstance().logout(); // Logout and clean session if needed
//        }
	}

	public void setupBeforeEachTest(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		test = ExtentManager.createTest(testName); // Create a new ExtentTest instance for each test
	}

	public void closeExtentReports() {
		if (extent != null) {
			extent.flush();
		}
	}

	public void testcaseName(String testName) {
		test = extent.createTest(testName);
	}

	public void verifyText(String expected, String actual) {
		AssertJUnit.assertEquals(expected, actual);
	}

	public void openUrlInNewTab(String url) {
		js.executeScript("window.open(arguments[0], '_blank');", url);
		// Switch to new tab
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
	}

	public void switchToTab(int tabIndex) {
		Object[] tabs = driver.getWindowHandles().toArray();
		if (tabIndex < tabs.length) {
			driver.switchTo().window(tabs[tabIndex].toString());
		} else {
			throw new IllegalArgumentException("Tab index out of bounds.");
		}
	}

	public String generateUniqueEmail() {
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		return "testuser+" + timestamp + "@yopmail.com";
	}

	public String generateUniqueMessage() {
		String timestamp = new SimpleDateFormat("HHmmss").format(new Date());
		return "Cubix Test Bot" + timestamp;
	}

}