package pages;

import java.sql.SQLException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utils.TestUtil;

public class InvestorAdminPage extends TestBase {
	
	public static Properties prop;
	InvestorUpdatePage InvestorUpdatePage = new InvestorUpdatePage();
	
	
	@FindBy(xpath="//input[@type='text']")
	WebElement SearchInvestorId;
	
	
	
	/*Web Elements*/
	//URL=https://harry.kredx.com/login
	//userName=//input[@id='email']
	//pwd=//input[@id='password']
	//signInBtn=//button[@type='submit']
	
	//otp=//input[@id='otp']
	//button[@class='kx-btn kx-btn__primary']
	
	
	
	
	
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
	
	
	public InvestorUpdatePage SearchFinancier() throws ClassNotFoundException, SQLException{
		
	String InvestorUid= TestUtil.getFinancierFrmDb("indu+finan004@kredx.com");	
	SearchInvestorId.sendKeys(InvestorUid);
	
	return InvestorUpdatePage;
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
