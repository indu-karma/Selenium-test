package pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;


public class InvestorUpdatePage extends TestBase{
	
	public static Properties prop;
	
	@FindBy(xpath="//span[@class='glyphicon glyphicon-glyphicon glyphicon-pencil']")
	WebElement UpdateInvestor;
	
	@FindBy(xpath="//a[@id='Details-tab-2']")
	WebElement KYCDetailTab;
	
	@FindBy(id="id_proof.verification.latest.status")
	WebElement VerifyPanCard;
	
	@FindBy(name="address_proof.verification.latest.status")
	WebElement VerifyAddressProof;
	
	@FindBy(xpath="//button[@class='btn btn-kredx-primary btn btn-default']")
	WebElement SubmitKYC;
	
	@FindBy(xpath="btn btn-kredx-secondary  mhs")
	WebElement AddWallet;
	
	public InvestorUpdatePage(){
		
		PageFactory.initElements(driver, this);
			
		}
	
	//Functions
	public void updateKYCDetails() {
	
		
	UpdateInvestor.click();
	KYCDetailTab.click();
	Select PanCardKYCStatus = new Select(VerifyPanCard);
	PanCardKYCStatus.selectByVisibleText("VERIFIED");
		
	Select AddressKYCStatus = new Select(VerifyAddressProof);
	AddressKYCStatus.selectByVisibleText("VERIFIED");
	
	SubmitKYC.click();
	AddWallet.click();
	
	
	}
	

	public void AddCreditLine()
	{
		
		
	}
}
