package pages;

import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utils.TestUtil;

public class InvestorAdminPage extends TestBase {
	
	
//	InvestorUpdatePage InvestorUpdatePage = new InvestorUpdatePage();
	
	@FindBy(xpath="//a[text()='Users']")
	WebElement ClickUsers;
	
	@FindBy(xpath="//a[text()='List Financiers']")
	WebElement ClickListFinanciers;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement SearchInvestorId;
	
	@FindBy(xpath="//span[@title='Update']")
	WebElement UpdateFinancier;
	
	@FindBy(xpath="//a[text()='KYC Detail']")
	WebElement SelectKYCDetails;
	
	@FindBy(name="id_proof.verification.latest.status")
	WebElement VerifyPanCard;
	
	@FindBy(name="address_proof.verification.latest.status")
	WebElement VerifyAddressProof;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement SubmitKYC;
	
	@FindBy(xpath="//a[text()='Add Wallet']")
	WebElement AddWallet;
	
	//SearchFinanciersElement
	
	//dashboardFinancerBtn
	//updateFinancierBtn
	//ChangePanCardStatus
	//ChangeAddessProofStatus
	//UpdateFinancierKYCBtn
	//CreateFinancierWallet
	
	public InvestorAdminPage(){
		
		PageFactory.initElements(driver, this);
			
		}
	
	
	/*Functions*/
	
	
	
	public void SearchFinancier(String InvestorUid) throws ClassNotFoundException, SQLException{
	
		
		
		ClickUsers.click();
		ClickListFinanciers.click();
	
		
		
		//SearchInvestorId.sendKeys(InvestorUid);
		//UpdateFinancier.click();
		driver.get("https://"+prop.getProperty("environment")+".kredx.com/admin/dashboard/user/financiers/"+InvestorUid+"/update");
		SelectKYCDetails.click();
		
		
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()",VerifyPanCard);
	
		Select PanCardKYCStatus = new Select(VerifyPanCard);
		PanCardKYCStatus.selectByVisibleText("VERIFIED");
			
		Select AddressKYCStatus = new Select(VerifyAddressProof);
		AddressKYCStatus.selectByVisibleText("VERIFIED");
		
		SubmitKYC.click();
		AddWallet.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//verify wallet created
	   	}
	
	
	//InvestorDashboard()
	
	/*InvestorUpdate_VerifyKYCDetails(){
	 //click on update button in action column
	//ChangePanCardStatus
	//ChangeAddessProofStatus
	 }
	 //InvestorUserLockReset()
	  //InvestorChangeRole()
	   //InvestorOnBoardStatus()
	  
	
	
    */
}
