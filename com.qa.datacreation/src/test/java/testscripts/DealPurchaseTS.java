package testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ECollectPage_Admin;
import pages.LoginLogoutPage;
import utils.TestUtil;
import pages.DealPurchaseFrmFianacierPage;


public class DealPurchaseTS extends TestBase{
	
	LoginLogoutPage Adminlogin;
	DealPurchaseFrmFianacierPage DPFFPage;
	ECollectPage_Admin ECollect;
	
	TestUtil TestUtil;
	
	public DealPurchaseTS() {
			super();
	}
	
	@BeforeClass	
	public void setUp()
	{ 
	
		initilaization("Admin");
		Adminlogin = new LoginLogoutPage();
		Adminlogin.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	    
	
	@Test(priority=1)
	public void DealBooking()
	{
	 
		DPFFPage.DealBuy("", "");
		
	}

	@Test(priority=2)
	public void DealExecution()
	{
		
		ECollect.VerifyDealTransaction("");
	}
	
	@AfterClass
	public void tearDown()
	{
	//	driver.quit();
	} 

}


