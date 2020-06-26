package pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import pages.AddInvoicePage_Admin;
import utils.TestUtil;


public class DealUpdationPage extends TestBase {
	
	AddInvoicePage_Admin invoicepage;
	LoginLogoutPage Vendorlogin;
	LoginLogoutPage Adminlogin;
	TestUtil TestUtil;
	DealCreationPage_Admin DcP;
	String DealdPrint = null;

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
	
	@FindBy(xpath="//button[contains(text(),'Send For Approval')]")
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
		
		invoicepage = new AddInvoicePage_Admin();
		TestUtil= new TestUtil();
		
		ApprovedAmount.click();
		ApprovedAmount.sendKeys(Keys.BACK_SPACE);
		ApprovedAmount.sendKeys(DealApprovedAmount);
		
		
		Tenure.click();
		Tenure.sendKeys(Keys.CONTROL,"a");
		Tenure.sendKeys(Keys.BACK_SPACE);
		Tenure.sendKeys(DealTenure);
		
		MonthlyDiscountPt.sendKeys(Keys.BACK_SPACE);
	    MonthlyDiscountPt.sendKeys(DealMonthlyDiscountPt);
		
	    MinAmountPurchase.sendKeys(Keys.BACK_SPACE);
		MinAmountPurchase.sendKeys(MinPurAmt);
		
		SaveDeal.click();
	
		//selectCompanyID(CostBorneBy, AddCostBorneBy);
		
		//Add Invoice	
	
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
 			
			
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
		
	   TestUtil.UploadDocument(driver, UploadDealReport);
       // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					
		
		
		Thread.sleep(5000);
		SaveDeal.click();
		OKDealBtn.click();
		DealdPrint=DealUID.getAttribute("innerHTML");
		System.out.print("Deal ID--"+DealdPrint);
		return DealdPrint;
	}
	
	public void SendForApproval(String DealID, String VendorID) throws SQLException, InterruptedException {
		
		//driver.getCurrentUrl();
		
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
		System.out.print("\nvendor id:--"+VendorID);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(SendForApprovalBtn));		
		
		Thread.sleep(5000);
		SendForApprovalBtn.click();
		
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
			
}
	
   public void DealSignFromVendor(String DealID,String vendorID) throws Exception
   {
	    
    	
	    String AgreementURL="//https://"+prop.getProperty("environment")+".kredx.com/vendor/dashboard/deals/"+DealID+"/agreement";
	   
        System.out.print("\nAgreement:--"+AgreementURL);
	    driver.get(AgreementURL);
	    //ClickOnNotification.click();
        SignAgreementBtn.click();
        ClickHereToSignBtn.click();
        driver.switchTo().activeElement();
        AcceptAndSendOTPBtn.click();
        // AcceptAndSendOTPBtn.click();
       
        EnterOTP.sendKeys("000000");
        VerifyBtn.click();
       
        Vendorlogin.logout(); 
	   
   }
   
   
   public static void selectCompanyID(WebElement CompanyIDXpath,String CompanyID) {
		
	//org.openqa.selenium.interactions.Actions builder = new org.openqa.selenium.interactions.Actions(driver);
	   
		Actions builder = new Actions(driver);
	    Action mouseOverHome = builder
	   		 .moveToElement(CompanyIDXpath)
	   		 .clickAndHold()
	   		 .sendKeys(CompanyID)
	   		 .sendKeys(Keys.ARROW_DOWN)
	   		 .sendKeys(Keys.ENTER)
	   		 .build();
	    
	    mouseOverHome.perform();
	}
   	
	
	
	public void ListDealOnPlatform() {
		
		ClickListDealOnPlatform.click();
		DealVisibleOnPlatform.click();
		SaveDeal.click();
		
	}

	public void DealLiveOnPlatform(String DealID) throws SQLException
	{
		TestUtil.UpdatePlatformListingDate(DealID);  
		
	}
	
	
	public void DownloadCalculationSheet() {}
	public void UploadInvoiceInBulk() {}
	public void CreateInvoice() {}
	
}
