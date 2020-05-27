package testscripts;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.TestBase;
import pages.LoginPage;
import utils.TestUtil;
import pages.DealCreationPage_Admin;
import pages.DealUpdationPage;


public class DealCreationTS extends TestBase{
	
	
	LoginPage Adminlogin;
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
		Adminlogin = new LoginPage();
		Adminlogin.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	    
	//Add new deal details
	@Test(priority=1)
	public void DealCreateNew() throws IOException {
		
		dcpa = new DealCreationPage_Admin();
		//TestUtil = new TestUtil();
		dcpa.CreateDeal(prop.getProperty("VendorID"),
				prop.getProperty("EnterpriseID"),
				prop.getProperty("TypeOfDeal"),
				prop.getProperty("LOB"));
	}
	
	@Test(priority=2)
	public void DealUpdatePage() throws IOException, InterruptedException, SQLException {
	
		dup=new DealUpdationPage();
        
		String dealID=dup.DealUpdateWithInvoice(prop.getProperty("DealApprovedAmount"), 
        		prop.getProperty("DealTenure"),
        		prop.getProperty("DealMonthlyDiscountPt"),
        		prop.getProperty("VendorID"),
        		prop.getProperty("MinPurchaseAmount"),
        		prop.getProperty("NoOfInvoice"));
          System.out.print("\ndeal created as deal id--"+dealID);

        //Deal send for vendor approval
          
        dup=new DealUpdationPage();
		dup.SendForApproval(dealID, prop.getProperty("VendorID"));
	
		//Deal sign from Vendor
		
	
	}
	
	
	@AfterClass
	public void tearDown()
	{
	//	driver.quit();
	} 
	
}
