package testscripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.VendorFinancialsData;
import pages.VendorOrganizationData;
import pages.VendorRegisterPage_Admin;



public class VendorOnboardingTS extends TestBase{
	
	VendorRegisterPage_Admin vendRegPag;
	VendorOrganizationData venOrgData;
	VendorFinancialsData venFinData;
	
	
	public VendorOnboardingTS() {
			super();
	}
	
	@BeforeClass	
	public void setUp()
	{ 
		initilaization_Vendor();
		
	}
	    
	//Add new Vendor details
	@Test(priority=1)
	public void VendorRegistration() throws IOException {
		vendRegPag= new VendorRegisterPage_Admin();
		vendRegPag.VendorRegisterDetails();
	}
	
	@Test(priority=2)
	public void VendorOrganizationDetail()
	{
		venOrgData=new VendorOrganizationData();
		venOrgData.VendorOrganizationDetails();
		
	}
	
	@Test(priority=3)
	public void UploadVendorFinancierDetail() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		venFinData=new VendorFinancialsData();
		venFinData.AddVenFinanDetails();
		
	}

}
