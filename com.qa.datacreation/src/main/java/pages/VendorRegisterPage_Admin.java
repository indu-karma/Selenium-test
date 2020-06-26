package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utils.TestUtil;

public class VendorRegisterPage_Admin extends TestBase{
	
	//https://harry.kredx.com/vendor/register
	
	//
	
	    @FindBy(xpath = "//*[text()='Your Name']/..//input")
	    WebElement nameField;

	    @FindBy(xpath = "//*[text()='Email']/..//input")
	    WebElement emailAddressField;

	    @FindBy(xpath = "//*[text()='Mobile']/..//input")
	    WebElement mobileNumberField;

	    @FindBy(xpath = "//*[text()='Password']/..//input")
	    WebElement passwordField;
	    
	    @FindBy(xpath = "//*[text()='Confirm Password']/..//input")
	    WebElement confirmPasswordField;

	    @FindBy(xpath = "//button[@type='submit']")
	    WebElement submitButton;
	    
	   
	    /*functions of page*/
	    public VendorRegisterPage_Admin(){
	    			
	    			PageFactory.initElements(driver, this);
	    			
	    }
	    
	    public void VendorRegisterDetails() {
	    
	    	String VenName=TestUtil.generateRandomName();
	    	nameField.sendKeys(VenName);
	    	String VendEmail="indu+"+VenName+"@kredx.com";
  	        emailAddressField.sendKeys(VendEmail);
  	        mobileNumberField.sendKeys("9886765251");
            passwordField.sendKeys("Kredxtest");
	   	    confirmPasswordField.sendKeys("Kredxtest");
   	   	    submitButton.click();;
	    	
	    	
	    }
	    

}
