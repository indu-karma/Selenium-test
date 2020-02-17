package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import pages.AddInvoicePage_Admin;

public class DealUpdationPage {
	
	
	

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
	
	
	
	
	
	/*---------------------------------------------*/
	
	public String DealUpdate(String DealApprovedAmount,String DealTenure,String DealMonthlyDiscountPt,String AddCostBorneBy) {
		
		
		String DealId = null;
		
		
		ApprovedAmount.sendKeys(DealApprovedAmount);
		Tenure.sendKeys(DealTenure);
		MonthlyDiscountPt.sendKeys(DealMonthlyDiscountPt);
		MinAmountPurchase.sendKeys("10000");
		CostBorneBy.sendKeys(AddCostBorneBy);
		SaveDeal.click();
		
		
		
		return DealId;
	}
	
	public String AddAsset(int InvoiceCount, String LOB,String VendorId,String EnterpriseId) {
		
		AddInvoicePage_Admin AddInvoicePage = new AddInvoicePage_Admin();
		
		String AssetUID=null;
		
		if (LOB=="Recivables") {
			Select AssetTypeSelect = new Select(AssetType);
			AssetTypeSelect.selectByValue("Invoice");		
			InvoiceUID.sendKeys(AddInvoicePage.AddInvoice_Invoice(VendorId, EnterpriseId));
			
			
		}else if (LOB=="Paybles")
		{
			
		}else 
		{
			
		}
		
		
		return AssetUID;
	}
	
	public void DealReportUpload(WebDriver driver) throws IOException{
		
		UploadDealReport.click();
		 driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);	
		 Runtime.getRuntime().exec("C:\\Users\\DELL\\Desktop\\Auto_Data creation\\uploadaddress\\fileup.exe");
	}
	
	
	
}
