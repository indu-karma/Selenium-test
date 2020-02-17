package testscripts;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import pages.AdminLoginPage;
import pages.DealCreationPage_Admin;


public class DealCreationTS extends TestBase{
	
	AdminLoginPage Adminlogin;
	DealCreationPage_Admin dcpa = new DealCreationPage_Admin();
	
	public DealCreationTS() {
			super();
	}
	
	@BeforeMethod	
	public void setUp()
	{ 
		initilaization();
		Adminlogin = new AdminLoginPage();
		Adminlogin.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	    
	//Add new deal details
	@Test
	public void DealCreateNew() throws IOException {
		
		dcpa.CreateDeal(prop.getProperty("VendorID"),prop.getProperty("EnterpriseID"),prop.getProperty("TypeOfDeal"),prop.getProperty("LOB"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	//public void DealUpdatePage() {}
	//public void DealAddAssert() {}
	
	
	
}
