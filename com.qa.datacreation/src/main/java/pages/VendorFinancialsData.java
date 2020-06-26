package pages;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utils.TestUtil;

public class VendorFinancialsData extends TestBase{
	
	
	TestUtil TestUtils = new TestUtil();
	
	
	//web elements
	
	@FindBy(xpath="(//button[@type='button'])[1]")
	WebElement FinancialStatementAudited;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement FinancialStatement1;
	
	@FindBy(xpath="(//button[@type='button'])[3]")
	WebElement FinancialStatement2;
	
	@FindBy(xpath="(//button[@type='button'])[4]")
	WebElement FinancialAuditedReport;
	
	@FindBy(xpath="(//button[@type='button'])[5]")
	WebElement FinancialAuditReport1;
	
	@FindBy(xpath="(//button[@type='button'])[6]")
	WebElement FinancialAuditRepor2;
	
	@FindBy(xpath="(//button[@type='button'])[7]")
	WebElement FinancialSalesData;
	
	@FindBy(xpath="//label[text()='Select Banks']/..//input[1]")
	WebElement SelectBanks;
		
	
	@FindBy(xpath="//span[text()='Axis Bank Ltd.']")
	WebElement Bankname;
	
	@FindBy(xpath="(//button[@type='button'])[8]")
	WebElement UploadBankStmt;
	
	@FindBy(xpath="(//button[@type='button'])[10]")
	WebElement Declaration;
	
	@FindBy(xpath="(//button[@type='button'])[11]")
	WebElement SanctionLetter;
	
	@FindBy(xpath="(//button[@type='button'])[12]")
	WebElement ShareholdingPattern;
	
	
	@FindBy(xpath="(//button[@type='button'])[21]")
	WebElement AddCustomerNames;
	
	@FindBy(xpath="//input[@name='clientele[0]']")
	WebElement CustomerNames;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SaveFinandata;
	
	
	@FindBy(xpath="//button[text()='Ok']")
	WebElement OkBtn;
	
	   /*functions of page*/
    public VendorFinancialsData(){
    			
    			PageFactory.initElements(driver, this);
    			
    }
    
	
	public void AddVenFinanDetails() throws IOException {
		
			
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()",SelectBanks);
		
		
		Actions a1=new Actions(driver);
		a1.click(Bankname).sendKeys("Axis Bank Ltd.").build().perform();
		
		UploadBankStmt.sendKeys("C:\\Users\\DELL\\git\\Selenium-test\\com.qa.datacreation\\Test Files.sample.pdf");	
	   // driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	   /* TestUtils.UploadDocument(driver, UploadBankStmt);
	
		TestUtils.UploadDocument(driver, ShareholdingPattern);
		TestUtils.UploadDocument(driver, SanctionLetter);
		TestUtils.UploadDocument(driver, Declaration);
		TestUtils.UploadDocument(driver, UploadBankStmt);
		TestUtils.UploadDocument(driver, Bankname);
		TestUtils.UploadDocument(driver, FinancialSalesData);
		TestUtils.UploadDocument(driver, FinancialAuditRepor2);
		TestUtils.UploadDocument(driver, FinancialAuditReport1);
		TestUtils.UploadDocument(driver, FinancialAuditedReport);
		TestUtils.UploadDocument(driver, FinancialStatement2);
		TestUtils.UploadDocument(driver, FinancialStatement1);
		TestUtils.UploadDocument(driver, FinancialStatementAudited);
		
		*/
		AddCustomerNames.click();
		CustomerNames.sendKeys("custmoer");
		SaveFinandata.click();
		
		
	}
	
	
	

}
