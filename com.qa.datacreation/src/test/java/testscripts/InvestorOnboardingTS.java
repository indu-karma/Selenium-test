package testscripts;

import base.TestBase;
import pages.InvestorAdminPage;
import pages.InvestorKYC_upload;
import pages.InvestorRegisterPage;
import pages.InvestorSLASigning;
import pages.InvestorUpdatePage;
import pages.LoginPage;
import utils.TestUtil;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InvestorOnboardingTS extends TestBase{
	
	
	InvestorRegisterPage InvestorRegisterPage;
	InvestorKYC_upload InvestorKYC_upload;
	InvestorAdminPage InvestorAdminPage;
	InvestorUpdatePage InvestorUpdatePage;
	InvestorSLASigning InvestorSLASigning;
	LoginPage Adminlogin;
	TestUtil TestUtil;
	
	public InvestorOnboardingTS() {
		super();
     }

	
	@BeforeClass
	public void setUp()
	{ 
	
		initilaization("Investor");
		
	}
	
	@Test(priority=1)
	//Investor Registration
		public void InvestorRegistration() {
		
	    InvestorRegisterPage = new InvestorRegisterPage();
	    String Name = "finan", MobNo = "9886765251", Email = "indu+financ11"+TestUtil.randomno()+"@kredx.com", Pwd = "kredxtest", referralCd = null;
	    InvestorRegisterPage.AddInvestorMainDetails(Name, MobNo, Email, Pwd, referralCd);
	}
	
	@Test(priority=2)
		//Investor KYC Upload
		public void InvestorKYC_upload() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		
		InvestorKYC_upload = new InvestorKYC_upload();	
		TestUtil = new TestUtil();
	
		InvestorKYC_upload.UploadAddressKYCDetails("test", "Bangalore", "", "560048");
		Thread.sleep(2000);
		InvestorKYC_upload.UploadPANCardKYCDetails("09/09/1987",TestUtil.generateRandomNamePancardNumber());
	
		String InvestorEmailID=InvestorKYC_upload.GetInvestorEmailAddress();
		String InvestorID=InvestorKYC_upload.verifyFinancierEmailAndMobile(InvestorEmailID);
		
		System.out.print("InvestorID:---"+InvestorID+"\nInvestorEmailID:----"+InvestorEmailID);
		driver.close();
		
	
		/*Verify Investor KYC from Admin*/
	
		//Admin login
		
		initilaization("Admin");
		Adminlogin = new LoginPage();
		Adminlogin.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
		//KYC verification
		InvestorAdminPage = new InvestorAdminPage();
		InvestorAdminPage.SearchFinancier(InvestorID);
		
		
		/*Sign SLA and Investor Onboarding*/
	
		//Investor Login
		
		initilaization("Userlogin");
		Adminlogin = new LoginPage();
		Adminlogin.adminLogin(InvestorEmailID, "kredxtest");
			
		//SLA Signing
		InvestorSLASigning = new InvestorSLASigning();
		InvestorSLASigning.SignSLA();
}	
		
		
		
		
		
		
}
	
	
	


	

