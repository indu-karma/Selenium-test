package pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import pages.AddInvoicePage_Admin;
import utils.TestUtil;

public class DealUpdationPage extends TestBase {
	
	AddInvoicePage_Admin invoicepage;
	LoginPage Vendorlogin;
	TestUtil TestUtils;
	

	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement ApprovedAmount;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement Tenure;
	
	@FindBy(xpath="(//input[@type='text'])[5]")
	WebElement MonthlyDiscountPt;
	
	@FindBy(xpath="(//input[@type='text'])[10]")
	WebElement MinAmountPurchase;
	
	@FindBy(xpath="//div[@class='Select-placeholder']")
	WebElement CostBorneBy;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SaveDeal;
	
	@FindBy(xpath="//span[@class='upload-icon']")
	WebElement UploadDealReport;
	
	@FindBy(xpath="(//select[@type='text'])[6]")
	WebElement AssetType;
	
	@FindBy(xpath="(//input[@type='text'])[17]")
	WebElement InvoiceUID;
	
	@FindBy(xpath="//a[@class='btn-link fz16']")
	WebElement SingleInvoiceClk;
	
	@FindBy(xpath="//a[@class='btn-link fz16 pull-right']")
	WebElement MultipleInvoiceClk;
	
	@FindBy(xpath="//div[@class='breadcrumb']/span[3]/a")
	WebElement DealUID;
	
	@FindBy(xpath="//button[@class='btn btn-sm btn-default']")
	WebElement AddInvoicebtn;
	
	@FindBy(xpath="//button[@class='close']")
	WebElement CloseDealUpdateWin;
	
	@FindBy(xpath="//button[@class='rrt-button rrt-ok-btn toastr-control']")
	WebElement OKDealBtn;
	
	@FindBy(xpath="(//button[@class='btn btn-kredx-secondary mls'])[2]")
	WebElement SendForApprovalBtn;
	
	@FindBy(xpath="(//a[contains(text(),'Deals')])[1]")
	WebElement SelectDeals;
	
	@FindBy(xpath="//a[contains(text(),\"List Deals\")]")
	WebElement ClickOnListDeals;
	
	@FindBy(xpath="//input[@class='sk-search-box__text']")
	WebElement SearchDeal;
	
	@FindBy(xpath="//span[@class='glyphicon glyphicon-glyphicon glyphicon-pencil']")
	WebElement ClickOnEditDeal;
	
	@FindBy(xpath="//i[@class='fa fa-bell']")
	WebElement ClickOnNotification;
	
	@FindBy(xpath="//button[@class='btn btn-kredx-secondary pending-task-btn']")
	WebElement SignAgreementBtn;
	
	@FindBy(xpath="//button[@class='btn btn-kredx-special']")
	WebElement ClickHereToSignBtn;
	
	@FindBy(xpath="//button[@class='btn btn-kredx-primary btn-lg accept-send-otp-button']")
	WebElement AcceptAndSendOTPBtn;
	
	@FindBy(xpath="//label[@class='kx-form__unit-label']")
	WebElement EnterOTP;
	
	@FindBy(xpath="//button[@class='kx-btn kx-btn__primary']")
	WebElement VerifyBtn;
	
	@FindBy(xpath="(//button[@class='btn btn-kredx-secondary mls'])[2]")
	WebElement ClickListDealOnPlatform;
	
	@FindBy(xpath="//label[@for='is_listedyes']")
	WebElement DealVisibleOnPlatform;
	
	
	/*---------------------------------------------*/

	/*functions of page*/
public DealUpdationPage(){
				
				PageFactory.initElements(driver, this);
					
				}
	
	
public String DealUpdateWithoutInvoice(String DealApprovedAmount,String DealTenure,String DealMonthlyDiscountPt,String AddCostBorneBy, String MinPurAmt) {
		
		
		String DealId = null;
		invoicepage = new AddInvoicePage_Admin();
		ApprovedAmount.click();
	//	ApprovedAmount.sendKeys(Keys.BACK_SPACE);
		ApprovedAmount.sendKeys(DealApprovedAmount);
		
		Tenure.click();
		Tenure.sendKeys(Keys.CONTROL,"a");
		Tenure.sendKeys(Keys.DELETE);
		Tenure.sendKeys(DealTenure);
		
		MonthlyDiscountPt.sendKeys(Keys.BACK_SPACE);
	    MonthlyDiscountPt.sendKeys(DealMonthlyDiscountPt);
		
	  //  MinAmountPurchase.sendKeys(Keys.BACK_SPACE);
		MinAmountPurchase.sendKeys(MinPurAmt);
		
		
						
		SaveDeal.click();
		OKDealBtn.click();
		
		DealId=DealUID.getAttribute("href");
		return DealId;
	}
	
	
	public String DealUpdateWithInvoice(String DealApprovedAmount,String DealTenure,String DealMonthlyDiscountPt,String AddCostBorneBy, String MinPurAmt,String NoOfInvoice) throws IOException, InterruptedException {
		
		
		String DealId = null;
		invoicepage = new AddInvoicePage_Admin();
		
		ApprovedAmount.click();
		//ApprovedAmount.sendKeys(Keys.BACK_SPACE);
		ApprovedAmount.sendKeys(DealApprovedAmount);
		
		Tenure.click();
		Tenure.sendKeys(Keys.CONTROL,"a");
		Tenure.sendKeys(Keys.DELETE);
		Tenure.sendKeys(DealTenure);
		
		MonthlyDiscountPt.sendKeys(Keys.BACK_SPACE);
	    MonthlyDiscountPt.sendKeys(DealMonthlyDiscountPt);
		
	    //MinAmountPurchase.sendKeys(Keys.BACK_SPACE);
		MinAmountPurchase.sendKeys(MinPurAmt);
		
		SaveDeal.click();
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
   //    for (int i=1;i<=Integer.parseInt(NoOfInvoice);i++) {
		
	//	if (i == 1) {
			
		//	System.out.println("i=="+i);
			
			
			
			String IUID=invoicepage.AddAsset(prop.getProperty("LOB"),
					prop.getProperty("VendorID"),
					prop.getProperty("EnterpriseID"));
			System.out.print("\nIUID--"+IUID);
	
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click()",SingleInvoiceClk);
			   		
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
			Select AssetTypeSelect = new Select(AssetType);
			AssetTypeSelect.selectByIndex(1);

			AddInvoicebtn.click();
			InvoiceUID.click();
			InvoiceUID.sendKeys(IUID);
		
		//}
		//*else {
		//		MultipleInvoiceClk.click(); }
	    		
		  //      InvoiceUID.sendKeys(invoicepage.AddAsset(prop.getProperty("LOB"), 
	     //		prop.getProperty("VendorID"),
	     	//	prop.getProperty("EnterpriseID")));
	//}	
		
			
			
        TestUtils.UploadDocument(driver, UploadDealReport);
					
		SaveDeal.click();
		OKDealBtn.click();
		
		Thread.sleep(5000);
		SaveDeal.click();

		DealId=DealUID.getText();
		System.out.print("Deal ID--"+DealId);
		return DealId;
	}
	
	public void SendForApproval(String DealID, String VendorID) throws SQLException {
		
		driver.getCurrentUrl();
		
		if(DealID!=DealUID.getText() && SendForApprovalBtn.isEnabled()!=true) {
			
			//search deal id
		    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			SelectDeals.click();
			ClickOnListDeals.click();
			
			SearchDeal.sendKeys(DealID);
			SearchDeal.click();
			ClickOnEditDeal.click();
			AcceptAndSendOTPBtn.click();
			
				
		}
		
		SendForApprovalBtn.click();
		
		DealSignFromVendor(VendorID);
		//verify deal status
		
		
	}
	
   public void DealSignFromVendor(String vendorID) throws SQLException
   {
	   initilaization_Vendor();
	   Vendorlogin = new LoginPage();
       Vendorlogin.adminLogin(TestUtil.CompanyUserEmailID(vendorID), prop.getProperty("vendorPassword"));
	  
       ClickOnNotification.click();
       SignAgreementBtn.click();
       ClickHereToSignBtn.click();
       
       driver.close();
	 	    
	   
   }
   
   	
	
	
	public void ListDealOnPlatform() {
		
		ClickListDealOnPlatform.click();
		DealVisibleOnPlatform.click();
		SaveDeal.click();
		
	}

	public void DealLiveOnPlatform(String DealID) throws SQLException
	{
		TestUtils.UpdatePlatformListingDate(DealID);  
		
	}
	
	
	public void DownloadCalculationSheet() {}
	public void UploadInvoiceInBulk() {}
	public void CreateInvoice() {}
	
}
