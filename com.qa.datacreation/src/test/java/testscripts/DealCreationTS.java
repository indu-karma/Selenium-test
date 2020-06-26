package testscripts;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.TestBase;
import pages.LoginLogoutPage;
import utils.TestUtil;
import pages.DealCreationPage_Admin;
import pages.DealUpdationPage;


public class DealCreationTS extends TestBase{
	
	
	LoginLogoutPage Adminlogin;
	DealCreationPage_Admin dcpa; 
	DealUpdationPage dup;
	TestUtil TestUtil;
	
	public DealCreationTS() {
			super();
	}
	
	@BeforeClass	
	public void setUp()
	{ 
	
		initilaization("Admin");
		Adminlogin = new LoginLogoutPage();
		Adminlogin.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	    
	//Add new deal details
	@Test(priority=1)
	public void DealCreateNew() throws IOException {
		
		dcpa = new DealCreationPage_Admin();
		dcpa.CreateDeal(prop.getProperty("VendorID"),
				prop.getProperty("EnterpriseID"),
				prop.getProperty("TypeOfDeal"),
				prop.getProperty("LOB"));
	}
	
	@Test(priority=2)
	public void DealUpdatePage() throws Exception {
	
		dup=new DealUpdationPage();
        
		String dealID=dup.DealUpdateWithInvoice(prop.getProperty("DealApprovedAmount"), 
        		prop.getProperty("DealTenure"),
        		prop.getProperty("DealMonthlyDiscountPt"),
        		prop.getProperty("VendorID"),
        		prop.getProperty("MinPurchaseAmount"),
        		prop.getProperty("NoOfInvoice"));
          System.out.print("\ndeal created as deal id--"+dealID);

        /*--------------------------Deal send for vendor approval--------------------*/
        System.out.print("\nvendor id--"+prop.getProperty("VendorID"));  
     	dup.SendForApproval(dealID, prop.getProperty("VendorID"));
     	Adminlogin.adminLogout();
	
		/*---------------------Deal sign from Vendor--------------------------------*/
     	String emailid=utils.TestUtil.CompanyUserEmailID(prop.getProperty("VendorID"));
	    String VendorEMailID= emailid.replaceAll("^\"|\"$", "");
    	Adminlogin.adminLogin(VendorEMailID,prop.getProperty("userPassword"));
     	
     	dup.DealSignFromVendor(dealID,prop.getProperty("VendorID"));
     
     	dup.ListDealOnPlatform();
     	
    	dup.DealLiveOnPlatform(dealID);
     	
    	
     	//DE20WO26X9
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
	//	driver.quit();
	} 
	
}
