package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverManager;

public class EmploymentSA102Page {

	private WebDriver driver;
	private WebDriverWait wait;


	// Constructor
	public EmploymentSA102Page(WebDriver driver) {
		this.driver = driver;
		 this.wait = DriverManager.getWait(); // <-- Add this line
	}

	// Locators

	private By userEmailInputField = By.xpath("//input[@type='email' and @placeholder='example@gmail.com']");
	private By userPassInputField = By.xpath("//input[@type='password' and @placeholder='*********']");
	private By loginButton = By.xpath("//span[contains(text(),'Login')]");
	private By selfEmployed = By.xpath("//span[contains(text(),'Self Employed')]");
	private By cancelButton = By.xpath("//button[contains(text(),'Cancel')]");
	private By selectValue = By.xpath("//input[@placeholder='Select' and @value='2025/26']");
	private By dropdownSelect = By.xpath("//span[contains(text(),'2023/24')]");
	private By submitTaxReturn = By.xpath("//div[contains(text(),'Submit Tax Return')]");
	private By addNewSectionButton = By.xpath("//span[contains(text(),'Add a new section')]");
	private By employmentSA102 = By.xpath("//div[contains(text(),'Employment')]");
	
	
	////////////////////////////////////form/////////////////////////////
	
	private By input1 = By.xpath("(//input[@type='text' and @inputmode='numeric'])[1]");
	private By input2 = By.xpath("(//input[@type='text' and @inputmode='numeric'])[2]");
	private By input3 = By.xpath("(//input[@type='text' and @inputmode='numeric'])[3]");
	private By input4 = By.xpath("(//input[@type='text' and @inputmode='numeric'])[4]");
	
	private By input17= By.xpath("(//input[@type='text' and @placeholder='Enter'])[1]");
	private By input18= By.xpath("(//input[@type='text' and @placeholder='Enter'])[2]");
	private By checkBox= By.xpath("//input[@name='EMP6' and @type='checkbox']");
	private By dateInput= By.xpath("//input[@placeholder='DD-MM-YYYY' and contains(@class, 'mantine-DateInput-input')]");

	
	
	private By input5 = By.xpath("(//input[@type='text' and @inputmode='numeric'])[5]");
	private By input6 = By.xpath("(//input[@type='text' and @inputmode='numeric'])[6]");
	private By input7 = By.xpath("(//input[@type='text' and @inputmode='numeric'])[7]");
	private By input8 = By.xpath("(//input[@type='text' and @inputmode='numeric'])[8]");
	private By input9 = By.xpath("(//input[@type='text' and @inputmode='numeric'])[9]");
	private By input10= By.xpath("(//input[@type='text' and @inputmode='numeric'])[10]");
	private By input11= By.xpath("(//input[@type='text' and @inputmode='numeric'])[11]");
	private By input12= By.xpath("(//input[@type='text' and @inputmode='numeric'])[12]");
	private By input13= By.xpath("(//input[@type='text' and @inputmode='numeric'])[13]");
	private By input14= By.xpath("(//input[@type='text' and @inputmode='numeric'])[14]");
	private By input15= By.xpath("(//input[@type='text' and @inputmode='numeric'])[15]");
	private By input16= By.xpath("(//input[@type='text' and @inputmode='numeric'])[16]");
	
	private By saveTaxForm= By.xpath("//button[contains(text(),'Save')]");	
	private By saveTaxFormSuccessToast= By.xpath("//div[contains(text(),'SUCCESS')]");
	
	
	// Actions
	public void input1(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input1));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	public void input2(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input2));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	public void input3(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input3));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	public void input4(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input4));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	
	public void checkBox() {
		 WebElement checkBoxbtn = wait.until(ExpectedConditions.elementToBeClickable(checkBox));
		 checkBoxbtn.click();
	}
	public void dateInput(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(dateInput));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	
	public void input5(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input5));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	public void input6(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input6));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	public void input7(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input7));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	public void input8(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input8));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	public void input9(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input9));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	public void input10(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input10));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	public void input11(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input11));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	public void input12(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input12));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	public void input13(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input13));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	public void input14(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input14));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	public void input15(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input15));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	public void input16(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input16));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	public void input17(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input17));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	public void input18(String value) {
	    WebElement inputF1 = wait.until(ExpectedConditions.elementToBeClickable(input18));
	    inputF1.clear();
	    inputF1.sendKeys(value);
	}
	
	public void saveTaxForm() {
		
		 WebElement saveTaxFormBtn = wait.until(ExpectedConditions.elementToBeClickable(saveTaxForm));
		 saveTaxFormBtn.click();
		
	}
	
	public String getToastMessage() {
	    WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(saveTaxFormSuccessToast));
	    return toast.getText().trim();
	}

	
	public void cancelButton() {
		 WebElement cancelbtn = wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
		 cancelbtn.click();
	}
	
	public void submitTaxReturn() {
		WebElement submitTaxReturnBtn = wait.until(ExpectedConditions.elementToBeClickable(submitTaxReturn));
		submitTaxReturnBtn.click();
	}
	
	public void dropdownSelect() {
		WebElement dropdownSelectBtn = wait.until(ExpectedConditions.elementToBeClickable(dropdownSelect));
		dropdownSelectBtn.click();
	}
	
	public void selectValue() {
	    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(selectValue));
	    dropdown.click();
	}
	
	public void enterEmail(String email) {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(userEmailInputField));
	    wait.until(ExpectedConditions.elementToBeClickable(userEmailInputField));

	    WebElement emailField = driver.findElement(userEmailInputField);
	    emailField.clear();
	    emailField.sendKeys(email);
	}

	public void enterPass(String pass) {
		driver.findElement(userPassInputField).clear();
		driver.findElement(userPassInputField).sendKeys(pass);
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public void selfEmployed() {
		 WebElement selfEmployedBtn = wait.until(ExpectedConditions.elementToBeClickable(selfEmployed));
		 selfEmployedBtn.click();
	}
	
	public void addNewSectionButton() {
		
		 WebElement addNewSectionBtn = wait.until(ExpectedConditions.elementToBeClickable(addNewSectionButton));
		 addNewSectionBtn.click();
	}
	public void clickemploymentSA102() {
		 WebElement employmentSA = wait.until(ExpectedConditions.elementToBeClickable(employmentSA102));
		 employmentSA.click();
	}
	

//	public String getResetScreenText() {
//		return driver.findElement(getResetScreenText).getText().trim();
//	}

//	public String getToastMessage() {
//		WebElement toast = driver.findElement(toastMessage);
//		return toast.isDisplayed() ? toast.getText().trim() : "";
//	}

//	public boolean isResetButtonEnabled() {
//		return driver.findElement(resetButton).isEnabled();
//	}
//
//	public boolean isEmailFieldDisplayed() {
//		return driver.findElement(clientEmailInputField).isDisplayed();
//	}
}
