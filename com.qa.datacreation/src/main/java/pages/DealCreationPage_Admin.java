package pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;


import base.TestBase;
import utils.TestUtil;

public class DealCreationPage_Admin extends TestBase{
	
	    TestUtil TestUtil;
		@FindBy(xpath="(//div/select[@type='text'])[1]")
	    WebElement TypeOfDeal;
		
		@FindBy(xpath="(//div/select[@type='text'])[2]")
		WebElement LineOfBusiness;
		
		
		@FindBy(xpath="(//div[@class='Select-placeholder'])[1]")
		WebElement PaidToCompany;
		
		@FindBy(xpath="(//div[@class='Select-placeholder'])[2]")
		WebElement ObligationID;
		
		
		@FindBy(xpath="(//div[@class='Select-placeholder'])[3]")
		WebElement RecourseOn;
		
		@FindBy(xpath="//button[@type='submit']")
		WebElement Submitbutton;
		
		@FindBy(xpath="//button[@class='btn btn-kredx-secondary mtm']")
		WebElement ContinueBtn;
		
		@FindBy(xpath="(//a[contains(text(),'Deals')])[1]")
		WebElement SelectDeals;
		
		@FindBy(xpath="//a[contains(text(),\"Add New Deal\")]")
		WebElement ClickOnAddNewDeals;

		@FindBy(xpath="//div[@class='breadcrumb']/span[3]/a")
		WebElement DealUID;
		
		
/*functions of page*/
public DealCreationPage_Admin(){
			
			PageFactory.initElements(driver, this);
			
				
			}
	
	
	//Add new Deal Page
 public DealUpdationPage CreateDeal(String VendorID, String EnterpriseID, String SelectTypeOfDeal,String LOB) {
    	 
    	 
	   
         SelectDeals.click();
      	 ClickOnAddNewDeals.click();
    	 
    	 //select type of deal
    	 Select TypeOfDealSelect = new Select(TypeOfDeal);
    	 TypeOfDealSelect.selectByValue(SelectTypeOfDeal);
    	 
    	 System.out.print("LOB");
    	 Select LineOfBusinessSelect = new Select(LineOfBusiness);
    	 LineOfBusinessSelect.selectByValue(LOB);
    	 
    	 TestUtil.selectCompanyID(RecourseOn, VendorID);
    	 TestUtil.selectCompanyID(ObligationID, EnterpriseID);
    	 TestUtil.selectCompanyID(PaidToCompany, VendorID);
    	
    	 Submitbutton.click();
    	 ContinueBtn.click();
    	 
    	 //UID provided for Company is invalid

 		return  new DealUpdationPage();	 
     }	

}
