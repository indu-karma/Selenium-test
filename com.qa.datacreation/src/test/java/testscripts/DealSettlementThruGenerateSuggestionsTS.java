package testscripts;

import java.sql.SQLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginLogoutPage;
import utils.TestUtil;
import pages.ECollectPage_Admin;

public class DealSettlementThruGenerateSuggestionsTS extends TestBase{
	
	TestUtil TestUtil;
	LoginLogoutPage Adminlogin;
	ECollectPage_Admin ECollectPage_Admin;
	
	
	public DealSettlementThruGenerateSuggestionsTS() {
		super();
	}

	
	@BeforeClass	
	public void setUp()
	{ 
	
		initilaization("Admin");
		Adminlogin = new LoginLogoutPage();
		Adminlogin.adminLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void DealSettlementThruGenerateSuggestions() throws SQLException {
		
		ECollectPage_Admin.DateUpdate("");
		//ECollectPage_Admin.ECollectCreatePage(AccountNum, AmountValues, UTRID, RemarkComments, RemitterName1, SelectModeOfPayment, RemitterDetails1);
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		
	}
}
