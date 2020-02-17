package testscripts;

import base.TestBase;
import pages.InvestorAdminPage;
import pages.InvestorKYC_upload;
import pages.InvestorRegisterPage;
import pages.InvestorSLASigning;
import pages.InvestorUpdatePage;

import java.io.IOException;
import java.sql.SQLException;

public class InvestorOnboardingTS extends TestBase{
	
	
	InvestorRegisterPage InvestorRegisterPage;
	InvestorKYC_upload InvestorKYC_upload;
	InvestorAdminPage InvestorAdminPage;
	InvestorUpdatePage InvestorUpdatePage;
	InvestorSLASigning InvestorSLASigning; 
	
	//Investor Registration
	public void InvestorRegistration() {
	initilaization();
    InvestorRegisterPage = new InvestorRegisterPage();
    String Name = null, MobNo = null, Email = null, Pwd = null, referralCd = null;
    InvestorRegisterPage.AddInvestorMainDetails(Name, MobNo, Email, Pwd, referralCd);
	}
	
	
	//Investor KYC Upload
	public void InvestorKYC_upload() throws IOException, InterruptedException {
		initilaization();
		InvestorKYC_upload = new InvestorKYC_upload();	
		InvestorKYC_upload.UploadAddressKYCDetails("test", "Bangalore", "", "560048");
		Thread.sleep(2000);
		InvestorKYC_upload.UploadPANCardKYCDetails("09/09/1987", "APKPK2887H");
		
	}
	//Investor KYC verification
	public void InvestorKYCVerification() throws ClassNotFoundException, SQLException{
		initilaization();
		InvestorAdminPage = new InvestorAdminPage();
		InvestorUpdatePage = new InvestorUpdatePage();
		InvestorAdminPage.SearchFinancier();
		InvestorUpdatePage.updateKYCDetails();
		
	}
	
	
	//Investor SLA upload
	public void InvestorSLAUpload() {
		initilaization();
		InvestorSLASigning = new InvestorSLASigning();
		InvestorSLASigning.SignSLA();
		
	}
	//Investor Onboarded confirmation
	//Investor Add Wallet

	
}
