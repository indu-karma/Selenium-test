package pages;

import java.sql.SQLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utils.TestUtil;

public class DealExecutionPage_Admin extends TestBase {

	

	

	
	
	
	
	/*functions of page*/
	public DealExecutionPage_Admin(){
				
				PageFactory.initElements(driver, this);
    }
	
	
	public void DealExecution(String DealID) throws SQLException {
		
		String DealTransID=TestUtil.DealTransactionID(DealID);
		//DTEMD6D50Q
		
		
		
	}
	
	
}
