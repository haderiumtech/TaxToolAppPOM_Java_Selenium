package tests;

import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
//import config.Configuration;
import pages.EmploymentSA102Page;
import utils.EnvReader;
import utils.JsonReader;

public class EmploymentSA102Test extends BaseClass {

	private EmploymentSA102Page EmploymentSA102Page;
	private static JsonReader reader;

	@BeforeClass
	public void initJson() {
		reader = new JsonReader("testdata/toastMessages.json");
	}

	@BeforeMethod
	public void setupPages() {
		EmploymentSA102Page = new EmploymentSA102Page(driver);
	}

	@Test(priority = 1)
	public void verifyForgotPasswordEmail() throws InterruptedException, TimeoutException {

		test = extent.createTest("Test case for: Employment SA102 Tax Form");

//		String clientPortalUrl = Configuration.get("clientUrl");
//		String hrmUrl = Configuration.get("hrmUrl");

		// driver.get(clientPortalUrl);
		//Thread.sleep(3000);
		EmploymentSA102Page.enterEmail(EnvReader.get("CLIENT_EMAIL"));
		EmploymentSA102Page.enterPass(EnvReader.get("CLIENT_PASSWORD"));
		EmploymentSA102Page.clickLoginButton();
		EmploymentSA102Page.selfEmployed();
		EmploymentSA102Page.cancelButton();
		EmploymentSA102Page.selectValue();
		EmploymentSA102Page.dropdownSelect();
		EmploymentSA102Page.submitTaxReturn();

		EmploymentSA102Page.addNewSectionButton();
		EmploymentSA102Page.clickemploymentSA102();
		Thread.sleep(2000);
		EmploymentSA102Page.input1("33");
		EmploymentSA102Page.input2("22");
		EmploymentSA102Page.input3("11");
		EmploymentSA102Page.input4("12");
		
		EmploymentSA102Page.input17("james");
		EmploymentSA102Page.input18("joan");
		EmploymentSA102Page.checkBox();
		EmploymentSA102Page.dateInput("12-1-2023");
		
		EmploymentSA102Page.input5("32");
		EmploymentSA102Page.input6("53");
		EmploymentSA102Page.input7("56");
		EmploymentSA102Page.input8("65");
		EmploymentSA102Page.input9("43");
		EmploymentSA102Page.input10("21");
		EmploymentSA102Page.input11("45");
		EmploymentSA102Page.input12("65");
		EmploymentSA102Page.input13("7");
		EmploymentSA102Page.input14("67");
		EmploymentSA102Page.input15("89");
		EmploymentSA102Page.input16("94");
		EmploymentSA102Page.saveTaxForm();
		
		
		String expectedToast = reader.getValue("EmploymentSA102Page.employmentSuccess");

	    String actualMessage = EmploymentSA102Page.getToastMessage();

	    Assert.assertEquals(actualMessage, expectedToast, "Toast message does not match!");

	}
}
