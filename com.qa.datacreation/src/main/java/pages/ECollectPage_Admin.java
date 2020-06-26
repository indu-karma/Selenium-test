package pages;

import java.sql.SQLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utils.TestUtil;

public class ECollectPage_Admin extends TestBase {
	
	
	TestUtil TestUtil= new TestUtil();
    @FindBy(xpath="(//a[contains(text(),'ECollect')])[1]")
	WebElement SelectECollect;
	
	@FindBy(xpath="//a[contains(text(),'All ECollect Transactions')]")
	WebElement ClickAllECollectTransaction;
	
	@FindBy(xpath="//input[@placeholder='search ecollect transactions']")
	WebElement SearchEcollect;
	
	@FindBy(xpath="(//span[@class='glyphicon glyphicon-glyphicon glyphicon-pencil'])[2]")
	WebElement VerifyFeeTxn;
	
	@FindBy(xpath="(//span[@class='glyphicon glyphicon-glyphicon glyphicon-pencil'])[2]")
	WebElement VerifyPaymentDealTxn;
	
	@FindBy(xpath="//input[@name='utr']")
	WebElement utr;
	
	@FindBy(xpath="//input[@name='status']")
	WebElement status;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement SubmitBtn;
	
	@FindBy(xpath="//input[@name='mode_of_payment']")
	WebElement mode_of_payment;
	
	@FindBy(xpath="//div[contains(text(),'VERIFIED')]")
	WebElement DealTxnStatus;
	
	@FindBy(xpath="(//a[contains(text(),'ECollect')])[1]")
	WebElement CreateNewECollectTransaction;
	
	@FindBy(xpath="//a[contains(text(),\"Create new ECollect transaction\")]")
	WebElement ClickOnCreateNewECollectTransaction;
	     
	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement AccountNumber;
		
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement Amount;
		
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement UTR;
		
	@FindBy(xpath="(//div/select[@type='text'])[1]")
	WebElement ModeOfPayment;
		
	@FindBy(xpath="(//input[@type='text'])[4]")
	WebElement Remarks;
		
	@FindBy(xpath="(//input[@type='text'])[5]")
	WebElement RemitterName;
		
	@FindBy(xpath="(//input[@type='text'])[6]")
	WebElement RemitterDetails;
		
	@FindBy(xpath="(//input[@type='text'])[7]")
	WebElement TransactionDate;
		
	@FindBy(xpath="(//span[@class='rw-i rw-i-calendar'])[1]")
	WebElement ClickTransactionDate;
		
	@FindBy(xpath="(//button[@class='rw-btn'])[1]")
	WebElement SelectTransactionDate;
		
	@FindBy(xpath="//button[@type='submit']")
	WebElement Savebutton;
	
	@FindBy(xpath="//div[@class='breadcrumb']/span[3]/a")
	WebElement ECollectTransactionID;
	
	
	/*functions of page*/
	public ECollectPage_Admin(){
				
				PageFactory.initElements(driver, this);
    }
	
	public String VerifyDealTransaction(String DealTxn) {
		 String TxnStatus="";
		
		 SelectECollect.click();
		 ClickAllECollectTransaction.click();
		
		 SearchEcollect.sendKeys(DealTxn);
		
		 VerifyFeeTxn.click();
		 AddUTR(DealTxn);
		 VerifyPaymentDealTxn.click();
		 AddUTR(DealTxn);
		
				
	return TxnStatus;
		
			
	}
	
	
	public void ECollectCreatePage (String AccountNum, String AmountValues,String UTRID, String RemarkComments, String RemitterName1,
			String SelectModeOfPayment,String RemitterDetails1) {
			    	 
			   
				 CreateNewECollectTransaction.click();
				 ClickOnCreateNewECollectTransaction.click();
				 AccountNumber.sendKeys(AccountNum);
				 Amount.sendKeys(AmountValues);
				 UTR.sendKeys(UTRID);
				 Remarks.sendKeys(RemarkComments);
				 RemitterName.sendKeys(RemitterName1);
				 RemitterDetails.sendKeys(RemitterDetails1);
				 Savebutton.click();
								
						 
			     }	

	
	
	public void DateUpdate(String DealID) throws SQLException {
		
		TestUtil.UpdateListingDate(DealID);
		TestUtil.UpdateDueDate(DealID);
		
	}
	
	
	public void AddUTR(String DealTxn) {
		
		utr.sendKeys("utr"+DealTxn);
		//status
		Select DTxnStatus = new Select(status);
		DTxnStatus.selectByValue("VERIFY");
		
		Select DTxnMdOfPay= new Select(mode_of_payment);
		DTxnStatus.selectByValue("NEFT");

		SubmitBtn.click();
		
	}
	

}
