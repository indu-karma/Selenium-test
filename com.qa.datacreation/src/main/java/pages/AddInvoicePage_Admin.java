package pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.TestUtil;

import base.TestBase;

public class AddInvoicePage_Admin extends TestBase {

//Web Elements
	TestUtil TstUtl= new TestUtil(); 
	String AssetUID=null;
	
	@FindBy(xpath="(//a[contains(text(),'Invoices')])[1]")
	WebElement SelectInvoices;
	
	@FindBy(xpath="//a[contains(text(),\"Add New Invoice\")]")
	WebElement AddNewInvoice;
	 
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement InvoiceID;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement InvoiceValue;
	
	@FindBy(xpath="(//input[@type='text'])[4]")
	WebElement InvoicePayable;
	
	@FindBy(xpath="(//input[@type='text'])[5]")
	WebElement BorrowerUID;
	
	@FindBy(xpath="(//input[@type='text'])[7]")
	WebElement EnterpriseUID;
	
	@FindBy(xpath="(//span[@class='rw-i rw-i-calendar'])[1]")
	WebElement IssueDateClk;
	
	@FindBy(xpath="(//button[@class='rw-btn'])[1]")
	WebElement IssueDate;
	
	@FindBy(xpath="(//span[@class='rw-i rw-i-calendar'])[2]")
	WebElement RepayementDateClk;
	
	@FindBy(xpath="(//button[@class='rw-btn'])[2]")
	WebElement RepayementDate;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SaveInvoice;
	
	@FindBy(xpath="//div[@class='breadcrumb']/span[3]/a")
	WebElement InvoiceUID;

//Methods	

public AddInvoicePage_Admin(){
		
		PageFactory.initElements(driver, this);
			
		}
	
public String AddAsset(String LOB,String VendorId,String EnterpriseId) throws InterruptedException {
		
		    SelectInvoices.click();
    		AddNewInvoice.click();
	        
	       // driver.get(prop.getProperty("AddInvoiceURL"));
    
    		         
            InvoiceID.click();
			InvoiceID.sendKeys(TstUtl.generateInvoiceID());
			InvoiceValue.sendKeys(prop.getProperty("DealApprovedAmount"));
			InvoicePayable.sendKeys(prop.getProperty("DealApprovedAmount"));
			
			BorrowerUID.sendKeys(VendorId);
		    EnterpriseUID.sendKeys(EnterpriseId);
		    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		    
		      
		    JavascriptExecutor executor = (JavascriptExecutor)driver;
			
		    executor.executeScript("arguments[0].click()",IssueDateClk);
			executor.executeScript("arguments[0].click()",IssueDate);
			
		    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		        
		    executor.executeScript("arguments[0].click()",RepayementDateClk);
		    executor.executeScript("arguments[0].click()",RepayementDate);
		    
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			SaveInvoice.click();
		//	SaveInvoice.click();	
			AssetUID=InvoiceUID.getText();
		
			System.out.print("\nin uid---" + AssetUID);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
                
			driver.navigate().back(); 
			executor.executeScript("history.go(-1);", new Object[0]);      
           
           	return AssetUID;
			
	   
	}
	
	
	
public String AddInvoice_BOE(String VendorId, String EnterpriseId)
	{
		
		String InvoiceUID = null;
		return InvoiceUID;
	}
}
