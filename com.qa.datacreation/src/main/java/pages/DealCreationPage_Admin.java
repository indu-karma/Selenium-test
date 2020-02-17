package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class DealCreationPage_Admin extends TestBase{
	
	//Select Type = text

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
		
	
	
	
	//Add new Deal Page
     public DealUpdationPage CreateDeal(String VendorID, String EnterpriseID, String SelectTypeOfDeal,String LOB) {
    	 
    	driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
    	SelectDeals.click();
    	//Actions action = new Actions(driver);
    	//action.contextClick(SelectDeals).contextClick(ClickOnAddNewDeals).build().perform();
       //action.moveToElement(SelectDeals).moveToElement(ClickOnAddNewDeals).click().build().perform();
      
    	
  
    	 ClickOnAddNewDeals.click();
    	 
    	 //select type of deal
    	 Select TypeOfDealSelect = new Select(TypeOfDeal);
    	 TypeOfDealSelect.selectByValue(SelectTypeOfDeal);
    	 
    	 System.out.print("enter2");
    	 Select LineOfBusinessSelect = new Select(LineOfBusiness);
    	 LineOfBusinessSelect.selectByValue(LOB);
    	 
    	 
    	 PaidToCompany.sendKeys(VendorID);
    	 ObligationID.sendKeys(EnterpriseID);
    	 RecourseOn.sendKeys(VendorID);
    	 
    	 Submitbutton.click();
    	 ContinueBtn.click();
    	 
    	 return new DealUpdationPage();   	 
     }	

}
