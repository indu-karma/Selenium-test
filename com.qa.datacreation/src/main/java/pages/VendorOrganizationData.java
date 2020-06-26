package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utils.TestUtil;

public class VendorOrganizationData extends TestBase {
	
	
	
	//Company details element
		@FindBy(xpath = "//*[text()='Organization Name']/..//input")
	    WebElement organizationName;
	    
	    @FindBy(xpath = "//label[text()='Organization Type']/..//input[1]")
	    WebElement organizationType;
	    
	    @FindBy(xpath="//span[text()='PROPRIETORSHIP']")
	    WebElement proprietorship;
	    
	    @FindBy(xpath = "//label[text()='Type of Industry']/..//input[1]")
	    WebElement typeOfIndustry;
	    
	    @FindBy(xpath = "//span[text()='AEROSPACE']")
	    WebElement aerospace;
	    
	    @FindBy(xpath = "//*[text()='Company PAN']/..//input")
	    WebElement panNumberField;
	
	 //Registered Address
	    
	  @FindBy(xpath="//input[@name='registered_address.street_address']")
	  WebElement organizationAddress;
	  
	  @FindBy(xpath="//input[@name='registered_address.pincode']")
	  WebElement organizationPincode;
	  
	  @FindBy(xpath="//input[@name='registered_address.city']")
	  WebElement organizationCity;
	  
	  @FindBy(xpath="//label[text()='State']/..//input[1]")
	  WebElement organizationState;
	  
	  @FindBy(xpath="//span[text()='Karnataka']")
	  WebElement selectstate;
	  
	  @FindBy(xpath="//button[@type='submit']")
	  WebElement Savebutton;
	   
	
	

    /*functions of page*/
    public VendorOrganizationData(){
    			
    			PageFactory.initElements(driver, this);
    			
    }
    
    
    public void VendorOrganizationDetails() {
    	
    	
    	organizationName.sendKeys("orgtest");
	    
	   organizationType.click();
	    
	    proprietorship.click();
	    
	    typeOfIndustry.click();
	    
	    aerospace.click();
	    
	   panNumberField.sendKeys("BYYPK"+"28"+TestUtil.randomno()+"H");
	
	 //Registered Address
	    
	  organizationAddress.sendKeys("Bellandur");;
	  
	  organizationPincode.sendKeys("560048");;
	  
	  organizationCity.sendKeys("Bangalore");;
	  
	  organizationState.click();;
	  
	  selectstate.click();
	  
	  Savebutton.click();
    	
    	
    	
    }
    

}
